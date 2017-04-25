package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.sdk.platformtools.aa;
import java.util.ArrayList;

public final class e extends Drawable {
    private static final RectF dVP = new RectF(-21.0f, -21.0f, 21.0f, 21.0f);
    private static final RectF dVQ = new RectF(-19.0f, -19.0f, 19.0f, 19.0f);
    private int dVR = Math.round(aa.getResources().getDisplayMetrics().density * 48.0f);
    private int dVS = 4;
    private boolean dVT = false;
    private int dVU = 0;
    public b dVV = new b();
    public c dVW = new c();
    private Paint ft;
    public ArrayList<Animator> mb = new ArrayList();
    private int mu = -16777216;

    private static class a {
        public static final Interpolator dVX = new LinearInterpolator();
    }

    private static class b {
        public float mA;
        public float mB;
        public float mC;

        private b() {
            this.mA = 0.0f;
            this.mB = 0.0f;
            this.mC = 0.0f;
        }

        @android.support.a.a
        public final void setTrimPathStart(float f) {
            this.mA = f;
        }

        @android.support.a.a
        public final void setTrimPathEnd(float f) {
            this.mB = f;
        }

        @android.support.a.a
        public final void setTrimPathOffset(float f) {
            this.mC = f;
        }
    }

    private static class c {
        float fE;

        private c() {
        }

        @android.support.a.a
        public final void setRotation(float f) {
            this.fE = f;
        }
    }

    private static class d {
        public static final Interpolator dVX = android.support.v4.view.b.e.b(dVY);
        private static final Path dVY;

        static {
            Path path = new Path();
            dVY = path;
            path.cubicTo(0.2f, 0.0f, 0.1f, 1.0f, 0.5f, 1.0f);
            dVY.lineTo(1.0f, 1.0f);
        }
    }

    private static class e {
        public static final Interpolator dVX = android.support.v4.view.b.e.b(dVZ);
        private static final Path dVZ;

        static {
            Path path = new Path();
            dVZ = path;
            path.lineTo(0.5f, 0.0f);
            dVZ.cubicTo(0.7f, 0.0f, 0.6f, 1.0f, 1.0f, 1.0f);
        }
    }

    public final void setStrokeColor(int i) {
        this.mu = i;
        invalidateSelf();
    }

    public final int getIntrinsicWidth() {
        return this.dVR;
    }

    public final int getIntrinsicHeight() {
        return this.dVR;
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.width() != 0 && bounds.height() != 0) {
            int save;
            if (this.ft == null) {
                this.ft = new Paint();
                this.ft.setAntiAlias(true);
                this.ft.setStyle(Style.STROKE);
                this.ft.setStrokeWidth((float) this.dVS);
                this.ft.setStrokeCap(Cap.SQUARE);
                this.ft.setStrokeJoin(Join.MITER);
            }
            int save2 = canvas.save();
            canvas.translate((float) bounds.left, (float) bounds.top);
            int width = bounds.width();
            int height = bounds.height();
            Paint paint = this.ft;
            canvas.scale(((float) width) / dVP.width(), ((float) height) / dVP.height());
            canvas.translate(dVP.width() / 2.0f, dVP.height() / 2.0f);
            if (this.dVT) {
                save = canvas.save();
                paint.setColor(this.dVU);
                canvas.drawArc(dVQ, 0.0f, 360.0f, false, paint);
                canvas.restoreToCount(save);
            }
            save = canvas.save();
            paint.setColor(this.mu);
            canvas.rotate(this.dVW.fE);
            Canvas canvas2 = canvas;
            canvas2.drawArc(dVQ, -90.0f + ((this.dVV.mC + this.dVV.mA) * 360.0f), 360.0f * (this.dVV.mB - this.dVV.mA), false, paint);
            canvas.restoreToCount(save);
            canvas.restoreToCount(save2);
        }
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return -3;
    }

    public static Animator a(b bVar) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar, "trimPathStart", new float[]{0.0f, 0.75f});
        ofFloat.setDuration(1333);
        ofFloat.setInterpolator(e.dVX);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar, "trimPathEnd", new float[]{0.0f, 0.75f});
        ofFloat2.setDuration(1333);
        ofFloat2.setInterpolator(d.dVX);
        ofFloat2.setRepeatCount(-1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(bVar, "trimPathOffset", new float[]{0.0f, 0.25f});
        ofFloat3.setDuration(1333);
        ofFloat3.setInterpolator(a.dVX);
        ofFloat3.setRepeatCount(-1);
        Animator animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        return animatorSet;
    }

    public static Animator a(c cVar) {
        Animator ofFloat = ObjectAnimator.ofFloat(cVar, "rotation", new float[]{0.0f, 720.0f});
        ofFloat.setDuration(6665);
        ofFloat.setInterpolator(a.dVX);
        ofFloat.setRepeatCount(-1);
        return ofFloat;
    }
}
