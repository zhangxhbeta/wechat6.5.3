package com.tencent.mm.model;

import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.aan;
import com.tencent.mm.protocal.c.aao;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.be;

public final class ar {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public aan csY = new aan();

        public final byte[] zf() {
            this.lWS = ad.brG();
            this.csY.mgD = new are().ba(be.buh());
            this.csY.mPU = l.a(this);
            return this.csY.toByteArray();
        }

        public final int zg() {
            return 618;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public aao csZ = new aao();

        public final int y(byte[] bArr) {
            this.csZ = (aao) new aao().az(bArr);
            l.a(this, this.csZ.mQl);
            return this.csZ.mQl.mcj;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
