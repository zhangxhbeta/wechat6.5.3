package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.ui.chatting.ad.a;

final class dg extends a {
    ProgressBar ieT;
    RTChattingEmojiView okk;
    ImageView okl;
    ImageView okm;
    ViewStub oxD;

    public dg(int i) {
        super(i);
    }

    public final a o(View view, boolean z) {
        super.cM(view);
        this.eTg = (TextView) view.findViewById(2131755027);
        this.okk = (RTChattingEmojiView) view.findViewById(2131756186);
        this.gfb = (CheckBox) view.findViewById(2131755022);
        this.fIV = view.findViewById(2131755026);
        if (z) {
            this.iJL = (TextView) view.findViewById(2131755341);
            this.type = 14;
        } else {
            this.ieT = (ProgressBar) view.findViewById(2131756257);
            this.iJL = (TextView) view.findViewById(2131755341);
            this.oky = (ImageView) view.findViewById(2131756230);
            this.type = 15;
            this.okm = (ImageView) view.findViewById(2131756258);
        }
        if (this.okl != null) {
            ((ViewGroup) this.okl.getParent()).setBackgroundDrawable(null);
        }
        this.oxD = (ViewStub) view.findViewById(2131756263);
        return this;
    }
}
