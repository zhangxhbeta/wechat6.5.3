package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.l;
import com.tencent.mm.protocal.c.m;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class g extends k implements j {
    private e cii;
    private b dsK;
    private l dsR;
    public m dsS;

    public g() {
        a aVar = new a();
        aVar.czn = new l();
        aVar.czo = new m();
        aVar.czm = 1698;
        aVar.uri = "/cgi-bin/mmpay-bin/newaaoperation";
        aVar.czp = 0;
        aVar.czq = 0;
        this.dsK = aVar.Bv();
        this.dsR = (l) this.dsK.czk.czs;
    }

    public final int getType() {
        return 1698;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.dsK, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneAAOperation", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.dsS = (m) ((b) pVar).czl.czs;
        if (i2 == 0 && i3 == 0) {
            v.i("MicroMsg.NetSceneAAOperation", "retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[]{Integer.valueOf(this.dsS.hKq), this.dsS.hKr, Integer.valueOf(this.dsS.lYH), Integer.valueOf(this.dsS.lYI), Integer.valueOf(this.dsS.lYJ), Long.valueOf(this.dsS.lYK), Long.valueOf(this.dsS.lYL), this.dsS.hbX, this.dsS.irN});
        }
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
