package com.tencent.mm.t;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.yu;
import com.tencent.mm.protocal.c.yv;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;

public final class e extends k implements j {
    public final b cxe;
    private com.tencent.mm.v.e cxf;

    public e(int i) {
        a aVar = new a();
        aVar.czn = new yu();
        aVar.czo = new yv();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getservicenotifyoptions";
        this.cxe = aVar.Bv();
        ((yu) this.cxe.czk.czs).mAJ = i;
    }

    public final yv AH() {
        if (this.cxe == null) {
            return null;
        }
        return (yv) this.cxe.czl.czs;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.cxf != null) {
            this.cxf.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1145;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        v.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
        this.cxf = eVar2;
        return a(eVar, this.cxe, this);
    }
}
