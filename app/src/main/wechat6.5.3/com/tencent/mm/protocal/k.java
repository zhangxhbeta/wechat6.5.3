package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.dt;
import com.tencent.mm.protocal.c.dv;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.v;

public final class k {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public dt lWJ = new dt();
        public byte[] lWK;

        public final byte[] zf() {
            this.lWJ.mPU = l.a(this);
            v.d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", this.lWK, Integer.valueOf(this.lWJ.meD), this.lWJ.meE, this.lWJ.meF, this.lWJ.meG, Integer.valueOf(this.lWJ.maG), Long.valueOf(this.lWJ.eeK), this.lWJ.meH, this.lWJ.meI);
            return this.lWJ.toByteArray();
        }

        public final int zg() {
            return 1000;
        }

        public final int getCmdId() {
            return 1000;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public dv lWL = new dv();

        public final int y(byte[] bArr) {
            this.lWL = (dv) new dv().az(bArr);
            v.d("MicroMsg.MMBakchatCreateQRcodeOffline.Resp", "Ret:%d, QRCodeBuffer:%s, QRCodeUrl:%s", Integer.valueOf(this.lWL.mcj), this.lWL.meJ, this.lWL.meK);
            return this.lWL.mcj;
        }

        public final int getCmdId() {
            return 1000;
        }
    }
}
