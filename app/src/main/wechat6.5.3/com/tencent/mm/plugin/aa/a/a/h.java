package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.n;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class h extends k implements j {
    private e cii;
    private b dsK;
    private n dsT;
    public o dsU;

    public h(String str, long j, int i, String str2) {
        a aVar = new a();
        aVar.czn = new n();
        aVar.czo = new o();
        aVar.czm = 1629;
        aVar.uri = "/cgi-bin/mmpay-bin/newaapay";
        aVar.czp = 0;
        aVar.czq = 0;
        this.dsK = aVar.Bv();
        this.dsT = (n) this.dsK.czk.czs;
        this.dsT.lYw = str;
        this.dsT.lYM = j;
        this.dsT.scene = i;
        this.dsT.lYx = str2;
        v.i("MicroMsg.NetSceneAAPay", "NetSceneAAPay, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s", new Object[]{this.dsT.lYw, Long.valueOf(this.dsT.lYM), Integer.valueOf(this.dsT.scene), this.dsT.lYx});
    }

    public final int getType() {
        return 1629;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.dsK, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneAAPay", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.dsU = (o) ((b) pVar).czl.czs;
        v.i("MicroMsg.NetSceneAAPay", "retcode: %s, retmsg: %s, paymsgid:%s", new Object[]{Integer.valueOf(this.dsU.hKq), this.dsU.hKr, this.dsU.blS});
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
