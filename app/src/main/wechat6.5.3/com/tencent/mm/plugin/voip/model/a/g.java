package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.model.k;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bfm;
import com.tencent.mm.protocal.c.bfn;
import com.tencent.mm.protocal.c.bfs;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.LinkedList;
import java.util.List;

public final class g extends n<bfm, bfn> {
    public g(List<String> list, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        a aVar = new a();
        aVar.czn = new bfm();
        aVar.czo = new bfn();
        aVar.uri = "/cgi-bin/micromsg-bin/voipinvite";
        aVar.czm = 170;
        aVar.czp = 63;
        aVar.czq = 1000000063;
        this.cif = aVar.Bv();
        bfm com_tencent_mm_protocal_c_bfm = (bfm) this.cif.czk.czs;
        LinkedList linkedList = new LinkedList();
        for (int i5 = 0; i5 < list.size(); i5++) {
            linkedList.add(new arf().JF((String) list.get(i5)));
        }
        com_tencent_mm_protocal_c_bfm.mOk = k.xF();
        com_tencent_mm_protocal_c_bfm.naV = linkedList;
        com_tencent_mm_protocal_c_bfm.naU = linkedList.size();
        com_tencent_mm_protocal_c_bfm.mnk = i;
        com_tencent_mm_protocal_c_bfm.mUW = 0;
        com_tencent_mm_protocal_c_bfm.naJ = i3;
        com_tencent_mm_protocal_c_bfm.mNO = i4;
        bfs com_tencent_mm_protocal_c_bfs = new bfs();
        com_tencent_mm_protocal_c_bfs.efm = 2;
        are com_tencent_mm_protocal_c_are = new are();
        com_tencent_mm_protocal_c_are.ba(bArr);
        com_tencent_mm_protocal_c_bfs.meT = com_tencent_mm_protocal_c_are;
        com_tencent_mm_protocal_c_bfm.mZR = com_tencent_mm_protocal_c_bfs;
        com_tencent_mm_protocal_c_bfs = new bfs();
        com_tencent_mm_protocal_c_bfs.efm = 3;
        com_tencent_mm_protocal_c_are = new are();
        com_tencent_mm_protocal_c_are.ba(bArr2);
        com_tencent_mm_protocal_c_bfs.meT = com_tencent_mm_protocal_c_are;
        com_tencent_mm_protocal_c_bfm.mZS = com_tencent_mm_protocal_c_bfs;
        com_tencent_mm_protocal_c_bfm.mZV = System.currentTimeMillis();
    }

    public final int getType() {
        return 170;
    }

