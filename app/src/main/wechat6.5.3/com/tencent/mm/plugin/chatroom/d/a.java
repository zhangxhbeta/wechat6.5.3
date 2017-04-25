package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bo.b;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;

public final class a implements b {
    public final void a(com.tencent.mm.v.d.a aVar) {
        int i = 1;
        bm bmVar = aVar.czu;
        if (bmVar.gll == 10002) {
            String a = m.a(bmVar.mbW);
            if (be.kS(a)) {
                v.w("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "msg content is null");
                return;
            }
            String a2 = m.a(bmVar.mbU);
            ak.yW();
            at S = c.wJ().S(a2, bmVar.mcb);
            if (S.field_msgId <= 0) {
                i = 0;
            }
            S.y(bmVar.mcb);
            S.z(aw.h(a2, (long) bmVar.hNS));
            S.setType(10002);
            S.setContent(a);
            S.di(0);
            S.cH(a2);
            S.cN(bmVar.mbZ);
            S.ds(S.bNn & -49);
            aw.a(S, aVar);
            if (i == 0) {
                aw.e(S);
                return;
            }
            ak.yW();
            c.wJ().b(bmVar.mcb, S);
            return;
        }
        v.i("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "not new xml type:%d ", new Object[]{Integer.valueOf(bmVar.gll)});
    }
}
