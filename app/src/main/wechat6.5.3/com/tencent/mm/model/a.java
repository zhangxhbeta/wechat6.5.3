package com.tencent.mm.model;

import com.tencent.mm.h.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.plugin.report.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public byte[] cqS;
    public long cqT = -1;

    public final int wt() {
        return this.cqS == null ? -1 : this.cqS.length;
    }

    public a() {
        if (wu()) {
            ad.g(new Runnable(this) {
                final /* synthetic */ a cqU;

                {
                    this.cqU = r1;
                }

                public final void run() {
                    try {
                        if (a.wu()) {
                            b.itm.a(226, 1, 1, false);
                        }
                    } catch (Throwable e) {
                        v.e("MicroMsg.AccInfoCacheInWorker", "init Exception:%s", be.e(e));
                    }
                }
            }, 5000);
        }
    }

    public static boolean wu() {
        if (com.tencent.mm.kernel.a.uG() || !g.uz()) {
            return false;
        }
        int i = be.getInt(((h) g.f(h.class)).sU().getValue("AndroidUseWorkerAuthCache"), 0);
        g.vx();
        int aq = com.tencent.mm.a.h.aq(g.vu().uin, 100);
        boolean bsI = com.tencent.mm.sdk.b.b.bsI();
        r7 = new Object[4];
        g.vx();
        r7[2] = Integer.valueOf(g.vu().uin);
        r7[3] = Integer.valueOf(aq);
        v.i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d", r7);
        if (bsI) {
            return true;
        }
        if (i > aq) {
            return true;
        }
        return false;
    }

    public static void wv() {
        if (wu()) {
            try {
                g.vx();
                a aVar = g.vu().cjr;
                g.vx();
                c BU = g.vv().cjC.cAa.BU();
                long Ni = be.Ni();
                if (BU == null) {
                    v.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
                    b.itm.a(226, 2, 1, false);
                    return;
                }
                v.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", Boolean.valueOf(BU.BQ()), Integer.valueOf(aVar.wt()));
                if (BU.BQ()) {
                    aVar.cqS = BU.BT();
                    b.itm.a(226, aVar.wt() > 0 ? 4 : 5, 1, false);
                    v.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", Long.valueOf(be.ay(Ni)), Integer.valueOf(aVar.wt()), Long.valueOf(aVar.cqT));
                    if (aVar.wt() > 0) {
                        b.itm.a(226, 31 - (aVar.cqT > 5 ? 5 : aVar.cqT), 1, false);
                        b.itm.h(11098, Integer.valueOf(2000), Long.valueOf(aVar.cqT));
                        aVar.cqT = -1;
                        return;
                    }
                    return;
                }
                b.itm.a(226, 3, 1, false);
                v.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
            } catch (Throwable th) {
                v.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", be.e(th));
            }
        }
    }
}
