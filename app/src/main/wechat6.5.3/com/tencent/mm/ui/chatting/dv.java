package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ui.chatting.ad.a;

final class dv extends a {
    protected TextView dtZ;
    protected ImageView oyN;

    public dv(int i) {
        super(i);
    }

    public final dv cT(View view) {
        super.cM(view);
        this.dtZ = (TextView) view.findViewById(2131756166);
        this.oyN = (ImageView) view.findViewById(2131756168);
        this.gfb = (CheckBox) view.findViewById(2131755022);
        this.fIV = view.findViewById(2131755026);
        return this;
    }
}
