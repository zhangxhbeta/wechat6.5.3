package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class ag extends a {
    public int pOj;

    public ag() {
        this.pOj = 0;
        this.pMT = 324;
    }

    public final byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        int length;
        int i;
        if (bArr != null) {
            length = bArr.length + 0;
            i = 1;
        } else {
            i = 0;
            length = 0;
        }
        if (bArr2 != null) {
            length += bArr2.length;
            i++;
        }
        if (bArr3 != null) {
            length += bArr3.length;
            i++;
        }
        if (bArr4 != null) {
            length += bArr4.length;
            i++;
        }
        Object obj = new byte[(length + 2)];
        util.n(obj, 0, i);
        if (bArr != null) {
            System.arraycopy(bArr, 0, obj, 2, bArr.length);
            i = bArr.length + 2;
        } else {
            i = 2;
        }
        if (bArr2 != null) {
            System.arraycopy(bArr2, 0, obj, i, bArr2.length);
            i += bArr2.length;
        }
        if (bArr3 != null) {
            System.arraycopy(bArr3, 0, obj, i, bArr3.length);
            i += bArr3.length;
        }
        if (bArr4 != null) {
            System.arraycopy(bArr4, 0, obj, i, bArr4.length);
        }
        byte[] b = d.b(obj, obj.length, bArr5);
        this.pOj = b.length;
        super.zS(this.pMT);
        super.H(b, b.length);
        super.bQX();
        return super.bQT();
    }
}
