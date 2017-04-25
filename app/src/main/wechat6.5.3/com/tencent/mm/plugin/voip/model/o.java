package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.a.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.bfd;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.protocal.c.bfs;
import com.tencent.mm.protocal.c.bgc;
import com.tencent.mm.protocal.c.bge;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class o {
    e kqI = null;
    bfo kvk = new bfo();
    private bfd kvl = null;
    private int kvm = 0;

    public o(e eVar) {
        this.kqI = eVar;
    }

    private void a(bfd com_tencent_mm_protocal_c_bfd) {
        if (com_tencent_mm_protocal_c_bfd == null) {
            a.cR("MicroMsg.Voip.VoipSyncHandle", "failed to pushVoipCmdList , VoipCmdList = null");
            this.kvm++;
            return;
        }
        if (this.kvl == null) {
            this.kvl = new bfd();
        }
        for (int i = 0; i < com_tencent_mm_protocal_c_bfd.eet; i++) {
            this.kvl.eeu.add((bfc) com_tencent_mm_protocal_c_bfd.eeu.get(i));
        }
        this.kvl.eet = this.kvl.eeu.size();
    }

    private void b(bfd com_tencent_mm_protocal_c_bfd) {
        if (this.kvl != null && this.kvl.eet > 0) {
            for (int i = 0; i < this.kvl.eet; i++) {
                com_tencent_mm_protocal_c_bfd.eeu.add((bfc) this.kvl.eeu.get(i));
            }
            com_tencent_mm_protocal_c_bfd.eet = com_tencent_mm_protocal_c_bfd.eeu.size();
            bcS();
        }
    }

    public final void bcS() {
        if (this.kvl != null) {
            this.kvl.eeu.clear();
            this.kvl.eet = 0;
            this.kvl = null;
            this.kvm = 0;
        }
    }

    public final int a(bfd com_tencent_mm_protocal_c_bfd, boolean z, int i) {
        if (this.kqI.ksc.gFG == 0) {
            a.cR("MicroMsg.Voip.VoipSyncHandle", g.sm() + "failed to do voip sync , roomid = 0");
        } else if (this.kqI.ksi) {
            a.cR("MicroMsg.Voip.VoipSyncHandle", g.sm() + "voip syncing, push to cache...");
            a(com_tencent_mm_protocal_c_bfd);
        } else {
            bfd com_tencent_mm_protocal_c_bfd2;
            this.kqI.ksi = true;
            if (com_tencent_mm_protocal_c_bfd == null) {
                com_tencent_mm_protocal_c_bfd2 = new bfd();
                com_tencent_mm_protocal_c_bfd2.eet = 0;
                com_tencent_mm_protocal_c_bfd2.eeu = new LinkedList();
            } else {
                com_tencent_mm_protocal_c_bfd2 = com_tencent_mm_protocal_c_bfd;
            }
            b(com_tencent_mm_protocal_c_bfd2);
            this.kvm = 0;
            if (this.kqI.ksg == null) {
                this.kqI.ksg = "".getBytes();
            }
            a.cS("MicroMsg.Voip.VoipSyncHandle", "doSync fromjni:" + z + " cmdList:" + com_tencent_mm_protocal_c_bfd2.eet + ",syncKey.length=" + this.kqI.ksg.length);
            new m(this.kqI.ksc.gFG, com_tencent_mm_protocal_c_bfd2, this.kqI.ksg, this.kqI.ksc.gFH, i).bcW();
        }
        return 0;
    }

    public final void a(bgc com_tencent_mm_protocal_c_bgc) {
        a.cT("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged:  status:" + com_tencent_mm_protocal_c_bgc.eeO);
        if (com_tencent_mm_protocal_c_bgc.eeO == 1) {
            this.kqI.krB = true;
            h hVar = this.kqI.ksc.kxf;
            hVar.ktr = System.currentTimeMillis();
            a.cS("MicroMsg.VoipDailReport", "accept received timestamp:" + hVar.ktr);
            a.cT("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT");
            this.kqI.ksd.atM();
            d.bbw().kuO.bcR();
            this.kqI.krC = true;
            if (this.kqI.krE) {
                this.kqI.krE = false;
                if (this.kqI.krz) {
                    a.cT("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT, pre-connect already success");
                    this.kqI.bbH();
                } else if (this.kqI.krD) {
                    a.cT("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect already fail");
                    this.kqI.m(1, -9000, "");
                } else {
                    a.cT("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect still connecting...");
                }
            }
            com.tencent.mm.plugin.report.service.g.iuh.h(11519, new Object[]{Integer.valueOf(d.bbw().bcB()), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(2)});
            this.kqI.bbL();
            this.kqI.bbM();
        } else if (com_tencent_mm_protocal_c_bgc.eeO == 6) {
            a.cT("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACKED");
            a.cT("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: try use pre-connect");
            this.kqI.krE = true;
            this.kqI.ksc.kwi = 1;
            this.kqI.bbL();
        } else if (com_tencent_mm_protocal_c_bgc.eeO == 8) {
            a.cS("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACK BUSY");
            this.kqI.ksc.kxf.ksQ = 211;
            this.kqI.ksc.kxf.ksP = 11;
            this.kqI.ksc.kxf.ktb = 12;
            com.tencent.mm.plugin.report.service.g.iuh.h(11519, new Object[]{Integer.valueOf(d.bbw().bcB()), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(3)});
            this.kqI.m(1, 211, "");
            this.kqI.bbM();
        } else if (com_tencent_mm_protocal_c_bgc.eeO == 2) {
            a.cT("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_REJECT");
            this.kqI.ksc.kxf.ksP = 103;
            this.kqI.ksc.kxf.ktb = 4;
            this.kqI.ksc.kxf.kti = (int) (System.currentTimeMillis() - this.kqI.ksc.kxf.beginTime);
            com.tencent.mm.plugin.report.service.g.iuh.h(11519, new Object[]{Integer.valueOf(d.bbw().bcB()), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(1)});
            this.kqI.bbM();
            this.kqI.m(4, 0, "");
        } else if (com_tencent_mm_protocal_c_bgc.eeO == 3) {
            this.kqI.ksc.kxf.ktb = 5;
        } else if (com_tencent_mm_protocal_c_bgc.eeO == 4) {
            a.cT("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_SHUTDOWN");
            if (this.kqI.mStatus < 6) {
                this.kqI.ksc.kxf.ktc = 1;
            }
            this.kqI.ksc.kxf.ksP = 110;
            this.kqI.m(6, 0, "");
            this.kqI.bbM();
        } else {
            a.cT("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged: unknow status:" + com_tencent_mm_protocal_c_bgc.eeO);
        }
    }

    public final void a(bfs com_tencent_mm_protocal_c_bfs) {
        try {
            boolean z;
            bfo com_tencent_mm_protocal_c_bfo = (bfo) new bfo().az(com_tencent_mm_protocal_c_bfs.meT.mQw.toByteArray());
            if (!(com_tencent_mm_protocal_c_bfo.mZR == null || com_tencent_mm_protocal_c_bfo.mZR.meT == null || com_tencent_mm_protocal_c_bfo.mZR.meT.mQw == null)) {
                this.kvk.mZR = com_tencent_mm_protocal_c_bfo.mZR;
            }
            if (!(com_tencent_mm_protocal_c_bfo.mZS.meT == null || com_tencent_mm_protocal_c_bfo.mZS.meT.mQw == null)) {
                this.kvk.mZS = com_tencent_mm_protocal_c_bfo.mZS;
            }
            if (com_tencent_mm_protocal_c_bfo.naY != 0) {
                this.kvk.naY = com_tencent_mm_protocal_c_bfo.naY;
            }
            if (!(com_tencent_mm_protocal_c_bfo.naZ == null || com_tencent_mm_protocal_c_bfo.naZ.naa == 0)) {
                this.kvk.naZ = com_tencent_mm_protocal_c_bfo.naZ;
            }
            if (!(com_tencent_mm_protocal_c_bfo.nba == null || com_tencent_mm_protocal_c_bfo.nba.naa == 0)) {
                this.kvk.nba = com_tencent_mm_protocal_c_bfo.nba;
            }
            if (com_tencent_mm_protocal_c_bfo.nbc != 0) {
                this.kvk.nbc = com_tencent_mm_protocal_c_bfo.nbc;
            }
            if (com_tencent_mm_protocal_c_bfo.nbd != 0) {
                this.kvk.nbd = com_tencent_mm_protocal_c_bfo.nbd;
            }
            if (com_tencent_mm_protocal_c_bfo.nbh.naa != 0) {
                this.kvk.nbh = com_tencent_mm_protocal_c_bfo.nbh;
            }
            if (com_tencent_mm_protocal_c_bfo.nbi > 0) {
                this.kvk.nbi = com_tencent_mm_protocal_c_bfo.nbi;
            } else {
                this.kvk.nbi = 0;
                a.cS("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQstrategy in mrdata");
            }
            if (com_tencent_mm_protocal_c_bfo.gGd > 0) {
                this.kvk.gGd = com_tencent_mm_protocal_c_bfo.gGd - 1;
                a.cS("MicroMsg.Voip.VoipSyncHandle", "zhengxue[ENCRYPT] got encryptStrategy[" + this.kvk.gGd + "] from relaydata");
            } else {
                this.kvk.gGd = 1;
                a.cS("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no EncryptStrategy in mrdata");
            }
            if (com_tencent_mm_protocal_c_bfo.nbj > 0) {
                this.kvk.nbj = com_tencent_mm_protocal_c_bfo.nbj;
                this.kvk.nbk = com_tencent_mm_protocal_c_bfo.nbk;
                this.kvk.nbl = com_tencent_mm_protocal_c_bfo.nbl;
                this.kvk.nbm = com_tencent_mm_protocal_c_bfo.nbm;
                a.cS("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got ARQCacheLen: " + com_tencent_mm_protocal_c_bfo.nbj + ", ARQRttThreshold: " + com_tencent_mm_protocal_c_bfo.nbk + ", ARQUsedRateThreshold: " + com_tencent_mm_protocal_c_bfo.nbl + ", ARQRespRateThreshold: " + com_tencent_mm_protocal_c_bfo.nbm);
            } else {
                a.cS("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQKeyParameters in mrdata");
            }
            if (com_tencent_mm_protocal_c_bfo.nbq > 0) {
                this.kvk.nbq = com_tencent_mm_protocal_c_bfo.nbq;
            } else {
                this.kvk.nbq = 0;
                a.cS("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no QosStrategy in mrdata");
            }
            if (this.kvk.mZR == null || this.kvk.mZR.meT == null || this.kvk.mZR.meT.mQw == null || this.kvk.naY == 0 || this.kvk.mZS == null || this.kvk.mZS.meT == null || this.kvk.mZS.meT.mQw == null || this.kvk.naZ == null || this.kvk.naZ.naa == 0 || this.kvk.nba == null || this.kvk.nba.naa == 0 || this.kvk.nbh == null || this.kvk.nbh.naa == 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                a.cS("MicroMsg.Voip.VoipSyncHandle", "multiRelayData recv all, update");
                this.kqI.rE(this.kvk.naY);
                this.kqI.aH(this.kvk.mZR.meT.mQw.toByteArray());
                if (!(com_tencent_mm_protocal_c_bfo.nbf == null || com_tencent_mm_protocal_c_bfo.nbf.mQw == null || com_tencent_mm_protocal_c_bfo.nbr == null || com_tencent_mm_protocal_c_bfo.nbr.mQw == null)) {
                    this.kqI.a(com_tencent_mm_protocal_c_bfo.nbf.mQw.toByteArray(), com_tencent_mm_protocal_c_bfo.nbe, this.kvk.gGd, com_tencent_mm_protocal_c_bfo.nbr.mQw.toByteArray());
                }
                if (d.bbw().bcB() != 0) {
                    this.kqI.aI(this.kvk.mZS.meT.mQw.toByteArray());
                }
                this.kqI.a(this.kvk.naZ, this.kvk.nba, this.kvk.nbh);
                this.kqI.g(this.kvk.nbi, this.kvk.nbj, this.kvk.nbk, this.kvk.nbl, this.kvk.nbm);
                this.kqI.rD(this.kvk.nbq);
                e eVar = this.kqI;
                int i = this.kvk.nbc;
                int i2 = this.kvk.nbd;
                eVar.ksc.kvO = i;
                eVar.ksc.kvP = i2;
                if (!(com_tencent_mm_protocal_c_bfo.nbo == null || com_tencent_mm_protocal_c_bfo.nbo.mQw == null || com_tencent_mm_protocal_c_bfo.nbp == null || com_tencent_mm_protocal_c_bfo.nbp.mQw == null)) {
                    this.kqI.d(com_tencent_mm_protocal_c_bfo.nbn, com_tencent_mm_protocal_c_bfo.nbo.mQw.toByteArray(), com_tencent_mm_protocal_c_bfo.nbp.mQw.toByteArray());
                }
                this.kqI.krE = true;
                this.kqI.bbL();
            }
        } catch (Throwable e) {
            v.a("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
        }
    }

    public final void b(bfs com_tencent_mm_protocal_c_bfs) {
        e eVar = this.kqI;
        eVar.ksc.kvL = com_tencent_mm_protocal_c_bfs.meT.mQw.toByteArray();
        if (eVar.kry && !be.bl(eVar.ksc.kvL)) {
            int handleCommand = eVar.ksc.handleCommand(eVar.ksc.kvL, eVar.ksc.kvL.length);
            if (handleCommand < 0) {
                a.cR("MicroMsg.Voip.VoipContext", "v2protocal handlecommand failed ret:" + handleCommand);
            }
            eVar.ksc.kvL = null;
        }
    }

    public final void c(are com_tencent_mm_protocal_c_are) {
        int aM = a.aM(com_tencent_mm_protocal_c_are.mQw.toByteArray());
        a.cT("MicroMsg.Voip.VoipSyncHandle", "voipSync remote status changed, status = " + aM);
        e eVar = this.kqI;
        aM &= 255;
        if (8 == aM || 9 == aM) {
            eVar.krU = aM;
        } else {
            eVar.krS = aM;
            eVar.krQ = aM;
        }
        if (1 == aM || 3 == aM) {
            eVar.rC(2);
        }
        eVar.ksd.rK(aM);
    }

    public final void m(k kVar) {
        this.kqI.ksi = false;
        bge com_tencent_mm_protocal_c_bge = (bge) ((m) kVar).bcX();
        this.kqI.ksc.parseSyncKeyBuff(this.kqI.ksg, this.kqI.ksg.length);
        int i = this.kqI.ksc.field_statusSyncKey;
        int i2 = this.kqI.ksc.field_relayDataSyncKey;
        int i3 = this.kqI.ksc.field_connectingStatusKey;
        this.kqI.ksc.parseSyncKeyBuff(com_tencent_mm_protocal_c_bge.mkF.mQw.toByteArray(), com_tencent_mm_protocal_c_bge.mkF.mQu);
        int i4 = this.kqI.ksc.field_statusSyncKey;
        int i5 = this.kqI.ksc.field_relayDataSyncKey;
        int i6 = this.kqI.ksc.field_connectingStatusKey;
        v.d("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: oldStatusSyncKey:" + i + " oldRelayDataSyncKey:" + i2 + " oldConnectingStatusSyncKey:" + i3);
        v.d("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: newStatusSyncKey:" + i4 + " newRelayDataSyncKey:" + i5 + " newConnectingStatusSyncKey:" + i6);
        this.kqI.ksg = com_tencent_mm_protocal_c_bge.mkF.mQw.toByteArray();
        v.d("MicroMsg.Voip.VoipSyncHandle", "voipSync response: continueflag=" + com_tencent_mm_protocal_c_bge.miR);
        LinkedList linkedList = com_tencent_mm_protocal_c_bge.nbL.eeu;
        if (!(linkedList == null || linkedList.size() == 0)) {
            v.d("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size" + linkedList.size());
            v.d("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size:" + linkedList.size() + ",selector = " + ((m) kVar).bcV());
            for (int i7 = 0; i7 < linkedList.size(); i7++) {
                bfc com_tencent_mm_protocal_c_bfc = (bfc) linkedList.get(i7);
                int i8 = com_tencent_mm_protocal_c_bfc.bkM;
                if (i8 == 1) {
                    if (i4 > i) {
                        if (this.kqI.ksc.gFG == 0) {
                            a.cR("MicroMsg.Voip.VoipSyncHandle", "voipSyncStatus ignored , roomid = 0");
                        } else {
                            try {
                                bgc com_tencent_mm_protocal_c_bgc = (bgc) new bgc().az(com_tencent_mm_protocal_c_bfc.mnB.mQw.toByteArray());
                                a.cT("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus in...from user=" + com_tencent_mm_protocal_c_bfc.gon + ",itemStatus =  " + com_tencent_mm_protocal_c_bgc.eeO);
                                a(com_tencent_mm_protocal_c_bgc);
                            } catch (Throwable e) {
                                v.a("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
                            }
                        }
                    }
                } else if (i8 == 2) {
                    if (i5 > i2) {
                        if (this.kqI.ksc.gFG == 0) {
                            a.cR("MicroMsg.Voip.VoipSyncHandle", "RelayData ignored , roomid = 0");
                        } else {
                            try {
                                bfs com_tencent_mm_protocal_c_bfs = (bfs) new bfs().az(com_tencent_mm_protocal_c_bfc.mnB.mQw.toByteArray());
                                a.cT("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncRelayData ...relayType = " + com_tencent_mm_protocal_c_bfs.efm + ",from user = " + com_tencent_mm_protocal_c_bfc.gon);
                                if (com_tencent_mm_protocal_c_bfs.efm == 5) {
                                    a(com_tencent_mm_protocal_c_bfs);
                                } else if (com_tencent_mm_protocal_c_bfs.efm == 3) {
                                    this.kqI.aI(com_tencent_mm_protocal_c_bfs.meT.mQw.toByteArray());
                                    if (!(com_tencent_mm_protocal_c_bfs.meT == null || com_tencent_mm_protocal_c_bfs.meT.mQw == null)) {
                                        this.kvk.mZS = com_tencent_mm_protocal_c_bfs;
                                    }
                                } else if (com_tencent_mm_protocal_c_bfs.efm == 2) {
                                    this.kqI.aH(com_tencent_mm_protocal_c_bfs.meT.mQw.toByteArray());
                                    if (!(com_tencent_mm_protocal_c_bfs.meT == null || com_tencent_mm_protocal_c_bfs.meT.mQw == null)) {
                                        this.kvk.mZR = com_tencent_mm_protocal_c_bfs;
                                    }
                                } else if (com_tencent_mm_protocal_c_bfs.efm == 1) {
                                    b(com_tencent_mm_protocal_c_bfs);
                                }
                            } catch (Throwable e2) {
                                v.a("MicroMsg.Voip.VoipSyncHandle", e2, "", new Object[0]);
                            }
                        }
                    }
                } else if (i8 == 3 && i6 > i3) {
                    if (this.kqI.ksc.gFG == 0) {
                        v.e("MicroMsg.Voip.VoipSyncHandle", "voipSync(ClientStatus) ignored , roomid = 0");
                    } else {
                        try {
                            are bb = new are().bb(com_tencent_mm_protocal_c_bfc.mnB.mQw.toByteArray());
                            if (com_tencent_mm_protocal_c_bfc.gon.equals(com.tencent.mm.model.k.xF())) {
                                a.cR("MicroMsg.Voip.VoipSyncHandle", "svr response: local connecting status changed.");
                            } else {
                                c(bb);
                            }
                        } catch (Throwable e22) {
                            v.a("MicroMsg.Voip.VoipSyncHandle", e22, "", new Object[0]);
                        }
                    }
                }
            }
        }
        if ((this.kvl != null && this.kvl.eet > 0) || this.kvm > 0) {
            a(null, false, 7);
        }
    }
}
