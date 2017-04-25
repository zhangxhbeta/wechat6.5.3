package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.d;

public final class c {

    public static class a extends com.tencent.mm.protocal.l.c implements com.tencent.mm.protocal.l.a {
        public bx gAF = new bx();

        public final byte[] zf() {
            this.gAF.mPU = l.a(this);
            return this.gAF.toByteArray();
        }

        public final int getCmdId() {
            return 289;
        }

        public final int zg() {
            return 623;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public by gAG = new by();

        public final int y(byte[] bArr) {
            this.gAG = (by) new by().az(bArr);
            l.a(this, this.gAG.mQl);
            return this.gAG.mQl.mcj;
        }

        public final int getCmdId() {
            return 1000000289;
        }
    }
}
