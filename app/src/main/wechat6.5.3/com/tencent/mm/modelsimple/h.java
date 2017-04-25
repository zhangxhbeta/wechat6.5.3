package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.kp;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class h extends k implements j {
    public static int cYs = 1;
    public static int cYt = 2;
    public static int cYu = 3;
    public static int cYv = 4;
    private b cif;
    private e cii;

    public h(int i) {
        a aVar = new a();
        aVar.czn = new kp();
        aVar.czo = new kq();
        aVar.uri = "/cgi-bin/micromsg-bin/checkunbind";
        this.cif = aVar.Bv();
        ((kp) this.cif.czk.czs).mnb = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final String IR() {
        try {
            String str = ((kq) this.cif.czl.czs).mnc;
            v.d("MicroMsg.NetSceneCheckUnBind", "getRandomPasswd() " + str);
            return str;
        } catch (Throwable e) {
            v.a("MicroMsg.NetSceneCheckUnBind", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }

    public final int getType() {
        return 254;
    }

    public final kq IS() {
        return (kq) this.cif.czl.czs;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cii.a(i2, i3, str, this);
    }
}
