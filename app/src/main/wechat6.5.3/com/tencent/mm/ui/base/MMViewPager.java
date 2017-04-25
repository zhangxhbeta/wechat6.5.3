package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;

public class MMViewPager extends WxViewPager {
    private int aah;
    private int aai;
    private OnTouchListener dPb;
    private int eww;
    private int ewx;
    private VelocityTracker fj;
    private GestureDetector fjR;
    private float gpp = 0.0f;
    private ac handler = new ac(Looper.getMainLooper());
    private float jRo = 0.0f;
    private boolean jRp = false;
    private boolean jRq = false;
    private boolean jRr = false;
    private MultiTouchImageView nYR;
    private k nYS;
    private boolean nYT = false;
    private boolean nYU = false;
    private boolean nYV = false;
    private boolean nYW = false;
    private boolean nYX = false;
    private boolean nYY = false;
    private boolean nYZ = false;
    private boolean nZa = false;
    private boolean nZb = false;
    private boolean nZc = false;
    private float nZd;
    private float nZe;
    private OverScroller nZf;
    private RectF nZg = new RectF();
    private int nZh = 0;
    private a nZi;
    public e nZj;
    public c nZk;
    public android.support.v4.view.ViewPager.e nZl = null;
    private float nZm = 0.0f;
    private MotionEvent nZn;
    private long nZo = 0;
    public b nZp;
    private final int nZq = 60;
    private final int nZr = 500;

    private abstract class a {
        final /* synthetic */ MMViewPager nZs;
        protected boolean nZt = false;

        public abstract void play();

        public a(MMViewPager mMViewPager) {
            this.nZs = mMViewPager;
        }

        public final boolean bnj() {
            return this.nZt;
        }
    }

    public interface b {
        void x(float f, float f2);

        void y(float f, float f2);
    }

    public interface c {
        void amC();
    }

    private class d extends SimpleOnGestureListener {
        final /* synthetic */ MMViewPager nZs;

        private d(MMViewPager mMViewPager) {
            this.nZs = mMViewPager;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (this.nZs.nZj != null) {
                this.nZs.nZj.abF();
            }
            return true;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            if (this.nZs.nZf != null) {
                this.nZs.nZf.forceFinished(true);
            }
            return super.onDown(motionEvent);
        }

        public final void onLongPress(MotionEvent motionEvent) {
            this.nZs.jRr = true;
            if (this.nZs.nZk != null) {
                this.nZs.nZk.amC();
            }
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            if (this.nZs.nYR == null) {
                return false;
            }
            if (this.nZs.nYR.getScale() <= this.nZs.nYR.iBk) {
                this.nZs.nYR.A(f.i(motionEvent, 0), f.j(motionEvent, 0));
            } else {
                this.nZs.nYR.z(f.i(motionEvent, 0), f.j(motionEvent, 0));
            }
            return true;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            v.d("MicroMsg.MMViewPager", "onFling");
            MultiTouchImageView g = ((t) this.nZs.xA).lo(this.nZs.xB);
            if (g != null) {
                v.d("MicroMsg.MMViewPager", "onFling MultiTouchImageView");
                g = g;
                float scale = g.getScale() * ((float) g.imageWidth);
                float scale2 = g.getScale() * ((float) g.imageHeight);
                if (g.oae || g.oaf || ((int) scale) > this.nZs.eww || ((int) scale2) > this.nZs.ewx) {
                    float f3;
                    r6 = new float[9];
                    g.getImageMatrix().getValues(r6);
                    float f4 = r6[2];
                    float f5 = f4 + scale;
                    float f6 = r6[5];
                    float f7 = f6 + scale2;
                    v.d("MicroMsg.MMViewPager", "left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", Float.valueOf(f4), Float.valueOf(f5), Boolean.valueOf(MMViewPager.a(motionEvent, motionEvent2)), Float.valueOf(f), Float.valueOf(f2));
                    if (((float) Math.round(f4)) >= this.nZs.nZg.left || ((float) Math.round(f5)) <= this.nZs.nZg.right) {
                        f3 = 0.0f;
                    } else {
                        f3 = f;
                    }
                    if (((float) Math.round(f6)) >= this.nZs.nZg.top || ((float) Math.round(f7)) <= this.nZs.nZg.bottom) {
                        f2 = 0.0f;
                    }
                    int i = (int) (this.nZs.nZg.right - scale);
                    int i2 = (int) (scale + this.nZs.nZg.right);
                    int i3 = (int) (this.nZs.nZg.bottom - scale2);
                    int i4 = (int) (this.nZs.nZg.bottom + scale2);
                    if (f3 >= 0.0f) {
                        if (Math.abs(f3) >= ((float) this.nZs.nZh)) {
                            f3 = (float) this.nZs.nZh;
                        }
                        f6 = f3;
                    } else {
                        f6 = Math.abs(f) >= ((float) this.nZs.nZh) ? (float) (-this.nZs.nZh) : f;
                    }
                    if (f2 >= 0.0f) {
                        if (Math.abs(f2) >= ((float) this.nZs.nZh)) {
                            f2 = (float) this.nZs.nZh;
                        }
                    } else if (Math.abs(f2) >= ((float) this.nZs.nZh)) {
                        f2 = (float) (-this.nZs.nZh);
                    }
                    this.nZs.nZf.fling(this.nZs.nZf.getCurrX(), this.nZs.nZf.getCurrY(), (int) f6, (int) f2, i, i2, i3, i4, 0, 0);
                    if ((!MMViewPager.a(motionEvent, motionEvent2) || f4 < 0.0f) && (MMViewPager.a(motionEvent, motionEvent2) || f5 > ((float) this.nZs.eww))) {
                        return false;
                    }
                }
            }
            if (this.nZs.nYT) {
                return false;
            }
            return MMViewPager.a(this.nZs, motionEvent, motionEvent2, f);
        }
    }

