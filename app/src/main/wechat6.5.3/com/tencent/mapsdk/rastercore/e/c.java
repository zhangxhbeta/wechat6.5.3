package com.tencent.mapsdk.rastercore.e;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.d.e;
import java.util.ArrayList;
import java.util.List;

public class c implements b {
    private List<LatLng> a = new ArrayList();
    private int b;
    private int c;
    private LatLngBounds d = null;
    private boolean e = true;
    private float f;
    private float g = 0.0f;
    private String h;
    private e i;
    private a j;

    public c(e eVar, PolygonOptions polygonOptions) {
        this.i = eVar;
        this.j = eVar.e();
        this.h = getId();
        this.b = polygonOptions.getFillColor();
        b(polygonOptions.getPoints());
        this.e = polygonOptions.isVisible();
        this.f = polygonOptions.getStrokeWidth();
        this.g = polygonOptions.getZIndex();
        this.c = polygonOptions.getStrokeColor();
    }

    private void b(List<LatLng> list) {
        Builder builder = LatLngBounds.builder();
        this.a.clear();
        if (list != null) {
            Object obj = null;
            for (LatLng latLng : list) {
                if (!latLng.equals(obj)) {
                    this.a.add(latLng);
                    builder.include(latLng);
                    obj = latLng;
                }
            }
            int size = this.a.size();
            if (size > 1 && ((LatLng) this.a.get(0)).equals((LatLng) this.a.get(size - 1))) {
                this.a.remove(size - 1);
            }
        }
        this.d = builder.build();
    }

    public float a() {
        return this.f;
    }

    public void a(float f) {
        this.f = f;
        this.i.a(false, false);
    }

    public void a(int i) {
        this.b = i;
        this.i.a(false, false);
    }

    public void a(List<LatLng> list) {
        b((List) list);
        this.i.a(false, false);
    }

    public boolean a(LatLng latLng) {
        return com.tencent.mapsdk.rastercore.f.a.a(latLng, c());
    }

    public int b() {
        return this.b;
    }

    public void b(int i) {
        this.c = i;
        this.i.a(false, false);
    }

    public List<LatLng> c() {
        return this.a;
    }

    public boolean checkInBounds() {
        if (this.d == null) {
            return false;
        }
        LatLngBounds c = this.i.b().c();
        return c == null ? true : this.d.contains(c) || this.d.intersects(c);
    }

    public int d() {
        return this.c;
    }

    public void destroy() {
    }

    public void draw(Canvas canvas) {
        if (this.a != null && this.a.size() != 0) {
            Path path = new Path();
            LatLng latLng = (LatLng) this.a.get(0);
            PointF pointF = new PointF();
            PointF a = this.i.b().a(latLng);
            path.moveTo(a.x, a.y);
            for (int i = 1; i < this.a.size(); i++) {
                latLng = (LatLng) this.a.get(i);
                PointF pointF2 = new PointF();
                a = this.i.b().a(latLng);
                path.lineTo(a.x, a.y);
            }
            Paint paint = new Paint();
            paint.setColor(b());
            paint.setAntiAlias(true);
            paint.setStyle(Style.FILL);
            path.close();
            canvas.drawPath(path, paint);
            if (!com.tencent.mapsdk.rastercore.f.a.a(a(), 0.0f)) {
                paint.setStyle(Style.STROKE);
                paint.setColor(d());
                paint.setStrokeWidth(a());
                canvas.drawPath(path, paint);
            }
        }
    }

    public boolean equalsRemote(b bVar) {
        return equals(bVar) || bVar.getId().equals(getId());
    }

    public String getId() {
        if (this.h == null) {
            this.h = a.a("Polygon");
        }
        return this.h;
    }

    public float getZIndex() {
        return this.g;
    }

    public int hashCodeRemote() {
        return super.hashCode();
    }

    public boolean isVisible() {
        return this.e;
    }

    public void remove() {
        this.j.b(getId());
    }

    public void setVisible(boolean z) {
        this.e = z;
        this.i.a(false, false);
    }

    public void setZIndex(float f) {
        this.g = f;
        this.j.c();
        this.i.a(false, false);
    }
}
