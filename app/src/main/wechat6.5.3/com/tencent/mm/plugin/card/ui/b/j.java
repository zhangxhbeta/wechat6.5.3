package com.tencent.mm.plugin.card.ui.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.d.a;
import com.tencent.mm.ui.MMActivity;

public final class j extends f {
    private View eMQ;
    private ImageView eMR;
    private TextView eMS;
    private TextView eMT;

    public final void NI() {
        this.eMQ = findViewById(2131755799);
        this.eMR = (ImageView) findViewById(2131757137);
        this.eMS = (TextView) findViewById(2131757138);
        this.eMT = (TextView) findViewById(2131757139);
        this.eMQ.setVisibility(8);
    }

    public final void update() {
        b abq = this.eMF.abq();
        MMActivity abt = this.eMF.abt();
        a abx = this.eMF.abx();
        this.eMQ.setVisibility(0);
        TextView textView = this.eMS;
        ak.yW();
        textView.setText(c.wH().LX(abx.eHL).tT());
        if (abq.Zx() != null && !TextUtils.isEmpty(abq.Zx().mSm)) {
            this.eMT.setText(abq.Zx().mSm);
        } else if (TextUtils.isEmpty(abq.Zv().eCC)) {
            this.eMT.setText(abt.getString(2131231628, new Object[]{this.eMF.aby().getTitle()}));
        } else {
            this.eMT.setText(abt.getString(2131231628, new Object[]{abq.Zv().eCC}));
        }
        com.tencent.mm.pluginsdk.ui.a.b.m(this.eMR, abx.eHL);
        this.eMR.setOnClickListener(this.eMF.abu());
    }

    public final void acF() {
        this.eMQ.setVisibility(8);
    }
}
