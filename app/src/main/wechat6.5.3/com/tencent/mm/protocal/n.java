package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.ge;
import com.tencent.mm.protocal.c.gf;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.be;

public final class n {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public ge lWY = new ge();

        public final byte[] zf() {
            this.lWS = ad.brG();
            this.lWY.mgD = new are().ba(be.buh());
            this.lWY.mPU = l.a(this);
            return this.lWY.toByteArray();
        }

        public final int zg() {
            return 145;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public gf lWZ = new gf();

        public final int y(byte[] bArr) {
            this.lWZ = (gf) new gf().az(bArr);
            l.a(this, this.lWZ.mQl);
            return this.lWZ.mQl.mcj;
        }
    }
}
