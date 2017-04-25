package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.n;
import android.support.v4.view.y;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class a implements OnTouchListener {
    private static final int zW = ViewConfiguration.getTapTimeout();
    private Runnable lv;
    private final a zG = new a();
    private final Interpolator zH = new AccelerateInterpolator();
    private final View zI;
    private float[] zJ = new float[]{0.0f, 0.0f};
    private float[] zK = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int zL;
    private int zM;
    private float[] zN = new float[]{0.0f, 0.0f};
    private float[] zO = new float[]{0.0f, 0.0f};
    private float[] zP = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean zQ;
    private boolean zR;
    private boolean zS;
    private boolean zT;
    private boolean zU;
    private boolean zV;

    private static class a {
        float Aa;
        long Ab = 0;
        int Ac = 0;
        int Ad = 0;
        long Ae = -1;
        float Af;
        int Ag;
        long mStartTime = Long.MIN_VALUE;
        int zX;
        int zY;
        float zZ;

        final float e(long j) {
            if (j < this.mStartTime) {
                return 0.0f;
            }
            if (this.Ae < 0 || j < this.Ae) {
                return a.e(((float) (j - this.mStartTime)) / ((float) this.zX), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.Ae;
            return (a.e(((float) j2) / ((float) this.Ag), 0.0f, 1.0f) * this.Af) + (1.0f - this.Af);
        }
    }

    private class b implements Runnable {
        final /* synthetic */ a Ah;

        private b(a aVar) {
            this.Ah = aVar;
        }

        public final void run() {
            int i = 0;
            if (this.Ah.zT) {
                a d;
                if (this.Ah.zR) {
                    this.Ah.zR = false;
                    d = this.Ah.zG;
                    d.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    d.Ae = -1;
                    d.Ab = d.mStartTime;
                    d.Af = 0.5f;
                    d.Ac = 0;
                    d.Ad = 0;
                }
                d = this.Ah.zG;
                if (d.Ae > 0 && AnimationUtils.currentAnimationTimeMillis() > d.Ae + ((long) d.Ag)) {
                    i = 1;
                }
                if (i == 0 && this.Ah.am()) {
                    if (this.Ah.zS) {
                        this.Ah.zS = false;
                        a.i(this.Ah);
                    }
                    if (d.Ab == 0) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    float e = d.e(currentAnimationTimeMillis);
                    e = (e * 4.0f) + ((-4.0f * e) * e);
                    long j = currentAnimationTimeMillis - d.Ab;
                    d.Ab = currentAnimationTimeMillis;
                    d.Ac = (int) ((((float) j) * e) * d.zZ);
                    d.Ad = (int) ((e * ((float) j)) * d.Aa);
                    this.Ah.ae(d.Ad);
                    y.a(this.Ah.zI, (Runnable) this);
                    return;
                }
                this.Ah.zT = false;
            }
        }
    }

    public abstract void ae(int i);

    public abstract boolean af(int i);

    static /* synthetic */ void i(a aVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        aVar.zI.onTouchEvent(obtain);
        obtain.recycle();
    }

    public a(View view) {
        this.zI = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        float f = (float) i;
        this.zP[0] = f / 1000.0f;
        this.zP[1] = f / 1000.0f;
        float f2 = (float) i2;
        this.zO[0] = f2 / 1000.0f;
        this.zO[1] = f2 / 1000.0f;
        this.zL = 1;
        this.zK[0] = Float.MAX_VALUE;
        this.zK[1] = Float.MAX_VALUE;
        this.zJ[0] = 0.2f;
        this.zJ[1] = 0.2f;
        this.zN[0] = 0.001f;
        this.zN[1] = 0.001f;
        this.zM = zW;
        this.zG.zX = 500;
        this.zG.zY = 500;
    }

    public final a s(boolean z) {
        if (this.zU && !z) {
            cn();
        }
        this.zU = z;
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.zU) {
            return false;
        }
        switch (n.d(motionEvent)) {
            case 0:
                this.zS = true;
                this.zQ = false;
                break;
            case 1:
            case 3:
                cn();
                break;
            case 2:
                break;
        }
        float a = a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.zI.getWidth());
        float a2 = a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.zI.getHeight());
        a aVar = this.zG;
        aVar.zZ = a;
        aVar.Aa = a2;
        if (!this.zT && am()) {
            if (this.lv == null) {
                this.lv = new b();
            }
            this.zT = true;
            this.zR = true;
            if (this.zQ || this.zM <= 0) {
                this.lv.run();
            } else {
                y.a(this.zI, this.lv, (long) this.zM);
            }
            this.zQ = true;
        }
        if (this.zV && this.zT) {
            return true;
        }
        return false;
    }

    private boolean am() {
        a aVar = this.zG;
        int abs = (int) (aVar.Aa / Math.abs(aVar.Aa));
        int abs2 = (int) (aVar.zZ / Math.abs(aVar.zZ));
        if (abs != 0 && af(abs)) {
            return true;
        }
        if (abs2 != 0) {
        }
        return false;
    }

    private void cn() {
        if (this.zR) {
            this.zT = false;
            return;
        }
        a aVar = this.zG;
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i = (int) (currentAnimationTimeMillis - aVar.mStartTime);
        int i2 = aVar.zY;
        if (i <= i2) {
            i2 = i < 0 ? 0 : i;
        }
        aVar.Ag = i2;
        aVar.Af = aVar.e(currentAnimationTimeMillis);
        aVar.Ae = currentAnimationTimeMillis;
    }

    private float a(int i, float f, float f2, float f3) {
        float f4;
        float f5;
        float f6;
        float e = e(this.zJ[i] * f2, 0.0f, this.zK[i]);
        e = g(f2 - f, e) - g(f, e);
        if (e < 0.0f) {
            e = -this.zH.getInterpolation(-e);
        } else if (e > 0.0f) {
            e = this.zH.getInterpolation(e);
        } else {
            e = 0.0f;
            if (e == 0.0f) {
                return 0.0f;
            }
            f4 = this.zN[i];
            f5 = this.zO[i];
            f6 = this.zP[i];
            f4 *= f3;
            if (e <= 0.0f) {
                return e(e * f4, f5, f6);
            }
            return -e((-e) * f4, f5, f6);
        }
        e = e(e, -1.0f, 1.0f);
        if (e == 0.0f) {
            return 0.0f;
        }
        f4 = this.zN[i];
        f5 = this.zO[i];
        f6 = this.zP[i];
        f4 *= f3;
        if (e <= 0.0f) {
            return -e((-e) * f4, f5, f6);
        }
        return e(e * f4, f5, f6);
    }

    private float g(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.zL) {
            case 0:
            case 1:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.zT && this.zL == 1) {
                    return 1.0f;
                }
                return 0.0f;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    private static float e(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }
}
