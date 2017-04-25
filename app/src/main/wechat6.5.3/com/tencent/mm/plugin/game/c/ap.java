package com.tencent.mm.plugin.game.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.ag;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class ap extends k implements j {
    private e cii;
    public final b fut;

    public ap(int i, int i2, int i3) {
        v.i("MicroMsg.NetSceneGetMoreGameList", "offset: %d, limit: %d, type: %d, cat: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(15), Integer.valueOf(i2), Integer.valueOf(i3)});
        a aVar = new a();
        aVar.czn = new af();
        aVar.czo = new ag();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetmoregamelist";
        aVar.czm = 1220;
        aVar.czp = 0;
        aVar.czq = 0;
        this.fut = aVar.Bv();
        af afVar = (af) this.fut.czk.czs;
        afVar.gmn = i;
        afVar.gmo = 15;
        afVar.glC = u.bsY();
        afVar.gmv = i2;
        afVar.gmw = i3;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.fut, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetMoreGameList", "errType = " + i2 + ", errCode = " + i3);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1220;
    }
}
