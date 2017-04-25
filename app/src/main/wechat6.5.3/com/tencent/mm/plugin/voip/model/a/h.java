package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.protocal.c.beh;
import com.tencent.mm.protocal.c.bfq;
import com.tencent.mm.protocal.c.bfr;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class h extends n<bfq, bfr> {
    public h(int i, long j, int i2) {
        a aVar = new a();
        aVar.czn = new bfq();
        aVar.czo = new bfr();
        aVar.uri = "/cgi-bin/micromsg-bin/voipRedirect";
        aVar.czm = 678;
        aVar.czp = 240;
        aVar.czq = 1000000240;
        this.cif = aVar.Bv();
        bfq com_tencent_mm_protocal_c_bfq = (bfq) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bfq.mqS = i;
        com_tencent_mm_protocal_c_bfq.mqT = j;
        com_tencent_mm_protocal_c_bfq.mNZ = i2;
    }

    public final int getType() {
        return 678;
    }

    public final void cB(int i, int i2) {
        if (i == 0 && i2 == 0) {
            if (((bfr) this.cif.czl.czs) != null) {
                v.i("MicroMsg.Voip.Redirect", "roomId:%d, roomKey:%s, member:%d", new Object[]{Integer.valueOf(((bfr) this.cif.czl.czs).mqS), Long.valueOf(((bfr) this.cif.czl.czs).mqT), Integer.valueOf(((bfr) this.cif.czl.czs).mNZ)});
                return;
            }
            return;
        }
        v.i("MicroMsg.Voip.Redirect", "Redirect error");
    }

    public final e bcT() {
        return new e(this) {
            final /* synthetic */ h kvv;

            {
                this.kvv = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.Redirect", "Redirect response:" + i + " errCode:" + i2 + " status:" + this.kvv.ksv.mStatus);
                if (i2 != 0) {
                    com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.Redirect", " redirect response with error code:" + i2);
                    return;
                }
                bfr com_tencent_mm_protocal_c_bfr = (bfr) this.kvv.bcX();
                com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.Redirect", "room " + com_tencent_mm_protocal_c_bfr.mqS + " member " + com_tencent_mm_protocal_c_bfr.mNZ + " key " + com_tencent_mm_protocal_c_bfr.mqT + "relay addr cnt " + com_tencent_mm_protocal_c_bfr.nbv);
                beh com_tencent_mm_protocal_c_beh = new beh();
                beh com_tencent_mm_protocal_c_beh2 = new beh();
                com_tencent_mm_protocal_c_beh.naa = com_tencent_mm_protocal_c_bfr.nbv;
                com_tencent_mm_protocal_c_beh.nab = com_tencent_mm_protocal_c_bfr.nbw;
                com_tencent_mm_protocal_c_beh2.naa = com_tencent_mm_protocal_c_bfr.nbx;
                com_tencent_mm_protocal_c_beh2.nab = com_tencent_mm_protocal_c_bfr.nby;
                this.kvv.ksv.ksc.b(com_tencent_mm_protocal_c_beh, com_tencent_mm_protocal_c_beh2, null);
            }
        };
    }
}
