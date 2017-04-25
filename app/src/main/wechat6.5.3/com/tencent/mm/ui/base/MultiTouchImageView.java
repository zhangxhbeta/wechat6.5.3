package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.gif.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;

public class MultiTouchImageView extends ImageView {
    public int fET;
    public int fEU;
    private boolean hqt;
    public float iBk;
    public int imageHeight;
    public int imageWidth;
    protected Bitmap jAO;
    public boolean jOS;
    protected ac mHandler;
    protected Matrix nZR;
    protected Matrix nZS;
    private final Matrix nZT;
    private final float[] nZU;
    int nZV;
    int nZW;
    private float nZX;
    private float nZY;
    private float nZZ;
    private float oaa;
    private float oab;
    private float oac;
    public boolean oad;
    public boolean oae;
    public boolean oaf;
    private float oag;
    private float oah;
    private float oai;
    float oaj;
    public boolean oak;
    public a oal;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ long cMA;
        final /* synthetic */ float oam = 128.0f;
        final /* synthetic */ float oan;
        final /* synthetic */ float oao;
        final /* synthetic */ float oap;
        final /* synthetic */ float oaq;
        final /* synthetic */ MultiTouchImageView oar;

        AnonymousClass1(MultiTouchImageView multiTouchImageView, float f, long j, float f2, float f3, float f4, float f5) {
            this.oar = multiTouchImageView;
            this.cMA = j;
            this.oan = f2;
            this.oao = f3;
            this.oap = f4;
            this.oaq = f5;
        }

