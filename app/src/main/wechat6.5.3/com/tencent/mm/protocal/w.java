package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.ajy;
import com.tencent.mm.protocal.c.ajz;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;

public final class w {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public ajy lXq = new ajy();

        public final byte[] zf() {
            this.lXq.mPU = l.a(this);
            return this.lXq.toByteArray();
        }

        public final int zg() {
            return 139;
        }

        public final int getCmdId() {
            return 27;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public ajz lXr = new ajz();

        public final int y(byte[] bArr) {
            this.lXr = (ajz) new ajz().az(bArr);
            l.a(this, this.lXr.mQl);
            return this.lXr.mQl.mcj;
        }

        public final int getCmdId() {
            return 1000000027;
        }
    }
}
