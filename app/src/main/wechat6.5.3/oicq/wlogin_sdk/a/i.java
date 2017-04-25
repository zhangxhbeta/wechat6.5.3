package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class i extends a {
    int pNU;

    public i() {
        this.pNU = 6;
        this.pMT = 263;
    }

    public final byte[] t(int i, int i2, int i3, int i4) {
        byte[] bArr = new byte[this.pNU];
        util.n(bArr, 0, 0);
        util.m(bArr, 2, 1);
        util.n(bArr, 3, 102400);
        util.m(bArr, 5, 1);
        super.zS(this.pMT);
        super.H(bArr, this.pNU);
        super.bQX();
        return super.bQT();
    }
}
