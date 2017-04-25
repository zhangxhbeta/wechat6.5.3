package com.tencent.mm.model;

import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bds;
import com.tencent.mm.protocal.c.bdt;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.be;

public final class at {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public bds ctc = new bds();

        public final byte[] zf() {
            this.lWS = ad.brG();
            this.ctc.mgD = new are().ba(be.buh());
            this.ctc.mPU = l.a(this);
            return this.ctc.toByteArray();
        }

        public final int zg() {
            return 617;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public bdt ctd = new bdt();

        public final int y(byte[] bArr) {
            this.ctd = (bdt) new bdt().az(bArr);
            l.a(this, this.ctd.mQl);
            return this.ctd.mQl.mcj;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
