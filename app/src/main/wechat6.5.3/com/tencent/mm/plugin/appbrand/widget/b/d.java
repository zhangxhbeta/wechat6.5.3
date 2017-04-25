package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.tencent.mm.bd.a;

public final class d extends NumberPicker implements g {
    private int OT;
    public String[] dZq;
    private int dZr;
    private int iN;

    public d(Context context) {
        super(new ContextThemeWrapper(context, 2131559156));
        h.a(this, getResources().getDrawable(2130839544));
        h.a(this);
        this.OT = a.fromDPToPix(context, 100);
        this.dZr = a.fromDPToPix(context, 20);
    }

    protected final void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) == Integer.MIN_VALUE || MeasureSpec.getMode(i) == 1073741824) {
            this.iN = MeasureSpec.getSize(i);
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(0, 0), i2);
        if (getMeasuredWidth() > this.OT || (this.iN > 0 && this.OT > this.iN)) {
            int measuredWidth = getMeasuredWidth() + (this.dZr * 2);
            if (this.iN > 0 && this.iN <= measuredWidth) {
                measuredWidth = this.iN;
            }
            setMeasuredDimension(measuredWidth, getMeasuredHeight());
            return;
        }
        setMeasuredDimension(this.OT, getMeasuredHeight());
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.b(this);
    }

    public final String To() {
        return (this.dZq == null || this.dZq.length <= 0) ? "" : this.dZq[getValue()];
    }

    public final View getView() {
        return this;
    }

    public final void aEU() {
    }
}
