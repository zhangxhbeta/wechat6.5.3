package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class RadarSpecialGridView extends RadarSpecialSmoothScrollView {
    protected a ijs = null;
    protected RadarSpecialTableLayout ijt = null;
    private int iju = 0;
    private int ijv = 0;

    public interface a {
        void e(int i, View view);
    }

    public final /* bridge */ /* synthetic */ boolean aIR() {
        return super.aIR();
    }

    public final /* bridge */ /* synthetic */ boolean aIS() {
        return super.aIS();
    }

    public final /* bridge */ /* synthetic */ void axn() {
        super.axn();
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public RadarSpecialGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        aIQ();
    }

    public RadarSpecialGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aIQ();
    }

    private void aIQ() {
        this.ijt = new RadarSpecialTableLayout(getContext());
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.ijt.setLayoutParams(layoutParams);
        this.ijt.setStretchAllColumns(true);
        this.ijt.setShrinkAllColumns(true);
        this.ijt.setGravity(80);
        addView(this.ijt);
    }

    public final void a(a aVar) {
        if (this.ijs == null) {
            this.ijs = aVar;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int scrollX;
        int i5 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            scrollX = (getScrollX() + childAt.getWidth()) - this.ijv;
            this.ijv = childAt.getWidth();
            if (scrollX <= 0) {
                scrollX = 0;
            }
        } else {
            scrollX = getScrollX();
        }
        if (getChildCount() > 0) {
            View childAt2 = getChildAt(0);
            int scrollY = (getScrollY() + childAt2.getHeight()) - this.iju;
            this.iju = childAt2.getHeight();
            if (scrollY > 0) {
                i5 = scrollY;
            }
        } else {
            i5 = getScrollY();
        }
        scrollTo(scrollX, i5);
    }
}
