package com.tencent.mm.plugin.setting.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.zs;
import com.tencent.mm.protocal.c.zt;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c extends k implements j {
    private e cii;

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.czG = i;
        if (!(i2 == 0 && i3 == 0)) {
            v.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 869;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        a aVar = new a();
        aVar.czn = new zs();
        aVar.czo = new zt();
        aVar.uri = "/cgi-bin/micromsg-bin/gettrustedfriends";
        aVar.czm = 869;
        aVar.czp = 0;
        aVar.czp = 0;
        return a(eVar, aVar.Bv(), this);
    }
}
