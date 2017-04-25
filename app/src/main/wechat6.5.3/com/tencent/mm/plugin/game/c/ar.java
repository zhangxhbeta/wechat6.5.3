package com.tencent.mm.plugin.game.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.arx;
import com.tencent.mm.protocal.c.ary;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class ar extends k implements j {
    private e cii;
    final b fut;

    public ar(int i, int i2) {
        v.i("MicroMsg.NetSceneSearchGameList", "offset: %d, limit: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        a aVar = new a();
        aVar.czn = new arx();
        aVar.czo = new ary();
        aVar.uri = "/cgi-bin/mmgame-bin/searchgamelist";
        aVar.czm = 1215;
        aVar.czp = 0;
        aVar.czq = 0;
        this.fut = aVar.Bv();
        arx com_tencent_mm_protocal_c_arx = (arx) this.fut.czk.czs;
        com_tencent_mm_protocal_c_arx.gmn = i;
        com_tencent_mm_protocal_c_arx.gmo = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.fut, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneSearchGameList", "errType = " + i2 + ", errCode = " + i3);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1215;
    }
}
