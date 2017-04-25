package com.tencent.mm.modelbiz;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.atp;
import com.tencent.mm.protocal.c.atq;
import com.tencent.mm.protocal.c.hc;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class t extends k implements j {
    public b cif;
    private e cii;
    Object data;

    public t(hc hcVar, Object obj) {
        a aVar = new a();
        aVar.czn = new atp();
        aVar.czo = new atq();
        aVar.uri = "/cgi-bin/mmocbiz-bin/setbizenterpriseattr";
        this.cif = aVar.Bv();
        atp com_tencent_mm_protocal_c_atp = (atp) this.cif.czk.czs;
        com_tencent_mm_protocal_c_atp.mwH = hcVar;
        com_tencent_mm_protocal_c_atp.mask = 1;
        com_tencent_mm_protocal_c_atp.mwG = 1;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneSetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1228;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.NetSceneSetBizEnterpriseAttr", "do scene");
        return a(eVar, this.cif, this);
    }
}
