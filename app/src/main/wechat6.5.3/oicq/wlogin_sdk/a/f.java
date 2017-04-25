package oicq.wlogin_sdk.a;

public final class f extends a {
    int pNM;

    public f() {
        this.pNM = 0;
        this.pMT = 260;
    }

    public final byte[] bH(byte[] bArr) {
        this.pNM = bArr.length;
        Object obj = new byte[this.pNM];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        super.zS(this.pMT);
        super.H(obj, this.pNM);
        super.bQX();
        return super.bQT();
    }
}
