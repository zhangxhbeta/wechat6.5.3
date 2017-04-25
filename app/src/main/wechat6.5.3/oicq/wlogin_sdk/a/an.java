package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class an extends a {
    int pOp;
    int pOq;
    int pOr;

    public an() {
        this.pOp = 22;
        this.pOq = 1;
        this.pOr = 1536;
        this.pMT = 24;
    }

    public final byte[] a(long j, int i, long j2, int i2) {
        byte[] bArr = new byte[this.pOp];
        util.n(bArr, 0, this.pOq);
        util.o(bArr, 2, this.pOr);
        util.o(bArr, 6, (int) j);
        util.o(bArr, 10, i);
        util.o(bArr, 14, (int) j2);
        util.n(bArr, 18, 0);
        util.n(bArr, 20, 0);
        super.zS(this.pMT);
        super.H(bArr, this.pOp);
        super.bQX();
        return super.bQT();
    }
}
