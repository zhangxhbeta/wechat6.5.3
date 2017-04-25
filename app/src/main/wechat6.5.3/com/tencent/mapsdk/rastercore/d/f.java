package com.tencent.mapsdk.rastercore.d;

import android.graphics.Point;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Scroller;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.tencentmap.mapsdk.map.g.a;
import com.tencent.tencentmap.mapsdk.map.g.c;
import com.tencent.tencentmap.mapsdk.map.g.d;
import com.tencent.tencentmap.mapsdk.map.g.e;
import com.tencent.tencentmap.mapsdk.map.g.g;
import com.tencent.tencentmap.mapsdk.map.g.h;
import com.tencent.tencentmap.mapsdk.map.g.i;

public final class f implements OnDoubleTapListener, OnGestureListener, OnKeyListener {
    private long A = 0;
    private Point B;
    private e a;
    private b b;
    private a c;
    private GestureDetector d;
    private MotionEvent e;
    private e f;
    private g g;
    private d h;
    private c i;
    private a j;
    private i k;
    private h l;
    private float m = 1.0f;
    private float n = 1.0f;
    private float o = 1.0f;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private Scroller s;
    private int t = 0;
    private int u = 0;
    private long v;
    private float w;
    private float x;
    private float y;
    private float z;

    public f(e eVar) {
        this.a = eVar;
        this.b = eVar.c();
        this.c = eVar.e();
        this.d = new GestureDetector(e.a().getApplicationContext(), this);
        this.s = new Scroller(e.a());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics = e.a().getApplicationContext().getResources().getDisplayMetrics();
        this.t = displayMetrics.widthPixels / 2;
        this.u = displayMetrics.heightPixels / 2;
    }

