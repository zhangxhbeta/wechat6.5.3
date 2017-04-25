package oicq.wlogin_sdk.a;

import com.tencent.mmdb.FileUtils;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class a {
    public int pMH = FileUtils.S_IWUSR;
    public int pMI = 0;
    public byte[] pMN = new byte[this.pMH];
    public int pMT = 0;
    int pNB = 0;
    public int pNC = 4;
    public int pND = 0;

    public final byte[] bQT() {
        Object obj = new byte[this.pMI];
        System.arraycopy(this.pMN, 0, obj, 0, this.pMI);
        return obj;
    }

    public final byte[] bQW() {
        Object obj = new byte[this.pND];
        System.arraycopy(this.pMN, this.pNC, obj, 0, this.pND);
        return obj;
    }

    public final void zS(int i) {
        util.n(this.pMN, this.pMI, i);
        this.pMI += 2;
        util.n(this.pMN, this.pMI, 0);
        this.pMI += 2;
    }

    public final void bQX() {
        util.n(this.pMN, 2, this.pMI - this.pNC);
    }

    public final void H(byte[] bArr, int i) {
        if (i > this.pMH - this.pNC) {
            this.pMH = (this.pNC + i) + 64;
            Object obj = new byte[this.pMH];
            System.arraycopy(this.pMN, 0, obj, 0, this.pMI);
            this.pMN = obj;
        }
        this.pND = i;
        System.arraycopy(bArr, 0, this.pMN, this.pMI, i);
        this.pMI += i;
    }

    private static int k(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        int i3 = i;
        while (i3 < length && i3 + 2 <= length) {
            if (util.K(bArr, i3) != i2) {
                i3 += 2;
                if (i3 + 2 > length) {
                    break;
                }
                i3 += util.K(bArr, i3) + 2;
            } else {
                return i3;
            }
        }
        return -1;
    }

    public final int l(byte[] bArr, int i, int i2) {
        int k = k(bArr, i, this.pMT);
        if (k < 0) {
            return -1;
        }
        int i3 = i2 - (k - i);
        if (this.pNC >= i3) {
            return -1;
        }
        this.pND = util.K(bArr, k + 2);
        if (this.pNC + this.pND > i3) {
            return -1;
        }
        int i4 = this.pNC + this.pND;
        if (i4 > this.pMH) {
            this.pMH = i4 + FileUtils.S_IWUSR;
            this.pMN = new byte[this.pMH];
        }
        this.pMI = i4;
        System.arraycopy(bArr, k, this.pMN, 0, i4);
        this.pMT = util.K(bArr, k);
        this.pND = i4 - this.pNC;
        if (bQY().booleanValue()) {
            return (this.pNC + k) + this.pND;
        }
        return -1005;
    }

    public final int b(byte[] bArr, int i, int i2, byte[] bArr2) {
        int k = k(bArr, i, this.pMT);
        if (k < 0) {
            return -1;
        }
        int i3 = i2 - (k - i);
        Object obj = new byte[i3];
        System.arraycopy(bArr, k, obj, 0, i3);
        if (this.pNC >= i3) {
            return -1;
        }
        this.pND = util.K(obj, 2);
        if (this.pNC + this.pND > i3) {
            return -1;
        }
        Object decrypt = d.decrypt(obj, this.pNC, this.pND, bArr2);
        if (decrypt == null) {
            return -1015;
        }
        if (this.pNC + decrypt.length > this.pMH) {
            this.pMH = this.pNC + decrypt.length;
            this.pMN = new byte[this.pMH];
        }
        this.pMI = 0;
        System.arraycopy(obj, 0, this.pMN, 0, this.pNC);
        this.pMI += this.pNC;
        System.arraycopy(decrypt, 0, this.pMN, this.pMI, decrypt.length);
        this.pMI += decrypt.length;
        this.pND = decrypt.length;
        return !bQY().booleanValue() ? -1005 : 0;
    }

    public Boolean bQY() {
        return Boolean.valueOf(true);
    }
}
