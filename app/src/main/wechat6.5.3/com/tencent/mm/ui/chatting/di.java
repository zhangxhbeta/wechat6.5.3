package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ui.chatting.ad.a;

final class di extends a {
    TextView iLR;
    TextView lts;
    TextView olK;
    View oxE;
    ImageView oxF;
    ImageView oxG;
    TextView oxH;
    TextView oxI;

    public di(int i) {
        super(i);
    }

    public final a cS(View view) {
        super.cM(view);
        this.eTg = (TextView) view.findViewById(2131755027);
        this.olK = (TextView) view.findViewById(2131756197);
        this.iLR = (TextView) view.findViewById(2131756196);
        this.lts = (TextView) view.findViewById(2131755342);
        this.onC = view.findViewById(2131756148);
        this.oxI = (TextView) view.findViewById(2131756203);
        this.oxE = view.findViewById(2131756204);
        this.oxF = (ImageView) view.findViewById(2131756205);
        this.oxG = (ImageView) view.findViewById(2131756207);
        this.oxH = (TextView) view.findViewById(2131756206);
        this.gfb = (CheckBox) view.findViewById(2131755022);
        this.fIV = view.findViewById(2131755026);
        this.type = 9;
        return this;
    }
}
