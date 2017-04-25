package com.tencent.mm.plugin.voip_cs.b;

import android.os.Looper;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.brandservice.a.j;
import com.tencent.mm.plugin.voip_cs.b.c.b;
import com.tencent.mm.plugin.voip_cs.b.c.c;
import com.tencent.mm.plugin.voip_cs.b.c.f;
import com.tencent.mm.protocal.c.asf;
import com.tencent.mm.protocal.c.beg;
import com.tencent.mm.protocal.c.beh;
import com.tencent.mm.protocal.c.bel;
import com.tencent.mm.protocal.c.ben;
import com.tencent.mm.protocal.c.ber;
import com.tencent.mm.protocal.c.beu;
import com.tencent.mm.protocal.c.bex;
import com.tencent.mm.protocal.c.bez;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.Arrays;
import java.util.List;

public final class d implements e {
    public int gFR = 0;
    public a kDX;
    public int kDY = 0;
    public int kDZ = 0;
    public int kDu = 0;
    public int kEa = 0;
    public byte[] kEb = null;
    public int kEc = 0;
    public int kEd = 0;
    public int kEe = 0;
    public String kEf = "";
    public int kEg = 0;
    public ah kEh = new ah(Looper.getMainLooper(), new a(this) {
        final /* synthetic */ d kEj;

        {
            this.kEj = r1;
        }

        public final boolean oU() {
            v.v("MicroMsg.voipcs.VoipCSService", "voipcs repeat sync");
            this.kEj.beh();
            return true;
        }
    }, true);
    public ah kEi = new ah(Looper.getMainLooper(), new a(this) {
        final /* synthetic */ d kEj;

        {
            this.kEj = r1;
        }

        public final boolean oU() {
            v.v("MicroMsg.voipcs.VoipCSService", "voipcs heart beat");
            ak.vy().a(795, this.kEj);
            ak.vy().a(new b(b.beb().gGO.kvI, b.beb().gGO.gFH), 0);
            return true;
        }
    }, true);
    public int ksm = 0;

    public final void beh() {
        ak.vy().a(818, this);
        ak.vy().a(new f(b.beb().gGO.kvI, b.beb().gGO.gFH, this.kDY), 0);
    }

    private static void b(int i, int i2, k kVar) {
        v.i("MicroMsg.voipcs.VoipCSService", "Redirect response:" + i + " errCode:" + i2);
        if (i2 != 0) {
            v.i("MicroMsg.voipcs.VoipCSService", " redirect response with error code:" + i2);
            return;
        }
        beu com_tencent_mm_protocal_c_beu = (beu) ((com.tencent.mm.plugin.voip_cs.b.c.d) kVar).cif.czl.czs;
        v.i("MicroMsg.voipcs.VoipCSService", "roomid " + com_tencent_mm_protocal_c_beu.nat + " key " + com_tencent_mm_protocal_c_beu.mqT + "relay addr cnt " + com_tencent_mm_protocal_c_beu.meE.size());
        List<bel> list = com_tencent_mm_protocal_c_beu.meE;
        beh com_tencent_mm_protocal_c_beh = new beh();
        for (bel com_tencent_mm_protocal_c_bel : list) {
            beg com_tencent_mm_protocal_c_beg = new beg();
            b.beb();
            com_tencent_mm_protocal_c_beg.mWf = com.tencent.mm.plugin.voip_cs.b.b.a.CU(com_tencent_mm_protocal_c_bel.mGp);
            com_tencent_mm_protocal_c_beg.mNM = com_tencent_mm_protocal_c_bel.mNM;
            com_tencent_mm_protocal_c_beh.nab.add(com_tencent_mm_protocal_c_beg);
        }
        com_tencent_mm_protocal_c_beh.naa = list.size();
        b.beb().gGO.b(com_tencent_mm_protocal_c_beh, com_tencent_mm_protocal_c_beh, null);
    }

