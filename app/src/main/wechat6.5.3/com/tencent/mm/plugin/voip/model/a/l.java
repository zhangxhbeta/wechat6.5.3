package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bfz;
import com.tencent.mm.protocal.c.bga;
import com.tencent.mm.protocal.c.bgb;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class l extends n<bga, bgb> {
    public l(String str, String str2, String str3, String str4, String str5) {
        a aVar = new a();
        aVar.czn = new bga();
        aVar.czo = new bgb();
        aVar.uri = "/cgi-bin/micromsg-bin/voipstatreport";
        aVar.czm = 320;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        bga com_tencent_mm_protocal_c_bga = (bga) this.cif.czk.czs;
        bfz com_tencent_mm_protocal_c_bfz = new bfz();
        arf com_tencent_mm_protocal_c_arf = new arf();
        com_tencent_mm_protocal_c_arf.JF(str);
        com_tencent_mm_protocal_c_bfz.mWh = com_tencent_mm_protocal_c_arf;
        bfz com_tencent_mm_protocal_c_bfz2 = new bfz();
        arf com_tencent_mm_protocal_c_arf2 = new arf();
        com_tencent_mm_protocal_c_arf2.JF(str2);
        com_tencent_mm_protocal_c_bfz2.mWh = com_tencent_mm_protocal_c_arf2;
        bfz com_tencent_mm_protocal_c_bfz3 = new bfz();
        arf com_tencent_mm_protocal_c_arf3 = new arf();
        com_tencent_mm_protocal_c_arf3.JF(str3);
        com_tencent_mm_protocal_c_bfz3.mWh = com_tencent_mm_protocal_c_arf3;
        bfz com_tencent_mm_protocal_c_bfz4 = new bfz();
        arf com_tencent_mm_protocal_c_arf4 = new arf();
        com_tencent_mm_protocal_c_arf4.JF(str4);
        com_tencent_mm_protocal_c_bfz4.mWh = com_tencent_mm_protocal_c_arf4;
        bfz com_tencent_mm_protocal_c_bfz5 = new bfz();
        arf com_tencent_mm_protocal_c_arf5 = new arf();
        com_tencent_mm_protocal_c_arf5.JF(str5);
        com_tencent_mm_protocal_c_bfz5.mWh = com_tencent_mm_protocal_c_arf5;
        com_tencent_mm_protocal_c_bga.naI = com_tencent_mm_protocal_c_bfz;
        com_tencent_mm_protocal_c_bga.nbH = com_tencent_mm_protocal_c_bfz2;
        com_tencent_mm_protocal_c_bga.nbG = com_tencent_mm_protocal_c_bfz3;
        com_tencent_mm_protocal_c_bga.nbI = com_tencent_mm_protocal_c_bfz4;
        com_tencent_mm_protocal_c_bga.nbJ = com_tencent_mm_protocal_c_bfz5;
    }

    public final int getType() {
        return 320;
    }

    public final e bcT() {
        return new e(this) {
            final /* synthetic */ l kvz;

            {
                this.kvz = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.NetSceneVoipStatReport", "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
            }
        };
    }
}
