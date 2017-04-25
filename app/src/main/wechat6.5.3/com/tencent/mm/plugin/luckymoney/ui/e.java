package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.c.h;

public final class e extends d {
    private Context mContext = null;

    class a {
        TextView eXB;
        TextView gNg;
        TextView hea;
        TextView hfA;
        final /* synthetic */ e hfR;
        int vI;

        a(e eVar) {
            this.hfR = eVar;
        }
    }

    public e(Context context) {
        super(context);
        this.mContext = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.CE.inflate(2130903895, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.eXB = (TextView) view.findViewById(2131757869);
            aVar2.gNg = (TextView) view.findViewById(2131757872);
            aVar2.hfA = (TextView) view.findViewById(2131757870);
            aVar2.hea = (TextView) view.findViewById(2131757871);
            aVar2.vI = i;
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        h mF = mF(i);
        aVar.eXB.setText(mF.hbj);
        aVar.hfA.setText(mF.hbk);
        aVar.hea.setText(this.mContext.getString(2131233602, new Object[]{com.tencent.mm.wallet_core.ui.e.m(((double) mF.haH) / 100.0d)}));
        CharSequence string = this.mContext.getString(2131233661, new Object[]{Long.valueOf(mF.haE), Long.valueOf(mF.hbl)});
        if (mF.status == 5) {
            string = this.mContext.getString(2131233662) + " " + string;
        }
        aVar.gNg.setText(string);
        return view;
    }
}
