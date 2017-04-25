package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.atv;
import com.tencent.mm.protocal.c.atw;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class ac extends k implements j {
    private final b cif;
    private e cii;

    public ac(String str) {
        a aVar = new a();
        aVar.czn = new atv();
        aVar.czo = new atw();
        aVar.uri = "/cgi-bin/micromsg-bin/newsetemailpwd";
        this.cif = aVar.Bv();
        ((atv) this.cif.czk.czs).mgI = be.KE(str);
        v.d("MicroMsg.NetSceneSetEmailPwd", "md5 " + str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 382;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneSetEmailPwd", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.cii.a(i2, i3, str, this);
    }
}
