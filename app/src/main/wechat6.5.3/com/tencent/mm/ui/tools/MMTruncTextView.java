package com.tencent.mm.ui.tools;

import android.content.Context;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;

public class MMTruncTextView extends TextView {
    private boolean oTN = false;
    private boolean oTO = false;

    public MMTruncTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMTruncTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.oTN) {
            CharSequence text = getText();
            if (text instanceof Spanned) {
                this.oTO = true;
                setText(TextUtils.ellipsize(text, getPaint(), (float) ((getWidth() - getCompoundPaddingRight()) - getCompoundPaddingLeft()), TruncateAt.END));
                this.oTO = false;
            }
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        this.oTN = !this.oTO;
    }
}
