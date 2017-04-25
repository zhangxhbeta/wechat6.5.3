package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class CustomerScrollView extends ScrollView {
    private float pjk;
    private float pjl;
    private float pjm;
    private float pjn;

    public CustomerScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CustomerScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.pjl = 0.0f;
                this.pjk = 0.0f;
                this.pjm = motionEvent.getX();
                this.pjn = motionEvent.getY();
                break;
            case 2:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.pjk += Math.abs(x - this.pjm);
                this.pjl += Math.abs(y - this.pjn);
                this.pjm = x;
                this.pjn = y;
                if (this.pjk > this.pjl) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
