package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.asn;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;

public final class aa {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public asn lXw = new asn();

        public final byte[] zf() {
            this.lXw.mPU = l.a(this);
            return this.lXw.toByteArray();
        }

        public final int getCmdId() {
            return 42;
        }

        public final int zg() {
            return 131;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public aso lXx = new aso();

        public final int y(byte[] bArr) {
            this.lXx = (aso) new aso().az(bArr);
            l.a(this, this.lXx.mQl);
            return this.lXx.mQl.mcj;
        }
    }
}
