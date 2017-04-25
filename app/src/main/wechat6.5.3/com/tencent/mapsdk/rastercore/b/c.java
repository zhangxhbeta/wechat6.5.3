package com.tencent.mapsdk.rastercore.b;

public final class c {
    private double a = Double.MIN_VALUE;
    private double b = Double.MIN_VALUE;

    public c(double d, double d2) {
        this.b = d2;
        this.a = d;
    }

    public final double a() {
        return this.a;
    }

    public final void a(double d) {
        this.a = d;
    }

    public final double b() {
        return this.b;
    }

    public final void b(double d) {
        this.b = d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.hashCode() != hashCode()) {
            return false;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Double.doubleToLongBits(cVar.b) == Double.doubleToLongBits(this.b) && Double.doubleToLongBits(cVar.a) == Double.doubleToLongBits(this.a);
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.b);
        long doubleToLongBits2 = Double.doubleToLongBits(this.a);
        return ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + ((((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32))) + 31) * 31);
    }
}
