package com.tencent.mapsdk.rastercore.c;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.rastercore.b.c;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.d.e;

public final class b extends a {
    private int d;
    private int e;
    private LatLngBounds f;
    private int g;

    public final void a(int i) {
        this.d = i;
    }

    public final void a(LatLngBounds latLngBounds) {
        this.f = latLngBounds;
    }

    public final void a(e eVar) {
        com.tencent.mapsdk.rastercore.d.b c = eVar.c();
        this.e = this.e == 0 ? c.getHeight() - (this.g * 2) : this.e - (this.g * 2);
        this.d = this.d == 0 ? c.getWidth() - (this.g * 2) : this.d - (this.g * 2);
        if (this.e != 0 && this.d != 0) {
            LatLng northeast = this.f.getNortheast();
            LatLng southwest = this.f.getSouthwest();
            c a = a.a(northeast);
            c a2 = a.a(southwest);
            double a3 = a.a() - a2.a();
            double b = a.b() - a2.b();
            com.tencent.mapsdk.rastercore.b.a a4 = eVar.b().a(new com.tencent.mapsdk.rastercore.b.a(0, (double) ((((float) this.e) * 1.0f) / ((float) this.d) < ((float) (a3 / b)) ? (float) ((((double) this.e) * 156543.0339d) / a3) : (float) ((((double) this.d) * 156543.0339d) / b))));
            c cVar = new c((a3 / 2.0d) + a2.a(), (b / 2.0d) + a2.b());
            if (this.a) {
                c.a(cVar, this.b, this.c);
            } else {
                c.b(cVar);
            }
            c.b(a4.c(), this.a, this.c);
        }
    }

    public final void b(int i) {
        this.e = i;
    }

    public final void c(int i) {
        this.g = i;
    }
}
