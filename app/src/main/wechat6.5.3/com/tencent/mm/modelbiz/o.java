package com.tencent.mm.modelbiz;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.tl;
import com.tencent.mm.protocal.c.tm;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class o extends k implements j {
    public b cif;
    private e cii;
    Object data;

    public o(String str, int i, Object obj) {
        a aVar = new a();
        aVar.czn = new tl();
        aVar.czo = new tm();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizenterpriseattr";
        this.cif = aVar.Bv();
        tl tlVar = (tl) this.cif.czk.czs;
        tlVar.mhJ = str;
        tlVar.mwG = i;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1343;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.NetSceneGetBizEnterpriseAttr", "do scene");
        return a(eVar, this.cif, this);
    }
}
