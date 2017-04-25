package com.tencent.mm.modelstat;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ab.f;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.m.a;
import com.tencent.mm.network.w;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.d;
import java.util.HashMap;

public class p implements ag {
    private static HashMap<Integer, c> bXq;
    private m cEZ = new a(this) {
        final /* synthetic */ p ddP;

        {
            this.ddP = r1;
        }

        public final void cI(int i) {
            if (i == 4 || i == 6) {
                ak.vA().f(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 ddQ;

                    {
                        this.ddQ = r1;
                    }

                    public final void run() {
                        if (ak.uz()) {
                            p.Kk().Kb();
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|onNetworkChange";
                    }
                }, 3000);
                v.d("MicroMsg.SubCoreStat", "NetTypeReporter st:%d", Integer.valueOf(i));
                n.gp(2);
            }
        }
    };
    private k ddL = new k();
    private l ddM;
    private w ddN = new w();
    private f ddO = null;

    public static f Kk() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        if (Kl().ddO == null) {
            Kl().ddO = new f(t.cng);
        }
        return Kl().ddO;
    }

    private static p Kl() {
        p pVar = (p) ak.yP().fY(p.class.getName());
        if (pVar != null) {
            return pVar;
        }
        Object pVar2 = new p();
        ak.yP().a(p.class.getName(), pVar2);
        return pVar2;
    }

    public static l Km() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        if (Kl().ddM == null) {
            p Kl = Kl();
            ak.yW();
            Kl.ddM = new l(com.tencent.mm.model.c.wE());
        }
        return Kl().ddM;
    }

    public static void e(e eVar) {
        boolean z;
        String str = "MicroMsg.SubCoreStat";
        String str2 = "dknetstat setNetworkMoniter  isnull:%b  ,  %s ";
        Object[] objArr = new Object[2];
        if (eVar == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = be.bur();
        v.d(str, str2, objArr);
        if (eVar != null) {
            eVar.a(Kl().ddL);
        }
    }

    public static void f(e eVar) {
        String str = "MicroMsg.SubCoreStat";
        String str2 = "setKVReportMonitor  isnull:%b  ,  %s ";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(eVar == null);
        objArr[1] = be.bur();
        v.d(str, str2, objArr);
        if (eVar != null) {
            eVar.a(Kl().ddN);
        }
    }

    public final void th() {
        ak.b(this.cEZ);
        d.c.aw(Integer.valueOf(9998));
        this.ddL = new k();
        ab.a.csa = null;
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("NETSTAT_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return l.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        d.c.a(Integer.valueOf(9998), this.ddL);
        ak.a(this.cEZ);
        ab.a.csa = new f(this) {
            final /* synthetic */ p ddP;

            {
                this.ddP = r1;
            }

            public final void aC(int i, int i2) {
                v.d("MicroMsg.SubCoreStat", "ReportDataFlow [%d][%d][%d] : %s ", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), be.bur());
                m.r(i, i2, 0);
            }
        };
    }

    public final void aH(boolean z) {
    }
}
