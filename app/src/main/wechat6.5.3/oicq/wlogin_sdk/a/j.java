package oicq.wlogin_sdk.a;

public final class j extends a {
    int pNV;

    public j() {
        this.pNV = 0;
        this.pMT = 264;
    }

    public final byte[] bI(byte[] bArr) {
        this.pNV = bArr.length;
        Object obj = new byte[this.pNV];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        super.zS(this.pMT);
        super.H(obj, this.pNV);
        super.bQX();
        return super.bQT();
    }
}
