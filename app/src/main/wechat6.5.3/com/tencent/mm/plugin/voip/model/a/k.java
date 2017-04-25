package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.axs;
import com.tencent.mm.protocal.c.bfx;
import com.tencent.mm.protocal.c.bfy;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;

public final class k extends n<bfx, bfy> {
    public k(axs com_tencent_mm_protocal_c_axs) {
        a aVar = new a();
        aVar.czn = new bfx();
        aVar.czo = new bfy();
        aVar.uri = "/cgi-bin/micromsg-bin/voipspeedtest";
        aVar.czm = 765;
        aVar.czp = 765;
        aVar.czq = 1000000765;
        this.cif = aVar.Bv();
        bfx com_tencent_mm_protocal_c_bfx = (bfx) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bfx.mqS = com_tencent_mm_protocal_c_axs.mqS;
        com_tencent_mm_protocal_c_bfx.mUW = com_tencent_mm_protocal_c_axs.mUW;
        com_tencent_mm_protocal_c_bfx.mnk = com_tencent_mm_protocal_c_axs.mnk;
        com_tencent_mm_protocal_c_bfx.mUX = com_tencent_mm_protocal_c_axs.mUX;
        com_tencent_mm_protocal_c_bfx.mUY = com_tencent_mm_protocal_c_axs.mUY;
        com_tencent_mm_protocal_c_bfx.mUZ = com_tencent_mm_protocal_c_axs.mUZ;
        com_tencent_mm_protocal_c_bfx.mVa = com_tencent_mm_protocal_c_axs.mVa;
        com_tencent_mm_protocal_c_bfx.mVb = com_tencent_mm_protocal_c_axs.mVb;
        com_tencent_mm_protocal_c_bfx.mVc = com_tencent_mm_protocal_c_axs.mVc;
        com_tencent_mm_protocal_c_bfx.mVd = com_tencent_mm_protocal_c_axs.mVd;
        com_tencent_mm_protocal_c_bfx.mVe = com_tencent_mm_protocal_c_axs.mVe;
        com_tencent_mm_protocal_c_bfx.mVf = com_tencent_mm_protocal_c_axs.mVf;
        com_tencent_mm_protocal_c_bfx.mVg = com_tencent_mm_protocal_c_axs.mVg;
    }

    public final int getType() {
        return 765;
    }

    public final e bcT() {
        return new e(this) {
            final /* synthetic */ k kvy;

            {
                this.kvy = r1;
            }

            public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.NetSceneVoipSpeedTest", "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
                try {
                    bfy com_tencent_mm_protocal_c_bfy = (bfy) this.kvy.bcX();
                    if (com_tencent_mm_protocal_c_bfy.nbD == 0 || com_tencent_mm_protocal_c_bfy.nbE == 0) {
                        com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, svrCount = " + com_tencent_mm_protocal_c_bfy.nbE);
                    } else if (this.kvy.ksv.krH != 1) {
                        com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, for mSpeedTestStatus = " + this.kvy.ksv.krH);
                    } else {
                        this.kvy.ksv.krH = 2;
                        this.kvy.ksv.krJ = com_tencent_mm_protocal_c_bfy.nbz;
                        v2protocal com_tencent_mm_plugin_voip_model_v2protocal = this.kvy.ksv.ksc;
                        if (com_tencent_mm_plugin_voip_model_v2protocal.kwL != 0) {
                            com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.Voip", "v2protocal StartVoipSpeedTest fail: a speedtest is doing");
                            return;
                        }
                        com_tencent_mm_plugin_voip_model_v2protocal.kwL = com_tencent_mm_protocal_c_bfy.nbz;
                        com_tencent_mm_plugin_voip_model_v2protocal.field_SpeedTestSvrParaArray = com.tencent.mm.plugin.voip.b.a.a(com_tencent_mm_protocal_c_bfy);
                        com_tencent_mm_plugin_voip_model_v2protocal.StartSpeedTest(com_tencent_mm_protocal_c_bfy.nbz, com_tencent_mm_protocal_c_bfy.nbE);
                    }
                } catch (Exception e) {
                    this.kvy.ksv.krH = 0;
                }
            }
        };
    }
}
