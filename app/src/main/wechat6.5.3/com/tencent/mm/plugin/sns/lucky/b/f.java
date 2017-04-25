package com.tencent.mm.plugin.sns.lucky.b;

import com.tencent.mm.protocal.c.akg;
import com.tencent.mm.protocal.c.akh;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.v;

public final class f {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        int fvo;
        int jel;
        int jem;
        com.tencent.mm.ba.b jen;
        private akg jeo = new akg();

        public final void cW(int i) {
            this.fvo = i;
        }

        public final byte[] zf() {
            this.jeo.fvo = this.fvo;
            this.jeo.jel = this.jel;
            this.jeo.jem = this.jem;
            this.jeo.jen = this.jen;
            return this.jeo.toByteArray();
        }

        public final int zg() {
            return 428;
        }

        public final int getCmdId() {
            return 319;
        }

        public final boolean aRf() {
            return true;
        }

        public final boolean Cd() {
            return false;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        akh jep = new akh();

        public final int y(byte[] bArr) {
            if (bArr == null) {
                v.e("MicroMsg.NetSceneSnsLuckyMoneyFlowControl2016", "hy: buf is null!");
                return -1;
            }
            this.jep = (akh) new akh().az(bArr);
            return 0;
        }

        public final int getCmdId() {
            return 1000000319;
        }

        public final boolean aRf() {
            return true;
        }

        public final String toString() {
            return String.format("Action: %d, FeedAmountLevel: %d, FeedAmountList: %s, CacheInterval: %d, CookieBuffer: %s, Ticket: %s", new Object[]{Integer.valueOf(this.jep.aXy), Integer.valueOf(this.jep.mLj), this.jep.mLk.toString(), Integer.valueOf(this.jep.mLl), this.jep.jen.toString(), this.jep.mLm.toString()});
        }
    }
}
