package com.tencent.mm.plugin.card.ui.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;

public final class d extends f {
    private TextView eFF;
    private View eMB;
    private TextView eMC;
    private TextView eMD;

    public final void NI() {
        this.eMB = findViewById(2131755821);
        this.eMC = (TextView) findViewById(2131755822);
        this.eFF = (TextView) findViewById(2131755826);
        this.eMD = (TextView) findViewById(2131755730);
        this.eMC.setOnClickListener(this.eMF.abu());
        this.eMB.setVisibility(8);
    }

    public final void update() {
        b abq = this.eMF.abq();
        Context abt = this.eMF.abt();
        this.eMB.setVisibility(0);
        if (TextUtils.isEmpty(abq.Zv().mkY)) {
            this.eMC.setVisibility(8);
        } else {
            this.eMC.setVisibility(0);
            this.eMC.setText(abq.Zv().mkY);
            if (abq.Zb() || (abq.Za() && abq.Zd())) {
                this.eMC.setTextColor(abt.getResources().getColor(2131690127));
            } else if (abq.Za() && abq.Zc()) {
                this.eMC.setTextColor(abt.getResources().getColor(2131689587));
                this.eMB.setBackgroundColor(abt.getResources().getColor(2131689900));
            } else {
                this.eMC.setTextColor(abt.getResources().getColor(2131690127));
            }
        }
        View findViewById = this.eMB.findViewById(2131755823);
        if (this.eMF.abv().acC()) {
            findViewById.setVisibility(0);
            this.eMD.setText(abt.getString(2131231683));
            this.eMD.setTextColor(abt.getResources().getColor(2131690127));
            int dimensionPixelOffset = abt.getResources().getDimensionPixelOffset(2131493168);
            Button button = (Button) this.eMB.findViewById(2131755731);
            Drawable c = j.c(abt, abt.getResources().getColor(2131690127), dimensionPixelOffset);
            Drawable bs = j.bs(abt.getResources().getColor(2131690127), dimensionPixelOffset);
            Drawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, bs);
            stateListDrawable.addState(new int[0], c);
            button.setBackgroundDrawable(stateListDrawable);
            int[] iArr = new int[]{j.qv(abq.Zv().coN), abt.getResources().getColor(2131690127)};
            button.setTextColor(new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, iArr));
            button.setOnClickListener(this.eMF.abu());
            findViewById = this.eMB.findViewById(2131755824);
            View findViewById2 = this.eMB.findViewById(2131755825);
            if (abq.Zv().mlm == 1) {
                findViewById.setVisibility(0);
                findViewById2.setVisibility(0);
                return;
            }
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            return;
        }
        findViewById.setVisibility(8);
    }

    public final void acF() {
        this.eMB.setVisibility(8);
    }

    public final void qk(String str) {
        this.eMD.setText(str);
    }
}
