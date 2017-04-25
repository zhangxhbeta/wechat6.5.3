package com.tencent.mm.model;

import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bbf;
import com.tencent.mm.protocal.c.bbg;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.be;

public final class as {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public bbf cta = new bbf();

        public final byte[] zf() {
            this.lWS = ad.brG();
            this.cta.mgD = new are().ba(be.buh());
            this.cta.mPU = l.a(this);
            return this.cta.toByteArray();
        }

        public final int zg() {
            return 627;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public bbg ctb = new bbg();

        public final int y(byte[] bArr) {
            this.ctb = (bbg) new bbg().az(bArr);
            l.a(this, this.ctb.mQl);
            return this.ctb.mQl.mcj;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
