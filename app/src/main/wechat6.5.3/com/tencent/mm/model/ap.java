package com.tencent.mm.model;

import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.aaj;
import com.tencent.mm.protocal.c.aak;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.be;

public final class ap {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public aaj csU = new aaj();

        public final byte[] zf() {
            this.lWS = ad.brG();
            this.csU.mgD = new are().ba(be.buh());
            this.csU.mPU = l.a(this);
            return this.csU.toByteArray();
        }

        public final int zg() {
            return 616;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public aak csV = new aak();

        public final int y(byte[] bArr) {
            this.csV = (aak) new aak().az(bArr);
            l.a(this, this.csV.mQl);
            return this.csV.mQl.mcj;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
