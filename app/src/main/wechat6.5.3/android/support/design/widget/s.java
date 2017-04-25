package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.view.n;
import android.support.v4.view.y;
import android.support.v4.widget.u;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class s<V extends View> extends Behavior<V> {
    private u fb;
    private boolean fc;
    private final android.support.v4.widget.u.a fo = new android.support.v4.widget.u.a(this) {
        private int fk = -1;
        private int jM;
        final /* synthetic */ s jN;

        {
            this.jN = r2;
        }

        public final boolean a(View view, int i) {
            return this.fk == -1 && this.jN.r(view);
        }

        public final void e(View view, int i) {
            this.fk = i;
            this.jM = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public final void j(int i) {
            if (this.jN.jF != null) {
                this.jN.jF.w(i);
            }
        }

        public final void a(View view, float f, float f2) {
            boolean z;
            int i;
            boolean z2 = true;
            this.fk = -1;
            int width = view.getWidth();
            if (f != 0.0f) {
                z = y.I(view) == 1;
                z = this.jN.jI == 2 ? true : this.jN.jI == 0 ? z ? f < 0.0f : f > 0.0f : this.jN.jI == 1 ? z ? f > 0.0f : f < 0.0f : false;
            } else {
                z = Math.abs(view.getLeft() - this.jM) >= Math.round(((float) view.getWidth()) * this.jN.jJ);
            }
            if (z) {
                i = view.getLeft() < this.jM ? this.jM - width : this.jM + width;
            } else {
                i = this.jM;
                z2 = false;
            }
            if (this.jN.fb.p(i, view.getTop())) {
                y.a(view, new b(this.jN, view, z2));
            } else if (z2 && this.jN.jF != null) {
                this.jN.jF.onDismiss(view);
            }
        }

        public final int s(View view) {
            return view.getWidth();
        }

        public final int c(View view, int i) {
            int width;
            int i2;
            Object obj = y.I(view) == 1 ? 1 : null;
            if (this.jN.jI == 0) {
                if (obj != null) {
                    width = this.jM - view.getWidth();
                    i2 = this.jM;
                } else {
                    width = this.jM;
                    i2 = this.jM + view.getWidth();
                }
            } else if (this.jN.jI != 1) {
                width = this.jM - view.getWidth();
                i2 = this.jM + view.getWidth();
            } else if (obj != null) {
                width = this.jM;
                i2 = this.jM + view.getWidth();
            } else {
                width = this.jM - view.getWidth();
                i2 = this.jM;
            }
            return Math.min(Math.max(width, i), i2);
        }

        public final int b(View view, int i) {
            return view.getTop();
        }

        public final void a(View view, int i, int i2) {
            float width = ((float) this.jM) + (((float) view.getWidth()) * this.jN.jK);
            float width2 = ((float) this.jM) + (((float) view.getWidth()) * this.jN.jL);
            if (((float) i) <= width) {
                y.d(view, 1.0f);
            } else if (((float) i) >= width2) {
                y.d(view, 0.0f);
            } else {
                y.d(view, s.c(0.0f, 1.0f - s.d(width, width2, (float) i), 1.0f));
            }
        }
    };
    a jF;
    private float jG = 0.0f;
    private boolean jH;
    int jI = 2;
    private float jJ = 0.5f;
    float jK = 0.0f;
    float jL = 0.5f;

    public interface a {
        void onDismiss(View view);

        void w(int i);
    }

    private class b implements Runnable {
        final /* synthetic */ s jN;
        private final boolean jO;
        private final View mView;

        b(s sVar, View view, boolean z) {
            this.jN = sVar;
            this.mView = view;
            this.jO = z;
        }

        public final void run() {
            if (this.jN.fb != null && this.jN.fb.cL()) {
                y.a(this.mView, (Runnable) this);
            } else if (this.jO && this.jN.jF != null) {
                this.jN.jF.onDismiss(this.mView);
            }
        }
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        switch (n.d(motionEvent)) {
            case 1:
            case 3:
                if (this.fc) {
                    this.fc = false;
                    return false;
                }
                break;
            default:
                boolean z;
                if (coordinatorLayout.b(v, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    z = false;
                } else {
                    z = true;
                }
                this.fc = z;
                break;
        }
        if (this.fc) {
            return false;
        }
        if (this.fb == null) {
            u a;
            if (this.jH) {
                a = u.a((ViewGroup) coordinatorLayout, this.jG, this.fo);
            } else {
                a = u.a(coordinatorLayout, this.fo);
            }
            this.fb = a;
        }
        return this.fb.j(motionEvent);
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.fb == null) {
            return false;
        }
        this.fb.k(motionEvent);
        return true;
    }

    public boolean r(View view) {
        return true;
    }

    static float c(float f, float f2, float f3) {
        return Math.min(Math.max(0.0f, f2), 1.0f);
    }

    static float d(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }
}
