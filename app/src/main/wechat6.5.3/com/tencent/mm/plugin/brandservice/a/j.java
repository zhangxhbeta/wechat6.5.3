package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.asd;
import com.tencent.mm.protocal.c.ase;
import com.tencent.mm.protocal.c.asf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.LinkedList;

public final class j extends k implements com.tencent.mm.network.j {
    private int bdf = 0;
    private b cif;
    private e cii;
    private String exv;
    private int exw;
    private are exx = new are().ba(new byte[0]);
    public LinkedList<asf> exy;

    public j(String str) {
        this.exv = str;
        this.exw = 0;
    }

    public final int getType() {
        return 455;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        a aVar = new a();
        aVar.czn = new asd();
        aVar.czo = new ase();
        aVar.uri = "/cgi-bin/micromsg-bin/searchorrecommendbiz";
        aVar.czm = 455;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        asd com_tencent_mm_protocal_c_asd = (asd) this.cif.czk.czs;
        com_tencent_mm_protocal_c_asd.mEj = m.lY(this.exv);
        com_tencent_mm_protocal_c_asd.lZm = this.bdf;
        com_tencent_mm_protocal_c_asd.mQT = this.exw;
        com_tencent_mm_protocal_c_asd.mcz = this.exx;
        v.d("MicroMsg.BrandService.NetSceneSearchOrRecommendBiz", "doScene:" + this.exv + "  :" + this.bdf + "  entryFlag:" + this.exw);
        return a(eVar, this.cif, this);
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }

    protected final int ul() {
        return 50;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.BrandService.NetSceneSearchOrRecommendBiz", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (i2 == 0 && i3 == 0) {
            ase com_tencent_mm_protocal_c_ase = (ase) this.cif.czl.czs;
            this.exx = com_tencent_mm_protocal_c_ase.mQI;
            this.exy = com_tencent_mm_protocal_c_ase.mQV;
            Iterator it = this.exy.iterator();
            while (it.hasNext()) {
                asf com_tencent_mm_protocal_c_asf = (asf) it.next();
                h hVar = new h();
                hVar.username = m.a(com_tencent_mm_protocal_c_asf.moM);
                hVar.cyD = com_tencent_mm_protocal_c_asf.mlY;
                hVar.cyC = com_tencent_mm_protocal_c_asf.mlZ;
                hVar.bkU = -1;
                hVar.bBY = 3;
                hVar.aP(true);
                n.Bo().a(hVar);
            }
        } else {
            this.exy = null;
        }
        this.cii.a(i2, i3, str, this);
    }
}
