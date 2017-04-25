package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class e extends BaseAdapter {
    String apU = "";
    byte[] buffer = null;
    private Context context = null;
    boolean eDI = false;
    private List<f> gYH = new ArrayList();
    int gYI = 0;
    boolean gYJ = false;
    boolean gYv = false;

    static class a {
        TextView gYK;
        ImageView gYL;
        View gYM;
        View gYN;
        TextView gYO;
        TextView titleView;
    }

    public final /* synthetic */ Object getItem(int i) {
        return mv(i);
    }

    public e(Context context) {
        this.context = context;
    }

    public final void clean() {
        this.buffer = null;
        this.eDI = false;
        this.apU = "";
        this.gYH.clear();
    }

    public final void vV(String str) {
        clean();
        this.apU = str;
        v.i("MicroMsg.PoiAdapter", "initdata key %s", new Object[]{str});
    }

    public final void b(f fVar) {
        if (this.gYH.size() >= 0) {
            this.gYH.add(0, fVar);
            notifyDataSetChanged();
        }
    }

    public final void a(List<f> list, byte[] bArr, boolean z, String str) {
        if (this.apU == null || !this.apU.equals(str)) {
            v.i("MicroMsg.PoiAdapter", "old key come pass it %s %s", new Object[]{this.apU, str});
            return;
        }
        for (f add : list) {
            this.gYH.add(add);
        }
        this.buffer = bArr;
        this.eDI = z;
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.gYH.size();
    }

    public final f mv(int i) {
        return (f) this.gYH.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(2130904166, null);
            aVar = new a();
            aVar.titleView = (TextView) view.findViewById(2131755226);
            aVar.gYK = (TextView) view.findViewById(2131755719);
            aVar.gYL = (ImageView) view.findViewById(2131758573);
            aVar.gYN = view.findViewById(2131758575);
            aVar.gYM = view.findViewById(2131758574);
            aVar.gYO = (TextView) view.findViewById(2131758576);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (((f) this.gYH.get(i)).type == 1 || ((f) this.gYH.get(i)).type == 2) {
            aVar.gYN.setVisibility(0);
            aVar.gYM.setVisibility(8);
            aVar.gYO.setText(be.ah(((f) this.gYH.get(i)).gYP, ""));
        } else {
            aVar.gYN.setVisibility(8);
            aVar.gYM.setVisibility(0);
        }
        if (i != 0 || this.gYJ) {
            aVar.titleView.setText(be.ah(((f) this.gYH.get(i)).mName, ""));
            aVar.gYK.setVisibility(0);
            aVar.gYK.setText(be.ah(((f) this.gYH.get(i)).gYP, ""));
        } else if (this.gYv) {
            aVar.titleView.setText(be.ah(((f) this.gYH.get(0)).mName, ""));
            aVar.gYK.setVisibility(0);
            aVar.gYK.setText(be.ah(((f) this.gYH.get(0)).gYP, ""));
        } else {
            aVar.gYK.setVisibility(8);
            if (!be.kS(((f) this.gYH.get(0)).gYP)) {
                aVar.titleView.setText(be.ah(((f) this.gYH.get(i)).gYP, ""));
            } else if (be.kS(((f) this.gYH.get(0)).gYY)) {
                aVar.titleView.setText(be.ah(((f) this.gYH.get(i)).mName, ""));
            } else {
                aVar.titleView.setText(be.ah(((f) this.gYH.get(i)).gYY, ""));
            }
        }
        if (i == this.gYI) {
            aVar.gYL.setVisibility(0);
        } else {
            aVar.gYL.setVisibility(4);
        }
        return view;
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Thread.currentThread().getId();
        Looper.getMainLooper().getThread().getId();
        v.i("MicroMsg.PoiAdapter", "map notifyDataChange " + be.bur().toString() + " threadId : " + Thread.currentThread().getId());
    }
}
