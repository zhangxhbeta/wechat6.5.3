package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.zi;
import com.tencent.mm.protocal.c.zj;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.be;

public final class u {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public zi lXn = new zi();

        public final byte[] zf() {
            this.lWS = ad.brG();
            this.lXn.mgD = new are().ba(be.buh());
            this.lXn.mPU = l.a(this);
            return this.lXn.toByteArray();
        }

        public final int zg() {
            return 429;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public zj lXo = new zj();

        public final int y(byte[] bArr) {
            this.lXo = (zj) new zj().az(bArr);
            l.a(this, this.lXo.mQl);
            return this.lXo.mQl.mcj;
        }
    }
}
