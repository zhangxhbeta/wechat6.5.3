package com.tencent.mm.plugin.game.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.d.ad;
import com.tencent.mm.plugin.game.d.ae;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class ao extends k implements j {
    private e cii;
    public final b fut;

    public ao(int i, LinkedList<String> linkedList, int i2, boolean z) {
        a aVar = new a();
        aVar.czn = new ad();
        aVar.czo = new ae();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetlibgamelist";
        aVar.czm = 1218;
        aVar.czp = 0;
        aVar.czq = 0;
        this.fut = aVar.Bv();
        ad adVar = (ad) this.fut.czk.czs;
        adVar.gmn = i;
        adVar.gmo = 15;
        adVar.glC = u.bsY();
        adVar.cHl = be.buo();
        adVar.gmp = i2;
        adVar.glQ = linkedList;
        adVar.gmq = z;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.fut, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetLibGameList", "errType = " + i2 + ", errCode = " + i3);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1218;
    }
}
