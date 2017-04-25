package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.v;

public class MMADFlipper extends ViewGroup {
    private VelocityTracker fj;
    private int fmM;
    private int iD;
    private Context mContext;
    private int nTA;
    private boolean nTB;
    private boolean nTC;
    private Interpolator nTy;
    private int nTz;
    private Scroller xF;
    private float xW;
    private float xX;

    public MMADFlipper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMADFlipper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmM = 0;
        this.nTB = false;
        this.nTC = true;
        this.mContext = context;
        this.nTy = new LinearInterpolator();
        this.xF = new Scroller(this.mContext, this.nTy);
        this.iD = ViewConfiguration.get(this.mContext).getScaledDoubleTapSlop();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i5, 0, i5 + measuredWidth, childAt.getMeasuredHeight());
                i5 += measuredWidth;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        MeasureSpec.getSize(i);
        MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(i, i2);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.nTC) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (getChildCount() == 1) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 2 && this.fmM != 0) {
            return true;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.xW = x;
                this.xX = y;
                this.fmM = this.xF.isFinished() ? 0 : 1;
                break;
            case 1:
            case 3:
                this.fmM = 0;
                break;
            case 2:
                boolean z;
                action = (int) Math.abs(this.xW - x);
                int abs = (int) Math.abs(this.xX - y);
                if (action <= this.iD || abs >= this.iD) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    this.fmM = 0;
                    break;
                }
                this.fmM = 1;
                break;
                break;
        }
        if (this.fmM == 0) {
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getChildCount() == 1) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.fj == null) {
            this.fj = VelocityTracker.obtain();
        }
        this.fj.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        switch (action) {
            case 0:
                if (!this.xF.isFinished()) {
                    this.xF.abortAnimation();
                }
                this.xW = x;
                return true;
            case 1:
            case 3:
                VelocityTracker velocityTracker = this.fj;
                velocityTracker.computeCurrentVelocity(1000);
                action = (int) velocityTracker.getXVelocity();
                if (action > 600) {
                    if (bBO()) {
                        this.nTz--;
                        wh(this.nTz);
                    }
                    this.nTB = true;
                } else if (action < -600) {
                    if (bBO()) {
                        this.nTz++;
                        wh(this.nTz);
                    }
                    this.nTB = true;
                } else {
                    action = getWidth();
                    wh((getScrollX() + (action / 2)) / action);
                }
                if (this.fj != null) {
                    this.fj.recycle();
                    this.fj = null;
                }
                this.fmM = 0;
                this.xW = 0.0f;
                this.xX = 0.0f;
                return true;
            case 2:
                action = (int) (this.xW - x);
                this.xW = x;
                scrollBy(action, 0);
                return true;
            default:
                return true;
        }
    }

    private boolean bBO() {
        if (getChildCount() > 1) {
            return true;
        }
        return false;
    }

    private void wh(int i) {
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        if (getScrollX() != getWidth() * max) {
            int width = (max * getWidth()) - getScrollX();
            this.xF.startScroll(getScrollX(), 0, width, 0, a.P(getContext(), Math.abs(width) * 2));
            invalidate();
        }
        v.d("MicroMsg.MMFlipper", "mCurScreen:%d, mLastScreen:%d, whichScreen:%d", new Object[]{Integer.valueOf(this.nTz), Integer.valueOf(this.nTA), Integer.valueOf(i)});
        this.nTA = i;
    }

    public void computeScroll() {
        if (this.xF.computeScrollOffset()) {
            scrollTo(this.xF.getCurrX(), this.xF.getCurrY());
            postInvalidate();
        } else if (this.nTB) {
            this.nTB = false;
            if (this.nTz <= 0) {
                this.nTz = getChildCount() > 1 ? getChildCount() - 2 : getChildCount();
                wi(this.nTz * getWidth());
            } else if (this.nTz >= getChildCount() - 1) {
                this.nTz = 1;
                wi(this.nTz * getWidth());
            }
        }
    }

    @TargetApi(14)
    private void wi(int i) {
        if (VERSION.SDK_INT >= 14) {
            setScrollX(i);
        } else if (this.xF != null) {
            this.xF.setFinalX(i);
        }
    }
}
