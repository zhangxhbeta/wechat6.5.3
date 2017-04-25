package com.tencent.mm.ui.account;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ResizeLayout extends LinearLayout {
    a nMr = null;

    public interface a {
        void dd(int i, int i2);
    }

    public ResizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.nMr != null) {
            this.nMr.dd(i2, i4);
        }
        super.onSizeChanged(i, i2, i3, i4);
    }
}
