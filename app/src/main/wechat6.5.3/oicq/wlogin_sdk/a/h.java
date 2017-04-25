package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class h extends a {
    int pNR;
    int pNS;
    int pNT;

    public h() {
        this.pNR = 1;
        this.pNS = 1;
        this.pNT = 69;
        this.pMT = 262;
        this.pNS = util.pOP;
        if (util.pOP <= 2) {
            this.pNR = 1;
            this.pNT = 69;
            return;
        }
        this.pNR = 2;
        this.pNT = 90;
    }

    public final byte[] a(long j, int i, long j2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i2, byte[] bArr5) {
        if (util.pOP <= 2) {
            Object obj = new byte[this.pNT];
            util.n(obj, 0, this.pNR);
            util.o(obj, 2, util.bRd());
            util.o(obj, 6, this.pNS);
            util.o(obj, 10, (int) j);
            util.o(obj, 14, i);
            util.b(obj, 18, j2);
            System.arraycopy(bArr, 0, obj, 26, bArr.length);
            int length = bArr.length + 26;
            System.arraycopy(bArr2, 0, obj, length, bArr2.length);
            length += bArr2.length;
            util.m(obj, length, 1);
            length++;
            System.arraycopy(bArr3, 0, obj, length, bArr3.length);
            System.arraycopy(bArr4, 0, obj, length + bArr3.length, bArr4.length);
            Object obj2 = new byte[24];
            System.arraycopy(bArr3, 0, obj2, 0, bArr3.length);
            util.b(obj2, 16, j2);
            byte[] b = d.b(obj, obj.length, c.bN(obj2));
            this.pNT = b.length;
            super.zS(this.pMT);
            super.H(b, this.pNT);
            super.bQX();
            return super.bQT();
        }
        obj = new byte[this.pNT];
        util.n(obj, 0, this.pNR);
        util.o(obj, 2, util.bRd());
        util.o(obj, 6, this.pNS);
        util.o(obj, 10, (int) j);
        util.o(obj, 14, i);
        util.b(obj, 18, j2);
        System.arraycopy(bArr, 0, obj, 26, bArr.length);
        length = bArr.length + 26;
        System.arraycopy(bArr2, 0, obj, length, bArr2.length);
        length += bArr2.length;
        util.m(obj, length, 1);
        length++;
        System.arraycopy(bArr3, 0, obj, length, bArr3.length);
        length += bArr3.length;
        System.arraycopy(bArr4, 0, obj, length, bArr4.length);
        length += bArr4.length;
        util.o(obj, length, 0);
        length += 4;
        util.m(obj, length, i2);
        length++;
        if (bArr5 == null || bArr5.length <= 0) {
            byte[] bArr6 = new byte[16];
            util.o(bArr6, 0, util.bRd());
            util.o(bArr6, 4, util.bRd());
            util.o(bArr6, 8, util.bRd());
            util.o(bArr6, 12, util.bRd());
        } else {
            System.arraycopy(bArr5, 0, obj, length, bArr5.length);
        }
        obj2 = new byte[24];
        System.arraycopy(bArr3, 0, obj2, 0, bArr3.length);
        util.b(obj2, 16, j2);
        b = d.b(obj, obj.length, c.bN(obj2));
        this.pNT = b.length;
        super.zS(this.pMT);
        super.H(b, this.pNT);
        super.bQX();
        return bQT();
    }
}
