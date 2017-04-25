package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bey;
import com.tencent.mm.protocal.c.bez;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class f extends k implements j {
    public b cif;
    private e cii;

    public f(long j, long j2, int i) {
        a aVar = new a();
        aVar.czn = new bey();
        aVar.czo = new bez();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipsync";
        aVar.czm = 818;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        bey com_tencent_mm_protocal_c_bey = (bey) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bey.nat = j;
        com_tencent_mm_protocal_c_bey.mqT = j2;
        com_tencent_mm_protocal_c_bey.naB = i;
        com_tencent_mm_protocal_c_bey.mNN = System.currentTimeMillis();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneVoipCSSync", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 818;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
