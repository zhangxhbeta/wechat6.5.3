package com.tencent.mm.plugin.report.b;

import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.aff;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.sdk.platformtools.be;

public final class b {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public aff itt = new aff();

        public final byte[] zf() {
            this.lWS = ad.brH();
            this.itt.mgD = new are().ba(be.buh());
            this.itt.mPU = l.a(this);
            return this.itt.toByteArray();
        }

        public final int zg() {
            return 499;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
