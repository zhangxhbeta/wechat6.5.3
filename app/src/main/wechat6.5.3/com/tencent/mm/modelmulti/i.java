package com.tencent.mm.modelmulti;

import com.tencent.mm.e.a.ms;
import com.tencent.mm.e.a.mu;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.plugin.f.a.a.f;
import com.tencent.mm.plugin.f.a.a.h;
import com.tencent.mm.protocal.c.aih;
import com.tencent.mm.protocal.c.aii;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.asw;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class i extends k implements j {
    private static final List<ad> cRt = new ArrayList();
    public long bao;
    private final List<at> cRu = new LinkedList();
    private int cRv = 3;
    private boolean cRw = false;
    private final List<at> cRx = new ArrayList();
    private at cRy = null;
    public f cRz = null;
    private b cif;
    private e cii;

    static /* synthetic */ void a(i iVar, List list) {
        for (int i = 0; i < list.size(); i++) {
            n((at) list.get(i));
        }
    }

    static /* synthetic */ void b(i iVar, List list) {
        for (int i = 0; i < list.size(); i++) {
            m((at) list.get(i));
        }
    }

    public i(String str, String str2, int i) {
        boolean z = false;
        v.d("MicroMsg.NetSceneSendMsg", "dktext :%s", be.bur());
        if (!be.kS(str)) {
            bx atVar = new at();
            atVar.dh(1);
            atVar.cH(str);
            atVar.z(aw.fN(str));
            atVar.di(1);
            atVar.setContent(str2);
            atVar.setType(i);
            String o = ((h) g.f(h.class)).o(atVar);
            if (!be.kS(o)) {
                atVar.cN(o);
                v.d("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", atVar.bNo);
            }
            this.bao = ((d) g.f(d.class)).azI().R(atVar);
            if (this.bao == -1) {
                com.tencent.mm.plugin.report.b.itm.a(111, 255, 1, false);
            }
            if (this.bao != -1) {
                z = true;
            }
            Assert.assertTrue(z);
            v.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.bao);
        }
    }

    public i(long j) {
        v.i("MicroMsg.NetSceneSendMsg", "resend msg , local id = " + j);
        this.bao = j;
        this.cRy = ((d) g.f(d.class)).azI().ek(j);
        if (this.cRy == null) {
            v.e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", Long.valueOf(j));
        }
    }

    public i() {
        v.d("MicroMsg.NetSceneSendMsg", "dktext :%s", be.bur());
        v.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    }

    public final boolean Bz() {
        return true;
    }

    protected final int ul() {
        return 10;
    }

    public final boolean BA() {
        boolean BA = super.BA();
        if (BA) {
            com.tencent.mm.plugin.report.b.itm.a(111, 254, 1, false);
        }
        return BA;
    }

    protected final int a(p pVar) {
        return this.cRu.size() > 0 ? b.czU : b.czV;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        List bwX;
        this.cii = eVar2;
        a aVar = new a();
        aVar.czn = new asv();
        aVar.czo = new asw();
        aVar.uri = "/cgi-bin/micromsg-bin/newsendmsg";
        aVar.czm = 522;
        aVar.czp = 237;
        aVar.czq = 1000000237;
        this.cif = aVar.Bv();
        asv com_tencent_mm_protocal_c_asv = (asv) this.cif.czk.czs;
        if (this.cRy == null) {
            bwX = ((d) g.f(d.class)).azI().bwX();
        } else {
            if (this.cRy.field_status != 5) {
                v.w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", Long.valueOf(this.cRy.field_msgId), Integer.valueOf(this.cRy.field_status));
            }
            this.cRy.dh(1);
            ((d) g.f(d.class)).azI().a(this.bao, this.cRy);
            List arrayList = new ArrayList();
            arrayList.add(this.cRy);
            this.cRy = null;
            bwX = arrayList;
        }
        if (bwX.size() == 0) {
            v.w("MicroMsg.NetSceneSendMsg", "no sending message");
            return -2;
        }
        this.cRu.clear();
        for (int i = 0; i < bwX.size(); i++) {
            at atVar = (at) bwX.get(i);
            if (atVar.field_isSend == 1) {
                aih com_tencent_mm_protocal_c_aih = new aih();
                com_tencent_mm_protocal_c_aih.mbV = new arf().JF(atVar.field_talker);
                com_tencent_mm_protocal_c_aih.hNS = (int) (atVar.field_createTime / 1000);
                com_tencent_mm_protocal_c_aih.efm = atVar.field_type;
                com_tencent_mm_protocal_c_aih.hQP = atVar.field_content;
                com_tencent_mm_protocal_c_aih.mIR = com.tencent.mm.model.j.f(com.tencent.mm.model.k.xF(), atVar.field_createTime).hashCode();
                if (this.cRz == null) {
                    this.cRz = ((h) g.f(h.class)).Hn();
                }
                v.i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", this.cRz);
                this.cRz.a(com_tencent_mm_protocal_c_aih, atVar);
                v.i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", com_tencent_mm_protocal_c_aih.mbZ);
                com_tencent_mm_protocal_c_asv.eeu.add(com_tencent_mm_protocal_c_aih);
                com_tencent_mm_protocal_c_asv.eet = com_tencent_mm_protocal_c_asv.eeu.size();
                this.cRu.add(atVar);
            }
        }
        int a = a(eVar, this.cif, this);
        if (a >= 0) {
            return a;
        }
        v.i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", Integer.valueOf(a));
        Hj();
        return a;
    }

    public final int getType() {
        return 522;
    }

    private void fN(int i) {
        if (this.cRu == null) {
            v.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
        } else if (i >= this.cRu.size() || i < 0) {
            v.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", Integer.valueOf(i), Integer.valueOf(this.cRu.size()));
        } else {
            m((at) this.cRu.get(i));
        }
    }

    private static void m(at atVar) {
        com.tencent.mm.sdk.c.b msVar = new ms();
        msVar.boc.aXd = atVar;
        com.tencent.mm.sdk.c.a.nhr.z(msVar);
        v.d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", Long.valueOf(atVar.field_msgId));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            List list = ((asw) this.cif.czl.czs).eeu;
            ArrayList arrayList = new ArrayList();
            if (this.cRu.size() == list.size()) {
                int i4 = 0;
                while (i4 < list.size()) {
                    aii com_tencent_mm_protocal_c_aii = (aii) list.get(i4);
                    if (com_tencent_mm_protocal_c_aii.mcj != 0 || q.dqR) {
                        com.tencent.mm.plugin.report.b.itm.a(111, 252, 1, false);
                        if (com_tencent_mm_protocal_c_aii.mcj == -49 || q.dqR) {
                            v.i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", Integer.valueOf(com_tencent_mm_protocal_c_aii.mcj), Integer.valueOf(i4), Boolean.valueOf(q.dqR), Integer.valueOf(this.cRv));
                            if (this.cRw) {
                                this.cRx.add((at) this.cRu.get(i4));
                            } else if (this.cRv < 0) {
                                fO(i4);
                                this.cii.a(4, com_tencent_mm_protocal_c_aii.mcj, str, this);
                                fN(i4);
                                return;
                            } else {
                                this.cRw = true;
                                this.cRv--;
                                this.cRx.add((at) this.cRu.get(i4));
                                final String str2 = str;
                                g.vA().x(new Runnable(this) {
                                    final /* synthetic */ i cRB;

                                    public final void run() {
                                        new ag(5, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, false, 1, false).a(this.cRB.czE, new e(this) {
                                            final /* synthetic */ AnonymousClass1 cRC;

                                            {
                                                this.cRC = r1;
                                            }

                                            public final void a(int i, int i2, String str, k kVar) {
                                                kVar.czK = true;
                                                v.i("MicroMsg.NetSceneSendMsg", "summerdktext verifypsw onSceneEnd[%d, %d] needVerifyPswList size[%d] errMsg[%s] verifyingPsw[%b], retryVerifyCount[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.cRC.cRB.cRx.size()), str, Boolean.valueOf(this.cRC.cRB.cRw), Integer.valueOf(this.cRC.cRB.cRv));
                                                if (i == 0 && i2 == 0) {
                                                    this.cRC.cRB.cRx.clear();
                                                    this.cRC.cRB.jp(str);
                                                } else {
                                                    i.a(this.cRC.cRB, this.cRC.cRB.cRx);
                                                    this.cRC.cRB.cii.a(4, -49, str2, this.cRC.cRB);
                                                    i.b(this.cRC.cRB, this.cRC.cRB.cRx);
                                                    this.cRC.cRB.cRx.clear();
                                                }
                                                this.cRC.cRB.cRw = false;
                                                q.dqR = false;
                                            }
                                        });
                                    }
                                });
                            }
                        } else {
                            fO(i4);
                            this.cii.a(4, com_tencent_mm_protocal_c_aii.mcj, str, this);
                            fN(i4);
                            return;
                        }
                    }
                    long j = ((at) this.cRu.get(i4)).field_msgId;
                    v.i("MicroMsg.NetSceneSendMsg", "msg local id = " + j + ", SvrId = " + com_tencent_mm_protocal_c_aii.mcb + " sent successfully!");
                    at ek = ((d) g.f(d.class)).azI().ek(j);
                    ek.y(com_tencent_mm_protocal_c_aii.mcb);
                    v.d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(com_tencent_mm_protocal_c_aii.mcb), Integer.valueOf(q.dqk));
                    if (10007 == q.dqj && q.dqk != 0) {
                        ek.y((long) q.dqk);
                        q.dqk = 0;
                    }
                    ek.dh(2);
                    ((d) g.f(d.class)).azI().a(j, ek);
                    if (this.cRu == null) {
                        v.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
                    } else if (i4 >= this.cRu.size() || i4 < 0) {
                        v.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", Integer.valueOf(i4), Integer.valueOf(this.cRu.size()));
                    } else {
                        v.d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", Long.valueOf(((at) this.cRu.get(i4)).field_msgId));
                        at ek2 = ((d) g.f(d.class)).azI().ek(j);
                        com.tencent.mm.sdk.c.b muVar = new mu();
                        muVar.boe.aXd = ek2;
                        com.tencent.mm.sdk.c.a.nhr.z(muVar);
                    }
                    arrayList.add(Integer.valueOf(i4));
                    if (1 == com_tencent_mm_protocal_c_aii.efm) {
                        com.tencent.mm.plugin.report.b.itm.a(11942, true, false, Long.valueOf(com_tencent_mm_protocal_c_aii.mcb));
                        com.tencent.mm.plugin.report.b.itm.a(11945, false, true, Long.valueOf(com_tencent_mm_protocal_c_aii.mcb));
                        com.tencent.mm.plugin.report.b.itm.a(11946, false, false, Long.valueOf(com_tencent_mm_protocal_c_aii.mcb));
                        com.tencent.mm.plugin.report.b.itm.a(90, 0, 1, false);
                        com.tencent.mm.plugin.report.b.itm.a(90, 1, 1, true);
                    }
                    i4++;
                }
                v.i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", Integer.valueOf(i4 - this.cRx.size()), Integer.valueOf(this.cRx.size()));
            }
            v.d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", Boolean.valueOf(this.cRw));
            if (this.cRw) {
                this.cii.a(i2, i3, str, this);
                return;
            } else {
                jp(str);
                return;
            }
        }
        com.tencent.mm.plugin.report.b.itm.a(111, 253, 1, false);
        v.i("MicroMsg.NetSceneSendMsg", "mark all failed. onGYNetEnd. errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        Hj();
        this.cii.a(i2, i3, str, this);
        for (int i5 = 0; i5 < this.cRu.size(); i5++) {
            fN(i5);
        }
        v.d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
        jp(str);
    }

    private void jp(String str) {
        v.d("MicroMsg.NetSceneSendMsg", "continue send msg in list");
        int a = a(this.czE, this.cii);
        if (a == -2) {
            this.cii.a(0, 0, str, this);
        } else if (a < 0) {
            this.cii.a(3, -1, str, this);
        }
    }

    public static void a(ad adVar) {
        cRt.remove(adVar);
    }

    private void Hj() {
        for (int i = 0; i < this.cRu.size(); i++) {
            fO(i);
        }
    }

    private void fO(int i) {
        v.d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", Long.valueOf(((at) this.cRu.get(i)).field_msgId));
        n(r0);
    }

    private static void n(at atVar) {
        atVar.dh(5);
        ((d) g.f(d.class)).azI().a(atVar.field_msgId, atVar);
        for (ad adVar : cRt) {
            String str = atVar.field_talker;
            String str2 = atVar.field_content;
            adVar.fF(str);
        }
    }
}
