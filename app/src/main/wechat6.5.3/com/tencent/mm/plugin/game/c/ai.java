package com.tencent.mm.plugin.game.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.d.u;
import com.tencent.mm.plugin.game.d.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class ai extends k implements j {
    private e cii;
    public final b fut;

    public ai(String str) {
        this(str, 0, 0);
    }

    public ai(String str, int i, int i2) {
        a aVar = new a();
        aVar.czn = new u();
        aVar.czo = new v();
        aVar.uri = "/cgi-bin/mmgame-bin/gamemsgblock";
        aVar.czm = 1221;
        aVar.czp = 0;
        aVar.czq = 0;
        this.fut = aVar.Bv();
        u uVar = (u) this.fut.czk.czs;
        uVar.gkz = str;
        uVar.glu = i;
        uVar.glv = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.fut, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneGameMsgBlock", "errType = " + i2 + ", errCode = " + i3);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1221;
    }
}