    private static float c(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        new StringBuilder("event0.x:").append(motionEvent.getX(0)).append(",event0.y:").append(motionEvent.getY(0)).append(";  event1.x:").append(motionEvent.getX(1)).append(",event1.y:").append(motionEvent.getY(1));
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    public final void a() {
        if (this.s.computeScrollOffset()) {
            int currX = this.s.getCurrX() - this.t;
            int currY = this.s.getCurrY() - this.u;
            this.t = this.s.getCurrX();
            this.u = this.s.getCurrY();
            this.b.scrollBy(currX, currY);
            if (this.s.isFinished()) {
                if (this.h != null) {
                    a(true);
                }
                this.a.a(false, false);
                return;
            }
            if (Math.abs(currX) < 6) {
                Math.abs(currY);
            }
            this.a.a(false, false);
        }
    }

    public final void a(a aVar) {
        this.j = aVar;
    }

    public final void a(c cVar) {
        this.i = cVar;
    }

    public final void a(d dVar) {
        this.h = dVar;
    }

    public final void a(e eVar) {
        this.f = eVar;
    }

    public final void a(g gVar) {
        this.g = gVar;
    }

    public final void a(h hVar) {
        this.l = hVar;
    }

    public final void a(i iVar) {
        this.k = iVar;
    }

    public final void a(boolean z) {
        if (this.h != null) {
            this.a.b().d();
            if (z) {
                this.h.Qy();
                this.r = false;
                return;
            }
            this.h.Qx();
            this.r = true;
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        boolean z = false;
        switch (motionEvent.getAction() & 255) {
            case 0:
                new StringBuilder("event0.x:").append(motionEvent.getX(0)).append(",event0.y:").append(motionEvent.getY(0));
                this.a.d().stopAnimation();
                if (this.a.f().g()) {
                    this.a.j();
                    break;
                }
                break;
            case 1:
                boolean z2;
                this.A = motionEvent.getEventTime();
                if (this.a.f().g()) {
                    this.a.k();
                }
                if (motionEvent.getEventTime() - this.v >= 200 || ((Math.abs(motionEvent.getX(0) - this.x) >= 10.0f || Math.abs(motionEvent.getY(0) - this.z) >= 10.0f) && (Math.abs(motionEvent.getX(0) - this.w) >= 10.0f || Math.abs(motionEvent.getY(0) - this.y) >= 10.0f))) {
                    z2 = false;
                } else {
                    com.tencent.mapsdk.rastercore.b.a d = this.b.d();
                    z2 = this.a.f().a() >= 3 && this.a.f().b() > 1.0f;
                    if (z2) {
                        d.a(1.3d);
                    } else {
                        d.a(1.0d);
                    }
                    if (this.a.f().i()) {
                        this.b.b(true, null);
                    }
                    z2 = true;
                }
                this.v = 0;
                this.w = 0.0f;
                this.y = 0.0f;
                this.p = false;
                this.o = 0.0f;
                z = z2;
                break;
            case 2:
                if (motionEvent.getPointerCount() > 1) {
                    if (this.a.f().i()) {
                        float c = c(motionEvent);
                        if (c >= 10.0f) {
                            if (this.o >= 10.0f) {
                                this.m = this.n;
                                this.n = c / this.o;
                                new StringBuilder().append(this.n);
                                if (((double) Math.abs(this.n - 1.0f)) >= 0.01d) {
                                    this.b.a((double) this.n, new PointF((float) (this.b.getWidth() / 2), (float) (this.b.getHeight() / 2)));
                                    a(false);
                                    this.o = c;
                                    this.a.a(false, false);
                                    this.q = true;
                                    z = true;
                                    break;
                                }
                            }
                            this.o = c;
                            break;
                        }
                    }
                    return false;
                }
                break;
            case 5:
                if (motionEvent.getPointerCount() > 1) {
                    this.v = motionEvent.getEventTime();
                    this.x = motionEvent.getX(0);
                    this.z = motionEvent.getY(0);
                    this.w = motionEvent.getX(1);
                    this.y = motionEvent.getY(1);
                    this.o = c(motionEvent);
                    break;
                }
                break;
            case 6:
                if (motionEvent.getPointerCount() == 2) {
                    new StringBuilder("event0.x:").append(motionEvent.getX(0)).append(",event0.y:").append(motionEvent.getY(0)).append(";  event1.x:").append(motionEvent.getX(1)).append(",event1.y:").append(motionEvent.getY(1));
                    if (this.q) {
                        this.b.a(((Math.sqrt((double) (this.n * this.m)) - 1.0d) * 1.5d) + this.b.c(), new PointF((float) (this.b.getWidth() / 2), (float) (this.b.getHeight() / 2)), true, 200, com.tencent.mapsdk.rastercore.a.a.a.DECELERATE, new com.tencent.tencentmap.mapsdk.map.c(this) {
                            private /* synthetic */ f a;

                            {
                                this.a = r1;
                            }

                            public final void onCancel() {
                                this.a.q = false;
                            }

                            public final void onFinish() {
                                this.a.q = false;
                            }
                        });
                    }
                    this.B = null;
                    break;
                }
                break;
        }
        if (z) {
            this.A = motionEvent.getEventTime();
        }
        if (!(z || this.q)) {
            this.d.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 1 && !this.q && this.h != null && this.s.isFinished() && (this.p || this.r)) {
            a(true);
        }
        if (z) {
            motionEvent.setAction(3);
            this.d.onTouchEvent(motionEvent);
        }
        this.c.a(motionEvent);
        return true;
    }

    public final void b() {
        this.s.abortAnimation();
    }

    public final void b(MotionEvent motionEvent) {
        if (this.e != null) {
            this.e.recycle();
        }
        this.e = motionEvent;
        if (this.e.getAction() == 0) {
            if (this.B == null) {
                this.B = new Point();
            }
            this.B.x = (int) this.e.getX();
            this.B.y = (int) this.e.getY();
        }
    }

    public final MotionEvent c() {
        return this.e;
    }

    public final h d() {
        return this.l;
    }

    public final i e() {
        return this.k;
    }

    public final c f() {
        return this.i;
    }

    public final a g() {
        return this.j;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.a.f().i()) {
            com.tencent.mapsdk.rastercore.b.a d = this.b.d();
            boolean z = this.a.f().a() >= 3 && this.a.f().b() > 1.0f;
            if (z) {
                d.a(1.3d);
            } else {
                d.a(1.0d);
            }
            if (this.b.d().a() < this.a.b().i().a()) {
                this.b.a(new PointF(motionEvent.getX(), motionEvent.getY()), true, null);
            }
        }
        return true;
    }

    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        this.p = false;
        return false;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.p = false;
        if (!this.a.f().h()) {
            return true;
        }
        this.s.fling(this.t, this.u, (int) (((double) (-f)) * 0.6d), (int) (((double) (-f2)) * 0.6d), -2147483647, Integer.MAX_VALUE, -2147483647, Integer.MAX_VALUE);
        this.a.a(false, false);
        return true;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        switch (i) {
            case 19:
                this.b.scrollBy(0, -10);
                return true;
            case 20:
                this.b.scrollBy(0, 10);
                return true;
            case 21:
                this.b.scrollBy(-10, 0);
                return true;
            case bf.CTRL_INDEX /*22*/:
                this.b.scrollBy(10, 0);
                return true;
            default:
                return false;
        }
    }

    public final void onLongPress(MotionEvent motionEvent) {
        this.p = false;
        this.c.a(com.tencent.mapsdk.rastercore.f.a.a(this.a.b().a((int) motionEvent.getX(), (int) motionEvent.getY())), motionEvent);
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!this.a.f().h()) {
            this.p = false;
        } else if (!this.q && motionEvent2.getEventTime() - this.A >= 30) {
            this.p = true;
            int x = (int) this.e.getX();
            int y = (int) this.e.getY();
            if (this.B == null) {
                this.B = new Point();
                this.B.x = x;
                this.B.y = y;
            } else {
                this.b.scrollBy(this.B.x - x, this.B.y - y);
                this.B.x = x;
                this.B.y = y;
                a(false);
            }
        }
        return true;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        this.p = false;
        try {
            if (!(this.c.a(com.tencent.mapsdk.rastercore.f.a.a(this.a.b().a((int) motionEvent.getX(), (int) motionEvent.getY()))) || this.f == null)) {
                this.f.Qw();
                this.a.d().setFocusable(true);
                this.a.d().setFocusableInTouchMode(true);
                this.a.d().requestFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) e.a().getSystemService("input_method");
                if (inputMethodManager.isActive()) {
                    inputMethodManager.hideSoftInputFromWindow(this.a.d().getWindowToken(), 0);
                }
            }
        } catch (Exception e) {
        }
        return true;
    }
}
