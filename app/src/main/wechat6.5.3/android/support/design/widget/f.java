package android.support.design.widget;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.design.a.i;
import android.support.v4.d.d;
import android.support.v4.d.e;
import android.support.v4.view.y;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.mm.plugin.gif.MMGIFException;

final class f {
    private static final boolean fF = (VERSION.SDK_INT < 18);
    private static final Paint fG = null;
    private boolean fH;
    float fI;
    private final Rect fJ;
    private final Rect fK;
    private final RectF fL;
    private int fM = 16;
    private int fN = 16;
    float fO = 15.0f;
    float fP = 15.0f;
    int fQ;
    int fR;
    private float fS;
    private float fT;
    private float fU;
    private float fV;
    private float fW;
    private float fX;
    Typeface fY;
    Typeface fZ;
    private Typeface ga;
    private CharSequence gb;
    private boolean gc;
    private boolean gd;
    private Bitmap ge;
    private Paint gf;
    private float gg;
    private float gh;
    private float gi;
    private float gj;
    private boolean gk;
    private final TextPaint gl;
    Interpolator gm;
    private Interpolator gn;
    private float go;
    private float gp;
    private float gq;
    private int gr;
    private float gs;
    private float gt;
    private float gu;
    private int gv;
    CharSequence mText;
    private final View mView;

    public f(View view) {
        this.mView = view;
        this.gl = new TextPaint(129);
        this.fK = new Rect();
        this.fJ = new Rect();
        this.fL = new RectF();
    }

    final void a(Interpolator interpolator) {
        this.gn = interpolator;
        Q();
    }

    final void l(int i) {
        if (this.fR != i) {
            this.fR = i;
            Q();
        }
    }

    final void a(int i, int i2, int i3, int i4) {
        if (!a(this.fJ, i, i2, i3, i4)) {
            this.fJ.set(i, i2, i3, i4);
            this.gk = true;
            O();
        }
    }

    final void b(int i, int i2, int i3, int i4) {
        if (!a(this.fK, i, i2, i3, i4)) {
            this.fK.set(i, i2, i3, i4);
            this.gk = true;
            O();
        }
    }

    private void O() {
        boolean z = this.fK.width() > 0 && this.fK.height() > 0 && this.fJ.width() > 0 && this.fJ.height() > 0;
        this.fH = z;
    }

    final void m(int i) {
        if (this.fM != i) {
            this.fM = i;
            Q();
        }
    }

    final void n(int i) {
        if (this.fN != i) {
            this.fN = i;
            Q();
        }
    }

