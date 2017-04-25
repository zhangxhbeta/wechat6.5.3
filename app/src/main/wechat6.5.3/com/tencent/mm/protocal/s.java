package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.un;
import com.tencent.mm.protocal.c.uo;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.be;

public final class s {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public un lXk = new un();

        public final byte[] zf() {
            this.lWS = ad.brI();
            this.lXk.mgD = new are().ba(be.buh());
            this.lXk.mxf = ad.brG().ver;
            this.lXk.mPU = l.a(this);
            return this.lXk.toByteArray();
        }

        public final int zg() {
            return 381;
        }

        public final int getCmdId() {
            return 179;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public uo lXl = new uo();

        public final int y(byte[] bArr) {
            this.lXl = (uo) new uo().az(bArr);
            l.a(this, this.lXl.mQl);
            return this.lXl.mQl.mcj;
        }

        public final int getCmdId() {
            return 1000000179;
        }
    }
}
