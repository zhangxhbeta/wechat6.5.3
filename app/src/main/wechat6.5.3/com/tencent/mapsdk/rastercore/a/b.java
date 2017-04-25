package com.tencent.mapsdk.rastercore.a;

import com.tencent.mapsdk.rastercore.b.c;
import com.tencent.mapsdk.rastercore.d.e;

public final class b extends a {
    private c d;
    private c e;
    private double f;
    private double g;

    public b(e eVar, c cVar, long j, com.tencent.tencentmap.mapsdk.map.c cVar2) {
        super(eVar, j, cVar2);
        this.e = cVar;
    }

    protected final void a(float f) {
        double d = this.g * ((double) f);
        this.d.b((this.f * ((double) f)) + this.d.b());
        this.d.a(d + this.d.a());
        this.b.b(this.d);
    }

    protected final void c() {
        this.d = this.b.b();
        this.f = this.e.b() - this.d.b();
        this.g = this.e.a() - this.d.a();
    }

    protected final void d() {
        this.b.b(this.e);
    }
}
