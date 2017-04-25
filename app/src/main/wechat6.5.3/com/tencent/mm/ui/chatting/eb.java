package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.ui.chatting.ad.a;

final class eb extends a {
    TextView dtZ;

    public eb(int i) {
        super(i);
    }

    public final a cU(View view) {
        super.cM(view);
        this.eTg = (TextView) view.findViewById(2131755027);
        this.iJL = (TextView) view.findViewById(2131755341);
        this.dtZ = (TextView) view.findViewById(2131755342);
        this.gfb = (CheckBox) view.findViewById(2131755022);
        this.fIV = view.findViewById(2131755026);
        this.type = 2;
        return this;
    }
}
