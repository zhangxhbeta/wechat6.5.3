package com.tencent.mm.plugin.game.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.rh;
import com.tencent.mm.protocal.c.ri;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class aj extends k implements j {
    private e cii;
    public final b fut;

    public aj(String str, LinkedList<String> linkedList, LinkedList<String> linkedList2) {
        a aVar = new a();
        aVar.czn = new rh();
        aVar.czo = new ri();
        aVar.uri = "/cgi-bin/mmgame-bin/gamecentersearch";
        aVar.czm = 1328;
        aVar.czp = 0;
        aVar.czq = 0;
        this.fut = aVar.Bv();
        rh rhVar = (rh) this.fut.czk.czs;
        rhVar.glC = str;
        rhVar.mve = linkedList;
        rhVar.muX = linkedList2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.fut, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGameCenterSearch", "errType = " + i2 + ", errCode = " + i3);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1328;
    }
}
