package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.j;
import java.util.ArrayList;
import java.util.Iterator;

public final class a extends j {
    private int gTx = 8;
    private ArrayList<String> gTy = new ArrayList();

    class a {
        ImageView cHH;
        final /* synthetic */ a gTA;
        TextView gTz;

        a(a aVar) {
            this.gTA = aVar;
        }
    }

    public final void F(ArrayList<String> arrayList) {
        boolean z;
        this.gTy.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.gTy.add((String) it.next());
        }
        String str = "MicroMsg.MMGridPaperAdapter";
        String str2 = "notifyDataSetChange, notifier is null ? %B";
        Object[] objArr = new Object[1];
        if (this.nVM == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        v.i(str, str2, objArr);
        if (this.nVM != null) {
            this.nVM.bCe();
        }
    }

    public final int getCount() {
        return this.gTy.size();
    }

    public final View c(int i, View view) {
        a aVar = new a(this);
        if (view == null) {
            view = View.inflate(aa.getContext(), 2130903143, null);
            aVar.cHH = (ImageView) view.findViewById(2131755498);
            aVar.gTz = (TextView) view.findViewById(2131755499);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        String str = (String) this.gTy.get(i);
        b.m(aVar.cHH, str);
        CharSequence er = l.er(str);
        if (er.length() > this.gTx) {
            er = er.subSequence(0, this.gTx + 1) + "...";
        }
        aVar.gTz.setText(er);
        return view;
    }

    public final Object getItem(int i) {
        return this.gTy.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