    public final e bcT() {
        return new e(this) {
            final /* synthetic */ g kvu;

            {
                this.kvu = r1;
            }

            public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.NetSceneVoipInvite", "Invite response:" + i + " errCode:" + i2 + " status:" + this.kvu.ksv.mStatus);
                if (this.kvu.ksv.mStatus != 2) {
                    com.tencent.mm.plugin.voip.b.a.cR("MicroMsg.NetSceneVoipInvite", " invite response with error status:" + this.kvu.ksv.mStatus + " should:2");
                    return;
                }
                bfn com_tencent_mm_protocal_c_bfn = (bfn) this.kvu.bcX();
                this.kvu.ksv.ksc.kwk = com_tencent_mm_protocal_c_bfn.nag;
                this.kvu.ksv.ksc.kwl = com_tencent_mm_protocal_c_bfn.nah;
                this.kvu.ksv.ksc.kwm = com_tencent_mm_protocal_c_bfn.nai;
                this.kvu.ksv.ksc.kwn = com_tencent_mm_protocal_c_bfn.naj;
                this.kvu.ksv.ksc.kwp = com_tencent_mm_protocal_c_bfn.nal;
                this.kvu.ksv.ksc.kwo = com_tencent_mm_protocal_c_bfn.naq;
                this.kvu.ksv.rF(com_tencent_mm_protocal_c_bfn.mZY);
                com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.NetSceneVoipInvite", "setSvrConfig onInviteResp: audioTsdfBeyond3G = " + this.kvu.ksv.ksc.kwk + ",audioTsdEdge = " + this.kvu.ksv.ksc.kwl + ",passthroughQosAlgorithm = " + this.kvu.ksv.ksc.kwm + ",fastPlayRepair = " + this.kvu.ksv.ksc.kwn + ", audioDtx = " + this.kvu.ksv.ksc.kwp + ",switchtcpPktCnt = " + this.kvu.ksv.ksc.kvQ + ",SvrCfgListV = " + this.kvu.ksv.ksc.kwo);
                this.kvu.ksv.ksc.kwq = com_tencent_mm_protocal_c_bfn.nap;
                com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.NetSceneVoipInvite", "inviteResp AudioAecMode5 = " + this.kvu.ksv.ksc.kwq);
                int netType = com.tencent.mm.plugin.voip.b.a.getNetType(aa.getContext());
                if (i == 0) {
                    this.kvu.ksv.dh(4);
                    this.kvu.ksv.ksc.gFG = com_tencent_mm_protocal_c_bfn.mqS;
                    this.kvu.ksv.ksc.gFH = com_tencent_mm_protocal_c_bfn.mqT;
                    this.kvu.ksv.ksc.gFO = com_tencent_mm_protocal_c_bfn.mNZ;
                    com.tencent.mm.plugin.report.service.g.iuh.a(11518, true, true, new Object[]{Integer.valueOf(d.bbw().bcB()), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(1), Integer.valueOf(netType)});
                    if (com_tencent_mm_protocal_c_bfn.naX > 0) {
                        long j = (long) (com_tencent_mm_protocal_c_bfn.naX * BaseReportManager.MAX_READ_COUNT);
                        this.kvu.ksv.kso.ea(j);
                    }
                    com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.NetSceneVoipInvite", "invite ok, roomid =" + this.kvu.ksv.ksc.gFG + ",memberid = " + this.kvu.ksv.ksc.gFO + "VoipSyncInterval = " + com_tencent_mm_protocal_c_bfn.naX);
                    this.kvu.ksv.ksd.bcf();
                } else if (i == 4) {
                    com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.NetSceneVoipInvite", "RoomId in InviteResp: " + com_tencent_mm_protocal_c_bfn.mqS + "," + com_tencent_mm_protocal_c_bfn.mqT);
                    switch (i2) {
                        case 211:
                            this.kvu.ksv.ksc.kxf.ksP = 12;
                            this.kvu.ksv.ksc.kxf.ktb = 12;
                            com.tencent.mm.plugin.report.service.g.iuh.a(11518, true, true, new Object[]{Integer.valueOf(d.bbw().bcB()), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(8), Integer.valueOf(netType)});
                            break;
                        case 233:
                            this.kvu.ksv.ksc.kxf.ksP = 12;
                            this.kvu.ksv.ksc.kxf.ktb = 1;
                            com.tencent.mm.plugin.report.service.g.iuh.a(11518, true, true, new Object[]{Integer.valueOf(d.bbw().bcB()), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(3), Integer.valueOf(netType)});
                            break;
                        case 234:
                            this.kvu.ksv.ksc.kxf.ksP = 13;
                            this.kvu.ksv.ksc.kxf.ktb = 11;
                            com.tencent.mm.plugin.report.service.g.iuh.a(11518, true, true, new Object[]{Integer.valueOf(d.bbw().bcB()), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(4), Integer.valueOf(netType)});
                            break;
                        case 235:
                            this.kvu.ksv.ksc.kxf.ksP = 13;
                            this.kvu.ksv.ksc.kxf.ktb = 2;
                            com.tencent.mm.plugin.report.service.g.iuh.a(11518, true, true, new Object[]{Integer.valueOf(d.bbw().bcB()), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(2), Integer.valueOf(netType)});
                            break;
                        case 236:
                            this.kvu.ksv.ksc.kxf.ksP = 12;
                            this.kvu.ksv.ksc.kxf.ktb = 10;
                            com.tencent.mm.plugin.report.service.g.iuh.a(11518, true, true, new Object[]{Integer.valueOf(d.bbw().bcB()), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(7), Integer.valueOf(netType)});
                            break;
                        case 237:
                            this.kvu.ksv.ksc.kxf.ksP = 13;
                            this.kvu.ksv.ksc.kxf.ktb = 9;
                            com.tencent.mm.plugin.report.service.g.iuh.a(11518, true, true, new Object[]{Integer.valueOf(d.bbw().bcB()), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(2), Integer.valueOf(netType)});
                            break;
                        case 238:
                            this.kvu.ksv.krC = true;
                            this.kvu.ksv.krE = false;
                            this.kvu.ksv.krD = false;
                            this.kvu.ksv.ksc.kwj = 0;
                            this.kvu.ksv.ksc.kwi = 0;
                            this.kvu.ksv.dh(3);
                            this.kvu.ksv.ksc.gFG = com_tencent_mm_protocal_c_bfn.mqS;
                            this.kvu.ksv.ksc.gFH = com_tencent_mm_protocal_c_bfn.mqT;
                            this.kvu.ksv.ksc.gFO = com_tencent_mm_protocal_c_bfn.mNZ;
                            this.kvu.ksv.ksd.rL(((bfm) ((g) kVar).bcY()).mUW);
                            return;
                        default:
                            this.kvu.ksv.ksc.kxf.ksP = 12;
                            this.kvu.ksv.ksc.kxf.ktb = 99;
                            com.tencent.mm.plugin.report.service.g.iuh.a(11518, true, true, new Object[]{Integer.valueOf(d.bbw().bcB()), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(5), Integer.valueOf(netType)});
                            break;
                    }
                    this.kvu.ksv.ksc.kxf.ksQ = i2;
                    this.kvu.ksv.m(1, i2, str);
                } else {
                    this.kvu.ksv.ksc.kxf.ksP = 12;
                    this.kvu.ksv.ksc.kxf.ksQ = i2;
                    this.kvu.ksv.ksc.kxf.ktb = 99;
                    com.tencent.mm.plugin.report.service.g.iuh.a(11518, true, true, new Object[]{Integer.valueOf(d.bbw().bcB()), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(9), Integer.valueOf(netType)});
                    this.kvu.ksv.m(1, -9004, "");
                }
            }
        };
    }
}
