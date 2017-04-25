package com.tencent.mm.plugin.chatroom.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.uu;
import com.tencent.mm.protocal.c.uv;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class h extends k implements j {
    public String biB;
    private final b cif;
    private e cii = null;
    public String eOP;
    public int eOQ;
    public int eOR;
    public int status;

    public h(String str) {
        a aVar = new a();
        aVar.czn = new uu();
        aVar.czo = new uv();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroomupgradestatus";
        aVar.czm = 519;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.biB = str;
        ((uu) this.cif.czk.czs).moN = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 519;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        uv uvVar = (uv) this.cif.czl.czs;
        v.d("MicroMsg.NetSceneGetChatRoomUpgradeStatus", "NetSceneGetChatRoomUpgradeStatus onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.status = uvVar.eeO;
        this.eOP = uvVar.mxz;
        this.eOR = uvVar.mxA;
        this.eOP = uvVar.mxz;
        this.eOQ = uvVar.mxy;
        this.cii.a(i2, i3, str, this);
    }
}
