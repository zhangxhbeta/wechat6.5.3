package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bd.a;

public class MMImageButton extends FrameLayout {
    private ImageView bgv;
    private TextView hRT;

    public MMImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.bgv = new ImageView(context);
        this.bgv.setLayoutParams(layoutParams);
        addView(this.bgv);
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.hRT = new TextView(context);
        this.hRT.setLayoutParams(layoutParams);
        this.hRT.setClickable(false);
        this.hRT.setFocusable(false);
        this.hRT.setFocusableInTouchMode(false);
        this.hRT.setTextColor(a.M(context, 2131690169));
        addView(this.hRT);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.hRT.setEnabled(z);
        this.bgv.setEnabled(z);
    }
}
