package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.model.ad;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.ax;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class c extends k implements j {
    private static final List<ad> cRt = new ArrayList();
    private static final Set<Long> krs = new HashSet();
    private long bao;
    private final List<at> cRu = new LinkedList();
    private b cif;
    private e cii;

    public c(String str, String str2, int i) {
        boolean z = true;
        v.d("MicroMsg.NetSceneSendMsg", "dktext :" + be.bur());
        if (!be.kS(str)) {
            at atVar = new at();
            atVar.dh(1);
            atVar.cH(str);
            atVar.z(aw.fN(str));
            atVar.di(1);
            atVar.setContent(str2);
            atVar.setType(i);
            ak.yW();
            this.bao = com.tencent.mm.model.c.wJ().R(atVar);
            if (this.bao == -1) {
                z = false;
            }
            Assert.assertTrue(z);
            v.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.bao);
        }
    }

    public c() {
        v.d("MicroMsg.NetSceneSendMsg", "dktext :" + be.bur());
        v.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    }

    protected final int ul() {
        return 10;
    }

    protected final int a(p pVar) {
        return this.cRu.size() > 0 ? k.b.czU : k.b.czV;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
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
        ak.yW();
        List bwX = com.tencent.mm.model.c.wJ().bwX();
        if (bwX.size() == 0) {
            v.i("MicroMsg.NetSceneSendMsg", "no sending message");
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
                com_tencent_mm_protocal_c_aih.mbZ = ax.zs();
                com_tencent_mm_protocal_c_asv.eeu.add(com_tencent_mm_protocal_c_aih);
                com_tencent_mm_protocal_c_asv.eet = com_tencent_mm_protocal_c_asv.eeu.size();
                this.cRu.add(atVar);
            }
        }
        int a = a(eVar, this.cif, this);
        if (a >= 0) {
            return a;
        }
        Hj();
        return a;
    }

    public final int getType() {
        return 522;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            List list = ((asw) this.cif.czl.czs).eeu;
            if (this.cRu.size() == list.size()) {
                int i4 = 0;
                while (i4 < list.size()) {
                    aii com_tencent_mm_protocal_c_aii = (aii) list.get(i4);
                    if (com_tencent_mm_protocal_c_aii.mcj != 0) {
                        v.e("MicroMsg.NetSceneSendMsg", "send msg failed: item ret code=" + com_tencent_mm_protocal_c_aii.mcj);
                        fO(i4);
                        this.cii.a(4, com_tencent_mm_protocal_c_aii.mcj, str, this);
                        return;
                    }
                    long j = ((at) this.cRu.get(i4)).field_msgId;
                    v.i("MicroMsg.NetSceneSendMsg", "msg local id = " + j + ", SvrId = " + com_tencent_mm_protocal_c_aii.mcb + " sent successfully!");
                    ak.yW();
                    at ek = com.tencent.mm.model.c.wJ().ek(j);
                    ek.y(com_tencent_mm_protocal_c_aii.mcb);
                    ek.dh(2);
                    ak.yW();
                    com.tencent.mm.model.c.wJ().a(j, ek);
                    i4++;
                }
                v.i("MicroMsg.NetSceneSendMsg", "total " + i4 + " msgs sent successfully");
            }
            int a = a(this.czE, this.cii);
            if (a == -2) {
                this.cii.a(0, 0, str, this);
                return;
            } else if (a < 0) {
                this.cii.a(3, -1, str, this);
                return;
            } else {
                return;
            }
        }
        Hj();
        this.cii.a(i2, i3, str, this);
    }

    private void Hj() {
        for (int i = 0; i < this.cRu.size(); i++) {
            fO(i);
        }
    }

    private void fO(int i) {
        at atVar = (at) this.cRu.get(i);
        atVar.dh(5);
        ak.yW();
        com.tencent.mm.model.c.wJ().a(atVar.field_msgId, atVar);
        for (ad adVar : cRt) {
            String str = atVar.field_talker;
            String str2 = atVar.field_content;
            adVar.fF(str);
        }
    }
}
