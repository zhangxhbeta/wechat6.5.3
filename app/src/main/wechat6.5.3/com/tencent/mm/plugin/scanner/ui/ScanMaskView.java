package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.compatible.util.d;

public class ScanMaskView extends View {
    private Paint ft;
    float iAA = 0.0f;
    private Paint iAB;
    ValueAnimator iAC = null;
    private Bitmap iAa = null;
    private Bitmap iAb = null;
    private Bitmap iAc = null;
    int iAd = 0;
    int iAe = 0;
    private boolean iAf = false;
    private Rect iAg = new Rect();
    private Rect iAh = new Rect();
    private Rect iAi = new Rect();
    private Rect iAj = new Rect();
    private Rect iAk = new Rect();
    private Rect iAl = new Rect();
    private Rect iAm = new Rect();
    private Rect iAn = new Rect();
    private Rect iAo = new Rect();
    private Path iAp = new Path();
    Rect iAq;
    private PorterDuffXfermode iAr;
    private int iAs = 2131689969;
    private long iAt = 0;
    boolean iAu = false;
    Rect iAv;
    private final long iAw = 200;
    float iAx = 0.0f;
    float iAy = 0.0f;
    float iAz = 0.0f;
    private Bitmap izZ = null;

    public ScanMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScanMaskView(Context context, Rect rect) {
        super(context);
        this.iAq = rect;
        getDrawingRect(this.iAg);
        this.ft = new Paint();
        this.izZ = a.decodeResource(getResources(), 2130839077);
        this.iAa = a.decodeResource(getResources(), 2130839078);
        this.iAb = a.decodeResource(getResources(), 2130839079);
        this.iAc = a.decodeResource(getResources(), 2130839080);
        this.iAd = this.izZ.getWidth();
        this.iAe = this.izZ.getHeight();
        this.iAB = new Paint();
        this.iAr = new PorterDuffXfermode(Mode.CLEAR);
    }

    public final void aLG() {
        this.iAf = true;
        if (this.izZ != null) {
            this.izZ.recycle();
            this.izZ = null;
        }
        if (this.iAa != null) {
            this.iAa.recycle();
            this.iAa = null;
        }
        if (this.iAb != null) {
            this.iAb.recycle();
            this.iAb = null;
        }
        if (this.iAc != null) {
            this.iAc.recycle();
            this.iAc = null;
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.iAq != null && !this.iAf) {
            System.currentTimeMillis();
            System.currentTimeMillis();
            int save = canvas.save();
            this.ft.reset();
            if (d.dX(18)) {
                this.iAl.left = 0;
                this.iAl.top = this.iAq.top;
                this.iAl.right = this.iAq.left;
                this.iAl.bottom = this.iAq.bottom;
                this.iAm.left = this.iAq.left;
                this.iAm.top = 0;
                this.iAm.right = this.iAq.right;
                this.iAm.bottom = this.iAq.top;
                this.iAn.left = this.iAq.right;
                this.iAn.top = this.iAq.top;
                this.iAn.right = getWidth();
                this.iAn.bottom = this.iAq.bottom;
                this.iAo.left = this.iAq.left;
                this.iAo.top = this.iAq.bottom;
                this.iAo.right = this.iAq.right;
                this.iAo.bottom = getHeight();
                this.iAh.left = 0;
                this.iAh.top = 0;
                this.iAh.right = this.iAq.left;
                this.iAh.bottom = this.iAq.top;
                this.iAi.left = this.iAq.right;
                this.iAi.top = 0;
                this.iAi.right = getWidth();
                this.iAi.bottom = this.iAq.top;
                this.iAj.left = 0;
                this.iAj.top = this.iAq.bottom;
                this.iAj.right = this.iAq.left;
                this.iAj.bottom = getHeight();
                this.iAk.left = this.iAq.right;
                this.iAk.top = this.iAq.bottom;
                this.iAk.right = getWidth();
                this.iAk.bottom = getHeight();
                canvas.save();
                canvas.clipRect(this.iAl, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.iAs));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.iAm, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.iAs));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.iAn, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.iAs));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.iAo, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.iAs));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.iAh, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.iAs));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.iAi, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.iAs));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.iAj, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.iAs));
                canvas.restore();
                canvas.save();
                canvas.clipRect(this.iAk, Op.REPLACE);
                canvas.drawColor(getResources().getColor(this.iAs));
                canvas.restore();
            } else {
                canvas.clipRect(this.iAq, Op.DIFFERENCE);
                canvas.drawColor(getResources().getColor(this.iAs));
            }
            System.currentTimeMillis();
            System.currentTimeMillis();
            canvas.restoreToCount(save);
            this.ft.reset();
            this.ft.setStyle(Style.STROKE);
            this.ft.setStrokeWidth(1.0f);
            this.ft.setColor(-3355444);
            this.ft.setAntiAlias(true);
            canvas.drawRect(this.iAq, this.ft);
            System.currentTimeMillis();
            System.currentTimeMillis();
            canvas.drawBitmap(this.izZ, (float) this.iAq.left, (float) this.iAq.top, this.iAB);
            canvas.drawBitmap(this.iAa, (float) (this.iAq.right - this.iAd), (float) this.iAq.top, this.iAB);
            canvas.drawBitmap(this.iAb, (float) this.iAq.left, (float) (this.iAq.bottom - this.iAe), this.iAB);
            canvas.drawBitmap(this.iAc, (float) (this.iAq.right - this.iAd), (float) (this.iAq.bottom - this.iAe), this.iAB);
            System.currentTimeMillis();
            super.onDraw(canvas);
            System.currentTimeMillis();
        }
    }
}