    final void o(int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, i.dj);
        if (obtainStyledAttributes.hasValue(i.do)) {
            this.fR = obtainStyledAttributes.getColor(i.do, this.fR);
        }
        if (obtainStyledAttributes.hasValue(i.dp)) {
            this.fP = (float) obtainStyledAttributes.getDimensionPixelSize(i.dp, (int) this.fP);
        }
        this.gr = obtainStyledAttributes.getInt(i.dk, 0);
        this.gp = obtainStyledAttributes.getFloat(i.dl, 0.0f);
        this.gq = obtainStyledAttributes.getFloat(i.dm, 0.0f);
        this.go = obtainStyledAttributes.getFloat(i.dn, 0.0f);
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.fY = q(i);
        }
        Q();
    }

    final void p(int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, i.dj);
        if (obtainStyledAttributes.hasValue(i.do)) {
            this.fQ = obtainStyledAttributes.getColor(i.do, this.fQ);
        }
        if (obtainStyledAttributes.hasValue(i.dp)) {
            this.fO = (float) obtainStyledAttributes.getDimensionPixelSize(i.dp, (int) this.fO);
        }
        this.gv = obtainStyledAttributes.getInt(i.dk, 0);
        this.gt = obtainStyledAttributes.getFloat(i.dl, 0.0f);
        this.gu = obtainStyledAttributes.getFloat(i.dm, 0.0f);
        this.gs = obtainStyledAttributes.getFloat(i.dn, 0.0f);
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.fZ = q(i);
        }
        Q();
    }

    private Typeface q(int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                Typeface create = Typeface.create(string, 0);
                return create;
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    final void e(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f != this.fI) {
            this.fI = f;
            P();
        }
    }

    private void P() {
        f(this.fI);
    }

    private void f(float f) {
        this.fL.left = a((float) this.fJ.left, (float) this.fK.left, f, this.gm);
        this.fL.top = a(this.fS, this.fT, f, this.gm);
        this.fL.right = a((float) this.fJ.right, (float) this.fK.right, f, this.gm);
        this.fL.bottom = a((float) this.fJ.bottom, (float) this.fK.bottom, f, this.gm);
        this.fW = a(this.fU, this.fV, f, this.gm);
        this.fX = a(this.fS, this.fT, f, this.gm);
        g(a(this.fO, this.fP, f, this.gn));
        if (this.fR != this.fQ) {
            this.gl.setColor(b(this.fQ, this.fR, f));
        } else {
            this.gl.setColor(this.fR);
        }
        this.gl.setShadowLayer(a(this.gs, this.go, f, null), a(this.gt, this.gp, f, null), a(this.gu, this.gq, f, null), b(this.gv, this.gr, f));
        y.E(this.mView);
    }

    public final void draw(Canvas canvas) {
        int save = canvas.save();
        if (this.gb != null && this.fH) {
            float f;
            float f2 = this.fW;
            float f3 = this.fX;
            int i = (!this.gd || this.ge == null) ? 0 : 1;
            if (i != 0) {
                f = this.gg * this.gi;
            } else {
                this.gl.ascent();
                f = 0.0f;
                this.gl.descent();
            }
            if (i != 0) {
                f3 += f;
            }
            if (this.gi != 1.0f) {
                canvas.scale(this.gi, this.gi, f2, f3);
            }
            if (i != 0) {
                canvas.drawBitmap(this.ge, f2, f3, this.gf);
            } else {
                canvas.drawText(this.gb, 0, this.gb.length(), f2, f3, this.gl);
            }
        }
        canvas.restoreToCount(save);
    }

    private void g(float f) {
        h(f);
        boolean z = fF && this.gi != 1.0f;
        this.gd = z;
        if (this.gd && this.ge == null && !this.fJ.isEmpty() && !TextUtils.isEmpty(this.gb)) {
            f(0.0f);
            this.gg = this.gl.ascent();
            this.gh = this.gl.descent();
            int round = Math.round(this.gl.measureText(this.gb, 0, this.gb.length()));
            int round2 = Math.round(this.gh - this.gg);
            if (round > 0 && round2 > 0) {
                this.ge = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
                new Canvas(this.ge).drawText(this.gb, 0, this.gb.length(), 0.0f, ((float) round2) - this.gl.descent(), this.gl);
                if (this.gf == null) {
                    this.gf = new Paint(3);
                }
            }
        }
        y.E(this.mView);
    }

    private void h(float f) {
        boolean z = true;
        if (this.mText != null) {
            float width;
            float f2;
            boolean z2;
            if (c(f, this.fP)) {
                width = (float) this.fK.width();
                float f3 = this.fP;
                this.gi = 1.0f;
                if (this.ga != this.fY) {
                    this.ga = this.fY;
                    f2 = width;
                    width = f3;
                    z2 = true;
                } else {
                    f2 = width;
                    width = f3;
                    z2 = false;
                }
            } else {
                f2 = (float) this.fJ.width();
                width = this.fO;
                if (this.ga != this.fZ) {
                    this.ga = this.fZ;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (c(f, this.fO)) {
                    this.gi = 1.0f;
                } else {
                    this.gi = f / this.fO;
                }
            }
            if (f2 > 0.0f) {
                if (this.gj != width || this.gk || r0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.gj = width;
                this.gk = false;
            }
            if (this.gb == null || r0) {
                this.gl.setTextSize(this.gj);
                this.gl.setTypeface(this.ga);
                TextPaint textPaint = this.gl;
                if (this.gi != 1.0f) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                textPaint.setLinearText(z2);
                CharSequence ellipsize = TextUtils.ellipsize(this.mText, this.gl, f2, TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.gb)) {
                    d dVar;
                    this.gb = ellipsize;
                    CharSequence charSequence = this.gb;
                    if (y.I(this.mView) != 1) {
                        z = false;
                    }
                    if (z) {
                        dVar = e.vi;
                    } else {
                        dVar = e.vh;
                    }
                    this.gc = dVar.a(charSequence, charSequence.length());
                }
            }
        }
    }

    public final void Q() {
        int i = 1;
        float f = 0.0f;
        if (this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            float measureText;
            float f2 = this.gj;
            h(this.fP);
            if (this.gb != null) {
                measureText = this.gl.measureText(this.gb, 0, this.gb.length());
            } else {
                measureText = 0.0f;
            }
            int absoluteGravity = android.support.v4.view.e.getAbsoluteGravity(this.fN, this.gc ? 1 : 0);
            switch (absoluteGravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                case 48:
                    this.fT = ((float) this.fK.top) - this.gl.ascent();
                    break;
                case 80:
                    this.fT = (float) this.fK.bottom;
                    break;
                default:
                    this.fT = (((this.gl.descent() - this.gl.ascent()) / 2.0f) - this.gl.descent()) + ((float) this.fK.centerY());
                    break;
            }
            switch (absoluteGravity & 8388615) {
                case 1:
                    this.fV = ((float) this.fK.centerX()) - (measureText / 2.0f);
                    break;
                case 5:
                    this.fV = ((float) this.fK.right) - measureText;
                    break;
                default:
                    this.fV = (float) this.fK.left;
                    break;
            }
            h(this.fO);
            if (this.gb != null) {
                f = this.gl.measureText(this.gb, 0, this.gb.length());
            }
            int i2 = this.fM;
            if (!this.gc) {
                i = 0;
            }
            i2 = android.support.v4.view.e.getAbsoluteGravity(i2, i);
            switch (i2 & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                case 48:
                    this.fS = ((float) this.fJ.top) - this.gl.ascent();
                    break;
                case 80:
                    this.fS = (float) this.fJ.bottom;
                    break;
                default:
                    this.fS = (((this.gl.descent() - this.gl.ascent()) / 2.0f) - this.gl.descent()) + ((float) this.fJ.centerY());
                    break;
            }
            switch (i2 & 8388615) {
                case 1:
                    this.fU = ((float) this.fJ.centerX()) - (f / 2.0f);
                    break;
                case 5:
                    this.fU = ((float) this.fJ.right) - f;
                    break;
                default:
                    this.fU = (float) this.fJ.left;
                    break;
            }
            R();
            g(f2);
            P();
        }
    }

    final void setText(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.mText)) {
            this.mText = charSequence;
            this.gb = null;
            R();
            Q();
        }
    }

    private void R() {
        if (this.ge != null) {
            this.ge.recycle();
            this.ge = null;
        }
    }

    private static boolean c(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    private static int b(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((f2 * ((float) Color.blue(i))) + (((float) Color.blue(i2)) * f)));
    }

    private static float a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return a.b(f, f2, f3);
    }

    private static boolean a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
