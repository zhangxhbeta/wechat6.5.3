package com.tencent.mm.svg.b;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Gravity;
import android.view.View;
import com.tencent.mm.svg.c.c;
import com.tencent.smtt.sdk.WebView;

public abstract class b extends Drawable {
    public long Ov = 0;
    protected int gDf = 0;
    protected int gDg = 0;
    protected int nyr = 0;
    protected boolean nys = false;
    protected Paint nyt = new Paint();
    protected View nyu;
    protected int nyv = 0;
    protected int nyw = 0;
    protected float nyx;
    protected final Rect tG = new Rect();

    public b(int i, int i2, int i3) {
        this.nyv = i;
        this.nyw = i2;
        this.nyx = 1.0f;
        this.gDf = this.nyv;
        this.gDg = this.nyw;
        setLevel(10000);
        this.nyr = i3;
    }

    protected final void byc() {
        this.tG.set(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
    }

    protected void onBoundsChange(Rect rect) {
        this.nys = true;
    }

    protected boolean onLevelChange(int i) {
        bye();
        return super.onLevelChange(i);
    }

    protected final void byd() {
        if (this.nys) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.tG);
        }
        this.nys = false;
    }

    private void bye() {
        this.nyu = a.t(this);
        if (this.nyu != null) {
            a.b(this.nyu, this.nyt);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        bye();
        return super.setVisible(z, z2);
    }

    @TargetApi(17)
    public void setAlpha(int i) {
        this.nyt.setAlpha(i);
        if (this.nyu != null && VERSION.SDK_INT >= 17) {
            try {
                this.nyu.setLayerPaint(this.nyt);
            } catch (Throwable e) {
                c.a("MicroMsg.SVGDrawable", e, "fucking samsung", new Object[0]);
            }
        }
    }

    @TargetApi(17)
    public void setColorFilter(ColorFilter colorFilter) {
        this.nyt.setColorFilter(colorFilter);
        if (this.nyu != null && VERSION.SDK_INT >= 17) {
            try {
                this.nyu.setLayerPaint(this.nyt);
            } catch (Throwable e) {
                c.a("MicroMsg.SVGDrawable", e, "fucking samsung", new Object[0]);
            }
        }
    }

    public int getOpacity() {
        if (this.nyu != null && this.nyu.getAlpha() < 1.0f) {
            return -3;
        }
        if (this.nyt == null || this.nyt.getAlpha() >= WebView.NORMAL_MODE_ALPHA) {
            return 0;
        }
        return -3;
    }

    protected final void f(Canvas canvas) {
        if (com.tencent.mm.svg.c.b.byh()) {
            int height = this.tG.height() / 3;
            canvas.save();
            Paint paint = new Paint();
            paint.setStyle(Style.FILL);
            paint.setColor(-12303292);
            paint.setAlpha(127);
            paint.setTextSize((float) height);
            paint.setStrokeWidth(1.0f);
            canvas.translate(((float) this.tG.width()) - paint.measureText("SVG"), (float) ((this.tG.height() * 2) / 3));
            canvas.drawText("SVG", 0.0f, (float) height, paint);
            canvas.restore();
        }
    }

    public int getIntrinsicWidth() {
        return this.gDf;
    }

    public int getIntrinsicHeight() {
        return this.gDg;
    }
}
