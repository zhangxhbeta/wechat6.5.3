package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bft;
import com.tencent.mm.protocal.c.bfu;
import com.tencent.mm.protocal.c.bfz;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class i extends n<bft, bfu> {
    String TAG = "MicroMsg.NetSceneVoipShutDown";

    public i(int i, long j, String str) {
        a aVar = new a();
        aVar.czn = new bft();
        aVar.czo = new bfu();
        aVar.uri = "/cgi-bin/micromsg-bin/voipshutdown";
        aVar.czm = 173;
        aVar.czp = 66;
        aVar.czq = 1000000066;
        this.cif = aVar.Bv();
        bft com_tencent_mm_protocal_c_bft = (bft) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bft.mqS = i;
        com_tencent_mm_protocal_c_bft.mqT = j;
        bfz com_tencent_mm_protocal_c_bfz = new bfz();
        arf com_tencent_mm_protocal_c_arf = new arf();
        com_tencent_mm_protocal_c_arf.JF(str);
        com_tencent_mm_protocal_c_bfz.mWh = com_tencent_mm_protocal_c_arf;
        com_tencent_mm_protocal_c_bft.naI = com_tencent_mm_protocal_c_bfz;
        com_tencent_mm_protocal_c_bft.mZV = System.currentTimeMillis();
    }

    public final int getType() {
        return 173;
    }

    public final e bcT() {
        return new e(this) {
            final /* synthetic */ i kvw;

            {
                this.kvw = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.cT(this.kvw.TAG, "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
            }
        };
    }
}
