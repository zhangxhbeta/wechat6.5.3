package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.protocal.c.p;
import com.tencent.mm.protocal.c.q;
import com.tencent.pb.common.c.c;

public final class a extends com.tencent.mm.v.a<q> {
    public a(String str, String str2, int i) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        p pVar = new p();
        pVar.lYw = str;
        pVar.lYx = str2;
        pVar.scene = i;
        aVar.czn = pVar;
        aVar.czo = new q();
        aVar.uri = "/cgi-bin/mmpay-bin/newaapayurge";
        aVar.czm = 1644;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        c.h("MicroMsg.CgiAAPayUrge", new Object[]{"CgiAAPayUrge, billNo: %s, chatroom: %s, scene: %s", str, str2, Integer.valueOf(i)});
    }
}
