package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ad;
import android.support.v4.view.n;
import android.support.v4.view.x;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Adapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Scroller;
import java.util.ArrayList;

public class MMDragSortGridViewPager extends ViewGroup {
    private static final Interpolator xy = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    private final DataSetObserver AB = new DataSetObserver(this) {
        final /* synthetic */ MMDragSortGridViewPager dWw;

        {
            this.dWw = r1;
        }

        public final void onChanged() {
            MMDragSortGridViewPager.a(this.dWw);
        }

        public final void onInvalidated() {
            MMDragSortGridViewPager.a(this.dWw);
        }
    };
    private int Ef;
    private OnItemClickListener abT;
    private int dWa = 2;
    private int dWb = 4;
    private int dWc = (this.dWa * this.dWb);
    private int dWd;
    private int dWe;
    private int dWf;
    private int dWg;
    private int dWh;
    private int dWi;
    private int dWj;
    private int dWk;
    private Adapter dWl;
    private int dWm = -1;
    private long dWn = Long.MAX_VALUE;
    private View dWo = null;
    private int dWp = -1;
    private int dWq = -1;
    private int dWr = -1;
    private long dWs = Long.MAX_VALUE;
    private ArrayList<Integer> dWt = new ArrayList();
    private a dWu;
    private OnItemLongClickListener dWv;
    private int ek;
    private VelocityTracker fj;
    private int fk = -1;
    private boolean iB;
    private int iD;
    private float wL;
    private float wM;
    private int xB;
    private Scroller xF;
    private boolean xQ;
    private boolean xT;
    private float xW;
    private float xX;
    private int xY;
    private int xZ;
    private int xe = 0;
    private int ya;
    private int yb;
    private boolean yh;
    private final Runnable yr = new Runnable(this) {
        final /* synthetic */ MMDragSortGridViewPager dWw;

        {
            this.dWw = r1;
        }

        public final void run() {
            this.dWw.Y(0);
        }
    };

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int dWx;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.dWx = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.dWx);
        }
    }

    public interface a {
    }

    static /* synthetic */ void a(MMDragSortGridViewPager mMDragSortGridViewPager) {
        int i = 0;
        while (i < mMDragSortGridViewPager.getChildCount() && i < mMDragSortGridViewPager.dWl.getCount()) {
            View childAt = mMDragSortGridViewPager.getChildAt(i);
            View view = mMDragSortGridViewPager.dWl.getView(i, childAt, mMDragSortGridViewPager);
            if (view != childAt) {
                mMDragSortGridViewPager.removeViewAt(i);
                mMDragSortGridViewPager.addView(view, i);
            }
            i++;
        }
        for (i = mMDragSortGridViewPager.getChildCount(); i < mMDragSortGridViewPager.dWl.getCount(); i++) {
            mMDragSortGridViewPager.addView(mMDragSortGridViewPager.dWl.getView(i, null, mMDragSortGridViewPager));
        }
        while (mMDragSortGridViewPager.getChildCount() > mMDragSortGridViewPager.dWl.getCount()) {
            mMDragSortGridViewPager.removeViewAt(mMDragSortGridViewPager.getChildCount() - 1);
        }
    }

    public MMDragSortGridViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        SH();
    }

    public MMDragSortGridViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SH();
    }

    private void SH() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        setChildrenDrawingOrderEnabled(true);
        Context context = getContext();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.dWd = (int) (8.0f * f);
        this.dWi = getPaddingLeft();
        this.ek = getPaddingTop();
        this.dWj = getPaddingRight();
        this.dWk = getPaddingBottom();
        super.setPadding(0, 0, 0, 0);
        this.xF = new Scroller(context, xy);
        this.iD = ad.a(viewConfiguration);
        this.xY = (int) (400.0f * f);
        this.xZ = viewConfiguration.getScaledMaximumFlingVelocity();
        this.ya = (int) (25.0f * f);
        this.yb = (int) (2.0f * f);
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.yr);
        if (this.dWl != null) {
            this.dWl.unregisterDataSetObserver(this.AB);
        }
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int childCount = getChildCount();
        this.dWe = ((this.dWc + childCount) - 1) / this.dWc;
        this.dWf = (((getWidth() - this.dWi) - this.dWj) - ((this.dWa - 1) * this.dWd)) / this.dWa;
        this.dWg = (((getHeight() - this.ek) - this.dWk) - ((this.dWb - 1) * this.dWd)) / this.dWb;
        this.dWh = this.dWf / 2;
        this.Ef = this.dWf / 2;
        this.dWt.clear();
        for (i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            Rect hB = hB(i5);
            childAt.measure(MeasureSpec.makeMeasureSpec(hB.width(), 1073741824), MeasureSpec.makeMeasureSpec(hB.height(), 1073741824));
            new StringBuilder("child.layout position=").append(i5).append(", rect=").append(hB);
            childAt.layout(hB.left, hB.top, hB.right, hB.bottom);
            this.dWt.add(Integer.valueOf(-1));
        }
        if (this.xB > 0 && this.xB < this.dWe) {
            i5 = this.xB;
            this.xB = 0;
            y(i5, false);
        }
    }

    private void Y(int i) {
        if (this.xe != i) {
            this.xe = i;
        }
    }

    private void y(int i, boolean z) {
        a(i, z, false, 0);
    }

    private void a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.dWe <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.xB != i) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.dWe) {
                i = this.dWe - 1;
            }
            if (this.xB != i) {
                z3 = true;
            }
            this.xB = i;
            a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        int width = getWidth() * i;
        if (z) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int i3 = width - scrollX;
                int i4 = 0 - scrollY;
                if (i3 == 0 && i4 == 0) {
                    r(false);
                    Y(0);
                } else {
                    setScrollingCacheEnabled(true);
                    Y(2);
                    width = getWidth();
                    int i5 = width / 2;
                    float sin = (((float) i5) * ((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (1.0f * ((float) Math.abs(i3))) / ((float) width)) - 0.5f)) * 0.4712389167638204d))))) + ((float) i5);
                    int abs = Math.abs(i2);
                    this.xF.startScroll(scrollX, scrollY, i3, i4, Math.min(abs > 0 ? Math.round(1000.0f * Math.abs(sin / ((float) abs))) * 4 : (int) (((((float) Math.abs(i3)) / ((float) width)) + 1.0f) * 100.0f), 600));
                    y.E(this);
                }
            }
            if (!z2 || this.dWu != null) {
                return;
            }
            return;
        }
        r(false);
        scrollTo(width, 0);
        ac(width);
    }

    public void computeScroll() {
        if (this.xF.isFinished() || !this.xF.computeScrollOffset()) {
            r(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.xF.getCurrX();
        int currY = this.xF.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!ac(currX)) {
                this.xF.abortAnimation();
                scrollTo(0, currY);
            }
        }
        y.E(this);
    }

    private boolean ac(int i) {
        if (this.dWe <= 0) {
            this.yh = false;
            this.yh = true;
            if (this.yh) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        getWidth();
        this.yh = false;
        this.yh = true;
        if (this.yh) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void r(boolean z) {
        if (this.xe == 2) {
            setScrollingCacheEnabled(false);
            this.xF.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.xF.getCurrX();
            int currY = this.xF.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
            if (z) {
                y.a(this, this.yr);
            } else {
                this.yr.run();
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.iB = false;
            this.xT = false;
            this.fk = -1;
            if (this.fj == null) {
                return false;
            }
            this.fj.recycle();
            this.fj = null;
            return false;
        }
        if (action != 0) {
            if (this.iB || this.dWp >= 0) {
                return true;
            }
            if (this.xT) {
                return false;
            }
        }
        float x;
        switch (action) {
            case 0:
                x = motionEvent.getX();
                this.wL = x;
                this.xW = x;
                x = motionEvent.getY();
                this.wM = x;
                this.xX = x;
                this.fk = n.c(motionEvent, 0);
                this.xT = false;
                this.xF.computeScrollOffset();
                if (this.xe != 2 || Math.abs(this.xF.getFinalX() - this.xF.getCurrX()) <= this.yb) {
                    r(false);
                    this.iB = false;
                } else {
                    this.xF.abortAnimation();
                    this.iB = true;
                    bW();
                    Y(1);
                }
                new StringBuilder("***Down at ").append(this.xW).append(",").append(this.xX).append(" mIsBeingDragged=").append(this.iB).append(" mIsUnableToDrag=").append(this.xT);
                this.dWp = -1;
                break;
            case 2:
                int i = this.fk;
                if (i != -1) {
                    i = n.b(motionEvent, i);
                    x = n.d(motionEvent, i);
                    float f = x - this.xW;
                    float abs = Math.abs(f);
                    float e = n.e(motionEvent, i);
                    float abs2 = Math.abs(e - this.wM);
                    new StringBuilder("***Moved to ").append(x).append(",").append(e).append(" diff=").append(abs).append(",").append(abs2);
                    if (abs > ((float) this.iD) && abs * 0.5f > abs2) {
                        this.iB = true;
                        bW();
                        Y(1);
                        this.xW = f > 0.0f ? this.wL + ((float) this.iD) : this.wL - ((float) this.iD);
                        this.xX = e;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.iD)) {
                        this.xT = true;
                    }
                    if (this.iB) {
                        o(x);
                        break;
                    }
                }
                break;
            case 6:
                h(motionEvent);
                break;
        }
        if (this.fj == null) {
            this.fj = VelocityTracker.obtain();
        }
        this.fj.addMovement(motionEvent);
        return this.iB;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || this.dWe <= 0) {
            return false;
        }
        if (this.fj == null) {
            this.fj = VelocityTracker.obtain();
        }
        this.fj.addMovement(motionEvent);
        float x;
        int b;
        float d;
        int bh;
        int scrollX;
        float f;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.xF.abortAnimation();
                x = motionEvent.getX();
                this.wL = x;
                this.xW = x;
                x = motionEvent.getY();
                this.wM = x;
                this.xX = x;
                this.fk = n.c(motionEvent, 0);
                new StringBuilder("Down at ").append(this.xW).append(",").append(this.xX).append(" mIsBeingDragged=").append(this.iB).append(" mIsUnableToDrag=").append(this.xT);
                if (this.iB || this.xe != 0) {
                    this.dWm = -1;
                } else {
                    this.dWm = bh((int) this.xW, (int) this.xX);
                }
                if (this.dWm >= 0) {
                    this.dWn = System.currentTimeMillis();
                } else {
                    this.dWn = Long.MAX_VALUE;
                }
                new StringBuilder("Down at mLastPosition=").append(this.dWm);
                this.dWp = -1;
                break;
            case 1:
                b = n.b(motionEvent, this.fk);
                d = n.d(motionEvent, b);
                x = n.e(motionEvent, b);
                if (this.dWp < 0) {
                    if (!this.iB) {
                        if (this.dWm >= 0) {
                            bh = bh((int) d, (int) x);
                            if (bh == this.dWm && this.abT != null) {
                                this.abT.onItemClick(null, getChildAt(bh), bh, (long) (bh / this.dWa));
                                break;
                            }
                        }
                    }
                    VelocityTracker velocityTracker = this.fj;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.xZ);
                    int a = (int) x.a(velocityTracker, this.fk);
                    bh = getWidth();
                    scrollX = getScrollX();
                    b = scrollX / bh;
                    f = ((float) (scrollX - (b * bh))) / ((float) bh);
                    if (Math.abs((int) (d - this.wL)) <= this.ya || Math.abs(a) <= this.xY) {
                        b = (int) ((((float) b) + f) + (b >= this.xB ? 0.4f : 0.6f));
                    } else if (a <= 0) {
                        b++;
                    }
                    a(b, true, true, a);
                    this.fk = -1;
                    cD();
                    break;
                }
                SI();
                break;
                break;
            case 2:
                b = n.b(motionEvent, this.fk);
                d = n.d(motionEvent, b);
                float e = n.e(motionEvent, b);
                if (this.dWp >= 0) {
                    View childAt = getChildAt(this.dWp);
                    bh = (getScrollX() + ((int) d)) - (childAt.getWidth() / 2);
                    scrollX = (getScrollY() + ((int) e)) - (childAt.getHeight() / 2);
                    childAt.layout(bh, scrollX, childAt.getWidth() + bh, childAt.getHeight() + scrollX);
                    if (this.xe == 0) {
                        bh = (int) d;
                        scrollX = (int) e;
                        b = bh(bh, scrollX);
                        if (b < 0) {
                            b = -1;
                        } else {
                            Rect hB = hB(b);
                            int i = b / this.dWc;
                            hB.inset(hB.width() / 4, hB.height() / 4);
                            hB.offset(i * (-getWidth()), 0);
                            if (!hB.contains(bh, scrollX)) {
                                b = -1;
                            }
                        }
                        if (!(b == -1 || this.dWq == b)) {
                            hC(b);
                            this.dWq = b;
                            new StringBuilder("Moved to mLastTarget=").append(this.dWq);
                        }
                        b = (int) d;
                        b = b < this.Ef ? 0 : b >= getWidth() - this.Ef ? 1 : -1;
                        if (this.dWr != -1) {
                            if (b == this.dWr) {
                                if (System.currentTimeMillis() - this.dWs >= 1200) {
                                    performHapticFeedback(0);
                                    if (b == 0 && this.xB > 0) {
                                        y(this.xB - 1, true);
                                    } else if (b == 1 && this.xB < this.dWe - 1) {
                                        y(this.xB + 1, true);
                                    }
                                }
                            }
                            this.dWr = -1;
                        } else if (b != this.dWr) {
                            this.dWr = b;
                            this.dWs = System.currentTimeMillis();
                        }
                    }
                } else if (!this.iB) {
                    x = Math.abs(d - this.xW);
                    f = Math.abs(e - this.xX);
                    new StringBuilder("Moved to ").append(d).append(",").append(e).append(" diff=").append(x).append(",").append(f);
                    if (x > ((float) this.iD) && x > f) {
                        this.iB = true;
                        bW();
                        if (d - this.wL > 0.0f) {
                            x = this.wL + ((float) this.iD);
                        } else {
                            x = this.wL - ((float) this.iD);
                        }
                        this.xW = x;
                        this.xX = e;
                        Y(1);
                        setScrollingCacheEnabled(true);
                    }
                }
                if (!this.iB) {
                    if (this.dWm >= 0) {
                        bh = bh((int) d, (int) e);
                        if (bh == this.dWm) {
                            if (System.currentTimeMillis() - this.dWn >= 400) {
                                if (this.dWv != null ? this.dWv.onItemLongClick(null, getChildAt(bh), bh, (long) (bh / this.dWa)) : false) {
                                    performHapticFeedback(0);
                                    this.dWp = this.dWm;
                                    bW();
                                    this.dWq = -1;
                                    if (this.dWp >= 0) {
                                        View childAt2 = getChildAt(this.dWp);
                                        this.dWo = childAt2;
                                        Rect rect = new Rect(childAt2.getLeft(), childAt2.getTop(), childAt2.getRight(), childAt2.getBottom());
                                        rect.inset((-rect.width()) / 20, (-rect.height()) / 20);
                                        childAt2.measure(MeasureSpec.makeMeasureSpec(rect.width(), 1073741824), MeasureSpec.makeMeasureSpec(rect.height(), 1073741824));
                                        childAt2.layout(rect.left, rect.top, rect.right, rect.bottom);
                                        Animation animationSet = new AnimationSet(true);
                                        Animation scaleAnimation = new ScaleAnimation(0.9091f, 1.0f, 0.9091f, 1.0f, (float) (childAt2.getWidth() / 2), (float) (childAt2.getHeight() / 2));
                                        scaleAnimation.setDuration(150);
                                        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.75f);
                                        alphaAnimation.setDuration(150);
                                        animationSet.addAnimation(scaleAnimation);
                                        animationSet.addAnimation(alphaAnimation);
                                        animationSet.setFillEnabled(true);
                                        animationSet.setFillAfter(true);
                                        childAt2.clearAnimation();
                                        childAt2.startAnimation(animationSet);
                                    }
                                    this.dWm = -1;
                                }
                                this.dWn = Long.MAX_VALUE;
                                break;
                            }
                        }
                        this.dWm = -1;
                        break;
                    }
                }
                o(d);
                break;
                break;
            case 3:
                if (this.dWp < 0) {
                    if (this.iB) {
                        a(this.xB, true, 0, false);
                        this.fk = -1;
                        cD();
                        break;
                    }
                }
                SI();
                break;
                break;
            case 5:
                b = n.e(motionEvent);
                this.xW = n.d(motionEvent, b);
                this.fk = n.c(motionEvent, b);
                break;
            case 6:
                h(motionEvent);
                this.xW = n.d(motionEvent, n.b(motionEvent, this.fk));
                break;
        }
        return true;
    }

    private void bW() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private boolean o(float f) {
        float f2 = this.xW - f;
        this.xW = f;
        f2 += (float) getScrollX();
        int width = getWidth();
        float f3 = (float) (width * 0);
        float f4 = (float) (width * (this.dWe - 1));
        if (f2 < f3) {
            f2 = f3 - Math.min(f3 - f2, (float) this.dWh);
        } else if (f2 > f4) {
            f2 = Math.min(f2 - f4, (float) this.dWh) + f4;
        }
        this.xW += f2 - ((float) ((int) f2));
        scrollTo((int) f2, getScrollY());
        ac((int) f2);
        return false;
    }

    private void h(MotionEvent motionEvent) {
        int e = n.e(motionEvent);
        if (n.c(motionEvent, e) == this.fk) {
            e = e == 0 ? 1 : 0;
            this.xW = n.d(motionEvent, e);
            this.fk = n.c(motionEvent, e);
            if (this.fj != null) {
                this.fj.clear();
            }
        }
    }

    private void cD() {
        this.iB = false;
        this.xT = false;
        if (this.fj != null) {
            this.fj.recycle();
            this.fj = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.xQ != z) {
            this.xQ = z;
        }
    }

    private Rect hB(int i) {
        int width = (((i / this.dWc) * getWidth()) + this.dWi) + (((i % this.dWc) % this.dWa) * (this.dWf + this.dWd));
        int i2 = this.ek + (((i % this.dWc) / this.dWa) * (this.dWg + this.dWd));
        return new Rect(width, i2, this.dWf + width, this.dWg + i2);
    }

    private int bh(int i, int i2) {
        int i3 = (i - this.dWi) / (this.dWf + this.dWd);
        int i4 = (i2 - this.ek) / (this.dWg + this.dWd);
        if (i < this.dWi || i >= (this.dWi + ((this.dWf + this.dWd) * i3)) + this.dWf || i2 < this.ek || i2 >= (this.ek + ((this.dWg + this.dWd) * i4)) + this.dWg || i3 < 0 || i3 >= this.dWa || i4 < 0 || i4 >= this.dWb) {
            return -1;
        }
        i3 += (i4 * this.dWa) + (this.xB * this.dWc);
        if (i3 < 0 || i3 >= getChildCount()) {
            return -1;
        }
        return i3;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.dWp == -1) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.dWp;
        }
        if (i2 >= this.dWp) {
            return i2 + 1;
        }
        return i2;
    }

    private void hC(int i) {
        int i2 = 0;
        while (i2 < getChildCount()) {
            View childAt = getChildAt(i2);
            if (i2 != this.dWp) {
                int i3;
                int intValue;
                if (this.dWp < i && i2 >= this.dWp + 1 && i2 <= i) {
                    i3 = i2 - 1;
                } else if (i >= this.dWp || i2 < i || i2 >= this.dWp) {
                    i3 = i2;
                } else {
                    i3 = i2 + 1;
                }
                if (((Integer) this.dWt.get(i2)).intValue() != -1) {
                    intValue = ((Integer) this.dWt.get(i2)).intValue();
                } else {
                    intValue = i2;
                }
                if (intValue != i3) {
                    new StringBuilder("animateGap from=").append(intValue).append(", to=").append(i3);
                    Rect hB = hB(intValue);
                    Rect hB2 = hB(i3);
                    hB.offset(-childAt.getLeft(), -childAt.getTop());
                    hB2.offset(-childAt.getLeft(), -childAt.getTop());
                    Animation translateAnimation = new TranslateAnimation((float) hB.left, (float) hB2.left, (float) hB.top, (float) hB2.top);
                    translateAnimation.setDuration(150);
                    translateAnimation.setFillEnabled(true);
                    translateAnimation.setFillAfter(true);
                    childAt.clearAnimation();
                    childAt.startAnimation(translateAnimation);
                    this.dWt.set(i2, Integer.valueOf(i3));
                }
            }
            i2++;
        }
    }

    private void SI() {
        if (this.dWp >= 0) {
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).clearAnimation();
            }
            View childAt = getChildAt(this.dWp);
            if (this.dWq >= 0 && this.dWp != this.dWq) {
                removeViewAt(this.dWp);
                addView(childAt, this.dWq);
            }
            this.dWp = -1;
            this.dWq = -1;
            requestLayout();
            invalidate();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.xB = savedState.dWx;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.dWx = this.xB;
        return savedState;
    }
}
