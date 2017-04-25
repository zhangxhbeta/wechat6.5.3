package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.n;
import android.support.v4.view.x;
import android.support.v4.view.y;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public final class u {
    private static final Interpolator xy = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    int DU;
    float[] DV;
    float[] DW;
    float[] DX;
    float[] DY;
    private int[] DZ;
    private int[] Ea;
    private int[] Eb;
    private int Ec;
    private float Ed;
    float Ee;
    int Ef;
    int Eg;
    private final a Eh;
    View Ei;
    private boolean Ej;
    private final ViewGroup Ek;
    private final Runnable El = new Runnable(this) {
        final /* synthetic */ u Em;

        {
            this.Em = r1;
        }

        public final void run() {
            this.Em.ao(0);
        }
    };
    private VelocityTracker fj;
    private int fk = -1;
    private q iA;
    public int iD;

    public static abstract class a {
        public abstract boolean a(View view, int i);

        public void j(int i) {
        }

        public void a(View view, int i, int i2) {
        }

        public void e(View view, int i) {
        }

        public void a(View view, float f, float f2) {
        }

        public void cu() {
        }

        public void m(int i, int i2) {
        }

        public int s(View view) {
            return 0;
        }

        public int N() {
            return 0;
        }

        public int c(View view, int i) {
            return 0;
        }

        public int b(View view, int i) {
            return 0;
        }
    }

    public static u a(ViewGroup viewGroup, a aVar) {
        return new u(viewGroup.getContext(), viewGroup, aVar);
    }

    public static u a(ViewGroup viewGroup, float f, a aVar) {
        u a = a(viewGroup, aVar);
        a.iD = (int) (((float) a.iD) * (1.0f / f));
        return a;
    }

    private u(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.Ek = viewGroup;
            this.Eh = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.Ef = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.iD = viewConfiguration.getScaledTouchSlop();
            this.Ed = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.Ee = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.iA = q.a(context, xy);
        }
    }

    public final void m(View view, int i) {
        if (view.getParent() != this.Ek) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.Ek + ")");
        }
        this.Ei = view;
        this.fk = i;
        this.Eh.e(view, i);
        ao(1);
    }

    public final void cancel() {
        this.fk = -1;
        if (this.DV != null) {
            Arrays.fill(this.DV, 0.0f);
            Arrays.fill(this.DW, 0.0f);
            Arrays.fill(this.DX, 0.0f);
            Arrays.fill(this.DY, 0.0f);
            Arrays.fill(this.DZ, 0);
            Arrays.fill(this.Ea, 0);
            Arrays.fill(this.Eb, 0);
            this.Ec = 0;
        }
        if (this.fj != null) {
            this.fj.recycle();
            this.fj = null;
        }
    }

    public final void abort() {
        cancel();
        if (this.DU == 2) {
            this.iA.getCurrX();
            this.iA.getCurrY();
            this.iA.abortAnimation();
            this.Eh.a(this.Ei, this.iA.getCurrX(), this.iA.getCurrY());
        }
        ao(0);
    }

    public final boolean e(View view, int i, int i2) {
        this.Ei = view;
        this.fk = -1;
        boolean e = e(i, i2, 0, 0);
        if (!(e || this.DU != 0 || this.Ei == null)) {
            this.Ei = null;
        }
        return e;
    }

    public final boolean p(int i, int i2) {
        if (this.Ej) {
            return e(i, i2, (int) x.a(this.fj, this.fk), (int) x.b(this.fj, this.fk));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean e(int i, int i2, int i3, int i4) {
        int left = this.Ei.getLeft();
        int top = this.Ei.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.iA.abortAnimation();
            ao(0);
            return false;
        }
        View view = this.Ei;
        int h = h(i3, (int) this.Ee, (int) this.Ed);
        int h2 = h(i4, (int) this.Ee, (int) this.Ed);
        int abs = Math.abs(i5);
        int abs2 = Math.abs(i6);
        int abs3 = Math.abs(h);
        int abs4 = Math.abs(h2);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        this.iA.startScroll(left, top, i5, i6, (int) (((h2 != 0 ? ((float) abs4) / ((float) i7) : ((float) abs2) / ((float) i8)) * ((float) g(i6, h2, this.Eh.N()))) + ((h != 0 ? ((float) abs3) / ((float) i7) : ((float) abs) / ((float) i8)) * ((float) g(i5, h, this.Eh.s(view))))));
        ao(2);
        return true;
    }

    private int g(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.Ek.getWidth();
        int i4 = width / 2;
        float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, ((float) Math.abs(i)) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(sin / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private static int h(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private static float f(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    public final boolean cL() {
        if (this.DU == 2) {
            boolean computeScrollOffset = this.iA.computeScrollOffset();
            int currX = this.iA.getCurrX();
            int currY = this.iA.getCurrY();
            int left = currX - this.Ei.getLeft();
            int top = currY - this.Ei.getTop();
            if (left != 0) {
                y.j(this.Ei, left);
            }
            if (top != 0) {
                y.i(this.Ei, top);
            }
            if (!(left == 0 && top == 0)) {
                this.Eh.a(this.Ei, currX, currY);
            }
            if (computeScrollOffset && currX == this.iA.getFinalX() && currY == this.iA.getFinalY()) {
                this.iA.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.Ek.post(this.El);
            }
        }
        if (this.DU == 2) {
            return true;
        }
        return false;
    }

    private void i(float f, float f2) {
        this.Ej = true;
        this.Eh.a(this.Ei, f, f2);
        this.Ej = false;
        if (this.DU == 1) {
            ao(0);
        }
    }

    private void am(int i) {
        if (this.DV != null) {
            this.DV[i] = 0.0f;
            this.DW[i] = 0.0f;
            this.DX[i] = 0.0f;
            this.DY[i] = 0.0f;
            this.DZ[i] = 0;
            this.Ea[i] = 0;
            this.Eb[i] = 0;
            this.Ec &= (1 << i) ^ -1;
        }
    }

    private void a(float f, float f2, int i) {
        int i2 = 0;
        if (this.DV == null || this.DV.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.DV != null) {
                System.arraycopy(this.DV, 0, obj, 0, this.DV.length);
                System.arraycopy(this.DW, 0, obj2, 0, this.DW.length);
                System.arraycopy(this.DX, 0, obj3, 0, this.DX.length);
                System.arraycopy(this.DY, 0, obj4, 0, this.DY.length);
                System.arraycopy(this.DZ, 0, obj5, 0, this.DZ.length);
                System.arraycopy(this.Ea, 0, obj6, 0, this.Ea.length);
                System.arraycopy(this.Eb, 0, obj7, 0, this.Eb.length);
            }
            this.DV = obj;
            this.DW = obj2;
            this.DX = obj3;
            this.DY = obj4;
            this.DZ = obj5;
            this.Ea = obj6;
            this.Eb = obj7;
        }
        float[] fArr = this.DV;
        this.DX[i] = f;
        fArr[i] = f;
        fArr = this.DW;
        this.DY[i] = f2;
        fArr[i] = f2;
        int[] iArr = this.DZ;
        int i3 = (int) f;
        int i4 = (int) f2;
        if (i3 < this.Ek.getLeft() + this.Ef) {
            i2 = 1;
        }
        if (i4 < this.Ek.getTop() + this.Ef) {
            i2 |= 4;
        }
        if (i3 > this.Ek.getRight() - this.Ef) {
            i2 |= 2;
        }
        if (i4 > this.Ek.getBottom() - this.Ef) {
            i2 |= 8;
        }
        iArr[i] = i2;
        this.Ec |= 1 << i;
    }

    private void i(MotionEvent motionEvent) {
        int f = n.f(motionEvent);
        for (int i = 0; i < f; i++) {
            int c = n.c(motionEvent, i);
            float d = n.d(motionEvent, i);
            float e = n.e(motionEvent, i);
            this.DX[c] = d;
            this.DY[c] = e;
        }
    }

    public final boolean an(int i) {
        return (this.Ec & (1 << i)) != 0;
    }

    final void ao(int i) {
        this.Ek.removeCallbacks(this.El);
        if (this.DU != i) {
            this.DU = i;
            this.Eh.j(i);
            if (this.DU == 0) {
                this.Ei = null;
            }
        }
    }

    private boolean n(View view, int i) {
        if (view == this.Ei && this.fk == i) {
            return true;
        }
        if (view == null || !this.Eh.a(view, i)) {
            return false;
        }
        this.fk = i;
        m(view, i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.v4.view.n.d(r14);
        r1 = android.support.v4.view.n.e(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.cancel();
    L_0x000d:
        r2 = r13.fj;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.fj = r2;
    L_0x0017:
        r2 = r13.fj;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x011f;
            case 2: goto L_0x008c;
            case 3: goto L_0x011f;
            case 4: goto L_0x001f;
            case 5: goto L_0x0057;
            case 6: goto L_0x0116;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.DU;
        r1 = 1;
        if (r0 != r1) goto L_0x0124;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = android.support.v4.view.n.c(r14, r2);
        r13.a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.q(r0, r1);
        r1 = r13.Ei;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.DU;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.n(r0, r2);
    L_0x0048:
        r0 = r13.DZ;
        r0 = r0[r2];
        r1 = r13.Eg;
        r0 = r0 & r1;
        if (r0 == 0) goto L_0x001f;
    L_0x0051:
        r0 = r13.Eh;
        r0.cu();
        goto L_0x001f;
    L_0x0057:
        r0 = android.support.v4.view.n.c(r14, r1);
        r2 = android.support.v4.view.n.d(r14, r1);
        r1 = android.support.v4.view.n.e(r14, r1);
        r13.a(r2, r1, r0);
        r3 = r13.DU;
        if (r3 != 0) goto L_0x0079;
    L_0x006a:
        r1 = r13.DZ;
        r0 = r1[r0];
        r1 = r13.Eg;
        r0 = r0 & r1;
        if (r0 == 0) goto L_0x001f;
    L_0x0073:
        r0 = r13.Eh;
        r0.cu();
        goto L_0x001f;
    L_0x0079:
        r3 = r13.DU;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x007e:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.q(r2, r1);
        r2 = r13.Ei;
        if (r1 != r2) goto L_0x001f;
    L_0x0088:
        r13.n(r1, r0);
        goto L_0x001f;
    L_0x008c:
        r0 = r13.DV;
        if (r0 == 0) goto L_0x001f;
    L_0x0090:
        r0 = r13.DW;
        if (r0 == 0) goto L_0x001f;
    L_0x0094:
        r2 = android.support.v4.view.n.f(r14);
        r0 = 0;
        r1 = r0;
    L_0x009a:
        if (r1 >= r2) goto L_0x0111;
    L_0x009c:
        r3 = android.support.v4.view.n.c(r14, r1);
        r0 = r13.ap(r3);
        if (r0 == 0) goto L_0x010b;
    L_0x00a6:
        r0 = android.support.v4.view.n.d(r14, r1);
        r4 = android.support.v4.view.n.e(r14, r1);
        r5 = r13.DV;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.DW;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.q(r0, r4);
        if (r4 == 0) goto L_0x010f;
    L_0x00c2:
        r0 = r13.b(r4, r5, r6);
        if (r0 == 0) goto L_0x010f;
    L_0x00c8:
        r0 = 1;
    L_0x00c9:
        if (r0 == 0) goto L_0x00fb;
    L_0x00cb:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.Eh;
        r8 = r9.c(r4, r8);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.Eh;
        r10 = r11.b(r4, r10);
        r11 = r13.Eh;
        r11 = r11.s(r4);
        r12 = r13.Eh;
        r12 = r12.N();
        if (r11 == 0) goto L_0x00f5;
    L_0x00f1:
        if (r11 <= 0) goto L_0x00fb;
    L_0x00f3:
        if (r8 != r7) goto L_0x00fb;
    L_0x00f5:
        if (r12 == 0) goto L_0x0111;
    L_0x00f7:
        if (r12 <= 0) goto L_0x00fb;
    L_0x00f9:
        if (r10 == r9) goto L_0x0111;
    L_0x00fb:
        r13.b(r5, r6, r3);
        r5 = r13.DU;
        r6 = 1;
        if (r5 == r6) goto L_0x0111;
    L_0x0103:
        if (r0 == 0) goto L_0x010b;
    L_0x0105:
        r0 = r13.n(r4, r3);
        if (r0 != 0) goto L_0x0111;
    L_0x010b:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x009a;
    L_0x010f:
        r0 = 0;
        goto L_0x00c9;
    L_0x0111:
        r13.i(r14);
        goto L_0x001f;
    L_0x0116:
        r0 = android.support.v4.view.n.c(r14, r1);
        r13.am(r0);
        goto L_0x001f;
    L_0x011f:
        r13.cancel();
        goto L_0x001f;
    L_0x0124:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.u.j(android.view.MotionEvent):boolean");
    }

    public final void k(MotionEvent motionEvent) {
        int i = 0;
        int d = n.d(motionEvent);
        int e = n.e(motionEvent);
        if (d == 0) {
            cancel();
        }
        if (this.fj == null) {
            this.fj = VelocityTracker.obtain();
        }
        this.fj.addMovement(motionEvent);
        float x;
        float y;
        View q;
        int left;
        switch (d) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = n.c(motionEvent, 0);
                q = q((int) x, (int) y);
                a(x, y, i);
                n(q, i);
                if ((this.DZ[i] & this.Eg) != 0) {
                    this.Eh.cu();
                    return;
                }
                return;
            case 1:
                if (this.DU == 1) {
                    cM();
                }
                cancel();
                return;
            case 2:
                int f;
                if (this.DU != 1) {
                    f = n.f(motionEvent);
                    while (i < f) {
                        d = n.c(motionEvent, i);
                        if (ap(d)) {
                            float d2 = n.d(motionEvent, i);
                            float e2 = n.e(motionEvent, i);
                            float f2 = d2 - this.DV[d];
                            float f3 = e2 - this.DW[d];
                            b(f2, f3, d);
                            if (this.DU != 1) {
                                q = q((int) d2, (int) e2);
                                if (b(q, f2, f3) && n(q, d)) {
                                }
                            }
                            i(motionEvent);
                            return;
                        }
                        i++;
                    }
                    i(motionEvent);
                    return;
                } else if (ap(this.fk)) {
                    i = n.b(motionEvent, this.fk);
                    x = n.d(motionEvent, i);
                    d = (int) (x - this.DX[this.fk]);
                    e = (int) (n.e(motionEvent, i) - this.DY[this.fk]);
                    f = this.Ei.getLeft() + d;
                    i = this.Ei.getTop() + e;
                    left = this.Ei.getLeft();
                    int top = this.Ei.getTop();
                    if (d != 0) {
                        f = this.Eh.c(this.Ei, f);
                        y.j(this.Ei, f - left);
                    }
                    if (e != 0) {
                        i = this.Eh.b(this.Ei, i);
                        y.i(this.Ei, i - top);
                    }
                    if (!(d == 0 && e == 0)) {
                        this.Eh.a(this.Ei, f, i);
                    }
                    i(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.DU == 1) {
                    i(0.0f, 0.0f);
                }
                cancel();
                return;
            case 5:
                i = n.c(motionEvent, e);
                x = n.d(motionEvent, e);
                y = n.e(motionEvent, e);
                a(x, y, i);
                if (this.DU == 0) {
                    n(q((int) x, (int) y), i);
                    if ((this.DZ[i] & this.Eg) != 0) {
                        this.Eh.cu();
                        return;
                    }
                    return;
                }
                if (f(this.Ei, (int) x, (int) y)) {
                    n(this.Ei, i);
                    return;
                }
                return;
            case 6:
                d = n.c(motionEvent, e);
                if (this.DU == 1 && d == this.fk) {
                    e = n.f(motionEvent);
                    while (i < e) {
                        left = n.c(motionEvent, i);
                        if (left != this.fk) {
                            if (q((int) n.d(motionEvent, i), (int) n.e(motionEvent, i)) == this.Ei && n(this.Ei, left)) {
                                i = this.fk;
                                if (i == -1) {
                                    cM();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        cM();
                    }
                }
                am(d);
                return;
            default:
                return;
        }
    }

    private void b(float f, float f2, int i) {
        int i2 = 1;
        if (!a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.Ea;
            iArr[i] = iArr[i] | i2;
            this.Eh.m(i2, i);
        }
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.DZ[i] & i2) != i2 || (this.Eg & i2) == 0 || (this.Eb[i] & i2) == i2 || (this.Ea[i] & i2) == i2) {
            return false;
        }
        if ((abs > ((float) this.iD) || abs2 > ((float) this.iD)) && (this.Ea[i] & i2) == 0 && abs > ((float) this.iD)) {
            return true;
        }
        return false;
    }

    private boolean b(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.Eh.s(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.Eh.N() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) > ((float) (this.iD * this.iD))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.iD)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f2) <= ((float) this.iD)) {
            return false;
        } else {
            return true;
        }
    }

    private void cM() {
        this.fj.computeCurrentVelocity(1000, this.Ed);
        i(f(x.a(this.fj, this.fk), this.Ee, this.Ed), f(x.b(this.fj, this.fk), this.Ee, this.Ed));
    }

    public static boolean f(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public final View q(int i, int i2) {
        for (int childCount = this.Ek.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.Ek.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private boolean ap(int i) {
        if (an(i)) {
            return true;
        }
        new StringBuilder("Ignoring pointerId=").append(i).append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}
