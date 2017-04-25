package com.tencent.mm.plugin.card.ui.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.ld;

public final class k extends f {
    private View eMU;

    public final void NI() {
    }

    public final void update() {
        if (this.eMU == null) {
            this.eMU = ((ViewStub) findViewById(2131755811)).inflate();
        }
        b abq = this.eMF.abq();
        Context abt = this.eMF.abt();
        ld ldVar = abq.Zw().mkv;
        if (this.eMU != null) {
            TextView textView = (TextView) this.eMU.findViewById(2131755936);
            textView.setText(ldVar.title);
            textView.setTextColor(j.qv(abq.Zv().coN));
            TextView textView2 = (TextView) this.eMU.findViewById(2131755937);
            LinearLayout linearLayout = (LinearLayout) this.eMU.findViewById(2131755935);
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            if (abq.Zc()) {
                LayoutParams layoutParams2 = (LayoutParams) textView.getLayoutParams();
                if (TextUtils.isEmpty(ldVar.eBO)) {
                    textView2.setVisibility(8);
                    layoutParams.height = abt.getResources().getDimensionPixelOffset(2131493364);
                } else {
                    textView2.setText(ldVar.eBO);
                    textView2.setVisibility(0);
                    layoutParams.height = abt.getResources().getDimensionPixelOffset(2131493363);
                    layoutParams2.bottomMargin = abt.getResources().getDimensionPixelSize(2131492962);
                    LayoutParams layoutParams3 = (LayoutParams) textView2.getLayoutParams();
                    layoutParams3.topMargin = abt.getResources().getDimensionPixelSize(2131492962);
                    textView2.setLayoutParams(layoutParams3);
                    textView2.invalidate();
                }
                layoutParams2.height = abt.getResources().getDimensionPixelSize(2131493365);
                textView.setLayoutParams(layoutParams2);
                textView.invalidate();
                textView.setBackgroundDrawable(j.c(abt, abq.Zv().coN, abt.getResources().getDimensionPixelSize(2131493367)));
                textView.setTextColor(j.N(abt, abq.Zv().coN));
                linearLayout.setBackgroundDrawable(null);
                textView.setOnClickListener(this.eMF.abu());
            } else {
                if (TextUtils.isEmpty(ldVar.eBO)) {
                    textView2.setVisibility(8);
                    layoutParams.height = abt.getResources().getDimensionPixelOffset(2131493376);
                } else {
                    textView2.setText(ldVar.eBO);
                    textView2.setVisibility(0);
                    layoutParams.height = abt.getResources().getDimensionPixelOffset(2131493375);
                }
                linearLayout.setOnClickListener(this.eMF.abu());
            }
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.invalidate();
            this.eMU.invalidate();
            if (abq.Zc()) {
                linearLayout.getLayoutParams();
            }
        }
    }

    public final void acF() {
        if (this.eMU != null) {
            this.eMU.setVisibility(8);
        }
    }
}
