package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.avs;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awi;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Locale;

public final class m extends k implements j {
    private b cif;
    public e cii;
    private String jjR;
    private avn jjS;
    private int type;

    public m(avn com_tencent_mm_protocal_c_avn, String str) {
        a aVar = new a();
        aVar.czn = new avs();
        aVar.czo = new avt();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnscomment";
        aVar.czm = 213;
        aVar.czp = 100;
        aVar.czq = 1000000100;
        this.cif = aVar.Bv();
        avs com_tencent_mm_protocal_c_avs = (avs) this.cif.czk.czs;
        com_tencent_mm_protocal_c_avs.mSD = com_tencent_mm_protocal_c_avn;
        this.type = com_tencent_mm_protocal_c_avn.mST.efm;
        this.jjS = com_tencent_mm_protocal_c_avn;
        com_tencent_mm_protocal_c_avs.mbN = str;
        this.jjR = str;
        v.d("MicroMsg.NetSceneSnsComment", com_tencent_mm_protocal_c_avn.mST.mOk + " " + com_tencent_mm_protocal_c_avn.mST.mqR);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        com.tencent.mm.plugin.sns.storage.k dd = ad.aSE().dd(this.jjS.mjq);
        if (dd == null) {
            c cV = ad.aSF().cV(this.jjS.mjq);
            if (cV != null) {
                dd = cV.aUr();
            }
        }
        if (dd != null) {
            try {
                awa com_tencent_mm_protocal_c_awa = (awa) new awa().az(dd.field_attrBuf);
                if (com_tencent_mm_protocal_c_awa.mTy != null && com_tencent_mm_protocal_c_awa.mTy.mQx) {
                    awi com_tencent_mm_protocal_c_awi = (awi) new awi().az(com_tencent_mm_protocal_c_awa.mTy.mQw.lVU);
                    avs com_tencent_mm_protocal_c_avs = (avs) this.cif.czk.czs;
                    if (com_tencent_mm_protocal_c_awi.mTL != null) {
                        v.i("MicroMsg.NetSceneSnsComment", "doScene(sight_autodownload) snsStatExt:%s", new Object[]{String.format(Locale.US, "preloadLayerId=%d&preloadExpId=%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_awi.mTL.moW), Integer.valueOf(com_tencent_mm_protocal_c_awi.mTL.moX)})});
                        com_tencent_mm_protocal_c_avs.mSE = new arf().JF(r0);
                    }
                }
            } catch (Throwable e) {
                v.a("MicroMsg.NetSceneSnsComment", e, "", new Object[0]);
            }
        }
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 213;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneSnsComment", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            ad.aSD().c(this.jjS.mjq, this.type, this.jjR);
            avm com_tencent_mm_protocal_c_avm = this.jjS.mST;
            if (com_tencent_mm_protocal_c_avm.efm == 1 || com_tencent_mm_protocal_c_avm.efm == 2 || com_tencent_mm_protocal_c_avm.efm == 3 || com_tencent_mm_protocal_c_avm.efm == 5) {
                avr com_tencent_mm_protocal_c_avr = new avr();
                com_tencent_mm_protocal_c_avr.hNS = com_tencent_mm_protocal_c_avm.hNS;
                com_tencent_mm_protocal_c_avr.efm = com_tencent_mm_protocal_c_avm.efm;
                com_tencent_mm_protocal_c_avr.mcP = com_tencent_mm_protocal_c_avm.mcP;
                com_tencent_mm_protocal_c_avr.mdw = com_tencent_mm_protocal_c_avm.mOk;
                com_tencent_mm_protocal_c_avr.mGq = com_tencent_mm_protocal_c_avm.mSK;
                com_tencent_mm_protocal_c_avr.hQP = com_tencent_mm_protocal_c_avm.hQP;
                try {
                    awa com_tencent_mm_protocal_c_awa = ((avt) this.cif.czl.czs).mSF;
                    if (com_tencent_mm_protocal_c_avm.efm == 1 || com_tencent_mm_protocal_c_avm.efm == 5) {
                        v.i("MicroMsg.NetSceneSnsComment", "snsComment:" + com_tencent_mm_protocal_c_awa.mjq + " " + com.tencent.mm.platformtools.m.b(com_tencent_mm_protocal_c_awa.mTg) + " " + com_tencent_mm_protocal_c_awa.mTk.size() + " " + com_tencent_mm_protocal_c_awa.mTn.size());
                    } else {
                        v.i("MicroMsg.NetSceneSnsComment", "snsComment:" + com_tencent_mm_protocal_c_awa.mjq + " " + com_tencent_mm_protocal_c_awa.mTk.size() + " " + com_tencent_mm_protocal_c_awa.mTn.size());
                    }
                    ah.d(com_tencent_mm_protocal_c_awa);
                } catch (Throwable e) {
                    v.a("MicroMsg.NetSceneSnsComment", e, "", new Object[0]);
                }
            }
            ad.aSD().aSf();
        } else if (i2 == 4) {
            ad.aSD().c(this.jjS.mjq, this.type, this.jjR);
        }
        this.cii.a(i2, i3, str, this);
    }
}
