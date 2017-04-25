package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Gallery;
import android.widget.OverScroller;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;

public class MMGestureGallery extends Gallery {
    private int aah;
    private int aai;
    private int count = 0;
    private int eww;
    private int ewx;
    private VelocityTracker fj;
    private float gpp = 0.0f;
    private ac handler = new ac(Looper.getMainLooper());
    private float jRo = 0.0f;
    private boolean jRp = false;
    private boolean jRq = false;
    private boolean jRr = false;
    private long nBK = 0;
    private MultiTouchImageView nYR;
    private boolean nYT = false;
    public boolean nYU = false;
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
    private final int nZq = 60;
    private final int nZr = 500;
    private GestureDetector oTd;
    public l oTe;
    public l oTf;
    public l oTg;
    private long oTh = 0;
    private float oTi = 0.0f;
    private float oTj = 0.0f;
    private long oTk = 0;
    private a oTl;
    public f oTm;
    public c oTn;
    public e oTo;
    public boolean oTp = true;
    public b oTq;

    private abstract class a {
        protected boolean nZt = false;
        final /* synthetic */ MMGestureGallery oTr;

        public abstract void play();

        public a(MMGestureGallery mMGestureGallery) {
            this.oTr = mMGestureGallery;
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
        final /* synthetic */ MMGestureGallery oTr;

        private d(MMGestureGallery mMGestureGallery) {
            this.oTr = mMGestureGallery;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            return true;
        }
    }

    public interface e {
        void aXb();
    }

    public interface f {
        void abF();
    }

    private class g extends a {
        float[] nZu = new float[9];
        final /* synthetic */ MMGestureGallery oTr;

        public g(MMGestureGallery mMGestureGallery) {
            this.oTr = mMGestureGallery;
            super(mMGestureGallery);
        }

