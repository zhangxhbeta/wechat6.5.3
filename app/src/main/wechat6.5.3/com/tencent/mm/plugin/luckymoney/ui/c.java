package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.c.h;
import com.tencent.mm.plugin.luckymoney.c.n;
import com.tencent.mm.wallet_core.ui.e;

public final class c extends d {
    private Context mContext;

    class a {
        ImageView heZ;
        TextView hea;
        TextView hfA;
        final /* synthetic */ c hfB;
        TextView hfz;

        a(c cVar) {
            this.hfB = cVar;
        }
    }

    public c(Context context) {
        super(context);
        this.mContext = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.CE.inflate(2130903893, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.hfz = (TextView) view.findViewById(2131757863);
            aVar2.hfA = (TextView) view.findViewById(2131757865);
            aVar2.hea = (TextView) view.findViewById(2131757866);
            aVar2.heZ = (ImageView) view.findViewById(2131757864);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        h mF = mF(i);
        n.a(this.mContext, aVar.hfz, mF.hbg);
        aVar.hfA.setText(mF.hbi);
        aVar.hea.setText(this.mContext.getString(2131233647, new Object[]{e.m(((double) mF.hbh) / 100.0d)}));
        if (mF.hau == 1) {
            aVar.heZ.setVisibility(0);
        } else {
            aVar.heZ.setVisibility(8);
        }
        return view;
    }
}
