package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.jl;
import com.tencent.mm.protocal.c.jm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    private b cif;
    private e cii;

    public a(String str, String str2) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new jl();
        aVar.czo = new jm();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/channelpkginfo";
        aVar.czm = 1210;
        this.cif = aVar.Bv();
        jl jlVar = (jl) this.cif.czk.czs;
        jlVar.mlR = str2;
        jlVar.mlO = str;
        jlVar.mlS = be.buw();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return this.cif.czm;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
