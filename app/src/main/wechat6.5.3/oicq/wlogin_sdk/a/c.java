package oicq.wlogin_sdk.a;

import com.tencent.mmdb.FileUtils;
import oicq.wlogin_sdk.tools.util;

public final class c extends a {
    int pNJ;
    int pNK;
    int pNL;

    public c() {
        this.pNJ = 1;
        this.pNK = util.pOP;
        this.pNL = 22;
        this.pMT = FileUtils.S_IRUSR;
    }

    public final byte[] a(long j, long j2, int i, int i2) {
        byte[] bArr = new byte[this.pNL];
        util.n(bArr, 0, this.pNJ);
        util.o(bArr, 2, this.pNK);
        util.o(bArr, 6, (int) j);
        util.o(bArr, 10, 1);
        util.o(bArr, 14, i);
        util.o(bArr, 18, i2);
        super.zS(this.pMT);
        super.H(bArr, this.pNL);
        super.bQX();
        return super.bQT();
    }
}
