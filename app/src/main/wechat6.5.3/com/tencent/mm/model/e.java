package com.tencent.mm.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import com.tencent.mm.v.d;
import com.tencent.mmdb.database.SQLiteDatabase;

public class e implements d {
    private static final a crq = new a();

    public interface b {
        void a(com.tencent.mm.v.d.a aVar, at atVar, String str, String str2, boolean z);
    }

    private static final class a extends com.tencent.mm.av.a<b> implements b {
        private a() {
        }

        public final void a(com.tencent.mm.v.d.a aVar, at atVar, String str, String str2, boolean z) {
            final com.tencent.mm.v.d.a aVar2 = aVar;
            final at atVar2 = atVar;
            final String str3 = str;
            final String str4 = str2;
            final boolean z2 = z;
            a(new com.tencent.mm.av.a.a<b>(this) {
                final /* synthetic */ a crv;

                public final /* synthetic */ void an(Object obj) {
                    ((b) obj).a(aVar2, atVar2, str3, str4, z2);
                }
            });
        }
    }

    public static void a(b bVar) {
        crq.ay(bVar);
    }

    public com.tencent.mm.v.d.b b(com.tencent.mm.v.d.a aVar) {
        bm bmVar = aVar.czu;
        String str = (String) g.vw().vf().get(2, SQLiteDatabase.KeyEmpty);
        if (str.length() <= 0) {
            return null;
        }
        String a = m.a(bmVar.mbU);
        String a2 = m.a(bmVar.mbV);
        if (be.ma(a).length() <= 0 || be.ma(a2).length() <= 0) {
            v.e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
            return null;
        }
        at a3 = a(bmVar, a, a2, str);
        if (a3 == null) {
            return null;
        }
        int i;
        at atVar;
        boolean z = ((com.tencent.mm.plugin.f.a.a.d) g.f(com.tencent.mm.plugin.f.a.a.d.class)).wN().has(a) || str.equals(a);
        if (z) {
            a3.di(1);
            a3.cH(a2);
            i = bmVar.eeO;
            atVar = a3;
        } else {
            a3.di(0);
            a3.cH(a);
            if (bmVar.eeO > 3) {
                i = bmVar.eeO;
                atVar = a3;
            } else {
                i = 3;
                atVar = a3;
            }
        }
        atVar.dh(i);
        if (bmVar.gll == 10000) {
            a3.dh(4);
        }
        a3.cN(bmVar.mbZ);
        crq.a(aVar, a3, a, a2, z);
        if (a3.field_msgId == 0) {
            aw.a(a3, aVar);
            a3.x(aw.e(a3));
            return new com.tencent.mm.v.d.b(a3, true);
        }
        ((com.tencent.mm.plugin.f.a.a.d) g.f(com.tencent.mm.plugin.f.a.a.d.class)).azI().b(bmVar.mcb, a3);
        return new com.tencent.mm.v.d.b(a3, false);
    }

    public at a(bm bmVar, String str, String str2, String str3) {
        au azI = ((com.tencent.mm.plugin.f.a.a.d) g.f(com.tencent.mm.plugin.f.a.a.d.class)).azI();
        if (!str3.equals(str)) {
            str2 = str;
        }
        at S = azI.S(str2, bmVar.mcb);
        v.i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d", Long.valueOf(bmVar.mcb), Long.valueOf(S.field_msgId));
        if (S.field_msgId != 0 && S.field_createTime + 604800000 < aw.h(str, (long) bmVar.hNS)) {
            v.w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(bmVar.mcb), Long.valueOf(S.field_msgId));
            aw.L(S.field_msgId);
            S.x(0);
        }
        if (S.field_msgId != 0) {
            return S;
        }
        S = new at();
        S.y(bmVar.mcb);
        S.z(aw.h(str, (long) bmVar.hNS));
        S.setType(bmVar.gll);
        S.setContent(be.KZ(be.ma(m.a(bmVar.mbW))));
        return S;
    }

    public void d(at atVar) {
    }
}
