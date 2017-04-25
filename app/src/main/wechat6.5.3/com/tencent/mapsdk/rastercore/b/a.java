package com.tencent.mapsdk.rastercore.b;

public final class a {
    public static int a = 5;
    private static double b = Math.log(2.0d);
    private int c;
    private double d;
    private double e;

    public a(double d) {
        this.e = d;
        f();
    }

    public a(int i, double d) {
        this.c = i;
        this.d = d;
        e();
    }

    public static double c(double d) {
        return 156543.0339d / Math.pow(2.0d, d);
    }

    private void e() {
        this.e = (Math.log(this.d) / b) + ((double) this.c);
        new StringBuilder("refreshZoom--zoom=").append(this.e).append(";level=").append(this.c).append(";scale=").append(this.d);
    }

    private void f() {
        this.c = (int) this.e;
        this.d = Math.pow(2.0d, this.e - ((double) this.c));
        new StringBuilder("refreshLevel--zoom=").append(this.e).append(";level=").append(this.c).append(";scale=").append(this.d);
    }

    public final int a() {
        return this.c;
    }

    public final void a(double d) {
        this.d = d;
        e();
        f();
    }

    public final void a(int i) {
        this.c = 19;
        e();
    }

    public final double b() {
        return this.d;
    }

    public final void b(double d) {
        this.e = d;
        f();
    }

    public final double c() {
        return this.e;
    }

    public final double d() {
        return c(this.e);
    }
}