    public interface e {
        void abF();

        void aqZ();
    }

    private class f extends a {
        final /* synthetic */ MMViewPager nZs;
        float[] nZu = new float[9];

        public f(MMViewPager mMViewPager) {
            this.nZs = mMViewPager;
            super(mMViewPager);
        }

        public final void play() {
            this.nZs.handler.post(new Runnable(this) {
                final /* synthetic */ f nZv;

                {
                    this.nZv = r1;
                }

                public final void run() {
                    this.nZv.nZs.nYR.getImageMatrix().getValues(this.nZv.nZu);
                    float scale = ((float) this.nZv.nZs.nYR.imageHeight) * this.nZv.nZs.nYR.getScale();
                    float f = this.nZv.nZu[5] + scale;
                    float d = (float) this.nZv.nZs.ewx;
                    if (scale < ((float) this.nZv.nZs.ewx)) {
                        d = (((float) this.nZv.nZs.ewx) / 2.0f) + (scale / 2.0f);
                    }
                    d -= f;
                    if (d <= 0.0f) {
                        this.nZv.nZt = true;
                    } else if (Math.abs(d) <= 5.0f) {
                        this.nZv.nZt = true;
                    } else {
                        d = ((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    this.nZv.nZs.nYR.B(0.0f, d);
                }
            });
        }
    }

    private class g extends a {
        final /* synthetic */ MMViewPager nZs;
        float[] nZu = new float[9];

        public g(MMViewPager mMViewPager) {
            this.nZs = mMViewPager;
            super(mMViewPager);
        }

        public final void play() {
            this.nZs.handler.post(new Runnable(this) {
                final /* synthetic */ g nZw;

                {
                    this.nZw = r1;
                }

                public final void run() {
                    float d;
                    float b;
                    this.nZw.nZs.nYR.getImageMatrix().getValues(this.nZw.nZu);
                    float scale = this.nZw.nZs.nYR.getScale() * ((float) this.nZw.nZs.nYR.imageWidth);
                    float scale2 = this.nZw.nZs.nYR.getScale() * ((float) this.nZw.nZs.nYR.imageHeight);
                    float f = this.nZw.nZu[2];
                    float f2 = this.nZw.nZu[5];
                    float f3 = this.nZw.nZu[2] + scale;
                    float f4 = this.nZw.nZu[5] + scale2;
                    float d2 = (float) this.nZw.nZs.ewx;
                    float b2 = (float) this.nZw.nZs.eww;
                    if (scale2 < ((float) this.nZw.nZs.ewx)) {
                        d2 = (((float) this.nZw.nZs.ewx) / 2.0f) - (scale2 / 2.0f);
                        d = (((float) this.nZw.nZs.ewx) / 2.0f) + (scale2 / 2.0f);
                    } else {
                        float f5 = d2;
                        d2 = 0.0f;
                        d = f5;
                    }
                    d2 -= f2;
                    d -= f4;
                    if (d2 >= 0.0f) {
                        if (d > 0.0f) {
                            d2 = d;
                        } else {
                            d2 = 0.0f;
                        }
                    }
                    if (scale < ((float) this.nZw.nZs.eww)) {
                        d = (((float) this.nZw.nZs.eww) / 2.0f) - (scale / 2.0f);
                        b = (((float) this.nZw.nZs.eww) / 2.0f) + (scale / 2.0f);
                    } else {
                        b = b2;
                        d = 0.0f;
                    }
                    d -= f;
                    b -= f3;
                    if (d >= 0.0f) {
                        if (b > 0.0f) {
                            d = b;
                        } else {
                            d = 0.0f;
                        }
                    }
                    if (Math.abs(d) > 5.0f || Math.abs(d2) > 5.0f) {
                        if (d >= 0.0f) {
                            d = ((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d))) * 2.0f;
                        } else {
                            d = (-((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d)))) * 2.0f;
                        }
                        if (d2 >= 0.0f) {
                            d2 = ((float) (((double) Math.abs(d2)) - Math.pow(Math.sqrt((double) Math.abs(d2)) - 1.0d, 2.0d))) * 2.0f;
                        } else {
                            d2 = (-((float) (((double) Math.abs(d2)) - Math.pow(Math.sqrt((double) Math.abs(d2)) - 1.0d, 2.0d)))) * 2.0f;
                        }
                    } else {
                        this.nZw.nZt = true;
                    }
                    this.nZw.nZs.nYR.B(d, d2);
                }
            });
        }
    }

    private class h extends a {
        final /* synthetic */ MMViewPager nZs;
        float[] nZu = new float[9];

        public h(MMViewPager mMViewPager) {
            this.nZs = mMViewPager;
            super(mMViewPager);
        }

