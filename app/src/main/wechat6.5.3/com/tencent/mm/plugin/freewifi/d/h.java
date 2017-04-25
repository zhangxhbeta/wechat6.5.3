package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.protocal.c.qz;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.v.b.a;

public final class h extends c {
    protected final void apq() {
        a aVar = new a();
        aVar.czn = new xv();
        aVar.czo = new xw();
        aVar.uri = "/cgi-bin/mmo2o-bin/getpcfrontpage";
        aVar.czm = 1760;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final int getType() {
        return 1760;
    }

    public h(String str, int i, String str2) {
        apq();
        xv xvVar = (xv) this.cif.czk.czs;
        xvVar.appId = str;
        xvVar.gcx = i;
        xvVar.bax = str2;
    }

    public final qz apu() {
        xw xwVar = (xw) this.cif.czl.czs;
        if (xwVar != null) {
            return xwVar.lZA;
        }
        return null;
    }
}
