package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bfa;
import com.tencent.mm.protocal.c.bfb;
import com.tencent.mm.protocal.c.bfz;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c extends n<bfa, bfb> {
    public c(int i, long j, String str, String str2, int i2) {
        a aVar = new a();
        aVar.czn = new bfa();
        aVar.czo = new bfb();
        aVar.uri = "/cgi-bin/micromsg-bin/voipcancelinvite";
        aVar.czm = 171;
        aVar.czp = 64;
        aVar.czq = 1000000064;
        this.cif = aVar.Bv();
        bfa com_tencent_mm_protocal_c_bfa = (bfa) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bfa.mqS = i;
        com_tencent_mm_protocal_c_bfa.mqT = j;
        com_tencent_mm_protocal_c_bfa.gom = str;
        com_tencent_mm_protocal_c_bfa.mNO = i2;
        bfz com_tencent_mm_protocal_c_bfz = new bfz();
        arf com_tencent_mm_protocal_c_arf = new arf();
        com_tencent_mm_protocal_c_arf.JF(str2);
        com_tencent_mm_protocal_c_bfz.mWh = com_tencent_mm_protocal_c_arf;
        com_tencent_mm_protocal_c_bfa.naI = com_tencent_mm_protocal_c_bfz;
        com_tencent_mm_protocal_c_bfa.mZV = System.currentTimeMillis();
    }

    public final int bcU() {
        bfa com_tencent_mm_protocal_c_bfa = (bfa) bcY();
        if (com_tencent_mm_protocal_c_bfa.mqS == 0 && com_tencent_mm_protocal_c_bfa.mNO == 0) {
            return -1;
        }
        return 0;
    }

    public final int getType() {
        return 171;
    }

    public final e bcT() {
        return new e(this) {
            final /* synthetic */ c kvq;

            {
                this.kvq = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.NetSceneVoipCancelInvite", "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
            }
        };
    }
}
