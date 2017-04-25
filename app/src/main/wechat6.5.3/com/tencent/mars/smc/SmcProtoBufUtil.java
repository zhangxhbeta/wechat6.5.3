package com.tencent.mars.smc;

import com.tencent.mm.protocal.a.a.a;
import com.tencent.mm.protocal.a.a.b;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.d;
import com.tencent.mm.protocal.a.a.e;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.a.a.g;
import com.tencent.mm.protocal.a.a.h;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.a.a.j;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.protocal.a.a.l;
import com.tencent.mm.protocal.a.a.m;
import com.tencent.mm.protocal.a.a.n;
import com.tencent.mm.protocal.a.a.o;
import com.tencent.mm.protocal.c.acx;
import com.tencent.mm.protocal.c.acy;
import com.tencent.mm.protocal.c.afe;
import com.tencent.mm.protocal.c.akd;
import com.tencent.mm.protocal.c.ayi;
import com.tencent.mm.protocal.c.kt;
import com.tencent.mm.protocal.c.ku;
import com.tencent.mm.protocal.c.kv;
import com.tencent.mm.protocal.c.uy;
import com.tencent.mm.protocal.c.uz;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil {
    public static ku toMMReportKvReq(i iVar) {
        ku kuVar = new ku();
        kuVar.mnl = iVar.lXF;
        kuVar.mnm = iVar.lXV;
        kuVar.mnn = iVar.lXT;
        for (int i = 0; i < iVar.lXW.size(); i++) {
            e eVar = (e) iVar.lXW.get(i);
            kt ktVar = new kt();
            ktVar.fvo = eVar.uin;
            ktVar.mfB = eVar.lXD;
            ktVar.mnk = eVar.nettype;
            ktVar.miq = eVar.lXP;
            ktVar.mio = eVar.lXN;
            ktVar.mip = eVar.lXO;
            ktVar.mir = eVar.lXQ;
            ktVar.mis = eVar.lXR;
            ktVar.efp = eVar.lXS;
            for (int i2 = 0; i2 < eVar.lXE.size(); i2++) {
                d dVar = (d) eVar.lXE.get(i2);
                afe com_tencent_mm_protocal_c_afe = new afe();
                com_tencent_mm_protocal_c_afe.mFd = dVar.lXC;
                com_tencent_mm_protocal_c_afe.mFe = dVar.lXL;
                com_tencent_mm_protocal_c_afe.mFf = dVar.lXM;
                com_tencent_mm_protocal_c_afe.mpl = dVar.iOT;
                com_tencent_mm_protocal_c_afe.eet = dVar.count;
                ktVar.miT.add(com_tencent_mm_protocal_c_afe);
            }
            kuVar.mno.add(ktVar);
        }
        return kuVar;
    }

    public static ku toMMReportIdkeyReq(g gVar) {
        ku kuVar = new ku();
        kuVar.mnl = gVar.lXF;
        kuVar.mnm = gVar.lXV;
        kuVar.mnn = 0;
        for (int i = 0; i < gVar.lXW.size(); i++) {
            b bVar = (b) gVar.lXW.get(i);
            kt ktVar = new kt();
            ktVar.fvo = bVar.uin;
            ktVar.mfB = bVar.lXD;
            ktVar.mnk = bVar.nettype;
            for (int i2 = 0; i2 < bVar.lXE.size(); i2++) {
                a aVar = (a) bVar.lXE.get(i2);
                afe com_tencent_mm_protocal_c_afe = new afe();
                com_tencent_mm_protocal_c_afe.mFd = aVar.lXC;
                com_tencent_mm_protocal_c_afe.mpl = 0;
                com_tencent_mm_protocal_c_afe.mFf = 0;
                com_tencent_mm_protocal_c_afe.eet = aVar.count;
                com_tencent_mm_protocal_c_afe.mFe = com.tencent.mm.ba.b.aT(Integer.toString(aVar.value).getBytes());
                ktVar.miT.add(com_tencent_mm_protocal_c_afe);
            }
            kuVar.mno.add(ktVar);
        }
        return kuVar;
    }

    private static o fillStrategyTable(LinkedList<ayi> linkedList) {
        o oVar = new o();
        for (int i = 0; i < linkedList.size(); i++) {
            ayi com_tencent_mm_protocal_c_ayi = (ayi) linkedList.get(i);
            m mVar = new m();
            mVar.lYi = com_tencent_mm_protocal_c_ayi.mVP;
            mVar.lYj = com_tencent_mm_protocal_c_ayi.mVQ;
            for (int i2 = 0; i2 < com_tencent_mm_protocal_c_ayi.mVR.size(); i2++) {
                akd com_tencent_mm_protocal_c_akd = (akd) com_tencent_mm_protocal_c_ayi.mVR.get(i2);
                n nVar = new n();
                nVar.lXC = com_tencent_mm_protocal_c_akd.mFd;
                nVar.lYl = com_tencent_mm_protocal_c_akd.mLb;
                nVar.lYm = com_tencent_mm_protocal_c_akd.mKZ;
                nVar.lYn = com_tencent_mm_protocal_c_akd.mLa;
                nVar.lYo = com_tencent_mm_protocal_c_akd.mLc;
                nVar.lYp = com_tencent_mm_protocal_c_akd.mLd;
                nVar.lYq = com_tencent_mm_protocal_c_akd.mLe;
                mVar.lYk.add(nVar);
            }
            oVar.lYr.add(mVar);
        }
        return oVar;
    }

    public static j toSmcReportKvResp(kv kvVar) {
        j jVar = new j();
        jVar.ret = kvVar.mcj;
        jVar.lXF = kvVar.mnq;
        jVar.lXG = kvVar.mnr;
        jVar.lXT = kvVar.mns;
        jVar.lXJ = kvVar.mnw;
        jVar.lXY = kvVar.mnx;
        jVar.lXK = kvVar.mny;
        jVar.lXH = fillStrategyTable(kvVar.mnt);
        jVar.lXI = fillStrategyTable(kvVar.mnu);
        jVar.lXU = fillStrategyTable(kvVar.mnv);
        return jVar;
    }

    public static h toSmcReportIdkeyResp(kv kvVar) {
        h hVar = new h();
        hVar.ret = kvVar.mcj;
        hVar.lXF = kvVar.mnq;
        hVar.lXG = kvVar.mnr;
        hVar.lXJ = kvVar.mnw;
        hVar.lXY = kvVar.mnx;
        hVar.lXK = kvVar.mny;
        hVar.lXH = fillStrategyTable(kvVar.mnt);
        hVar.lXI = fillStrategyTable(kvVar.mnu);
        return hVar;
    }

    public static uy toMMGetStrategyReq() {
        uy uyVar = new uy();
        ArrayList strategyVersions = SmcLogic.getStrategyVersions();
        if (strategyVersions.size() != 6) {
            return null;
        }
        uyVar.mnl = ((Integer) strategyVersions.get(0)).intValue();
        uyVar.mnm = ((Integer) strategyVersions.get(1)).intValue();
        uyVar.mnn = ((Integer) strategyVersions.get(2)).intValue();
        uyVar.mxD = ((Integer) strategyVersions.get(3)).intValue();
        uyVar.mxE = ((Integer) strategyVersions.get(4)).intValue();
        uyVar.mxF = ((Integer) strategyVersions.get(5)).intValue();
        return uyVar;
    }

    public static f toSmcKVStrategyResp(uz uzVar) {
        f fVar = new f();
        fVar.ret = uzVar.mcj;
        fVar.lXF = uzVar.mxD;
        fVar.lXG = uzVar.mxE;
        fVar.lXT = uzVar.mxF;
        fVar.lXJ = uzVar.mnw;
        fVar.lXK = uzVar.mny;
        fVar.lXH = fillStrategyTable(uzVar.mxG);
        fVar.lXI = fillStrategyTable(uzVar.mxH);
        fVar.lXU = fillStrategyTable(uzVar.mxI);
        return fVar;
    }

    public static c toSmcIdkeyStrategyResp(uz uzVar) {
        c cVar = new c();
        cVar.ret = uzVar.mcj;
        cVar.lXF = uzVar.mnq;
        cVar.lXG = uzVar.mnr;
        cVar.lXJ = uzVar.mnw;
        cVar.lXK = uzVar.mny;
        cVar.lXH = fillStrategyTable(uzVar.mnt);
        cVar.lXI = fillStrategyTable(uzVar.mnu);
        return cVar;
    }

    public static acx toMMSelfMonitor(k kVar) {
        acx com_tencent_mm_protocal_c_acx = new acx();
        com_tencent_mm_protocal_c_acx.mDR = kVar.lXZ;
        for (int i = 0; i < kVar.lYa.size(); i++) {
            acy com_tencent_mm_protocal_c_acy = new acy();
            l lVar = (l) kVar.lYa.get(i);
            com_tencent_mm_protocal_c_acy.mDS = lVar.lYb;
            com_tencent_mm_protocal_c_acy.aXy = lVar.action;
            com_tencent_mm_protocal_c_acy.mDT = lVar.lYc;
            com_tencent_mm_protocal_c_acy.mDU = lVar.lYd;
            com_tencent_mm_protocal_c_acy.mDV = lVar.lYe;
            com_tencent_mm_protocal_c_acy.mDW = lVar.lYf;
            com_tencent_mm_protocal_c_acy.mDX = lVar.lYg;
            com_tencent_mm_protocal_c_acy.mDY = lVar.lYh;
            com_tencent_mm_protocal_c_acx.miT.add(com_tencent_mm_protocal_c_acy);
        }
        return com_tencent_mm_protocal_c_acx;
    }
}
