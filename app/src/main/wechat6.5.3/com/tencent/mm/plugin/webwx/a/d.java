package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.pl;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class d extends k implements j {
    private final b cQA;
    private e cii;

    public d(String str, String str2) {
        a aVar = new a();
        pl plVar = new pl();
        pm pmVar = new pm();
        aVar.czn = plVar;
        aVar.czo = pmVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
        aVar.czm = 972;
        aVar.czp = 0;
        aVar.czq = 0;
        plVar.mre = str;
        plVar.mrn = str2;
        this.cQA = aVar.Bv();
    }

    public final int getType() {
        return 972;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cii.a(i2, i3, str, this);
    }
}
