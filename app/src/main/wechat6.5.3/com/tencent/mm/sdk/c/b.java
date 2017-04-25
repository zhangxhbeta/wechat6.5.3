package com.tencent.mm.sdk.c;

public abstract class b {
    public Runnable bpT = null;
    public boolean nhx;
    private int nhy = 0;

    final int bsK() {
        if (this.nhy == 0) {
            this.nhy = getClass().getName().hashCode();
        }
        return this.nhy;
    }
}
