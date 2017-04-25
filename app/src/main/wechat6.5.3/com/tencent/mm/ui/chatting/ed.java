package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.chatting.ad.a;
import com.tencent.mm.ui.widget.MMTextView;

final class ed extends a {
    View fDt;
    ImageView okm;
    MMTextView olH;
    ChattingTranslateView olI;
    private int pSb = com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 232);
    private int pSc = com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 264);
    private int pSd = 320;

    public ed(int i) {
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
        Context context = aa.getContext();
        float ds = com.tencent.mm.bd.a.ds(context);
        this.pSd = (int) (((float) this.pSd) / ds);
        if (ds == 0.875f) {
            this.pSb = com.tencent.mm.bd.a.fromDPToPix(context, 233);
            this.pSc = com.tencent.mm.bd.a.fromDPToPix(context, 261);
        } else if (ds == 1.125f) {
            this.pSb = com.tencent.mm.bd.a.fromDPToPix(context, 239);
            this.pSc = com.tencent.mm.bd.a.fromDPToPix(context, 257);
        } else if (ds == 1.25f) {
            this.pSb = com.tencent.mm.bd.a.fromDPToPix(context, 244);
            this.pSc = com.tencent.mm.bd.a.fromDPToPix(context, 264);
        } else if (ds == 1.375f) {
            this.pSb = com.tencent.mm.bd.a.fromDPToPix(context, 243);
            this.pSc = com.tencent.mm.bd.a.fromDPToPix(context, 266);
        }
        return this;
    }

    public final void d(TextView textView, String str) {
        if (str.toString().length() > this.pSd) {
            textView.setMaxWidth(this.pSc);
        } else {
            textView.setMaxWidth(this.pSb);
        }
    }
}
