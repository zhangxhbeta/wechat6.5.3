package com.tencent.mm.plugin.appbrand.k;

public final class b {
    private long dSH;
    private long dSI;
    private a dSJ;

    public interface a {
        boolean h(Object... objArr);
    }

    public b(long j, a aVar) {
        this.dSH = j;
        this.dSJ = aVar;
    }

    public final boolean i(Object... objArr) {
        boolean z = false;
        if (!((System.currentTimeMillis() - this.dSI < this.dSH) || this.dSJ == null)) {
            z = this.dSJ.h(objArr);
            if (z) {
                this.dSI = System.currentTimeMillis();
            }
        }
        return z;
    }
}
