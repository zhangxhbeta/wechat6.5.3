package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class aa extends a {
    int pOd;

    public aa() {
        this.pOd = 0;
        this.pMT = 296;
    }

    private static int I(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > i) {
            return i;
        }
        return bArr.length;
    }

    public final byte[] a(int i, int i2, int i3, byte[] bArr, byte[] bArr2) {
        int I = I(bArr, 32);
        int I2 = I(bArr2, 16);
        this.pOd = (((I + 11) + 2) + I2) + 2;
        Object obj = new byte[this.pOd];
        util.n(obj, 0, 0);
        util.m(obj, 2, i);
        util.m(obj, 3, i2);
        util.m(obj, 4, i3);
        util.o(obj, 5, 0);
        util.n(obj, 9, I);
        System.arraycopy(bArr, 0, obj, 11, I);
        I += 11;
        util.n(obj, I, I2);
        I += 2;
        System.arraycopy(bArr2, 0, obj, I, I2);
        util.n(obj, I + I2, 0);
        super.zS(this.pMT);
        super.H(obj, this.pOd);
        super.bQX();
        return super.bQT();
    }
}
