package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.akw;
import com.tencent.mm.protocal.c.akx;
import com.tencent.mm.protocal.c.bdz;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class a extends k implements j {
    private b cif;
    private e cii;

    public a(LinkedList<bdz> linkedList, int i) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new akw();
        aVar.czo = new akx();
        aVar.uri = "/cgi-bin/micromsg-bin/opvoicereminder";
        this.cif = aVar.Bv();
        akw com_tencent_mm_protocal_c_akw = (akw) this.cif.czk.czs;
        com_tencent_mm_protocal_c_akw.lZm = 1;
        com_tencent_mm_protocal_c_akw.mLL = linkedList;
        com_tencent_mm_protocal_c_akw.mLK = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 331;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cii.a(i2, i3, str, this);
    }
}
