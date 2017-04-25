package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.v;

public class ElasticHorizontalScrollView extends HorizontalScrollView {
    private static int gpm = 82;
    protected LinearLayout dRD;
    private Interpolator eV;
    private int gpn;
    private boolean gpo;
    private float gpp;
    private Rect gpq = new Rect();
    private float x;

    public ElasticHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            v.i("MicroMsg.ElasticHorizontalScrollView", "Get the first child of ElasticHorizontalScrollView.");
            if (childAt instanceof LinearLayout) {
                this.dRD = (LinearLayout) childAt;
                v.i("MicroMsg.ElasticHorizontalScrollView", "The first child of ElasticHorizontalScrollView is a instance of LinearLayout.");
            }
        }
        if (this.dRD == null) {
            v.i("MicroMsg.ElasticHorizontalScrollView", "The first child of ElasticHorizontalScrollView is null, so create a LinearLayout for it.");
            this.dRD = new LinearLayout(getContext());
            this.dRD.setLayoutParams(new LayoutParams(-2, -2, 3));
        }
        super.onFinishInflate();
        this.gpn = b.a(getContext(), (float) gpm);
        this.eV = new DecelerateInterpolator();
        setSmoothScrollingEnabled(true);
        this.x = -10000.0f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 1;
        int i2 = 0;
        if (motionEvent != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.x = motionEvent.getX();
                    this.gpp = this.x;
                    break;
                case 1:
                case 3:
                    this.gpo = motionEvent.getX() > this.gpp;
                    if (this.gpq.isEmpty()) {
                        i = 0;
                    }
                    if (i != 0) {
                        this.dRD.startAnimation(a((float) this.dRD.getLeft(), this.dRD.getLeft() - this.gpq.left));
                        this.dRD.layout(this.gpq.left, this.gpq.top, this.gpq.right, this.gpq.bottom);
                        this.gpq.setEmpty();
                    } else {
                        this.dRD.startAnimation(a((float) aso(), this.gpn >> 1));
                        scrollBy(aso(), 0);
                    }
                    this.x = -10000.0f;
                    break;
                case 2:
                    float f = this.x;
                    float x = motionEvent.getX();
                    int i3 = (int) (f - x);
                    if (i3 >= 2 || i3 <= -2) {
                        if (this.x != -10000.0f) {
                            int measuredWidth = this.dRD.getMeasuredWidth() - ((getWidth() - getPaddingLeft()) - getPaddingRight());
                            int scrollX = getScrollX();
                            if (scrollX == 0 || measuredWidth == scrollX) {
                                i2 = 1;
                            }
                            if (i2 != 0) {
                                if (this.gpq.isEmpty()) {
                                    this.gpq.set(this.dRD.getLeft(), this.dRD.getTop(), this.dRD.getRight(), this.dRD.getBottom());
                                }
                                this.dRD.layout(this.dRD.getLeft() - i3, this.dRD.getTop(), this.dRD.getRight() - i3, this.dRD.getBottom());
                            }
                        } else {
                            this.gpp = x;
                        }
                        this.x = x;
                        break;
                    }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private TranslateAnimation a(float f, int i) {
        TranslateAnimation translateAnimation = new TranslateAnimation(f, 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration((long) Math.abs(i));
        translateAnimation.setInterpolator(this.eV);
        return translateAnimation;
    }

    private int aso() {
        int scrollX;
        if (this.gpo) {
            scrollX = getScrollX() % this.gpn;
            return scrollX / (this.gpn >> 1) == 0 ? -scrollX : this.gpn - scrollX;
        } else {
            scrollX = (getScrollX() + getWidth()) % this.gpn;
            return scrollX / (this.gpn >> 1) == 0 ? -scrollX : this.gpn - scrollX;
        }
    }
}
