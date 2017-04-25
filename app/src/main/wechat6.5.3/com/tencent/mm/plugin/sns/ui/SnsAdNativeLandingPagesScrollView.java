package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class SnsAdNativeLandingPagesScrollView extends NestedScrollView {
    volatile boolean jKq;
    private int jKr = 0;
    private int jKs = 0;
    private int jKt = 50;
    ak jKu = null;
    private long jKv = System.currentTimeMillis();
    Runnable jKw = new Runnable(this) {
        final /* synthetic */ SnsAdNativeLandingPagesScrollView jKx;

        {
            this.jKx = r1;
        }

        public final void run() {
            int scrollY = this.jKx.getScrollY();
            if (scrollY != this.jKx.jKs) {
                System.currentTimeMillis();
                this.jKx.jKv;
                if (this.jKx.jKu != null) {
                    ak c = this.jKx.jKu;
                    SnsAdNativeLandingPagesScrollView snsAdNativeLandingPagesScrollView = this.jKx;
                    this.jKx.jKr;
                    c.c(snsAdNativeLandingPagesScrollView, scrollY);
                }
                this.jKx.jKv = System.currentTimeMillis();
            }
            if (this.jKx.jKs - scrollY == 0) {
                if (this.jKx.jKu != null) {
                    ak c2 = this.jKx.jKu;
                    this.jKx.jKs;
                    this.jKx.jKr;
                    c2.aWq();
                }
                this.jKx.jKr = this.jKx.jKs;
            }
            this.jKx.jKs = this.jKx.getScrollY();
            this.jKx.postDelayed(this.jKx.jKw, (long) this.jKx.jKt);
        }
    };

    public SnsAdNativeLandingPagesScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SnsAdNativeLandingPagesScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void aWp() {
        if (!this.jKq) {
            this.jKq = true;
            this.jKr = getScrollY();
            postDelayed(this.jKw, (long) this.jKt);
            if (this.jKu != null) {
                ak akVar = this.jKu;
                getScrollY();
                akVar.aWr();
            }
        }
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    public final void fling(int i) {
        super.fling(i / 3);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.jKu != null) {
            this.jKu.aWr();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
