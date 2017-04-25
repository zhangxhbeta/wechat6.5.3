package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bax;
import com.tencent.mm.protocal.c.bay;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class y extends k implements j {
    private String aRh;
    private String aZN;
    public String bLc;
    private b cif;
    private e cii;
    private int fuE = 0;

    public y(String str, String str2, String str3) {
        this.bLc = str3;
        this.aRh = str;
        this.aZN = str2;
    }

    public final int getType() {
        return 1263;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        a aVar = new a();
        aVar.czn = new bax();
        aVar.czo = new bay();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/updatemydeviceattr";
        aVar.czm = 1263;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        bax com_tencent_mm_protocal_c_bax = (bax) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bax.bLc = this.bLc;
        com_tencent_mm_protocal_c_bax.hKI = this.aRh;
        com_tencent_mm_protocal_c_bax.devicetype = this.aZN;
        com_tencent_mm_protocal_c_bax.mXl = this.fuE;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cii.a(i2, i3, str, this);
    }
}
