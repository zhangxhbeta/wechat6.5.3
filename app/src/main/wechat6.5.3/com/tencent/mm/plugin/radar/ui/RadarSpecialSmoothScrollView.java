package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

class RadarSpecialSmoothScrollView extends ScrollView {
    private Rect fu = new Rect();
    private RadarSpecialTableLayout ijw;
    private TranslateAnimation ijx;
    private a ijy = new a();
    private float xX;

    private static class a implements Interpolator {
        private float ijz = 1.3f;

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (((f2 * (this.ijz + 1.0f)) + this.ijz) * (f2 * f2)) + 1.0f;
        }
    }

    public RadarSpecialSmoothScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            this.ijw = (RadarSpecialTableLayout) getChildAt(0);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ijw == null) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.xX = motionEvent.getY();
                break;
            case 1:
                this.xX = 0.0f;
                if (aIS()) {
                    axn();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY();
                if (this.xX == 0.0f) {
                    this.xX = y;
                }
                if (aIR()) {
                    int i = (int) (this.xX - y);
                    scrollBy(0, i);
                    if (this.fu.isEmpty()) {
                        this.fu.set(this.ijw.getLeft(), this.ijw.getTop(), this.ijw.getRight(), this.ijw.getBottom());
                    }
                    this.ijw.k(this.ijw.getLeft(), this.ijw.getTop() - (i / 2), this.ijw.getRight(), this.ijw.getBottom() - (i / 2));
                } else {
                    scrollBy(0, ((int) (this.xX - y)) / 2);
                }
                this.xX = y;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void axn() {
        this.ijx = new TranslateAnimation(0.0f, 0.0f, (float) (this.ijw.getTop() - this.fu.top), 0.0f);
        this.ijx.setInterpolator(this.ijy);
        this.ijx.setDuration((long) Math.abs(this.ijw.getTop() - this.fu.top));
        this.ijw.startAnimation(this.ijx);
        this.ijw.k(this.fu.left, this.fu.top, this.fu.right, this.fu.bottom);
        this.fu.setEmpty();
    }

    public boolean aIS() {
        return !this.fu.isEmpty();
    }

    public boolean aIR() {
        int measuredHeight = this.ijw.getMeasuredHeight() - getHeight();
        int scrollY = getScrollY();
        if (scrollY == 0 || scrollY == measuredHeight) {
            return true;
        }
        return false;
    }
}
