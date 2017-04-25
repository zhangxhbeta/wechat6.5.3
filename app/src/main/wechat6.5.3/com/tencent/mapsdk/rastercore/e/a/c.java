package com.tencent.mapsdk.rastercore.e.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.BitmapDescriptorFactory;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.MapView.a;

public final class c {
    private static int a = 0;
    private static BitmapDescriptor b;
    private Animation A;
    private int B = 25;
    private Object C;
    private e c;
    private Context d;
    private f e;
    private MapView f;
    private View g;
    private View h;
    private Animation i = null;
    private Animation j = null;
    private GestureDetector k;
    private BitmapDescriptor l = null;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private float q = 0.5f;
    private float r = 1.0f;
    private boolean s = true;
    private float t = 0.0f;
    private float u = 1.0f;
    private String v;
    private LatLng w;
    private String x;
    private String y;
    private Animation z;

    public c(e eVar, MarkerOptions markerOptions) {
        this.c = eVar;
        this.d = e.a();
        this.f = eVar.d();
        this.e = eVar.h();
        this.n = markerOptions.isGps();
        if (markerOptions.getPosition() != null) {
            if (this.n) {
                try {
                    double[] a = e.a(markerOptions.getPosition().getLongitude(), markerOptions.getPosition().getLatitude());
                    LatLng latLng = new LatLng(a[1], a[0]);
                } catch (Exception e) {
                    markerOptions.getPosition();
                }
            }
            this.w = markerOptions.getPosition();
        }
        a(markerOptions.getIcon());
        this.g = markerOptions.getMarkerView();
        this.q = markerOptions.getAnchorU();
        this.r = markerOptions.getAnchorV();
        this.u = markerOptions.getAlpha();
        this.t = markerOptions.getRotation();
        this.s = markerOptions.isVisible();
        this.v = markerOptions.getSnippet();
        this.x = markerOptions.getTitle();
        this.m = markerOptions.isDraggable();
        this.y = m();
        this.j = markerOptions.getInfoWindowHideAnimation();
        this.i = markerOptions.getInfoWindowShowAnimation();
        this.z = markerOptions.getShowingAnination();
        this.A = markerOptions.getHidingAnination();
        this.C = markerOptions.getTag();
        this.B = (int) (((float) this.B) * this.d.getResources().getDisplayMetrics().density);
        this.k = new GestureDetector(this.d, new OnGestureListener(this) {
            private /* synthetic */ c a;

            {
                this.a = r1;
            }

            public final boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                if (this.a.m) {
                    float x = this.a.e.c().getX();
                    float y = this.a.e.c().getY();
                    this.a.o = true;
                    this.a.p = this.a.e();
                    if (this.a.p) {
                        this.a.g();
                    }
                    this.a.a(this.a.c.b().a((int) x, (int) (y - ((float) this.a.B))));
                    if (this.a.e.e() != null) {
                        this.a.e.e();
                        Marker marker = new Marker(this.a);
                    }
                }
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (this.a.m && this.a.o) {
                    return true;
                }
                this.a.f.requestDisallowInterceptTouchEvent(false);
                return false;
            }

            public final void onShowPress(MotionEvent motionEvent) {
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                this.a.n();
                if (this.a.e.d() != null) {
                    return this.a.e.d().a(new Marker(this.a));
                }
                if (this.a.e()) {
                    this.a.g();
                } else {
                    this.a.f();
                }
                return true;
            }
        });
        q();
    }

    private static boolean a(float f, float f2, float f3) {
        return f > f2 && f <= f3;
    }

    private void q() {
        if (this.g == null) {
            if (this.l == null) {
                if (b == null) {
                    b = BitmapDescriptorFactory.defaultMarker();
                }
                this.l = b;
            }
            this.g = new ImageView(this.d);
            ((ImageView) this.g).setImageBitmap(this.l.getBitmap());
        }
        this.g.measure(0, 0);
        b(this.u);
        a(this.t);
        this.f.addView(this.g, s());
        if (!this.s || this.z == null) {
            r();
            return;
        }
        this.g.clearAnimation();
        this.z.setAnimationListener(new a(this) {
            private /* synthetic */ c a;

            {
                this.a = r1;
            }

            public final void onAnimationEnd(Animation animation) {
                this.a.z.setAnimationListener(null);
                this.a.r();
            }
        });
        this.g.startAnimation(this.z);
    }

    private void r() {
        this.g.setOnTouchListener(new OnTouchListener(this) {
            private /* synthetic */ c a;

            {
                this.a = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                Marker marker;
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        if (this.a.m && this.a.o) {
                            this.a.o = false;
                            this.a.n();
                            new StringBuilder().append(this.a.p);
                            if (this.a.p) {
                                this.a.f();
                                this.a.p = false;
                            }
                            if (this.a.e.e() != null) {
                                this.a.e.e();
                                marker = new Marker(this.a);
                                break;
                            }
                        }
                        break;
                    case 2:
                        if (this.a.m && this.a.o) {
                            float x = this.a.e.c().getX();
                            float y = this.a.e.c().getY();
                            this.a.a(this.a.c.b().a((int) x, (int) (y - ((float) this.a.B))));
                            new StringBuilder().append(x).append(",").append(y);
                            if (this.a.e.e() != null) {
                                this.a.e.e();
                                marker = new Marker(this.a);
                            }
                            return true;
                        }
                }
                return this.a.k.onTouchEvent(motionEvent);
            }
        });
    }

    private a s() {
        PointF t = t();
        return new a(-2, -2, this.w, -((int) t.x), -((int) t.y), 0);
    }

    private PointF t() {
        PointF pointF = new PointF();
        pointF.x = ((float) this.g.getMeasuredWidth()) * this.q;
        pointF.y = ((float) this.g.getMeasuredHeight()) * this.r;
        return pointF;
    }

    private PointF u() {
        PointF pointF = new PointF();
        PointF pointF2 = a(this.t, 45.0f, 135.0f) ? new PointF(0.0f, ((float) this.g.getMeasuredHeight()) * 0.5f) : a(this.t, 135.0f, 225.0f) ? new PointF(((float) this.g.getMeasuredWidth()) * 0.5f, (float) this.g.getMeasuredHeight()) : a(this.t, 225.0f, 315.0f) ? new PointF((float) this.g.getMeasuredWidth(), ((float) this.g.getMeasuredHeight()) * 0.5f) : new PointF(((float) this.g.getMeasuredWidth()) * 0.5f, 0.0f);
        PointF t = t();
        float f = pointF2.x - t.x;
        float f2 = (-pointF2.y) + t.y;
        float sqrt = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        double atan = Math.atan((double) (f / f2));
        if ((f > 0.0f && f2 < 0.0f) || (f < 0.0f && f2 < 0.0f)) {
            atan += 3.141592653589793d;
        }
        atan += ((double) (this.t / 180.0f)) * 3.141592653589793d;
        pointF.x = (float) (((double) sqrt) * Math.sin(atan));
        pointF.y = -((float) (Math.cos(atan) * ((double) sqrt)));
        return pointF;
    }

    private void v() {
        if (e()) {
            this.h.clearAnimation();
            this.f.removeView(this.h);
            PointF u = u();
            this.f.addView(this.h, this.f.indexOfChild(this.g) + 1, new a(-2, -2, this.w, (int) u.x, (int) u.y, 81));
        }
    }

    private void w() {
        if (e() && (this.h instanceof b)) {
            ((b) this.h).a.setText(this.x);
            ((b) this.h).b.setText(this.v);
        }
    }

    public final View a() {
        return this.g;
    }

    @SuppressLint({"NewApi"})
    public final void a(float f) {
        float f2 = (f + 360.0f) % 360.0f;
        if (VERSION.SDK_INT < 11) {
            Animation rotateAnimation = new RotateAnimation(this.t, f2, 1, this.q, 1, this.r);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setDuration(0);
            this.g.clearAnimation();
            this.g.startAnimation(rotateAnimation);
        } else {
            PointF t = t();
            this.g.setPivotX(t.x);
            this.g.setPivotY(t.y);
            this.g.setRotation(f2);
        }
        this.t = f2;
        v();
    }

    public final void a(float f, float f2) {
        if (this.q != f || this.r != f2) {
            this.q = f;
            this.r = f2;
            this.g.setLayoutParams(s());
            a(this.t);
            v();
        }
    }

    public final void a(final View view) {
        if (this.g != null) {
            if (this.A != null) {
                this.A.setAnimationListener(new a(this) {
                    final /* synthetic */ c b;

                    public final void onAnimationEnd(Animation animation) {
                        new Handler().post(new Runnable(this) {
                            private /* synthetic */ AnonymousClass4 a;

                            {
                                this.a = r1;
                            }

                            public final void run() {
                                this.a.b.f.removeView(this.a.b.g);
                                this.a.b.A.setAnimationListener(null);
                                this.a.b.g = view;
                                this.a.b.q();
                                this.a.b.v();
                            }
                        });
                    }
                });
                this.g.setOnTouchListener(null);
                this.g.startAnimation(this.A);
                return;
            }
            this.f.removeView(this.g);
        }
        this.g = view;
        q();
        v();
    }

    public final void a(Animation animation) {
        this.i = animation;
    }

    public final void a(BitmapDescriptor bitmapDescriptor) {
        this.l = bitmapDescriptor;
        if (this.g != null && (this.g instanceof ImageView)) {
            ((ImageView) this.g).setImageBitmap(this.l.getBitmap());
        }
    }

    public final void a(LatLng latLng) {
        this.w = latLng;
        ((a) this.g.getLayoutParams()).point = latLng;
        this.f.layout(this.g);
        if (this.h != null) {
            ((a) this.h.getLayoutParams()).point = latLng;
            this.f.layout(this.h);
        }
    }

    public final void a(Object obj) {
        this.C = obj;
    }

    public final void a(String str) {
        this.v = str;
        w();
    }

    public final void a(boolean z) {
        this.g.setVisibility(z ? 0 : 8);
        if (!z && e()) {
            g();
        }
        this.s = z;
    }

    public final void b() {
        this.c.e().c(m());
    }

    public final void b(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (VERSION.SDK_INT < 11) {
            Animation alphaAnimation = new AlphaAnimation(this.u, f);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setDuration(0);
            this.g.clearAnimation();
            this.g.startAnimation(alphaAnimation);
        } else {
            this.g.setAlpha(f);
        }
        this.u = f;
    }

    public final void b(Animation animation) {
        this.j = animation;
    }

    public final void b(String str) {
        this.x = str;
        w();
    }

    public final void b(boolean z) {
        this.m = z;
    }

    public final void c() {
        if (this.A != null) {
            this.A.setAnimationListener(new a(this) {
                final /* synthetic */ c a;

                {
                    this.a = r1;
                }

                public final void onAnimationEnd(Animation animation) {
                    new Handler().post(new Runnable(this) {
                        private /* synthetic */ AnonymousClass5 a;

                        {
                            this.a = r1;
                        }

                        public final void run() {
                            this.a.a.f.removeView(this.a.a.g);
                            this.a.a.f.removeView(this.a.a.h);
                            this.a.a.A.setAnimationListener(null);
                        }
                    });
                }
            });
            this.g.setOnTouchListener(null);
            this.g.clearAnimation();
            this.g.startAnimation(this.A);
            return;
        }
        this.f.removeView(this.g);
        this.f.removeView(this.h);
    }

    public final boolean d() {
        return this.m;
    }

    public final boolean e() {
        return (this.h == null || this.h.getParent() == null) ? false : true;
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof c) && obj.hashCode() == hashCode() && ((c) obj).m().equals(m());
    }

    public final void f() {
        if (!e()) {
            Animation animation;
            if (this.e.g() != null) {
                Marker marker = new Marker(this);
                View bOl = this.e.g().bOl();
                if (bOl == null) {
                    this.h = new b(this.d, this.x, this.v);
                } else {
                    this.h = bOl;
                }
            } else {
                this.h = new b(this.d, this.x, this.v);
            }
            t();
            PointF u = u();
            new StringBuilder().append(u.x).append(", ").append(u.y);
            this.f.addView(this.h, this.f.indexOfChild(this.g) + 1, new a(-2, -2, this.w, (int) u.x, (int) u.y, 81));
            if (this.i != null) {
                animation = this.i;
            } else {
                Animation animationSet = new AnimationSet(false);
                animation = new ScaleAnimation(0.0f, 1.1f, 0.0f, 1.1f, 1, 0.5f, 1, 1.0f);
                animation.setDuration(150);
                animation.setInterpolator(new AccelerateInterpolator());
                Animation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 1.0f);
                scaleAnimation.setDuration(100);
                scaleAnimation.setInterpolator(new DecelerateInterpolator());
                scaleAnimation.setStartOffset(150);
                animationSet.addAnimation(animation);
                animationSet.addAnimation(scaleAnimation);
                animation = animationSet;
            }
            this.h.startAnimation(animation);
            this.h.setOnClickListener(new OnClickListener(this) {
                private /* synthetic */ c a;

                {
                    this.a = r1;
                }

                public final void onClick(View view) {
                    if (this.a.e.f() != null) {
                        this.a.e.f();
                        Marker marker = new Marker(this.a);
                    }
                }
            });
        }
    }

    public final void g() {
        if (e()) {
            Animation animation;
            this.h.clearAnimation();
            if (this.j != null) {
                animation = this.j;
            } else {
                Animation animationSet = new AnimationSet(true);
                animationSet.setInterpolator(new AccelerateInterpolator());
                animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
                animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 1.0f));
                animationSet.setDuration(100);
                animation = animationSet;
            }
            animation.setAnimationListener(new a(this) {
                final /* synthetic */ c a;

                {
                    this.a = r1;
                }

                public final void onAnimationEnd(Animation animation) {
                    new Handler().post(new Runnable(this) {
                        private /* synthetic */ AnonymousClass7 a;

                        {
                            this.a = r1;
                        }

                        public final void run() {
                            this.a.a.f.removeView(this.a.a.h);
                            if (this.a.a.e.g() != null) {
                                this.a.a.c.h().g();
                                Marker marker = new Marker(this.a.a);
                                this.a.a.h;
                            }
                            this.a.a.h = null;
                        }
                    });
                }
            });
            this.h.startAnimation(animation);
        }
    }

    public final String h() {
        return this.x;
    }

    public final int hashCode() {
        return m().hashCode();
    }

    public final String i() {
        return this.v;
    }

    public final float j() {
        return this.t;
    }

    public final boolean k() {
        return this.s;
    }

    public final LatLng l() {
        return this.w;
    }

    public final String m() {
        if (this.y == null) {
            a++;
            this.y = "Marker" + a;
        }
        return this.y;
    }

    public final void n() {
        if (VERSION.SDK_INT < 11) {
            this.g.clearAnimation();
        }
        this.f.removeView(this.g);
        this.f.addView(this.g);
        v();
    }

    public final float o() {
        return this.u;
    }

    public final Object p() {
        return this.C;
    }
}
