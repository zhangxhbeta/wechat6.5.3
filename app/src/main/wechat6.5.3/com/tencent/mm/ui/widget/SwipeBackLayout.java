package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.n;
import android.support.v4.view.x;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.j;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SwipeBackLayout extends FrameLayout {
    private float AM;
    public View Hq;
    private Rect gF;
    public boolean hVC;
    private boolean oQ;
    public boolean paQ;
    private boolean peA;
    public a peB;
    private float peq;
    private int per;
    private int pes;
    public com.tencent.mm.ui.mogic.a pet;
    private float peu;
    public Drawable pev;
    public boolean pew;
    private boolean pex;
    public boolean pey;
    public boolean pez;

    public interface a {
        void Rj();

        void Rk();

        void onCancel();
    }

    private class b extends com.tencent.mm.ui.mogic.a.a implements com.tencent.mm.ui.base.b.a {
        int peC;
        int peD;
        int peE;
        final /* synthetic */ SwipeBackLayout peF;

        private b(SwipeBackLayout swipeBackLayout) {
            this.peF = swipeBackLayout;
            this.peC = 0;
            this.peD = 0;
            this.peE = 0;
        }

        public final boolean ya(int i) {
            boolean z;
            com.tencent.mm.ui.mogic.a a = this.peF.pet;
            if ((a.Ec & (1 << i)) != 0) {
                z = true;
            } else {
                z = false;
            }
            return z && (a.DZ[i] & 1) != 0;
        }

        public final int bIN() {
            return 1;
        }

        public final void dq(int i, int i2) {
            if (this.peF.pey) {
                this.peF.peu = Math.abs(((float) i) / ((float) (this.peF.Hq.getWidth() + this.peF.pev.getIntrinsicWidth())));
                this.peF.per = i;
                this.peF.pes = i2;
                this.peF.invalidate();
                if (Float.compare(this.peF.peu, 1.0f) >= 0 && !this.peF.pez) {
                    this.peF.pez = true;
                    ad.o(new Runnable(this) {
                        final /* synthetic */ b peG;

                        {
                            this.peG = r1;
                        }

                        public final void run() {
                            if (this.peG.peF.peB != null) {
                                this.peG.peF.peB.Rj();
                                v.d("MicroMsg.SwipeBackLayout", "ashutest:: on popOut");
                            }
                            this.peG.peF.paQ = false;
                        }
                    });
                } else if (Float.compare(this.peF.peu, 0.01f) <= 0) {
                    this.peF.paQ = false;
                }
                if (this.peF.pet.DU == 1) {
                    j.al(this.peF.peu);
                }
            }
        }

        public final void a(View view, float f, float f2) {
            int width = view.getWidth();
            this.peD = 0;
            this.peE = 0;
            width = (f > 0.0f || (f == 0.0f && this.peF.peu > this.peF.peq)) ? (width + this.peF.pev.getIntrinsicWidth()) + 10 : 0;
            this.peD = width;
            v.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(this.peD), Integer.valueOf(this.peE), Boolean.valueOf(this.peF.pey));
            this.peF.paQ = true;
            if (this.peF.pey) {
                com.tencent.mm.ui.mogic.a a = this.peF.pet;
                int i = this.peD;
                int i2 = this.peE;
                if (a.Ej) {
                    a.e(i, i2, (int) x.a(a.fj, a.fk), (int) x.b(a.fj, a.fk));
                    this.peF.invalidate();
                    return;
                }
                throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
            }
            this.peF.peA = true;
        }

        public final int c(View view, int i) {
            if (this.peF.pey) {
                int max = Math.max(this.peC, i);
                this.peC = 0;
                return Math.min(view.getWidth(), Math.max(max, 0));
            }
            this.peC = Math.max(this.peC, i);
            return 0;
        }

        public final void j(int i) {
            v.i("MicroMsg.SwipeBackLayout", "ashutest::onViewDragStateChanged state %d, requestedTranslucent %B fastRelease %B", Integer.valueOf(i), Boolean.valueOf(this.peF.pex), Boolean.valueOf(this.peF.peA));
            if (1 == i) {
                v.i("MicroMsg.SwipeBackLayout", "ashutest:: on drag");
                if (this.peF.getContext() instanceof Activity) {
                    ((Activity) this.peF.getContext()).getWindow().getDecorView().setBackgroundResource(2131690078);
                }
                if (this.peF.peB != null) {
                    this.peF.peB.Rk();
                }
                this.peF.pez = false;
                if (this.peF.pey) {
                    j.al(0.0f);
                }
            }
            if (i == 0 && !this.peF.peA) {
                v.i("MicroMsg.SwipeBackLayout", "ashutest:: on cancel");
                if (this.peF.peB != null) {
                    this.peF.peB.onCancel();
                }
                j.al(1.0f);
            }
            if (1 == i && this.peF.pew && (this.peF.getContext() instanceof Activity) && !this.peF.pey && !this.peF.pex) {
                v.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging");
                this.peF.pex = true;
                Activity activity = (Activity) this.peF.getContext();
                if (d.dX(16)) {
                    v.w("MicroMsg.ActivityUtil", "convertActivityToTranslucent::Android Version Error %d", Integer.valueOf(VERSION.SDK_INT));
                } else {
                    try {
                        Object newProxyInstance;
                        Class[] declaredClasses = Activity.class.getDeclaredClasses();
                        int length = declaredClasses.length;
                        int i2 = 0;
                        Class cls = null;
                        while (i2 < length) {
                            Class cls2 = declaredClasses[i2];
                            if (!cls2.getSimpleName().contains("TranslucentConversionListener")) {
                                cls2 = cls;
                            }
                            i2++;
                            cls = cls2;
                        }
                        if (this != null) {
                            InvocationHandler bVar = new b();
                            bVar.nRB = new WeakReference(this);
                            newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, bVar);
                        } else {
                            newProxyInstance = null;
                        }
                        Method declaredMethod;
                        if (d.dX(21)) {
                            declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls});
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(activity, new Object[]{newProxyInstance});
                        } else {
                            declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls, ActivityOptions.class});
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(activity, new Object[]{newProxyInstance, null});
                        }
                    } catch (Throwable th) {
                        v.a("MicroMsg.ActivityUtil", th, "call convertActivityToTranslucent Fail: %s", th.getMessage());
                    }
                }
            }
            if (2 == i) {
                boolean z;
                v.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", Integer.valueOf(this.peD));
                if (this.peD > 0) {
                    z = true;
                } else {
                    z = false;
                }
                j.r(z, this.peD);
            }
        }

        public final void jg(final boolean z) {
            ad.o(new Runnable(this) {
                final /* synthetic */ b peG;

                public final void run() {
                    v.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", Boolean.valueOf(z), Integer.valueOf(this.peG.peD));
                    this.peG.peF.pex = z;
                    if (!z) {
                        this.peG.peF.paQ = false;
                    } else if (this.peG.peD > 0) {
                        j.al(0.0f);
                    } else {
                        j.al(1.0f);
                    }
                    this.peG.peF.ks(z);
                    if (z && this.peG.peF.peA) {
                        if (this.peG.peD == 0) {
                            j.a(this.peG.peF.Hq, 200, 0.0f, new com.tencent.mm.ui.tools.j.a(this) {
                                final /* synthetic */ AnonymousClass2 peI;

                                {
                                    this.peI = r1;
                                }

                                public final void onAnimationEnd() {
                                    this.peI.peG.peF.paQ = false;
                                }

                                public final void bJm() {
                                    onAnimationEnd();
                                }
                            });
                        } else {
                            j.a(this.peG.peF.Hq, 200, (float) this.peG.peD, new com.tencent.mm.ui.tools.j.a(this) {
                                final /* synthetic */ AnonymousClass2 peI;

                                {
                                    this.peI = r1;
                                }

                                public final void onAnimationEnd() {
                                    this.peI.peG.peF.pez = true;
                                    ad.o(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass2 peJ;

                                        {
                                            this.peJ = r1;
                                        }

                                        public final void run() {
                                            if (this.peJ.peI.peG.peF.peB != null) {
                                                this.peJ.peI.peG.peF.peB.Rj();
                                                v.d("MicroMsg.SwipeBackLayout", "ashutest:: on onSwipeBack");
                                            }
                                            j.al(1.0f);
                                            this.peJ.peI.peG.peF.paQ = false;
                                        }
                                    });
                                }

                                public final void bJm() {
                                    onAnimationEnd();
                                }
                            });
                            j.r(true, this.peG.peD);
                        }
                    }
                    this.peG.peF.peA = false;
                }
            });
        }
    }

    public SwipeBackLayout(Context context) {
        this(context, null);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.peq = 0.3f;
        this.hVC = true;
        this.gF = new Rect();
        this.pew = true;
        this.pex = false;
        this.pey = false;
        this.pez = false;
        this.paQ = false;
        this.peA = false;
        this.peB = null;
        this.pev = getResources().getDrawable(2130839103);
        setFocusable(true);
        setDescendantFocusability(262144);
        init();
    }

    public final void init() {
        this.pet = com.tencent.mm.ui.mogic.a.a(this, new b());
        this.pet.Eg = 1;
        float f = getResources().getDisplayMetrics().density;
        float f2 = 100.0f * f;
        f *= 300.0f;
        this.pet.Ee = f2;
        this.pet.Ed = f;
        this.per = 0;
        this.pes = 0;
    }

    public final void ks(boolean z) {
        v.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", Boolean.valueOf(z));
        this.pey = z;
    }

    public final boolean bKu() {
        bKv();
        return this.paQ;
    }

    public void onFinishInflate() {
        this.Hq = this;
    }

    public final boolean bKv() {
        if (!this.paQ) {
            return false;
        }
        if (Float.compare((float) this.Hq.getLeft(), 0.01f) > 0) {
            return true;
        }
        this.paQ = false;
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.hVC) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (bKv()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        try {
            int d;
            int e;
            float x;
            View q;
            float d2;
            float e2;
            float f;
            float e3;
            if (this.pet.DU == 1) {
                com.tencent.mm.ui.mogic.a aVar = this.pet;
                d = n.d(motionEvent);
                e = n.e(motionEvent);
                if (d == 0) {
                    aVar.cancel();
                }
                if (aVar.fj == null) {
                    aVar.fj = VelocityTracker.obtain();
                }
                aVar.fj.addMovement(motionEvent);
                int e4;
                int left;
                int left2;
                switch (d) {
                    case 0:
                        x = motionEvent.getX();
                        float y = motionEvent.getY();
                        e = n.c(motionEvent, 0);
                        q = aVar.q((int) x, (int) y);
                        aVar.a(x, y, e);
                        aVar.n(q, e);
                        return (aVar.Eg & aVar.DZ[e]) != 0 ? true : true;
                    case 1:
                        if (aVar.DU == 1) {
                            aVar.cM();
                        }
                        aVar.cancel();
                        return true;
                    case 2:
                        if (aVar.DU == 1) {
                            d = n.b(motionEvent, aVar.fk);
                            e = (int) (n.d(motionEvent, d) - aVar.DX[aVar.fk]);
                            e4 = (int) (n.e(motionEvent, d) - aVar.DY[aVar.fk]);
                            left = aVar.Ei.getLeft() + e;
                            d = aVar.Ei.getTop() + e4;
                            left2 = aVar.Ei.getLeft();
                            int top = aVar.Ei.getTop();
                            if (e != 0) {
                                left = aVar.oPJ.c(aVar.Ei, left);
                                aVar.Ei.offsetLeftAndRight(left - left2);
                            }
                            if (e4 != 0) {
                                aVar.Ei.offsetTopAndBottom(0 - top);
                                d = 0;
                            }
                            if (!(e == 0 && e4 == 0)) {
                                aVar.oPJ.dq(left, d);
                            }
                            aVar.i(motionEvent);
                            return true;
                        }
                        left = n.f(motionEvent);
                        d = 0;
                        while (d < left) {
                            e = n.c(motionEvent, d);
                            d2 = n.d(motionEvent, d);
                            e2 = n.e(motionEvent, d);
                            f = d2 - aVar.DV[e];
                            aVar.b(f, e2 - aVar.DW[e], e);
                            if (aVar.DU != 1) {
                                q = aVar.q((int) d2, (int) e2);
                                if (!aVar.k(q, f) || !aVar.n(q, e)) {
                                    d++;
                                }
                            }
                            aVar.i(motionEvent);
                            return true;
                        }
                        aVar.i(motionEvent);
                        return true;
                    case 3:
                        if (aVar.DU == 1) {
                            aVar.i(0.0f, 0.0f);
                        }
                        aVar.cancel();
                        return true;
                    case 5:
                        left = n.c(motionEvent, e);
                        x = n.d(motionEvent, e);
                        e3 = n.e(motionEvent, e);
                        aVar.a(x, e3, left);
                        if (aVar.DU == 0) {
                            aVar.n(aVar.q((int) x, (int) e3), left);
                            return true;
                        }
                        boolean z;
                        d = (int) x;
                        e = (int) e3;
                        q = aVar.Ei;
                        if (q == null || d < q.getLeft() || d >= q.getRight() || e < q.getTop() || e >= q.getBottom()) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            return true;
                        }
                        aVar.n(aVar.Ei, left);
                        return true;
                    case 6:
                        e = n.c(motionEvent, e);
                        if (aVar.DU == 1 && e == aVar.fk) {
                            e4 = n.f(motionEvent);
                            for (d = 0; d < e4; d++) {
                                left2 = n.c(motionEvent, d);
                                if (left2 != aVar.fk) {
                                    if (aVar.q((int) n.d(motionEvent, d), (int) n.e(motionEvent, d)) == aVar.Ei && aVar.n(aVar.Ei, left2)) {
                                        d = aVar.fk;
                                        if (d == -1) {
                                            aVar.cM();
                                        }
                                    }
                                }
                            }
                            d = -1;
                            if (d == -1) {
                                aVar.cM();
                            }
                        }
                        aVar.am(e);
                        return true;
                    default:
                        return true;
                }
            }
            com.tencent.mm.ui.mogic.a aVar2 = this.pet;
            d = n.d(motionEvent);
            int e5 = n.e(motionEvent);
            if (d == 0) {
                aVar2.cancel();
            }
            if (aVar2.fj == null) {
                aVar2.fj = VelocityTracker.obtain();
            }
            aVar2.fj.addMovement(motionEvent);
            float y2;
            switch (d) {
                case 0:
                    x = motionEvent.getX();
                    y2 = motionEvent.getY();
                    e = n.c(motionEvent, 0);
                    aVar2.a(x, y2, e);
                    View q2 = aVar2.q((int) x, (int) y2);
                    if (q2 == aVar2.Ei && aVar2.DU == 2) {
                        aVar2.n(q2, e);
                    }
                    if ((aVar2.DZ[e] & aVar2.Eg) != 0) {
                        break;
                    }
                    break;
                case 1:
                case 3:
                    aVar2.cancel();
                    break;
                case 2:
                    e5 = n.f(motionEvent);
                    d = 0;
                    while (d < e5) {
                        e = n.c(motionEvent, d);
                        d2 = n.d(motionEvent, d);
                        e2 = n.e(motionEvent, d);
                        f = d2 - aVar2.DV[e];
                        aVar2.b(f, e2 - aVar2.DW[e], e);
                        if (aVar2.DU != 1) {
                            q = aVar2.q((int) d2, (int) e2);
                            if (q == null || !aVar2.k(q, f) || !aVar2.n(q, e)) {
                                d++;
                            }
                        }
                        aVar2.i(motionEvent);
                        break;
                    }
                    aVar2.i(motionEvent);
                    break;
                case 5:
                    d = n.c(motionEvent, e5);
                    e3 = n.d(motionEvent, e5);
                    y2 = n.e(motionEvent, e5);
                    aVar2.a(e3, y2, d);
                    if (aVar2.DU != 0 && aVar2.DU == 2) {
                        View q3 = aVar2.q((int) e3, (int) y2);
                        if (q3 == aVar2.Ei) {
                            aVar2.n(q3, d);
                            break;
                        }
                    }
                    break;
                case 6:
                    aVar2.am(n.c(motionEvent, e5));
                    break;
            }
            if (aVar2.DU == 1) {
                motionEvent.setAction(3);
                super.dispatchTouchEvent(motionEvent);
                return true;
            }
            super.dispatchTouchEvent(motionEvent);
            return true;
        } catch (Throwable e6) {
            v.a("MicroMsg.SwipeBackLayout", e6, "got an NullPointerException", new Object[0]);
            return false;
        } catch (Throwable e62) {
            v.a("MicroMsg.SwipeBackLayout", e62, "got an IllegalArgumentException", new Object[0]);
            return false;
        } catch (Throwable e622) {
            v.a("MicroMsg.SwipeBackLayout", e622, "got an ArrayIndexOutOfBoundsException", new Object[0]);
            return false;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.oQ = true;
        if (this.Hq != null) {
            this.Hq.layout(this.per, this.pes, this.per + this.Hq.getMeasuredWidth(), this.pes + this.Hq.getMeasuredHeight());
        }
        this.oQ = false;
    }

    public void requestLayout() {
        if (!this.oQ) {
            super.requestLayout();
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        Object obj = view == this.Hq ? 1 : null;
        boolean drawChild = super.drawChild(canvas, view, j);
        if (!(Float.compare(this.AM, 0.0f) <= 0 || obj == null || this.pet.DU == 0)) {
            Rect rect = this.gF;
            view.getHitRect(rect);
            this.pev.setBounds(rect.left - this.pev.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
            this.pev.setAlpha((int) (this.AM * 255.0f));
            this.pev.draw(canvas);
        }
        return drawChild;
    }

    public void computeScroll() {
        this.AM = Math.max(0.0f, 1.0f - this.peu);
        com.tencent.mm.ui.mogic.a aVar = this.pet;
        if (aVar.DU == 2) {
            boolean computeScrollOffset = aVar.iA.computeScrollOffset();
            int currX = aVar.iA.getCurrX();
            int currY = aVar.iA.getCurrY();
            int left = currX - aVar.Ei.getLeft();
            int top = currY - aVar.Ei.getTop();
            if (left != 0) {
                aVar.Ei.offsetLeftAndRight(left);
            }
            if (top != 0) {
                aVar.Ei.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                aVar.oPJ.dq(currX, currY);
            }
            if (computeScrollOffset && currX == aVar.iA.getFinalX() && currY == aVar.iA.getFinalY()) {
                aVar.iA.abortAnimation();
                computeScrollOffset = aVar.iA.isFinished();
            }
            if (!computeScrollOffset) {
                aVar.Ek.post(aVar.El);
            }
        }
        if ((aVar.DU == 2 ? 1 : null) != null) {
            y.E(this);
        }
    }
}
