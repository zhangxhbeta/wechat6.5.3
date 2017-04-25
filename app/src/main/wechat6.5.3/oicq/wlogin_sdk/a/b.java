package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class b extends a {
    int pNE;
    int pNF;
    int pNG;
    int pNH;
    byte[] pNI;

    public b() {
        this.pNE = 4;
        this.pNF = 14;
        this.pNG = 1;
        this.pNH = 20;
        this.pNI = new byte[2];
        this.pMT = 1;
    }

    public final Boolean bQY() {
        if (this.pND < 20) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    public final byte[] f(long j, byte[] bArr) {
        Object obj = new byte[this.pNH];
        util.n(obj, 0, this.pNG);
        util.o(obj, 2, util.bRd());
        util.o(obj, 6, (int) j);
        util.c(obj, 10, util.bRf());
        System.arraycopy(bArr, 0, obj, 14, bArr.length);
        util.n(obj, bArr.length + 14, 0);
        super.zS(this.pMT);
        super.H(obj, this.pNH);
        super.bQX();
        return super.bQT();
    }
}
