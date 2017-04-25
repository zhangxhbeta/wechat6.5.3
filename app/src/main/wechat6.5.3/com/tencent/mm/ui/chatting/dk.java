package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ui.chatting.ad.a;

final class dk extends a {
    ProgressBar ieT;
    ImageView okl;
    ImageView okm;
    TextView oks;
    TextView oxL;
    ImageView oxM;
    View oxN;

    public dk(int i) {
        super(i);
    }

    public final a o(View view, boolean z) {
        super.cM(view);
        this.eTg = (TextView) view.findViewById(2131755027);
        this.okl = (ImageView) view.findViewById(2131756186);
        this.gfb = (CheckBox) view.findViewById(2131755022);
        this.fIV = view.findViewById(2131755026);
        this.oxN = view.findViewById(2131756218);
        if (z) {
            this.iJL = (TextView) view.findViewById(2131755341);
            this.ieT = (ProgressBar) view.findViewById(2131756219);
            this.type = 1;
        } else {
            this.ieT = (ProgressBar) view.findViewById(2131756257);
            this.oxL = (TextView) view.findViewById(2131756266);
            this.iJL = (TextView) view.findViewById(2131755341);
            this.type = 3;
            this.okm = (ImageView) view.findViewById(2131756258);
        }
        this.oks = (TextView) view.findViewById(2131756107);
        this.oxM = (ImageView) view.findViewById(2131756176);
        return this;
    }
}
