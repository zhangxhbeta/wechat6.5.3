package com.tencent.mm.pluginsdk.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Random;

public final class k extends Drawable {
    private Context context;
    private Paint evR = new Paint(1);
    ValueAnimator hvM = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
    float lHF = 0.0f;
    private int lHN = 0;
    private int lHO = 0;
    private Interpolator lHP = new LinearInterpolator();
    private Interpolator lHQ = new AccelerateDecelerateInterpolator();
    private int lHR;
    private int lHS;
    private int lHT;
    private int lHU;
    private int lHV;
    private int lHW;
    private int lHX;
    private int lHY;
    private int lHZ = 0;
    private float lIa = -90.0f;
    private float lIb = 0.0f;
    private float lIc = 0.0f;
    private float lId = 5.0f;
    boolean lIe = false;
    private int lIf;
    private int lIg;
    int lIh = 2;
    private RectF lIi;
    private int pQN;
    private int pQO;
    private int pQP;
    private Random random = new Random(System.currentTimeMillis());

    public k(Context context) {
        this.hvM.setInterpolator(this.lHP);
        this.hvM.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ k lIj;

            {
                this.lIj = r1;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.lIj.lHF = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.lIj.invalidateSelf();
            }
        });
        this.lIi = new RectF();
        this.context = context;
        this.lHN = a.b(context, 2131690123);
        this.lHO = a.b(context, 2131689906);
        this.lHU = a.N(context, 2131493600);
        this.lHV = a.N(context, 2131493599);
        this.lHW = a.N(context, 2131493591);
        this.lHZ = a.N(context, 2131493594);
        this.lHS = a.b(context, 2131690089);
        this.lHT = a.N(context, 2131493593);
        this.lHX = a.N(context, 2131493592);
        this.lHY = a.b(context, 2131690090);
        this.lIf = this.lHX;
        this.lIg = this.lIf;
        this.pQP = a.N(context, 2131493612);
        this.pQN = a.N(context, 2131493612);
        this.pQO = a.N(context, 2131493611);
        this.lHR = a.N(context, 2131493601);
    }

    public final void bRM() {
        v.d("MicroMsg.VoiceInputDrawable", "readyState %s", new Object[]{Integer.valueOf(this.lIh)});
        this.lIh = 2;
        this.hvM.cancel();
        this.lHF = 0.0f;
        invalidateSelf();
    }

    public final void hT(boolean z) {
        v.d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[]{Integer.valueOf(0), Boolean.valueOf(z)});
        if (!z) {
            this.lIh = 3;
        }
        this.lIe = true;
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        int width;
        int height;
        if (!e(canvas)) {
            width = canvas.getWidth() >> 1;
            height = canvas.getHeight() >> 1;
            this.evR.setShader(null);
            this.evR.setStyle(Style.FILL);
            this.evR.setColor(this.lHS);
            if (this.lIh == 7) {
                if (this.lIe) {
                    this.pQP -= 3;
                } else {
                    this.pQP += 3;
                }
                this.pQP = Math.min(Math.max(this.pQN, this.pQP), this.pQO);
                canvas.drawCircle((float) width, (float) height, (float) this.pQP, this.evR);
            } else {
                canvas.drawCircle((float) width, (float) height, (float) this.lHT, this.evR);
            }
            this.evR.setColor(-1);
            canvas.drawCircle((float) width, (float) height, (float) this.lHZ, this.evR);
        }
        if (this.lIh == 4) {
            if (canvas != null) {
                this.evR.setColor(this.lHN);
                this.evR.setStrokeWidth((float) this.lHR);
                this.evR.setStyle(Style.STROKE);
                this.evR.clearShadowLayer();
                this.evR.setShader(null);
                this.lIi.left = (float) ((canvas.getWidth() / 2) - this.lHX);
                this.lIi.top = (float) ((canvas.getHeight() / 2) - this.lHX);
                this.lIi.right = (float) ((canvas.getWidth() / 2) + this.lHX);
                this.lIi.bottom = (float) ((canvas.getHeight() / 2) + this.lHX);
                canvas.drawArc(this.lIi, this.lIa, this.lIc, false, this.evR);
                this.lIa += this.lIb;
                this.lIc += this.lId;
                if (this.lIc >= 360.0f) {
                    this.lId = -this.lId;
                    this.lIb = 5.0f;
                } else if (this.lIc <= 0.0f) {
                    this.lId = -this.lId;
                    this.lIb = 0.0f;
                    this.lIa = -90.0f;
                    this.lIc = 0.0f;
                }
            }
        } else if (!e(canvas)) {
            width = canvas.getWidth() >> 1;
            height = canvas.getHeight() >> 1;
            this.evR.setStrokeWidth((float) this.lHR);
            this.evR.setColor(this.lHN);
            if (this.lIh == 2 || this.lIh == 6 || this.lIh == 5 || this.lIh == 7) {
                this.evR.setStyle(Style.STROKE);
                this.evR.setColor(this.lHO);
                canvas.drawCircle((float) width, (float) height, (float) this.lHX, this.evR);
            } else {
                this.evR.setStyle(Style.STROKE);
                if (!this.lIe) {
                    this.lIf += 3;
                } else if (this.lIg == this.lHU) {
                    this.lIf++;
                } else if (this.lIg == this.lHV) {
                    this.lIf--;
                } else if (this.lIg == this.lHW) {
                    this.lIf--;
                } else {
                    this.lIf -= 3;
                }
                if (this.lIe) {
                    this.lIf = Math.min(Math.max(this.lHU, this.lIf), this.lHW);
                } else {
                    this.lIf = Math.min(Math.max(this.lHU, this.lIf), this.lHV);
                }
                if (this.lIf == this.lHU || this.lIf == this.lHV || this.lIf == this.lHW) {
                    if (this.lIe || this.lIf != this.lHV) {
                        this.lIg = this.lIf;
                    } else {
                        this.lIg = this.lIf + 1;
                    }
                }
                canvas.drawCircle((float) width, (float) height, (float) this.lIf, this.evR);
            }
        }
        if ((this.lIh == 6 || this.lIh == 7) && !e(canvas)) {
            this.evR.setStyle(Style.FILL);
            this.evR.setColor(this.lHY);
            canvas.drawCircle((float) (canvas.getWidth() >> 1), (float) (canvas.getHeight() >> 1), (float) this.lHZ, this.evR);
        }
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getIntrinsicWidth() {
        if (this.context == null) {
            return 0;
        }
        return a.dv(this.context);
    }

    public final int getIntrinsicHeight() {
        return this.lHZ * 2;
    }

    public final int getOpacity() {
        return -3;
    }

    private static boolean e(Canvas canvas) {
        return canvas == null || canvas.getWidth() == 0 || canvas.getHeight() == 0;
    }
}
