package com.tencent.mm.plugin.report.service;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.k;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.platformtools.g.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public class i implements ag {
    private static i iur;
    private static HashMap<Integer, c> ius;
    private a iut;
    private com.tencent.mm.sdk.c.c iuu = new com.tencent.mm.sdk.c.c<k>(this) {
        final /* synthetic */ i iuv;

        {
            this.iuv = r2;
            this.nhz = k.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((k) bVar).aWD.aWE) {
                ak.yW();
                if (com.tencent.mm.model.c.ww() == 0) {
                    v.i("MicroMsg.SubCoreReport", "mOnForegroundListener: account not ready");
                }
            }
            return false;
        }
    };

    static {
        HashMap hashMap = new HashMap();
        ius = hashMap;
        hashMap.put(Integer.valueOf("DUPLICATEKVLOG_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return com.tencent.mm.plugin.report.a.b.cic;
            }
        });
    }

    public final void th() {
        if (aKE() != null) {
            i aKE = aKE();
            if (aKE.iut != null) {
                aKE.iut.gG(aKE.hashCode());
                aKE.iut = null;
            }
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.iuu);
    }

    public final HashMap<Integer, c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        this.iut = g.a(hashCode(), stringBuilder.append(com.tencent.mm.model.c.xp()).append("CommonOneMicroMsg.db").toString(), ius, false);
        com.tencent.mm.sdk.c.a.nhr.e(this.iuu);
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ i iuv;

            {
                this.iuv = r1;
            }

            public final void run() {
                if (ak.uz()) {
                    ak.yW();
                    be.f(com.tencent.mm.model.c.xm(), "temp_", 10800000);
                }
            }

            public final String toString() {
                return super.toString() + "|onAccountPostReset";
            }
        });
    }

    public final void aH(boolean z) {
    }

    private static i aKE() {
        i iVar = (i) ak.yP().fY(i.class.getName());
        iur = iVar;
        if (iVar == null) {
            iur = new i();
            ak.yP().a(i.class.getName(), iur);
        }
        return iur;
    }
}
