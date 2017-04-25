package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.n;
import android.support.v4.view.x;
import android.support.v4.view.y;
import android.support.v4.widget.q;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private VelocityTracker fj;
    private int fk = -1;
    private q iA;
    private boolean iB;
    private int iC;
    private int iD = -1;
    private Runnable iz;

    private class a implements Runnable {
        private final CoordinatorLayout iE;
        private final V iF;
        final /* synthetic */ HeaderBehavior iG;

        a(HeaderBehavior headerBehavior, CoordinatorLayout coordinatorLayout, V v) {
            this.iG = headerBehavior;
            this.iE = coordinatorLayout;
            this.iF = v;
        }

        public final void run() {
            if (this.iF != null && this.iG.iA != null) {
                if (this.iG.iA.computeScrollOffset()) {
                    this.iG.c(this.iE, this.iF, this.iG.iA.getCurrY());
                    y.a(this.iF, (Runnable) this);
                    return;
                }
                this.iG.a(this.iE, this.iF);
            }
        }
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.iD < 0) {
            this.iD = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.iB) {
            return true;
        }
        int y;
        switch (n.d(motionEvent)) {
            case 0:
                this.iB = false;
                int x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                if (d(v) && coordinatorLayout.b(v, x, y)) {
                    this.iC = y;
                    this.fk = n.c(motionEvent, 0);
                    ah();
                    break;
                }
            case 1:
            case 3:
                this.iB = false;
                this.fk = -1;
                if (this.fj != null) {
                    this.fj.recycle();
                    this.fj = null;
                    break;
                }
                break;
            case 2:
                y = this.fk;
                if (y != -1) {
                    y = n.b(motionEvent, y);
                    if (y != -1) {
                        y = (int) n.e(motionEvent, y);
                        if (Math.abs(y - this.iC) > this.iD) {
                            this.iB = true;
                            this.iC = y;
                            break;
                        }
                    }
                }
                break;
        }
        if (this.fj != null) {
            this.fj.addMovement(motionEvent);
        }
        return this.iB;
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.iD < 0) {
            this.iD = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (n.d(motionEvent)) {
            case 0:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.b(v, (int) motionEvent.getX(), y) && d(v)) {
                    this.iC = y;
                    this.fk = n.c(motionEvent, 0);
                    ah();
                    break;
                }
                return false;
                break;
            case 1:
                if (this.fj != null) {
                    this.fj.addMovement(motionEvent);
                    this.fj.computeCurrentVelocity(1000);
                    a(coordinatorLayout, v, -b(v), x.b(this.fj, this.fk));
                    break;
                }
                break;
            case 2:
                int b = n.b(motionEvent, this.fk);
                if (b != -1) {
                    b = (int) n.e(motionEvent, b);
                    int i = this.iC - b;
                    if (!this.iB && Math.abs(i) > this.iD) {
                        this.iB = true;
                        i = i > 0 ? i - this.iD : i + this.iD;
                    }
                    if (this.iB) {
                        this.iC = b;
                        b(coordinatorLayout, v, i, c(v), 0);
                        break;
                    }
                }
                return false;
                break;
            case 3:
                break;
        }
        this.iB = false;
        this.fk = -1;
        if (this.fj != null) {
            this.fj.recycle();
            this.fj = null;
        }
        if (this.fj != null) {
            this.fj.addMovement(motionEvent);
        }
        return true;
    }

    final int c(CoordinatorLayout coordinatorLayout, V v, int i) {
        return a(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int L = L();
        if (i2 == 0 || L < i2 || L > i3) {
            return 0;
        }
        int a = n.a(i, i2, i3);
        if (L == a) {
            return 0;
        }
        f(a);
        return L - a;
    }

    int K() {
        return L();
    }

    final int b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return a(coordinatorLayout, v, K() - i, i2, i3);
    }

    final boolean a(CoordinatorLayout coordinatorLayout, V v, int i, float f) {
        if (this.iz != null) {
            v.removeCallbacks(this.iz);
            this.iz = null;
        }
        if (this.iA == null) {
            this.iA = q.a(v.getContext(), null);
        }
        this.iA.a(L(), 0, Math.round(f), 0, 0, i, 0);
        if (this.iA.computeScrollOffset()) {
            this.iz = new a(this, coordinatorLayout, v);
            y.a((View) v, this.iz);
            return true;
        }
        a(coordinatorLayout, v);
        return false;
    }

    void a(CoordinatorLayout coordinatorLayout, V v) {
    }

    boolean d(V v) {
        return false;
    }

    int c(V v) {
        return -v.getHeight();
    }

    int b(V v) {
        return v.getHeight();
    }

    private void ah() {
        if (this.fj == null) {
            this.fj = VelocityTracker.obtain();
        }
    }
}
