package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.al.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.List;

public class ChattingAnimFrame extends FrameLayout {
    private static String fbh = SQLiteDatabase.KeyEmpty;
    private int jqO = 40;
    private int jrs;
    private int jrt;
    private int mScreenHeight = com.tencent.mm.bd.a.dw(getContext());
    List<View> oml = new ArrayList();
    private int omm = 30;
    private int omn = 30;
    private boolean omo = false;
    private int omp = 0;
    private ArrayList<Integer> omq = new ArrayList();

    class a implements AnimationListener {
        final /* synthetic */ ChattingAnimFrame omr;

        a(ChattingAnimFrame chattingAnimFrame) {
            this.omr = chattingAnimFrame;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    private class b extends Animation {
        private float etA;
        private float etB;
        private float etC;
        private float etD;
        private float etE;
        private float etF;
        private int hO = 0;
        final /* synthetic */ ChattingAnimFrame omr;
        private float oms;
        private float omt;
        private float omu;
        private float omv;
        private int omw = 0;
        private boolean omx = false;
        private OnLayoutChangeListener omy = new OnLayoutChangeListener(this) {
            final /* synthetic */ b omz;

            {
                this.omz = r1;
            }

            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.omz.XI();
            }
        };

        public b(ChattingAnimFrame chattingAnimFrame, int i, int i2) {
            this.omr = chattingAnimFrame;
            this.omw = i;
            this.hO = i2;
            this.omx = false;
        }

        public b(ChattingAnimFrame chattingAnimFrame, int i, int i2, boolean z) {
            this.omr = chattingAnimFrame;
            this.omw = i;
            this.hO = i2;
            this.omx = z;
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            switch (this.omw) {
                case 1:
                    this.oms = ChattingAnimFrame.k(0.1f, 0.9f);
                    this.omt = ChattingAnimFrame.k(this.oms - 0.25f, this.oms + 0.25f);
                    this.omu = 1.5f;
                    this.omv = -0.2f;
                    setInterpolator(new LinearInterpolator());
                    break;
                case 2:
                    this.oms = 0.0f;
                    this.omt = 0.0f;
                    this.omu = 0.0f;
                    this.omv = 1.0f;
                    setInterpolator(new com.tencent.mm.ui.c.a.a());
                    break;
                case 3:
                    this.oms = 0.0f;
                    this.omt = 0.0f;
                    this.omu = 1.5f;
                    if (this.omx) {
                        this.omv = ChattingAnimFrame.k(0.4f, 0.55f);
                    } else {
                        this.omv = ChattingAnimFrame.k(0.54999995f, 0.85f);
                    }
                    setInterpolator(new com.tencent.mm.ui.c.a.b());
                    break;
                case TbsLog.TBSLOG_CODE_SDK_INIT /*999*/:
                    this.oms = ChattingAnimFrame.k(0.1f, 0.9f);
                    this.omt = ChattingAnimFrame.k(this.oms - 0.5f, this.oms + 0.5f);
                    this.omu = 0.0f;
                    this.omv = 0.0f;
                    this.etA = 0.8f;
                    this.etB = 1.1f;
                    setInterpolator(new LinearInterpolator());
                    break;
                default:
                    this.oms = ChattingAnimFrame.k(0.1f, 0.9f);
                    this.omt = ChattingAnimFrame.k(this.oms - 0.5f, this.oms + 0.5f);
                    this.omu = -0.2f;
                    this.omv = 1.5f;
                    setInterpolator(new LinearInterpolator());
                    break;
            }
            if (!(this.omw == 0 || this.omw == 1)) {
                this.omr.addOnLayoutChangeListener(this.omy);
            }
            XI();
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            float f2 = this.etC;
            float f3 = this.etE;
            if (this.etC != this.etD) {
                f2 = this.etC + ((this.etD - this.etC) * f);
            }
            if (this.etE != this.etF) {
                f3 = this.etE + ((this.etF - this.etE) * f);
                if (this.omw == 2) {
                    f3 -= (float) this.hO;
                }
            }
            transformation.getMatrix().setTranslate(f2, f3);
            if (this.etA != this.etB && 3 == this.omw) {
                f2 = this.etA + ((this.etB - this.etA) * f);
                transformation.getMatrix().postScale(f2, f2);
            }
        }

        protected final void finalize() {
            super.finalize();
            v.i("MicroMsg.ChattingAnimFrame", "finalize!");
            this.omr.removeOnLayoutChangeListener(this.omy);
        }

        public final void XI() {
            this.etC = this.oms * ((float) this.omr.jrt);
            this.etD = this.omt * ((float) this.omr.jrt);
            if (this.omw == 2) {
                this.etE = this.omu * ((float) this.omr.jrs);
                this.etF = this.omv * ((float) this.omr.jrs);
            } else if (this.omw == 3) {
                this.etE = this.omu * ((float) this.omr.mScreenHeight);
                this.etF = this.omv * ((float) this.omr.mScreenHeight);
                if (this.omr.omo) {
                    this.etE = (this.omu * ((float) this.omr.mScreenHeight)) - ((float) this.omr.omp);
                    this.etF = (this.omv * ((float) this.omr.mScreenHeight)) - ((float) this.omr.omp);
                }
                if (this.etF < 0.0f) {
                    this.etF = 0.0f;
                }
            } else {
                this.etE = this.omu * ((float) this.omr.mScreenHeight);
                this.etF = this.omv * ((float) this.omr.mScreenHeight);
            }
        }
    }