        public final void play() {
            this.oTr.handler.post(new Runnable(this) {
                final /* synthetic */ g oTs;

                {
                    this.oTs = r1;
                }

                public final void run() {
                    this.oTs.oTr.nYR.getImageMatrix().getValues(this.oTs.nZu);
                    float scale = ((float) this.oTs.oTr.nYR.imageHeight) * this.oTs.oTr.nYR.getScale();
                    float f = this.oTs.nZu[5] + scale;
                    float d = (float) this.oTs.oTr.ewx;
                    if (scale < ((float) this.oTs.oTr.ewx)) {
                        d = (((float) this.oTs.oTr.ewx) / 2.0f) + (scale / 2.0f);
                    }
                    d -= f;
                    if (d <= 0.0f) {
                        this.oTs.nZt = true;
                    } else if (Math.abs(d) <= 5.0f) {
                        this.oTs.nZt = true;
                    } else {
                        d = ((float) (((double) Math.abs(d)) - Math.pow(Math.sqrt((double) Math.abs(d)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    this.oTs.oTr.nYR.B(0.0f, d);
                }
            });
        }
    }

    private class h extends a {
        float[] nZu = new float[9];
        final /* synthetic */ MMGestureGallery oTr;

        public h(MMGestureGallery mMGestureGallery) {
            this.oTr = mMGestureGallery;
            super(mMGestureGallery);
        }

        public final void play() {
            this.oTr.handler.post(new Runnable(this) {
                final /* synthetic */ h oTt;

                {
                    this.oTt = r1;
                }

                public final void run() {
                    float d;
                    float b;
                    this.oTt.oTr.nYR.getImageMatrix().getValues(this.oTt.nZu);
                    float scale = this.oTt.oTr.nYR.getScale() * ((float) this.oTt.oTr.nYR.imageWidth);
                    float scale2 = this.oTt.oTr.nYR.getScale() * ((float) this.oTt.oTr.nYR.imageHeight);
                    float f = this.oTt.nZu[2];
                    float f2 = this.oTt.nZu[5];
                    float f3 = this.oTt.nZu[2] + scale;
                    float f4 = this.oTt.nZu[5] + scale2;
                    float d2 = (float) this.oTt.oTr.ewx;
                    float b2 = (float) this.oTt.oTr.eww;
                    if (scale2 < ((float) this.oTt.oTr.ewx)) {
                        d2 = (((float) this.oTt.oTr.ewx) / 2.0f) - (scale2 / 2.0f);
                        d = (((float) this.oTt.oTr.ewx) / 2.0f) + (scale2 / 2.0f);
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
                    if (scale < ((float) this.oTt.oTr.eww)) {
                        d = (((float) this.oTt.oTr.eww) / 2.0f) - (scale / 2.0f);
                        b = (((float) this.oTt.oTr.eww) / 2.0f) + (scale / 2.0f);
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
                        this.oTt.nZt = true;
                    }
                    this.oTt.oTr.nYR.B(d, d2);
                }
            });
        }
    }

    private class i extends a {
        float[] nZu = new float[9];
        final /* synthetic */ MMGestureGallery oTr;

        public i(MMGestureGallery mMGestureGallery) {
            this.oTr = mMGestureGallery;
            super(mMGestureGallery);
        }

        public final void play() {
            this.oTr.handler.post(new Runnable(this) {
                final /* synthetic */ i oTu;

                {
                    this.oTu = r1;
                }

                public final void run() {
                    this.oTu.oTr.nYR.getImageMatrix().getValues(this.oTu.nZu);
                    float f = this.oTu.nZu[2];
                    float scale = this.oTu.oTr.nYR.getScale() * ((float) this.oTu.oTr.nYR.imageWidth);
                    if (scale < ((float) this.oTu.oTr.eww)) {
                        scale = (((float) this.oTu.oTr.eww) / 2.0f) - (scale / 2.0f);
                    } else {
                        scale = 0.0f;
                    }
                    scale -= f;
                    if (scale >= 0.0f) {
                        this.oTu.nZt = true;
                    } else if (Math.abs(scale) <= 5.0f) {
                        this.oTu.nZt = true;
                    } else {
                        scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    this.oTu.oTr.nYR.B(scale, 0.0f);
                }
            });
        }
    }

    private class j extends a {
        float[] nZu = new float[9];
        final /* synthetic */ MMGestureGallery oTr;

        public j(MMGestureGallery mMGestureGallery) {
            this.oTr = mMGestureGallery;
            super(mMGestureGallery);
        }

        public final void play() {
            this.oTr.handler.post(new Runnable(this) {
                final /* synthetic */ j oTv;

                {
                    this.oTv = r1;
                }

                public final void run() {
                    this.oTv.oTr.nYR.getImageMatrix().getValues(this.oTv.nZu);
                    float scale = ((float) this.oTv.oTr.nYR.imageWidth) * this.oTv.oTr.nYR.getScale();
                    float f = this.oTv.nZu[2] + scale;
                    float b = (float) this.oTv.oTr.eww;
                    if (scale < ((float) this.oTv.oTr.eww)) {
                        b = (((float) this.oTv.oTr.eww) / 2.0f) + (scale / 2.0f);
                    }
                    b -= f;
                    if (b <= 0.0f) {
                        this.oTv.nZt = true;
                    } else if (Math.abs(b) <= 5.0f) {
                        this.oTv.nZt = true;
                    } else {
                        b = ((float) (((double) Math.abs(b)) - Math.pow(Math.sqrt((double) Math.abs(b)) - 1.0d, 2.0d))) * 2.0f;
                    }
                    this.oTv.oTr.nYR.B(b, 0.0f);
                }
            });
        }
    }

    private class k extends a {
        float[] nZu = new float[9];
        final /* synthetic */ MMGestureGallery oTr;

        public k(MMGestureGallery mMGestureGallery) {
            this.oTr = mMGestureGallery;
            super(mMGestureGallery);
        }

        public final void play() {
            this.oTr.handler.post(new Runnable(this) {
                final /* synthetic */ k oTw;

                {
                    this.oTw = r1;
                }

                public final void run() {
                    this.oTw.oTr.nYR.getImageMatrix().getValues(this.oTw.nZu);
                    float f = this.oTw.nZu[5];
                    float scale = this.oTw.oTr.nYR.getScale() * ((float) this.oTw.oTr.nYR.imageHeight);
                    if (scale < ((float) this.oTw.oTr.ewx)) {
                        scale = (((float) this.oTw.oTr.ewx) / 2.0f) - (scale / 2.0f);
                    } else {
                        scale = 0.0f;
                    }
                    scale -= f;
                    if (scale >= 0.0f) {
                        this.oTw.nZt = true;
                    } else if (Math.abs(scale) <= 5.0f) {
                        this.oTw.nZt = true;
                    } else {
                        scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
                    }
                    this.oTw.oTr.nYR.B(0.0f, scale);
                }
            });
        }
    }

    public static class l extends ac {
        WeakReference<MMGestureGallery> nZA;
        private long nZB;
        private boolean oTx;

        public l(WeakReference<MMGestureGallery> weakReference) {
            this.nZA = weakReference;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            removeMessages(message.what);
            if (this.nZA != null) {
                final MMGestureGallery mMGestureGallery = (MMGestureGallery) this.nZA.get();
                if (mMGestureGallery == null) {
                    return;
                }
                if (message.what == 0) {
                    if (mMGestureGallery.count == 1 || this.oTx) {
                        v.d("MicroMsg.MMGestureGallery", "single click over!");
                        if (mMGestureGallery.oTm != null) {
                            mMGestureGallery.handler.post(new Runnable(this) {
                                final /* synthetic */ l oTz;

                                public final void run() {
                                    mMGestureGallery.oTm.abF();
                                }
                            });
                        }
                    }
                    mMGestureGallery.count = 0;
                } else if (message.what != 1) {
                    removeMessages(2);
                    if (mMGestureGallery.oTn != null) {
                        mMGestureGallery.handler.post(new Runnable(this) {
                            final /* synthetic */ l oTz;

                            public final void run() {
                                mMGestureGallery.oTn.amC();
                            }
                        });
                    }
                } else if (mMGestureGallery.oTl == null || mMGestureGallery.oTl.bnj()) {
                    mMGestureGallery.bCF();
                } else {
                    mMGestureGallery.oTl.play();
                    sendEmptyMessageDelayed(message.what, this.nZB);
                }
            }
        }

        public final void b(int i, long j, long j2) {
            this.nZB = j2;
            sendEmptyMessageDelayed(i, j);
        }

        public final void m(long j, boolean z) {
            this.oTx = z;
            b(0, j, 0);
        }

        public final void release() {
            removeMessages(0);
            removeMessages(1);
            removeMessages(2);
        }
    }

    static /* synthetic */ void y(MMGestureGallery mMGestureGallery) {
        mMGestureGallery.bCF();
        mMGestureGallery.oTe.b(1, 15, 15);
    }

    public MMGestureGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setStaticTransformationsEnabled(true);
    }

    private void bCF() {
        this.oTe.removeMessages(1);
    }

    public MMGestureGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setStaticTransformationsEnabled(true);
        this.oTd = new GestureDetector(context, new d());
        this.oTe = new l(new WeakReference(this));
        this.oTf = new l(new WeakReference(this));
        this.oTg = new l(new WeakReference(this));
        this.nZf = new OverScroller(context, new DecelerateInterpolator(2.0f));
        this.nZh = (int) (getResources().getDisplayMetrics().density * 3000.0f);
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MMGestureGallery oTr;

            {
                this.oTr = r1;
            }

            private void bJn() {
                this.oTr.oTg.removeMessages(2);
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.oTr.fj == null) {
                    this.oTr.fj = VelocityTracker.obtain();
                }
                this.oTr.fj.addMovement(motionEvent);
                View selectedView = this.oTr.getSelectedView();
                if (selectedView instanceof ViewGroup) {
                    selectedView = selectedView.findViewById(2131755053);
                    if (selectedView == null || selectedView.getVisibility() == 8) {
                        if (this.oTr.oTp && this.oTr.oTm != null && motionEvent.getAction() == 1) {
                            ki(true);
                        }
                        return false;
                    }
                    selectedView = selectedView.findViewById(android.support.v7.a.a.f.Jm);
                    if (selectedView == null) {
                        return false;
                    }
                }
                if (selectedView instanceof MultiTouchImageView) {
                    this.oTr.nYR = (MultiTouchImageView) selectedView;
                    v.d("dktest", "MMGestureGallery onTouch event.getAction():" + motionEvent.getAction());
                    if (motionEvent.getAction() == 0) {
                        bJn();
                        this.oTr.oTg.b(2, 500, 0);
                        this.oTr.nYR.bCS();
                        this.oTr.gpp = motionEvent.getX();
                        this.oTr.jRo = motionEvent.getY();
                        this.oTr.nZd = 0.0f;
                        this.oTr.nZe = this.oTr.nYR.getScale();
                        v.d("dktest", "originalScale :" + this.oTr.nZe);
                        this.oTr.nYT = false;
                        this.oTr.count = this.oTr.count + 1;
                        if (this.oTr.count == 1) {
                            this.oTr.nBK = System.currentTimeMillis();
                            this.oTr.oTi = com.tencent.mm.ui.base.f.i(motionEvent, 0);
                            this.oTr.oTj = com.tencent.mm.ui.base.f.j(motionEvent, 0);
                        } else if (this.oTr.count == 2) {
                            this.oTr.oTk = System.currentTimeMillis();
                            if (this.oTr.oTk - this.oTr.oTh >= 350) {
                                this.oTr.count = 1;
                            } else if (Math.abs(this.oTr.oTi - com.tencent.mm.ui.base.f.i(motionEvent, 0)) >= 35.0f || Math.abs(this.oTr.oTj - com.tencent.mm.ui.base.f.j(motionEvent, 0)) >= 35.0f) {
                                this.oTr.count = 1;
                            } else {
                                this.oTr.count = 0;
                                v.d("MicroMsg.MMGestureGallery", "double click!");
                                if (this.oTr.nYR.getScale() <= this.oTr.nYR.iBk) {
                                    this.oTr.nYR.A(com.tencent.mm.ui.base.f.i(motionEvent, 0), com.tencent.mm.ui.base.f.j(motionEvent, 0));
                                } else {
                                    this.oTr.nYR.z(com.tencent.mm.ui.base.f.i(motionEvent, 0), com.tencent.mm.ui.base.f.j(motionEvent, 0));
                                    this.oTr.nYR.bCR();
                                }
                            }
                        }
                    }
                    if (motionEvent.getAction() == 6 || motionEvent.getAction() == 262) {
                        bJn();
                        this.oTr.nZd = 0.0f;
                        this.oTr.nZe = this.oTr.nYR.getScale();
                        this.oTr.nYT = true;
                        if (this.oTr.nZe < this.oTr.nYR.iBk) {
                            this.oTr.nYR.z((com.tencent.mm.ui.base.f.i(motionEvent, 0) - com.tencent.mm.ui.base.f.i(motionEvent, 1)) + com.tencent.mm.ui.base.f.i(motionEvent, 1), (com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1)) + com.tencent.mm.ui.base.f.j(motionEvent, 1));
                        }
                        if (this.oTr.nZe > this.oTr.nYR.bCT()) {
                            this.oTr.nYR.A((com.tencent.mm.ui.base.f.i(motionEvent, 0) - com.tencent.mm.ui.base.f.i(motionEvent, 1)) + com.tencent.mm.ui.base.f.i(motionEvent, 1), (com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1)) + com.tencent.mm.ui.base.f.j(motionEvent, 1));
                        }
                    }
                    if (motionEvent.getAction() == 1) {
                        bJn();
                        this.oTr.nYV = false;
                        this.oTr.nYW = false;
                        this.oTr.jRr = false;
                        if ((this.oTr.nZb || this.oTr.nZc || this.oTr.nYX || this.oTr.nYY) && (this.oTr.nYZ || this.oTr.nZa)) {
                            this.oTr.oTl = new h(this.oTr);
                            MMGestureGallery.y(this.oTr);
                            this.oTr.nZb = false;
                            this.oTr.nZc = false;
                            this.oTr.nYX = false;
                            this.oTr.nYY = false;
                            this.oTr.nYZ = false;
                            this.oTr.nZa = false;
                        } else {
                            if (this.oTr.nYX || this.oTr.nZb) {
                                this.oTr.nYX = false;
                                this.oTr.nZb = false;
                                this.oTr.oTl = new i(this.oTr);
                                MMGestureGallery.y(this.oTr);
                            }
                            if (this.oTr.nYY || this.oTr.nZc) {
                                this.oTr.nYY = false;
                                this.oTr.nZc = false;
                                this.oTr.oTl = new j(this.oTr);
                                MMGestureGallery.y(this.oTr);
                            }
                            if (this.oTr.nYZ) {
                                this.oTr.nYZ = false;
                                this.oTr.oTl = new k(this.oTr);
                                MMGestureGallery.y(this.oTr);
                            }
                            if (this.oTr.nZa) {
                                this.oTr.nZa = false;
                                this.oTr.oTl = new g(this.oTr);
                                MMGestureGallery.y(this.oTr);
                            }
                            if (this.oTr.jRq) {
                                if (this.oTr.oTq != null) {
                                    this.oTr.oTq.x(0.0f, 0.0f);
                                }
                                this.oTr.jRp = false;
                            }
                            if (this.oTr.jRp && !this.oTr.nYU) {
                                this.oTr.oTf.m(0, true);
                                this.oTr.jRp = false;
                            }
                        }
                        this.oTr.nZd = 0.0f;
                        this.oTr.nZe = this.oTr.nYR.getScale();
                        if (this.oTr.count == 1) {
                            this.oTr.oTh = System.currentTimeMillis();
                            if (this.oTr.oTh - this.oTr.nBK >= 350) {
                                this.oTr.count = 0;
                                v.d("MicroMsg.MMGestureGallery", "single long click over!");
                            } else if (Math.abs(this.oTr.oTi - com.tencent.mm.ui.base.f.i(motionEvent, 0)) < 10.0f && Math.abs(this.oTr.oTj - com.tencent.mm.ui.base.f.j(motionEvent, 0)) < 10.0f) {
                                ki(false);
                            }
                        }
                    }
                    if (motionEvent.getAction() == 5 || motionEvent.getAction() == 261) {
                        this.oTr.nZd = 0.0f;
                        this.oTr.nZe = this.oTr.nYR.getScale();
                        this.oTr.nYT = true;
                    }
                    if (motionEvent.getAction() == 2) {
                        float sqrt;
                        if (com.tencent.mm.ui.base.f.x(motionEvent) == 2) {
                            bJn();
                            if (this.oTr.nYW || this.oTr.nYX || this.oTr.nYY) {
                                return true;
                            }
                            this.oTr.nYT = true;
                            this.oTr.count = 0;
                            float i = com.tencent.mm.ui.base.f.i(motionEvent, 0) - com.tencent.mm.ui.base.f.i(motionEvent, 1);
                            float j = com.tencent.mm.ui.base.f.j(motionEvent, 0) - com.tencent.mm.ui.base.f.j(motionEvent, 1);
                            sqrt = (float) Math.sqrt((double) ((i * i) + (j * j)));
                            if (this.oTr.nZd == 0.0f) {
                                this.oTr.nZd = sqrt;
                            } else {
                                sqrt /= this.oTr.nZd;
                                if (this.oTr.nYT) {
                                    this.oTr.nYR.g(sqrt * this.oTr.nZe, i + com.tencent.mm.ui.base.f.i(motionEvent, 1), j + com.tencent.mm.ui.base.f.j(motionEvent, 1));
                                }
                            }
                        } else {
                            VelocityTracker f = this.oTr.fj;
                            f.computeCurrentVelocity(1000);
                            int xVelocity = (int) f.getXVelocity();
                            int yVelocity = (int) f.getYVelocity();
                            sqrt = motionEvent.getX() - this.oTr.gpp;
                            float y = motionEvent.getY() - this.oTr.jRo;
                            if (!(this.oTr.oTq == null || this.oTr.nYU || this.oTr.nYT || this.oTr.nZe > this.oTr.nYR.iBk)) {
                                this.oTr.oTq.y(sqrt, y);
                                if ((Math.abs(sqrt) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || this.oTr.jRr) && !this.oTr.jRp) {
                                    this.oTr.jRp = false;
                                } else {
                                    this.oTr.oTq.x(sqrt, y);
                                    this.oTr.jRp = true;
                                }
                                if (y > 200.0f) {
                                    this.oTr.jRq = false;
                                } else {
                                    this.oTr.jRq = true;
                                }
                            }
                            if (this.oTr.fj != null) {
                                this.oTr.fj.recycle();
                                this.oTr.fj = null;
                            }
                            if (Math.abs(this.oTr.oTi - com.tencent.mm.ui.base.f.i(motionEvent, 0)) > 10.0f || Math.abs(this.oTr.oTj - com.tencent.mm.ui.base.f.j(motionEvent, 0)) > 10.0f) {
                                bJn();
                                this.oTr.count = 0;
                            }
                        }
                    }
                }
                return false;
            }

            private void ki(boolean z) {
                this.oTr.oTf.m(350, z);
            }
        });
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.eww = MeasureSpec.getSize(i);
        this.ewx = MeasureSpec.getSize(i2);
        this.nZg.set(0.0f, 0.0f, (float) this.eww, (float) this.ewx);
        v.v("MicroMsg.MMGestureGallery", "MMGestureGallery width:" + this.eww + " height:" + this.ewx);
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.nYV) {
            return true;
        }
        this.nYW = true;
        if (this.oTo != null) {
            this.oTo.aXb();
        }
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }

