package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.protocal.c.anp;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    private com.tencent.mm.v.b cif = null;
    private e cii;
    public anp gHA = null;
    private ano gHz = null;

    public b(String str, String str2, String str3, String str4, int i) {
        a aVar = new a();
        aVar.czn = new ano();
        aVar.czo = new anp();
        aVar.czm = 807;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnchecknumber";
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.gHz = (ano) this.cif.czk.czs;
        this.gHz.mNR = str;
        this.gHz.mNT = str2;
        this.gHz.mNV = str3;
        this.gHz.mNU = str4;
        this.gHz.mNW = i;
        v.i("MicroMsg.NetSceneIPCallCheckNumber", "NetSceneIPCallCheckNumber pureNumber:%s,lastCountry:%s,osCountry:%s,simCountry:%s,dialScene:%d", new Object[]{str, str2, str3, str4, Integer.valueOf(i)});
    }

    public final int getType() {
        return 807;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneIPCallCheckNumber", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gHA = (anp) ((com.tencent.mm.v.b) pVar).czl.czs;
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
