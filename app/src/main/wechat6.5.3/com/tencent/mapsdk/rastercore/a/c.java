package com.tencent.mapsdk.rastercore.a;

import android.graphics.PointF;
import com.tencent.mapsdk.rastercore.d.e;

public final class c extends a {
    private PointF d;
    private double e;
    private double f;

    public c(e eVar, double d, PointF pointF, long j, com.tencent.tencentmap.mapsdk.map.c cVar) {
        super(eVar, j, cVar);
        this.e = d;
        this.d = pointF;
    }

    protected final void a(float f) {
        this.b.a(this.f * ((double) f), this.d, false, null);
    }

    protected final void c() {
        double c = this.b.c();
        this.f = this.e - c;
        new StringBuilder("newZoom:").append(this.e).append(",oldZoom=").append(c);
    }

    protected final void d() {
        this.b.a(this.e, this.d, false, 0, null);
    }
}
