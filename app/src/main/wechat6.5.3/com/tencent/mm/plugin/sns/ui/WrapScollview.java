package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

public class WrapScollview extends ScrollView {
    View dtW;
    boolean jZY = true;

    public WrapScollview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public WrapScollview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = 1;
        if (this.dtW != null) {
            View view = this.dtW;
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = view.getWidth() + i2;
            int i3 = iArr[1];
            int height = view.getHeight() + i3;
            if (((float) i2) >= rawX || rawX >= ((float) width) || ((float) i3) >= rawY || rawY >= ((float) height)) {
                i = 0;
            }
            if (i != 0) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if (this.jZY) {
            return super.computeScrollDeltaToGetChildRectOnScreen(rect);
        }
        return 0;
    }
}
