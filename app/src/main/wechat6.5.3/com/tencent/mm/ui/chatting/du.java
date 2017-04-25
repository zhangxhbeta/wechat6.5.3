package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.ui.chatting.ad.a;

final class du extends a {
    TextView fSs;
    TextView lts;

    public du(int i) {
        super(i);
    }

    public final a cS(View view) {
        super.cM(view);
        this.eTg = (TextView) view.findViewById(2131755027);
        this.iJL = (TextView) view.findViewById(2131755341);
        this.lts = (TextView) view.findViewById(2131755342);
        this.fSs = (TextView) view.findViewById(2131756256);
        this.gfb = (CheckBox) view.findViewById(2131755022);
        this.fIV = view.findViewById(2131755026);
        this.type = 2;
        return this;
    }
}
