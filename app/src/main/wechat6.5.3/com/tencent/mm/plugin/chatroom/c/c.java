package com.tencent.mm.plugin.chatroom.c;

import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ur;
import com.tencent.mm.v.a;
import com.tencent.mm.v.b;

public final class c extends a<ur> {
    public c(String str) {
        b.a aVar = new b.a();
        uq uqVar = new uq();
        uqVar.moN = str;
        aVar.czn = uqVar;
        aVar.czo = new ur();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroominfodetail";
        aVar.czm = 223;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }
}
