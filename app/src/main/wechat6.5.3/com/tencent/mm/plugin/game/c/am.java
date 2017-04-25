package com.tencent.mm.plugin.game.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.d.aa;
import com.tencent.mm.plugin.game.d.z;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class am extends k implements j {
    private e cii;
    public final b fut;

    public am(String str, String str2, boolean z) {
        a aVar = new a();
        aVar.czn = new z();
        aVar.czo = new aa();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetgamedetail";
        aVar.czm = 1217;
        aVar.czp = 0;
        aVar.czq = 0;
        this.fut = aVar.Bv();
        z zVar = (z) this.fut.czk.czs;
        zVar.glC = str;
        zVar.gkz = str2;
        zVar.glD = z;
        zVar.glF = true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.fut, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetGameDetailNew", "errType = " + i2 + ", errCode = " + i3);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1217;
    }
}
