package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.agd;
import com.tencent.mm.protocal.c.age;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class l extends k implements j {
    public int bmK;
    private b cif = null;
    private e cii = null;
    public String cps;
    public String fwr;

    public l(String str, String str2, int i, String str3) {
        this.fwr = str3;
        this.cps = str2;
        this.bmK = i;
        this.fwr = str3;
        a aVar = new a();
        aVar.czn = new agd();
        aVar.czo = new age();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/addlike";
        aVar.czm = 1041;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        agd com_tencent_mm_protocal_c_agd = (agd) this.cif.czk.czs;
        com_tencent_mm_protocal_c_agd.fDn = str2;
        com_tencent_mm_protocal_c_agd.username = str;
        com_tencent_mm_protocal_c_agd.bmK = i;
        com_tencent_mm_protocal_c_agd.coI = str3;
    }

    public final int getType() {
        return 1041;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneUpdateLikeStatus", "hy: end. errType: %d, errCode: %d, errMsg: %s, ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cii.a(i2, i3, str, this);
    }
}
