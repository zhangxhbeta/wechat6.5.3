package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.v;

public class MMAutoSizeTextView extends TextView {
    private float gAc;
    private float nUr;
    private float nUs;
    private Paint ns;

    public MMAutoSizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public MMAutoSizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setSingleLine();
        setEllipsize(TruncateAt.END);
        this.nUr = (float) a.fromDPToPix(getContext(), 8);
        this.nUs = (float) a.fromDPToPix(getContext(), 22);
        this.ns = new Paint();
        this.ns.set(getPaint());
        bBP();
    }

    private void cb(String str, int i) {
        v.i("MicroMsg.MMAutoSizeTextView", "autoAdjustTextSize[text=%s, viewWidth=%d]", new Object[]{str, Integer.valueOf(i)});
        if (i > 0) {
            int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
            bBP();
            float f = this.gAc;
            this.ns.setTextSize(f);
            while (f > this.nUr && this.ns.measureText(str) > ((float) paddingLeft)) {
                f -= 1.0f;
                if (f <= this.nUr) {
                    f = this.nUr;
                    break;
                }
                this.ns.setTextSize(f);
            }
            v.i("MicroMsg.MMAutoSizeTextView", "try size[%f], maxSize[%f], measureTextSize[%f], availableWidth[%d]", new Object[]{Float.valueOf(f), Float.valueOf(this.gAc), Float.valueOf(this.ns.measureText(str)), Integer.valueOf(paddingLeft)});
            setTextSize(0, f);
        }
    }

    private void bBP() {
        this.gAc = getTextSize();
        if (this.gAc <= this.nUr) {
            this.gAc = this.nUs;
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        v.w("MicroMsg.MMAutoSizeTextView", "on text changed");
        super.onTextChanged(charSequence, i, i2, i3);
        cb(charSequence.toString(), getWidth());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        v.w("MicroMsg.MMAutoSizeTextView", "on size changed");
        if (i != i3) {
            cb(getText().toString(), i);
        }
    }
}
