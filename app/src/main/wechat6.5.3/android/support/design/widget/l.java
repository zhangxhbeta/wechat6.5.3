package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.a.c;
import android.view.ViewTreeObserver.OnPreDrawListener;

abstract class l {
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] PRESSED_ENABLED_STATE_SET = new int[]{16842919, 16842910};
    static final int[] it = new int[]{16842908, 16842910};
    private final Rect gF = new Rect();
    Drawable im;
    Drawable in;
    d io;
    Drawable iq;
    float ir;
    float is;
    final VisibilityAwareImageButton iu;
    final p iv;
    OnPreDrawListener iw;

    interface a {
    }

    abstract void a(ColorStateList colorStateList, Mode mode, int i, int i2);

    abstract void a(a aVar, boolean z);

    abstract void aa();

    abstract void b(Rect rect);

    abstract void b(a aVar, boolean z);

    abstract void b(int[] iArr);

    abstract void i(float f);

    abstract void j(float f);

    abstract void setBackgroundTintList(ColorStateList colorStateList);

    abstract void setBackgroundTintMode(Mode mode);

    l(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        this.iu = visibilityAwareImageButton;
        this.iv = pVar;
    }

    final void ae() {
        Rect rect = this.gF;
        b(rect);
        c(rect);
        this.iv.c(rect.left, rect.top, rect.right, rect.bottom);
    }

    void c(Rect rect) {
    }

    boolean ac() {
        return false;
    }

    final d a(int i, ColorStateList colorStateList) {
        Resources resources = this.iu.getResources();
        d af = af();
        int color = resources.getColor(c.ae);
        int color2 = resources.getColor(c.ad);
        int color3 = resources.getColor(c.ab);
        int color4 = resources.getColor(c.ac);
        af.fx = color;
        af.fy = color2;
        af.fz = color3;
        af.fA = color4;
        float f = (float) i;
        if (af.fw != f) {
            af.fw = f;
            af.ft.setStrokeWidth(f * 1.3333f);
            af.fD = true;
            af.invalidateSelf();
        }
        af.c(colorStateList);
        return af;
    }

    d af() {
        return new d();
    }

    void ad() {
    }

    static GradientDrawable ag() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }
}