    class c extends AnimationSet {
        View ZP;
        int hO;
        private long omA;
        final /* synthetic */ ChattingAnimFrame omr;

        static /* synthetic */ void a(c cVar) {
            cVar.setStartOffset(cVar.omA);
            cVar.start();
        }

        public c(final ChattingAnimFrame chattingAnimFrame, int i, int i2, long j, boolean z) {
            this.omr = chattingAnimFrame;
            super(false);
            this.hO = i2;
            switch (i) {
                case 0:
                case 1:
                    addAnimation(new b(chattingAnimFrame, i, this.hO));
                    break;
                case 2:
                    addAnimation(new b(chattingAnimFrame, TbsLog.TBSLOG_CODE_SDK_INIT, this.hO));
                    addAnimation(new b(chattingAnimFrame, i, this.hO));
                    break;
                case 3:
                    addAnimation(new b(chattingAnimFrame, i, this.hO, z));
                    addAnimation(new b(chattingAnimFrame, TbsLog.TBSLOG_CODE_SDK_INIT, this.hO));
                    break;
                default:
                    addAnimation(new b(chattingAnimFrame, 0, this.hO));
                    break;
            }
            setAnimationListener(new a(this) {
                final /* synthetic */ c omC;

                public final void onAnimationEnd(Animation animation) {
                    c cVar = this.omC;
                    if (cVar.ZP != null) {
                        cVar.ZP.post(new Runnable(cVar) {
                            final /* synthetic */ c omC;

                            {
                                this.omC = r1;
                            }

                            public final void run() {
                                if (this.omC.ZP != null) {
                                    this.omC.ZP.clearAnimation();
                                    ChattingAnimFrame chattingAnimFrame = this.omC.omr;
                                    View view = this.omC.ZP;
                                    if (view != null && chattingAnimFrame.oml != null) {
                                        chattingAnimFrame.oml.remove(view);
                                        if (chattingAnimFrame.oml.isEmpty()) {
                                            view.setLayerType(0, null);
                                            chattingAnimFrame.removeAllViews();
                                            return;
                                        }
                                        view.setVisibility(4);
                                        view.setLayerType(0, null);
                                    }
                                }
                            }
                        });
                    } else {
                        v.w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
                    }
                }
            });
            this.omA = 500 + j;
            reset();
            setDuration(ChattingAnimFrame.wY(i));
        }
    }

    static /* synthetic */ long wY(int i) {
        switch (i) {
            case 2:
                return 1200;
            case 3:
                return 1500;
            default:
                return (long) ((int) k(4000.0f, 5000.0f));
        }
    }

