package com.tencent.mm.ap;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.zc;
import com.tencent.mm.protocal.c.zd;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c extends k implements j {
    public String cZU;
    private b cif;
    private e cii;

    public c(String str, String str2) {
        a aVar = new a();
        aVar.czn = new zc();
        aVar.czo = new zd();
        aVar.uri = "/cgi-bin/micromsg-bin/getsoterfingerprintticket";
        aVar.czm = 247;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        zc zcVar = (zc) this.cif.czk.czs;
        zcVar.mAM = str;
        zcVar.mAN = str2;
        zcVar.maG = 247;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            this.cZU = ((zd) this.cif.czl.czs).mpB;
        }
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 247;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
