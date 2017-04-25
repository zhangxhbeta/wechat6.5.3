package com.tencent.mm.plugin.game.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.d.bz;
import com.tencent.mm.plugin.game.d.ca;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class as extends k implements j {
    private e cii;
    public final b fut;

    public as(String str, String str2, String str3, boolean z) {
        a aVar = new a();
        aVar.czn = new bz();
        aVar.czo = new ca();
        aVar.uri = "/cgi-bin/mmgame-bin/newsubscribenewgame";
        aVar.czm = 1219;
        aVar.czp = 0;
        aVar.czq = 0;
        this.fut = aVar.Bv();
        bz bzVar = (bz) this.fut.czk.czs;
        bzVar.gkz = str;
        bzVar.glC = str2;
        bzVar.gkx = str3;
        bzVar.gkN = z;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.fut, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGameSubscription", "errType = " + i2 + ", errCode = " + i3);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1219;
    }
}
