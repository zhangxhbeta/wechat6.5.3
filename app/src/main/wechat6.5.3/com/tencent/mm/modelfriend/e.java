package com.tencent.mm.modelfriend;

import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;

public final class e extends com.tencent.mm.model.e {
    protected final at a(bm bmVar, String str, String str2, String str3) {
        String a = m.a(bmVar.mbW);
        if (a == null || a.length() <= 0) {
            v.e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
            return null;
        }
        a My = a.My(a);
        if (be.ma(My.lct).length() > 0) {
            h hVar = new h();
            hVar.username = My.lct;
            hVar.bBY = 3;
            hVar.aP(true);
            hVar.cyD = My.nvI;
            hVar.cyC = My.nvJ;
            hVar.bkU = -1;
            v.d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", My.lct, hVar.Be(), hVar.Bf());
            n.Bo().a(hVar);
        }
        return super.a(bmVar, str, str2, str3);
    }
}
