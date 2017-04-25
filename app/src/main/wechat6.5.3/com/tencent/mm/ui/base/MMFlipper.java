package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class MMFlipper extends ViewGroup {
    private Interpolator eV;
    private VelocityTracker fj;
    private int fmM;
    private int iD;
    protected int nTA;
    public boolean nTC;
    protected int nTz;
    protected int nUT;
    private int nUU;
    private boolean nUV;
    public b nUW;
    public a nUX;
    int nUY;
    int nUZ;
    private Scroller xF;
    private float xW;
    private float xX;

    public interface a {
        void ck(int i, int i2);
    }

    public interface b {
        void pa(int i);
    }

    private static class c implements Interpolator {
        private float ijz;

        public c() {
            this.ijz = 1.3f;
            this.ijz = 0.0f;
        }

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (f2 * f2)) + 1.0f;
        }
    }

    public MMFlipper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init(context);
    }

    public MMFlipper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nUU = 0;
        this.fmM = 0;
        this.nUV = false;
        this.nTC = true;
        this.nUY = -123454321;
        this.nUZ = -123454321;
        init(context);
    }

    private void init(Context context) {
        this.eV = new c();
        this.xF = new Scroller(context, this.eV);
        this.nTA = -1;
        int i = this.nUU;
        this.nTz = i;
        this.nUT = i;
        this.iD = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        long Nj = be.Nj();
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                v.v("MicroMsg.MMFlipper", "flipper onLayout childWidth:" + measuredWidth);
                childAt.layout(i5, 0, i5 + measuredWidth, childAt.getMeasuredHeight());
                i5 += measuredWidth;
            }
        }
        v.v("MicroMsg.MMFlipper", "use " + be.az(Nj) + " ms, flipper onLayout changed:" + z + " Left,Top,Right,Bottom:" + i + "," + i2 + "," + i3 + "," + i4);
    }

    protected void onMeasure(int i, int i2) {
        long Nj = be.Nj();
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.nUX != null) {
            this.nUX.ck(size, size2);
        }
        this.nUY = size;
        this.nUZ = size2;
        int childCount = getChildCount();
        for (size2 = 0; size2 < childCount; size2++) {
            getChildAt(size2).measure(i, i2);
        }
        scrollTo(this.nTz * size, 0);
        v.v("MicroMsg.MMFlipper", "flipper onMeasure:" + size + "," + MeasureSpec.getSize(i2) + " childCount:" + childCount + ", use " + be.az(Nj));
    }

    private void wh(int i) {
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        if (getScrollX() != getWidth() * max) {
            int width = (getWidth() * max) - getScrollX();
            this.xF.startScroll(getScrollX(), 0, width, 0, com.tencent.mm.bd.a.P(getContext(), (int) (((float) Math.abs(width)) * 1.3f)));
            if (this.nTz != max) {
                this.nUV = true;
                this.nUT += max - this.nTz;
            }
            this.nTA = this.nTz;
            this.nTz = max;
            invalidate();
        }
    }

    public final void wv(int i) {
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        this.nUV = false;
        if (!this.xF.isFinished()) {
            this.xF.abortAnimation();
        }
        this.nTA = this.nTz;
        this.nTz = max;
        scrollTo(max * getWidth(), 0);
    }

    public final void ww(int i) {
        this.nUT = i;
    }

    public final void wx(int i) {
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        this.nUV = false;
        if (!this.xF.isFinished()) {
            this.xF.abortAnimation();
        }
        if (this.nUW != null) {
            this.nUW.pa(max);
        }
        this.nTA = this.nTz;
        this.nTz = max;
        this.nUT = max;
        scrollTo(max * getWidth(), 0);
    }

    public final int bBS() {
        v.d("MicroMsg.MMFlipper", "cur screen is %d", Integer.valueOf(this.nTz));
        return this.nTz;
    }

    public void computeScroll() {
        this.xF.getCurrX();
        if (this.xF.computeScrollOffset()) {
            scrollTo(this.xF.getCurrX(), this.xF.getCurrY());
            postInvalidate();
        } else if (this.nUV) {
            this.nUV = false;
            if (this.nUW != null) {
                this.nUW.pa(this.nUT);
            }
        }
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
        motionEvent.getY();
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
                if (action > 600 && this.nTz > 0) {
                    wh(this.nTz - 1);
                } else if (action >= -600 || this.nTz >= getChildCount() - 1) {
                    action = getWidth();
                    wh((getScrollX() + (action / 2)) / action);
                } else {
                    wh(this.nTz + 1);
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
                v.v("MicroMsg.MMFlipper", "xDif = " + action + ", yDif = " + abs);
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
}
