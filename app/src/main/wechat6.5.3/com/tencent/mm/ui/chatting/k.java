package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ui.chatting.ad.a;

final class k extends a {
    protected TextView eTf;
    protected TextView fSs;
    protected ProgressBar ieT;
    protected TextView oks;
    protected ImageView oky;

    public k(int i) {
        super(i);
    }

    public final k cK(View view) {
        super.cM(view);
        this.eTf = (TextView) view.findViewById(2131755342);
        this.ieT = (ProgressBar) view.findViewById(2131756257);
        this.oky = (ImageView) view.findViewById(2131756230);
        this.fSs = (TextView) view.findViewById(2131756174);
        this.oks = (TextView) view.findViewById(2131756107);
        this.iJL = (TextView) view.findViewById(2131755341);
        this.gfb = (CheckBox) view.findViewById(2131755022);
        this.fIV = view.findViewById(2131755026);
        return this;
    }
}
