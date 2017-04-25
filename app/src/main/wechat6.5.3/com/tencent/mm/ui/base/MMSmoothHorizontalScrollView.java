package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;

public class MMSmoothHorizontalScrollView extends HorizontalScrollView {
    private Interpolator eV = new DecelerateInterpolator();
    private Rect fu = new Rect();
    private TranslateAnimation ijx;
    private View nXX;
    private float xW;

    public MMSmoothHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFadingEdgeLength(0);
    }

    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            this.nXX = getChildAt(0);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 1;
        int i2 = 0;
        if (this.nXX == null) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.xW = motionEvent.getX();
                break;
            case 1:
            case 3:
                this.xW = 0.0f;
                if (this.fu.isEmpty()) {
                    i = 0;
                }
                if (i != 0) {
                    this.ijx = new TranslateAnimation((float) this.nXX.getLeft(), (float) this.fu.left, 0.0f, 0.0f);
                    this.ijx.setInterpolator(this.eV);
                    this.ijx.setDuration((long) Math.abs(this.nXX.getLeft() - this.fu.left));
                    this.nXX.startAnimation(this.ijx);
                    this.nXX.layout(this.fu.left, this.fu.top, this.fu.right, this.fu.bottom);
                    this.fu.setEmpty();
                    break;
                }
                break;
            case 2:
                float x = motionEvent.getX();
                if (this.xW == 0.0f) {
                    this.xW = x;
                }
                int i3 = ((int) (this.xW - x)) / 2;
                scrollBy(i3, 0);
                this.xW = x;
                int measuredWidth = this.nXX.getMeasuredWidth() - ((getWidth() - getPaddingLeft()) - getPaddingRight());
                int scrollX = getScrollX();
                if (scrollX == 0 || scrollX == measuredWidth) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    if (this.fu.isEmpty()) {
                        this.fu.set(this.nXX.getLeft(), this.nXX.getTop(), this.nXX.getRight(), this.nXX.getBottom());
                    }
                    this.nXX.layout(this.nXX.getLeft() - i3, this.nXX.getTop(), this.nXX.getRight() - i3, this.nXX.getBottom());
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