    public ChattingAnimFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jrs = getMeasuredHeight();
        this.jrt = getMeasuredWidth();
        v.d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", Integer.valueOf(this.jrt), Integer.valueOf(this.jrs));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.jrs = i4 - i2;
        this.jrt = i3 - i;
        if (this.jrs < this.mScreenHeight) {
            this.omo = true;
            this.omp = this.mScreenHeight - this.jrs;
        } else {
            this.omo = false;
            this.omp = 0;
        }
        v.d("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", Integer.valueOf(this.jrt), Integer.valueOf(this.jrs), Boolean.valueOf(this.omo), Integer.valueOf(this.omp));
    }

    public final void a(d dVar) {
        stop();
        if (dVar == null) {
            v.w("MicroMsg.ChattingAnimFrame", "egg info is null. ignore.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (be.kS(fbh)) {
            fbh = e.cnh.replace("/data/user/0", "/data/data");
            fbh += "/emoji";
        }
        String stringBuilder2 = stringBuilder.append(fbh).append("/egg/").append(dVar.cUd).toString();
        if (com.tencent.mm.a.e.aR(stringBuilder2)) {
            setVisibility(0);
            if (dVar.cUf > 0) {
                this.omm = dVar.cUf;
                if (this.omm > 60) {
                    this.omm = 60;
                }
            } else {
                this.omm = 30;
            }
            if (dVar.cUg > 0) {
                this.omn = dVar.cUg;
            } else {
                this.omn = 30;
            }
            if (dVar.maxSize > 0) {
                this.jqO = dVar.maxSize;
            } else {
                this.jqO = 40;
            }
            v.i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", Integer.valueOf(this.omm), Integer.valueOf(this.omn), Integer.valueOf(this.jqO), Integer.valueOf(dVar.cUe), Integer.valueOf(dVar.cTZ));
            long j = 0;
            wX(this.omm);
            int i = 0;
            while (i < this.omm) {
                int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(getContext(), (int) k((float) this.omn, (float) this.jqO));
                int i2 = dVar.cUe;
                boolean z = this.omq != null && this.omq.contains(Integer.valueOf(i));
                Animation cVar = new c(this, i2, fromDPToPix, j, z);
                View mMGIFImageView = new MMGIFImageView(getContext());
                mMGIFImageView.uz(stringBuilder2);
                mMGIFImageView.setAnimation(cVar);
                mMGIFImageView.setLayerType(2, null);
                cVar.ZP = mMGIFImageView;
                mMGIFImageView.setLayoutParams(new LayoutParams(cVar.hO, cVar.hO));
                this.oml.add(mMGIFImageView);
                addView(mMGIFImageView);
                int i3 = dVar.cUe;
                int i4 = this.omm;
                switch (i3) {
                    case 2:
                        j = i < 2 ? 800 + j : ((long) (((Math.abs((((double) i) - (((double) i4) * 0.5d)) - 5.0d) / ((double) (i4 * 3))) + 0.01d) * 1000.0d)) + j;
                        break;
                    case 3:
                        j += (long) (((Math.abs((((double) i) - (((double) i4) * 0.5d)) - 5.0d) / ((double) (i4 * 6))) + 0.06d) * 1000.0d);
                        break;
                    default:
                        j = (long) ((int) (k(0.0f, 4.0f) * 1000.0f));
                        break;
                }
                i++;
            }
            if (this.oml != null) {
                for (View view : this.oml) {
                    if (view != null && (view.getAnimation() instanceof c)) {
                        c.a((c) view.getAnimation());
                    }
                }
                return;
            }
            return;
        }
        v.w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
    }

    private void wX(int i) {
        if (i <= 0) {
            v.w("MicroMsg.ChattingAnimFrame", "count is zero.");
            return;
        }
        int i2 = (int) (((double) i) * 0.1d);
        if (this.omq != null) {
            this.omq.clear();
        } else {
            this.omq = new ArrayList();
        }
        while (this.omq.size() < i2) {
            int k = (int) k(0.0f, (float) i);
            if (!this.omq.contains(Integer.valueOf(k))) {
                this.omq.add(Integer.valueOf(k));
            }
        }
    }

    public final void stop() {
        for (View clearAnimation : this.oml) {
            clearAnimation.clearAnimation();
        }
        removeAllViews();
    }

    static float k(float f, float f2) {
        return (((float) Math.random()) * (f2 - f)) + f;
    }
}
