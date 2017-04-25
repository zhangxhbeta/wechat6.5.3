package com.tencent.mm.w;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bam;
import com.tencent.mm.protocal.c.ban;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    private com.tencent.mm.v.b cif;
    private e cii;

    public b(String str) {
        a aVar = new a();
        aVar.czn = new bam();
        aVar.czo = new ban();
        aVar.uri = "/cgi-bin/micromsg-bin/unbindqq";
        this.cif = aVar.Bv();
        ((bam) this.cif.czk.czs).mpB = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 253;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cii.a(i2, i3, str, this);
    }
}
