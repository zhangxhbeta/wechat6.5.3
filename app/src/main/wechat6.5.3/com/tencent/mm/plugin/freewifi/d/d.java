package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.protocal.c.kd;
import com.tencent.mm.protocal.c.ke;
import com.tencent.mm.v.b.a;

public final class d extends c {
    protected final void apq() {
        a aVar = new a();
        aVar.czn = new kd();
        aVar.czo = new ke();
        aVar.uri = "/cgi-bin/mmo2o-bin/checkifcallup";
        aVar.czm = 1155;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final int getType() {
        return 1155;
    }

    public d(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7) {
        apq();
        kd kdVar = (kd) this.cif.czk.czs;
        kdVar.mmD = str;
        kdVar.mmE = str2;
        kdVar.mmF = str3;
        kdVar.mmG = str4;
        kdVar.mmH = str5;
        kdVar.mmI = j;
        kdVar.mmJ = str6;
        kdVar.mmK = str7;
    }

    public final ke apy() {
        return (ke) this.cif.czl.czs;
    }
}
