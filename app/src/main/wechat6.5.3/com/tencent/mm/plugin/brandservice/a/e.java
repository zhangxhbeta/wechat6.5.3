package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ahg;
import com.tencent.mm.protocal.c.ahh;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;

public final class e extends k implements j {
    public b cif;
    private com.tencent.mm.v.e cii;

    public e(String str) {
        a aVar = new a();
        aVar.czn = new ahg();
        aVar.czo = new ahh();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/getallrecvtmpmsgoption";
        aVar.czm = 1031;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((ahg) this.cif.czk.czs).mDK = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1031;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "do scene");
        return a(eVar, this.cif, this);
    }
}