        public final void run() {
            float min = Math.min(this.oam, (float) (System.currentTimeMillis() - this.cMA));
            this.oar.g(this.oan + (this.oao * min), this.oap, this.oaq);
            if (min < this.oam) {
                this.oar.mHandler.post(this);
            }
        }
    }

    public final void ah(float f) {
        if (Float.compare(f, 1.0f) < 0) {
            v.w("MicroMsg.MultiTouchImageView", "max scale limit is less than 1.0, change nothing, return");
        } else {
            this.oac = f;
        }
    }

    public MultiTouchImageView(Context context, int i, int i2) {
        super(context);
        this.nZR = new Matrix();
        this.nZS = new Matrix();
        this.nZT = new Matrix();
        this.nZU = new float[9];
        this.jAO = null;
        this.nZV = -1;
        this.nZW = -1;
        this.nZX = 0.0f;
        this.nZY = 0.0f;
        this.nZZ = 0.0f;
        this.hqt = false;
        this.oaa = 2.0f;
        this.oab = 0.75f;
        this.oac = 3.0f;
        this.oad = false;
        this.oae = false;
        this.oaf = false;
        this.jOS = true;
        this.mHandler = new ac();
        this.oai = 1.0f;
        this.oaj = 0.0f;
        this.oak = false;
        this.imageHeight = i2;
        this.imageWidth = i;
        init();
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private MultiTouchImageView(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet);
        this.nZR = new Matrix();
        this.nZS = new Matrix();
        this.nZT = new Matrix();
        this.nZU = new float[9];
        this.jAO = null;
        this.nZV = -1;
        this.nZW = -1;
        this.nZX = 0.0f;
        this.nZY = 0.0f;
        this.nZZ = 0.0f;
        this.hqt = false;
        this.oaa = 2.0f;
        this.oab = 0.75f;
        this.oac = 3.0f;
        this.oad = false;
        this.oae = false;
        this.oaf = false;
        this.jOS = true;
        this.mHandler = new ac();
        this.oai = 1.0f;
        this.oaj = 0.0f;
        this.oak = false;
        this.imageHeight = 0;
        this.imageWidth = 0;
        init();
    }

    public final void di(int i, int i2) {
        this.imageWidth = i;
        this.imageHeight = i2;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.fET = MeasureSpec.getSize(i);
        this.fEU = MeasureSpec.getSize(i2);
        if (!this.hqt) {
            this.hqt = true;
            init();
        }
        bCO();
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.oak = false;
        this.jAO = bitmap;
        this.hqt = false;
        super.setImageBitmap(bitmap);
    }

    protected void onDraw(Canvas canvas) {
        if (this.oak || this.jAO == null || !this.jAO.isRecycled()) {
            super.onDraw(canvas);
        } else {
            v.e("MicroMsg.MultiTouchImageView", "this bitmap is recycled! draw nothing!");
        }
    }

    public final void bCO() {
        this.nZS.reset();
        bCP();
        g(this.iBk, 0.0f, 0.0f);
    }

    public final void z(float f, float f2) {
        bCP();
        h(this.iBk, f, f2);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            this.hqt = false;
        }
    }

    private void bCP() {
        boolean z = true;
        this.oag = ((float) this.fET) / ((float) this.imageWidth);
        this.oah = ((float) this.fEU) / ((float) this.imageHeight);
        this.oae = d.aZ(this.imageWidth, this.imageHeight);
        this.oaf = d.aY(this.imageWidth, this.imageHeight);
        boolean z2 = this.oae && this.imageWidth > this.fET;
        this.oae = z2;
        if (!this.oaf || this.imageHeight <= this.fEU) {
            z = false;
        }
        this.oaf = z;
        this.iBk = this.oag;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        if (f.aZy()) {
            e eVar = new e();
            keyEvent.startTracking();
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z = false;
        if (i == 4) {
            boolean isTracking;
            if (f.aZy()) {
                e eVar = new e();
                isTracking = keyEvent.isTracking();
            } else {
                isTracking = false;
            }
            if (isTracking) {
                if (f.aZy()) {
                    e eVar2 = new e();
                    z = keyEvent.isCanceled();
                }
                if (!z && getScale() > 1.0f) {
                    g(1.0f, ((float) this.fET) / 2.0f, ((float) this.fEU) / 2.0f);
                    return true;
                }
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    private void H(boolean z, boolean z2) {
        float f = 0.0f;
        if (this.jAO == null && !this.oak) {
            return;
        }
        if (this.oal != null || !this.oak) {
            RectF rectF;
            Matrix bCQ = bCQ();
            if (this.oak) {
                rectF = new RectF(0.0f, 0.0f, (float) this.oal.getIntrinsicWidth(), (float) this.oal.getIntrinsicHeight());
            } else {
                rectF = new RectF(0.0f, 0.0f, (float) this.jAO.getWidth(), (float) this.jAO.getHeight());
            }
            bCQ.mapRect(rectF);
            float height = rectF.height();
            float width = rectF.width();
            if (z2) {
                if (height < ((float) this.fEU)) {
                    height = ((((float) this.fEU) - height) / 2.0f) - rectF.top;
                } else if (rectF.top > 0.0f) {
                    height = -rectF.top;
                } else {
                    if (rectF.bottom < ((float) this.fEU)) {
                        height = ((float) this.fEU) - rectF.bottom;
                    }
                    height = 0.0f;
                }
            } else if (rectF.top > 0.0f) {
                height = -rectF.top;
            } else {
                if (rectF.bottom < ((float) this.fEU)) {
                    height = ((float) this.fEU) - rectF.bottom;
                }
                height = 0.0f;
            }
            if (z) {
                if (width < ((float) this.fET)) {
                    f = ((((float) this.fET) - width) / 2.0f) - rectF.left;
                } else if (rectF.left > 0.0f) {
                    f = -rectF.left;
                } else if (rectF.right < ((float) this.fET)) {
                    f = ((float) this.fET) - rectF.right;
                }
            } else if (rectF.left > 0.0f) {
                f = -rectF.left;
            } else if (rectF.right < ((float) this.fET)) {
                f = ((float) this.fET) - rectF.right;
            }
            B(f, height);
            Matrix bCQ2 = bCQ();
            setImageMatrix(bCQ2);
            bCQ2.mapRect(rectF);
            rectF.height();
            rectF.width();
        }
    }

    private void init() {
        v.d("dktest", "init screenWidth:" + this.fET + " screenHeight :" + this.fEU);
        setScaleType(ScaleType.MATRIX);
        float f = ((float) getContext().getResources().getDisplayMetrics().widthPixels) / 720.0f;
        if (f > 1.0f) {
            this.oai = f;
        }
    }

    public final float getScale() {
        this.nZS.getValues(this.nZU);
        bCP();
        this.nZY = this.oac * this.oai;
        this.nZZ = this.iBk * this.oab;
        if (this.nZY < 1.0f) {
            this.nZY = 1.0f;
        }
        if (this.nZZ > 1.0f) {
            this.nZZ = 1.0f;
        }
        return this.nZU[0];
    }

    private Matrix bCQ() {
        this.nZT.set(this.nZR);
        this.nZT.postConcat(this.nZS);
        return this.nZT;
    }

    public final void bCR() {
        boolean z;
        boolean z2 = true;
        if (this.jOS && this.oae) {
            z = false;
        } else {
            z = true;
        }
        if (this.oaf) {
            z2 = false;
        }
        H(z, z2);
    }

    public final void bCS() {
        if (this.oad && 0.0f == this.nZX) {
            this.nZX = bCT();
        }
    }

    public final void g(float f, float f2, float f3) {
        boolean z;
        boolean z2 = true;
        float scale = getScale();
        if (this.oad) {
            this.nZY = 0.0f == this.nZX ? this.oac * this.oai : this.nZX;
        }
        if (f > this.nZY) {
            f = this.nZY + ((f - this.nZY) * 0.2f);
        } else if (f < this.nZZ) {
            f = this.nZZ;
        }
        float f4 = f / scale;
        if (!this.oak) {
            setImageMatrix(bCQ());
            this.nZS.postScale(f4, f4, f2, f3);
        }
        if (this.jOS && this.oae) {
            z = false;
        } else {
            z = true;
        }
        if (this.oaf) {
            z2 = false;
        }
        H(z, z2);
    }

    public final float bCT() {
        float f = this.iBk;
        if (this.oag * 0.7f > f) {
            f = this.oag;
        } else if (this.oah * 0.7f > f) {
            f = this.oah;
        } else {
            f = this.iBk * this.oaa;
        }
        if (((double) f) < 1.0d) {
            f = 1.0f;
        }
        if (f > this.nZY) {
            return this.nZY;
        }
        return f;
    }

    public final void A(float f, float f2) {
        this.nZX = bCT();
        h(this.nZX, f, f2);
    }

    private void h(float f, float f2, float f3) {
        float scale = (f - getScale()) / 128.0f;
        float scale2 = getScale();
        this.mHandler.post(new AnonymousClass1(this, 128.0f, System.currentTimeMillis(), scale2, scale, f2, f3));
    }

    public final void B(float f, float f2) {
        this.nZS.postTranslate(f, f2);
        setImageMatrix(bCQ());
    }
}
