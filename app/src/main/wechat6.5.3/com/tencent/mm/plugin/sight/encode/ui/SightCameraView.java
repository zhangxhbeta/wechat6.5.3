package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.jv;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class SightCameraView extends FrameLayout implements com.tencent.mm.model.d.a, com.tencent.mm.plugin.sight.encode.a.b.a {
    private Animation gMf;
    protected int hoQ;
    protected CameraFrontSightView hwI;
    private long iQs;
    private d iVr;
    protected boolean iYh;
    protected f iZN;
    protected com.tencent.mm.plugin.sight.encode.a.b iZO;
    protected ImageView iZP;
    protected Runnable iZQ;
    protected long iZR;
    protected b iZS;
    protected boolean iZT;
    protected int iZU;
    protected a iZV;
    private ah iZW;
    private int iZX;
    private Runnable iZY;
    private Runnable iZZ;

    public interface a {
        void aQb();
    }

    protected enum b {
        CREATE,
        CHANGED,
        DESTORY
    }

    public abstract void Y(float f);

    protected abstract void aQu();

    protected abstract void aQv();

    protected abstract int aQx();

    protected abstract int aQy();

    protected abstract void aQz();

    protected abstract void ah(String str, boolean z);

    protected abstract void fK(boolean z);

    public abstract boolean isPlaying();

    public final void Z(float f) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = (int) (((float) displayMetrics.widthPixels) / f);
        v.i("MicroMsg.SightCameraView", "resizeLayout width:%d, height:%d, previewRate %f", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Float.valueOf(f));
        postInvalidate();
    }

    public final void pL(int i) {
        this.hoQ = i;
    }

    public final void pM(int i) {
        v.d("MicroMsg.SightCameraView", "setRecordMaxDuring recordMaxDuring : " + i);
        this.iZU = i;
    }

    public SightCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iZR = -1;
        this.iZS = b.DESTORY;
        this.iYh = false;
        this.iZT = false;
        this.hoQ = 320;
        this.iZU = 6500;
        this.iQs = 0;
        this.iZW = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
            final /* synthetic */ SightCameraView jaa;

            {
                this.jaa = r1;
            }

            public final boolean oU() {
                float aPP = ((float) this.jaa.iZO.aPP()) / ((float) this.jaa.iZU);
                if (Float.compare(aPP, 0.0f) > 0 || System.currentTimeMillis() - this.jaa.iQs <= 20000) {
                    if (Float.compare(aPP, 1.0f) <= 0 || this.jaa.iZO.aAk() != com.tencent.mm.plugin.sight.encode.a.b.b.Start) {
                        this.jaa.aa(aPP);
                    } else {
                        this.jaa.iZO.aPO();
                        this.jaa.v(null);
                    }
                    return true;
                }
                v.e("MicroMsg.SightCameraView", "ERROR record duration, %dms !!!", Long.valueOf(20000));
                this.jaa.aPZ();
                return false;
            }
        }, true);
        this.iZX = -1;
        this.iZY = new Runnable(this) {
            final /* synthetic */ SightCameraView jaa;

            {
                this.jaa = r1;
            }

            public final void run() {
                if (this.jaa.iZN != null) {
                    this.jaa.iZO.initialize(this.jaa.iZN.hmy);
                }
            }

            public final String toString() {
                return super.toString() + "|startRecord";
            }
        };
        this.iZZ = new Runnable(this) {
            final /* synthetic */ SightCameraView jaa;

            {
                this.jaa = r1;
            }

            public final void run() {
                if (this.jaa.iZN != null) {
                    this.jaa.iZO.cancel();
                }
            }

            public final String toString() {
                return super.toString() + "|cancelRecord";
            }
        };
        this.iVr = new d();
        if (com.tencent.mm.plugin.sight.base.d.aOR()) {
            inflate(getContext(), 2130904396, this);
        } else {
            inflate(getContext(), 2130904395, this);
        }
        this.iYh = false;
        this.iZT = false;
        this.iZN = new f();
        f fVar = this.iZN;
        v.i("MicroMsg.SightCamera", "init needRotate %s", Boolean.valueOf(false));
        if (p.ceC.cfc) {
            fVar.hmu.lFt = p.ceC.cfe;
            fVar.hmu.lFu = p.ceC.cfd;
            fVar.hmu.lFs = p.ceC.cfh;
        }
        fVar.hmu.lFD = c.getNumberOfCameras();
        fVar.hmu.cdi = 0;
        this.iZP = (ImageView) findViewById(2131759190);
        pN(4);
        this.hwI = (CameraFrontSightView) findViewById(2131755556);
        int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(getContext(), 120);
        this.hwI.cp(fromDPToPix, fromDPToPix);
    }

    public SightCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(com.tencent.mm.plugin.sight.encode.a.b bVar) {
        if (this.iZO != null) {
            this.iZO.cancel();
            this.iZO.reset();
        }
        this.iZO = bVar;
        if (this.iZO != null && this.iZN != null) {
            this.iZO.a((com.tencent.mm.plugin.sight.encode.a.b.a) this);
            this.iZN.iXa = this.iZO.aPS();
        }
    }

    public final void a(a aVar) {
        this.iZV = aVar;
    }

    public final void aa(float f) {
        v.d("MicroMsg.SightCameraView", "update progress %f", Float.valueOf(f));
        if (this.iZX < 0) {
            this.iZX = getResources().getDisplayMetrics().widthPixels;
        }
        if (f < 0.0f) {
            LayoutParams layoutParams = this.iZP.getLayoutParams();
            layoutParams.width = this.iZX;
            this.iZP.setLayoutParams(layoutParams);
        } else if (f > 1.0f) {
            r0 = (this.iZX / 2) - 1;
            r1 = this.iZP.getLayoutParams();
            r1.width = this.iZX - (r0 * 2);
            this.iZP.setLayoutParams(r1);
        } else {
            r0 = (int) ((((float) getResources().getDisplayMetrics().widthPixels) * f) / 2.0f);
            r1 = this.iZP.getLayoutParams();
            r1.width = this.iZX - (r0 * 2);
            this.iZP.setLayoutParams(r1);
        }
    }

    protected final void auD() {
        v.i("MicroMsg.SightCameraView", "start record");
        if (this.iZO == null) {
            throw new IllegalStateException("The mSightMedia must be set!");
        }
        this.iZO.aPQ();
        ak.vA().x(this.iZY);
        fP(false);
        pN(0);
        aa(1.0f);
        setKeepScreenOn(true);
    }

    private void pN(int i) {
        if (this.iZP.getVisibility() != i) {
            if (i == 0) {
                if (this.gMf == null) {
                    this.gMf = new AlphaAnimation(0.0f, 1.0f);
                    this.gMf.setDuration(300);
                }
                this.iZP.startAnimation(this.gMf);
            } else if (this.gMf != null) {
                this.gMf.cancel();
            }
            this.iZP.setVisibility(i);
        }
    }

    public final com.tencent.mm.plugin.sight.encode.a.b.b aQA() {
        return this.iZO.aAk();
    }

    public final boolean aQB() {
        return this.iZO.aPP() < 1000 && (this.iZO.aAk() == com.tencent.mm.plugin.sight.encode.a.b.b.Start || this.iZO.aAk() == com.tencent.mm.plugin.sight.encode.a.b.b.WaitStart || this.iZO.aAk() == com.tencent.mm.plugin.sight.encode.a.b.b.Initialized);
    }

    public final boolean aQC() {
        return this.iZO.getFrameCount() < 12 && (this.iZO.aAk() == com.tencent.mm.plugin.sight.encode.a.b.b.Start || this.iZO.aAk() == com.tencent.mm.plugin.sight.encode.a.b.b.WaitStart || this.iZO.aAk() == com.tencent.mm.plugin.sight.encode.a.b.b.Initialized);
    }

    protected final void aPZ() {
        v.w("MicroMsg.SightCameraView", "cancel record");
        if (this.iZO == null) {
            throw new IllegalStateException("The mSightMedia must be set!");
        }
        ak.vA().btx().removeCallbacks(this.iZY);
        ak.vA().x(this.iZZ);
        this.iZW.QI();
        aa(0.0f);
        pN(4);
        setKeepScreenOn(false);
    }

    protected final void u(Runnable runnable) {
        this.iZQ = runnable;
    }

    protected final void oT() {
        v(this.iZQ);
    }

    private void v(final Runnable runnable) {
        v.i("MicroMsg.SightCameraView", "stop record");
        if (this.iZO == null) {
            throw new IllegalStateException("The mSightMedia must be set!");
        }
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ SightCameraView jaa;

            public final void run() {
                this.jaa.iZO.s(runnable);
            }

            public final String toString() {
                return super.toString() + "|stopRecord";
            }
        });
        this.iZW.QI();
        aa(0.0f);
        pN(4);
        setKeepScreenOn(false);
    }

    public final boolean aQD() {
        return this.iZO.aAk() == com.tencent.mm.plugin.sight.encode.a.b.b.Stop;
    }

    public final boolean pq() {
        return this.iZO.aAk() == com.tencent.mm.plugin.sight.encode.a.b.b.Start;
    }

    public final boolean aQE() {
        return this.iZO.aAk() == com.tencent.mm.plugin.sight.encode.a.b.b.WaitStart || this.iZO.aAk() == com.tencent.mm.plugin.sight.encode.a.b.b.Initialized;
    }

    public final boolean aQF() {
        return this.iZO.aAk() == com.tencent.mm.plugin.sight.encode.a.b.b.WaitSend;
    }

    public void aQw() {
        v.i("MicroMsg.SightCameraView", "openCamera");
        this.iYh = true;
        aQG();
        aQu();
        ak.oJ().pU();
    }

    public final void aLn() {
        v.i("MicroMsg.SightCameraView", "closeCamera");
        aQH();
        this.iYh = false;
        this.iZT = false;
        aQv();
        if (this.iZO != null) {
            this.iZO.reset();
        }
        ak.oJ().pT();
    }

    protected final void aQG() {
        this.iVr.a(this);
    }

    protected final void aQH() {
        this.iVr.aN(false);
    }

    protected final void aQI() {
        v.e("MicroMsg.SightCameraView", "showOpenFailed");
        ad.o(new Runnable(this) {
            final /* synthetic */ SightCameraView jaa;

            {
                this.jaa = r1;
            }

            public final void run() {
                SightCameraView sightCameraView = this.jaa;
                if (!Build.MANUFACTURER.equalsIgnoreCase("meizu") || com.tencent.mm.compatible.e.b.sf()) {
                    com.tencent.mm.sdk.c.b jvVar = new jv();
                    jvVar.bky.type = 2;
                    com.tencent.mm.sdk.c.a.nhr.z(jvVar);
                    if (!jvVar.bkz.bkx) {
                        h f = g.f(sightCameraView.getContext(), 2131235313, 2131231164);
                        if (f == null) {
                            v.e("MicroMsg.SightCameraView", "new dialog failed");
                        } else {
                            f.setCancelable(false);
                            f.setCanceledOnTouchOutside(false);
                            f.show();
                        }
                    }
                }
                this.jaa.aLn();
            }
        });
    }

    protected final void aQJ() {
        v.e("MicroMsg.SightCameraView", "showPreviewFailed");
        ad.o(new Runnable(this) {
            final /* synthetic */ SightCameraView jaa;

            {
                this.jaa = r1;
            }

            public final void run() {
                g.bf(this.jaa.getContext(), this.jaa.getContext().getString(2131235785));
                this.jaa.aLn();
            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0 && this.iYh && this.iZT) {
            v.i("MicroMsg.SightCameraView", "check double click %dms", Long.valueOf(SystemClock.elapsedRealtime() - this.iZR));
            if (SystemClock.elapsedRealtime() - this.iZR < 400) {
                this.iZN.iZy.removeMessages(4354);
                f fVar = this.iZN;
                if (fVar.hmx) {
                    Parameters parameters;
                    try {
                        parameters = fVar.cdl.getParameters();
                    } catch (Throwable e) {
                        v.e("MicroMsg.SightCamera", "getParameters failed %s", e.getMessage());
                        v.a("MicroMsg.SightCamera", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        parameters = null;
                    }
                    if (parameters != null) {
                        v.i("MicroMsg.SightCamera", "trigger zoom, has zoomed %B, isSupported %B", Boolean.valueOf(fVar.hmv), Boolean.valueOf(parameters.isZoomSupported()));
                        if (parameters.isZoomSupported()) {
                            fVar.iZy.removeMessages(4353);
                            if (fVar.hmv) {
                                fVar.iZy.hnf = false;
                                fVar.iZy.hmv = false;
                                fVar.iZy.hne = a.e(parameters) * -1;
                                fVar.iZy.sendMessage(fVar.iZy.obtainMessage(4353, fVar.cdl));
                            } else {
                                fVar.iZy.hnf = false;
                                fVar.iZy.hmv = true;
                                fVar.iZy.hne = a.e(parameters);
                                fVar.iZy.sendMessage(fVar.iZy.obtainMessage(4353, fVar.cdl));
                            }
                            if (!fVar.hmv) {
                                z = true;
                            }
                            fVar.hmv = z;
                        }
                    }
                } else {
                    v.w("MicroMsg.SightCamera", "want to trigger zoom, but current status is not preview");
                }
            } else {
                f fVar2 = this.iZN;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int aQx = aQx();
                int aQy = aQy();
                if (!com.tencent.mm.compatible.util.d.dX(14)) {
                    fVar2.iZy.removeMessages(4354);
                    fVar2.iZy.hnh = x;
                    fVar2.iZy.gLd = y;
                    fVar2.iZy.hni = aQx;
                    fVar2.iZy.hnj = aQy;
                    fVar2.iZy.sendMessageDelayed(fVar2.iZy.obtainMessage(4354, fVar2.cdl), 400);
                }
            }
            this.iZR = SystemClock.elapsedRealtime();
            w(motionEvent.getX(), motionEvent.getY());
        }
        return true;
    }

    protected final void w(float f, float f2) {
        if (!com.tencent.mm.compatible.util.d.dX(14) && this.hwI != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hwI.getLayoutParams();
            layoutParams.leftMargin = ((int) f) - (this.hwI.Zx / 2);
            layoutParams.topMargin = ((int) f2) - (this.hwI.QW / 2);
            this.hwI.setLayoutParams(layoutParams);
            this.hwI.aPX();
        }
    }

    public final void fP(boolean z) {
        if (z) {
            this.iZP.setImageResource(2131689626);
        } else {
            this.iZP.setImageResource(2131690126);
        }
    }

    public final void onStart() {
        v.i("MicroMsg.SightCameraView", "on camera start");
        this.iQs = System.currentTimeMillis();
        this.iZW.ea(20);
    }

    public final void aPT() {
    }

    public final void onStop() {
        v.i("MicroMsg.SightCameraView", "on camera stop");
    }

    public final void onError() {
        v.i("MicroMsg.SightCameraView", "on camera error");
        aPZ();
    }

    public final String aPR() {
        return this.iZO.aPR();
    }

    public final int getDuration() {
        return this.iZO.getDuration();
    }
}