    public final void a(bez com_tencent_mm_protocal_c_bez) {
        if (com_tencent_mm_protocal_c_bez.naB > this.kDY && b.bec().kEe != 3) {
            v.i("MicroMsg.voipcs.VoipCSService", "get callee sync resp,notifySeq:" + com_tencent_mm_protocal_c_bez.naB + ",calleeMemberId:" + com_tencent_mm_protocal_c_bez.naC + ",calleeStatus:" + com_tencent_mm_protocal_c_bez.naD + ",calleeSubStatus:" + com_tencent_mm_protocal_c_bez.naE + ",recv roomId:" + com_tencent_mm_protocal_c_bez.nat + ",recv roomKey:" + com_tencent_mm_protocal_c_bez.mqT);
            if (b.beb().gGO.kvI == 0 || b.beb().gGO.kvI == com_tencent_mm_protocal_c_bez.nat) {
                this.kDY = com_tencent_mm_protocal_c_bez.naB;
                this.kDu = com_tencent_mm_protocal_c_bez.naC;
                this.kDZ = com_tencent_mm_protocal_c_bez.naD;
                this.kEa = com_tencent_mm_protocal_c_bez.naE;
                b.bed().kDu = this.kDu;
                if (this.kDZ == 2) {
                    v.i("MicroMsg.voipcs.VoipCSService", "callee accept!");
                    this.kEh.QI();
                    beh();
                    b.beb().gGO.gFH = com_tencent_mm_protocal_c_bez.mqT;
                    v.i("MicroMsg.voipcs.VoipCSService", "csroomId:" + com_tencent_mm_protocal_c_bez.nat + ",roomkey:" + com_tencent_mm_protocal_c_bez.mqT);
                    this.kEb = com_tencent_mm_protocal_c_bez.naF != null ? com_tencent_mm_protocal_c_bez.naF.toByteArray() : null;
                    if (b.beb().gGO.field_capInfo != null && this.kEb != null) {
                        int i;
                        c bed = b.bed();
                        v.d("MicroMsg.VoipCSReportHelper", "markUserAccept");
                        if (bed.kDH == 0) {
                            bed.kDT = (int) (System.currentTimeMillis() / 1000);
                            bed.kDH = (long) (bed.kDT - bed.kDR);
                        }
                        b.beb().gGO.kvK = this.kEb;
                        v.i("MicroMsg.voipcs.VoipCSService", "calleeCapDump is " + Arrays.toString(b.beb().gGO.kvK));
                        v.i("MicroMsg.voipcs.VoipCSService", "calleeCap length:" + this.kEb.length);
                        if (b.beb().gGO.kvK != null && b.beb().gGO.exchangeCabInfo(b.beb().gGO.kvK, b.beb().gGO.kvK.length) < 0) {
                            v.i("MicroMsg.voipcs.VoipCSService", "exchangeCabInfo fail!");
                        }
                        if (b.beb().gGO.kvN == null) {
                            i = 0;
                        } else {
                            i = b.beb().gGO.kvN.length;
                        }
                        if (b.beb().gGO.setConfigConnect(b.beb().gGO.kvH, b.beb().gGO.kvI, b.beb().gGO.gFO, b.beb().gGO.gFH, b.beb().gGO.field_peerId, 1, b.beb().gGO.kvO, b.beb().gGO.kvP, b.beb().gGO.kvM, i, b.beb().gGO.kvN, b.beb().gGO.kvQ, 1, b.beb().gGO.netType, b.beb().gGO.kwB, b.beb().gGO.kwC) != 0) {
                            v.e("MicroMsg.voipcs.VoipCSService", "setConfig fail..");
                        }
                        if (this.kEi.btC()) {
                            this.kEi.ea(50000);
                        }
                        b.bed().kDA = 1;
                        return;
                    }
                    return;
                } else if (this.kDZ != 0 && this.kDZ != 1 && this.kDZ == 3) {
                    v.i("MicroMsg.voipcs.VoipCSService", "callee hangup!");
                    b.bed().aKG = 5;
                    b.bed().bee();
                    b.bed().kDE = 2;
                    if (this.kEa == 1) {
                        b.bed().kDw = 12;
                    } else if (this.kEa == 3) {
                        b.bed().kDw = 99;
                    }
                    if (this.kDX != null) {
                        this.kDX.sd(1);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            v.i("MicroMsg.voipcs.VoipCSService", "csRoomId:" + b.beb().gGO.kvI + ",recv roomId:" + com_tencent_mm_protocal_c_bez.nat + ",current and recv not equal!!");
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            v.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd  resp error!:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i != 0 && i != 4) {
                this.kEg = -1;
                this.kDX.onError(10);
            } else if (kVar.getType() == 823) {
                if (i2 == 406) {
                    v.i("MicroMsg.voipcs.VoipCSService", "CS_INVITE_RESP_REPEAT_INVTIE 503..");
                    return;
                }
                b.bed().aKG = 1;
                this.kEg = 823;
                this.kDX.onError(i2);
            } else if (kVar.getType() != 880 && kVar.getType() != 818 && kVar.getType() == 455) {
                this.kDX.cV("", "");
            }
        } else if (kVar.getType() == 823) {
            ber com_tencent_mm_protocal_c_ber = (ber) ((c) kVar).cif.czl.czs;
            long j = com_tencent_mm_protocal_c_ber.nat;
            long j2 = com_tencent_mm_protocal_c_ber.mqT;
            List<bel> list = com_tencent_mm_protocal_c_ber.meE;
            this.gFR = com_tencent_mm_protocal_c_ber.nay;
            b.beb().gGO.kvP = com_tencent_mm_protocal_c_ber.gFY;
            this.kEc = com_tencent_mm_protocal_c_ber.gFS;
            b.beb().gGO.kwB = com_tencent_mm_protocal_c_ber.gGd;
            b.beb().gGO.kwC = com_tencent_mm_protocal_c_ber.mOd.toByteArray();
            b.beb().gGO.kvO = com_tencent_mm_protocal_c_ber.gFZ;
            beh com_tencent_mm_protocal_c_beh = new beh();
            for (bel com_tencent_mm_protocal_c_bel : list) {
                beg com_tencent_mm_protocal_c_beg = new beg();
                b.beb();
                com_tencent_mm_protocal_c_beg.mWf = com.tencent.mm.plugin.voip_cs.b.b.a.CU(com_tencent_mm_protocal_c_bel.mGp);
                com_tencent_mm_protocal_c_beg.mNM = com_tencent_mm_protocal_c_bel.mNM;
                com_tencent_mm_protocal_c_beh.nab.add(com_tencent_mm_protocal_c_beg);
            }
            com_tencent_mm_protocal_c_beh.naa = list.size();
            b.beb().gGO.kvI = j;
            b.beb().gGO.gFH = j2;
            b.beb().gGO.kwJ = com_tencent_mm_protocal_c_ber.naz;
            b.beb().gGO.kwK = com_tencent_mm_protocal_c_ber.naA;
            if (b.beb().gGO.c(com_tencent_mm_protocal_c_beh, com_tencent_mm_protocal_c_beh, com_tencent_mm_protocal_c_beh) != 0) {
                v.i("MicroMsg.voipcs.VoipCSService", "setIp fail!");
            }
            c bed = b.bed();
            r1 = this.kEf;
            v.d("MicroMsg.VoipCSReportHelper", "setVoipCSBaseInfo");
            bed.kDs = j;
            bed.gFH = j2;
            bed.kDt = r1;
            if (this.kEh.btC()) {
                if (this.gFR > 0) {
                    this.kEh.ea((long) (this.gFR * BaseReportManager.MAX_READ_COUNT));
                } else {
                    this.kEh.ea(4000);
                }
            }
            bed = b.bed();
            v.d("MicroMsg.VoipCSReportHelper", "markRecvInvite");
            if (bed.kDR != 0) {
                bed.kDS = (int) (System.currentTimeMillis() / 1000);
            }
        } else if (kVar.getType() == 818) {
            bez com_tencent_mm_protocal_c_bez = (bez) ((f) kVar).cif.czl.czs;
            v.i("MicroMsg.voipcs.VoipCSService", "sync status = " + com_tencent_mm_protocal_c_bez.naD + ",notifySeq = " + com_tencent_mm_protocal_c_bez.naB);
            a(com_tencent_mm_protocal_c_bez);
        } else if (kVar.getType() == 880) {
            ben com_tencent_mm_protocal_c_ben = (ben) ((com.tencent.mm.plugin.voip_cs.b.c.a) kVar).cif.czl.czs;
            if (b.beb().gGO.kvI == com_tencent_mm_protocal_c_ben.nat && b.beb().gGO.gFH == com_tencent_mm_protocal_c_ben.mqT) {
                v.i("MicroMsg.voipcs.VoipCSService", "hangup success!");
            }
            ak.vy().b(880, this);
            b.bed().se(com.tencent.mm.plugin.voip_cs.b.a.a.bej().kve.bdR());
        } else if (kVar.getType() == 455) {
            j jVar = (j) kVar;
            r1 = "";
            String str2 = "";
            if (jVar.exy == null || jVar.exy.size() <= 0) {
                v.i("MicroMsg.voipcs.VoipCSService", "search Or Recommend items is null or empty !");
            } else {
                asf com_tencent_mm_protocal_c_asf = (asf) jVar.exy.get(0);
                r1 = com_tencent_mm_protocal_c_asf.mlY;
                str2 = com_tencent_mm_protocal_c_asf.mEj.mQy;
            }
            this.kDX.cV(r1, str2);
        } else if (kVar.getType() == 285) {
            b(i, i2, kVar);
        } else if (kVar.getType() == 312) {
            bex com_tencent_mm_protocal_c_bex = (bex) ((com.tencent.mm.plugin.voip_cs.b.c.e) kVar).cif.czl.czs;
            if (com_tencent_mm_protocal_c_bex.nat == b.beb().gGO.kvI && com_tencent_mm_protocal_c_bex.mqT == b.beb().gGO.gFH) {
                v.i("MicroMsg.voipcs.VoipCSService", "report data success!");
            }
        }
    }
}