    private boolean a(float f, float f2, View view, float f3) {
        boolean z;
        if (this.nYW || this.nYV) {
            z = false;
        } else {
            if (getPositionForView(view) == getAdapter().getCount() - 1) {
                if (this.nYY) {
                    if (f3 > 0.0f) {
                        if (f2 >= ((float) this.eww)) {
                            this.nYR.B(-f3, 0.0f);
                        } else if (f2 > ((float) this.eww) * 0.7f && f2 < ((float) this.ewx)) {
                            this.nYR.B(-(f3 * 0.3f), 0.0f);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (f3 > 0.0f) {
                    if (f2 < ((float) this.eww)) {
                        this.nYY = true;
                    }
                    if (f2 >= ((float) this.eww)) {
                        this.nYR.B(-f3, 0.0f);
                    } else if (f2 > ((float) this.eww) * 0.7f && f2 < ((float) this.ewx)) {
                        this.nYR.B(-(f3 * 0.3f), 0.0f);
                    }
                    z = true;
                }
            }
            this.nYY = false;
            z = false;
        }
        if (z) {
            return true;
        }
        if (this.nYW || this.nYV) {
            z = false;
        } else {
            if (getPositionForView(view) == 0) {
                if (this.nYX) {
                    if (f3 < 0.0f) {
                        if (f > 0.0f && f < ((float) this.eww) * 0.3f) {
                            this.nYR.B(-(f3 * 0.3f), 0.0f);
                        } else if (f <= 0.0f) {
                            this.nYR.B(-f3, 0.0f);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (f3 < 0.0f) {
                    if (f > 0.0f) {
                        this.nYX = true;
                    }
                    if (f > 0.0f && f < ((float) this.eww) * 0.3f) {
                        this.nYR.B(-(f3 * 0.3f), 0.0f);
                    } else if (f <= 0.0f) {
                        this.nYR.B(-f3, 0.0f);
                    }
                    z = true;
                }
            }
            this.nYX = false;
            z = false;
        }
        if (z) {
            return true;
        }
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.nYT || this.jRp) {
            return true;
        }
        View selectedView = getSelectedView();
        if (selectedView instanceof ViewGroup) {
            View findViewById = selectedView.findViewById(2131755053);
            if (findViewById == null || findViewById.getVisibility() == 8) {
                return a(motionEvent, motionEvent2, f, f2);
            }
            selectedView = findViewById.findViewById(android.support.v7.a.a.f.Jm);
            if (selectedView == null) {
                return a(motionEvent, motionEvent2, f, f2);
            }
        }
        if (!(selectedView instanceof MultiTouchImageView)) {
            return a(motionEvent, motionEvent2, f, f2);
        }
        this.nYR = (MultiTouchImageView) selectedView;
        float[] fArr = new float[9];
        this.nYR.getImageMatrix().getValues(fArr);
        float scale = this.nYR.getScale() * ((float) this.nYR.imageWidth);
        float scale2 = this.nYR.getScale() * ((float) this.nYR.imageHeight);
        float f3 = fArr[2];
        float f4 = f3 + scale;
        float f5 = fArr[5];
        float f6 = f5 + scale2;
        this.nYR.getGlobalVisibleRect(new Rect());
        if (((int) scale) > this.eww || ((int) scale2) > this.ewx) {
            if (((int) scale) > this.eww || ((int) scale2) <= this.ewx) {
                if (((int) scale) <= this.eww || ((int) scale2) > this.ewx) {
                    if (Math.abs(f2) > Math.abs(f)) {
                        if (f != 0.0f) {
                            this.nYW = true;
                            if (f < 0.0f) {
                                if (f3 > this.nZg.left) {
                                    this.nZb = true;
                                }
                                if (f3 > this.nZg.left && f4 >= ((float) this.eww)) {
                                    if (f3 > this.nZg.left && f3 < ((float) this.eww) * 0.3f) {
                                        f *= 0.3f;
                                    }
                                }
                                if (f2 != 0.0f) {
                                    this.nYV = true;
                                    if (f2 < 0.0f) {
                                        if (f5 > this.nZg.top) {
                                            this.nYZ = true;
                                        }
                                        if (f5 > this.nZg.top && f6 >= ((float) this.ewx)) {
                                            if (f5 > this.nZg.top && f5 < ((float) this.ewx) * 0.3f) {
                                                f2 *= 0.3f;
                                            }
                                        }
                                        this.nYR.B(-f, -f2);
                                        return true;
                                    }
                                    if (f6 < this.nZg.bottom) {
                                        this.nZa = true;
                                    }
                                    if (f5 <= 0.0f && f6 < ((float) this.ewx)) {
                                        if (f6 > ((float) this.ewx) * 0.7f && f6 < ((float) this.ewx)) {
                                            f2 *= 0.3f;
                                        }
                                    }
                                    this.nYR.B(-f, -f2);
                                    return true;
                                }
                                f2 = 0.0f;
                                this.nYR.B(-f, -f2);
                                return true;
                            }
                            if (f4 < this.nZg.right) {
                                this.nZc = true;
                            }
                            if (f3 <= 0.0f && f4 < ((float) this.eww)) {
                                if (f4 > ((float) this.eww) * 0.7f && f4 < ((float) this.ewx)) {
                                    f *= 0.3f;
                                }
                            }
                            if (f2 != 0.0f) {
                                this.nYV = true;
                                if (f2 < 0.0f) {
                                    if (f6 < this.nZg.bottom) {
                                        this.nZa = true;
                                    }
                                    f2 *= 0.3f;
                                    this.nYR.B(-f, -f2);
                                    return true;
                                }
                                if (f5 > this.nZg.top) {
                                    this.nYZ = true;
                                }
                                f2 *= 0.3f;
                                this.nYR.B(-f, -f2);
                                return true;
                            }
                            f2 = 0.0f;
                            this.nYR.B(-f, -f2);
                            return true;
                        }
                        f = 0.0f;
                        if (f2 != 0.0f) {
                            this.nYV = true;
                            if (f2 < 0.0f) {
                                if (f5 > this.nZg.top) {
                                    this.nYZ = true;
                                }
                                f2 *= 0.3f;
                                this.nYR.B(-f, -f2);
                                return true;
                            }
                            if (f6 < this.nZg.bottom) {
                                this.nZa = true;
                            }
                            f2 *= 0.3f;
                            this.nYR.B(-f, -f2);
                            return true;
                        }
                        f2 = 0.0f;
                        this.nYR.B(-f, -f2);
                        return true;
                    } else if (a(f3, f4, selectedView, f)) {
                        return true;
                    } else {
                        if (f > 0.0f) {
                            if (f4 <= ((float) this.eww)) {
                                return a(motionEvent, motionEvent2, f, 0.0f);
                            }
                        } else if (f3 >= 0.0f) {
                            return a(motionEvent, motionEvent2, f, 0.0f);
                        }
                        if (!this.nYW) {
                            this.nYR.B(-f, -f2);
                        }
                        return true;
                    }
                } else if (a(f3, f4, selectedView, f)) {
                    return true;
                } else {
                    if (f > 0.0f) {
                        if (f4 <= ((float) this.eww)) {
                            return a(motionEvent, motionEvent2, f, 0.0f);
                        }
                    } else if (f3 >= 0.0f) {
                        return a(motionEvent, motionEvent2, f, 0.0f);
                    }
                    if (!this.nYW) {
                        this.nYR.B(-f, 0.0f);
                    }
                    return true;
                }
            } else if (Math.abs(f2) > Math.abs(f)) {
                if (this.nYW || this.nYX || this.nYY) {
                    return true;
                }
                this.nYV = true;
                float f7 = 0.0f;
                float f8 = 0.0f;
                if (f2 < 0.0f) {
                    if (f5 > this.nZg.top) {
                        this.nYZ = true;
                    }
                    if (f5 <= this.nZg.top || f6 < ((float) this.ewx)) {
                        f8 = -f2;
                    } else if (f5 > this.nZg.top && f5 < ((float) this.ewx) * 0.3f) {
                        f8 = -(0.3f * f2);
                    }
                } else {
                    if (f6 < this.nZg.bottom) {
                        this.nZa = true;
                    }
                    if (f5 > 0.0f || f6 >= ((float) this.ewx)) {
                        f8 = -f2;
                    } else if (f6 > ((float) this.ewx) * 0.7f && f6 < ((float) this.ewx)) {
                        f8 = -(0.3f * f2);
                    }
                }
                if (f < 0.0f && f3 > this.nZg.left) {
                    this.nZb = true;
                    f7 = -(0.3f * f);
                } else if (f > 0.0f && f4 < this.nZg.right) {
                    this.nZc = true;
                    f7 = -(0.3f * f);
                }
                this.nYR.B(f7, f8);
                return true;
            } else if (a(f3, f4, selectedView, f)) {
                return true;
            } else {
                if (f > 0.0f) {
                    if (f4 <= ((float) this.eww)) {
                        if (f4 > ((float) this.eww) * 0.7f) {
                            return a(motionEvent, motionEvent2, 0.3f * f, 0.0f);
                        }
                        return a(motionEvent, motionEvent2, 0.0f, 0.0f);
                    }
                } else if (f3 >= 0.0f) {
                    if (f3 < ((float) this.eww) * 0.3f) {
                        return a(motionEvent, motionEvent2, 0.3f * f, 0.0f);
                    }
                    return a(motionEvent, motionEvent2, 0.0f, 0.0f);
                }
                if (!this.nYW) {
                    this.nYR.B(-f, 0.0f);
                }
                return true;
            }
        } else if (a(f3, f4, selectedView, f)) {
            return true;
        } else {
            if (f > 0.0f) {
                if (f4 <= ((float) this.eww)) {
                    return a(motionEvent, motionEvent2, f, 0.0f);
                }
            } else if (f3 >= 0.0f) {
                return a(motionEvent, motionEvent2, f, 0.0f);
            }
            if (!this.nYW) {
                this.nYR.B(-f, 0.0f);
            }
            return true;
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (this.nZf != null) {
            this.nZf.forceFinished(true);
        }
        return super.onDown(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        View selectedView = getSelectedView();
        if (selectedView instanceof ViewGroup) {
            selectedView = selectedView.findViewById(2131755053);
            if (selectedView == null || selectedView.getVisibility() == 8) {
                a(motionEvent, motionEvent2, f);
                return false;
            }
            selectedView = selectedView.findViewById(android.support.v7.a.a.f.Jm);
            if (selectedView == null) {
                a(motionEvent, motionEvent2, f);
                return false;
            }
        }
        if (selectedView instanceof MultiTouchImageView) {
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) selectedView;
            float scale = multiTouchImageView.getScale() * ((float) multiTouchImageView.imageWidth);
            float scale2 = multiTouchImageView.getScale() * ((float) multiTouchImageView.imageHeight);
            if (multiTouchImageView.oae || multiTouchImageView.oaf || ((int) scale) > this.eww || ((int) scale2) > this.ewx) {
                float f3;
                r4 = new float[9];
                multiTouchImageView.getImageMatrix().getValues(r4);
                float f4 = r4[2];
                float f5 = f4 + scale;
                float f6 = r4[5];
                float f7 = f6 + scale2;
                v.d("MicroMsg.MMGestureGallery", "jacks left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", Float.valueOf(f4), Float.valueOf(f5), Boolean.valueOf(a(motionEvent, motionEvent2)), Float.valueOf(f), Float.valueOf(f2));
                if (((float) Math.round(f4)) >= this.nZg.left || ((float) Math.round(f5)) <= this.nZg.right) {
                    f3 = 0.0f;
                } else {
                    f3 = f;
                }
                if (((float) Math.round(f6)) >= this.nZg.top || ((float) Math.round(f7)) <= this.nZg.bottom) {
                    f2 = 0.0f;
                }
                if (((float) Math.round(f6)) < this.nZg.top) {
                    this.nYU = true;
                } else {
                    this.nYU = false;
                }
                int i = (int) (this.nZg.right - scale);
                int i2 = (int) (scale + this.nZg.right);
                int i3 = (int) (this.nZg.bottom - scale2);
                int i4 = (int) (this.nZg.bottom + scale2);
                if (f3 >= 0.0f) {
                    if (Math.abs(f3) >= ((float) this.nZh)) {
                        f3 = (float) this.nZh;
                    }
                    f6 = f3;
                } else {
                    if (Math.abs(f3) >= ((float) this.nZh)) {
                        f3 = (float) (-this.nZh);
                    }
                    f6 = f3;
                }
                if (f2 >= 0.0f) {
                    if (Math.abs(f2) >= ((float) this.nZh)) {
                        f2 = (float) this.nZh;
                    }
                } else if (Math.abs(f2) >= ((float) this.nZh)) {
                    f2 = (float) (-this.nZh);
                }
                this.nZf.forceFinished(true);
                this.nZf.fling(this.nZf.getCurrX(), this.nZf.getCurrY(), (int) f6, (int) f2, i, i2, i3, i4, 0, 0);
                if ((!a(motionEvent, motionEvent2) || f4 < 0.0f) && (a(motionEvent, motionEvent2) || f5 > ((float) this.eww))) {
                    return true;
                }
            }
        }
        if (this.nYT) {
            return true;
        }
        a(motionEvent, motionEvent2, f);
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.jRr = true;
        super.onLongPress(motionEvent);
    }

    private static boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return motionEvent.getX() - motionEvent2.getX() < 0.0f;
    }

    private void a(MotionEvent motionEvent, MotionEvent motionEvent2, float f) {
        float x = motionEvent.getX() - motionEvent2.getX();
        float y = motionEvent.getY() - motionEvent2.getY();
        boolean a = a(motionEvent, motionEvent2);
        x = Math.abs(x);
        y = Math.abs(y);
        if (Math.abs(f) <= 500.0f || x < 60.0f || x < y) {
            return;
        }
        if (a) {
            onKeyDown(21, null);
        } else {
            onKeyDown(22, null);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.oTd.onTouchEvent(motionEvent);
        v.d("dktest", "onTouchEvent event.getAction()" + motionEvent.getAction());
        switch (motionEvent.getAction()) {
            case 1:
                View selectedView = getSelectedView();
                if (selectedView instanceof MultiTouchImageView) {
                    this.nYR = (MultiTouchImageView) selectedView;
                    float scale = this.nYR.getScale() * ((float) this.nYR.imageWidth);
                    float scale2 = this.nYR.getScale() * ((float) this.nYR.imageHeight);
                    if (((int) scale) <= this.eww && ((int) scale2) <= this.ewx) {
                        v.i("dktest", "onTouchEvent width:" + scale + "height:" + scale2);
                        break;
                    }
                    float[] fArr = new float[9];
                    this.nYR.getImageMatrix().getValues(fArr);
                    scale = fArr[5];
                    v.d("dktest", "onTouchEvent top:" + scale + " height:" + scale2 + " bottom:" + (scale + scale2));
                    break;
                }
                break;
        }
        computeScroll();
        return super.onTouchEvent(motionEvent);
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

    public void computeScroll() {
        int i = 0;
        if (this.nYR != null && this.nZf.computeScrollOffset()) {
            int currX = this.nZf.getCurrX() - this.aah;
            int currY = this.nZf.getCurrY() - this.aai;
            this.aah = this.nZf.getCurrX();
            this.aai = this.nZf.getCurrY();
            float scale = this.nYR.getScale() * ((float) this.nYR.imageWidth);
            float scale2 = this.nYR.getScale() * ((float) this.nYR.imageHeight);
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

    public boolean isFocused() {
        return true;
    }
}
