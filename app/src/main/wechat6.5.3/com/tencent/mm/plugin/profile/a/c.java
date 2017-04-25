package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ays;
import com.tencent.mm.protocal.c.ayt;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c extends k implements j {
    public b cif;
    private e cii;

    public c(String str, boolean z) {
        a aVar = new a();
        aVar.czn = new ays();
        aVar.czo = new ayt();
        aVar.uri = "/cgi-bin/mmocbiz-bin/switchbrand";
        this.cif = aVar.Bv();
        ays com_tencent_mm_protocal_c_ays = (ays) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ays.mhJ = str;
        com_tencent_mm_protocal_c_ays.mVW = z;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.brandservice.NetSceneSwitchBrand", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1394;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.brandservice.NetSceneSwitchBrand", "do scene");
        return a(eVar, this.cif, this);
    }

    public final ayt aGz() {
        if (this.cif == null || this.cif.czl.czs == null) {
            return null;
        }
        return (ayt) this.cif.czl.czs;
    }

    public final ays aGA() {
        if (this.cif == null || this.cif.czk.czs == null) {
            return null;
        }
        return (ays) this.cif.czk.czs;
    }
}
