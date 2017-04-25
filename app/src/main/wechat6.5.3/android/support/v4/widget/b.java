package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.y;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

final class b extends ImageView {
    AnimationListener Ai;
    private int Aj;

    private class a extends OvalShape {
        private RadialGradient Ak;
        private Paint Al = new Paint();
        private int Am;
        final /* synthetic */ b An;

        public a(b bVar, int i, int i2) {
            this.An = bVar;
            bVar.Aj = i;
            this.Am = i2;
            this.Ak = new RadialGradient((float) (this.Am / 2), (float) (this.Am / 2), (float) bVar.Aj, new int[]{1023410176, 0}, null, TileMode.CLAMP);
            this.Al.setShader(this.Ak);
        }

        public final void draw(Canvas canvas, Paint paint) {
            int width = this.An.getWidth();
            int height = this.An.getHeight();
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.Am / 2) + this.An.Aj), this.Al);
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.Am / 2), paint);
        }
    }

    public b(Context context) {
        Drawable shapeDrawable;
        super(context);
        float f = getContext().getResources().getDisplayMetrics().density;
        int i = (int) ((20.0f * f) * 2.0f);
        int i2 = (int) (1.75f * f);
        int i3 = (int) (0.0f * f);
        this.Aj = (int) (3.5f * f);
        if (co()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            y.g(this, f * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new a(this, this.Aj, i));
            y.a(this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.Aj, (float) i3, (float) i2, 503316480);
            int i4 = this.Aj;
            setPadding(i4, i4, i4, i4);
        }
        shapeDrawable.getPaint().setColor(-328966);
        setBackgroundDrawable(shapeDrawable);
    }

    private static boolean co() {
        return VERSION.SDK_INT >= 21;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!co()) {
            setMeasuredDimension(getMeasuredWidth() + (this.Aj * 2), getMeasuredHeight() + (this.Aj * 2));
        }
    }

    public final void onAnimationStart() {
        super.onAnimationStart();
        if (this.Ai != null) {
            this.Ai.onAnimationStart(getAnimation());
        }
    }

    public final void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.Ai != null) {
            this.Ai.onAnimationEnd(getAnimation());
        }
    }

    public final void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
