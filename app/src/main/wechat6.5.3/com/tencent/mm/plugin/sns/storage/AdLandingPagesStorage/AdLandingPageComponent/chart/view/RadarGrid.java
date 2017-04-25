package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.ChartGridView;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.List;

public class RadarGrid extends ChartGridView {
    public static final Point jxg = new Point(0, 0);
    private Rect fu = new Rect();
    private int jxb = 4;
    private int jxc = 4;
    private float jxe = 1.0f;
    public c jxf;
    private int jxm = 80;
    private Point jxn = jxg;
    private Spannable[] jxp;
    private List<PointF> jxq;
    private Path mT = new Path();

    public RadarGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aTE();
    }

    public RadarGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        aTE();
    }

    public RadarGrid(Context context, int i, int i2, float f, Spannable[] spannableArr, c cVar) {
        super(context);
        this.jxe = f;
        this.jxb = i;
        this.jxc = i2;
        this.jxe = f;
        this.jxp = spannableArr;
        this.jxf = cVar;
    }

    private void aTE() {
        setMinimumHeight(160);
        setMinimumWidth(160);
    }

    protected final int aTB() {
        return this.jxm * 2;
    }

    protected final int aTC() {
        return this.jxm * 2;
    }

    private List<PointF> ab(float f) {
        List<PointF> arrayList = new ArrayList();
        for (int i = 0; i < this.jxb; i++) {
            PointF pointF = new PointF();
            pointF.set((float) (((double) this.jxn.x) - (((double) (((float) this.jxm) * f)) * Math.sin((((double) (i * 2)) * 3.141592653589793d) / ((double) this.jxb)))), (float) (((double) this.jxn.y) - (((double) (((float) this.jxm) * f)) * Math.cos((((double) (i * 2)) * 3.141592653589793d) / ((double) this.jxb)))));
            arrayList.add(pointF);
        }
        return arrayList;
    }

    public void onDraw(Canvas canvas) {
        PointF pointF;
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        this.jxm = (int) (((double) (((float) Math.min(height, width)) / 2.0f)) * 0.8d);
        this.jxn.set((int) (((float) width) / 2.0f), (int) (((float) height) / 2.0f));
        if (this.jxf.jwR != null) {
            int i = (int) (((float) (this.jxm * 2)) + (this.jxf.jwO * 2.0f));
            int width2 = (this.jxf.jwR.getWidth() * i) / this.jxf.jwR.getHeight();
            canvas.drawBitmap(Bitmap.createScaledBitmap(this.jxf.jwR, width2, i, false), (float) (((int) (((float) width) / 2.0f)) - (width2 >>> 1)), (float) (((int) (((float) height) / 2.0f)) - (i >>> 1)), null);
        }
        if (this.jxf.jwy) {
            switch (this.jxf.jwx) {
                case 0:
                    this.jxq = ab(1.0f);
                    for (width = 0; width < this.jxb; width++) {
                        pointF = (PointF) this.jxq.get(width);
                        if (width == 0) {
                            this.mT.moveTo(pointF.x, pointF.y);
                        } else {
                            this.mT.lineTo(pointF.x, pointF.y);
                        }
                    }
                    this.mT.close();
                    if (this.jxf.backgroundColor != 0 && this.jxf.jwR == null) {
                        canvas.drawPath(this.mT, aTF());
                        break;
                    }
                case 1:
                    canvas.drawCircle((float) this.jxn.x, (float) this.jxn.y, (float) this.jxm, aTF());
                    break;
            }
        }
        if (this.jxf.jwz) {
            this.jxq = ab(1.0f);
            for (int i2 = 0; i2 < this.jxb; i2++) {
                pointF = (PointF) this.jxq.get(i2);
                float f = (float) this.jxn.x;
                float f2 = (float) this.jxn.y;
                float f3 = pointF.x;
                float f4 = pointF.y;
                Paint paint = new Paint();
                paint.setColor(this.jxf.jwE);
                paint.setStrokeWidth(this.jxf.jwF);
                canvas.drawLine(f, f2, f3, f4, paint);
            }
        }
        if (this.jxf.jwy) {
            switch (this.jxf.jwx) {
                case 0:
                    canvas.drawPath(this.mT, aTG());
                    this.mT.reset();
                    for (width = 1; width < this.jxc; width++) {
                        this.jxq = ab((((float) width) * 1.0f) / ((float) this.jxc));
                        for (i = 0; i < this.jxb; i++) {
                            pointF = (PointF) this.jxq.get(i);
                            if (i == 0) {
                                this.mT.moveTo(pointF.x, pointF.y);
                            } else {
                                this.mT.lineTo(pointF.x, pointF.y);
                            }
                            f3 = pointF.x;
                            float f5 = pointF.y;
                            f4 = (float) this.jxf.jwQ;
                            paint = new Paint();
                            paint.setColor(this.jxf.jwP);
                            paint.setStyle(Style.FILL);
                            paint.setAntiAlias(true);
                            canvas.drawCircle(f3, f5, f4, paint);
                        }
                        this.mT.close();
                        canvas.drawPath(this.mT, aTH());
                        this.mT.reset();
                    }
                    break;
                case 1:
                    canvas.drawCircle((float) this.jxn.x, (float) this.jxn.y, (float) this.jxm, aTG());
                    for (height = 1; height < this.jxc; height++) {
                        canvas.drawCircle((float) this.jxn.x, (float) this.jxn.y, ((float) this.jxm) * ((((float) height) * 1.0f) / ((float) this.jxc)), aTH());
                    }
                    break;
            }
        }
        if (this.jxp != null && this.jxf.jwB) {
            if (this.jxp.length != this.jxb) {
                throw new RuntimeException("Labels array length not matches longitude lines number.");
            }
            int i3 = 0;
            while (i3 < this.jxb) {
                CharSequence charSequence = this.jxp[i3];
                if (!charSequence.equals(null)) {
                    float f6;
                    float f7;
                    if (i3 == 0 || i3 == (this.jxb >>> 1)) {
                        f6 = 0.5f;
                    } else if (i3 <= 0 || i3 >= (this.jxb >>> 1)) {
                        f6 = 1.0f;
                    } else {
                        f6 = 0.0f;
                    }
                    if (i3 == 0) {
                        f7 = this.jxf.jwJ;
                    } else if (i3 == (this.jxb >>> 1)) {
                        f7 = -this.jxf.jwJ;
                    } else {
                        f7 = 0.0f;
                    }
                    TextPaint textPaint = new TextPaint();
                    textPaint.setColor(this.jxf.jwH);
                    textPaint.setTextSize(this.jxf.jwI);
                    StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, BaseReportManager.MAX_READ_COUNT, Alignment.ALIGN_NORMAL, 0.0f, 0.0f, false);
                    f = (float) (((double) (((float) this.jxn.x) - (staticLayout.getLineWidth(0) * f6))) - (((double) (((float) this.jxm) + this.jxf.jwJ)) * Math.sin(6.283185307179586d - ((((double) (i3 * 2)) * 3.141592653589793d) / ((double) this.jxb)))));
                    f2 = (float) ((((double) (this.jxn.y - (staticLayout.getHeight() / 2))) - (((double) (((float) this.jxm) + this.jxf.jwJ)) * Math.cos(6.283185307179586d - ((((double) (i3 * 2)) * 3.141592653589793d) / ((double) this.jxb))))) - ((double) f7));
                    canvas.save();
                    canvas.translate(f, f2);
                    staticLayout.draw(canvas);
                    canvas.restore();
                }
                i3++;
            }
        }
    }

    private Paint aTF() {
        Paint paint = new Paint();
        paint.setColor(this.jxf.backgroundColor);
        paint.setAntiAlias(true);
        return paint;
    }

    private Paint aTG() {
        Paint paint = new Paint();
        c cVar = this.jxf;
        paint.setColor(cVar.jwC == -1 ? cVar.jwD : cVar.jwC);
        paint.setStyle(Style.STROKE);
        cVar = this.jxf;
        paint.setStrokeWidth(cVar.jwG == -1.0f ? cVar.jwF : cVar.jwG);
        paint.setAntiAlias(true);
        return paint;
    }

    private Paint aTH() {
        Paint paint = new Paint();
        paint.setColor(this.jxf.jwD);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(this.jxf.jwF);
        paint.setAntiAlias(true);
        return paint;
    }

    public void setBackgroundColor(int i) {
        this.jxf.backgroundColor = i;
        invalidate();
    }
}
