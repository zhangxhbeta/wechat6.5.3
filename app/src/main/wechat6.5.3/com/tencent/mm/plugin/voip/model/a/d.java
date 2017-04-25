package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bfg;
import com.tencent.mm.protocal.c.bfh;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class d extends n<bfg, bfh> {
    public d(int i, long j, int i2, int i3, int i4, int i5, int i6, byte[] bArr, int i7) {
        a aVar = new a();
        aVar.czn = new bfg();
        aVar.czo = new bfh();
        aVar.uri = "/cgi-bin/micromsg-bin/voipDoubleLinkSwitch";
        aVar.czm = 249;
        aVar.czp = 249;
        aVar.czq = 1000000249;
        this.cif = aVar.Bv();
        bfg com_tencent_mm_protocal_c_bfg = (bfg) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bfg.mqS = i;
        com_tencent_mm_protocal_c_bfg.mqT = j;
        com_tencent_mm_protocal_c_bfg.mNZ = i2;
        com_tencent_mm_protocal_c_bfg.naL = i3;
        com_tencent_mm_protocal_c_bfg.naM = i4;
        com_tencent_mm_protocal_c_bfg.naN = i5;
        com_tencent_mm_protocal_c_bfg.naO = i6;
        com_tencent_mm_protocal_c_bfg.naP = 1;
        com_tencent_mm_protocal_c_bfg.meT = new are().z(bArr, i7);
    }

    public final int getType() {
        return 249;
    }

    public final void cB(int i, int i2) {
        if (i == 0 && i2 == 0) {
            if (((bfh) bcX()) != null) {
                v.i("MicroMsg.Voip.DoubleLinkSwitch", "roomId:%d, roomKey:%s, member:%d", new Object[]{Integer.valueOf(((bfh) bcX()).mqS), Long.valueOf(((bfh) bcX()).mqT), Integer.valueOf(((bfh) bcX()).mNZ)});
                return;
            }
            return;
        }
        v.i("MicroMsg.Voip.DoubleLinkSwitch", "double link switch error");
    }

    public final e bcT() {
        return new e(this) {
            final /* synthetic */ d kvr;

            {
                this.kvr = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.DoubleLinkSwitch", "double link switch response:" + i + " errCode:" + i2 + " status:" + this.kvr.ksv.mStatus);
                if (i2 != 0) {
                    com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.Voip.DoubleLinkSwitch", " double link switch  response with error code:" + i2);
                    return;
                }
                bfh com_tencent_mm_protocal_c_bfh = (bfh) this.kvr.bcX();
                this.kvr.ksv.krP = com_tencent_mm_protocal_c_bfh.mLa;
                if (this.kvr.ksv.krP != 0) {
                    if (this.kvr.ksv.ksc.doubleLinkSwitch(com_tencent_mm_protocal_c_bfh.naQ) == 0) {
                        v2protocal com_tencent_mm_plugin_voip_model_v2protocal;
                        if (1 == com_tencent_mm_protocal_c_bfh.naQ) {
                            com_tencent_mm_plugin_voip_model_v2protocal = this.kvr.ksv.ksc;
                            com_tencent_mm_plugin_voip_model_v2protocal.kwz++;
                        } else if (2 == com_tencent_mm_protocal_c_bfh.naQ) {
                            com_tencent_mm_plugin_voip_model_v2protocal = this.kvr.ksv.ksc;
                            com_tencent_mm_plugin_voip_model_v2protocal.kwA++;
                        }
                    }
                    com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.Voip.DoubleLinkSwitch", "zhengxue[DOUBLELINK]room " + com_tencent_mm_protocal_c_bfh.mqS + " member " + com_tencent_mm_protocal_c_bfh.mNZ + " key " + com_tencent_mm_protocal_c_bfh.mqT + "report flag " + com_tencent_mm_protocal_c_bfh.mLa + "switch to link type " + com_tencent_mm_protocal_c_bfh.naQ + "doubleLinkSwitchReportStatus " + this.kvr.ksv.krP + "mDoubleLinkSwitchSucToDirectCnt" + this.kvr.ksv.ksc.kwz + "mDoubleLinkSwitchSucToRelayCnt" + this.kvr.ksv.ksc.kwA);
                }
            }
        };
    }
}
