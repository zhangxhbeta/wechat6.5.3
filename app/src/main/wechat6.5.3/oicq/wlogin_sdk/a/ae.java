package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ae extends a {
    int pOg;
    int pOh;

    public ae() {
        this.pOg = 0;
        this.pOh = 0;
        this.pMT = 322;
    }

    public final byte[] bK(byte[] bArr) {
        this.pOh = bArr.length + 4;
        Object obj = new byte[this.pOh];
        util.n(obj, 0, this.pOg);
        util.n(obj, 2, bArr.length);
        System.arraycopy(bArr, 0, obj, 4, bArr.length);
        super.zS(this.pMT);
        super.H(obj, obj.length);
        super.bQX();
        return super.bQT();
    }
}
