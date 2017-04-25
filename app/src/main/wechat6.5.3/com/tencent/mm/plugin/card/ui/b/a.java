package com.tencent.mm.plugin.card.ui.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.ui.MMActivity;

public final class a extends f {
    private View eMt;

    public final void NI() {
        this.eMt = findViewById(2131755800);
    }

    public final void update() {
        g abv = this.eMF.abv();
        b abq = this.eMF.abq();
        MMActivity abt = this.eMF.abt();
        com.tencent.mm.plugin.card.ui.d.a abx = this.eMF.abx();
        f aby = this.eMF.aby();
        if (abv.acp()) {
            this.eMt.setVisibility(0);
            findViewById(2131755732).setVisibility(0);
            ImageView imageView = (ImageView) findViewById(2131755733);
            TextView textView = (TextView) findViewById(2131755734);
            TextView textView2 = (TextView) findViewById(2131755735);
            if (abx.eHL != null) {
                ak.yW();
                textView.setText(c.wH().LX(abx.eHL).tT());
            }
            if (abx.exT == 23) {
                if (!TextUtils.isEmpty(abq.Zv().mln)) {
                    textView2.setText(abq.Zv().mln);
                } else if (TextUtils.isEmpty(abq.Zv().eCC)) {
                    textView2.setText(abt.getString(2131231665, new Object[]{aby.getTitle()}));
                } else {
                    textView2.setText(abt.getString(2131231665, new Object[]{abq.Zv().eCC}));
                }
            } else if (abq.Zx() != null && !TextUtils.isEmpty(abq.Zx().mSm)) {
                textView2.setText(abq.Zx().mSm);
            } else if (TextUtils.isEmpty(abq.Zv().eCC)) {
                textView2.setText(abt.getString(2131231628, new Object[]{aby.getTitle()}));
            } else {
                textView2.setText(abt.getString(2131231628, new Object[]{abq.Zv().eCC}));
            }
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, abx.eHL, 0.15f, false);
            imageView.setOnClickListener(this.eMF.abu());
        } else if (!abv.acq()) {
            acF();
        } else if (TextUtils.isEmpty(abq.Zv().mln)) {
            this.eMt.setVisibility(8);
        } else {
            this.eMt.setVisibility(0);
            findViewById(2131755732).setVisibility(8);
            ((TextView) findViewById(2131755735)).setText(abq.Zv().mln);
        }
    }

    public final void acF() {
        this.eMt.setVisibility(8);
    }
}
