package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.qmessage.b;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.d;
import java.util.HashMap;

public final class g implements ag {
    private static HashMap<Integer, c> bXq;
    private e hZO;
    private f hZP = new f();
    private a hZQ = new a();
    private b hZR = new b();

    private static g aHk() {
        g gVar = (g) ak.yP().fY("plugin.qmessage");
        if (gVar != null) {
            return gVar;
        }
        gVar = new g();
        ak.yP().a("plugin.qmessage", gVar);
        return gVar;
    }

    public static e aHl() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aHk().hZO == null) {
            g aHk = aHk();
            ak.yW();
            aHk.hZO = new e(com.tencent.mm.model.c.wE());
        }
        return aHk().hZO;
    }

    public final void th() {
        d.c.aw(Integer.valueOf(36));
        d.c.aw(Integer.valueOf(39));
        a.nhr.f(this.hZQ);
        a.nhr.f(this.hZR);
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("QCONTACT_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return e.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
        v.d("MicroMsg.SubCoreQMsg", "clear plugin");
        if ((i & 32) != 0) {
            aHn();
        }
    }

    public static void aHm() {
        ak.yW();
        if (com.tencent.mm.model.c.wK().Mh("qmessage") == null) {
            ab abVar = new ab();
            abVar.setUsername("qmessage");
            abVar.setContent("");
            abVar.s(be.Ni());
            abVar.di(0);
            abVar.df(0);
            ak.yW();
            com.tencent.mm.model.c.wK().d(abVar);
            return;
        }
        ak.yW();
        at MI = com.tencent.mm.model.c.wJ().MI("qmessage");
        ab abVar2 = new ab();
        abVar2.setUsername("qmessage");
        abVar2.setContent(MI == null ? "" : MI.field_content);
        abVar2.s(be.Ni());
        abVar2.di(0);
        abVar2.df(0);
        ak.yW();
        com.tencent.mm.model.c.wK().a(abVar2, "qmessage", true);
    }

    public static void aHn() {
        aw.zm();
        ak.yW();
        com.tencent.mm.model.c.wK().Mg("@qqim");
        ak.yW();
        com.tencent.mm.model.c.wK().Mf("qmessage");
    }

    public final void aG(boolean z) {
        d.c.a(Integer.valueOf(36), this.hZP);
        d.c.a(Integer.valueOf(39), this.hZP);
        a.nhr.e(this.hZQ);
        a.nhr.e(this.hZR);
    }

    public final void aH(boolean z) {
    }
}
