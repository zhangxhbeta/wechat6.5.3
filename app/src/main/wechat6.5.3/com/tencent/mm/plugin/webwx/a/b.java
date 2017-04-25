package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.pf;
import com.tencent.mm.protocal.c.pg;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    private final com.tencent.mm.v.b cQA;
    private e cii;

    public b(String str) {
        a aVar = new a();
        pf pfVar = new pf();
        pg pgVar = new pg();
        aVar.czn = pfVar;
        aVar.czo = pgVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
        aVar.czm = 973;
        aVar.czp = 0;
        aVar.czq = 0;
        pfVar.mre = str;
        this.cQA = aVar.Bv();
    }

    public final int getType() {
        return 973;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cii.a(i2, i3, str, this);
    }
}
