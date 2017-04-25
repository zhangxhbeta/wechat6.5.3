package com.tencent.mm.model;

import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.ze;
import com.tencent.mm.protocal.c.zf;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.be;

public final class aq {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public ze csW = new ze();

        public final byte[] zf() {
            this.lWS = ad.brG();
            this.csW.mgD = new are().ba(be.buh());
            this.csW.mPU = l.a(this);
            return this.csW.toByteArray();
        }

        public final int zg() {
            return 261;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public zf csX = new zf();

        public final int y(byte[] bArr) {
            this.csX = (zf) new zf().az(bArr);
            l.a(this, this.csX.mQl);
            return this.csX.mQl.mcj;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
