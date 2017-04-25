package com.tencent.mm.plugin.freewifi.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bf;
import com.tencent.mm.protocal.c.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class i extends k implements j {
    private String bmJ;
    private final b cif;
    private e cii;

    private i() {
        a aVar = new a();
        aVar.czn = new bf();
        aVar.czo = new bg();
        aVar.uri = "/cgi-bin/mmo2o-bin/addcontact";
        aVar.czm = 1703;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public i(String str, String str2, int i, String str3) {
        this();
        this.bmJ = str;
        bf bfVar = (bf) this.cif.czk.czs;
        bfVar.mbH = str;
        bfVar.glb = str2;
        bfVar.lZo = i;
        bfVar.lZp = str3;
        v.i("MicroMsg.FreeWifi.NetSceneAddContact", "appid = %s", new Object[]{str});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.FreeWifi.NetSceneAddContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, this.bmJ});
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1703;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
