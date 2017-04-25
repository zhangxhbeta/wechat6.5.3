package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.fu;
import com.tencent.mm.protocal.c.fv;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class m extends a {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public int lWW = 0;
        public int netType;

        public final byte[] zf() {
            fu fuVar = new fu();
            fuVar.mfB = d.lWh;
            fuVar.mgf = 2;
            fuVar.mgg = this.netType;
            fuVar.mgh = this.lWW;
            v.i("MicroMsg.MMBgFg", "somr online:%d nettype:%d ver:%d devid:%d", Integer.valueOf(fuVar.mgh), Integer.valueOf(fuVar.mgg), Integer.valueOf(fuVar.mfB), Integer.valueOf(fuVar.mgf));
            byte[] bArr = null;
            try {
                bArr = fuVar.toByteArray();
            } catch (Throwable e) {
                v.e("MicroMsg.MMBgFg", "MMBgfg toProtoBuf exception:%s", be.e(e));
            }
            return bArr;
        }

        public final int zg() {
            return 0;
        }

        public final int getCmdId() {
            return 312;
        }

        public final boolean aRf() {
            return true;
        }

        public final boolean Cd() {
            return false;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public fv lWX = new fv();

        public final int y(byte[] bArr) {
            this.lWX = (fv) new fv().az(bArr);
            v.d("MicroMsg.MMBgFg", "retcode:" + this.lWX.hKq);
            return this.lWX.hKq;
        }

        public final int getCmdId() {
            return 1000000312;
        }

        public final boolean aRf() {
            return true;
        }
    }
}
