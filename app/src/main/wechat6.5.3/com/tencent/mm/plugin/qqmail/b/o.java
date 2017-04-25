package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ayw;
import com.tencent.mm.protocal.c.ayx;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class o extends k implements j {
    public final boolean brc;
    private b cif;
    private e cii;
    private String ibj = "";

    public o(boolean z, String str) {
        this.brc = z;
        this.ibj = be.ma(str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        a aVar = new a();
        aVar.czn = new ayw();
        aVar.czo = new ayx();
        aVar.uri = "/cgi-bin/micromsg-bin/switchpushmail";
        aVar.czm = 129;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ayw com_tencent_mm_protocal_c_ayw = (ayw) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ayw.muS = this.brc ? 1 : 2;
        com_tencent_mm_protocal_c_ayw.mVY = this.ibj;
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final boolean Bz() {
        return true;
    }

    public final int getType() {
        return 24;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            ayx com_tencent_mm_protocal_c_ayx = (ayx) this.cif.czl.czs;
            ak.yW();
            c.vf().set(17, Integer.valueOf(com_tencent_mm_protocal_c_ayx.muS));
        }
        this.cii.a(i2, i3, str, this);
    }
}
