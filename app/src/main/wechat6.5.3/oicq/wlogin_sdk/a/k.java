package oicq.wlogin_sdk.a;

public final class k extends a {
    int pNW;

    public k() {
        this.pNW = 0;
        this.pMT = 265;
    }

    public final byte[] bJ(byte[] bArr) {
        this.pNW = bArr.length;
        Object obj = new byte[this.pNW];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        super.zS(this.pMT);
        super.H(obj, this.pNW);
        super.bQX();
        return super.bQT();
    }
}
