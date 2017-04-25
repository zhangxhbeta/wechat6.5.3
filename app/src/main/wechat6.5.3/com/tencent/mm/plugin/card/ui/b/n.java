package com.tencent.mm.plugin.card.ui.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public final class n extends f {
    private b eBg;
    private MMActivity eBk;
    private View eNi;

    public final void NI() {
        this.eBk = this.eMF.abt();
    }

    public final void update() {
        this.eBg = this.eMF.abq();
        if (this.eNi == null) {
            this.eNi = ((ViewStub) findViewById(2131755806)).inflate();
        }
        if (this.eBg.Ze()) {
            this.eNi.setBackgroundDrawable(j.t(this.eBk, this.eBk.getResources().getColor(2131689590)));
        }
        TextView textView = (TextView) this.eNi.findViewById(2131755994);
        if (this.eBg.Zw() == null) {
            v.e("MicroMsg.CardStatusView", "updateState() mCardInfo.getDataInfo() == null");
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setTextColor(this.eBk.getResources().getColor(2131689769));
        if (TextUtils.isEmpty(this.eBg.Zv().mll)) {
            k.b(textView, this.eBg.Zw().status);
        } else {
            textView.setText(this.eBg.Zv().mll);
        }
    }

    public final void acF() {
        if (this.eNi != null) {
            this.eNi.setVisibility(8);
        }
    }
}
