package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.atd;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class ab extends k implements j {
    private final b cif;
    private e cii;

    public ab(String str) {
        a aVar = new a();
        aVar.czn = new atd();
        aVar.czo = new ate();
        aVar.uri = "/cgi-bin/micromsg-bin/sendverifyemail";
        aVar.czm = 108;
        aVar.czp = 43;
        aVar.czq = 1000000043;
        this.cif = aVar.Bv();
        ((atd) this.cif.czk.czs).moM = new arf().JF(str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 108;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cii.a(i2, i3, str, this);
    }
}
