package com.tencent.mm.ar;

import com.tencent.mm.e.a.er;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.e;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;

public final class d extends e {
    protected final at a(bm bmVar, String str, String str2, String str3) {
        String a = m.a(bmVar.mbW);
        if (a == null || a.length() <= 0) {
            v.e("MicroMsg.FMessageExtension", "possible friend msg : content is null");
        } else {
            a My = a.My(a);
            if (!(My.nvG == null && My.nvH == null) && (My.scene == 10 || My.scene == 11)) {
                b erVar = new er();
                erVar.bdp.bdr = My.nvG;
                erVar.bdp.bds = My.nvH;
                com.tencent.mm.sdk.c.a.nhr.z(erVar);
                if (erVar.bdq.bdt) {
                    v.v("MicroMsg.FMessageExtension", "possible mobile friend is not in local address book");
                }
            }
            if (My.hWq > 0) {
                com.tencent.mm.u.b.d(My.hWq, My.nvF);
            }
            if (be.ma(My.lct).length() > 0) {
                h hVar = new h();
                hVar.username = My.lct;
                hVar.bBY = 3;
                hVar.aP(true);
                hVar.bkU = -1;
                hVar.cyD = My.nvI;
                hVar.cyC = My.nvJ;
                hVar.bkU = -1;
                v.d("MicroMsg.FMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", My.lct, hVar.Be(), hVar.Bf());
                n.Bo().a(hVar);
            }
            f fVar = new f();
            fVar.field_createTime = e.h(str, (long) bmVar.hNS);
            fVar.field_isSend = 0;
            fVar.field_msgContent = m.a(bmVar.mbW);
            fVar.field_svrId = bmVar.mcb;
            fVar.field_talker = My.lct;
            fVar.field_type = 0;
            b kC = l.KD().kC(fVar.field_talker);
            if (kC != null) {
                v.d("MicroMsg.FMessageExtension", "getByEncryptTalker success. encryptTalker = " + fVar.field_talker + " , real talker = " + kC.field_talker);
                fVar.field_encryptTalker = fVar.field_talker;
                fVar.field_talker = kC.field_talker;
            }
            ak.yW();
            ab LX = c.wH().LX(fVar.field_talker);
            if (LX == null || !com.tencent.mm.i.a.ei(LX.field_type) || LX.chr <= 0) {
                l.KC().a(fVar);
            } else {
                v.d("MicroMsg.FMessageExtension", "The biz contact whose talker is " + fVar.field_talker + " has already been in user's contact list");
            }
        }
        return null;
    }
}
