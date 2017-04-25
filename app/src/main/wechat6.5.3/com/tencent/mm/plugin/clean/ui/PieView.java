package com.tencent.mm.plugin.clean.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class PieView extends View {
    int dyp = 0;
    private Paint eWh;
    private Paint eWi;
    private Paint eWj;
    private Paint eWk;
    private Paint eWl;
    private Paint eWm;
    private int eWn = 6;
    private int eWo;
    private int eWp;
    private int eWq;
    int eWr;
    int eWs;
    private int eWt = -90;

    public PieView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        NI();
    }

    public PieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        NI();
    }

    private void NI() {
        this.eWh = jy(-1);
        this.eWi = jy(-657931);
        this.eWj = jy(-2565928);
        this.eWk = jy(-15223279);
        this.eWl = jy(-7876878);
        this.eWm = jy(-1447447);
    }

    private static Paint jy(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Style.FILL);
        paint.setColor(i);
        return paint;
    }

    public void draw(Canvas canvas) {
        float measuredWidth = (float) (getMeasuredWidth() / 2);
        float measuredHeight = (float) ((getMeasuredHeight() / 2) + getTop());
        float measuredHeight2 = (float) ((getMeasuredHeight() / 3) + 15);
        float f = measuredHeight2 - 15.0f;
        RectF rectF = new RectF(measuredWidth - measuredHeight2, measuredHeight - measuredHeight2, measuredWidth + measuredHeight2, measuredHeight + measuredHeight2);
        if (this.dyp == 0) {
            canvas.drawCircle(measuredWidth, measuredHeight, measuredHeight2, this.eWi);
            canvas.drawArc(rectF, (float) this.eWt, 45.0f, true, this.eWj);
            canvas.drawCircle(measuredWidth, measuredHeight, f, this.eWh);
            this.eWt += 4;
            this.eWt %= 360;
        }
        if (this.dyp == 1) {
            float f2 = 10.0f + measuredHeight2;
            RectF rectF2 = new RectF(measuredWidth - f2, measuredHeight - f2, measuredWidth + f2, f2 + measuredHeight);
            this.eWo = y(this.eWo, this.eWr, this.eWn);
            canvas.drawArc(rectF2, -90.0f, (float) this.eWo, true, this.eWk);
            if (this.eWo == this.eWr) {
                this.eWq = y(this.eWq, this.eWs, this.eWn);
                canvas.drawArc(rectF, (float) (this.eWr - 90), (float) this.eWq, true, this.eWl);
            }
            if (this.eWq == this.eWs) {
                this.eWp = y(this.eWp, (360 - this.eWr) - this.eWs, this.eWn);
                canvas.drawArc(rectF, (float) ((this.eWr - 90) + this.eWs), (float) this.eWp, true, this.eWm);
            }
        }
        invalidate();
    }

    private static int y(int i, int i2, int i3) {
        if (i2 - i >= i3) {
            return i + i3;
        }
        if (i - i2 > i3) {
            return i - i3;
        }
        return i2;
    }
}
