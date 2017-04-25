package com.tencent.mapsdk.rastercore.e;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.GroundOverlayOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.rastercore.d.e;

public class a implements b {
    private BitmapDescriptor a;
    private LatLng b;
    private float c;
    private float d;
    private LatLngBounds e;
    private float f;
    private float g;
    private boolean h = true;
    private float i = 0.0f;
    private float j = 0.5f;
    private float k = 0.5f;
    private String l;
    private Bitmap m;
    private e n;
    private com.tencent.mapsdk.rastercore.d.a o;

    public a(e eVar, GroundOverlayOptions groundOverlayOptions) {
        this.n = eVar;
        this.o = eVar.e();
        this.l = getId();
        this.j = groundOverlayOptions.getAnchorU();
        this.k = groundOverlayOptions.getAnchorV();
        this.f = groundOverlayOptions.getBearing();
        this.c = groundOverlayOptions.getWidth();
        this.d = groundOverlayOptions.getHeight();
        this.a = groundOverlayOptions.getImage();
        this.b = groundOverlayOptions.getLocation();
        this.e = groundOverlayOptions.getBounds();
        this.i = groundOverlayOptions.getTransparency();
        this.h = groundOverlayOptions.isVisible();
        this.g = groundOverlayOptions.getZIndex();
    }

    private void g() {
        double cos = ((double) this.c) / ((6371000.79d * Math.cos(this.b.getLatitude() * 0.01745329251994329d)) * 0.01745329251994329d);
        double d = ((double) this.d) / 111194.94043265979d;
        this.e = new LatLngBounds(new LatLng(this.b.getLatitude() - (((double) (1.0f - this.k)) * d), this.b.getLongitude() - (((double) this.j) * cos)), new LatLng((d * ((double) this.k)) + this.b.getLatitude(), (cos * ((double) (1.0f - this.j))) + this.b.getLongitude()));
    }

    private void h() {
        LatLng southwest = this.e.getSouthwest();
        LatLng northeast = this.e.getNortheast();
        this.b = new LatLng(southwest.getLatitude() + (((double) (1.0f - this.k)) * (northeast.getLatitude() - southwest.getLatitude())), southwest.getLongitude() + (((double) this.j) * (northeast.getLongitude() - southwest.getLongitude())));
        this.c = (float) (((6371000.79d * Math.cos(this.b.getLatitude() * 0.01745329251994329d)) * (northeast.getLongitude() - southwest.getLongitude())) * 0.01745329251994329d);
        this.d = (float) (((northeast.getLatitude() - southwest.getLatitude()) * 6371000.79d) * 0.01745329251994329d);
    }

    public LatLng a() {
        return this.b;
    }

    public void a(float f) {
        if (this.c != f) {
            this.c = f;
            this.d = f;
            g();
        } else {
            this.c = f;
            this.d = f;
        }
        this.n.a(false, false);
    }

    public void a(float f, float f2) {
        if (this.c == f || this.d == f2) {
            this.c = f;
            this.d = f2;
        } else {
            this.c = f;
            this.d = f2;
            g();
        }
        this.n.a(false, false);
    }

    public void a(BitmapDescriptor bitmapDescriptor) {
        this.a = bitmapDescriptor;
        this.n.a(false, false);
    }

    public void a(LatLng latLng) {
        if (this.b == null || this.b.equals(latLng)) {
            this.b = latLng;
        } else {
            this.b = latLng;
            g();
        }
        this.n.a(false, false);
    }

    public void a(LatLngBounds latLngBounds) {
        if (this.e == null || this.e.equals(latLngBounds)) {
            this.e = latLngBounds;
        } else {
            this.e = latLngBounds;
            h();
        }
        this.n.a(false, false);
    }

    public float b() {
        return this.c;
    }

    public void b(float f) {
        float f2 = (((-f) % 360.0f) + 360.0f) % 360.0f;
        Double.doubleToLongBits((double) this.f);
        Double.doubleToLongBits((double) f2);
        this.f = f2;
        this.n.a(false, false);
    }

    public void b(float f, float f2) {
        this.j = f;
        this.k = f2;
        this.n.a(false, false);
    }

    public float c() {
        return this.d;
    }

    public void c(float f) {
        this.i = f;
        this.n.a(false, false);
    }

    public boolean checkInBounds() {
        if (this.e == null) {
            return false;
        }
        LatLngBounds c = this.n.b().c();
        return c == null ? true : c.contains(this.e) || this.e.intersects(c);
    }

    public LatLngBounds d() {
        return this.e;
    }

    public void destroy() {
        try {
            remove();
            if (this.a != null) {
                Bitmap bitmap = this.a.getBitmap();
                if (bitmap != null) {
                    bitmap.recycle();
                    this.a = null;
                }
            }
            this.b = null;
            this.e = null;
        } catch (Exception e) {
            new StringBuilder("GroundOverlayDelegateImp destroy").append(e.getMessage());
        }
    }

    public void draw(Canvas canvas) {
        if (!this.h) {
            return;
        }
        if ((this.b != null || this.e != null) && this.a != null) {
            if (this.b == null) {
                h();
            } else if (this.e == null) {
                g();
            }
            if (this.c != 0.0f || this.d != 0.0f) {
                this.m = this.a.getBitmap();
                if (this.m != null && !this.m.isRecycled()) {
                    LatLng southwest = this.e.getSouthwest();
                    LatLng northeast = this.e.getNortheast();
                    PointF a = this.n.b().a(southwest);
                    PointF a2 = this.n.b().a(northeast);
                    Paint paint = new Paint();
                    float f = ((a2.x - a.x) * this.j) + a.x;
                    float f2 = ((a.y - a2.y) * this.k) + a2.y;
                    RectF rectF = new RectF(a.x - f, a2.y - f2, a2.x - f, a.y - f2);
                    paint.setAlpha((int) (255.0f - (this.i * 255.0f)));
                    paint.setFilterBitmap(true);
                    canvas.save();
                    canvas.translate(f, f2);
                    canvas.rotate(-this.f);
                    canvas.drawBitmap(this.m, null, rectF, paint);
                    canvas.restore();
                }
            }
        }
    }

    public float e() {
        return this.f;
    }

    public boolean equalsRemote(b bVar) {
        return equals(bVar) || bVar.getId().equals(getId());
    }

    public float f() {
        return this.i;
    }

    public String getId() {
        if (this.l == null) {
            this.l = com.tencent.mapsdk.rastercore.d.a.a("GroundOverlay");
        }
        return this.l;
    }

    public float getZIndex() {
        return this.g;
    }

    public int hashCodeRemote() {
        return super.hashCode();
    }

    public boolean isVisible() {
        return this.h;
    }

    public void remove() {
        this.o.b(getId());
    }

    public void setVisible(boolean z) {
        this.h = z;
        this.n.a(false, false);
    }

    public void setZIndex(float f) {
        this.g = f;
        this.o.c();
        this.n.a(false, false);
    }
}
