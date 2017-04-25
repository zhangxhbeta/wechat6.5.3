package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.view.b.b;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;

final class l extends Drawable implements Animatable {
    private static final Interpolator BB = new b();
    private static final Interpolator er = new LinearInterpolator();
    private final int[] BC = new int[]{-16777216};
    final a BD;
    private Resources BE;
    private View BF;
    private float BG;
    private double BH;
    private double BI;
    boolean BJ;
    private float fE;
    private final Callback lX = new Callback(this) {
        final /* synthetic */ l BL;

        {
            this.BL = r1;
        }

        public final void invalidateDrawable(Drawable drawable) {
            this.BL.invalidateSelf();
        }

        public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.BL.scheduleSelf(runnable, j);
        }

        public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.BL.unscheduleSelf(runnable);
        }
    };
    private Animation mAnimation;
    private final ArrayList<Animation> mb = new ArrayList();

    private static class a {
        final RectF BM = new RectF();
        final Paint BN = new Paint();
        float BO = 0.0f;
        float BP = 0.0f;
        float BQ = 2.5f;
        int[] BR;
        int BS;
        float BT;
        float BU;
        float BV;
        boolean BW;
        Path BX;
        float BY;
        double BZ;
        int Ca;
        int Cb;
        int Cc;
        final Paint Cd = new Paint(1);
        int Ce;
        float fE = 0.0f;
        final Paint ft = new Paint();
        private final Callback lX;
        float mv = 5.0f;
        int tx;

        public a(Callback callback) {
            this.lX = callback;
            this.ft.setStrokeCap(Cap.SQUARE);
            this.ft.setAntiAlias(true);
            this.ft.setStyle(Style.STROKE);
            this.BN.setStyle(Style.FILL);
            this.BN.setAntiAlias(true);
        }

        public final void ai(int i) {
            this.BS = i;
            this.tx = this.BR[this.BS];
        }

        final int cx() {
            return (this.BS + 1) % this.BR.length;
        }

        public final void w(float f) {
            this.BO = f;
            invalidateSelf();
        }

        public final void x(float f) {
            this.BP = f;
            invalidateSelf();
        }

        public final void setRotation(float f) {
            this.fE = f;
            invalidateSelf();
        }

        public final void v(boolean z) {
            if (this.BW != z) {
                this.BW = z;
                invalidateSelf();
            }
        }

        public final void cy() {
            this.BT = this.BO;
            this.BU = this.BP;
            this.BV = this.fE;
        }

        public final void cz() {
            this.BT = 0.0f;
            this.BU = 0.0f;
            this.BV = 0.0f;
            w(0.0f);
            x(0.0f);
            setRotation(0.0f);
        }

        final void invalidateSelf() {
            this.lX.invalidateDrawable(null);
        }
    }

    static /* synthetic */ void a(l lVar, float f, a aVar) {
        a(f, aVar);
        float floor = (float) (Math.floor((double) (aVar.BV / 0.8f)) + 1.0d);
        float a = a(aVar);
        aVar.w((((aVar.BU - a) - aVar.BT) * f) + aVar.BT);
        aVar.x(aVar.BU);
        aVar.setRotation(((floor - aVar.BV) * f) + aVar.BV);
    }

    public l(Context context, View view) {
        this.BF = view;
        this.BE = context.getResources();
        this.BD = new a(this.lX);
        a aVar = this.BD;
        aVar.BR = this.BC;
        aVar.ai(0);
        a aVar2 = this.BD;
        float f = this.BE.getDisplayMetrics().density;
        this.BH = ((double) f) * 40.0d;
        this.BI = ((double) f) * 40.0d;
        float f2 = 2.5f * f;
        aVar2.mv = f2;
        aVar2.ft.setStrokeWidth(f2);
        aVar2.invalidateSelf();
        aVar2.BZ = 8.75d * ((double) f);
        aVar2.ai(0);
        f2 = 10.0f * f;
        f *= 5.0f;
        aVar2.Ca = (int) f2;
        aVar2.Cb = (int) f;
        f = (float) Math.min((int) this.BH, (int) this.BI);
        f = (aVar2.BZ <= 0.0d || f < 0.0f) ? (float) Math.ceil((double) (aVar2.mv / 2.0f)) : (float) (((double) (f / 2.0f)) - aVar2.BZ);
        aVar2.BQ = f;
        aVar = this.BD;
        Animation anonymousClass1 = new Animation(this) {
            final /* synthetic */ l BL;

            public final void applyTransformation(float f, Transformation transformation) {
                if (this.BL.BJ) {
                    l.a(this.BL, f, aVar);
                    return;
                }
                float b = l.a(aVar);
                float f2 = aVar.BU;
                float f3 = aVar.BT;
                float f4 = aVar.BV;
                l.a(f, aVar);
                if (f <= 0.5f) {
                    float f5 = 0.8f - b;
                    aVar.w(f3 + (l.BB.getInterpolation(f / 0.5f) * f5));
                }
                if (f > 0.5f) {
                    aVar.x(((0.8f - b) * l.BB.getInterpolation((f - 0.5f) / 0.5f)) + f2);
                }
                aVar.setRotation((0.25f * f) + f4);
                this.BL.setRotation((216.0f * f) + (1080.0f * (this.BL.BG / 5.0f)));
            }
        };
        anonymousClass1.setRepeatCount(-1);
        anonymousClass1.setRepeatMode(1);
        anonymousClass1.setInterpolator(er);
        anonymousClass1.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ l BL;

            public final void onAnimationStart(Animation animation) {
                this.BL.BG = 0.0f;
            }

            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
                aVar.cy();
                a aVar = aVar;
                aVar.ai(aVar.cx());
                aVar.w(aVar.BP);
                if (this.BL.BJ) {
                    this.BL.BJ = false;
                    animation.setDuration(1332);
                    aVar.v(false);
                    return;
                }
                this.BL.BG = (this.BL.BG + 1.0f) % 5.0f;
            }
        });
        this.mAnimation = anonymousClass1;
    }

    public final void u(boolean z) {
        this.BD.v(z);
    }

    public final void u(float f) {
        a aVar = this.BD;
        if (f != aVar.BY) {
            aVar.BY = f;
            aVar.invalidateSelf();
        }
    }

    public final void v(float f) {
        this.BD.w(0.0f);
        this.BD.x(f);
    }

    public final int getIntrinsicHeight() {
        return (int) this.BI;
    }

    public final int getIntrinsicWidth() {
        return (int) this.BH;
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.fE, bounds.exactCenterX(), bounds.exactCenterY());
        a aVar = this.BD;
        RectF rectF = aVar.BM;
        rectF.set(bounds);
        rectF.inset(aVar.BQ, aVar.BQ);
        float f = 360.0f * (aVar.BO + aVar.fE);
        float f2 = ((aVar.BP + aVar.fE) * 360.0f) - f;
        aVar.ft.setColor(aVar.tx);
        canvas.drawArc(rectF, f, f2, false, aVar.ft);
        if (aVar.BW) {
            if (aVar.BX == null) {
                aVar.BX = new Path();
                aVar.BX.setFillType(FillType.EVEN_ODD);
            } else {
                aVar.BX.reset();
            }
            float f3 = ((float) (((int) aVar.BQ) / 2)) * aVar.BY;
            float cos = (float) ((aVar.BZ * Math.cos(0.0d)) + ((double) bounds.exactCenterX()));
            float sin = (float) ((aVar.BZ * Math.sin(0.0d)) + ((double) bounds.exactCenterY()));
            aVar.BX.moveTo(0.0f, 0.0f);
            aVar.BX.lineTo(((float) aVar.Ca) * aVar.BY, 0.0f);
            aVar.BX.lineTo((((float) aVar.Ca) * aVar.BY) / 2.0f, ((float) aVar.Cb) * aVar.BY);
            aVar.BX.offset(cos - f3, sin);
            aVar.BX.close();
            aVar.BN.setColor(aVar.tx);
            canvas.rotate((f + f2) - 5.0f, bounds.exactCenterX(), bounds.exactCenterY());
            canvas.drawPath(aVar.BX, aVar.BN);
        }
        if (aVar.Cc < 255) {
            aVar.Cd.setColor(aVar.Ce);
            aVar.Cd.setAlpha(255 - aVar.Cc);
            canvas.drawCircle(bounds.exactCenterX(), bounds.exactCenterY(), (float) (bounds.width() / 2), aVar.Cd);
        }
        canvas.restoreToCount(save);
    }

    public final void setAlpha(int i) {
        this.BD.Cc = i;
    }

    public final int getAlpha() {
        return this.BD.Cc;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        a aVar = this.BD;
        aVar.ft.setColorFilter(colorFilter);
        aVar.invalidateSelf();
    }

    final void setRotation(float f) {
        this.fE = f;
        invalidateSelf();
    }

    public final int getOpacity() {
        return -3;
    }

    public final boolean isRunning() {
        ArrayList arrayList = this.mb;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public final void start() {
        this.mAnimation.reset();
        this.BD.cy();
        if (this.BD.BP != this.BD.BO) {
            this.BJ = true;
            this.mAnimation.setDuration(666);
            this.BF.startAnimation(this.mAnimation);
            return;
        }
        this.BD.ai(0);
        this.BD.cz();
        this.mAnimation.setDuration(1332);
        this.BF.startAnimation(this.mAnimation);
    }

    public final void stop() {
        this.BF.clearAnimation();
        setRotation(0.0f);
        this.BD.v(false);
        this.BD.ai(0);
        this.BD.cz();
    }

    private static float a(a aVar) {
        return (float) Math.toRadians(((double) aVar.mv) / (6.283185307179586d * aVar.BZ));
    }

    private static void a(float f, a aVar) {
        if (f > 0.75f) {
            float f2 = (f - 0.75f) / 0.25f;
            int i = aVar.BR[aVar.BS];
            int i2 = aVar.BR[aVar.cx()];
            i = Integer.valueOf(i).intValue();
            int i3 = (i >> 24) & 255;
            int i4 = (i >> 16) & 255;
            int i5 = (i >> 8) & 255;
            i &= 255;
            i2 = Integer.valueOf(i2).intValue();
            aVar.tx = (((int) (f2 * ((float) ((i2 & 255) - i)))) + i) | ((((i3 + ((int) (((float) (((i2 >> 24) & 255) - i3)) * f2))) << 24) | ((i4 + ((int) (((float) (((i2 >> 16) & 255) - i4)) * f2))) << 16)) | ((((int) (((float) (((i2 >> 8) & 255) - i5)) * f2)) + i5) << 8));
        }
    }
}
