package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.beu;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class d extends k implements j {
    public b cif;
    private e cii;

    public d(long j, long j2) {
        a aVar = new a();
        aVar.czn = new bet();
        aVar.czo = new beu();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipredirect";
        aVar.czm = 285;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        bet com_tencent_mm_protocal_c_bet = (bet) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bet.nat = j;
        com_tencent_mm_protocal_c_bet.mqT = j2;
        com_tencent_mm_protocal_c_bet.mNN = System.currentTimeMillis();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneVoipCSRedirect", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 285;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
