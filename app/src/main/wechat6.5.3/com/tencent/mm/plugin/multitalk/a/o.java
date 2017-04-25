package com.tencent.mm.plugin.multitalk.a;

import android.util.Base64;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.multitalk.b.b;
import com.tencent.mm.plugin.multitalk.b.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;

public final class o implements ag {
    private static HashMap<Integer, c> bXq;
    private d hAA;
    private f hAB;
    private com.tencent.mm.model.bq.a hAC = new com.tencent.mm.model.bq.a(this) {
        final /* synthetic */ o hAD;

        {
            this.hAD = r1;
        }

        public final boolean Ae() {
            v.w("MicroMsg.SubCoreMultiTalk", "HERE UninitForUEH is called! multitalk");
            if (this.hAD.hAu != null) {
                this.hAD.hAu.aCl();
                if (this.hAD.hAu.hzq != null) {
                    v.i("MicroMsg.SubCoreMultiTalk", "dump multiTalkGroup: %s", new Object[]{i.h(this.hAD.hAu.hzq)});
                }
            }
            return true;
        }
    };
    private c hAt;
    private e hAu;
    private l hAv;
    private h hAw;
    private a hAx;
    private g hAy;
    private b hAz;

    class a implements bo.b {
        final /* synthetic */ o hAD;

        a(o oVar) {
            this.hAD = oVar;
        }

        public final void a(com.tencent.mm.v.d.a aVar) {
            f aCJ = o.aCJ();
            String a = m.a(aVar.czu.mbW);
            Map q = bf.q(a, "sysmsg");
            if (((String) q.get(".sysmsg.multivoip.notfriendnotifydata")) != null) {
                v.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive notfriendnotifydata msg:" + a);
                return;
            }
            String str = (String) q.get(".sysmsg.multivoip.notifydata");
            if (str != null) {
                byte[] decode = Base64.decode(be.ah(str, "").getBytes(), 0);
                v.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive " + m.a(aVar.czu.mbW) + " buffer len " + decode.length);
                o.aCF().hyY.ay(be.f((Integer) ak.yT().get(1)), k.xF());
                o.aCF().hyY.bv(decode);
                return;
            }
            str = (String) q.get(".sysmsg.multivoip.banner");
            if (str != null) {
                aCJ.a(str, aVar);
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("MULTITALKINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return b.cic;
            }
        });
        bXq.put(Integer.valueOf("MULTITALKMEMBER_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return d.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    private static o aCB() {
        o oVar = (o) ak.yP().fY("plugin.multitalk");
        if (oVar != null) {
            return oVar;
        }
        oVar = new o();
        ak.yP().a("plugin.multitalk", oVar);
        return oVar;
    }

    public static b aCC() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aCB().hAz == null) {
            o aCB = aCB();
            ak.yW();
            aCB.hAz = new b(com.tencent.mm.model.c.wE());
        }
        return aCB().hAz;
    }

    public static d aCD() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aCB().hAA == null) {
            o aCB = aCB();
            ak.yW();
            aCB.hAA = new d(com.tencent.mm.model.c.wE());
        }
        return aCB().hAA;
    }

    public static h aCE() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aCB().hAw == null) {
            aCB().hAw = new h();
        }
        return aCB().hAw;
    }

    public static c aCF() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aCB().hAt == null) {
            aCB().hAt = new c();
        }
        return aCB().hAt;
    }

    public static e aCG() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aCB().hAu == null) {
            aCB().hAu = new e();
        }
        return aCB().hAu;
    }

    public static l aCH() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aCB().hAv == null) {
            aCB().hAv = new l();
        }
        return aCB().hAv;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        this.hAt = new c();
        this.hAx = new a(this);
        ak.yU().a("multivoip", this.hAx, true);
        ak.vz().a(this.hAC);
        com.tencent.mm.pluginsdk.j.a.lxR = aCI();
        aCI().aCv();
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        if (this.hAt != null) {
            c cVar = this.hAt;
            ak.vy().b(1918, cVar);
            ak.vy().b(1919, cVar);
            ak.vy().b(1927, cVar);
            ak.vy().b(1928, cVar);
            ak.vy().b(1929, cVar);
            ak.vy().b(1931, cVar);
            ak.vy().b(1932, cVar);
            ak.vy().b(1933, cVar);
            ak.vy().b(1935, cVar);
            ak.vy().b(1937, cVar);
            ak.vy().b(1938, cVar);
            ak.vy().b(1939, cVar);
            this.hAt = null;
        }
        if (this.hAu != null) {
            e eVar = this.hAu;
            aa.getContext().unregisterReceiver(eVar.hzx);
            com.tencent.mm.sdk.c.a.nhr.f(eVar.hzy);
            eVar.c(false, false, false);
            this.hAu = null;
        }
        if (this.hAv != null) {
            this.hAv.aCA();
            this.hAv = null;
        }
        if (this.hAw != null) {
            this.hAw.reset();
            this.hAw = null;
        }
        ak.yU().b("multivoip", this.hAx, true);
        ak.vz().b(this.hAC);
    }

    public static g aCI() {
        if (aCB().hAy == null) {
            aCB().hAy = new g();
        }
        return aCB().hAy;
    }

    public static f aCJ() {
        if (aCB().hAB == null) {
            aCB().hAB = new f();
        }
        return aCB().hAB;
    }
}
