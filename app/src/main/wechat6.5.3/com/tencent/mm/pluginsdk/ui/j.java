package com.tencent.mm.pluginsdk.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.bd.a;

public final class j extends Drawable {
    private int color;
    private float euG;
    private Paint evR = new Paint(1);
    private ValueAnimator hvM = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
    private float lHF;
    private int lHG;
    private float lHH;
    private float lHI;
    private float lHJ;
    private float lHK;
    private AnimatorUpdateListener lHL = new AnimatorUpdateListener(this) {
        final /* synthetic */ j lHM;

        {
            this.lHM = r1;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.lHM.lHF = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.lHM.invalidateSelf();
        }
    };
    private float x;

    public j(Context context) {
        this.color = a.b(context, 2131689613);
        this.lHG = a.N(context, 2131493595);
        this.x = (float) a.N(context, 2131493597);
        this.lHH = (float) a.N(context, 2131493598);
        this.lHK = (float) a.N(context, 2131493596);
        this.lHF = 0.0f;
        this.evR.setColor(this.color);
        this.evR.setStyle(Style.FILL);
        this.hvM.setInterpolator(new LinearInterpolator());
        this.hvM.setDuration(1250);
        this.hvM.setRepeatCount(-1);
        this.hvM.addUpdateListener(this.lHL);
        this.hvM.start();
    }

    private void a(float f, float f2, Canvas canvas) {
        canvas.drawCircle(f, f2, (float) this.lHG, this.evR);
    }

    public final void draw(Canvas canvas) {
        float f = this.lHK + ((float) this.lHG);
        if (f > ((float) canvas.getHeight())) {
            f = (float) canvas.getHeight();
            this.lHK = (float) (canvas.getHeight() - this.lHG);
        }
        if (this.lHF <= 25.0f) {
            this.euG = f - ((this.lHF / 25.0f) * this.lHK);
            this.lHI = f;
            this.lHJ = f;
        } else if (this.lHF <= 50.0f) {
            this.euG = f - (((50.0f - this.lHF) / 25.0f) * this.lHK);
            this.lHI = f - (((this.lHF - 25.0f) / 25.0f) * this.lHK);
            this.lHJ = f;
        } else if (this.lHF <= 75.0f) {
            this.euG = f;
            this.lHI = f - (((75.0f - this.lHF) / 25.0f) * this.lHK);
            this.lHJ = f - (((this.lHF - 50.0f) / 25.0f) * this.lHK);
        } else {
            this.euG = f;
            this.lHI = f;
            this.lHJ = f - (((100.0f - this.lHF) / 25.0f) * this.lHK);
        }
        a(this.x, this.euG, canvas);
        a(this.x + this.lHH, this.lHI, canvas);
        a(this.x + (this.lHH * 2.0f), this.lHJ, canvas);
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return 0;
    }
}
