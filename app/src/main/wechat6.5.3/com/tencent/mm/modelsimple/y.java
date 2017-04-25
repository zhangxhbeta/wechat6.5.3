package com.tencent.mm.modelsimple;

import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.arq;
import com.tencent.mm.protocal.c.arr;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;

public final class y extends k implements j {
    private final b cif;
    private e cii;

    public y(String str) {
        this(str, 0);
    }

    public y(String str, int i) {
        a aVar = new a();
        aVar.czn = new arr();
        aVar.czo = new ars();
        aVar.uri = "/cgi-bin/micromsg-bin/searchcontact";
        aVar.czm = MMGIFException.D_GIF_ERR_NO_COLOR_MAP;
        aVar.czp = 34;
        aVar.czq = 1000000034;
        this.cif = aVar.Bv();
        v.d("MicroMsg.NetSceneSearchContact", "search username [%s]", str);
        arr com_tencent_mm_protocal_c_arr = (arr) this.cif.czk.czs;
        com_tencent_mm_protocal_c_arr.moM = new arf().JF(str);
        com_tencent_mm_protocal_c_arr.mQH = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return MMGIFException.D_GIF_ERR_NO_COLOR_MAP;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        ars com_tencent_mm_protocal_c_ars = (ars) this.cif.czl.czs;
        h hVar;
        if (com_tencent_mm_protocal_c_ars != null && com_tencent_mm_protocal_c_ars.mxP > 0) {
            Iterator it = com_tencent_mm_protocal_c_ars.mxQ.iterator();
            while (it.hasNext()) {
                arq com_tencent_mm_protocal_c_arq = (arq) it.next();
                v.d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", com_tencent_mm_protocal_c_arq.moM);
                hVar = new h();
                hVar.username = m.a(com_tencent_mm_protocal_c_arq.moM);
                hVar.cyD = com_tencent_mm_protocal_c_arq.mlY;
                hVar.cyC = com_tencent_mm_protocal_c_arq.mlZ;
                hVar.bkU = -1;
                v.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", hVar.getUsername(), hVar.Be(), hVar.Bf());
                hVar.bBY = 3;
                hVar.aP(true);
                n.Bo().a(hVar);
            }
        } else if (!(com_tencent_mm_protocal_c_ars == null || be.kS(m.a(com_tencent_mm_protocal_c_ars.moM)))) {
            String a = m.a(com_tencent_mm_protocal_c_ars.moM);
            hVar = new h();
            hVar.username = a;
            hVar.cyD = com_tencent_mm_protocal_c_ars.mlY;
            hVar.cyC = com_tencent_mm_protocal_c_ars.mlZ;
            hVar.bkU = -1;
            v.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", hVar.getUsername(), hVar.Be(), hVar.Bf());
            hVar.bBY = 3;
            hVar.aP(true);
            n.Bo().a(hVar);
        }
        this.cii.a(i2, i3, str, this);
    }

    public final ars Jx() {
        ars com_tencent_mm_protocal_c_ars = (ars) this.cif.czl.czs;
        if (com_tencent_mm_protocal_c_ars != null) {
            Iterator it = com_tencent_mm_protocal_c_ars.mxQ.iterator();
            while (it.hasNext()) {
                arq com_tencent_mm_protocal_c_arq = (arq) it.next();
                ak.yW().xv().dJ(com_tencent_mm_protocal_c_arq.moM.mQy, com_tencent_mm_protocal_c_arq.mvR);
            }
        }
        return com_tencent_mm_protocal_c_ars;
    }
}
