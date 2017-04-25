package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.ns;
import com.tencent.mm.protocal.c.nt;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.be;

public final class q {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public ns lXg = new ns();

        public final byte[] zf() {
            this.lWS = ad.brI();
            this.lXg.mgD = new are().ba(be.buh());
            this.lXg.mPU = l.a(this);
            return this.lXg.toByteArray();
        }

        public final int zg() {
            return 481;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public nt lXh = new nt();

        public final int y(byte[] bArr) {
            this.lXh = (nt) new nt().az(bArr);
            l.a(this, this.lXh.mQl);
            return this.lXh.mQl.mcj;
        }
    }
}
