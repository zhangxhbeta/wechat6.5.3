package com.tencent.mapsdk.rastercore.d;

import android.graphics.PointF;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.rastercore.b.a;
import com.tencent.mapsdk.rastercore.b.b;
import com.tencent.mapsdk.rastercore.d;

public final class c {
    private static final b a = new b(new com.tencent.mapsdk.rastercore.b.c(-2.003750834E7d, -2.003750834E7d), new com.tencent.mapsdk.rastercore.b.c(2.003750834E7d, 2.003750834E7d));
    private e b;
    private b c;
    private a d;
    private a e;
    private boolean f = false;
    private b g;
    private double h = 0.0d;
    private double i = 0.0d;

    public c(e eVar) {
        this.b = eVar;
    }

    private double a(double d) {
        return this.c.d().d() * Math.cos(0.017453292519943295d * d);
    }

    private double a(boolean z) {
        LatLngBounds c = c();
        return z ? Math.abs(c.getNortheast().getLongitude() - c.getSouthwest().getLongitude()) : Math.abs(c.getNortheast().getLatitude() - c.getSouthwest().getLatitude());
    }

    private com.tencent.mapsdk.rastercore.b.c[] k() {
        int width = this.c.getWidth();
        com.tencent.mapsdk.rastercore.b.c a = d.a.a(new PointF(0.0f, (float) this.c.getHeight()), this.c.b(), this.c.a(), this.c.d());
        com.tencent.mapsdk.rastercore.b.c a2 = d.a.a(new PointF((float) width, 0.0f), this.c.b(), this.c.a(), this.c.d());
        return new com.tencent.mapsdk.rastercore.b.c[]{a, a2};
    }

    public final float a(double d, double d2) {
        return (float) (d2 / a(d));
    }

    public final float a(float f) {
        return (float) (((double) f) / a(0.0d));
    }

    public final PointF a(LatLng latLng) {
        com.tencent.mapsdk.rastercore.b.c b = this.c.b();
        PointF a = this.c.a();
        a d = this.c.d();
        com.tencent.mapsdk.rastercore.b.c a2 = d.a.a(latLng);
        double b2 = (a2.b() - b.b()) / d.d();
        double a3 = (a2.a() - b.a()) / d.d();
        PointF pointF = new PointF();
        pointF.x = (float) (b2 + ((double) a.x));
        pointF.y = (float) (((double) a.y) - a3);
        return pointF;
    }

    public final LatLng a(int i, int i2) {
        return d.a.a(d.a.a(new PointF((float) i, (float) i2), this.c.b(), this.c.a(), this.c.d()));
    }

    public final a a(a aVar) {
        a aVar2;
        Object obj = (this.b.f().a() < 3 || this.b.f().b() <= 1.0f) ? null : 1;
        if (aVar.c() < (obj != null ? Math.log(1.3d) / Math.log(2.0d) : 0.0d) + ((double) this.e.a())) {
            aVar2 = new a(this.e.c());
            if (obj != null) {
                aVar2.a(1.3d);
            }
        } else {
            aVar2 = aVar;
        }
        if (aVar.c() > (obj != null ? Math.log(1.3d) / Math.log(2.0d) : 0.0d) + this.d.c()) {
            aVar2 = new a(this.d.c());
            if (obj != null) {
                aVar2.a(1.3d);
            }
        }
        return aVar2;
    }

    public final void a() {
        this.g = a;
        this.d = new a(18.0d);
        this.e = new a((double) a.a);
        this.c = this.b.c();
    }

    protected final void a(int i) {
        this.h = 0.0d;
    }

    public final void a(com.tencent.mapsdk.rastercore.b.c cVar) {
        double d = 0.0d;
        if (this.g != null) {
            com.tencent.mapsdk.rastercore.b.c[] k = k();
            com.tencent.mapsdk.rastercore.b.c a = this.g.a();
            com.tencent.mapsdk.rastercore.b.c b = this.g.b();
            double a2 = a.a() > k[0].a() ? a.a() - k[0].a() : 0.0d;
            if (a.b() > k[0].b()) {
                d = a.b() - k[0].b();
            }
            if (b.a() < k[1].a()) {
                a2 = b.a() - k[1].a();
            }
            if (b.b() < k[1].b()) {
                d = b.b() - k[1].b();
            }
            cVar.a(a2 + cVar.a());
            cVar.b(cVar.b() + d);
        }
    }

