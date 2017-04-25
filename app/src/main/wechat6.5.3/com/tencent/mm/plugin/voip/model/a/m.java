package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.model.k;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bfd;
import com.tencent.mm.protocal.c.bgd;
import com.tencent.mm.protocal.c.bge;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;

public final class m extends n<bgd, bge> {
    public m(int i, bfd com_tencent_mm_protocal_c_bfd, byte[] bArr, long j, int i2) {
        a aVar = new a();
        aVar.czn = new bgd();
        aVar.czo = new bge();
        aVar.uri = "/cgi-bin/micromsg-bin/voipsync";
        aVar.czm = 174;
        aVar.czp = 62;
        aVar.czq = 1000000062;
        this.cif = aVar.Bv();
        bgd com_tencent_mm_protocal_c_bgd = (bgd) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bgd.mqS = i;
        com_tencent_mm_protocal_c_bgd.nbK = com_tencent_mm_protocal_c_bfd;
        com_tencent_mm_protocal_c_bgd.mqT = j;
        com_tencent_mm_protocal_c_bgd.mOk = k.xF();
        com_tencent_mm_protocal_c_bgd.mkE = i2;
        com_tencent_mm_protocal_c_bgd.mkF = new are().ba(bArr);
        com_tencent_mm_protocal_c_bgd.mZV = System.currentTimeMillis();
        v.d("MicroMsg.NetSceneVoipSync", "sync timestamp: " + com_tencent_mm_protocal_c_bgd.mZV);
    }

    public final int getType() {
        return 174;
    }

    public final int bcV() {
        return ((bgd) this.cif.czk.czs).mkE;
    }

    public final e bcT() {
        return new e(this) {
            final /* synthetic */ m kvA;

            {
                this.kvA = r1;
            }

            public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.NetSceneVoipSync", "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
                try {
                    if (((bge) this.kvA.bcX()).mqS != this.kvA.ksv.ksc.gFG) {
                        com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.NetSceneVoipSync", "syncOnSceneEnd: recv roomId != current roomid");
                        return;
                    }
                } catch (Exception e) {
                }
                if (i != 0) {
                    com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.NetSceneVoipSync", "VoipSync Failed, type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
                    this.kvA.ksv.ksc.kxf.ksP = 11;
                    this.kvA.ksv.ksc.kxf.ksR = i2;
                    this.kvA.ksv.ksc.kxf.ksQ = i2;
                    this.kvA.ksv.ksc.kxf.kth = 3;
                    if (i == 1) {
                        this.kvA.ksv.ksc.kxf.ktb = 8;
                    } else {
                        this.kvA.ksv.ksc.kxf.ktb = 99;
                    }
                    this.kvA.ksv.m(1, -9004, "");
                    return;
                }
                this.kvA.ksv.ksf.m(kVar);
            }
        };
    }
}
