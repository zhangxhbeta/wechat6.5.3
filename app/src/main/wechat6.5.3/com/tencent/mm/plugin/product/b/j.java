package com.tencent.mm.plugin.product.b;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ak;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.ang;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class j extends k implements com.tencent.mm.network.j {
    private b cif;
    private e cii;
    public String hQe;
    public LinkedList<pc> hQp;
    public LinkedList<ak> hQq;

    public j(LinkedList<arj> linkedList, int i) {
        int i2 = 0;
        a aVar = new a();
        aVar.czn = new anf();
        aVar.czo = new ang();
        aVar.uri = "/cgi-bin/micromsg-bin/presubmitorder";
        aVar.czm = 554;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        anf com_tencent_mm_protocal_c_anf = (anf) this.cif.czk.czs;
        com_tencent_mm_protocal_c_anf.mjW = linkedList;
        if (linkedList != null) {
            i2 = linkedList.size();
        }
        com_tencent_mm_protocal_c_anf.hOe = i2;
        com_tencent_mm_protocal_c_anf.mNs = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        ang com_tencent_mm_protocal_c_ang = (ang) ((b) pVar).czl.czs;
        if (i2 == 0 && i3 == 0 && com_tencent_mm_protocal_c_ang.mjY == 0) {
            v.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.ExpressCount " + com_tencent_mm_protocal_c_ang.mzb);
            v.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.LockId " + com_tencent_mm_protocal_c_ang.mjX);
            this.hQp = com_tencent_mm_protocal_c_ang.mNt;
            this.hQe = com_tencent_mm_protocal_c_ang.mjX;
            this.hQq = com_tencent_mm_protocal_c_ang.mNu;
        }
        if (i3 == 0 && com_tencent_mm_protocal_c_ang.mjY != 0) {
            i3 = com_tencent_mm_protocal_c_ang.mjY;
            str = com_tencent_mm_protocal_c_ang.mjZ;
        }
        v.d("MicroMsg.NetSceneMallPreSubmitOrder", "errCode " + i3 + ", errMsg " + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 554;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
