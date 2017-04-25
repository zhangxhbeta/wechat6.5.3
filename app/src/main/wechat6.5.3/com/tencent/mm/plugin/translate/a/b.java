package com.tencent.mm.plugin.translate.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bae;
import com.tencent.mm.protocal.c.baf;
import com.tencent.mm.protocal.c.zq;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class b extends k implements j {
    private final com.tencent.mm.v.b cif;
    private e cii = null;
    public LinkedList<baf> knM;

    public b(LinkedList<bae> linkedList) {
        a aVar = new a();
        aVar.czn = new zq();
        aVar.czo = new zr();
        aVar.uri = "/cgi-bin/micromsg-bin/gettranstext";
        aVar.czm = 631;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        zq zqVar = (zq) this.cif.czk.czs;
        zqVar.mBf = linkedList;
        zqVar.ees = linkedList.size();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 631;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        zr zrVar = (zr) this.cif.czl.czs;
        this.cii.a(i2, i3, str, this);
        this.knM = zrVar.mBf;
    }
}
