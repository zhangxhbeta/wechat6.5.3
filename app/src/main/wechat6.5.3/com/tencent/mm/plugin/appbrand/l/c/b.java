package com.tencent.mm.plugin.appbrand.l.c;

public class b extends Exception {
    public int dUv;

    public b() {
        this.dUv = 1002;
    }

    public b(String str) {
        super(str);
        this.dUv = 1002;
    }

    public b(int i, Throwable th) {
        super(th);
        this.dUv = i;
    }
}
