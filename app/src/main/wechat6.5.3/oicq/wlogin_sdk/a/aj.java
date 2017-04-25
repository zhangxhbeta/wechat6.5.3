package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class aj extends a {
    public aj() {
        this.pMT = 327;
    }

    private static int bM(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > 32) {
            return 32;
        }
        return bArr.length;
    }

    public final byte[] a(long j, byte[] bArr, byte[] bArr2) {
        int bM = bM(bArr);
        int bM2 = bM(bArr2);
        Object obj = new byte[(((bM + 6) + 2) + bM2)];
        util.c(obj, 0, j);
        util.n(obj, 4, bM);
        System.arraycopy(bArr, 0, obj, 6, bM);
        bM += 6;
        util.n(obj, bM, bM2);
        System.arraycopy(bArr2, 0, obj, bM + 2, bM2);
        super.zS(this.pMT);
        super.H(obj, obj.length);
        super.bQX();
        return super.bQT();
    }
}
