package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.wq;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.v.b.a;

public final class g extends c {
    protected final void apq() {
        a aVar = new a();
        aVar.czn = new wq();
        aVar.czo = new wr();
        aVar.uri = "/cgi-bin/mmo2o-bin/getprotocol31schemaurl";
        aVar.czm = 1746;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final int getType() {
        return 1746;
    }

    public g(String str, String str2, String str3) {
        apq();
        wq wqVar = (wq) this.cif.czk.czs;
        wqVar.fYL = str;
        wqVar.fYM = str2;
        wqVar.fYN = str3;
        wqVar.lZG = m.aoG();
    }

    public final String apA() {
        return ((wr) this.cif.czl.czs).myV;
    }
}
