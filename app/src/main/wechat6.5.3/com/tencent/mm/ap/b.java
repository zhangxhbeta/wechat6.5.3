package com.tencent.mm.ap;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.gi;
import com.tencent.mm.protocal.c.gj;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;

public final class b extends e implements j {
    private com.tencent.mm.v.b cif;
    private e cii;

    public b(String str, String str2) {
        a aVar = new a();
        aVar.czn = new gi();
        aVar.czo = new gj();
        aVar.uri = "/cgi-bin/micromsg-bin/bindsoterfingerprintlogin";
        this.cif = aVar.Bv();
        gi giVar = (gi) this.cif.czk.czs;
        giVar.maG = 246;
        giVar.mhd = str2;
        giVar.mhc = str;
    }

    public final void b(int i, int i2, String str, p pVar) {
        if (this.cii != null) {
            this.cii.a(i, i2, str, this);
        }
    }

    public final e BH() {
        return this.cii;
    }

    public final void b(int i, int i2, String str) {
        if (this.cii != null) {
            this.cii.a(i, i2, str, this);
        }
    }

    public final int getType() {
        return 246;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
