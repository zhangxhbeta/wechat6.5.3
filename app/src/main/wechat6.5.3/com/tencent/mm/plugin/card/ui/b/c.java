package com.tencent.mm.plugin.card.ui.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.plugin.card.base.b;

public final class c extends f {
    private TextView eMA;
    private View eMz;

    public final void NI() {
    }

    public final void update() {
        if (this.eMz == null) {
            this.eMz = ((ViewStub) findViewById(2131755804)).inflate();
            this.eMA = (TextView) this.eMz.findViewById(2131755739);
        }
        this.eMz.setVisibility(0);
        this.eMz.setOnClickListener(this.eMF.abu());
        b abq = this.eMF.abq();
        if (TextUtils.isEmpty(abq.Zv().mlf.mpc)) {
            this.eMA.setText(getString(2131231651));
        } else {
            this.eMA.setText(abq.Zv().mlf.mpc);
        }
    }

    public final void acF() {
        if (this.eMz != null) {
            this.eMz.setVisibility(8);
        }
    }
}
