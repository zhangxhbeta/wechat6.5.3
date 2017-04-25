package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.bi.a.b;
import com.tencent.mm.bi.a.g;

public class MMAutoAdjustTextView extends TextView {
    private float cmK;
    private float neH;
    private Paint ns;
    private float pbF;
    private boolean pbG = true;

    public MMAutoAdjustTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context.obtainStyledAttributes(attributeSet, g.aPm));
        init();
    }

    public MMAutoAdjustTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context.obtainStyledAttributes(attributeSet, g.aPm));
        init();
    }

    private void init() {
        this.pbF = (float) a.N(getContext(), b.peS);
        this.cmK = getTextSize();
        this.neH = a.ds(getContext());
        this.ns = new Paint();
        this.ns.set(getPaint());
    }

    private void b(TypedArray typedArray) {
        if (typedArray != null) {
            this.pbG = typedArray.getBoolean(g.pfJ, true);
            typedArray.recycle();
        }
    }

    private void yv(int i) {
        if (i > 0) {
            measure(0, 0);
            float measuredWidth = (float) getMeasuredWidth();
            while (measuredWidth > ((float) i)) {
                this.cmK -= a.getDensity(getContext());
                setTextSize(0, this.cmK * this.neH);
                measure(0, 0);
                measuredWidth = (float) getMeasuredWidth();
            }
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        charSequence.toString();
        yv(getWidth());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            getText().toString();
            yv(i);
        }
    }
}
