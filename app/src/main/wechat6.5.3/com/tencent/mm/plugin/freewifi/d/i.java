package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.protocal.c.xz;
import com.tencent.mm.protocal.c.ya;
import com.tencent.mm.v.b.a;

public final class i extends c {
    protected final void apq() {
        a aVar = new a();
        aVar.czn = new xz();
        aVar.czo = new ya();
        aVar.uri = "/cgi-bin/mmo2o-bin/getportalapinfo";
        aVar.czm = 1709;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final int getType() {
        return 1709;
    }

    public i(String str, String str2, String str3, String str4, String str5, String str6) {
        apq();
        xz xzVar = (xz) this.cif.czk.czs;
        xzVar.aYz = str;
        xzVar.fYL = str2;
        xzVar.fYM = str3;
        xzVar.fYN = str4;
        xzVar.bax = str5;
        xzVar.lZp = str6;
    }

    public final String apB() {
        return ((ya) this.cif.czl.czs).fZT;
    }

    public final String apC() {
        return ((ya) this.cif.czl.czs).fZU;
    }
}
