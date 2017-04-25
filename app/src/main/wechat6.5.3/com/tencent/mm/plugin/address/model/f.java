package com.tencent.mm.plugin.address.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.apj;
import com.tencent.mm.protocal.c.apq;
import com.tencent.mm.protocal.c.apr;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class f extends k implements j {
    private b cif;
    private e cii;

    public f(com.tencent.mm.plugin.address.c.b bVar) {
        a aVar = new a();
        aVar.czn = new apq();
        aVar.czo = new apr();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoupdate";
        aVar.czm = 418;
        aVar.czp = 203;
        aVar.czq = 1000000203;
        this.cif = aVar.Bv();
        apq com_tencent_mm_protocal_c_apq = (apq) this.cif.czk.czs;
        com_tencent_mm_protocal_c_apq.mOQ = new apj();
        com_tencent_mm_protocal_c_apq.mOQ.id = bVar.id;
        com_tencent_mm_protocal_c_apq.mOQ.mOY = new arf().JF(be.ah(bVar.dxE, ""));
        com_tencent_mm_protocal_c_apq.mOQ.mOW = new arf().JF(be.ah(bVar.dxC, ""));
        com_tencent_mm_protocal_c_apq.mOQ.mPb = new arf().JF(be.ah(bVar.dxH, ""));
        com_tencent_mm_protocal_c_apq.mOQ.mOZ = new arf().JF(be.ah(bVar.dxF, ""));
        com_tencent_mm_protocal_c_apq.mOQ.mPc = new arf().JF(be.ah(bVar.dxI, ""));
        com_tencent_mm_protocal_c_apq.mOQ.mPd = new arf().JF(be.ah(bVar.dxJ, ""));
        com_tencent_mm_protocal_c_apq.mOQ.mOX = new arf().JF(be.ah(bVar.dxD, ""));
        com_tencent_mm_protocal_c_apq.mOQ.mPa = new arf().JF(be.ah(bVar.dxG, ""));
        com_tencent_mm_protocal_c_apq.mOQ.mPe = new arf().JF(be.ah(bVar.dxK, ""));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneRcptInfoUpdate", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            apr com_tencent_mm_protocal_c_apr = (apr) ((b) pVar).czl.czs;
            if (com_tencent_mm_protocal_c_apr.mOR.mOV != null) {
                v.d("MicroMsg.NetSceneRcptInfoUpdate", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_apr.mOR.mOV.size());
                com.tencent.mm.plugin.address.a.a.Op();
                com.tencent.mm.plugin.address.a.a.Oq().q(com_tencent_mm_protocal_c_apr.mOR.mOV);
                com.tencent.mm.plugin.address.a.a.Op();
                com.tencent.mm.plugin.address.a.a.Oq().Os();
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 418;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
