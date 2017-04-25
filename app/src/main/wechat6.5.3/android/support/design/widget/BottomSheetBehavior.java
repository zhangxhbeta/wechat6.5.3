package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a.i;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.view.n;
import android.support.v4.view.o;
import android.support.v4.view.x;
import android.support.v4.view.y;
import android.support.v4.widget.u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends Behavior<V> {
    private float eW;
    private int eX;
    private int eY;
    private int eZ;
    public boolean fa;
    private u fb;
    private boolean fc;
    private int fd;
    private boolean fe;
    private int ff;
    private WeakReference<V> fg;
    private WeakReference<View> fh;
    public a fi;
    private VelocityTracker fj;
    private int fk;
    private int fl;
    private boolean fn;
    private final android.support.v4.widget.u.a fo = new android.support.v4.widget.u.a(this) {
        final /* synthetic */ BottomSheetBehavior fp;

        {
            this.fp = r1;
        }

        public final boolean a(View view, int i) {
            if (this.fp.mState == 1) {
                return false;
            }
            if (this.fp.fn) {
                return false;
            }
            if (this.fp.mState == 3 && this.fp.fk == i) {
                View view2 = (View) this.fp.fh.get();
                if (view2 != null && y.g(view2, -1)) {
                    return false;
                }
            }
            return this.fp.fg != null && this.fp.fg.get() == view;
        }

        public final void a(View view, int i, int i2) {
            this.fp.i(i2);
        }

        public final void j(int i) {
            if (i == 1) {
                this.fp.h(1);
            }
        }

        public final void a(View view, float f, float f2) {
            int f3;
            int i = 3;
            if (f2 < 0.0f) {
                f3 = this.fp.eY;
            } else if (this.fp.fa && this.fp.a(view, f2)) {
                f3 = this.fp.ff;
                i = 5;
            } else if (f2 == 0.0f) {
                int top = view.getTop();
                if (Math.abs(top - this.fp.eY) < Math.abs(top - this.fp.eZ)) {
                    f3 = this.fp.eY;
                } else {
                    f3 = this.fp.eZ;
                    i = 4;
                }
            } else {
                f3 = this.fp.eZ;
                i = 4;
            }
            if (this.fp.fb.p(view.getLeft(), f3)) {
                this.fp.h(2);
                y.a(view, new b(this.fp, view, i));
                return;
            }
            this.fp.h(i);
        }

        public final int b(View view, int i) {
            return n.a(i, this.fp.eY, this.fp.fa ? this.fp.ff : this.fp.eZ);
        }

        public final int c(View view, int i) {
            return view.getLeft();
        }

        public final int N() {
            if (this.fp.fa) {
                return this.fp.ff - this.fp.eY;
            }
            return this.fp.eZ - this.fp.eY;
        }
    };
    private int mState = 4;

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final int state;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }
    }

    public static abstract class a {
        public abstract void d(float f);

        public abstract void k(int i);
    }

    private class b implements Runnable {
        final /* synthetic */ BottomSheetBehavior fp;
        private final int fq;
        private final View mView;

        b(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
            this.fp = bottomSheetBehavior;
            this.mView = view;
            this.fq = i;
        }

        public final void run() {
            if (this.fp.fb == null || !this.fp.fb.cL()) {
                this.fp.h(this.fq);
            } else {
                y.a(this.mView, (Runnable) this);
            }
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.bm);
        g(obtainStyledAttributes.getDimensionPixelSize(i.bo, 0));
        this.fa = obtainStyledAttributes.getBoolean(i.bn, false);
        obtainStyledAttributes.recycle();
        this.eW = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public final Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.b(coordinatorLayout, v), this.mState);
    }

    public final void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.a(coordinatorLayout, (View) v, savedState.getSuperState());
        if (savedState.state == 1 || savedState.state == 2) {
            this.mState = 4;
        } else {
            this.mState = savedState.state;
        }
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (!(this.mState == 1 || this.mState == 2)) {
            if (y.Z(coordinatorLayout) && !y.Z(v)) {
                y.a((View) v, true);
            }
            coordinatorLayout.d(v, i);
        }
        this.ff = coordinatorLayout.getHeight();
        this.eY = Math.max(0, this.ff - v.getHeight());
        this.eZ = Math.max(this.ff - this.eX, this.eY);
        if (this.mState == 3) {
            y.i(v, this.eY);
        } else if (this.fa && this.mState == 5) {
            y.i(v, this.ff);
        } else if (this.mState == 4) {
            y.i(v, this.eZ);
        }
        if (this.fb == null) {
            this.fb = u.a(coordinatorLayout, this.fo);
        }
        this.fg = new WeakReference(v);
        this.fh = new WeakReference(h((View) v));
        return true;
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int d = n.d(motionEvent);
        if (d == 0) {
            reset();
        }
        if (this.fj == null) {
            this.fj = VelocityTracker.obtain();
        }
        this.fj.addMovement(motionEvent);
        switch (d) {
            case 0:
                int x = (int) motionEvent.getX();
                this.fl = (int) motionEvent.getY();
                View view = (View) this.fh.get();
                if (view != null && coordinatorLayout.b(view, x, this.fl)) {
                    this.fk = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.fn = true;
                }
                boolean z = this.fk == -1 && !coordinatorLayout.b(v, x, this.fl);
                this.fc = z;
                break;
            case 1:
            case 3:
                this.fn = false;
                this.fk = -1;
                if (this.fc) {
                    this.fc = false;
                    return false;
                }
                break;
        }
        if (!this.fc && this.fb.j(motionEvent)) {
            return true;
        }
        view = (View) this.fh.get();
        if (d != 2 || view == null || this.fc || this.mState == 1 || coordinatorLayout.b(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.fl) - motionEvent.getY()) <= ((float) this.fb.iD)) {
            return false;
        }
        return true;
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int d = n.d(motionEvent);
        if (this.mState == 1 && d == 0) {
            return true;
        }
        this.fb.k(motionEvent);
        if (d == 0) {
            reset();
        }
        if (this.fj == null) {
            this.fj = VelocityTracker.obtain();
        }
        this.fj.addMovement(motionEvent);
        if (d != 2 || this.fc || Math.abs(((float) this.fl) - motionEvent.getY()) <= ((float) this.fb.iD)) {
            return true;
        }
        this.fb.m(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        return true;
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        this.fd = 0;
        this.fe = false;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    public final void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int[] iArr) {
        if (view == ((View) this.fh.get())) {
            int top = v.getTop();
            int i2 = top - i;
            if (i > 0) {
                if (i2 < this.eY) {
                    iArr[1] = top - this.eY;
                    y.i(v, -iArr[1]);
                    h(3);
                } else {
                    iArr[1] = i;
                    y.i(v, -i);
                    h(1);
                }
            } else if (i < 0 && !y.g(view, -1)) {
                if (i2 <= this.eZ || this.fa) {
                    iArr[1] = i;
                    y.i(v, -i);
                    h(1);
                } else {
                    iArr[1] = top - this.eZ;
                    y.i(v, -iArr[1]);
                    h(4);
                }
            }
            i(v.getTop());
            this.fd = i;
            this.fe = true;
        }
    }

    public final void a(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i = 3;
        if (v.getTop() == this.eY) {
            h(3);
        } else if (view == this.fh.get() && this.fe) {
            int i2;
            if (this.fd > 0) {
                i2 = this.eY;
            } else {
                if (this.fa) {
                    this.fj.computeCurrentVelocity(1000, this.eW);
                    if (a((View) v, x.b(this.fj, this.fk))) {
                        i2 = this.ff;
                        i = 5;
                    }
                }
                if (this.fd == 0) {
                    int top = v.getTop();
                    if (Math.abs(top - this.eY) < Math.abs(top - this.eZ)) {
                        i2 = this.eY;
                    } else {
                        i2 = this.eZ;
                        i = 4;
                    }
                } else {
                    i2 = this.eZ;
                    i = 4;
                }
            }
            if (this.fb.e(v, v.getLeft(), i2)) {
                h(2);
                y.a((View) v, new b(this, v, i));
            } else {
                h(i);
            }
            this.fe = false;
        }
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.fh.get() && (this.mState != 3 || super.a(coordinatorLayout, (View) v, view, f, f2));
    }

    public final void g(int i) {
        this.eX = Math.max(0, i);
        this.eZ = this.ff - i;
    }

    private void h(int i) {
        if (this.mState != i) {
            this.mState = i;
            if (((View) this.fg.get()) != null && this.fi != null) {
                this.fi.k(i);
            }
        }
    }

    private void reset() {
        this.fk = -1;
        if (this.fj != null) {
            this.fj.recycle();
            this.fj = null;
        }
    }

    private boolean a(View view, float f) {
        if (view.getTop() >= this.eZ && Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.eZ)) / ((float) this.eX) > 0.5f) {
            return true;
        }
        return false;
    }

    private View h(View view) {
        if (view instanceof o) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View h = h(viewGroup.getChildAt(i));
                if (h != null) {
                    return h;
                }
            }
        }
        return null;
    }

    private void i(int i) {
        if (((View) this.fg.get()) != null && this.fi != null) {
            if (i > this.eZ) {
                this.fi.d(((float) (this.eZ - i)) / ((float) this.eX));
            } else {
                this.fi.d(((float) (this.eZ - i)) / ((float) (this.eZ - this.eY)));
            }
        }
    }

    public static <V extends View> BottomSheetBehavior<V> i(V v) {
        LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof d) {
            Behavior behavior = ((d) layoutParams).ht;
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
}
