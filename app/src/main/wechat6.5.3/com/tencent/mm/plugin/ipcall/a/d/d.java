package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aar;
import com.tencent.mm.protocal.c.aas;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class d extends k implements j {
    private b cif = null;
    private e cii;
    private aar gHD = null;
    public aas gHE = null;
    public boolean gHF = true;

    public d(String str, String str2) {
        if (be.kS(str2)) {
            this.gHF = true;
            str2 = "";
        } else {
            this.gHF = false;
        }
        a aVar = new a();
        aVar.czn = new aar();
        aVar.czo = new aas();
        aVar.czm = 929;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcoproductlist";
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.gHD = (aar) this.cif.czk.czs;
        this.gHD.mBW = str;
        this.gHD.mBX = str2;
        v.i("MicroMsg.NetSceneIPCallGetProductList", "NetSceneIPCallGetProductList");
    }

    public final int getType() {
        return 929;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneIPCallGetProductList", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gHE = (aas) ((b) pVar).czl.czs;
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
