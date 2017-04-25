package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ui.chatting.ad.a;

final class j extends a {
    public ImageView okv;
    public TextView okw;
    public TextView okx;

    public j(int i) {
        super(i);
    }

    public final j cJ(View view) {
        super.cM(view);
        this.eTg = (TextView) this.kad.findViewById(2131755027);
        this.gfb = (CheckBox) this.kad.findViewById(2131755022);
        this.fIV = this.kad.findViewById(2131755026);
        this.iJL = (TextView) this.kad.findViewById(2131755341);
        this.okv = (ImageView) this.kad.findViewById(2131756191);
        this.okw = (TextView) this.kad.findViewById(2131756192);
        this.okx = (TextView) this.kad.findViewById(2131756193);
        return this;
    }
}
