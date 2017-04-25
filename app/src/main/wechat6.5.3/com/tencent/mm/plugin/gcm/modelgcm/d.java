package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.protocal.c.bz;
import com.tencent.mm.protocal.c.ca;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;

public final class d {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public bz gAH = new bz();

        public final byte[] zf() {
            this.gAH.mPU = l.a(this);
            return this.gAH.toByteArray();
        }

        public final int getCmdId() {
            return 241;
        }

        public final int zg() {
            return 624;
        }
    }

    public static class b extends com.tencent.mm.protocal.l.d implements com.tencent.mm.protocal.l.b {
        public ca gAI = new ca();

        public final int y(byte[] bArr) {
            this.gAI = (ca) new ca().az(bArr);
            l.a(this, this.gAI.mQl);
            return this.gAI.mQl.mcj;
        }

        public final int getCmdId() {
            return 1000000241;
        }
    }
}
