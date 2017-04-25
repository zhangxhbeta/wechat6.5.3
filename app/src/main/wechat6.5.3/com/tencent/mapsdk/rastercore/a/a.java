package com.tencent.mapsdk.rastercore.a;

import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.tencentmap.mapsdk.map.c;

public abstract class a {
    protected e a;
    protected b b;
    protected c c;
    private a d = a.ACCELERATE_DECELERATE;
    private Handler e = new Handler();
    private Scroller f;
    private long g;
    private float h = 0.0f;
    private boolean i = false;
    private Runnable j = new Runnable(this) {
        private /* synthetic */ a a;

        {
            this.a = r1;
        }

        public final void run() {
            if (this.a.f.computeScrollOffset()) {
                float currX = (((float) this.a.f.getCurrX()) * 1.0f) / 10000.0f;
                this.a.a(currX - this.a.h);
                this.a.h = currX;
                if (this.a.i) {
                    this.a.e.postDelayed(this.a.j, 5);
                }
                this.a.a.h().a(false);
                return;
            }
            this.a.d();
            if (this.a.c != null) {
                this.a.c.onFinish();
            }
            this.a.i = false;
            this.a.a.h().a(true);
        }
    };

    public enum a {
        ACCELERATE,
        DECELERATE,
        ACCELERATE_DECELERATE;

        public static a[] a() {
            return (a[]) d.clone();
        }
    }

    public a(e eVar, long j, c cVar) {
        this.a = eVar;
        this.b = eVar.c();
        this.g = j;
        this.c = cVar;
    }

    public final void a() {
        switch (this.d) {
            case ACCELERATE:
                this.f = new Scroller(e.a(), new AccelerateInterpolator());
                break;
            case DECELERATE:
                this.f = new Scroller(e.a(), new DecelerateInterpolator());
                break;
            case ACCELERATE_DECELERATE:
                this.f = new Scroller(e.a(), new AccelerateDecelerateInterpolator());
                break;
        }
        this.f = new Scroller(e.a());
        c();
        this.i = true;
        this.f.startScroll(0, 0, 10000, 0, (int) this.g);
        this.e.postDelayed(this.j, 5);
        this.a.a(false, false);
    }

    protected abstract void a(float f);

    public final void a(a aVar) {
        this.d = aVar;
    }

    public final void b() {
        if (this.i) {
            this.i = false;
            if (this.c != null) {
                this.c.onCancel();
            }
            this.a.h().a(true);
        }
    }

    protected abstract void c();

    protected abstract void d();
}
