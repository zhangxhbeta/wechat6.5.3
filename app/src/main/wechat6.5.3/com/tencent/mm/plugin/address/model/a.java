package com.tencent.mm.plugin.address.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ape;
import com.tencent.mm.protocal.c.apf;
import com.tencent.mm.protocal.c.apj;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    private b cif;
    private e cii;

    public a(com.tencent.mm.plugin.address.c.b bVar) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new ape();
        aVar.czo = new apf();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoadd";
        aVar.czm = 415;
        aVar.czp = 200;
        aVar.czq = 1000000200;
        this.cif = aVar.Bv();
        ape com_tencent_mm_protocal_c_ape = (ape) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ape.mOQ = new apj();
        com_tencent_mm_protocal_c_ape.mOQ.mOY = new arf().JF(be.ah(bVar.dxE, ""));
        com_tencent_mm_protocal_c_ape.mOQ.mOW = new arf().JF(be.ah(bVar.dxC, ""));
        com_tencent_mm_protocal_c_ape.mOQ.mPb = new arf().JF(be.ah(bVar.dxH, ""));
        com_tencent_mm_protocal_c_ape.mOQ.mOZ = new arf().JF(be.ah(bVar.dxF, ""));
        com_tencent_mm_protocal_c_ape.mOQ.mPc = new arf().JF(be.ah(bVar.dxI, ""));
        com_tencent_mm_protocal_c_ape.mOQ.mPd = new arf().JF(be.ah(bVar.dxJ, ""));
        com_tencent_mm_protocal_c_ape.mOQ.mOX = new arf().JF(be.ah(bVar.dxD, ""));
        com_tencent_mm_protocal_c_ape.mOQ.mPa = new arf().JF(be.ah(bVar.dxG, ""));
        com_tencent_mm_protocal_c_ape.mOQ.mPe = new arf().JF(be.ah(bVar.dxK, ""));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneRcptInfoAdd", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            apf com_tencent_mm_protocal_c_apf = (apf) ((b) pVar).czl.czs;
            if (com_tencent_mm_protocal_c_apf.mOR.mOV != null) {
                v.d("MicroMsg.NetSceneRcptInfoAdd", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_apf.mOR.mOV.size());
                com.tencent.mm.plugin.address.a.a.Op();
                com.tencent.mm.plugin.address.a.a.Oq().q(com_tencent_mm_protocal_c_apf.mOR.mOV);
                com.tencent.mm.plugin.address.a.a.Op();
                com.tencent.mm.plugin.address.a.a.Oq().Os();
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 415;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
