package android.support.b.a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Xml;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mmdb.DatabaseUtils;
import com.tencent.smtt.sdk.WebView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public final class f extends e {
    static final Mode mj = Mode.SRC_IN;
    f mk;
    private PorterDuffColorFilter ml;
    private ColorFilter mm;
    private boolean mn;
    boolean mo;
    private ConstantState mp;
    private final float[] mq;
    private final Matrix mr;
    private final Rect ms;

    private static class c {
        int lZ;
        final Matrix mG = new Matrix();
        final ArrayList<Object> mH = new ArrayList();
        float mI = 0.0f;
        float mJ = 0.0f;
        float mK = 0.0f;
        float mL = 1.0f;
        float mM = 1.0f;
        float mN = 0.0f;
        float mO = 0.0f;
        final Matrix mP = new Matrix();
        String mQ = null;
        int[] mt;

        public c(c cVar, android.support.v4.e.a<String, Object> aVar) {
            this.mI = cVar.mI;
            this.mJ = cVar.mJ;
            this.mK = cVar.mK;
            this.mL = cVar.mL;
            this.mM = cVar.mM;
            this.mN = cVar.mN;
            this.mO = cVar.mO;
            this.mt = cVar.mt;
            this.mQ = cVar.mQ;
            this.lZ = cVar.lZ;
            if (this.mQ != null) {
                aVar.put(this.mQ, this);
            }
            this.mP.set(cVar.mP);
            ArrayList arrayList = cVar.mH;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof c) {
                    this.mH.add(new c((c) obj, aVar));
                } else {
                    d bVar;
                    if (obj instanceof b) {
                        bVar = new b((b) obj);
                    } else if (obj instanceof a) {
                        bVar = new a((a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.mH.add(bVar);
                    if (bVar.mS != null) {
                        aVar.put(bVar.mS, bVar);
                    }
                }
            }
        }
    }

    private static class d {
        int lZ;
        protected android.support.b.a.c.b[] mR = null;
        String mS;

        public d(d dVar) {
            this.mS = dVar.mS;
            this.lZ = dVar.lZ;
            this.mR = c.a(dVar.mR);
        }

        public final void a(Path path) {
            path.reset();
            if (this.mR != null) {
                android.support.b.a.c.b[] bVarArr = this.mR;
                float[] fArr = new float[6];
                int i = 0;
                char c = 'm';
                while (i < bVarArr.length) {
                    int i2;
                    char c2 = bVarArr[i].mg;
                    float[] fArr2 = bVarArr[i].mh;
                    float f = fArr[0];
                    float f2 = fArr[1];
                    float f3 = fArr[2];
                    float f4 = fArr[3];
                    float f5 = fArr[4];
                    float f6 = fArr[5];
                    switch (c2) {
                        case 'A':
                        case 'a':
                            i2 = 7;
                            break;
                        case 'C':
                        case DatabaseUtils.STATEMENT_OTHER /*99*/:
                            i2 = 6;
                            break;
                        case 'H':
                        case 'V':
                        case MMGIFException.D_GIF_ERR_NO_SCRN_DSCR /*104*/:
                        case 'v':
                            i2 = 1;
                            break;
                        case 'L':
                        case 'M':
                        case 'T':
                        case MMGIFException.D_GIF_ERR_DATA_TOO_BIG /*108*/:
                        case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
                        case 't':
                            i2 = 2;
                            break;
                        case 'Q':
                        case 'S':
                        case MMGIFException.D_GIF_ERR_EOF_TOO_SOON /*113*/:
                        case 's':
                            i2 = 4;
                            break;
                        case 'Z':
                        case 'z':
                            path.close();
                            path.moveTo(f5, f6);
                            f4 = f6;
                            f3 = f5;
                            f2 = f6;
                            f = f5;
                            i2 = 2;
                            break;
                        default:
                            i2 = 2;
                            break;
                    }
                    int i3 = 0;
                    float f7 = f6;
                    float f8 = f5;
                    float f9 = f2;
                    float f10 = f;
                    while (i3 < fArr2.length) {
                        switch (c2) {
                            case 'A':
                                android.support.b.a.c.b.a(path, f10, f9, fArr2[i3 + 5], fArr2[i3 + 6], fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                                f3 = fArr2[i3 + 5];
                                f4 = fArr2[i3 + 6];
                                f6 = f7;
                                f5 = f8;
                                f2 = f4;
                                f = f3;
                                break;
                            case 'C':
                                path.cubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3], fArr2[i3 + 4], fArr2[i3 + 5]);
                                f5 = fArr2[i3 + 4];
                                f6 = fArr2[i3 + 5];
                                f3 = fArr2[i3 + 2];
                                f4 = fArr2[i3 + 3];
                                f2 = f6;
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'H':
                                path.lineTo(fArr2[i3 + 0], f9);
                                f6 = f7;
                                f2 = f9;
                                f = fArr2[i3 + 0];
                                f5 = f8;
                                break;
                            case 'L':
                                path.lineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                f5 = fArr2[i3 + 0];
                                f2 = fArr2[i3 + 1];
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'M':
                                f5 = fArr2[i3 + 0];
                                f6 = fArr2[i3 + 1];
                                if (i3 <= 0) {
                                    path.moveTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                    f2 = f6;
                                    f = f5;
                                    break;
                                }
                                path.lineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                f2 = f6;
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'Q':
                                path.quadTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                                f3 = fArr2[i3 + 0];
                                f4 = fArr2[i3 + 1];
                                f5 = fArr2[i3 + 2];
                                f2 = fArr2[i3 + 3];
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'S':
                                if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                                    f6 = (2.0f * f9) - f4;
                                    f4 = (2.0f * f10) - f3;
                                } else {
                                    f6 = f9;
                                    f4 = f10;
                                }
                                path.cubicTo(f4, f6, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                                f3 = fArr2[i3 + 0];
                                f4 = fArr2[i3 + 1];
                                f5 = fArr2[i3 + 2];
                                f2 = fArr2[i3 + 3];
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'T':
                                if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                                    f10 = (2.0f * f10) - f3;
                                    f9 = (2.0f * f9) - f4;
                                }
                                path.quadTo(f10, f9, fArr2[i3 + 0], fArr2[i3 + 1]);
                                f5 = fArr2[i3 + 0];
                                f4 = f9;
                                f3 = f10;
                                f2 = fArr2[i3 + 1];
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'V':
                                path.lineTo(f10, fArr2[i3 + 0]);
                                f5 = f8;
                                f2 = fArr2[i3 + 0];
                                f = f10;
                                f6 = f7;
                                break;
                            case 'a':
                                android.support.b.a.c.b.a(path, f10, f9, fArr2[i3 + 5] + f10, fArr2[i3 + 6] + f9, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                                f3 = f10 + fArr2[i3 + 5];
                                f4 = f9 + fArr2[i3 + 6];
                                f6 = f7;
                                f5 = f8;
                                f2 = f4;
                                f = f3;
                                break;
                            case DatabaseUtils.STATEMENT_OTHER /*99*/:
                                path.rCubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3], fArr2[i3 + 4], fArr2[i3 + 5]);
                                f3 = f10 + fArr2[i3 + 2];
                                f4 = f9 + fArr2[i3 + 3];
                                f2 = f9 + fArr2[i3 + 5];
                                f = f10 + fArr2[i3 + 4];
                                f6 = f7;
                                f5 = f8;
                                break;
                            case MMGIFException.D_GIF_ERR_NO_SCRN_DSCR /*104*/:
                                path.rLineTo(fArr2[i3 + 0], 0.0f);
                                f6 = f7;
                                f2 = f9;
                                f = f10 + fArr2[i3 + 0];
                                f5 = f8;
                                break;
                            case MMGIFException.D_GIF_ERR_DATA_TOO_BIG /*108*/:
                                path.rLineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                f2 = f9 + fArr2[i3 + 1];
                                f = f10 + fArr2[i3 + 0];
                                f6 = f7;
                                f5 = f8;
                                break;
                            case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
                                f5 = f10 + fArr2[i3 + 0];
                                f6 = f9 + fArr2[i3 + 1];
                                if (i3 <= 0) {
                                    path.rMoveTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                    f2 = f6;
                                    f = f5;
                                    break;
                                }
                                path.rLineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                f2 = f6;
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case MMGIFException.D_GIF_ERR_EOF_TOO_SOON /*113*/:
                                path.rQuadTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                                f3 = f10 + fArr2[i3 + 0];
                                f4 = f9 + fArr2[i3 + 1];
                                f2 = f9 + fArr2[i3 + 3];
                                f = f10 + fArr2[i3 + 2];
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 's':
                                f6 = 0.0f;
                                if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                                    f6 = f9 - f4;
                                    f4 = f10 - f3;
                                } else {
                                    f4 = 0.0f;
                                }
                                path.rCubicTo(f4, f6, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                                f3 = f10 + fArr2[i3 + 0];
                                f4 = f9 + fArr2[i3 + 1];
                                f2 = f9 + fArr2[i3 + 3];
                                f = f10 + fArr2[i3 + 2];
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 't':
                                float f11;
                                if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                                    f11 = f9 - f4;
                                    f4 = f10 - f3;
                                } else {
                                    f11 = 0.0f;
                                    f4 = 0.0f;
                                }
                                path.rQuadTo(f4, f11, fArr2[i3 + 0], fArr2[i3 + 1]);
                                f3 = f10 + f4;
                                f4 = f9 + f11;
                                f2 = f9 + fArr2[i3 + 1];
                                f = f10 + fArr2[i3 + 0];
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'v':
                                path.rLineTo(0.0f, fArr2[i3 + 0]);
                                f5 = f8;
                                f2 = f9 + fArr2[i3 + 0];
                                f = f10;
                                f6 = f7;
                                break;
                            default:
                                f6 = f7;
                                f5 = f8;
                                f2 = f9;
                                f = f10;
                                break;
                        }
                        i3 += i2;
                        f7 = f6;
                        f8 = f5;
                        f9 = f2;
                        f10 = f;
                        c = c2;
                    }
                    fArr[0] = f10;
                    fArr[1] = f9;
                    fArr[2] = f3;
                    fArr[3] = f4;
                    fArr[4] = f8;
                    fArr[5] = f7;
                    char c3 = bVarArr[i].mg;
                    i++;
                    c = c3;
                }
            }
        }

        public boolean aE() {
            return false;
        }
    }

    private static class e {
        private static final Matrix mV = new Matrix();
        private int lZ;
        private final Path mT;
        private final Path mU;
        private final Matrix mW;
        private Paint mX;
        private Paint mY;
        private PathMeasure mZ;
        private final c na;
        float nb;
        float nc;
        float nd;
        float ne;
        int nf;
        String ng;
        final android.support.v4.e.a<String, Object> nh;

        public e() {
            this.mW = new Matrix();
            this.nb = 0.0f;
            this.nc = 0.0f;
            this.nd = 0.0f;
            this.ne = 0.0f;
            this.nf = WebView.NORMAL_MODE_ALPHA;
            this.ng = null;
            this.nh = new android.support.v4.e.a();
            this.na = new c();
            this.mT = new Path();
            this.mU = new Path();
        }

        public e(e eVar) {
            this.mW = new Matrix();
            this.nb = 0.0f;
            this.nc = 0.0f;
            this.nd = 0.0f;
            this.ne = 0.0f;
            this.nf = WebView.NORMAL_MODE_ALPHA;
            this.ng = null;
            this.nh = new android.support.v4.e.a();
            this.na = new c(eVar.na, this.nh);
            this.mT = new Path(eVar.mT);
            this.mU = new Path(eVar.mU);
            this.nb = eVar.nb;
            this.nc = eVar.nc;
            this.nd = eVar.nd;
            this.ne = eVar.ne;
            this.lZ = eVar.lZ;
            this.nf = eVar.nf;
            this.ng = eVar.ng;
            if (eVar.ng != null) {
                this.nh.put(eVar.ng, this);
            }
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.mG.set(matrix);
            cVar.mG.preConcat(cVar.mP);
            for (int i3 = 0; i3 < cVar.mH.size(); i3++) {
                Object obj = cVar.mH.get(i3);
                if (obj instanceof c) {
                    a((c) obj, cVar.mG, canvas, i, i2, colorFilter);
                } else if (obj instanceof d) {
                    d dVar = (d) obj;
                    float f = ((float) i) / this.nd;
                    float f2 = ((float) i2) / this.ne;
                    float min = Math.min(f, f2);
                    Matrix matrix2 = cVar.mG;
                    this.mW.set(matrix2);
                    this.mW.postScale(f, f2);
                    float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
                    matrix2.mapVectors(fArr);
                    f2 = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
                    float hypot = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
                    float f3 = (fArr[3] * fArr[0]) - (fArr[1] * fArr[2]);
                    f2 = Math.max(f2, hypot);
                    f = 0.0f;
                    if (f2 > 0.0f) {
                        f = Math.abs(f3) / f2;
                    }
                    if (f != 0.0f) {
                        dVar.a(this.mT);
                        Path path = this.mT;
                        this.mU.reset();
                        if (dVar.aE()) {
                            this.mU.addPath(path, this.mW);
                            canvas.clipPath(this.mU, Op.REPLACE);
                        } else {
                            Paint paint;
                            b bVar = (b) dVar;
                            if (!(bVar.mA == 0.0f && bVar.mB == 1.0f)) {
                                hypot = (bVar.mA + bVar.mC) % 1.0f;
                                f3 = (bVar.mB + bVar.mC) % 1.0f;
                                if (this.mZ == null) {
                                    this.mZ = new PathMeasure();
                                }
                                this.mZ.setPath(this.mT, false);
                                float length = this.mZ.getLength();
                                hypot *= length;
                                f3 *= length;
                                path.reset();
                                if (hypot > f3) {
                                    this.mZ.getSegment(hypot, length, path, true);
                                    this.mZ.getSegment(0.0f, f3, path, true);
                                } else {
                                    this.mZ.getSegment(hypot, f3, path, true);
                                }
                                path.rLineTo(0.0f, 0.0f);
                            }
                            this.mU.addPath(path, this.mW);
                            if (bVar.mw != 0) {
                                if (this.mY == null) {
                                    this.mY = new Paint();
                                    this.mY.setStyle(Style.FILL);
                                    this.mY.setAntiAlias(true);
                                }
                                paint = this.mY;
                                paint.setColor(((((int) (((float) Color.alpha(bVar.mw)) * bVar.mz)) << 24) | (16777215 & bVar.mw)));
                                paint.setColorFilter(colorFilter);
                                canvas.drawPath(this.mU, paint);
                            }
                            if (bVar.mu != 0) {
                                if (this.mX == null) {
                                    this.mX = new Paint();
                                    this.mX.setStyle(Style.STROKE);
                                    this.mX.setAntiAlias(true);
                                }
                                paint = this.mX;
                                if (bVar.mE != null) {
                                    paint.setStrokeJoin(bVar.mE);
                                }
                                if (bVar.mD != null) {
                                    paint.setStrokeCap(bVar.mD);
                                }
                                paint.setStrokeMiter(bVar.mF);
                                paint.setColor(((((int) (((float) Color.alpha(bVar.mu)) * bVar.mx)) << 24) | (16777215 & bVar.mu)));
                                paint.setColorFilter(colorFilter);
                                paint.setStrokeWidth((f * min) * bVar.mv);
                                canvas.drawPath(this.mU, paint);
                            }
                        }
                    }
                }
            }
        }

        public final void a(Canvas canvas, int i, int i2) {
            a(this.na, mV, canvas, i, i2, null);
        }
    }

    private static class f extends ConstantState {
        int lZ;
        e ni;
        ColorStateList nj;
        Mode nk;
        boolean nl;
        Bitmap nm;
        ColorStateList nn;
        Mode no;
        int np;
        boolean nq;
        boolean nr;
        Paint ns;

        public f(f fVar) {
            this.nj = null;
            this.nk = f.mj;
            if (fVar != null) {
                this.lZ = fVar.lZ;
                this.ni = new e(fVar.ni);
                if (fVar.ni.mY != null) {
                    this.ni.mY = new Paint(fVar.ni.mY);
                }
                if (fVar.ni.mX != null) {
                    this.ni.mX = new Paint(fVar.ni.mX);
                }
                this.nj = fVar.nj;
                this.nk = fVar.nk;
                this.nl = fVar.nl;
            }
        }

        public final void f(int i, int i2) {
            this.nm.eraseColor(0);
            this.ni.a(new Canvas(this.nm), i, i2);
        }

        public f() {
            this.nj = null;
            this.nk = f.mj;
            this.ni = new e();
        }

        public final Drawable newDrawable() {
            return new f();
        }

        public final Drawable newDrawable(Resources resources) {
            return new f();
        }

        public final int getChangingConfigurations() {
            return this.lZ;
        }
    }

    private static class g extends ConstantState {
        private final ConstantState md;

        public g(ConstantState constantState) {
            this.md = constantState;
        }

        public final Drawable newDrawable() {
            Drawable fVar = new f();
            fVar.mi = (VectorDrawable) this.md.newDrawable();
            return fVar;
        }

        public final Drawable newDrawable(Resources resources) {
            Drawable fVar = new f();
            fVar.mi = (VectorDrawable) this.md.newDrawable(resources);
            return fVar;
        }

        public final Drawable newDrawable(Resources resources, Theme theme) {
            Drawable fVar = new f();
            fVar.mi = (VectorDrawable) this.md.newDrawable(resources, theme);
            return fVar;
        }

        public final boolean canApplyTheme() {
            return this.md.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.md.getChangingConfigurations();
        }
    }

    private static class a extends d {
        public a(a aVar) {
            super(aVar);
        }

        final void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.mS = string;
            }
            string = typedArray.getString(1);
            if (string != null) {
                this.mR = c.g(string);
            }
        }

        public final boolean aE() {
            return true;
        }
    }

    private static class b extends d {
        float mA = 0.0f;
        float mB = 1.0f;
        float mC = 0.0f;
        Cap mD = Cap.BUTT;
        Join mE = Join.MITER;
        float mF = 4.0f;
        private int[] mt;
        int mu = 0;
        float mv = 0.0f;
        int mw = 0;
        float mx = 1.0f;
        int my;
        float mz = 1.0f;

        public b(b bVar) {
            super(bVar);
            this.mt = bVar.mt;
            this.mu = bVar.mu;
            this.mv = bVar.mv;
            this.mx = bVar.mx;
            this.mw = bVar.mw;
            this.my = bVar.my;
            this.mz = bVar.mz;
            this.mA = bVar.mA;
            this.mB = bVar.mB;
            this.mC = bVar.mC;
            this.mD = bVar.mD;
            this.mE = bVar.mE;
            this.mF = bVar.mF;
        }

        final void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.mt = null;
            if (d.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.mS = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.mR = c.g(string);
                }
                this.mw = d.a(typedArray, xmlPullParser, "fillColor", 1, this.mw);
                this.mz = d.a(typedArray, xmlPullParser, "fillAlpha", 12, this.mz);
                int a = d.a(typedArray, xmlPullParser, "strokeLineCap", 8);
                Cap cap = this.mD;
                switch (a) {
                    case 0:
                        cap = Cap.BUTT;
                        break;
                    case 1:
                        cap = Cap.ROUND;
                        break;
                    case 2:
                        cap = Cap.SQUARE;
                        break;
                }
                this.mD = cap;
                a = d.a(typedArray, xmlPullParser, "strokeLineJoin", 9);
                Join join = this.mE;
                switch (a) {
                    case 0:
                        join = Join.MITER;
                        break;
                    case 1:
                        join = Join.ROUND;
                        break;
                    case 2:
                        join = Join.BEVEL;
                        break;
                }
                this.mE = join;
                this.mF = d.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.mF);
                this.mu = d.a(typedArray, xmlPullParser, "strokeColor", 3, this.mu);
                this.mx = d.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.mx);
                this.mv = d.a(typedArray, xmlPullParser, "strokeWidth", 4, this.mv);
                this.mB = d.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.mB);
                this.mC = d.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.mC);
                this.mA = d.a(typedArray, xmlPullParser, "trimPathStart", 5, this.mA);
            }
        }
    }

    public final /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public final /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public final /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public final /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public final /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public final /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public final /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public final /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public final /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public final /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public final /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public final /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public final /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public final /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    private f() {
        this.mo = true;
        this.mq = new float[9];
        this.mr = new Matrix();
        this.ms = new Rect();
        this.mk = new f();
    }

    private f(f fVar) {
        this.mo = true;
        this.mq = new float[9];
        this.mr = new Matrix();
        this.ms = new Rect();
        this.mk = fVar;
        this.ml = a(fVar.nj, fVar.nk);
    }

    public final Drawable mutate() {
        if (this.mi != null) {
            this.mi.mutate();
        } else if (!this.mn && super.mutate() == this) {
            this.mk = new f(this.mk);
            this.mn = true;
        }
        return this;
    }

    public final ConstantState getConstantState() {
        if (this.mi != null) {
            return new g(this.mi.getConstantState());
        }
        this.mk.lZ = getChangingConfigurations();
        return this.mk;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(android.graphics.Canvas r12) {
        /*
        r11 = this;
        r10 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r9 = 0;
        r4 = 1;
        r5 = 0;
        r0 = r11.mi;
        if (r0 == 0) goto L_0x0011;
    L_0x000b:
        r0 = r11.mi;
        r0.draw(r12);
    L_0x0010:
        return;
    L_0x0011:
        r0 = r11.ms;
        r11.copyBounds(r0);
        r0 = r11.ms;
        r0 = r0.width();
        if (r0 <= 0) goto L_0x0010;
    L_0x001e:
        r0 = r11.ms;
        r0 = r0.height();
        if (r0 <= 0) goto L_0x0010;
    L_0x0026:
        r0 = r11.mm;
        if (r0 != 0) goto L_0x00e0;
    L_0x002a:
        r0 = r11.ml;
    L_0x002c:
        r1 = r11.mr;
        r12.getMatrix(r1);
        r1 = r11.mr;
        r3 = r11.mq;
        r1.getValues(r3);
        r1 = r11.mq;
        r1 = r1[r5];
        r3 = java.lang.Math.abs(r1);
        r1 = r11.mq;
        r6 = 4;
        r1 = r1[r6];
        r1 = java.lang.Math.abs(r1);
        r6 = r11.mq;
        r6 = r6[r4];
        r6 = java.lang.Math.abs(r6);
        r7 = r11.mq;
        r8 = 3;
        r7 = r7[r8];
        r7 = java.lang.Math.abs(r7);
        r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1));
        if (r6 != 0) goto L_0x0062;
    L_0x005e:
        r6 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r6 == 0) goto L_0x014a;
    L_0x0062:
        r1 = r2;
    L_0x0063:
        r3 = r11.ms;
        r3 = r3.width();
        r3 = (float) r3;
        r2 = r2 * r3;
        r2 = (int) r2;
        r3 = r11.ms;
        r3 = r3.height();
        r3 = (float) r3;
        r1 = r1 * r3;
        r1 = (int) r1;
        r2 = java.lang.Math.min(r10, r2);
        r3 = java.lang.Math.min(r10, r1);
        if (r2 <= 0) goto L_0x0010;
    L_0x007f:
        if (r3 <= 0) goto L_0x0010;
    L_0x0081:
        r6 = r12.save();
        r1 = r11.ms;
        r1 = r1.left;
        r1 = (float) r1;
        r7 = r11.ms;
        r7 = r7.top;
        r7 = (float) r7;
        r12.translate(r1, r7);
        r1 = r11.ms;
        r1.offsetTo(r5, r5);
        r7 = r11.mk;
        r1 = r7.nm;
        if (r1 == 0) goto L_0x00b0;
    L_0x009d:
        r1 = r7.nm;
        r1 = r1.getWidth();
        if (r2 != r1) goto L_0x00e4;
    L_0x00a5:
        r1 = r7.nm;
        r1 = r1.getHeight();
        if (r3 != r1) goto L_0x00e4;
    L_0x00ad:
        r1 = r4;
    L_0x00ae:
        if (r1 != 0) goto L_0x00ba;
    L_0x00b0:
        r1 = android.graphics.Bitmap.Config.ARGB_8888;
        r1 = android.graphics.Bitmap.createBitmap(r2, r3, r1);
        r7.nm = r1;
        r7.nr = r4;
    L_0x00ba:
        r1 = r11.mo;
        if (r1 != 0) goto L_0x00e6;
    L_0x00be:
        r1 = r11.mk;
        r1.f(r2, r3);
    L_0x00c3:
        r2 = r11.mk;
        r3 = r11.ms;
        r1 = r2.ni;
        r1 = r1.nf;
        r7 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r1 >= r7) goto L_0x0127;
    L_0x00cf:
        r1 = r4;
    L_0x00d0:
        if (r1 != 0) goto L_0x0129;
    L_0x00d2:
        if (r0 != 0) goto L_0x0129;
    L_0x00d4:
        r0 = 0;
    L_0x00d5:
        r1 = r2.nm;
        r2 = 0;
        r12.drawBitmap(r1, r2, r3, r0);
        r12.restoreToCount(r6);
        goto L_0x0010;
    L_0x00e0:
        r0 = r11.mm;
        goto L_0x002c;
    L_0x00e4:
        r1 = r5;
        goto L_0x00ae;
    L_0x00e6:
        r1 = r11.mk;
        r7 = r1.nr;
        if (r7 != 0) goto L_0x0125;
    L_0x00ec:
        r7 = r1.nn;
        r8 = r1.nj;
        if (r7 != r8) goto L_0x0125;
    L_0x00f2:
        r7 = r1.no;
        r8 = r1.nk;
        if (r7 != r8) goto L_0x0125;
    L_0x00f8:
        r7 = r1.nq;
        r8 = r1.nl;
        if (r7 != r8) goto L_0x0125;
    L_0x00fe:
        r7 = r1.np;
        r1 = r1.ni;
        r1 = r1.nf;
        if (r7 != r1) goto L_0x0125;
    L_0x0106:
        r1 = r4;
    L_0x0107:
        if (r1 != 0) goto L_0x00c3;
    L_0x0109:
        r1 = r11.mk;
        r1.f(r2, r3);
        r1 = r11.mk;
        r2 = r1.nj;
        r1.nn = r2;
        r2 = r1.nk;
        r1.no = r2;
        r2 = r1.ni;
        r2 = r2.nf;
        r1.np = r2;
        r2 = r1.nl;
        r1.nq = r2;
        r1.nr = r5;
        goto L_0x00c3;
    L_0x0125:
        r1 = r5;
        goto L_0x0107;
    L_0x0127:
        r1 = r5;
        goto L_0x00d0;
    L_0x0129:
        r1 = r2.ns;
        if (r1 != 0) goto L_0x0139;
    L_0x012d:
        r1 = new android.graphics.Paint;
        r1.<init>();
        r2.ns = r1;
        r1 = r2.ns;
        r1.setFilterBitmap(r4);
    L_0x0139:
        r1 = r2.ns;
        r4 = r2.ni;
        r4 = r4.nf;
        r1.setAlpha(r4);
        r1 = r2.ns;
        r1.setColorFilter(r0);
        r0 = r2.ns;
        goto L_0x00d5;
    L_0x014a:
        r2 = r3;
        goto L_0x0063;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.b.a.f.draw(android.graphics.Canvas):void");
    }

    public final int getAlpha() {
        if (this.mi != null) {
            return android.support.v4.b.a.a.d(this.mi);
        }
        return this.mk.ni.nf;
    }

    public final void setAlpha(int i) {
        if (this.mi != null) {
            this.mi.setAlpha(i);
        } else if (this.mk.ni.nf != i) {
            this.mk.ni.nf = i;
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.mi != null) {
            this.mi.setColorFilter(colorFilter);
            return;
        }
        this.mm = colorFilter;
        invalidateSelf();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void setTint(int i) {
        if (this.mi != null) {
            android.support.v4.b.a.a.a(this.mi, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.mi != null) {
            android.support.v4.b.a.a.a(this.mi, colorStateList);
            return;
        }
        f fVar = this.mk;
        if (fVar.nj != colorStateList) {
            fVar.nj = colorStateList;
            this.ml = a(colorStateList, fVar.nk);
            invalidateSelf();
        }
    }

    public final void setTintMode(Mode mode) {
        if (this.mi != null) {
            android.support.v4.b.a.a.a(this.mi, mode);
            return;
        }
        f fVar = this.mk;
        if (fVar.nk != mode) {
            fVar.nk = mode;
            this.ml = a(fVar.nj, mode);
            invalidateSelf();
        }
    }

    public final boolean isStateful() {
        if (this.mi != null) {
            return this.mi.isStateful();
        }
        return super.isStateful() || !(this.mk == null || this.mk.nj == null || !this.mk.nj.isStateful());
    }

    protected final boolean onStateChange(int[] iArr) {
        if (this.mi != null) {
            return this.mi.setState(iArr);
        }
        f fVar = this.mk;
        if (fVar.nj == null || fVar.nk == null) {
            return false;
        }
        this.ml = a(fVar.nj, fVar.nk);
        invalidateSelf();
        return true;
    }

    public final int getOpacity() {
        if (this.mi != null) {
            return this.mi.getOpacity();
        }
        return -3;
    }

    public final int getIntrinsicWidth() {
        if (this.mi != null) {
            return this.mi.getIntrinsicWidth();
        }
        return (int) this.mk.ni.nb;
    }

    public final int getIntrinsicHeight() {
        if (this.mi != null) {
            return this.mi.getIntrinsicHeight();
        }
        return (int) this.mk.ni.nc;
    }

    public final boolean canApplyTheme() {
        if (this.mi != null) {
            android.support.v4.b.a.a.e(this.mi);
        }
        return false;
    }

    public static f a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 23) {
            f fVar = new f();
            fVar.mi = VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
            fVar.mp = new g(fVar.mi.getConstantState());
            return fVar;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (XmlPullParserException e) {
            return null;
        } catch (IOException e2) {
            return null;
        }
    }

    public static f a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f fVar = new f();
        fVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return fVar;
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.mi != null) {
            this.mi.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.mi != null) {
            android.support.v4.b.a.a.a(this.mi, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        f fVar = this.mk;
        fVar.ni = new e();
        TypedArray a = e.a(resources, theme, attributeSet, a.lP);
        f fVar2 = this.mk;
        e eVar = fVar2.ni;
        int a2 = d.a(a, xmlPullParser, "tintMode", 6);
        Mode mode = Mode.SRC_IN;
        switch (a2) {
            case 3:
                mode = Mode.SRC_OVER;
                break;
            case 5:
                mode = Mode.SRC_IN;
                break;
            case 9:
                mode = Mode.SRC_ATOP;
                break;
            case 14:
                mode = Mode.MULTIPLY;
                break;
            case 15:
                mode = Mode.SCREEN;
                break;
            case 16:
                mode = Mode.ADD;
                break;
        }
        fVar2.nk = mode;
        ColorStateList colorStateList = a.getColorStateList(1);
        if (colorStateList != null) {
            fVar2.nj = colorStateList;
        }
        boolean z = fVar2.nl;
        if (d.a(xmlPullParser, "autoMirrored")) {
            z = a.getBoolean(5, z);
        }
        fVar2.nl = z;
        eVar.nd = d.a(a, xmlPullParser, "viewportWidth", 7, eVar.nd);
        eVar.ne = d.a(a, xmlPullParser, "viewportHeight", 8, eVar.ne);
        if (eVar.nd <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (eVar.ne <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            eVar.nb = a.getDimension(3, eVar.nb);
            eVar.nc = a.getDimension(2, eVar.nc);
            if (eVar.nb <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (eVar.nc <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                eVar.nf = (int) (d.a(a, xmlPullParser, "alpha", 4, ((float) eVar.nf) / 255.0f) * 255.0f);
                String string = a.getString(0);
                if (string != null) {
                    eVar.ng = string;
                    eVar.nh.put(string, eVar);
                }
                a.recycle();
                fVar.lZ = getChangingConfigurations();
                fVar.nr = true;
                b(resources, xmlPullParser, attributeSet, theme);
                this.ml = a(fVar.nj, fVar.nk);
            }
        }
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f fVar = this.mk;
        e eVar = fVar.ni;
        Object obj = 1;
        Stack stack = new Stack();
        stack.push(eVar.na);
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            Object obj2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) stack.peek();
                if ("path".equals(name)) {
                    d bVar = new b();
                    TypedArray a = e.a(resources, theme, attributeSet, a.lR);
                    bVar.a(a, xmlPullParser);
                    a.recycle();
                    cVar.mH.add(bVar);
                    if (bVar.mS != null) {
                        eVar.nh.put(bVar.mS, bVar);
                    }
                    obj2 = null;
                    fVar.lZ = bVar.lZ | fVar.lZ;
                } else if ("clip-path".equals(name)) {
                    d aVar = new a();
                    if (d.a(xmlPullParser, "pathData")) {
                        r8 = e.a(resources, theme, attributeSet, a.lS);
                        aVar.a(r8);
                        r8.recycle();
                    }
                    cVar.mH.add(aVar);
                    if (aVar.mS != null) {
                        eVar.nh.put(aVar.mS, aVar);
                    }
                    fVar.lZ |= aVar.lZ;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        c cVar2 = new c();
                        r8 = e.a(resources, theme, attributeSet, a.lQ);
                        cVar2.mt = null;
                        cVar2.mI = d.a(r8, xmlPullParser, "rotation", 5, cVar2.mI);
                        cVar2.mJ = r8.getFloat(1, cVar2.mJ);
                        cVar2.mK = r8.getFloat(2, cVar2.mK);
                        cVar2.mL = d.a(r8, xmlPullParser, "scaleX", 3, cVar2.mL);
                        cVar2.mM = d.a(r8, xmlPullParser, "scaleY", 4, cVar2.mM);
                        cVar2.mN = d.a(r8, xmlPullParser, "translateX", 6, cVar2.mN);
                        cVar2.mO = d.a(r8, xmlPullParser, "translateY", 7, cVar2.mO);
                        String string = r8.getString(0);
                        if (string != null) {
                            cVar2.mQ = string;
                        }
                        cVar2.mP.reset();
                        cVar2.mP.postTranslate(-cVar2.mJ, -cVar2.mK);
                        cVar2.mP.postScale(cVar2.mL, cVar2.mM);
                        cVar2.mP.postRotate(cVar2.mI, 0.0f, 0.0f);
                        cVar2.mP.postTranslate(cVar2.mN + cVar2.mJ, cVar2.mO + cVar2.mK);
                        r8.recycle();
                        cVar.mH.add(cVar2);
                        stack.push(cVar2);
                        if (cVar2.mQ != null) {
                            eVar.nh.put(cVar2.mQ, cVar2);
                        }
                        fVar.lZ |= cVar2.lZ;
                    }
                    obj2 = obj;
                }
            } else {
                if (eventType == 3) {
                    if ("group".equals(xmlPullParser.getName())) {
                        stack.pop();
                    }
                }
                obj2 = obj;
            }
            obj = obj2;
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        if (this.mi != null) {
            this.mi.setBounds(i, i2, i3, i4);
        } else {
            super.setBounds(i, i2, i3, i4);
        }
    }

    public final void setBounds(Rect rect) {
        if (this.mi != null) {
            this.mi.setBounds(rect);
        } else {
            super.setBounds(rect);
        }
    }

    public final int getChangingConfigurations() {
        if (this.mi != null) {
            return this.mi.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mk.getChangingConfigurations();
    }

    public final void invalidateSelf() {
        if (this.mi != null) {
            this.mi.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public final void scheduleSelf(Runnable runnable, long j) {
        if (this.mi != null) {
            this.mi.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.mi != null) {
            return this.mi.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public final void unscheduleSelf(Runnable runnable) {
        if (this.mi != null) {
            this.mi.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
