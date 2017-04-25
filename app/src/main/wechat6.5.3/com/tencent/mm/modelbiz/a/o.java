package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.tf;
import com.tencent.mm.protocal.c.tg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class o extends k implements j {
    boolean cEk = false;
    public b cif;
    private e cii;

    public o(String str, String str2, boolean z) {
        a aVar = new a();
        aVar.czn = new tf();
        aVar.czo = new tg();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatinfo";
        aVar.czm = 1352;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        tf tfVar = (tf) this.cif.czk.czs;
        tfVar.mhD = str;
        tfVar.mhJ = str2;
        this.cEk = z;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.brandservice.NetSceneGetBizChatInfo", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1352;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.brandservice.NetSceneGetBizChatInfo", "do scene");
        return a(eVar, this.cif, this);
    }
}