        public final void play() {
            this.nZs.handler.post(new Runnable(this) {
                final /* synthetic */ h nZx;

                {
                    this.nZx = r1;
                }

                public final void run() {
                    this.nZx.nZs.nYR.getImageMatrix().getValues(this.nZx.nZu);
                    float f = this.nZx.nZu[2];
                    float scale = this.nZx.nZs.nYR.getScale() * ((float) this.nZx.nZs.nYR.imageWidth);
                    if (scale < ((float) this.nZx.nZs.eww)) {
                        scale = (((float) this.nZx.nZs.eww) / 2.0f) - (scale / 2.0f);
                    } else {
                        scale = 0.0f;
                    }
                    scale -= f;
                    if (scale >= 0.0f) {
                        this.nZx.nZt = true;
                    } else if (Math.abs(scale) <= 5.0f) {
                        this.nZx.nZt = true;
                    } else {
                        scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    this.nZx.nZs.nYR.B(scale, 0.0f);
                }
            });
        }
    }

    private class i extends a {
        final /* synthetic */ MMViewPager nZs;
        float[] nZu = new float[9];

        public i(MMViewPager mMViewPager) {
            this.nZs = mMViewPager;
            super(mMViewPager);
        }

        public final void play() {
            this.nZs.handler.post(new Runnable(this) {
                final /* synthetic */ i nZy;

                {
                    this.nZy = r1;
                }

                public final void run() {
                    this.nZy.nZs.nYR.getImageMatrix().getValues(this.nZy.nZu);
                    float scale = ((float) this.nZy.nZs.nYR.imageWidth) * this.nZy.nZs.nYR.getScale();
                    float f = this.nZy.nZu[2] + scale;
                    float b = (float) this.nZy.nZs.eww;
                    if (scale < ((float) this.nZy.nZs.eww)) {
                        b = (((float) this.nZy.nZs.eww) / 2.0f) + (scale / 2.0f);
                    }
                    b -= f;
                    if (b <= 0.0f) {
                        this.nZy.nZt = true;
                    } else if (Math.abs(b) <= 5.0f) {
                        this.nZy.nZt = true;
                    } else {
                        b = ((float) (((double) Math.abs(b)) - Math.pow(Math.sqrt((double) Math.abs(b)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    this.nZy.nZs.nYR.B(b, 0.0f);
                }
            });
        }
    }

    private class j extends a {
        final /* synthetic */ MMViewPager nZs;
        float[] nZu = new float[9];

        public j(MMViewPager mMViewPager) {
            this.nZs = mMViewPager;
            super(mMViewPager);
        }

        public final void play() {
            this.nZs.handler.post(new Runnable(this) {
                final /* synthetic */ j nZz;

                {
                    this.nZz = r1;
                }

                public final void run() {
                    this.nZz.nZs.nYR.getImageMatrix().getValues(this.nZz.nZu);
                    float f = this.nZz.nZu[5];
                    float scale = this.nZz.nZs.nYR.getScale() * ((float) this.nZz.nZs.nYR.imageHeight);
                    if (scale < ((float) this.nZz.nZs.ewx)) {
                        scale = (((float) this.nZz.nZs.ewx) / 2.0f) - (scale / 2.0f);
                    } else {
                        scale = 0.0f;
                    }
                    scale -= f;
                    if (scale >= 0.0f) {
                        this.nZz.nZt = true;
                    } else if (Math.abs(scale) <= 5.0f) {
                        this.nZz.nZt = true;
                    } else {
                        scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    this.nZz.nZs.nYR.B(0.0f, scale);
                }
            });
        }
    }

    public static class k extends ac {
        WeakReference<MMViewPager> nZA;
        long nZB;

        public k(WeakReference<MMViewPager> weakReference) {
            this.nZA = weakReference;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            removeMessages(message.what);
            if (this.nZA != null) {
                MMViewPager mMViewPager = (MMViewPager) this.nZA.get();
                if (mMViewPager != null && message.what == 1) {
                    if (mMViewPager.nZi == null || mMViewPager.nZi.bnj()) {
                        mMViewPager.bCF();
                        return;
                    }
                    mMViewPager.nZi.play();
                    sendEmptyMessageDelayed(message.what, this.nZB);
                }
            }
        }
    }

    static /* synthetic */ boolean a(MMViewPager mMViewPager, MotionEvent motionEvent) {
        if (mMViewPager.fj == null) {
            mMViewPager.fj = VelocityTracker.obtain();
        }
        mMViewPager.fj.addMovement(motionEvent);
        switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
            case 0:
                mMViewPager.gpp = motionEvent.getX();
                mMViewPager.jRo = motionEvent.getY();
                break;
            case 1:
                mMViewPager.jRr = false;
                if (mMViewPager.jRq) {
                    if (mMViewPager.nZp != null) {
                        mMViewPager.nZp.x(0.0f, 0.0f);
                    }
                    mMViewPager.jRp = false;
                    return true;
                } else if (mMViewPager.jRp) {
                    if (mMViewPager.nZj != null) {
                        mMViewPager.nZj.aqZ();
                    }
                    mMViewPager.jRp = false;
                    return true;
                }
                break;
            case 2:
                float x = motionEvent.getX() - mMViewPager.gpp;
                float y = motionEvent.getY() - mMViewPager.jRo;
                VelocityTracker velocityTracker = mMViewPager.fj;
                velocityTracker.computeCurrentVelocity(1000);
                int xVelocity = (int) velocityTracker.getXVelocity();
                int yVelocity = (int) velocityTracker.getYVelocity();
                if (mMViewPager.nZp != null) {
                    mMViewPager.nZp.y(x, y);
                    if ((Math.abs(x) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || mMViewPager.jRr) && !mMViewPager.jRp) {
                        mMViewPager.jRp = false;
                    } else {
                        mMViewPager.nZp.x(x, y);
                        mMViewPager.jRp = true;
                    }
                    if (y > 200.0f) {
                        mMViewPager.jRq = false;
                    } else {
                        mMViewPager.jRq = true;
                    }
                }
                if (mMViewPager.fj != null) {
                    mMViewPager.fj.recycle();
                    mMViewPager.fj = null;
                    break;
                }
                break;
        }
        return false;
    }

    static /* synthetic */ boolean a(MMViewPager mMViewPager, MotionEvent motionEvent, MotionEvent motionEvent2, float f) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        float x = motionEvent.getX() - motionEvent2.getX();
        float y = motionEvent.getY() - motionEvent2.getY();
        boolean a = a(motionEvent, motionEvent2);
        x = Math.abs(x);
        y = Math.abs(y);
        if (Math.abs(f) <= 500.0f || x < 60.0f || x < y) {
            return false;
        }
        if (a) {
            mMViewPager.onKeyDown(21, null);
        } else {
            mMViewPager.onKeyDown(22, null);
        }
        return true;
    }

    static /* synthetic */ boolean a(MMViewPager mMViewPager, MultiTouchImageView multiTouchImageView, MotionEvent motionEvent) {
        if (mMViewPager.fj == null) {
            mMViewPager.fj = VelocityTracker.obtain();
        }
        mMViewPager.fj.addMovement(motionEvent);
        switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
            case 0:
                multiTouchImageView.bCS();
                float[] fArr = new float[9];
                multiTouchImageView.getImageMatrix().getValues(fArr);
                if (((float) Math.round(fArr[5])) < mMViewPager.nZg.top) {
                    mMViewPager.nYU = true;
                } else {
                    mMViewPager.nYU = false;
                }
                mMViewPager.gpp = motionEvent.getX();
                mMViewPager.jRo = motionEvent.getY();
                mMViewPager.nZd = 0.0f;
                mMViewPager.nZe = multiTouchImageView.getScale();
                mMViewPager.nYT = false;
                mMViewPager.nZo = System.currentTimeMillis();
                return false;
            case 1:
                mMViewPager.nYV = false;
                mMViewPager.nYW = false;
                mMViewPager.jRr = false;
                if ((mMViewPager.nZb || mMViewPager.nZc || mMViewPager.nYX || mMViewPager.nYY) && (mMViewPager.nYZ || mMViewPager.nZa)) {
                    mMViewPager.nZi = new g(mMViewPager);
                    mMViewPager.bCG();
                    mMViewPager.nZb = false;
                    mMViewPager.nZc = false;
                    mMViewPager.nYX = false;
                    mMViewPager.nYY = false;
                    mMViewPager.nYZ = false;
                    mMViewPager.nZa = false;
                } else {
                    if (mMViewPager.nYX || mMViewPager.nZb) {
                        mMViewPager.nYX = false;
                        mMViewPager.nZb = false;
                        mMViewPager.nZi = new h(mMViewPager);
                        mMViewPager.bCG();
                    }
                    if (mMViewPager.nYY || mMViewPager.nZc) {
                        mMViewPager.nYY = false;
                        mMViewPager.nZc = false;
                        mMViewPager.nZi = new i(mMViewPager);
                        mMViewPager.bCG();
                    }
                    if (mMViewPager.nYZ) {
                        mMViewPager.nYZ = false;
                        mMViewPager.nZi = new j(mMViewPager);
                        mMViewPager.bCG();
                    }
                    if (mMViewPager.nZa) {
                        mMViewPager.nZa = false;
                        mMViewPager.nZi = new f(mMViewPager);
                        mMViewPager.bCG();
                    }
                }
                mMViewPager.nZd = 0.0f;
                mMViewPager.nZe = multiTouchImageView.getScale();
                if (mMViewPager.jRq) {
                    if (mMViewPager.nZp != null) {
                        mMViewPager.nZp.x(0.0f, 0.0f);
                    }
                    mMViewPager.jRp = false;
                    return false;
                } else if (!mMViewPager.jRp || mMViewPager.nYU) {
                    return false;
                } else {
                    if (mMViewPager.nZj != null) {
                        mMViewPager.nZj.aqZ();
                    }
                    mMViewPager.jRp = false;
                    return true;
                }
            case 2:
                float x;
                float y;
                float f;
                if (f.x(motionEvent) != 2) {
                    x = motionEvent.getX() - mMViewPager.gpp;
                    y = motionEvent.getY() - mMViewPager.jRo;
                    VelocityTracker velocityTracker = mMViewPager.fj;
                    velocityTracker.computeCurrentVelocity(1000);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    int yVelocity = (int) velocityTracker.getYVelocity();
                    if (!(mMViewPager.nZp == null || mMViewPager.nYU || mMViewPager.nYT || mMViewPager.nZe > multiTouchImageView.iBk)) {
                        mMViewPager.nZp.y(x, y);
                        if ((Math.abs(x) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || mMViewPager.jRr) && !mMViewPager.jRp) {
                            mMViewPager.jRp = false;
                        } else {
                            mMViewPager.nZp.x(x, y);
                            mMViewPager.jRp = true;
                        }
                        if (y > 200.0f) {
                            mMViewPager.jRq = false;
                        } else {
                            mMViewPager.jRq = true;
                        }
                    }
                    if (mMViewPager.fj != null) {
                        mMViewPager.fj.recycle();
                        mMViewPager.fj = null;
                    }
                    if (mMViewPager.nZn == null) {
                        return false;
                    }
                    if (mMViewPager.nZn.getAction() != 0 && mMViewPager.nZn.getAction() != 2 && mMViewPager.nZn.getAction() != 5 && mMViewPager.nZn.getAction() != 261) {
                        return false;
                    }
                    boolean z;
                    float i = f.i(mMViewPager.nZn, 0) - f.i(motionEvent, 0);
                    x = f.j(mMViewPager.nZn, 0) - f.j(motionEvent, 0);
                    if (mMViewPager.nYT || mMViewPager.jRp) {
                        z = true;
                    } else if (i == 0.0f && x == 0.0f) {
                        z = true;
                    } else {
                        View wA = ((t) mMViewPager.xA).wA(mMViewPager.xB);
                        float[] fArr2 = new float[9];
                        mMViewPager.nYR.getImageMatrix().getValues(fArr2);
                        float scale = mMViewPager.nYR.getScale() * ((float) mMViewPager.nYR.imageWidth);
                        float scale2 = mMViewPager.nYR.getScale() * ((float) mMViewPager.nYR.imageHeight);
                        float f2 = fArr2[2];
                        float f3 = f2 + scale;
                        float f4 = fArr2[5];
                        float f5 = f4 + scale2;
                        if (((int) scale) > mMViewPager.eww || ((int) scale2) > mMViewPager.ewx) {
                            if (((int) scale) > mMViewPager.eww || ((int) scale2) <= mMViewPager.ewx) {
                                if (((int) scale) <= mMViewPager.eww || ((int) scale2) > mMViewPager.ewx) {
                                    if (Math.abs(x) > Math.abs(i)) {
                                        y = 0.0f;
                                        f = 0.0f;
                                        if (i != 0.0f) {
                                            mMViewPager.nYW = true;
                                            if (i < 0.0f) {
                                                if (f2 > mMViewPager.nZg.left) {
                                                    mMViewPager.nZb = true;
                                                }
                                                if (f2 <= mMViewPager.nZg.left || f3 < ((float) mMViewPager.eww)) {
                                                    y = i;
                                                } else if (f2 > mMViewPager.nZg.left && f2 < ((float) mMViewPager.eww) * 0.3f) {
                                                    y = 0.3f * i;
                                                }
                                            } else {
                                                if (f3 < mMViewPager.nZg.right) {
                                                    mMViewPager.nZc = true;
                                                }
                                                if (f2 > 0.0f || f3 >= ((float) mMViewPager.eww)) {
                                                    y = i;
                                                } else if (f3 > ((float) mMViewPager.eww) * 0.7f && f3 < ((float) mMViewPager.ewx)) {
                                                    y = 0.3f * i;
                                                }
                                            }
                                        }
                                        if (x != 0.0f) {
                                            mMViewPager.nYV = true;
                                            if (x < 0.0f) {
                                                if (f4 > mMViewPager.nZg.top) {
                                                    mMViewPager.nYZ = true;
                                                }
                                                if (f4 <= mMViewPager.nZg.top || f5 < ((float) mMViewPager.ewx)) {
                                                    f = x;
                                                } else if (f4 > mMViewPager.nZg.top && f4 < ((float) mMViewPager.ewx) * 0.3f) {
                                                    f = 0.3f * x;
                                                }
                                            } else {
                                                if (f5 < mMViewPager.nZg.bottom) {
                                                    mMViewPager.nZa = true;
                                                }
                                                if (f4 > 0.0f || f5 >= ((float) mMViewPager.ewx)) {
                                                    f = x;
                                                } else if (f5 > ((float) mMViewPager.ewx) * 0.7f && f5 < ((float) mMViewPager.ewx)) {
                                                    f = 0.3f * x;
                                                }
                                            }
                                        }
                                        mMViewPager.nYR.B(-y, -f);
                                        z = true;
                                    } else if (mMViewPager.a(f2, f3, wA, i)) {
                                        z = true;
                                    } else {
                                        if (i > 0.0f) {
                                            if (f3 <= ((float) mMViewPager.eww)) {
                                                z = mMViewPager.bCH();
                                            }
                                        } else if (f2 >= 0.0f) {
                                            z = mMViewPager.bCH();
                                        }
                                        if (!mMViewPager.nYW || ((((double) mMViewPager.nZm) < 0.06d && i > 0.0f && f3 > ((float) mMViewPager.eww)) || ((((double) mMViewPager.nZm) > 0.94d || mMViewPager.nZm == 0.0f) && i < 0.0f && f2 < 0.0f))) {
                                            f = -i;
                                            if (i < 0.0f) {
                                                if (f2 < 0.0f && f2 - i > 0.0f) {
                                                    y = -f2;
                                                }
                                                y = f;
                                            } else {
                                                if (f3 > ((float) mMViewPager.eww) && f3 - i < ((float) mMViewPager.eww)) {
                                                    y = ((float) mMViewPager.eww) - f3;
                                                }
                                                y = f;
                                            }
                                            f = -x;
                                            if (x < 0.0f) {
                                                if (f4 < 0.0f && f4 + f > 0.0f) {
                                                    f = -f4;
                                                }
                                            } else if (f5 > ((float) mMViewPager.ewx) && f5 + f < ((float) mMViewPager.ewx)) {
                                                f = ((float) mMViewPager.ewx) - f5;
                                            }
                                            mMViewPager.nYR.B(y, f);
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                    }
                                } else if (mMViewPager.a(f2, f3, wA, i)) {
                                    z = true;
                                } else {
                                    if (i > 0.0f) {
                                        if (f3 <= ((float) mMViewPager.eww)) {
                                            z = mMViewPager.bCH();
                                        }
                                    } else if (f2 >= 0.0f) {
                                        z = mMViewPager.bCH();
                                    }
                                    if (!mMViewPager.nYW || ((((double) mMViewPager.nZm) < 0.06d && i > 0.0f && f3 > ((float) mMViewPager.eww)) || ((((double) mMViewPager.nZm) > 0.94d || mMViewPager.nZm == 0.0f) && i < 0.0f && f2 < 0.0f))) {
                                        f = -i;
                                        if (i < 0.0f) {
                                            if (f2 < 0.0f && f2 - i > 0.0f) {
                                                f = -f2;
                                            }
                                        } else if (f3 > ((float) mMViewPager.eww) && f3 - i < ((float) mMViewPager.eww)) {
                                            f = ((float) mMViewPager.eww) - f3;
                                        }
                                        mMViewPager.nYR.B(f, 0.0f);
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                }
                            } else if (Math.abs(x) > Math.abs(i)) {
                                if (mMViewPager.nYW || mMViewPager.nYX || mMViewPager.nYY) {
                                    z = true;
                                } else {
                                    mMViewPager.nYV = true;
                                    f = 0.0f;
                                    if (x < 0.0f) {
                                        if (f4 > mMViewPager.nZg.top) {
                                            mMViewPager.nYZ = true;
                                        }
                                        if (f4 <= mMViewPager.nZg.top || f5 < ((float) mMViewPager.ewx)) {
                                            x = -x;
                                        } else {
                                            if (f4 > mMViewPager.nZg.top && f4 < ((float) mMViewPager.ewx) * 0.3f) {
                                                x = -(x * 0.3f);
                                            }
                                            x = 0.0f;
                                        }
                                    } else {
                                        if (f5 < mMViewPager.nZg.bottom) {
                                            mMViewPager.nZa = true;
                                        }
                                        if (f4 > 0.0f || f5 >= ((float) mMViewPager.ewx)) {
                                            x = -x;
                                        } else {
                                            if (f5 > ((float) mMViewPager.ewx) * 0.7f && f5 < ((float) mMViewPager.ewx)) {
                                                x = -(x * 0.3f);
                                            }
                                            x = 0.0f;
                                        }
                                    }
                                    if (i < 0.0f && f2 > mMViewPager.nZg.left) {
                                        mMViewPager.nZb = true;
                                        f = -(0.3f * i);
                                    } else if (i > 0.0f && f3 < mMViewPager.nZg.right) {
                                        mMViewPager.nZc = true;
                                        f = -(0.3f * i);
                                    }
                                    mMViewPager.nYR.B(f, x);
                                    z = true;
                                }
                            } else if (mMViewPager.a(f2, f3, wA, i)) {
                                z = true;
                            } else {
                                if (i > 0.0f) {
                                    if (f3 <= ((float) mMViewPager.eww)) {
                                        z = mMViewPager.bCH();
                                    }
                                } else if (f2 >= 0.0f) {
                                    z = mMViewPager.bCH();
                                }
                                if (!mMViewPager.nYW) {
                                    f = -i;
                                    if (i < 0.0f) {
                                        if (f2 < 0.0f && f2 - i > 0.0f) {
                                            f = -f2;
                                        }
                                    } else if (f3 > ((float) mMViewPager.eww) && f3 - i < ((float) mMViewPager.eww)) {
                                        f = ((float) mMViewPager.eww) - f3;
                                    }
                                    mMViewPager.nYR.B(f, 0.0f);
                                }
                                z = true;
                            }
                        } else if (mMViewPager.a(f2, f3, wA, i)) {
                            z = true;
                        } else {
                            if (i > 0.0f) {
                                if (f3 <= ((float) mMViewPager.eww)) {
                                    z = mMViewPager.bCH();
                                }
                            } else if (f2 >= 0.0f) {
                                z = mMViewPager.bCH();
                            }
                            if (!mMViewPager.nYW) {
                                f = -i;
                                if (i < 0.0f) {
                                    if (f2 < 0.0f && f2 - i > 0.0f) {
                                        f = -f2;
                                    }
                                } else if (f3 > ((float) mMViewPager.eww) && f3 - i < ((float) mMViewPager.eww)) {
                                    f = ((float) mMViewPager.eww) - f3;
                                }
                                mMViewPager.nYR.B(f, 0.0f);
                            }
                            z = true;
                        }
                    }
                    if (z) {
                        return z;
                    }
                    x = f.i(mMViewPager.nZn, 0);
                    y = f.j(mMViewPager.nZn, 0);
                    mMViewPager.xW = x;
                    mMViewPager.xX = y;
                    return z;
                } else if (System.currentTimeMillis() - mMViewPager.nZo > 500 && (mMViewPager.nYW || mMViewPager.nYX || mMViewPager.nYY)) {
                    return true;
                } else {
                    mMViewPager.nYT = true;
                    f = f.i(motionEvent, 0) - f.i(motionEvent, 1);
                    x = f.j(motionEvent, 0) - f.j(motionEvent, 1);
                    y = (float) Math.sqrt((double) ((f * f) + (x * x)));
                    if (mMViewPager.nZd == 0.0f) {
                        mMViewPager.nZd = y;
                    } else {
                        y /= mMViewPager.nZd;
                        if (mMViewPager.nYT) {
                            multiTouchImageView.g(y * mMViewPager.nZe, f + f.i(motionEvent, 1), x + f.j(motionEvent, 1));
                        }
                    }
                    return true;
                }
            case 5:
                mMViewPager.nZd = 0.0f;
                mMViewPager.nZe = multiTouchImageView.getScale();
                mMViewPager.nYT = true;
                if (mMViewPager.yc) {
                    return true;
                }
                if (!mMViewPager.iB) {
                    mMViewPager.yc = true;
                    super.Y(1);
                    mMViewPager.xW = 0.0f;
                    mMViewPager.wL = 0.0f;
                    if (mMViewPager.fj == null) {
                        mMViewPager.fj = VelocityTracker.obtain();
                    } else {
                        mMViewPager.fj.clear();
                    }
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
                    mMViewPager.fj.addMovement(obtain);
                    obtain.recycle();
                    mMViewPager.oPN = uptimeMillis;
                }
                return true;
            case 6:
                mMViewPager.nZd = 0.0f;
                mMViewPager.nZe = multiTouchImageView.getScale();
                mMViewPager.nYT = true;
                if (mMViewPager.nZe < multiTouchImageView.iBk) {
                    multiTouchImageView.z((f.i(motionEvent, 0) - f.i(motionEvent, 1)) + f.i(motionEvent, 1), (f.j(motionEvent, 0) - f.j(motionEvent, 1)) + f.j(motionEvent, 1));
                }
                if (mMViewPager.nZe <= multiTouchImageView.bCT()) {
                    return false;
                }
                multiTouchImageView.A((f.i(motionEvent, 0) - f.i(motionEvent, 1)) + f.i(motionEvent, 1), (f.j(motionEvent, 0) - f.j(motionEvent, 1)) + f.j(motionEvent, 1));
                return false;
            default:
                return false;
        }
    }

    public MMViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setStaticTransformationsEnabled(true);
    }

    private void bCF() {
        this.nYS.removeMessages(1);
    }

    private void bCG() {
        bCF();
        k kVar = this.nYS;
        kVar.nZB = 15;
        kVar.sendEmptyMessageDelayed(1, 15);
    }

    public final void b(android.support.v4.view.ViewPager.e eVar) {
        this.nZl = eVar;
    }

    public MMViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setStaticTransformationsEnabled(true);
        this.nYS = new k(new WeakReference(this));
        this.fjR = new GestureDetector(context, new d());
        this.nZf = new OverScroller(context, new DecelerateInterpolator(2.0f));
        this.nZh = (int) (getResources().getDisplayMetrics().density * 3000.0f);
        super.b(new android.support.v4.view.ViewPager.e(this) {
            final /* synthetic */ MMViewPager nZs;

            {
                this.nZs = r1;
            }

            public final void W(int i) {
                if (this.nZs.nZl != null) {
                    this.nZs.nZl.W(i);
                }
            }

            public final void a(int i, float f, int i2) {
                if (this.nZs.nZl != null) {
                    this.nZs.nZl.a(i, f, i2);
                }
                this.nZs.nZm = f;
            }

            public final void X(int i) {
                if (this.nZs.nZl != null) {
                    this.nZs.nZl.X(i);
                }
                if (i == 0) {
                    this.nZs.nZm = 0.0f;
                }
            }
        });
        super.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MMViewPager nZs;

            {
                this.nZs = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean onTouch;
                if (this.nZs.dPb != null) {
                    onTouch = this.nZs.dPb.onTouch(view, motionEvent);
                } else {
                    onTouch = false;
                }
                MultiTouchImageView g = ((t) this.nZs.xA).lo(this.nZs.xB);
                if (g == null) {
                    MMViewPager.a(this.nZs, motionEvent);
                    this.nZs.nZn = null;
                    this.nZs.fjR.onTouchEvent(motionEvent);
                    return (this.nZs.nYT || this.nZs.jRp) ? true : onTouch;
                } else {
                    this.nZs.nYR = g;
                    boolean a = MMViewPager.a(this.nZs, this.nZs.nYR, motionEvent);
                    if (this.nZs.nZn != null) {
                        this.nZs.nZn.recycle();
                    }
                    this.nZs.nZn = MotionEvent.obtainNoHistory(motionEvent);
                    this.nZs.fjR.onTouchEvent(motionEvent);
                    this.nZs.computeScroll();
                    return a || onTouch;
                }
            }
        });
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.dPb = onTouchListener;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.eww = MeasureSpec.getSize(i);
        this.ewx = MeasureSpec.getSize(i2);
        this.nZg.set(0.0f, 0.0f, (float) this.eww, (float) this.ewx);
    }