    public final boolean a(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            this.g = a;
            this.e.b((double) a.a);
            this.f = false;
            return true;
        }
        int height = this.c.getHeight();
        int width = this.c.getWidth();
        if (height == 0 || width == 0) {
            return false;
        }
        LatLng northeast = latLngBounds.getNortheast();
        LatLng southwest = latLngBounds.getSouthwest();
        com.tencent.mapsdk.rastercore.b.c a = d.a.a(northeast);
        com.tencent.mapsdk.rastercore.b.c a2 = d.a.a(southwest);
        double a3 = a.a() - a2.a();
        double b = a.b() - a2.b();
        float c = (((float) height) * 1.0f) / ((float) width) > ((float) (a3 / b)) ? (float) ((((double) height) * a.c(19.0d)) / a3) : (float) ((((double) width) * a.c(19.0d)) / b);
        if (c > 2.0f) {
            return false;
        }
        this.e.a(19);
        this.e.a((double) c);
        this.c.d().b(this.e.c());
        this.g = new b(a2, a);
        a(this.c.b());
        this.f = true;
        this.b.a(false, false);
        return true;
    }

    protected final void b(double d, double d2) {
        if (d > 0.0d && d2 > 0.0d) {
            double a = a(true);
            double a2 = a(false);
            if (a == 0.0d && a2 == 0.0d) {
                this.h = d;
                this.i = d2;
                return;
            }
            a = Math.max(d / a2, d2 / a);
            a d3 = this.c.d();
            d3.a(a * d3.b());
            a(d3);
            this.b.a(false, false);
        }
    }

    protected final void b(int i) {
        this.i = 0.0d;
    }

    public final com.tencent.mapsdk.rastercore.b.c[] b() {
        int i = 0;
        r1 = new com.tencent.mapsdk.rastercore.b.c[8];
        r2 = new PointF[8];
        float width = (float) this.c.getWidth();
        float height = (float) this.c.getHeight();
        r2[0] = new PointF(0.0f, 0.0f);
        r2[1] = new PointF(width / 2.0f, 0.0f);
        r2[2] = new PointF(width, 0.0f);
        r2[3] = new PointF(width, height / 2.0f);
        r2[4] = new PointF(width, height);
        r2[5] = new PointF(width / 2.0f, height);
        r2[6] = new PointF(0.0f, height);
        r2[7] = new PointF(0.0f, height / 2.0f);
        while (i < 8) {
            r1[i] = d.a.a(r2[i], this.c.b(), this.c.a(), this.c.d());
            i++;
        }
        return r1;
    }

    public final LatLngBounds c() {
        com.tencent.mapsdk.rastercore.b.c[] k = k();
        return new LatLngBounds(d.a.a(k[0]), d.a.a(k[1]));
    }

    public final void c(int i) {
        int i2 = 18;
        int a = i <= this.e.a() ? this.e.a() : i;
        if (a < 18) {
            i2 = a;
        }
        this.d.b((double) i2);
        if (this.c.d().c() >= this.d.c()) {
            this.c.b(this.d.c(), true, null);
        }
    }

    public final CameraPosition d() {
        return CameraPosition.builder().target(d.a.a(this.c.b())).zoom((float) this.c.d().a()).build();
    }

    public final void d(int i) {
        if (this.f && ((double) i) <= this.e.c()) {
            i = this.e.a();
        }
        if (i <= a.a) {
            i = a.a;
        }
        if (((double) i) >= this.d.c()) {
            i = this.d.a();
        }
        this.e.b((double) i);
        if (this.c.d().c() <= this.e.c()) {
            this.c.b(this.e.c(), true, null);
        }
    }

    public final double e() {
        double d = 1.0d;
        if (this.c.d().a() >= 7) {
            d = 1.0d - Math.abs(this.c.b().a() / 2.003750834E7d);
            if (d < 0.1d) {
                d = 0.1d;
            }
        }
        return d * this.c.d().d();
    }

    public final float f() {
        int width = this.c.getWidth();
        return (float) (d.a.a(a(0, 0), a(width, 0)) / ((double) width));
    }

    protected final double g() {
        return this.h;
    }

    protected final double h() {
        return this.i;
    }

    public final a i() {
        return this.d;
    }

    public final a j() {
        return this.e;
    }
}
