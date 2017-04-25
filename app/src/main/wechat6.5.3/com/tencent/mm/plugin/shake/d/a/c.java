package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aku;
import com.tencent.mm.protocal.c.akv;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c extends k implements j {
    private b cif;
    private e cii;

    public c(int i, String str) {
        a aVar = new a();
        aVar.czn = new aku();
        aVar.czo = new akv();
        aVar.uri = "/cgi-bin/mmoctv/optvhist";
        aVar.czm = 1740;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aku com_tencent_mm_protocal_c_aku = (aku) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aku.gly = i;
        com_tencent_mm_protocal_c_aku.mLJ = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneOpTvHist", "onGYNetEnd [%d,%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1740;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
