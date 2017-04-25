package com.tencent.mm.t;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bji;
import com.tencent.mm.protocal.c.bjj;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class g extends k implements j {
    public final b cxe;
    private e cxf;

    public g(String str) {
        a aVar = new a();
        aVar.czn = new bji();
        aVar.czo = new bjj();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxatmplcomplaint";
        this.cxe = aVar.Bv();
        ((bji) this.cxe.czk.czs).ndP = str;
    }

    public final int getType() {
        return 1198;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.cxf != null) {
            this.cxf.a(i2, i3, str, this);
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
        this.cxf = eVar2;
        return a(eVar, this.cxe, this);
    }
}
