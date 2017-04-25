package com.tencent.mm.plugin.game.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.d.x;
import com.tencent.mm.plugin.game.d.y;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class aq extends k implements j {
    private e cii;
    private final b fut;

    public aq(String str, int i, int i2, String str2, String str3) {
        a aVar = new a();
        aVar.czn = new x();
        aVar.czo = new y();
        aVar.uri = "/cgi-bin/mmgame-bin/gamereport";
        aVar.czm = 1223;
        aVar.czp = 0;
        aVar.czq = 0;
        this.fut = aVar.Bv();
        x xVar = (x) this.fut.czk.czs;
        xVar.gkz = str;
        xVar.gly = i;
        xVar.glz = i2;
        xVar.glA = str2;
        xVar.glB = str3;
        xVar.glx = (int) (System.currentTimeMillis() / 1000);
    }

    public final int getType() {
        return 1223;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.fut, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetGameIndex", "errType = " + i2 + ", errCode = " + i3);
        this.cii.a(i2, i3, str, this);
    }
}
