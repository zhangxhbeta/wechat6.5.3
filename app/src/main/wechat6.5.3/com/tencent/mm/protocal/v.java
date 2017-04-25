package com.tencent.mm.protocal;

import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.aag;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.sdk.platformtools.be;

public final class v {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public aag lXp = new aag();

        public final byte[] zf() {
            this.lWS = ad.brI();
            this.lXp.mgD = new are().ba(be.buh());
            this.lXp.mPU = l.a(this);
            return this.lXp.toByteArray();
        }

        public final int zg() {
            return MMGIFException.D_GIF_ERR_WRONG_RECORD;
        }

        public final int getCmdId() {
            return 48;
        }
    }
}
