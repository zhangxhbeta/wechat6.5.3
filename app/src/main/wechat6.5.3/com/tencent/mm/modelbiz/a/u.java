package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aoq;
import com.tencent.mm.protocal.c.aor;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class u extends k implements j {
    public b cif;
    private e cii;

    public u(String str, String str2) {
        a aVar = new a();
        aVar.czn = new aoq();
        aVar.czo = new aor();
        aVar.uri = "/cgi-bin/mmocbiz-bin/quitbizchat";
        this.cif = aVar.Bv();
        aoq com_tencent_mm_protocal_c_aoq = (aoq) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aoq.mhJ = str;
        com_tencent_mm_protocal_c_aoq.mhD = str2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.brandservice.NetSceneQuitBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1358;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.brandservice.NetSceneQuitBizChat", "do scene");
        return a(eVar, this.cif, this);
    }
}
