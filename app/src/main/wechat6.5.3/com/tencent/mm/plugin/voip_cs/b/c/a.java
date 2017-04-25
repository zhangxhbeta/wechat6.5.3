package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.protocal.c.ben;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    public b cif;
    private e cii;

    public a(int i, long j, long j2, String str, int i2) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new bem();
        aVar.czo = new ben();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoiphangup";
        aVar.czm = 880;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        bem com_tencent_mm_protocal_c_bem = (bem) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bem.mNO = i;
        com_tencent_mm_protocal_c_bem.nat = j;
        com_tencent_mm_protocal_c_bem.mqT = j2;
        com_tencent_mm_protocal_c_bem.nau = str;
        com_tencent_mm_protocal_c_bem.mvF = i2;
        com_tencent_mm_protocal_c_bem.mNN = System.currentTimeMillis();
    }

    public final int getType() {
        return 880;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneVoipCSHangUp", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cii.a(i2, i3, str, this);
    }
}
