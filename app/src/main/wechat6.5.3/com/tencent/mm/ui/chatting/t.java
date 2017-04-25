package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ui.chatting.ad.a;
import com.tencent.mm.ui.widget.MMTextView;

final class t extends a {
    View fDt;
    ImageView okm;
    MMTextView olH;
    ChattingTranslateView olI;

    public t(int i) {
        super(i);
    }

    public final a o(View view, boolean z) {
        super.cM(view);
        this.eTg = (TextView) view.findViewById(2131755027);
        this.iJL = (TextView) view.findViewById(2131755341);
        this.olH = (MMTextView) view.findViewById(2131755342);
        this.gfb = (CheckBox) view.findViewById(2131755022);
        this.fIV = view.findViewById(2131755026);
        this.fDt = view.findViewById(2131755023);
        this.olI = (ChattingTranslateView) view.findViewById(2131756143);
        if (z) {
            this.type = 2;
        } else {
            this.okm = (ImageView) view.findViewById(2131756258);
            this.oky = (ImageView) view.findViewById(2131756230);
            this.ieT = (ProgressBar) view.findViewById(2131756257);
            this.type = 4;
        }
        return this;
    }
}
