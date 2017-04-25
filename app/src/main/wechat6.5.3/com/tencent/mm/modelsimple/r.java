package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yt;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class r extends k implements j {
    public final b cYO;
    private e cii;

    public r() {
        a aVar = new a();
        aVar.czn = new ys();
        aVar.czo = new yt();
        aVar.uri = "/cgi-bin/micromsg-bin/getresourcecontrolinfo";
        this.cYO = aVar.Bv();
        ((ys) this.cYO.czk.czs).efm = 0;
        v.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo type[%d], stack[%s]", Integer.valueOf(0), be.bur());
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            g.iuh.a(405, 2, 1, true);
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 725;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        g.iuh.a(405, 1, 1, true);
        return a(eVar, this.cYO, this);
    }
}
