package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;
import java.util.Set;

public class MMSlideDelView extends ViewGroup {
    public f euc;
    public c eud;
    public d euf;
    private VelocityTracker fj;
    public boolean gMt = true;
    private int gYI;
    private final int iD;
    private boolean lta = false;
    private ac mHandler = new ac();
    private boolean nXQ = false;
    private b nXR;
    private Runnable nXS;
    private long nXT;
    private boolean nXU = false;
    private a nXV = null;
    long time;
    private final Scroller xF;
    private float xW;
    private float xX;

    class b implements Runnable {
        final /* synthetic */ MMSlideDelView nXW;

        b(MMSlideDelView mMSlideDelView) {
            this.nXW = mMSlideDelView;
        }

        public final void run() {
            v.v("MicroMsg.MMSlideDelView", "checkfortap");
            this.nXW.setPressed(true);
        }
    }

    public interface c {
        int bN(View view);
    }

    public interface d {
        public static final Set<MMSlideDelView> gMD = new HashSet();

        void a(MMSlideDelView mMSlideDelView, boolean z);

        boolean avl();

        void avm();

        void avn();
    }

    public interface e {
        void aE(Object obj);
    }

    public interface f {
        void p(View view, int i);
    }

    private class g {
        int fnj;
        final /* synthetic */ MMSlideDelView nXW;

        private g(MMSlideDelView mMSlideDelView) {
            this.nXW = mMSlideDelView;
        }
    }

    private class a extends g implements Runnable {
        final /* synthetic */ MMSlideDelView nXW;

        private a(MMSlideDelView mMSlideDelView) {
            this.nXW = mMSlideDelView;
            super();
        }

        public final void run() {
            Object obj = (this.nXW.hasWindowFocus() && this.nXW.getWindowAttachCount() == this.fnj) ? 1 : null;
            if (obj != null && !this.nXW.lta) {
                v.i("MicroMsg.MMSlideDelView", "is long press");
                if (this.nXW.getParent() != null) {
                    this.nXW.nXU = true;
                    this.nXW.performLongClick();
                }
            }
        }
    }

    public static d bCp() {
        return new d() {
            public final void a(MMSlideDelView mMSlideDelView, boolean z) {
                if (z) {
                    gMD.add(mMSlideDelView);
                } else {
                    gMD.remove(mMSlideDelView);
                }
            }

            public final boolean avl() {
                return gMD.size() > 0;
            }

            public final void avm() {
                for (MMSlideDelView mMSlideDelView : gMD) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.bCu();
                    }
                }
                gMD.clear();
            }

