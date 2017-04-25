package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.protocal.c.avf;
import com.tencent.mm.protocal.c.avg;
import com.tencent.mm.protocal.c.avi;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awp;
import com.tencent.mm.protocal.c.aya;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class j extends k implements com.tencent.mm.network.j {
    private b cif;
    public e cii;
    private String jjR;
    private avn jjS;
    private int type;

    public j(avn com_tencent_mm_protocal_c_avn, String str, String str2) {
        aya kw;
        a aVar = new a();
        aVar.czn = new avf();
        aVar.czo = new avg();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsadcomment";
        aVar.czm = 682;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        avf com_tencent_mm_protocal_c_avf = (avf) this.cif.czk.czs;
        com_tencent_mm_protocal_c_avf.mSD = com_tencent_mm_protocal_c_avn;
        this.type = com_tencent_mm_protocal_c_avn.mST.efm;
        this.jjS = com_tencent_mm_protocal_c_avn;
        com_tencent_mm_protocal_c_avf.mbN = str;
        this.jjR = str;
        c cV = ad.aSF().cV(com_tencent_mm_protocal_c_avn.mjq);
        if (cV != null) {
            azr aUp = cV.aUp();
            if (aUp != null) {
                kw = o.kw(aUp.jGu);
            } else {
                v.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[]{Long.valueOf(r2)});
                kw = null;
            }
        } else {
            v.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[]{Long.valueOf(r2)});
            kw = null;
        }
        if (kw != null) {
            com_tencent_mm_protocal_c_avf.mSE = m.lY(o.a(kw));
            com_tencent_mm_protocal_c_avf.mcP = kw.bbT;
        }
        com_tencent_mm_protocal_c_avf.mSC = m.lY(be.ah(str2, ""));
        v.i("MicroMsg.NetSceneSnsAdComment", com_tencent_mm_protocal_c_avn.mST.mOk + " " + com_tencent_mm_protocal_c_avn.mST.mqR + " type " + com_tencent_mm_protocal_c_avn.mST.efm + " aduxinfo " + str2 + ", SnsStat=" + com_tencent_mm_protocal_c_avf.mSE + ", source=" + com_tencent_mm_protocal_c_avf.mcP);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 682;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneSnsAdComment", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            ad.aSD().c(this.jjS.mjq, this.type, this.jjR);
            avm com_tencent_mm_protocal_c_avm = this.jjS.mST;
            if (com_tencent_mm_protocal_c_avm.efm == 1 || com_tencent_mm_protocal_c_avm.efm == 2 || com_tencent_mm_protocal_c_avm.efm == 3 || com_tencent_mm_protocal_c_avm.efm == 5 || com_tencent_mm_protocal_c_avm.efm == 7 || com_tencent_mm_protocal_c_avm.efm == 8) {
                avr com_tencent_mm_protocal_c_avr = new avr();
                com_tencent_mm_protocal_c_avr.hNS = com_tencent_mm_protocal_c_avm.hNS;
                com_tencent_mm_protocal_c_avr.efm = com_tencent_mm_protocal_c_avm.efm;
                com_tencent_mm_protocal_c_avr.mcP = com_tencent_mm_protocal_c_avm.mcP;
                com_tencent_mm_protocal_c_avr.mdw = com_tencent_mm_protocal_c_avm.mOk;
                com_tencent_mm_protocal_c_avr.mGq = com_tencent_mm_protocal_c_avm.mSK;
                com_tencent_mm_protocal_c_avr.hQP = com_tencent_mm_protocal_c_avm.hQP;
                try {
                    awa com_tencent_mm_protocal_c_awa;
                    avg com_tencent_mm_protocal_c_avg = (avg) this.cif.czl.czs;
                    if (((avf) this.cif.czk.czs).mcP == 1) {
                        awp com_tencent_mm_protocal_c_awp = com_tencent_mm_protocal_c_avg.mPj;
                        com_tencent_mm_protocal_c_awa = com_tencent_mm_protocal_c_awp.mSF;
                        a.a(com_tencent_mm_protocal_c_awp);
                    } else {
                        avi com_tencent_mm_protocal_c_avi = com_tencent_mm_protocal_c_avg.mcn;
                        com_tencent_mm_protocal_c_awa = com_tencent_mm_protocal_c_avi.mSF;
                        a.b(com_tencent_mm_protocal_c_avi);
                    }
                    v.d("MicroMsg.NetSceneSnsAdComment", "snsComment:" + com_tencent_mm_protocal_c_awa.toString() + " " + com_tencent_mm_protocal_c_awa.mTk.size() + " " + com_tencent_mm_protocal_c_awa.mTn.size());
                } catch (Throwable e) {
                    v.a("MicroMsg.NetSceneSnsAdComment", e, "", new Object[0]);
                }
            }
            ad.aSD().aSf();
        } else if (i2 == 4) {
            ad.aSD().c(this.jjS.mjq, this.type, this.jjR);
        }
        this.cii.a(i2, i3, str, this);
    }
}
