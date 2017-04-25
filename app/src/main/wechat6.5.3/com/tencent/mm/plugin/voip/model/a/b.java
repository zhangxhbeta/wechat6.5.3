package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bei;
import com.tencent.mm.protocal.c.bej;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.protocal.c.bfs;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends n<bei, bej> {
    String TAG = "MicroMsg.NetSceneVoipAnswer";

    public b(int i, int i2, int i3, byte[] bArr, byte[] bArr2, long j, boolean z, boolean z2) {
        a aVar = new a();
        aVar.czn = new bei();
        aVar.czo = new bej();
        aVar.uri = "/cgi-bin/micromsg-bin/voipanswer";
        aVar.czm = 172;
        aVar.czp = 65;
        aVar.czq = 1000000065;
        this.cif = aVar.Bv();
        bei com_tencent_mm_protocal_c_bei = (bei) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bei.nac = i;
        com_tencent_mm_protocal_c_bei.mqS = i3;
        com_tencent_mm_protocal_c_bei.mnk = i2;
        bfs com_tencent_mm_protocal_c_bfs = new bfs();
        com_tencent_mm_protocal_c_bfs.efm = 2;
        are com_tencent_mm_protocal_c_are = new are();
        com_tencent_mm_protocal_c_are.ba(bArr);
        com_tencent_mm_protocal_c_bfs.meT = com_tencent_mm_protocal_c_are;
        com_tencent_mm_protocal_c_bei.mZR = com_tencent_mm_protocal_c_bfs;
        com_tencent_mm_protocal_c_bfs = new bfs();
        com_tencent_mm_protocal_c_bfs.efm = 3;
        com_tencent_mm_protocal_c_are = new are();
        com_tencent_mm_protocal_c_are.ba(bArr2);
        com_tencent_mm_protocal_c_bfs.meT = com_tencent_mm_protocal_c_are;
        com_tencent_mm_protocal_c_bei.mZS = com_tencent_mm_protocal_c_bfs;
        com_tencent_mm_protocal_c_bei.mqT = j;
        if (z2) {
            com_tencent_mm_protocal_c_bei.nad = z ? 1 : 0;
        }
        com_tencent_mm_protocal_c_bei.mZV = System.currentTimeMillis();
    }

    public final int getType() {
        return 172;
    }

    public final e bcT() {
        return new e(this) {
            final /* synthetic */ b kvp;

            {
                this.kvp = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.cS(this.kvp.TAG, "Anwser response:" + i + " errCode:" + i2 + " status:" + this.kvp.ksv.mStatus);
                if (this.kvp.ksv.mStatus == 1) {
                    com.tencent.mm.plugin.voip.b.a.cS(this.kvp.TAG, "reject ok!");
                } else if (this.kvp.ksv.mStatus != 4) {
                    com.tencent.mm.plugin.voip.b.a.cR(this.kvp.TAG, "Anwser response not within WAITCONNECT, ignored.");
                } else if (i == 0) {
                    bej com_tencent_mm_protocal_c_bej = (bej) this.kvp.bcX();
                    this.kvp.ksv.ksc.gFG = com_tencent_mm_protocal_c_bej.mqS;
                    this.kvp.ksv.ksc.gFH = com_tencent_mm_protocal_c_bej.mqT;
                    this.kvp.ksv.ksc.gFO = com_tencent_mm_protocal_c_bej.mZW;
                    this.kvp.ksv.ksc.kwk = com_tencent_mm_protocal_c_bej.nag;
                    this.kvp.ksv.ksc.kwl = com_tencent_mm_protocal_c_bej.nah;
                    this.kvp.ksv.ksc.kwm = com_tencent_mm_protocal_c_bej.nai;
                    this.kvp.ksv.ksc.kwn = com_tencent_mm_protocal_c_bej.naj;
                    this.kvp.ksv.ksc.kwp = com_tencent_mm_protocal_c_bej.nal;
                    this.kvp.ksv.ksc.kwo = com_tencent_mm_protocal_c_bej.naq;
                    this.kvp.ksv.rF(com_tencent_mm_protocal_c_bej.mZY);
                    com.tencent.mm.plugin.voip.b.a.cS(this.kvp.TAG, "onAnwserResp: audioTsdfBeyond3G = " + this.kvp.ksv.ksc.kwk + ",audioTsdEdge = " + this.kvp.ksv.ksc.kwl + ",passthroughQosAlgorithm = " + this.kvp.ksv.ksc.kwm + ",fastPlayRepair = " + this.kvp.ksv.ksc.kwn + ", audioDtx = " + this.kvp.ksv.ksc.kwp + ", switchtcppktCnt=" + this.kvp.ksv.ksc.kvQ + ", SvrCfgListV=" + this.kvp.ksv.ksc.kwo);
                    this.kvp.ksv.ksc.kwq = com_tencent_mm_protocal_c_bej.nap;
                    com.tencent.mm.plugin.voip.b.a.cS(this.kvp.TAG, "answerResp AudioAecMode5 = " + this.kvp.ksv.ksc.kwq);
                    this.kvp.ksv.krC = true;
                    com.tencent.mm.plugin.voip.b.a.cS(this.kvp.TAG, "answer ok, roomid =" + this.kvp.ksv.ksc.gFG + ",memberid = " + this.kvp.ksv.ksc.gFO);
                    bfo com_tencent_mm_protocal_c_bfo = com_tencent_mm_protocal_c_bej.mZX;
                    if (com_tencent_mm_protocal_c_bfo.gGd > 0) {
                        com_tencent_mm_protocal_c_bfo.gGd--;
                        com.tencent.mm.plugin.voip.b.a.cS(this.kvp.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + com_tencent_mm_protocal_c_bfo.gGd + "] from answerresp relaydata");
                    } else {
                        com_tencent_mm_protocal_c_bfo.gGd = 1;
                        com.tencent.mm.plugin.voip.b.a.cS(this.kvp.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in answerresp mrdata");
                    }
                    com.tencent.mm.plugin.voip.b.a.cS(this.kvp.TAG, "answer with relayData peerid.length =" + com_tencent_mm_protocal_c_bfo.mZR.meT.mQu);
                    com.tencent.mm.plugin.voip.b.a.cS(this.kvp.TAG, "answer with relayData capinfo.length =" + com_tencent_mm_protocal_c_bfo.mZS.meT.mQu);
                    this.kvp.ksv.rE(com_tencent_mm_protocal_c_bfo.naY);
                    this.kvp.ksv.a(com_tencent_mm_protocal_c_bfo.naZ, com_tencent_mm_protocal_c_bfo.nba, com_tencent_mm_protocal_c_bfo.nbh);
                    if (com_tencent_mm_protocal_c_bfo.mZR.meT.mQw != null) {
                        this.kvp.ksv.aH(com_tencent_mm_protocal_c_bfo.mZR.meT.mQw.toByteArray());
                    } else {
                        v.e(this.kvp.TAG, "multiRelayData.PeerId.Buffer.getBuffer() is null");
                    }
                    if (!(com_tencent_mm_protocal_c_bfo.nbf == null || com_tencent_mm_protocal_c_bfo.nbf.mQw == null || com_tencent_mm_protocal_c_bfo.nbr == null || com_tencent_mm_protocal_c_bfo.nbr.mQw == null)) {
                        this.kvp.ksv.a(com_tencent_mm_protocal_c_bfo.nbf.mQw.toByteArray(), com_tencent_mm_protocal_c_bfo.nbe, com_tencent_mm_protocal_c_bfo.gGd, com_tencent_mm_protocal_c_bfo.nbr.mQw.toByteArray());
                    }
                    this.kvp.ksv.g(com_tencent_mm_protocal_c_bfo.nbi, com_tencent_mm_protocal_c_bfo.nbj, com_tencent_mm_protocal_c_bfo.nbk, com_tencent_mm_protocal_c_bfo.nbl, com_tencent_mm_protocal_c_bfo.nbm);
                    this.kvp.ksv.rD(com_tencent_mm_protocal_c_bfo.nbq);
                    if (!(com_tencent_mm_protocal_c_bfo.nbo == null || com_tencent_mm_protocal_c_bfo.nbp == null || com_tencent_mm_protocal_c_bfo.nbo.mQw == null || com_tencent_mm_protocal_c_bfo.nbp.mQw == null)) {
                        this.kvp.ksv.d(com_tencent_mm_protocal_c_bfo.nbn, com_tencent_mm_protocal_c_bfo.nbo.mQw.toByteArray(), com_tencent_mm_protocal_c_bfo.nbp.mQw.toByteArray());
                    }
                    if (com_tencent_mm_protocal_c_bfo.mZS.meT.mQw != null) {
                        this.kvp.ksv.aI(com_tencent_mm_protocal_c_bfo.mZS.meT.mQw.toByteArray());
                    } else {
                        v.e(this.kvp.TAG, "multiRelayData.CapInfo.Buffer.getBuffer() is null");
                    }
                    if (this.kvp.ksv.krE) {
                        this.kvp.ksv.krE = false;
                        if (this.kvp.ksv.krz) {
                            com.tencent.mm.plugin.voip.b.a.cS(this.kvp.TAG, "channel pre-connect already success, start talk");
                            this.kvp.ksv.bbH();
                            return;
                        } else if (this.kvp.ksv.krD) {
                            com.tencent.mm.plugin.voip.b.a.cS(this.kvp.TAG, "channel pre-connect already failed");
                            this.kvp.ksv.m(1, -9000, "");
                            return;
                        } else {
                            com.tencent.mm.plugin.voip.b.a.cS(this.kvp.TAG, "channel pre-connect still connecting...");
                            return;
                        }
                    }
                    v.i(this.kvp.TAG, "isPreConnect is false");
                    this.kvp.ksv.bbM();
                    this.kvp.ksv.bbL();
                } else if (i == 4) {
                    this.kvp.ksv.ksc.kxf.ksP = 12;
                    this.kvp.ksv.ksc.kxf.ksQ = i2;
                    this.kvp.ksv.m(1, i2, "");
                } else {
                    this.kvp.ksv.ksc.kxf.ksP = 12;
                    this.kvp.ksv.ksc.kxf.ksQ = i2;
                    this.kvp.ksv.m(1, -9004, "");
                }
            }
        };
    }
}
