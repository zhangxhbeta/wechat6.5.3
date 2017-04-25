package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.s;
import com.tencent.mm.protocal.c.t;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class i extends k implements j {
    private e cii;
    private b dsK;
    private s dsV;
    public t dsW;

    public i(String str, int i, String str2) {
        a aVar = new a();
        aVar.czn = new s();
        aVar.czo = new t();
        aVar.czm = 1695;
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerydetail";
        aVar.czp = 0;
        aVar.czq = 0;
        this.dsK = aVar.Bv();
        this.dsV = (s) this.dsK.czk.czs;
        this.dsV.lYw = str;
        this.dsV.scene = i;
        this.dsV.lYx = str2;
        v.i("MicroMsg.NetSceneAAQueryDetail", "NetSceneAAQueryDetail, billNo: %s, scene: %s, groupId: %s", new Object[]{str, Integer.valueOf(i), str2});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneAAQueryDetail", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.dsW = (t) ((b) pVar).czl.czs;
        v.i("MicroMsg.NetSceneAAQueryDetail", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.dsW.hKq), this.dsW.hKr});
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1695;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.NetSceneAAQueryDetail", "doScene");
        this.cii = eVar2;
        return a(eVar, this.dsK, this);
    }
}
