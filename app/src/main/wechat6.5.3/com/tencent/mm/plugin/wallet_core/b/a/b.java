package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.protocal.c.aly;
import com.tencent.mm.protocal.c.alz;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;
import java.util.ArrayList;

public final class b extends k {
    private com.tencent.mm.v.b cif;
    private e cii;
    public Orders kLv;

    public b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        a aVar = new a();
        aVar.czn = new aly();
        aVar.czo = new alz();
        aVar.uri = "/cgi-bin/mmpay-bin/payibgjsgettransaction";
        aVar.czm = 1565;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aly com_tencent_mm_protocal_c_aly = (aly) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aly.glj = str;
        com_tencent_mm_protocal_c_aly.mmU = str4;
        com_tencent_mm_protocal_c_aly.mmT = str2;
        com_tencent_mm_protocal_c_aly.mmV = str5;
        com_tencent_mm_protocal_c_aly.mmW = str6;
        com_tencent_mm_protocal_c_aly.mgs = str3;
        com_tencent_mm_protocal_c_aly.mmu = str7;
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.i("MicroMsg.NetSceneIbgGetTransaction", "hy: get h5 transaction: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        alz com_tencent_mm_protocal_c_alz = (alz) ((com.tencent.mm.v.b) pVar).czl.czs;
        if (i2 == 0 && i == 0) {
            i2 = com_tencent_mm_protocal_c_alz.fvC;
            str = com_tencent_mm_protocal_c_alz.fvD;
        }
        this.kLv = new Orders();
        this.kLv.kLu = 1;
        if (com_tencent_mm_protocal_c_alz == null || com_tencent_mm_protocal_c_alz.mML == null) {
            v.e("MicroMsg.NetSceneIbgGetTransaction", "hy: info not valid");
        } else {
            this.kLv.kOU = (double) com_tencent_mm_protocal_c_alz.mML.mMQ;
            Commodity commodity = new Commodity();
            commodity.eWA = com_tencent_mm_protocal_c_alz.mML.irC;
            commodity.desc = com_tencent_mm_protocal_c_alz.mML.cOb;
            commodity.eWz = ((double) com_tencent_mm_protocal_c_alz.mML.mMQ) / 100.0d;
            commodity.hMZ = String.valueOf(com_tencent_mm_protocal_c_alz.mML.mMS);
            commodity.hNa = com_tencent_mm_protocal_c_alz.mML.mMT;
            commodity.hNe = com_tencent_mm_protocal_c_alz.mML.mMO;
            commodity.hNc = com_tencent_mm_protocal_c_alz.mML.mMN;
            commodity.hNg = com_tencent_mm_protocal_c_alz.mML.hNg;
            if (com_tencent_mm_protocal_c_alz.mMM != null) {
                commodity.hNh = com_tencent_mm_protocal_c_alz.mMM.mkK;
                com.tencent.mm.plugin.wallet_core.model.Orders.b bVar = new com.tencent.mm.plugin.wallet_core.model.Orders.b();
                bVar.name = com_tencent_mm_protocal_c_alz.mMM.mMz;
                bVar.hNh = com_tencent_mm_protocal_c_alz.mMM.mkK;
                commodity.kPx = com_tencent_mm_protocal_c_alz.mMM.mkK;
                bVar.hRr = com_tencent_mm_protocal_c_alz.mMM.eBM;
                commodity.kPd = com_tencent_mm_protocal_c_alz.mMM.mMx;
                if (!be.kS(bVar.name)) {
                    commodity.kPC.add(bVar);
                }
                this.kLv.kPd = com_tencent_mm_protocal_c_alz.mMM.mMx;
            } else {
                v.i("MicroMsg.NetSceneIbgGetTransaction", "hy: no biz info");
                this.kLv.kPd = 0;
            }
            this.kLv.kPm = new ArrayList();
            this.kLv.kPm.add(commodity);
            this.kLv.kPf = com_tencent_mm_protocal_c_alz.mML.mMT;
        }
        if (be.kS(str)) {
            str = aa.getContext().getString(2131236155);
        }
        this.cii.a(i, i2, str, this);
    }

    public final int getType() {
        return 1565;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
