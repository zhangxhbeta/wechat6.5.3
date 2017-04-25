package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.protocal.c.u;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.v.a;

public final class b extends a<v> {
    public b(int i, int i2) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        u uVar = new u();
        uVar.aGx = i;
        uVar.offset = i2;
        aVar.czn = uVar;
        aVar.czo = new v();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
        aVar.czm = 1676;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(1)});
    }
}
