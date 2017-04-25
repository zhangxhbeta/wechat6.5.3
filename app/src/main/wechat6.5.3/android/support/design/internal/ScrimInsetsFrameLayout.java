package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.view.ao;
import android.support.v4.view.s;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class ScrimInsetsFrameLayout extends FrameLayout {
    private Drawable en;
    private Rect eo;
    private Rect ep;

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ep = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.cC, i, h.aS);
        this.en = obtainStyledAttributes.getDrawable(i.cD);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        y.b((View) this, new s(this) {
            final /* synthetic */ ScrimInsetsFrameLayout eq;

            {
                this.eq = r1;
            }

            public final ao a(View view, ao aoVar) {
                if (this.eq.eo == null) {
                    this.eq.eo = new Rect();
                }
                this.eq.eo.set(aoVar.getSystemWindowInsetLeft(), aoVar.getSystemWindowInsetTop(), aoVar.getSystemWindowInsetRight(), aoVar.getSystemWindowInsetBottom());
                this.eq.a(this.eq.eo);
                ScrimInsetsFrameLayout scrimInsetsFrameLayout = this.eq;
                boolean z = this.eq.eo.isEmpty() || this.eq.en == null;
                scrimInsetsFrameLayout.setWillNotDraw(z);
                y.E(this.eq);
                return aoVar.cd();
            }
        });
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.eo != null && this.en != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.ep.set(0, 0, width, this.eo.top);
            this.en.setBounds(this.ep);
            this.en.draw(canvas);
            this.ep.set(0, height - this.eo.bottom, width, height);
            this.en.setBounds(this.ep);
            this.en.draw(canvas);
            this.ep.set(0, this.eo.top, this.eo.left, height - this.eo.bottom);
            this.en.setBounds(this.ep);
            this.en.draw(canvas);
            this.ep.set(width - this.eo.right, this.eo.top, width, height - this.eo.bottom);
            this.en.setBounds(this.ep);
            this.en.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.en != null) {
            this.en.setCallback(this);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.en != null) {
            this.en.setCallback(null);
        }
    }

    public void a(Rect rect) {
    }
}
