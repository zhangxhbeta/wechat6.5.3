package com.tencent.mapsdk.rastercore.b;

public final class b {
    private c a;
    private c b;

    public static final class a {
        private double a = Double.MAX_VALUE;
        private double b = -1.7976931348623157E308d;
        private double c = Double.MAX_VALUE;
        private double d = -1.7976931348623157E308d;

        public final a a(c cVar) {
            this.a = Math.min(this.a, cVar.a());
            this.b = Math.max(this.b, cVar.a());
            this.d = Math.max(this.d, cVar.b());
            this.c = Math.min(this.c, cVar.b());
            return this;
        }
    }

    public b(c cVar, c cVar2) {
        a a = new a().a(cVar).a(cVar2);
        this.a = new c(a.a, a.c);
        this.b = new c(a.b, a.d);
    }

    public final c a() {
        return this.a;
    }

    public final c b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a.equals(bVar.a) && this.b.equals(bVar.b);
    }

    public final int hashCode() {
        return com.tencent.mapsdk.rastercore.f.a.a(new Object[]{this.a, this.b});
    }

    public final String toString() {
        return com.tencent.mapsdk.rastercore.f.a.a(com.tencent.mapsdk.rastercore.f.a.a("southwest", this.a), com.tencent.mapsdk.rastercore.f.a.a("northeast", this.b));
    }
}
