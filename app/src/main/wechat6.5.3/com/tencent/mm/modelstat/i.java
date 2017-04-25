package com.tencent.mm.modelstat;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.vw;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class i extends k implements j {
    private e cxf;
    final b dcy;

    public i(com.tencent.mm.ba.b bVar) {
        a aVar = new a();
        com.tencent.mm.ba.a vwVar = new vw();
        vwVar.myw = bVar;
        aVar.czn = vwVar;
        aVar.czo = new vx();
        aVar.uri = "/cgi-bin/mmbiz-bin/geteventsampleconf";
        aVar.czm = 1126;
        aVar.czp = 0;
        aVar.czq = 0;
        this.dcy = aVar.Bv();
    }

    public final int getType() {
        return 1126;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.NetSceneUpdateEventConfig", "start update event config");
        this.czK = true;
        this.cxf = eVar2;
        return a(eVar, this.dcy, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneUpdateEventConfig", "onGYNetEnd errType: %d, errCode: %d, errMsg %s, IReqResp %s", Integer.valueOf(i2), Integer.valueOf(i3), str, pVar.toString());
        this.cxf.a(i2, i3, str, this);
    }
}
