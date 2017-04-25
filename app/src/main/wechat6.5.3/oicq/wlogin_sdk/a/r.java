package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class r extends a {
    int pNX;
    int pNY;

    public r() {
        this.pNX = 0;
        this.pNY = 0;
        this.pMT = 278;
    }

    public final byte[] a(int i, int i2, long[] jArr) {
        this.pNX = 10;
        byte[] bArr = new byte[this.pNX];
        util.m(bArr, 0, this.pNY);
        util.o(bArr, 1, i);
        util.o(bArr, 5, i2);
        util.m(bArr, 9, 0);
        super.zS(this.pMT);
        super.H(bArr, this.pNX);
        super.bQX();
        return super.bQT();
    }
}
