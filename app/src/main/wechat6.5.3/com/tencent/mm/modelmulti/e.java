package com.tencent.mm.modelmulti;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ws;
import com.tencent.mm.protocal.c.wt;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;

public final class e extends k implements j {
    public int cRc = 0;
    private b cif;
    private com.tencent.mm.v.e cii;
    public String content = "";
    public String title = "";

    public e(int i) {
        a aVar = new a();
        aVar.czn = new ws();
        aVar.czo = new wt();
        aVar.uri = "/cgi-bin/micromsg-bin/getinvitefriendsmsg";
        aVar.czm = 1803;
        this.cif = aVar.Bv();
        ((ws) this.cif.czk.czs).myW = i;
        this.cRc = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetInviteFriendsMsg", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            wt wtVar = (wt) this.cif.czl.czs;
            this.title = wtVar.myX;
            this.content = wtVar.myY;
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1803;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        v.d("MicroMsg.NetSceneGetInviteFriendsMsg", "doScene");
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
