package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.baz;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class m extends k implements j {
    private b cif = null;
    private e cii = null;
    public String fwf;
    public String fwg;

    public m(String str, String str2) {
        this.fwf = str;
        this.fwg = str2;
        a aVar = new a();
        aVar.czn = new baz();
        aVar.czo = new bba();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/updatecover";
        aVar.czm = 1040;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        baz com_tencent_mm_protocal_c_baz = (baz) this.cif.czk.czs;
        com_tencent_mm_protocal_c_baz.mBv = str;
        com_tencent_mm_protocal_c_baz.fwg = str2;
    }

    public final int getType() {
        return 1040;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneUpdateRankCoverAndMotto", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cii.a(i2, i3, str, this);
    }
}
