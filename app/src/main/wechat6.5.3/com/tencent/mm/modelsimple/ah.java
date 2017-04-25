package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.agr;
import com.tencent.mm.protocal.c.ags;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class ah extends k implements j {
    private final b cif;
    private e cii;

    public ah(int i) {
        a aVar = new a();
        aVar.czn = new agr();
        aVar.czo = new ags();
        aVar.uri = "/cgi-bin/micromsg-bin/logoutwebwx";
        aVar.czm = 281;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((agr) this.cif.czk.czs).lZm = i;
    }

    public final int getType() {
        return 281;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.NetSceneWebWXLogout", "doScene");
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            v.d("MicroMsg.NetSceneWebWXLogout", "logout Error. ");
        }
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
