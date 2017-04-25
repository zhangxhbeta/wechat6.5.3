package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bat;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.protocal.c.gu;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class w extends k implements j {
    public b cif;
    private e cii;
    Object data;

    public w(String str, gu guVar, Object obj) {
        a aVar = new a();
        aVar.czn = new bat();
        aVar.czo = new bau();
        aVar.uri = "/cgi-bin/mmocbiz-bin/updatebizchat";
        this.cif = aVar.Bv();
        bat com_tencent_mm_protocal_c_bat = (bat) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bat.mhJ = str;
        com_tencent_mm_protocal_c_bat.muP = guVar;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.brandservice.NetSceneUpdateBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1356;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.brandservice.NetSceneUpdateBizChat", "do scene");
        return a(eVar, this.cif, this);
    }
}
