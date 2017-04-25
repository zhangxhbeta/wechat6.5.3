package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.gz;
import com.tencent.mm.protocal.c.ha;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class l extends k implements j {
    public b cif;
    private e cii;
    private Object data;

    public l(String str, String str2, int i) {
        a aVar = new a();
        aVar.czn = new gz();
        aVar.czo = new ha();
        aVar.uri = "/cgi-bin/mmocbiz-bin/bizchatsearchcontact";
        this.cif = aVar.Bv();
        gz gzVar = (gz) this.cif.czk.czs;
        gzVar.mhJ = str;
        gzVar.aXp = str2;
        gzVar.offset = i;
        this.data = null;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneBizChatSearchContact", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1364;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.NetSceneBizChatSearchContact", "do scene");
        return a(eVar, this.cif, this);
    }
}
