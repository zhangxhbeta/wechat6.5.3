package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.beo;
import com.tencent.mm.protocal.c.bep;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    private com.tencent.mm.v.b cif;
    private e cii;

    public b(long j, long j2) {
        a aVar = new a();
        aVar.czn = new beo();
        aVar.czo = new bep();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipheartbeat";
        aVar.czm = 795;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        beo com_tencent_mm_protocal_c_beo = (beo) this.cif.czk.czs;
        com_tencent_mm_protocal_c_beo.nat = j;
        com_tencent_mm_protocal_c_beo.mqT = j2;
        com_tencent_mm_protocal_c_beo.mNN = System.currentTimeMillis();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneVoipCSHeartBeat", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 795;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
