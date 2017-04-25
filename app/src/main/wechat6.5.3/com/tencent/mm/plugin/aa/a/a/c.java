package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.v.a;
import com.tencent.mm.v.b;

public final class c extends a<com.tencent.mm.protocal.c.c> {
    public c(String str, String str2) {
        b.a aVar = new b.a();
        com.tencent.mm.protocal.c.b bVar = new com.tencent.mm.protocal.c.b();
        bVar.lYw = str;
        bVar.lYx = str2;
        aVar.czn = bVar;
        aVar.czo = new com.tencent.mm.protocal.c.c();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaclosenotify";
        aVar.czm = 1672;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        com.tencent.pb.common.c.c.h("MicroMsg.CgiCloseAAUrgeNotify", new Object[]{"CgiCloseAAUrgeNotify, billNo: %s, chatroom: %s", str, str2});
    }
}