    private boolean bCH() {
        if (this.nYV) {
            return true;
        }
        this.nYW = true;
        return false;
    }

    private boolean a(float f, float f2, View view, float f3) {
        boolean z;
        if (this.xA.j(view) == bCJ()) {
            if (this.nYY) {
                if (f3 > 0.0f) {
                    if (f2 >= ((float) this.eww)) {
                        this.nYR.B(-f3, 0.0f);
                    } else if (f2 > ((float) this.eww) * 0.7f && f2 < ((float) this.ewx)) {
                        this.nYR.B(-(f3 * 0.3f), 0.0f);
                        z = true;
                    }
                }
                z = false;
            } else if (f3 > 0.0f) {
                if (f2 < ((float) this.eww)) {
                    this.nYY = true;
                }
                if (f2 >= ((float) this.eww)) {
                    this.nYR.B(-f3, 0.0f);
                } else if (f2 > ((float) this.eww) * 0.7f && f2 < ((float) this.ewx)) {
                    this.nYR.B(-(f3 * 0.3f), 0.0f);
                    z = true;
                }
            }
            if (z) {
                return true;
            }
            if (this.xA.j(view) == bCI()) {
                if (this.nYX) {
                    if (f3 < 0.0f) {
                        if (f > this.nZg.left) {
                            this.nYR.B(-f3, 0.0f);
                        } else if (f > this.nZg.left && f < ((float) this.eww) * 0.3f) {
                            this.nYR.B(-(f3 * 0.3f), 0.0f);
                            z = true;
                        }
                    }
                    z = false;
                } else if (f3 < 0.0f) {
                    if (f > 0.0f) {
                        this.nYX = true;
                    }
                    if (f > this.nZg.left) {
                        this.nYR.B(-f3, 0.0f);
                    } else if (f > this.nZg.left && f < ((float) this.eww) * 0.3f) {
                        this.nYR.B(-(f3 * 0.3f), 0.0f);
                        z = true;
                    }
                }
                if (z) {
                    return false;
                }
                return true;
            }
            if (!this.nYW || this.nYV) {
                z = false;
            } else {
                this.nYX = false;
                z = false;
            }
            if (z) {
                return true;
            }
            return false;
        }
        if (this.nYW || this.nYV) {
            z = false;
        } else {
            this.nYY = false;
            z = false;
        }
        if (z) {
            return true;
        }
        if (this.xA.j(view) == bCI()) {
            if (this.nYX) {
                if (f3 < 0.0f) {
                    if (f > this.nZg.left) {
                        this.nYR.B(-(f3 * 0.3f), 0.0f);
                        z = true;
                    } else {
                        this.nYR.B(-f3, 0.0f);
                    }
                }
                z = false;
            } else if (f3 < 0.0f) {
                if (f > 0.0f) {
                    this.nYX = true;
                }
                if (f > this.nZg.left) {
                    this.nYR.B(-(f3 * 0.3f), 0.0f);
                    z = true;
                } else {
                    this.nYR.B(-f3, 0.0f);
                }
            }
            if (z) {
                return false;
            }
            return true;
        }
        if (this.nYW) {
        }
        z = false;
        if (z) {
            return true;
        }
        return false;
    }

