package com.tencent.mm.plugin.game.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.re;
import com.tencent.mm.protocal.c.rf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class ak extends k implements j {
    public String aXp;
    private e cii;
    public final b fut;

    public ak(String str, String str2, LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.czn = new re();
        aVar.czo = new rf();
        aVar.uri = "/cgi-bin/mmgame-bin/gamecentersearchrecommend";
        aVar.czm = 1329;
        aVar.czp = 0;
        aVar.czq = 0;
        if (str2 == null) {
            this.aXp = "";
        } else {
            this.aXp = str2.trim();
        }
        this.fut = aVar.Bv();
        re reVar = (re) this.fut.czk.czs;
        reVar.glC = str;
        reVar.muW = str2;
        reVar.muX = linkedList;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.fut, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGameSearchRecmd", "errType = " + i2 + ", errCode = " + i3);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1329;
    }
}
