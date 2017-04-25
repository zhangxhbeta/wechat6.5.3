package com.tencent.mm.ui.mogic;

import android.content.Context;
import android.support.v4.view.n;
import android.support.v4.view.x;
import android.support.v4.widget.q;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Arrays;

public final class a {
    private static final Interpolator xy = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    public int DU;
    public float[] DV;
    public float[] DW;
    public float[] DX;
    public float[] DY;
    public int[] DZ;
    private int[] Ea;
    private int[] Eb;
    public int Ec;
    public float Ed;
    public float Ee;
    private int Ef;
    public int Eg;
    public View Ei;
    public boolean Ej;
    public final ViewGroup Ek;
    public final Runnable El = new Runnable(this) {
        final /* synthetic */ a oPK;

        {
            this.oPK = r1;
        }

        public final void run() {
            this.oPK.ao(0);
        }
    };
    public VelocityTracker fj;
    public int fk = -1;
    public q iA;
    private int iD;
    public final a oPJ;

    public static abstract class a {
        public abstract boolean ya(int i);

        public void j(int i) {
        }

        public void dq(int i, int i2) {
        }

        public void a(View view, float f, float f2) {
        }

        public int bIN() {
            return 0;
        }

        public int c(View view, int i) {
            return 0;
        }
    }

    public static a a(ViewGroup viewGroup, a aVar) {
        return new a(viewGroup.getContext(), viewGroup, aVar);
    }

    private a(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.Ek = viewGroup;
            this.oPJ = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.Ef = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.iD = viewConfiguration.getScaledTouchSlop();
            this.Ed = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.Ee = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.iA = q.a(context, xy);
        }
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

    public final boolean e(int i, int i2, int i3, int i4) {
        int left = this.Ei.getLeft();
        int top = this.Ei.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.iA.abortAnimation();
            ao(0);
            return false;
        }
        int h = h(i3, (int) this.Ee, (int) this.Ed);
        int h2 = h(i4, (int) this.Ee, (int) this.Ed);
        int abs = Math.abs(i5);
        int abs2 = Math.abs(i6);
        int abs3 = Math.abs(h);
        int abs4 = Math.abs(h2);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        v.d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf((int) (((h2 != 0 ? ((float) abs4) / ((float) i7) : ((float) abs2) / ((float) i8)) * ((float) g(i6, h2, 0))) + ((h != 0 ? ((float) abs3) / ((float) i7) : ((float) abs) / ((float) i8)) * ((float) g(i5, h, this.oPJ.bIN()))))));
        this.iA.startScroll(left, top, i5, i6, abs3);
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

    public final void i(float f, float f2) {
        this.Ej = true;
        this.oPJ.a(this.Ei, f, f2);
        this.Ej = false;
        if (this.DU == 1) {
            ao(0);
        }
    }

    public final void am(int i) {
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

    public final void a(float f, float f2, int i) {
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

    public final void i(MotionEvent motionEvent) {
        int f = n.f(motionEvent);
        for (int i = 0; i < f; i++) {
            int c = n.c(motionEvent, i);
            float d = n.d(motionEvent, i);
            float e = n.e(motionEvent, i);
            this.DX[c] = d;
            this.DY[c] = e;
        }
    }

    final void ao(int i) {
        if (this.DU != i) {
            this.DU = i;
            this.oPJ.j(i);
            if (i == 0) {
                this.Ei = null;
            }
        }
    }

    public final boolean n(View view, int i) {
        if (view == this.Ei && this.fk == i) {
            return true;
        }
        if (view == null || !this.oPJ.ya(i)) {
            return false;
        }
        this.fk = i;
        if (view.getParent() != this.Ek) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.Ek + ")");
        }
        this.Ei = view;
        this.fk = i;
        ao(1);
        return true;
    }

    public final void b(float f, float f2, int i) {
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
            iArr[i] = i2 | iArr[i];
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

    public final boolean k(View view, float f) {
        if (view == null) {
            return false;
        }
        if (!(this.oPJ.bIN() > 0) || Math.abs(f) <= ((float) this.iD)) {
            return false;
        }
        return true;
    }

    public final void cM() {
        this.fj.computeCurrentVelocity(1000, this.Ed);
        i(f(x.a(this.fj, this.fk), this.Ee, this.Ed), f(x.b(this.fj, this.fk), this.Ee, this.Ed));
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
}