    public final void a(t tVar) {
        if (tVar instanceof t) {
            super.a(tVar);
            return;
        }
        throw new IllegalArgumentException("must be MMViewPagerAdapter");
    }

    private static boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return motionEvent.getX() - motionEvent2.getX() < 0.0f;
    }

    public void computeScroll() {
        int i = 0;
        super.computeScroll();
        if (this.nYR != null) {
            float scale = this.nYR.getScale() * ((float) this.nYR.imageWidth);
            float scale2 = this.nYR.getScale() * ((float) this.nYR.imageHeight);
            if (this.nZf.computeScrollOffset()) {
                int currX = this.nZf.getCurrX() - this.aah;
                int currY = this.nZf.getCurrY() - this.aai;
                this.aah = this.nZf.getCurrX();
                this.aai = this.nZf.getCurrY();
                float[] fArr = new float[9];
                this.nYR.getImageMatrix().getValues(fArr);
                float f = fArr[2];
                scale += f;
                float f2 = fArr[5];
                float f3 = f2 + scale2;
                if (currX < 0 && ((float) currX) < this.nZg.right - ((float) Math.round(scale))) {
                    currX = (int) (this.nZg.right - ((float) Math.round(scale)));
                }
                if (currX > 0 && ((float) currX) > this.nZg.left - ((float) Math.round(f))) {
                    currX = (int) (this.nZg.left - ((float) Math.round(f)));
                }
                if (currY < 0 && ((float) currY) < this.nZg.bottom - ((float) Math.round(f3))) {
                    currY = (int) (this.nZg.bottom - ((float) Math.round(f3)));
                }
                if (currY > 0 && ((float) currY) > this.nZg.top - ((float) Math.round(f2))) {
                    currY = (int) (this.nZg.top - ((float) Math.round(f2)));
                }
                if (((float) Math.round(f)) >= this.nZg.left || ((float) Math.round(scale)) <= this.nZg.right) {
                    currX = 0;
                } else if (((float) Math.round(f2)) >= this.nZg.top || ((float) Math.round(f3)) <= this.nZg.bottom) {
                    currY = 0;
                }
                if (scale2 >= ((float) this.ewx)) {
                    i = currY;
                }
                this.nYR.B((float) currX, (float) i);
                postInvalidate();
            }
        }
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            super.onFocusChanged(z, i, rect);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            super.onWindowFocusChanged(z);
        }
    }

    public boolean isFocused() {
        return true;
    }

    public final int bCI() {
        int bCI = ((t) this.xA).bCI();
        return bCI >= 0 ? bCI : super.bCI();
    }

    public final int bCJ() {
        int bCJ = ((t) this.xA).bCJ();
        return bCJ >= 0 ? bCJ : super.bCJ();
    }
}
