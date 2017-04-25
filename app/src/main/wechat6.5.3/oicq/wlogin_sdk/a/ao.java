package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ao extends a {
    int pOs;
    int pOt;

    public ao() {
        this.pOs = 0;
        this.pOt = 0;
        this.pMT = 2;
    }

    public final byte[] o(byte[] bArr, byte[] bArr2) {
        this.pOs = (bArr.length + 6) + bArr2.length;
        Object obj = new byte[this.pOs];
        util.n(obj, 0, this.pOt);
        util.n(obj, 2, bArr.length);
        System.arraycopy(bArr, 0, obj, 4, bArr.length);
        int length = bArr.length + 4;
        util.n(obj, length, bArr2.length);
        System.arraycopy(bArr2, 0, obj, length + 2, bArr2.length);
        super.zS(this.pMT);
        super.H(obj, this.pOs);
        super.bQX();
        return super.bQT();
    }
}
