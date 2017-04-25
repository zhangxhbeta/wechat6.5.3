package com.tencent.mm.t;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ayy;
import com.tencent.mm.protocal.c.fq;
import com.tencent.mm.protocal.c.fr;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class d extends k implements j {
    private final b cxe;
    private e cxf;

    public d(LinkedList<ayy> linkedList) {
        a aVar = new a();
        aVar.czn = new fq();
        aVar.czo = new fr();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchswitchservicenotifyoption";
        this.cxe = aVar.Bv();
        ((fq) this.cxe.czk.czs).mgc = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.cxf != null) {
            this.cxf.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1176;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "doScene");
        this.cxf = eVar2;
        return a(eVar, this.cxe, this);
    }
}
