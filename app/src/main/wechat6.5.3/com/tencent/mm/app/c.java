package com.tencent.mm.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.model.bq;
import com.tencent.mm.network.e;
import com.tencent.mm.network.f.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.r;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.o;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.q;
import com.tencent.mm.v.p;
import com.tencent.recovery.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import junit.framework.Assert;

public final class c implements ServiceConnection {
    private static boolean aQv = false;
    private Runnable aQw = new Runnable(this) {
        private int aQA = 0;
        final /* synthetic */ c aQx;

        {
            this.aQx = r2;
        }

        public final void run() {
            v.e("MicroMsg.CoreServiceConnection", String.format("CoreService started but not responding, possibly zombie. Use step %d to restart CoreService.", new Object[]{Integer.valueOf(this.aQA)}));
            if (this.aQA == 1) {
                int bj = c.bi("com.tencent.mm:push");
                if (bj != -1) {
                    b.yH(13);
                    Process.killProcess(bj);
                    v.d("MicroMsg.CoreServiceConnection", String.format("Push Process %d killed.", new Object[]{Integer.valueOf(bj)}));
                } else {
                    v.d("MicroMsg.CoreServiceConnection", "Push Process not found.");
                }
            }
            Context context = aa.getContext();
            Intent intent = new Intent(context, CoreService.class);
            try {
                v.i("MicroMsg.CoreServiceConnection", "unbinding CoreService...");
                context.unbindService(this.aQx);
            } catch (Exception e) {
            } finally {
                context.stopService(intent);
                context.bindService(intent, this.aQx, 1);
                context.startService(intent);
            }
            if (this.aQA == 1) {
                this.aQA = 0;
            } else {
                this.aQA++;
            }
            ad.g(this, 10000);
            v.d("MicroMsg.CoreServiceConnection", String.format("ZombieWaker posted again with step %d", new Object[]{Integer.valueOf(this.aQA)}));
        }
    };
    private Object lock = new Object();

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        v.w("MicroMsg.CoreServiceConnection", "onServiceConnected ");
        synchronized (this.lock) {
            ad.B(this.aQw);
            aQv = false;
        }
        if (iBinder == null) {
            Assert.assertTrue("WorkerProfile onServiceConnected binder == null", false);
            com.tencent.mm.sdk.b.b.r("WorkerProfile onServiceConnected binder == null", "it will result in accInfo being null");
        }
        e pVar = new p(a.A(iBinder));
        try {
            pVar.cAq.a(new r.a(this) {
                final /* synthetic */ c aQx;

                {
                    this.aQx = r1;
                }

                public final boolean og() {
                    return true;
                }
            });
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
        try {
            pVar.cAq.a(new g.a(this) {
                final /* synthetic */ c aQx;

                {
                    this.aQx = r1;
                }

                public final void cF(final int i) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 aQz;

                        public final void run() {
                            if (com.tencent.mm.kernel.g.vB() != null) {
                                com.tencent.mm.kernel.g.vB().eh(i);
                            }
                        }
                    });
                }
            });
        } catch (Throwable e2) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e2));
        }
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.b vv = com.tencent.mm.kernel.g.vv();
        v.w("MMKernel.CoreNetwork", "setting up remote dispatcher " + pVar);
        vv.cjB.b(pVar);
        try {
            if (pVar.BV() != null) {
                pVar.BV().c(vv.cjE);
            }
        } catch (Throwable e22) {
            v.e("MMKernel.CoreNetwork", "exception:%s", be.e(e22));
        }
        pVar.a(new ac.a(vv) {
            final /* synthetic */ b cjF;
            private byte[] cjG;

            {
                this.cjF = r1;
            }

            public final byte[] uV() {
                if (!g.uz()) {
                    return null;
                }
                com.tencent.mm.protocal.ab.a aVar = new com.tencent.mm.protocal.ab.a();
                g.vx();
                aVar.uin = g.vu().uin;
                g.vx();
                aVar.cRq = be.KG((String) g.vw().vf().get(8195, null));
                aVar.netType = com.tencent.mm.protocal.a.getNetType(aa.getContext());
                aVar.lWW = com.tencent.mm.protocal.a.brq();
                try {
                    byte[] zf = aVar.zf();
                    this.cjG = aVar.cjG;
                    return zf;
                } catch (Throwable e) {
                    v.e("MMKernel.CoreNetwork", "exception:%s", be.e(e));
                    return null;
                }
            }

            public final int w(byte[] bArr) {
                int i = 0;
                com.tencent.mm.protocal.ab.b bVar = new com.tencent.mm.protocal.ab.b();
                try {
                    bVar.y(bArr);
                    return (int) bVar.lXy;
                } catch (Throwable e) {
                    v.e("MMKernel.CoreNetwork", "exception:%s", be.e(e));
                    return i;
                }
            }

            public final byte[] uW() {
                return this.cjG;
            }
        });
        com.tencent.mm.network.c BU = pVar.BU();
        if (BU == null) {
            v.f("MMKernel.CoreNetwork", "accInfo is null, it would assert before!!!");
            vv.cjC.reset();
            vv.cjC.BM();
        } else {
            String str;
            com.tencent.mm.sdk.b.b.a(new com.tencent.mm.sdk.b.a(vv) {
                final /* synthetic */ b cjF;

                {
                    this.cjF = r1;
                }

                public final void dS(String str) {
                    v.w("MMKernel.CoreNetwork", "CallbackForReset errorStack %s ", str);
                    g.vx();
                    if (g.vz() != null) {
                        g.vx();
                        bq vz = g.vz();
                        vz.aHp = true;
                        for (com.tencent.mm.model.bq.a aVar : vz.cvH) {
                            if (aVar != null) {
                                aVar.Ae();
                            }
                        }
                        vz.aHp = false;
                    }
                    g.vx();
                    if (g.vw() != null) {
                        g.vx();
                        g.vw().cQ(str);
                    }
                }
            });
            com.tencent.mm.kernel.g.vx();
            q qVar = com.tencent.mm.kernel.g.vw().cjT;
            Assert.assertTrue("setAutoAuth, getSysCfg() is null, stack = " + be.bur(), qVar != null);
            int i = qVar.getInt(47, 0);
            String str2 = (String) qVar.get(2);
            String str3 = (String) qVar.get(3);
            String str4 = (String) qVar.get(25);
            String str5 = (String) qVar.get(24);
            o.a dv = o.dv((String) qVar.get(6), (String) qVar.get(7));
            v.d("MMKernel.CoreNetwork", "dkidc host[s:%s l:%s] builtin[s:%s l:%s] ports[%s] timeout[%s] mmtls[%d]", str5, str4, str2, str3, str, r4, Integer.valueOf(i));
            Assert.assertTrue("setAutoAuth, autoAuth is null, stack = " + be.bur(), true);
            pVar.a(false, str2, str3, dv.lXa, dv.lXb, dv.lXc, dv.lXd, str5, str4);
            pVar.aW((i & 1) == 0);
            com.tencent.mm.kernel.g.vx();
            com.tencent.mm.kernel.a vu = com.tencent.mm.kernel.g.vu();
            Assert.assertTrue("setAutoAuth, accInfo is null, stack = " + be.bur(), BU != null);
            if (com.tencent.mm.kernel.g.uz()) {
                com.tencent.mm.kernel.g.vx();
                if (!com.tencent.mm.kernel.g.vu().cjo) {
                    vv.cjC.d(pVar);
                    com.tencent.mm.network.b.a(new com.tencent.mm.network.b.a(vv) {
                        final /* synthetic */ b cjF;

                        {
                            this.cjF = r1;
                        }

                        public final e uX() {
                            try {
                                return this.cjF.cjC.cAa;
                            } catch (Throwable th) {
                                v.e("MMKernel.CoreNetwork", "%s", be.e(th));
                                return null;
                            }
                        }
                    });
                    v.i("MMKernel.CoreNetwork", "setAutoAuth differrent accStg uin[%d], accInfo uin[%d]", Integer.valueOf(vu.uin), Integer.valueOf(BU.ww()));
                    if (vu.uin != BU.ww()) {
                        v.w("MMKernel.CoreNetwork", "update acc info with acc stg: uin =" + BU.ww());
                        str = "setAutoAuth, getConfigStg() is null, stack = " + be.bur();
                        com.tencent.mm.kernel.g.vx();
                        Assert.assertTrue(str, com.tencent.mm.kernel.g.vw().vf() != null);
                        com.tencent.mm.kernel.g.vx();
                        String str6 = (String) com.tencent.mm.kernel.g.vw().vf().get(2, null);
                        BU.i(new byte[0], vu.uin);
                        BU.setUsername(str6);
                    }
                }
            }
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(com.tencent.mm.kernel.g.uz());
            com.tencent.mm.kernel.g.vx();
            objArr[1] = Boolean.valueOf(com.tencent.mm.kernel.g.vu().cjo);
            v.w("MMKernel.CoreNetwork", "need to clear acc info and maybe stop networking accHasReady():%b accInitializing():%b", objArr);
            com.tencent.mm.plugin.report.b.itm.a(148, com.tencent.mm.kernel.g.uz() ? 44 : 43, 1, false);
            BU.reset();
            pVar.reset();
            vv.cjC.d(pVar);
            com.tencent.mm.network.b.a(new com.tencent.mm.network.b.a(vv) {
                final /* synthetic */ b cjF;

                {
                    this.cjF = r1;
                }

                public final e uX() {
                    try {
                        return this.cjF.cjC.cAa;
                    } catch (Throwable th) {
                        v.e("MMKernel.CoreNetwork", "%s", be.e(th));
                        return null;
                    }
                }
            });
            if (vu.uin != BU.ww() && vu.cjo) {
                com.tencent.mm.plugin.report.b.itm.a(148, 45, 1, false);
                v.w("MMKernel.CoreNetwork", "summerauth update acc info with acc stg: old acc uin=%d, acc stg uin=%d", Integer.valueOf(BU.ww()), Integer.valueOf(vu.uin));
                BU.cW(vu.uin);
            }
        }
        if (com.tencent.mm.model.a.wu()) {
            try {
                com.tencent.mm.kernel.g.vx();
                com.tencent.mm.model.a aVar = com.tencent.mm.kernel.g.vu().cjr;
                com.tencent.mm.kernel.g.vx();
                com.tencent.mm.network.c BU2 = com.tencent.mm.kernel.g.vv().cjC.cAa.BU();
                long Ni = be.Ni();
                if (BU2 == null) {
                    v.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush  accinfo == null");
                    com.tencent.mm.plugin.report.b.itm.a(226, 6, 1, false);
                } else {
                    v.i("MicroMsg.AccInfoCacheInWorker", "reuseToPush islogin:%b cache:%s", Boolean.valueOf(BU2.BQ()), Integer.valueOf(aVar.wt()));
                    if (BU2.BQ()) {
                        if (aVar.wt() > 0) {
                            com.tencent.mm.plugin.report.b.itm.a(226, 7, 1, false);
                            v.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush  something Error! islogin && isCacheValid . Clean Cache Now !");
                            aVar.cqS = null;
                        } else {
                            v.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush Here, DANGER! . HERE means worker just init , try set from push now!");
                            com.tencent.mm.plugin.report.b.itm.a(226, 8, 1, false);
                        }
                        aVar.cqS = BU2.BT();
                        com.tencent.mm.plugin.report.b.itm.a(226, aVar.wt() > 0 ? 9 : 10, 1, false);
                    } else if (aVar.wt() <= 0) {
                        com.tencent.mm.plugin.report.b.itm.a(226, 11, 1, false);
                        v.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush something is null. give up %s", aVar.toString());
                    } else {
                        int A = BU2.A(aVar.cqS);
                        v.i("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s time:%s  cache:%s", Integer.valueOf(A), Long.valueOf(be.ay(Ni)), Integer.valueOf(aVar.wt()));
                        if (A != 0) {
                            v.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s", Integer.valueOf(A));
                            aVar.cqS = null;
                        } else {
                            aVar.cqT = 0;
                        }
                        com.tencent.mm.plugin.report.b.itm.a(226, (long) (A + 20), 1, false);
                    }
                }
            } catch (Throwable th) {
                v.e("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush Exception:%s", be.e(th));
            }
        }
        if (com.tencent.mm.kernel.g.uz()) {
            com.tencent.mm.kernel.g.vx();
            if (com.tencent.mm.kernel.g.vv().cjC != null) {
                com.tencent.mm.kernel.g.vx();
                if (com.tencent.mm.kernel.g.vv().cjC.cAa != null) {
                    com.tencent.mm.kernel.g.vx();
                    com.tencent.mm.kernel.g.vv().cjC.cAa.aU(true);
                }
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        v.w("MicroMsg.CoreServiceConnection", "onServiceDisconnected ");
        if (!com.tencent.mm.kernel.a.uN() || com.tencent.mm.kernel.a.uG()) {
            com.tencent.mm.kernel.g.vx();
            com.tencent.mm.kernel.g.vv().cjC.BM();
            com.tencent.mm.kernel.g.vx();
            com.tencent.mm.kernel.g.vv().cjC.reset();
            return;
        }
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vv().cjC.BL();
        ad(aa.getContext());
    }

    public final void ad(Context context) {
        if (com.tencent.mm.booter.b.s(context, "noop")) {
            Intent intent = new Intent(context, CoreService.class);
            v.i("MicroMsg.CoreServiceConnection", "prepare dispatcher / bind core service");
            if (context.bindService(intent, this, 1)) {
                synchronized (this.lock) {
                    if (!aQv) {
                        aQv = true;
                        v.d("MicroMsg.CoreServiceConnection", "ZombieWaker posted.");
                        ad.g(this.aQw, 10000);
                    }
                }
                return;
            }
            v.e("MicroMsg.CoreServiceConnection", "bindService failed, may be caused by some crashes");
            return;
        }
        v.i("MicroMsg.CoreServiceConnection", "ensureServiceInstance return false");
    }

    private static int bi(String str) {
        Throwable th;
        File[] listFiles = new File("/proc").listFiles();
        int length = listFiles.length;
        int i = 0;
        int i2 = -1;
        Scanner scanner = null;
        while (i < length) {
            File file = listFiles[i];
            try {
                i2 = be.getInt(file.getName(), -1);
                try {
                    Scanner scanner2 = new Scanner(new File(file, "cmdline"));
                    try {
                        if (scanner2.hasNext() && scanner2.nextLine().equals(str)) {
                            scanner2.close();
                            break;
                        }
                        scanner2.close();
                        scanner = null;
                        i++;
                    } catch (FileNotFoundException e) {
                        scanner = scanner2;
                        if (scanner != null) {
                            scanner.close();
                            scanner = null;
                        }
                        i++;
                    } catch (Throwable th2) {
                        th = th2;
                        scanner = scanner2;
                    }
                } catch (FileNotFoundException e2) {
                    if (scanner != null) {
                        scanner.close();
                        scanner = null;
                    }
                    i++;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (NumberFormatException e3) {
            }
        }
        return i2;
        if (scanner != null) {
            scanner.close();
        }
        throw th;
    }
}
