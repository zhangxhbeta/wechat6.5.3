package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.kl;
import com.tencent.mm.protocal.c.km;
import com.tencent.mm.protocal.c.om;
import com.tencent.mm.protocal.c.on;
import com.tencent.mm.protocal.c.oo;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.be;

public final class r {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public final on lXi = new on();

        public a() {
            cW(0);
            this.lXi.mqQ = new om();
            this.lXi.mqQ.mqO = new kl();
            this.lXi.mqP = new oo();
        }

        public final byte[] zf() {
            this.lWS = ad.brG();
            this.lXi.mqQ.mPU = l.a(this);
            this.lXi.mqP.mgD = new are().ba(be.buh());
            return this.lXi.toByteArray();
        }

        public final int zg() {
            return 722;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public final km lXj = new km();

        public final int y(byte[] bArr) {
            this.lXj.az(bArr);
            return this.lXj.mQl.mcj;
        }
    }
}
