package com.tencent.mm.s;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.fw;
import com.tencent.mm.protocal.c.fx;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    public static int cxb = 1;
    public static int cxc = 2;
    private b cif;
    private e cii;

    public a(int i, String str) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new fw();
        aVar.czo = new fx();
        aVar.uri = "/cgi-bin/micromsg-bin/bindemail";
        aVar.czm = 256;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        fw fwVar = (fw) this.cif.czk.czs;
        fwVar.lZm = i;
        fwVar.mgi = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 256;
    }

    public final int AG() {
        return ((fw) this.cif.czk.czs).lZm;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cii.a(i2, i3, str, this);
    }
}
