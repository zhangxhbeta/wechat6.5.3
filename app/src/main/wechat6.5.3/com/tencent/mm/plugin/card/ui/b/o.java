package com.tencent.mm.plugin.card.ui.b;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.protocal.c.ld;

public final class o extends f {
    private View eNj;

    public final void NI() {
    }

    public final void update() {
        if (this.eNj == null) {
            this.eNj = ((ViewStub) findViewById(2131755818)).inflate();
        }
        ld ldVar = this.eMF.abq().Zw().mks;
        if (this.eNj != null) {
            ((TextView) this.eNj.findViewById(2131755996)).setText(ldVar.title);
            ((TextView) this.eNj.findViewById(2131755997)).setText(ldVar.eBN);
            int i = (this.eMF.abv().abY() && this.eMF.abv().abZ()) ? 0 : 1;
            if (i != 0) {
                ((LayoutParams) ((LinearLayout) this.eNj).getLayoutParams()).bottomMargin = 0;
            } else {
                ((LayoutParams) ((LinearLayout) this.eNj).getLayoutParams()).bottomMargin = this.eMF.abt().getResources().getDimensionPixelSize(2131493190);
            }
        }
    }

    public final void acF() {
        if (this.eNj != null) {
            this.eNj.setVisibility(8);
        }
    }
}
