package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.d;
import com.tencent.mm.v.d.b;
import java.util.Map;
import junit.framework.Assert;

public final class f implements d {

    public static final class a {
        String caJ;
        String content;

        private a() {
            this.caJ = "";
            this.content = "";
        }
    }

    public final b b(com.tencent.mm.v.d.a aVar) {
        bm bmVar = aVar.czu;
        if (bmVar == null) {
            v.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM is null");
            return null;
        } else if (bmVar.gll == 36 || bmVar.gll == 39) {
            at atVar;
            int i;
            String a = m.a(bmVar.mbW);
            String a2 = m.a(bmVar.mbU);
            String a3 = m.a(bmVar.mbV);
            v.d("MicroMsg.QMsgExtension", "parseQMsg content:" + a);
            ak.yW();
            String str = (String) c.vf().get(2, null);
            String str2 = str.equals(a2) ? a3 : a2;
            ak.yW();
            at S = c.wJ().S(str2, bmVar.mcb);
            v.d("MicroMsg.QMsgExtension", "dkmsgid parseQMsg svrid:%d localid:%d", new Object[]{Long.valueOf(bmVar.mcb), Long.valueOf(S.field_msgId)});
            if (S.field_msgId != 0 && S.field_createTime + 604800000 < aw.h(a2, (long) bmVar.hNS)) {
                v.w("MicroMsg.QMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[]{Long.valueOf(bmVar.mcb), Long.valueOf(S.field_msgId)});
                aw.L(S.field_msgId);
                S.x(0);
            }
            if (S.field_msgId == 0) {
                S = new at();
                S.y(bmVar.mcb);
                S.z(aw.h(a2, (long) bmVar.hNS));
                atVar = S;
            } else {
                atVar = S;
            }
            atVar.setType(bmVar.gll);
            atVar.cH(str2);
            d xU = g.aHl().xU(str2);
            if (xU == null || be.ma(xU.getUsername()).length() <= 0) {
                xU = new d();
                xU.username = str2;
                xU.hZH = 1;
                xU.bkU = 9;
                if (!g.aHl().a(xU)) {
                    v.e("MicroMsg.QMsgExtension", "parseQMsg : insert QContact failed : username = " + xU.getUsername());
                }
            }
            long j = -1;
            if (bmVar.mbX == 2 && atVar.field_msgId == 0) {
                byte[] a4 = m.a(bmVar.mbY);
                PString pString = new PString();
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                com.tencent.mm.ae.f GH = n.GH();
                int i2 = bmVar.mbX;
                j = GH.a(a4, bmVar.mcb, false, "", pString, pInt, pInt2);
                if (j > 0) {
                    atVar.cI(pString.value);
                    atVar.dt(pInt.value);
                    atVar.du(pInt2.value);
                }
            }
            long j2 = j;
            if (bmVar.gll == 36) {
                Object obj;
                u uVar;
                Assert.assertTrue(true);
                Assert.assertTrue(be.ma(a).length() > 0);
                Assert.assertTrue(be.ma(atVar.field_talker).length() > 0);
                ak.yW();
                u LX = c.wH().LX(atVar.field_talker);
                if (LX == null || be.ma(LX.field_username).length() <= 0) {
                    obj = 1;
                    uVar = new u(atVar.field_talker);
                } else {
                    obj = null;
                    uVar = LX;
                }
                a aVar2 = new a();
                Map q = bf.q(a, "msg");
                if (q != null) {
                    aVar2.caJ = (String) q.get(".msg.from.displayname");
                    aVar2.content = (String) q.get(".msg.content.t");
                }
                uVar.bQ(aVar2.caJ == null ? "" : aVar2.caJ);
                atVar.setContent(aVar2.content == null ? "" : aVar2.content);
                if (obj != null) {
                    ak.yW();
                    c.wH().N(uVar);
                } else {
                    ak.yW();
                    c.wH().a(uVar.field_username, uVar);
                }
            }
            ak.yW();
            Object obj2 = (c.wN().has(a2) || str.equals(a2)) ? 1 : null;
            if (obj2 != null) {
                atVar.di(1);
                i = bmVar.eeO;
                S = atVar;
            } else {
                atVar.di(0);
                if (bmVar.eeO > 3) {
                    i = bmVar.eeO;
                    S = atVar;
                } else {
                    i = 3;
                    S = atVar;
                }
            }
            S.dh(i);
            atVar.cN(bmVar.mbZ);
            aw.a(atVar, aVar);
            if (atVar.field_msgId == 0) {
                atVar.x(aw.e(atVar));
                if (bmVar.mbX == 2) {
                    com.tencent.mm.ae.d b = n.GH().b(Long.valueOf(j2));
                    b.af((long) ((int) atVar.field_msgId));
                    n.GH().a(Long.valueOf(j2), b);
                }
                return new b(atVar, true);
            }
            ak.yW();
            c.wJ().b(bmVar.mcb, atVar);
            return new b(atVar, false);
        } else {
            v.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM.type:%d", new Object[]{Integer.valueOf(bmVar.gll)});
            return null;
        }
    }

    public final void d(at atVar) {
        n.GH().k(atVar);
    }
}
