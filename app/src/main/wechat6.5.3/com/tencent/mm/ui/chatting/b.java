package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.ae.a.a.c.a;
import com.tencent.mm.ae.n;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

final class b extends BaseAdapter {
    private Context context;
    private c fzb;
    private List<db> ojV;
    boolean ojW = false;

    public final /* synthetic */ Object getItem(int i) {
        return wU(i);
    }

    public b(Context context) {
        this.context = context;
        this.ojV = new ArrayList();
        a aVar = new a();
        aVar.cPH = 2130838737;
        this.fzb = aVar.GU();
        an(null);
    }

    public final void an(List<db> list) {
        List list2;
        db dbVar;
        this.ojV.clear();
        if (!(list == null || list.size() == 0)) {
            this.ojV.addAll(list);
        }
        if (this.ojW) {
            list2 = this.ojV;
            dbVar = new db();
            dbVar.kCd = 2130839093;
            dbVar.caJ = this.context.getString(2131231898);
            list2.add(dbVar);
        }
        list2 = this.ojV;
        dbVar = new db();
        dbVar.kCd = 2130839092;
        dbVar.caJ = this.context.getString(2131235169);
        list2.add(dbVar);
        v.d("MicroMsg.AppInfoListAdapter", "updateData mDeviceInfoList.size() = %d.", Integer.valueOf(this.ojV.size()));
    }

    public final int getCount() {
        return this.ojV.size();
    }

    private db wU(int i) {
        return (db) this.ojV.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        eh ehVar;
        db wU = wU(i);
        if (view == null) {
            eh ehVar2 = new eh();
            view = View.inflate(viewGroup.getContext(), 2130904343, null);
            ehVar2.fCf = view.findViewById(2131755326);
            ehVar2.eVA = (TextView) view.findViewById(2131756776);
            ehVar2.eZn = (ImageView) view.findViewById(2131756775);
            ehVar2.osx = (TextView) view.findViewById(2131759058);
            ehVar2.ozp = (SendDataToDeviceProgressBar) view.findViewById(2131759057);
            ehVar2.ozp.setVisibility(4);
            view.setTag(ehVar2);
            ehVar = ehVar2;
        } else {
            ehVar = (eh) view.getTag();
        }
        ehVar.eVA.setText(wU.caJ);
        v.v("MicroMsg.AppInfoListAdapter", "position(%s), name(%s).", Integer.valueOf(i), wU.caJ);
        if (wU.kCd != 0) {
            ehVar.eZn.setImageResource(wU.kCd);
        } else {
            Bitmap b = g.b(wU.appId, 1, com.tencent.mm.bd.a.getDensity(this.context));
            if (b == null || b.isRecycled()) {
                n.GL().a(wU.iconUrl, ehVar.eZn, this.fzb);
            } else {
                ehVar.eZn.setImageBitmap(b);
            }
        }
        ehVar.fCf.setTag(Integer.valueOf(i));
        return view;
    }
}
