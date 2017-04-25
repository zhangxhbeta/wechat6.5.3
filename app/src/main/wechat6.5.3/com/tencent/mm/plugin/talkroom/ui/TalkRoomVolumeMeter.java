package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;

public class TalkRoomVolumeMeter extends FrameLayout {
    a kmb;
    private ImageView kmc;
    private ImageView kmd;
    private ImageView kme;
    private FrameLayout kmf;

    private class a extends SurfaceView implements Callback {
        SurfaceHolder dVL = getHolder();
        Paint evR;
        float kmg = 0.0f;
        float kmh = 0.0f;
        Bitmap kmi;
        Bitmap kmj;
        private Bitmap kmk;
        Rect kml;
        int kmm;
        int kmn;
        ah kmo;
        private boolean kmp = false;
        private float kmq = this.kmh;
        float kmr = this.kmh;
        PaintFlagsDrawFilter kms;
        boolean kmt = false;
        private float[] kmu;
        final /* synthetic */ TalkRoomVolumeMeter kmv;
        int max = 100;
        boolean started = false;
        int value = 0;

        static /* synthetic */ void a(a aVar) {
            if (aVar.kmr >= aVar.kmg && aVar.kmr <= aVar.kmh && aVar.kmj != null && aVar.kmi != null) {
                Canvas lockCanvas = aVar.dVL.lockCanvas();
                if (lockCanvas != null && aVar.kml != null) {
                    lockCanvas.setDrawFilter(aVar.kms);
                    float f = aVar.kmr;
                    if (aVar.kmu == null) {
                        aVar.kmu = new float[]{aVar.kmh, aVar.kmh, aVar.kmh, aVar.kmh, aVar.kmh};
                    }
                    int i = 0;
                    while (i < aVar.kmu.length - 1) {
                        aVar.kmu[i] = aVar.kmu[i + 1];
                        i++;
                    }
                    aVar.kmu[i] = f;
                    aVar.kmq = ((((aVar.kmu[0] + (aVar.kmu[1] * 4.0f)) + (aVar.kmu[2] * 6.0f)) + (aVar.kmu[3] * 4.0f)) + (aVar.kmu[4] * 1.0f)) / 16.0f;
                    aVar.kml.set(0, (int) aVar.kmq, aVar.kmn, ((int) aVar.kmq) + aVar.kmm);
                    lockCanvas.drawBitmap(aVar.kmt ? aVar.kmj : aVar.kmi, null, aVar.kml, aVar.evR);
                    aVar.dVL.unlockCanvasAndPost(lockCanvas);
                }
            }
        }

        public a(TalkRoomVolumeMeter talkRoomVolumeMeter, Context context) {
            this.kmv = talkRoomVolumeMeter;
            super(context);
            this.dVL.addCallback(this);
            this.evR = new Paint();
            this.evR.setAntiAlias(true);
            this.kms = new PaintFlagsDrawFilter(0, 3);
            this.kmo = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
                final /* synthetic */ a kmw;

                {
                    this.kmw = r1;
                }

                public final boolean oU() {
                    a.a(this.kmw);
                    return this.kmw.kmp;
                }
            }, true);
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            v.v("MicroMsg.TalkRoomVoiceMeter", "surfaceCreated");
            this.kmi = BitmapFactory.decodeResource(getResources(), 2130839305);
            this.kmk = BitmapFactory.decodeResource(getResources(), 2130839304);
            this.kmj = BitmapFactory.decodeResource(getResources(), 2130839306);
        }

        private int baB() {
            return this.kmi == null ? 190 : this.kmi.getHeight();
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            v.v("MicroMsg.TalkRoomVoiceMeter", "surfaceChanged, width = " + i2 + " height = " + i3);
            this.kmh = 0.0f;
            this.kmg = (float) (i3 - baB());
            this.kmq = this.kmh;
            this.kmr = this.kmh;
            this.kmn = i2;
            this.kmm = baB();
            this.kml = new Rect(0, (int) this.kmq, this.kmn, ((int) this.kmq) + this.kmm);
            this.kmp = true;
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            v.v("MicroMsg.TalkRoomVoiceMeter", "surfaceDestroyed");
            this.kmp = false;
            this.kmo.QI();
            if (this.kmi != null) {
                this.kmi.recycle();
                this.kmi = null;
            }
            if (this.kmk != null) {
                this.kmk.recycle();
                this.kmk = null;
            }
            if (this.kmj != null) {
                this.kmj.recycle();
                this.kmj = null;
            }
        }
    }

    public TalkRoomVolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        NI();
    }

    public TalkRoomVolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        NI();
    }

    private void NI() {
        this.kmb = new a(this, getContext());
        this.kmc = new ImageView(getContext());
        this.kmc.setScaleType(ScaleType.FIT_XY);
        this.kmc.setImageResource(2130839308);
        this.kmc.setVisibility(0);
        this.kmd = new ImageView(getContext());
        this.kmd.setScaleType(ScaleType.FIT_CENTER);
        this.kmd.setImageResource(2130839307);
        this.kmd.setVisibility(8);
        this.kme = new ImageView(getContext());
        this.kme.setScaleType(ScaleType.FIT_CENTER);
        this.kme.setImageResource(2130839304);
        this.kme.setVisibility(8);
        this.kmf = new FrameLayout(getContext());
        this.kmf.addView(this.kmb);
        this.kmf.addView(this.kmd);
        this.kmf.setVisibility(8);
        addView(this.kmf);
        addView(this.kme);
        addView(this.kmc);
        setBackgroundColor(-16777216);
        bringChildToFront(this.kmc);
    }

    public final void gH(boolean z) {
        this.kmf.setVisibility(z ? 0 : 8);
        if (z) {
            a aVar = this.kmb;
            if (!aVar.started) {
                aVar.started = true;
                aVar.kmo.ea(100);
                return;
            }
            return;
        }
        a aVar2 = this.kmb;
        if (aVar2.started) {
            aVar2.started = false;
            if (aVar2.kmr >= aVar2.kmg && aVar2.kmr <= aVar2.kmh && aVar2.kmj != null && aVar2.kmi != null) {
                Canvas lockCanvas = aVar2.dVL.lockCanvas();
                if (!(lockCanvas == null || aVar2.kml == null)) {
                    lockCanvas.setDrawFilter(aVar2.kms);
                    aVar2.kml.set(0, 0, aVar2.kmn, aVar2.kmm + 0);
                    lockCanvas.drawBitmap(aVar2.kmt ? aVar2.kmj : aVar2.kmi, null, aVar2.kml, aVar2.evR);
                    aVar2.dVL.unlockCanvasAndPost(lockCanvas);
                }
            }
            aVar2.kmo.QI();
        }
    }
}
