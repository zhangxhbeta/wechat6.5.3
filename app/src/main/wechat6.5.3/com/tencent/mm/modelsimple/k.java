package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.or;
import com.tencent.mm.protocal.c.os;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class k extends com.tencent.mm.v.k implements j {
    private final b cif;
    private e cii;

    public k(String str, int i, String str2) {
        v.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", str, Integer.valueOf(i), str2);
        a aVar = new a();
        aVar.czn = new or();
        aVar.czo = new os();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/entertempsession";
        this.cif = aVar.Bv();
        String str3 = SQLiteDatabase.KeyEmpty;
        if (str2 == null) {
            str2 = str3;
        } else if (str2.length() > 32) {
            str2 = str2.substring(0, 32);
        }
        or orVar = (or) this.cif.czk.czs;
        orVar.mhz = str;
        orVar.mcP = i;
        orVar.mqX = com.tencent.mm.ba.b.Ir(str2);
        orVar.moV = com.tencent.mm.ba.b.aT(new byte[0]);
        v.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", str, Integer.valueOf(i), Integer.valueOf(orVar.moV.lVU.length));
    }

    public final int getType() {
        return 1066;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneEnterTempSession", "onGYNetEnd: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.cii.a(i2, i3, str, this);
    }
}
