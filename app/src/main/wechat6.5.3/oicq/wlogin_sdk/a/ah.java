package oicq.wlogin_sdk.a;

public final class ah extends a {
    public int pOk;

    public ah() {
        this.pOk = 0;
        this.pMT = 325;
    }

    public final byte[] bL(byte[] bArr) {
        int length;
        if (bArr != null) {
            length = bArr.length + 0;
        } else {
            length = 0;
        }
        Object obj = new byte[length];
        if (obj.length > 0) {
            System.arraycopy(bArr, 0, obj, 0, length);
        }
        this.pOk = obj.length;
        super.zS(this.pMT);
        super.H(obj, obj.length);
        super.bQX();
        return super.bQT();
    }
}
