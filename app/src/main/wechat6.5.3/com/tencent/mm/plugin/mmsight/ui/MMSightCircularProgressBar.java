package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MMSightCircularProgressBar extends View {
    boolean bhY = false;
    int duration = 0;
    private Paint evR;
    float hvI = 0.0f;
    int hvJ = 0;
    int hvK = 0;
    private RectF hvL;
    a hvN;
    private int hvO = Color.parseColor("#1AAD19");
    a pPH;
    private float strokeWidth = 0.0f;
    private float yw = 0.0f;

    public interface a {
        void aBv();
    }

    public MMSightCircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMSightCircularProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        float dimensionPixelSize = (float) getResources().getDimensionPixelSize(2131493535);
        this.strokeWidth = (float) getResources().getDimensionPixelSize(2131493537);
        this.yw = this.strokeWidth / 2.0f;
        this.hvL = new RectF(this.yw, this.yw, dimensionPixelSize - this.yw, dimensionPixelSize - this.yw);
        this.evR = new Paint();
        this.evR.setStyle(Style.STROKE);
        this.evR.setStrokeWidth(this.strokeWidth);
        this.evR.setColor(this.hvO);
        this.evR.setAlpha(153);
        this.evR.setAntiAlias(true);
    }

    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.yw, this.yw);
        canvas.rotate(180.0f, this.hvL.right / 2.0f, this.hvL.bottom / 2.0f);
        canvas.drawArc(this.hvL, 90.0f, 360.0f * (this.hvI / ((float) this.hvK)), false, this.evR);
        canvas.restore();
    }
}
