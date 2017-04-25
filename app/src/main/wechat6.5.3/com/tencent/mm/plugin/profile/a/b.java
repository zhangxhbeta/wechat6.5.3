package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.atr;
import com.tencent.mm.protocal.c.ats;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    public com.tencent.mm.v.b cif;
    private e cii;

    public b(String str, int i) {
        a aVar = new a();
        aVar.czn = new atr();
        aVar.czo = new ats();
        aVar.uri = "/cgi-bin/mmocbiz-bin/setbrandflag";
        aVar.czm = 1363;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        atr com_tencent_mm_protocal_c_atr = (atr) this.cif.czk.czs;
        com_tencent_mm_protocal_c_atr.mhJ = str;
        com_tencent_mm_protocal_c_atr.mRF = i;
        com_tencent_mm_protocal_c_atr.mRG = 4;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.brandservice.NetSceneSetBrandFlag", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1363;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.brandservice.NetSceneSetBrandFlag", "do scene");
        return a(eVar, this.cif, this);
    }
}
