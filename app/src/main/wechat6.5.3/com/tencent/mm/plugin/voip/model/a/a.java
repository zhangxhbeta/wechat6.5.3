package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bee;
import com.tencent.mm.protocal.c.bef;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.protocal.c.bfs;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends n<bee, bef> {
    String TAG = "MicroMsg.NetSceneVoipAck";

    public a(int i, long j, int i2, byte[] bArr, byte[] bArr2, String str) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new bee();
        aVar.czo = new bef();
        aVar.uri = "/cgi-bin/micromsg-bin/voipack";
        aVar.czm = 305;
        aVar.czp = au.CTRL_INDEX;
        aVar.czq = 1000000123;
        this.cif = aVar.Bv();
        bee com_tencent_mm_protocal_c_bee = (bee) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bee.mqS = i;
        com_tencent_mm_protocal_c_bee.mqT = j;
        com_tencent_mm_protocal_c_bee.mZU = i2;
        if (i2 != 1) {
            com_tencent_mm_protocal_c_bee.mZQ = 0;
            return;
        }
        com_tencent_mm_protocal_c_bee.mZT = str;
        bfs com_tencent_mm_protocal_c_bfs = new bfs();
        com_tencent_mm_protocal_c_bfs.efm = 2;
        are com_tencent_mm_protocal_c_are = new are();
        com_tencent_mm_protocal_c_are.ba(bArr);
        com_tencent_mm_protocal_c_bfs.meT = com_tencent_mm_protocal_c_are;
        com_tencent_mm_protocal_c_bee.mZR = com_tencent_mm_protocal_c_bfs;
        com_tencent_mm_protocal_c_bfs = new bfs();
        com_tencent_mm_protocal_c_bfs.efm = 3;
        com_tencent_mm_protocal_c_are = new are();
        com_tencent_mm_protocal_c_are.ba(bArr2);
        com_tencent_mm_protocal_c_bfs.meT = com_tencent_mm_protocal_c_are;
        com_tencent_mm_protocal_c_bee.mZS = com_tencent_mm_protocal_c_bfs;
        com_tencent_mm_protocal_c_bee.mZV = System.currentTimeMillis();
        com_tencent_mm_protocal_c_bee.mZQ = 1;
    }

    public final int getType() {
        return 305;
    }

    public final e bcT() {
        return new e(this) {
            final /* synthetic */ a kvo;

            {
                this.kvo = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.cS(this.kvo.TAG, "ack response:" + i + " errCode:" + i2 + " status:" + this.kvo.ksv.mStatus);
                if (this.kvo.ksv.mStatus == 1) {
                    com.tencent.mm.plugin.voip.b.a.cS(this.kvo.TAG, "reject ok!");
                } else if (this.kvo.ksv.mStatus != 3) {
                    com.tencent.mm.plugin.voip.b.a.cR(this.kvo.TAG, "ack response not within WAITCONNECT, ignored.");
                } else if (i == 0) {
                    bef com_tencent_mm_protocal_c_bef = (bef) this.kvo.bcX();
                    if (com_tencent_mm_protocal_c_bef.mZQ != 1) {
                        com.tencent.mm.plugin.voip.b.a.cS(this.kvo.TAG, "onVoipAckResp: do not use preconnect");
                        return;
                    }
                    this.kvo.ksv.krE = true;
                    this.kvo.ksv.ksc.kwi = 1;
                    this.kvo.ksv.ksc.gFG = com_tencent_mm_protocal_c_bef.mqS;
                    this.kvo.ksv.ksc.gFH = com_tencent_mm_protocal_c_bef.mqT;
                    this.kvo.ksv.ksc.gFO = com_tencent_mm_protocal_c_bef.mZW;
                    this.kvo.ksv.rF(com_tencent_mm_protocal_c_bef.mZY);
                    com.tencent.mm.plugin.voip.b.a.cS(this.kvo.TAG, "ack ok, roomid =" + this.kvo.ksv.ksc.gFG + ",memberid = " + this.kvo.ksv.ksc.gFO);
                    bfo com_tencent_mm_protocal_c_bfo = com_tencent_mm_protocal_c_bef.mZX;
                    if (com_tencent_mm_protocal_c_bfo.gGd > 0) {
                        com_tencent_mm_protocal_c_bfo.gGd--;
                        com.tencent.mm.plugin.voip.b.a.cS(this.kvo.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + com_tencent_mm_protocal_c_bfo.gGd + "] from ackresp relaydata");
                    } else {
                        com_tencent_mm_protocal_c_bfo.gGd = 1;
                        com.tencent.mm.plugin.voip.b.a.cS(this.kvo.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in ackresp mrdata");
                    }
                    com.tencent.mm.plugin.voip.b.a.cS(this.kvo.TAG, "ack with switchtcpcnt  =" + this.kvo.ksv.ksc.kvQ);
                    this.kvo.ksv.rE(com_tencent_mm_protocal_c_bfo.naY);
                    this.kvo.ksv.aH(com_tencent_mm_protocal_c_bfo.mZR.meT.mQw.toByteArray());
                    if (!(com_tencent_mm_protocal_c_bfo.nbf == null || com_tencent_mm_protocal_c_bfo.nbf.mQw == null || com_tencent_mm_protocal_c_bfo.nbr == null || com_tencent_mm_protocal_c_bfo.nbr.mQw == null)) {
                        this.kvo.ksv.a(com_tencent_mm_protocal_c_bfo.nbf.mQw.toByteArray(), com_tencent_mm_protocal_c_bfo.nbe, com_tencent_mm_protocal_c_bfo.gGd, com_tencent_mm_protocal_c_bfo.nbr.mQw.toByteArray());
                    }
                    this.kvo.ksv.g(com_tencent_mm_protocal_c_bfo.nbi, com_tencent_mm_protocal_c_bfo.nbj, com_tencent_mm_protocal_c_bfo.nbk, com_tencent_mm_protocal_c_bfo.nbl, com_tencent_mm_protocal_c_bfo.nbm);
                    this.kvo.ksv.aI(com_tencent_mm_protocal_c_bfo.mZS.meT.mQw.toByteArray());
                    this.kvo.ksv.a(com_tencent_mm_protocal_c_bfo.naZ, com_tencent_mm_protocal_c_bfo.nba, com_tencent_mm_protocal_c_bfo.nbh);
                    this.kvo.ksv.rD(com_tencent_mm_protocal_c_bfo.nbq);
                    if (!(com_tencent_mm_protocal_c_bfo.nbo == null || com_tencent_mm_protocal_c_bfo.nbp == null)) {
                        this.kvo.ksv.d(com_tencent_mm_protocal_c_bfo.nbn, com_tencent_mm_protocal_c_bfo.nbo.mQw.toByteArray(), com_tencent_mm_protocal_c_bfo.nbp.mQw.toByteArray());
                    }
                    com.tencent.mm.plugin.voip.b.a.cS(this.kvo.TAG, "ack success, try connect channel");
                    this.kvo.ksv.bbL();
                } else if (i == 4) {
                    this.kvo.ksv.ksc.kxf.ksP = 12;
                    this.kvo.ksv.ksc.kxf.ksQ = i2;
                    this.kvo.ksv.m(1, i2, "");
                } else {
                    this.kvo.ksv.ksc.kxf.ksP = 12;
                    this.kvo.ksv.ksc.kxf.ksQ = i2;
                    this.kvo.ksv.m(1, -9004, "");
                }
            }
        };
    }
}
