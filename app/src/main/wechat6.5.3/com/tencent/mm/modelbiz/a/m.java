package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.lr;
import com.tencent.mm.protocal.c.ls;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class m extends k implements j {
    public String cEj;
    public b cif;
    private e cii;
    Object data;

    public m(String str, String str2, String str3, Object obj) {
        a aVar = new a();
        aVar.czn = new lr();
        aVar.czo = new ls();
        aVar.uri = "/cgi-bin/mmocbiz-bin/convertbizchat";
        this.cif = aVar.Bv();
        lr lrVar = (lr) this.cif.czk.czs;
        lrVar.mop = str;
        lrVar.mor = str2;
        lrVar.moq = str3;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneConvertBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1315;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.NetSceneConvertBizChat", "do scene");
        return a(eVar, this.cif, this);
    }

    public final ls DQ() {
        if (this.cif == null || this.cif.czl.czs == null) {
            return null;
        }
        return (ls) this.cif.czl.czs;
    }
}
