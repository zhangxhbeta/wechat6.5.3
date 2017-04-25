package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.c;

final class AppBrandSmileyPanel extends WebViewSmileyPanel {
    private int dYg = 0;
    int dYh = -1;
    private boolean dYi = false;
    private boolean oQ = false;

    public AppBrandSmileyPanel(Context context) {
        super(context);
    }

    public AppBrandSmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final c Td() {
        return new h();
    }

    protected final void onMeasure(int i, int i2) {
        if (isShown()) {
            int min;
            int[] ahP;
            if (!j.aF(getContext())) {
                ahP = c.ahP();
                min = (Math.min(ahP[0], ahP[1]) / 2) - getContext().getResources().getDimensionPixelSize(2131492990);
            } else if (this.dYh > 0) {
                min = this.dYh;
            } else if (this.dYg > 0) {
                min = this.dYg;
            } else {
                ahP = c.ahP();
                min = (Math.max(ahP[0], ahP[1]) / 2) - getContext().getResources().getDimensionPixelSize(2131492990);
                this.dYg = min;
            }
            bi(i, MeasureSpec.makeMeasureSpec(min, 1073741824));
            return;
        }
        bi(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
    }

    public final void setVisibility(int i) {
        to(i);
        if (i == 0) {
            NI();
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.oQ = true;
        super.onLayout(z, i, i2, i3, i4);
        this.oQ = false;
    }

    final boolean Te() {
        if (d.dW(18)) {
            return super.isInLayout();
        }
        return this.oQ;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.dYi = true;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dYi = false;
    }

    final boolean Tf() {
        if (d.dW(19)) {
            return super.isAttachedToWindow();
        }
        return this.dYi;
    }
}
