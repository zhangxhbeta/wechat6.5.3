package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.lw;
import com.tencent.mm.protocal.c.lx;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class n extends k implements j {
    public b cif;
    private e cii;
    Object data;

    public n(String str, ra raVar, Object obj) {
        a aVar = new a();
        aVar.czn = new lw();
        aVar.czo = new lx();
        aVar.uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
        this.cif = aVar.Bv();
        lw lwVar = (lw) this.cif.czk.czs;
        lwVar.mhJ = str;
        lwVar.moz = raVar;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1355;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
        return a(eVar, this.cif, this);
    }

    public final lx DR() {
        if (this.cif == null || this.cif.czl.czs == null) {
            return null;
        }
        return (lx) this.cif.czl.czs;
    }

    public final lw DS() {
        if (this.cif == null || this.cif.czk.czs == null) {
            return null;
        }
        return (lw) this.cif.czk.czs;
    }
}
