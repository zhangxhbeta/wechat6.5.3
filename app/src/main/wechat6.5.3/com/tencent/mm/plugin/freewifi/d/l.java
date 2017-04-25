package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.protocal.c.atx;
import com.tencent.mm.protocal.c.aty;
import com.tencent.mm.v.b.a;

public final class l extends c {
    protected final void apq() {
        a aVar = new a();
        aVar.czn = new atx();
        aVar.czo = new aty();
        aVar.uri = "/cgi-bin/mmo2o-bin/setpcloginuserInfo";
        aVar.czm = 1761;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final int getType() {
        return 1761;
    }

    public l(String str, int i, String str2) {
        apq();
        atx com_tencent_mm_protocal_c_atx = (atx) this.cif.czk.czs;
        com_tencent_mm_protocal_c_atx.appId = str;
        com_tencent_mm_protocal_c_atx.gcx = i;
        com_tencent_mm_protocal_c_atx.bax = str2;
    }
}
