package com.tencent.mm.plugin.luckymoney.c;

import android.net.Uri;
import android.os.Looper;
import com.tencent.mm.e.a.qv;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.u.n;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Iterator;

public final class ah implements e {
    public c hcA = new c<qv>(this) {
        final /* synthetic */ ah hcB;

        {
            this.hcB = r2;
            this.nhz = qv.class.getName().hashCode();
        }

        private boolean a(qv qvVar) {
            if (qvVar instanceof qv) {
                switch (qvVar.bsq.action) {
                    case 1:
                        ah ahVar = this.hcB;
                        long j = qvVar.bsq.aYG;
                        if (!ahVar.hcw) {
                            ahVar.hcw = true;
                            ak.yW();
                            at ek = com.tencent.mm.model.c.wJ().ek(j);
                            String str = ek.field_content;
                            a B = str != null ? a.B(str, ek.field_reserved) : null;
                            if (B != null) {
                                String ma = be.ma(B.cpK);
                                Uri parse = Uri.parse(ma);
                                String queryParameter = parse.getQueryParameter("sendid");
                                int i = be.getInt(parse.getQueryParameter("channelid"), 1);
                                if (ahVar.hcx != null) {
                                    ak.vy().c(ahVar.hcx);
                                    ahVar.hcx = null;
                                }
                                ak.vy().a(1581, ahVar);
                                ahVar.hcx = new ae(i, queryParameter, ma, 3, "v1.0");
                                ahVar.hcx.bdo = ek.field_talker;
                                ahVar.hcx.bao = j;
                                ak.vy().a(ahVar.hcx, 0);
                                break;
                            }
                        }
                        break;
                }
            }
            return false;
        }
    };
    boolean hcw;
    public ae hcx;
    public ab hcy;
    private u hcz;

    public ah() {
        com.tencent.mm.sdk.c.a.nhr.e(this.hcA);
    }

    public final void a(int i, int i2, String str, k kVar) {
        ak.vy().b(1581, this);
        ak.vy().b(1685, this);
        ak.vy().b(1585, this);
        if (kVar instanceof ae) {
            ae aeVar = (ae) kVar;
            if (i != 0 || i2 != 0) {
                this.hcw = false;
                cg(aeVar.bao);
            } else if (aeVar.hav == 4) {
                if (this.hcz != null) {
                    ak.vy().c(this.hcz);
                    this.hcz = null;
                }
                ak.vy().a(1585, this);
                this.hcz = new u(aeVar.haB, aeVar.cCj, "v1.0");
                this.hcz.bdo = aeVar.bdo;
                this.hcz.bao = aeVar.bao;
                ak.vy().a(this.hcz, 0);
                v.i("MicroMsg.Wear.WearLuckyLogic", "start to get detail");
            } else if (aeVar.haN == 1 || aeVar.hav == 5 || aeVar.hav == 1) {
                this.hcw = false;
                v.i("MicroMsg.Wear.WearLuckyLogic", "receive lucky already");
                cg(aeVar.bao);
            } else {
                if (this.hcy != null) {
                    ak.vy().c(this.hcy);
                    this.hcy = null;
                }
                ak.vy().a(1685, this);
                this.hcy = new ab(aeVar.msgType, aeVar.aPW, aeVar.haB, aeVar.cCj, n.axJ(), com.tencent.mm.model.k.xH(), aeVar.bdo, "v1.0");
                this.hcy.bao = aeVar.bao;
                ak.vy().a(this.hcy, 0);
                v.i("MicroMsg.Wear.WearLuckyLogic", "start to open lucky");
            }
        } else if (kVar instanceof ab) {
            this.hcw = false;
            ab abVar = (ab) kVar;
            if (i == 0 && i2 == 0) {
                e eVar = abVar.hbH;
                if (eVar.haN == 2) {
                    a(eVar, abVar.bao, abVar.bdo);
                    return;
                } else {
                    cg(abVar.bao);
                    return;
                }
            }
            cg(abVar.bao);
        } else if (kVar instanceof u) {
            this.hcw = false;
            u uVar = (u) kVar;
            if (i == 0 && i2 == 0) {
                a(uVar.hbH, uVar.bao, uVar.bdo);
            } else {
                cg(uVar.bao);
            }
        }
    }

    private static void cg(long j) {
        qv qvVar = new qv();
        qvVar.bsq.action = 2;
        qvVar.bsr.aYG = j;
        qvVar.bsr.bst = 0;
        qvVar.bsr.bsu = "";
        com.tencent.mm.sdk.c.a.nhr.a(qvVar, Looper.getMainLooper());
    }

    private static void a(e eVar, long j, String str) {
        qv qvVar = new qv();
        qvVar.bsq.action = 2;
        qvVar.bsr.aYG = j;
        qvVar.bsr.bst = eVar.bst;
        qvVar.bsr.bsu = eVar.haM;
        qvVar.bsr.bsv = new ArrayList();
        if (m.dE(str)) {
            Iterator it = eVar.haY.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                qvVar.bsr.bsv.add(n.Bq().gG(mVar.hbv) + "=" + mVar.hbu + "=" + mVar.hbh);
            }
        }
        com.tencent.mm.sdk.c.a.nhr.a(qvVar, Looper.getMainLooper());
    }
}
