package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.protocal.c.bfi;
import com.tencent.mm.protocal.c.bfj;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;

public final class e extends n<bfi, bfj> {
    public e(int i, long j, String str) {
        a aVar = new a();
        aVar.czn = new bfi();
        aVar.czo = new bfj();
        aVar.uri = "/cgi-bin/micromsg-bin/voipgetroominfo";
        aVar.czm = 303;
        aVar.czp = 119;
        aVar.czq = 1000000119;
        this.cif = aVar.Bv();
        bfi com_tencent_mm_protocal_c_bfi = (bfi) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bfi.mqS = i;
        com_tencent_mm_protocal_c_bfi.mqT = j;
        com_tencent_mm_protocal_c_bfi.naR = str;
        com_tencent_mm_protocal_c_bfi.efm = 1;
        com_tencent_mm_protocal_c_bfi.mZV = System.currentTimeMillis();
    }

    public final int getType() {
        return 303;
    }

    public final void cB(int i, int i2) {
        if (i == 0 && i2 == 0) {
            if (((bfj) bcX()) != null) {
                v.i("MicroMsg.Voip.GetRoomInfo", "roomId:%d, roomKey:%s, memberCount:%d, inviteType:%d", new Object[]{Integer.valueOf(((bfj) bcX()).mqS), Long.valueOf(((bfj) bcX()).mqT), Integer.valueOf(((bfj) bcX()).eOX), Integer.valueOf(((bfj) bcX()).naJ)});
                return;
            }
            return;
        }
        v.i("MicroMsg.Voip.GetRoomInfo", "Get RoomInfo error");
    }

    public final com.tencent.mm.v.e bcT() {
        return new com.tencent.mm.v.e(this) {
            final /* synthetic */ e kvs;

            {
                this.kvs = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.GetRoomInfo", "Voip onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
                if (i == 0 && i2 == 0 && kVar != null) {
                    bfj com_tencent_mm_protocal_c_bfj = (bfj) this.kvs.bcX();
                    if (com_tencent_mm_protocal_c_bfj.mQl.mcj == 0 && !d.bbw().kuO.bcL()) {
                        d.bbw().a(com_tencent_mm_protocal_c_bfj);
                    }
                }
            }
        };
    }
}
