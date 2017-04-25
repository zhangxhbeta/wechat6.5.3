package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.wo;
import com.tencent.mm.protocal.c.wp;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c extends k implements j {
    public final b dcy;
    private e hZG;

    public c() {
        a aVar = new a();
        aVar.czn = new wo();
        aVar.czo = new wp();
        aVar.uri = "/cgi-bin/micromsg-bin/getimunreadmsgcount";
        aVar.czm = 630;
        aVar.czp = 0;
        aVar.czq = 0;
        this.dcy = aVar.Bv();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetImUnreadMsgCount", "end get im unread msg count, errType: %d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.hZG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 630;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.NetSceneGetImUnreadMsgCount", "get im unread msg count");
        this.hZG = eVar2;
        return a(eVar, this.dcy, this);
    }
}
