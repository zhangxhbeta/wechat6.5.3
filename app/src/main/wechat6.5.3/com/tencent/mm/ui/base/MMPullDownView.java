package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public class MMPullDownView extends FrameLayout implements OnGestureListener {
    private static int nXs = 400;
    private static final int nXv = Color.parseColor("#00000000");
    public int bgColor;
    private Context context;
    private GestureDetector hDG;
    private int nTz;
    private int nUU;
    public g nWT;
    public e nWU;
    public int nWV;
    private int nWW;
    private boolean nWX;
    private boolean nWY;
    private boolean nWZ;
    private boolean nXa;
    private boolean nXb;
    private boolean nXc;
    private boolean nXd;
    private boolean nXe;
    public c nXf;
    public d nXg;
    private View nXh;
    private View nXi;
    private int nXj;
    private int nXk;
    private int nXl;
    private boolean nXm;
    public f nXn;
    public boolean nXo;
    public k nXp;
    public boolean nXq;
    public a nXr;
    private ac nXt;
    boolean nXu;
    public boolean nXw;
    private int nXx;
    public int nXy;
    public b nXz;
    private Scroller xF;

    public interface a {
        boolean akz();
    }

    public interface b {
        void aks();
    }

    public interface c {
        boolean agv();
    }

    public interface d {
        boolean agu();
    }

    public interface e {
        boolean agi();
    }

    public interface f {
        void aXT();

        void ac(float f);
    }

    public interface g {
        boolean azp();
    }

    public MMPullDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMPullDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nUU = 1;
        this.nWX = false;
        this.nWY = false;
        this.nWZ = false;
        this.nXa = false;
        this.nXb = true;
        this.nXc = false;
        this.nXd = true;
        this.nXe = true;
        this.nXk = 4;
        this.nXl = 4;
        this.nXm = false;
        this.nXo = true;
        this.nXq = false;
        this.nXt = new ac(this) {
            final /* synthetic */ MMPullDownView nXA;

            {
                this.nXA = r1;
            }

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                switch (this.nXA.nXj) {
                    case 0:
                        if (this.nXA.nWT != null) {
                            this.nXA.nXb = this.nXA.nWT.azp();
                        }
                        if (this.nXA.nXb && this.nXA.nXh.getVisibility() == 0) {
                            this.nXA.scrollTo(0, this.nXA.nWV);
                            break;
                        }
                    case 1:
                        if (this.nXA.nWU != null) {
                            this.nXA.nXb = this.nXA.nWU.agi();
                        }
                        if (this.nXA.nXb && this.nXA.nXi.getVisibility() == 0) {
                            this.nXA.scrollTo(0, this.nXA.nWV);
                            break;
                        }
                }
                v.i("MicroMsg.MMPullDownView", "summerbadcr updateDelayHandler handleMessage loadDataType[%d] loadDataEnd[%b]", Integer.valueOf(this.nXA.nXj), Boolean.valueOf(this.nXA.nXb));
            }
        };
        this.nXu = false;
        this.nXw = false;
        this.bgColor = Color.parseColor("#ffffffff");
        this.nXx = Integer.MIN_VALUE;
        this.nXy = this.bgColor;
        this.xF = new Scroller(context, new AccelerateInterpolator());
        this.nTz = this.nUU;
        this.hDG = new GestureDetector(context, this);
        this.nXp = new k(context);
        this.context = context;
    }

    public final void jo(boolean z) {
        v.d("MicroMsg.MMPullDownView", "setIsTopShowAll showAll[%b], isTopShowAll[%b], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.nXd), be.bur());
        this.nXd = z;
    }

    public final void jp(boolean z) {
        v.d("MicroMsg.MMPullDownView", "setIsBottomShowAll showAll[%b], isTopShowAll[%b], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.nXe), be.bur());
        this.nXe = z;
    }

    public final void jq(boolean z) {
        this.nXk = z ? 0 : 4;
        if (this.nXi != null) {
            this.nXi.setVisibility(this.nXk);
        }
    }

    public final void jr(boolean z) {
        this.nXl = z ? 0 : 4;
        if (this.nXh != null) {
            this.nXh.setVisibility(this.nXl);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        v.d("MicroMsg.MMPullDownView", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (!this.nXm) {
            View inflate = inflate(this.context, 2130903864, null);
            View inflate2 = inflate(this.context, 2130903864, null);
            addView(inflate, 0, new LayoutParams(-1, -2));
            addView(inflate2, new LayoutParams(-1, -2));
            this.nXm = true;
        }
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            inflate2 = getChildAt(i6);
            int measuredHeight = inflate2.getMeasuredHeight();
            if (inflate2.getVisibility() != 8) {
                try {
                    inflate2.layout(0, i5, inflate2.getMeasuredWidth(), i5 + measuredHeight);
                } catch (Throwable e) {
                    v.a("MicroMsg.MMPullDownView", e, "childCount: %d, i:%d, childHeight:%d", Integer.valueOf(childCount), Integer.valueOf(i6), Integer.valueOf(measuredHeight));
                }
                i5 += measuredHeight;
            }
        }
        this.nXh = getChildAt(0);
        this.nXi = getChildAt(getChildCount() - 1);
        this.nXh.setVisibility(this.nXl);
        this.nXi.setVisibility(this.nXk);
        this.nWV = this.nXh.getHeight();
        this.nWW = this.nXi.getHeight();
        this.nXx = this.nWV;
        if (!this.nXc && this.nWV != 0) {
            this.nXc = true;
            scrollTo(0, this.nWV);
        }
    }

    public void computeScroll() {
        if (this.xF.computeScrollOffset()) {
            scrollTo(this.xF.getCurrX(), this.xF.getCurrY());
            postInvalidate();
        } else if (this.nXa) {
            v.d("MicroMsg.MMPullDownView", "summberbadcd computeScroll loadDataBegin true UPDATE_DELAY");
            this.nXa = false;
            this.nXt.sendEmptyMessageDelayed(0, (long) nXs);
        }
        this.xF.isFinished();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.nXr != null) {
            this.nXr.akz();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                if (getScrollY() - this.nWV < 0) {
                    this.nWX = true;
                }
                if (getScrollY() > this.nWW) {
                    this.nWY = true;
                }
                bCm();
                break;
        }
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        k kVar = this.nXp;
        if (kVar.oSY != null) {
            kVar.oSX.onTouchEvent(motionEvent);
        }
        if (!this.nXb) {
            return z;
        }
        if (this.nXg == null) {
            this.nWX = false;
        } else {
            this.nWX = this.nXg.agu();
        }
        if (this.nXf == null) {
            this.nWY = false;
        } else {
            this.nWY = this.nXf.agv();
        }
        if (this.nXl == 0) {
            if (this.nXd) {
                this.nXh.setVisibility(4);
            } else {
                this.nXh.setVisibility(0);
            }
        }
        if (this.nXk == 0) {
            if (this.nXe) {
                this.nXi.setVisibility(4);
            } else {
                this.nXi.setVisibility(0);
            }
        }
        if (motionEvent.getAction() == z) {
            bCm();
            return super.dispatchTouchEvent(motionEvent);
        } else if (motionEvent.getAction() == 3) {
            bCm();
            return this.nXq ? super.dispatchTouchEvent(motionEvent) : false;
        } else if (this.hDG.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
            this.nXu = z;
            return super.dispatchTouchEvent(motionEvent);
        } else {
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (Throwable e) {
                v.a("MicroMsg.MMPullDownView", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                return z;
            }
        }
    }

    public final void js(boolean z) {
        v.i("MicroMsg.MMPullDownView", "summerbadcr forceTopLoadData start[%b] loadDataEnd[%b], isTopShowAll[%b], getScrollY[%d], topView[%s]", Boolean.valueOf(z), Boolean.valueOf(this.nXb), Boolean.valueOf(this.nXd), Integer.valueOf(getScrollY()), this.nXh);
        if (z) {
            if (this.nXd) {
                this.xF.startScroll(0, getScrollY(), 0, this.nWV + (-getScrollY()), 200);
            } else {
                if (this.nXh != null && this.nXh.getVisibility() == 4) {
                    this.xF.startScroll(0, getScrollY(), 0, this.nWV + (-getScrollY()), 200);
                }
                if (this.nXh != null && this.nXh.getVisibility() == 0) {
                    this.xF.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
                }
                this.nXj = 0;
                this.nXa = true;
                this.nXb = false;
            }
            postInvalidate();
        } else if (!this.nXb) {
            this.nXb = true;
            if (this.nXh != null && this.nXh.getVisibility() == 0) {
                scrollTo(0, this.nWV);
            }
        }
    }

    public final void jt(boolean z) {
        v.i("MicroMsg.MMPullDownView", "summerbadcr forceBottomLoadData start[%b] loadDataEnd[%b], isBottomShowAll[%b], getScrollY[%d], bottomView[%s]", Boolean.valueOf(z), Boolean.valueOf(this.nXb), Boolean.valueOf(this.nXe), Integer.valueOf(getScrollY()), this.nXi);
        if (z) {
            if (this.nXe) {
                this.xF.startScroll(0, getScrollY(), 0, this.nWW - getScrollY(), 200);
            } else {
                if (this.nXi != null && this.nXi.getVisibility() == 4) {
                    this.xF.startScroll(0, getScrollY(), 0, this.nWW - getScrollY(), 200);
                }
                if (this.nXi != null && this.nXi.getVisibility() == 0) {
                    this.xF.startScroll(0, getScrollY(), 0, this.nWW + (this.nWW - getScrollY()), 200);
                }
                this.nXj = 1;
                this.nXa = true;
                this.nXb = false;
            }
            postInvalidate();
        } else if (!this.nXb) {
            this.nXb = true;
            if (this.nXi != null && this.nXi.getVisibility() == 0) {
                scrollTo(0, this.nWV);
            }
        }
    }

    private void bCm() {
        if (this.nXn != null) {
            this.nXn.aXT();
        }
        if (getScrollY() - this.nWV < 0) {
            if (this.nXd) {
                this.xF.startScroll(0, getScrollY(), 0, this.nWV + (-getScrollY()), 200);
            } else {
                if (this.nXh.getVisibility() == 4) {
                    this.xF.startScroll(0, getScrollY(), 0, this.nWV + (-getScrollY()), 200);
                }
                if (this.nXh.getVisibility() == 0) {
                    this.xF.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
                }
                this.nXj = 0;
                this.nXa = true;
                this.nXb = false;
            }
            postInvalidate();
        }
        if (getScrollY() > this.nWW) {
            if (this.nXe) {
                this.xF.startScroll(0, getScrollY(), 0, this.nWW - getScrollY(), 200);
            } else {
                if (this.nXi.getVisibility() == 4) {
                    this.xF.startScroll(0, getScrollY(), 0, this.nWW - getScrollY(), 200);
                }
                if (this.nXi.getVisibility() == 0) {
                    this.xF.startScroll(0, getScrollY(), 0, this.nWW + (this.nWW - getScrollY()), 200);
                }
                this.nXj = 1;
                this.nXa = true;
                this.nXb = false;
            }
            postInvalidate();
        }
        this.nWZ = false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (!this.xF.isFinished()) {
            this.xF.abortAnimation();
        }
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        v.v("MicroMsg.MMPullDownView", "on fling, velocityX %f velocityY %f", Float.valueOf(f), Float.valueOf(f2));
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i = -1;
        if (this.nXn != null) {
            this.nXn.ac(f2);
        }
        if (f2 > 0.0f) {
            this.nWZ = true;
        } else {
            this.nWZ = false;
        }
        int i2;
        if (this.nWY && (this.nWZ || getScrollY() - this.nWV > 0)) {
            if (!this.nXo) {
                if (this.nXi.getVisibility() != 0) {
                    return true;
                }
                if (this.nWZ && getScrollY() >= this.nWV * 2) {
                    return true;
                }
            }
            i2 = (int) (((double) f2) * 0.5d);
            if (i2 != 0) {
                i = i2;
            } else if (f2 > 0.0f) {
                i = 1;
            }
            v.v("check", "moveUp:" + i + " distanceY:" + f2 + " scrollY:" + getScrollY());
            if (getScrollY() + i < this.nWV && !this.nWZ) {
                i = this.nWV - getScrollY();
            } else if (!this.nXo && getScrollY() + i >= this.nWV * 2) {
                i = (this.nWV * 2) - getScrollY();
            }
            scrollBy(0, i);
            return true;
        } else if (!this.nWX || (this.nWZ && getScrollY() - this.nWV >= 0)) {
            return false;
        } else {
            if (!this.nXo) {
                if (this.nXh.getVisibility() != 0) {
                    return true;
                }
                if (!this.nWZ && getScrollY() <= 0) {
                    return true;
                }
            }
            i2 = (int) (((double) f2) * 0.5d);
            if (i2 != 0) {
                i = i2;
            } else if (f2 > 0.0f) {
                i = 1;
            }
            if (getScrollY() + i > this.nWV) {
                i = this.nWV - getScrollY();
            } else if (!this.nXo && getScrollY() + i < 0) {
                i = -getScrollY();
            }
            scrollBy(0, i);
            return true;
        }
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.nXz != null) {
            this.nXz.aks();
        }
        if (this.nXw) {
            if (this.nXx == Integer.MIN_VALUE) {
                this.nXx = this.nWV;
                v.d("MicroMsg.MMPullDownView", "onScrollChanged static y:" + this.nXx);
            }
            if (i2 <= this.nXx && this.nXy != nXv) {
                setBackgroundResource(2130838689);
                this.nXy = nXv;
                v.d("MicroMsg.MMPullDownView", "onScrollChanged full");
            } else if (i2 > this.nXx && this.nXy != this.bgColor) {
                v.d("MicroMsg.MMPullDownView", "onScrollChanged white");
                setBackgroundColor(this.bgColor);
                this.nXy = this.bgColor;
            }
        }
    }
}