            public final void avn() {
                for (MMSlideDelView mMSlideDelView : gMD) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.bCt();
                    }
                }
                gMD.clear();
            }
        };
    }

    public MMSlideDelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.xF = new Scroller(context, new LinearInterpolator());
        this.iD = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.nXT = (long) ViewConfiguration.getLongPressTimeout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() >= 2) {
            int childCount = getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    childAt.layout(i5, 0, i5 + measuredWidth, i4 - i2);
                    i5 += measuredWidth;
                }
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        if (getChildCount() >= 2) {
            int size = MeasureSpec.getSize(i);
            try {
                getChildAt(0).measure(i, i2);
            } catch (ArrayIndexOutOfBoundsException e) {
            }
            int max = Math.max(0, getChildAt(0).getMeasuredHeight());
            LayoutParams layoutParams = getChildAt(1).getLayoutParams();
            View childAt = getChildAt(1);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                try {
                    childAt.measure(MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), MeasureSpec.makeMeasureSpec(max, 1073741824));
                } catch (ArrayIndexOutOfBoundsException e2) {
                }
                max = Math.max(max, childAt.getMeasuredHeight());
            }
            setMeasuredDimension(resolveSize(size, i), resolveSize(max, i2));
        }
    }

    public final void setView(View view) {
        if (getChildCount() == 2) {
            removeViewAt(0);
        }
        addView(view, 0, new LayoutParams(-1, -2));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.gMt) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.euf.avl() && !this.nXQ) {
            v.v("MicroMsg.MMSlideDelView", "onTouchEvent a menu has been shown, skip");
            this.nXU = false;
            this.euf.avm();
        }
        if (this.fj == null) {
            this.fj = VelocityTracker.obtain();
        }
        this.fj.addMovement(motionEvent);
        if (this.nXU) {
            return false;
        }
        switch (action) {
            case 0:
                if (getContext() instanceof MMActivity) {
                    ((MMActivity) getContext()).axg();
                }
                this.lta = false;
                if (!this.xF.isFinished()) {
                    this.xF.abortAnimation();
                }
                this.time = System.currentTimeMillis();
                if (this.eud != null) {
                    this.gYI = this.eud.bN(this);
                }
                if (this.nXR == null) {
                    this.nXR = new b(this);
                }
                this.mHandler.postDelayed(this.nXR, (long) ViewConfiguration.getTapTimeout());
                this.xW = x;
                this.xX = y;
                if (this.nXV == null) {
                    this.nXV = new a();
                }
                g gVar = this.nXV;
                gVar.fnj = gVar.nXW.getWindowAttachCount();
                this.mHandler.postDelayed(this.nXV, this.nXT);
                return true;
            case 1:
                bCr();
                if (this.lta || ((!isPressed() && System.currentTimeMillis() - this.time >= 200) || this.euc == null || this.nXQ)) {
                    setPressed(false);
                } else {
                    setPressed(true);
                    if (this.nXS != null) {
                        removeCallbacks(this.nXS);
                    }
                    this.nXS = new Runnable(this) {
                        final /* synthetic */ MMSlideDelView nXW;

                        {
                            this.nXW = r1;
                        }

                        public final void run() {
                            this.nXW.setPressed(false);
                            v.v("MicroMsg.MMSlideDelView", "onClick");
                            this.nXW.euc.p(this.nXW, this.nXW.gYI);
                            this.nXW.bCt();
                        }
                    };
                    this.mHandler.postDelayed(this.nXS, (long) ViewConfiguration.getPressedStateDuration());
                }
                if (this.lta) {
                    bCs();
                }
                bCq();
                if (this.mHandler == null) {
                    return true;
                }
                this.mHandler.removeCallbacks(this.nXV);
                return true;
            case 2:
                int i = (int) (this.xW - x);
                action = (int) (this.xX - y);
                int scrollX = getScrollX();
                if (!this.lta) {
                    boolean z;
                    if (i >= 0 && Math.abs(i) >= this.iD / 3) {
                        if (action == 0) {
                            action = 1;
                        }
                        if (Math.abs(i / action) > 3) {
                            z = true;
                            if (z || this.nXQ) {
                                this.lta = true;
                                cy(true);
                            }
                        }
                    }
                    z = false;
                    this.lta = true;
                    cy(true);
                }
                if (this.lta) {
                    View childAt = getChildAt(1);
                    if (!(childAt == null || childAt.isShown())) {
                        childAt.setVisibility(0);
                    }
                    bCr();
                    setPressed(false);
                    cy(true);
                    if (scrollX + i < 0) {
                        action = -scrollX;
                    } else if (scrollX + i > getChildAt(1).getWidth()) {
                        action = getChildAt(1).getWidth() - scrollX;
                    } else {
                        action = i;
                    }
                    if (this.mHandler != null) {
                        this.mHandler.removeCallbacks(this.nXV);
                    }
                    scrollBy(action, 0);
                }
                this.xW = x;
                this.xX = y;
                return true;
            case 3:
                bCr();
                setPressed(false);
                if (this.lta) {
                    bCs();
                }
                bCq();
                if (this.mHandler == null) {
                    return true;
                }
                this.mHandler.removeCallbacks(this.nXV);
                return true;
            default:
                if (this.mHandler == null) {
                    return true;
                }
                this.mHandler.removeCallbacks(this.nXV);
                return true;
        }
    }

    private void bCq() {
        if (this.fj != null) {
            this.fj.clear();
            this.fj = null;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        v.v("MicroMsg.MMSlideDelView", "window focus change, reset long press status");
        this.nXU = false;
        super.onWindowFocusChanged(z);
    }

    private void bCr() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.nXR);
        }
    }

    private void bCs() {
        setPressed(false);
        if (this.nXQ) {
            bCu();
            return;
        }
        MMSlideDelView mMSlideDelView;
        VelocityTracker velocityTracker = this.fj;
        velocityTracker.computeCurrentVelocity(1000);
        int xVelocity = (int) velocityTracker.getXVelocity();
        int scrollX;
        int width;
        if (xVelocity < -600) {
            scrollX = getScrollX();
            width = getChildAt(1).getWidth() - scrollX;
            this.euf.a(this, true);
            this.nXQ = true;
            this.xF.startScroll(scrollX, 0, width, 0, 100);
            mMSlideDelView = this;
        } else if (xVelocity > 600) {
            bCu();
            if (this.fj != null) {
                this.fj.recycle();
                this.fj = null;
            }
            this.lta = false;
            cy(false);
        } else {
            scrollX = getScrollX();
            xVelocity = getChildAt(1).getWidth();
            width = xVelocity - scrollX;
            if (scrollX > xVelocity / 2) {
                this.euf.a(this, true);
                this.nXQ = true;
                this.xF.startScroll(scrollX, 0, width, 0, 100);
                mMSlideDelView = this;
            } else {
                this.nXQ = false;
                this.euf.a(this, false);
                this.xF.startScroll(scrollX, 0, -scrollX, 0, 100);
                mMSlideDelView = this;
            }
        }
        mMSlideDelView.invalidate();
        if (this.fj != null) {
            this.fj.recycle();
            this.fj = null;
        }
        this.lta = false;
        cy(false);
    }

    private void cy(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final void bCt() {
        this.euf.a(this, false);
        this.nXQ = false;
        scrollTo(0, 0);
        invalidate();
    }

    public final void bCu() {
        int scrollX = getScrollX();
        this.euf.a(this, false);
        this.nXQ = false;
        this.xF.startScroll(scrollX, 0, -scrollX, 0, 100);
        invalidate();
    }

    public void computeScroll() {
        if (this.xF.computeScrollOffset()) {
            scrollTo(this.xF.getCurrX(), this.xF.getCurrY());
            postInvalidate();
        }
    }

    public Bitmap getDrawingCache() {
        return null;
    }

    public Bitmap getDrawingCache(boolean z) {
        return null;
    }

    public void buildDrawingCache(boolean z) {
    }

    public void buildDrawingCache() {
    }
}
