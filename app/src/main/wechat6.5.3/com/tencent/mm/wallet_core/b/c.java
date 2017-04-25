package com.tencent.mm.wallet_core.b;

public final class c {
    public String biS;
    public int errCode;
    public int errType;
    public int piu;

    public c(int i, int i2, String str) {
        this.piu = 0;
        b(i, i2, str, 0);
    }

    public final void b(int i, int i2, String str, int i3) {
        this.errType = i;
        this.errCode = i2;
        this.biS = str;
        this.piu = i3;
    }

    public c() {
        this.piu = 0;
        this.errType = 0;
        this.errCode = 0;
        this.biS = "";
        this.piu = 0;
    }
}
