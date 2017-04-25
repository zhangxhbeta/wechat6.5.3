package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class d extends k implements j {
    private e cii;
    private b dsK;
    private com.tencent.mm.protocal.c.d dsL;
    public com.tencent.mm.protocal.c.e dsM;
    public int scene;

    public d(String str, int i, String str2) {
        a aVar = new a();
        aVar.czn = new com.tencent.mm.protocal.c.d();
        aVar.czo = new com.tencent.mm.protocal.c.e();
        aVar.czm = 1530;
        aVar.uri = "/cgi-bin/mmpay-bin/newaaclose";
        aVar.czp = 0;
        aVar.czq = 0;
        this.dsK = aVar.Bv();
        this.dsL = (com.tencent.mm.protocal.c.d) this.dsK.czk.czs;
        this.dsL.lYx = str2;
        this.dsL.lYw = str;
        this.dsL.scene = i;
        this.scene = i;
        v.d("MicroMsg.NetSceneAAClose", "NetSceneAAClose, billNo: %s, scene: %s", new Object[]{this.dsL.lYw, Integer.valueOf(i)});
    }

    public final int getType() {
        return 1530;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.NetSceneAAClose", "doScene");
        this.cii = eVar2;
        return a(eVar, this.dsK, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneAAClose", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.dsM = (com.tencent.mm.protocal.c.e) ((b) pVar).czl.czs;
        v.i("MicroMsg.NetSceneAAClose", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.dsM.hKq), this.dsM.hKr});
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
