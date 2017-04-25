package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class MMFrameLayout extends FrameLayout {
    private boolean nVk = false;

    public MMFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        while (!this.nVk && i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.gravity == -1) {
                    layoutParams.gravity = 51;
                    childAt.setLayoutParams(layoutParams);
                }
            }
            i5++;
        }
        this.nVk = true;
        super.onLayout(z, i, i2, i3, i4);
    }
}
