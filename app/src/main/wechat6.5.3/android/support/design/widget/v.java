package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

final class v extends e {
    private static final Handler jh = new Handler(Looper.getMainLooper());
    private boolean lo;
    private final int[] lp = new int[2];
    private final float[] lq = new float[2];
    private int lr = 200;
    private a ls;
    private b lt;
    private float lu;
    private final Runnable lv = new Runnable(this) {
        final /* synthetic */ v lw;

        {
            this.lw = r1;
        }

        public final void run() {
            v.a(this.lw);
        }
    };
    private Interpolator mInterpolator;
    private long mStartTime;

    v() {
    }

    static /* synthetic */ void a(v vVar) {
        if (vVar.lo) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - vVar.mStartTime)) / ((float) vVar.lr);
            if (vVar.mInterpolator != null) {
                uptimeMillis = vVar.mInterpolator.getInterpolation(uptimeMillis);
            }
            vVar.lu = uptimeMillis;
            if (vVar.lt != null) {
                vVar.lt.ay();
            }
            if (SystemClock.uptimeMillis() >= vVar.mStartTime + ((long) vVar.lr)) {
                vVar.lo = false;
                if (vVar.ls != null) {
                    vVar.ls.onAnimationEnd();
                }
            }
        }
        if (vVar.lo) {
            jh.postDelayed(vVar.lv, 10);
        }
    }

    public final void start() {
        if (!this.lo) {
            if (this.mInterpolator == null) {
                this.mInterpolator = new AccelerateDecelerateInterpolator();
            }
            this.mStartTime = SystemClock.uptimeMillis();
            this.lo = true;
            jh.postDelayed(this.lv, 10);
        }
    }

    public final boolean isRunning() {
        return this.lo;
    }

    public final void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void a(a aVar) {
        this.ls = aVar;
    }

    public final void a(b bVar) {
        this.lt = bVar;
    }

    public final void e(int i, int i2) {
        this.lp[0] = i;
        this.lp[1] = i2;
    }

    public final int aA() {
        return a.a(this.lp[0], this.lp[1], this.lu);
    }

    public final void e(float f, float f2) {
        this.lq[0] = f;
        this.lq[1] = f2;
    }

    public final float aB() {
        return a.b(this.lq[0], this.lq[1], this.lu);
    }

    public final void setDuration(int i) {
        this.lr = i;
    }

    public final void cancel() {
        this.lo = false;
        jh.removeCallbacks(this.lv);
    }

    public final float getAnimatedFraction() {
        return this.lu;
    }

    public final long getDuration() {
        return (long) this.lr;
    }
}
