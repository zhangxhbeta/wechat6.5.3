package com.tencent.mm.kernel;

import android.app.Application;
import com.tencent.mm.a.o;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.plugin.ProcessProfile;
import com.tencent.mm.kernel.plugin.ProcessProfileImpl;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.n;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class g {
    private static y ckQ = null;
    private static g cky;
    public final a cjB = new a();
    public final a cjU = new a();
    public final List<com.tencent.mm.kernel.api.a> cjX = new ArrayList();
    private bq ckA = null;
    public e ckB;
    public a ckC;
    public b ckD;
    private c ckE = new c();
    private d ckF;
    private byte[] ckG = new byte[0];
    public volatile boolean ckH = false;
    public volatile boolean ckI = false;
    public d ckJ = new d();
    public final c ckK = new c();
    public final a ckL = new a();
    public final b ckM = new b();
    public final List<x> ckN = new ArrayList();
    private final boolean ckO;
    public volatile boolean ckP = false;
    private ad ckz;

    class AnonymousClass4 implements com.tencent.mm.vending.g.d.b<Void> {
        final /* synthetic */ g ckR;
        final /* synthetic */ long ckT;

        public AnonymousClass4(g gVar, long j) {
            this.ckR = gVar;
            this.ckT = j;
        }

        public final /* synthetic */ void ap(Object obj) {
            com.tencent.mm.kernel.a.b.a("mmkernel boot startup finished in [%s]!", com.tencent.mm.kernel.a.b.H(this.ckT));
            synchronized (this.ckR.ckG) {
                this.ckR.ckH = true;
            }
            this.ckR.ckJ.ok();
        }
    }

    private static class a extends com.tencent.mm.av.a<com.tencent.mm.kernel.api.b> implements com.tencent.mm.kernel.api.b {
        private a() {
        }

        public final void th() {
            a(new com.tencent.mm.av.a.a<com.tencent.mm.kernel.api.b>(this) {
                final /* synthetic */ a ckU;

                {
                    this.ckU = r1;
                }

                public final /* synthetic */ void an(Object obj) {
                    ((com.tencent.mm.kernel.api.b) obj).th();
                }
            });
        }
    }

    private static class b extends com.tencent.mm.av.a<com.tencent.mm.v.n.a> implements com.tencent.mm.v.n.a {
        private b() {
        }

        public final void a(final n nVar, final boolean z) {
            a(new com.tencent.mm.av.a.a<com.tencent.mm.v.n.a>(this) {
                final /* synthetic */ b ckX;

                public final /* synthetic */ void an(Object obj) {
                    ((com.tencent.mm.v.n.a) obj).a(nVar, z);
                }
            });
        }

        public final void a(final n nVar) {
            a(new com.tencent.mm.av.a.a<com.tencent.mm.v.n.a>(this) {
                final /* synthetic */ b ckX;

                public final /* synthetic */ void an(Object obj) {
                    ((com.tencent.mm.v.n.a) obj).a(nVar);
                }
            });
        }
    }

    private static class c extends com.tencent.mm.av.a<f> implements f {
        private c() {
        }

        public final void a(final a aVar) {
            a(new com.tencent.mm.av.a.a<f>(this) {
                final /* synthetic */ c ckZ;

                public final /* synthetic */ void an(Object obj) {
                    ((f) obj).a(aVar);
                }
            });
        }

        public final void a(final a aVar, final boolean z) {
            a(new com.tencent.mm.av.a.a<f>(this) {
                final /* synthetic */ c ckZ;

                public final /* synthetic */ void an(Object obj) {
                    ((f) obj).a(aVar, z);
                }
            });
        }
    }

    private static class d extends com.tencent.mm.av.a<e> implements e {
        public d() {
            super(com.tencent.mm.vending.h.d.phX);
        }

        public final void ok() {
            a(new com.tencent.mm.av.a.a<e>(this) {
                final /* synthetic */ d clb;

                {
                    this.clb = r1;
                }

                public final /* synthetic */ void an(Object obj) {
                    ((e) obj).ok();
                }
            });
        }

        public final void ah(final boolean z) {
            a(new com.tencent.mm.av.a.a<e>(this) {
                final /* synthetic */ d clb;

                public final /* synthetic */ void an(Object obj) {
                    ((e) obj).ah(z);
                }
            });
        }
    }

    static /* synthetic */ void a(g gVar, ProcessProfile processProfile, Object obj) {
        if (obj instanceof ApplicationLifeCycleBucket) {
            processProfile.addApplicationLifeCycleCallback((ApplicationLifeCycle) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.bucket.g) {
            gVar.ckK.ay((f) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.bucket.b) {
            gVar.ckL.ay((com.tencent.mm.kernel.api.b) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.bucket.a) {
            gVar.cjX.add((com.tencent.mm.kernel.api.a) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.bucket.d) {
            gVar.cjU.ay((com.tencent.mm.kernel.api.d) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.bucket.c) {
            gVar.cjB.ay((com.tencent.mm.kernel.api.c) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.bucket.f) {
            gVar.ckJ.ay((e) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.bucket.e) {
            gVar.ckN.add((x) obj);
        }
    }

    private g(final ProcessProfile processProfile) {
        this.ckF = new d(processProfile);
        this.ckO = d.b(this.ckF.uZ());
        if (this.ckO) {
            this.ckA = new bq();
            this.ckz = new ad();
            this.ckz.x(new Runnable(this) {
                final /* synthetic */ g ckR;

                {
                    this.ckR = r1;
                }

                public final void run() {
                    ak.dS(aa.getContext());
                }
            });
        }
        this.ckE.cjQ = new com.tencent.mm.kernel.c.a(this) {
            final /* synthetic */ g ckR;

            public final void b(com.tencent.mm.kernel.plugin.b bVar) {
                g.a(this.ckR, processProfile, (Object) bVar);
            }

            public final void a(com.tencent.mm.kernel.b.c cVar) {
                g.a(this.ckR, processProfile, (Object) cVar);
            }
        };
    }

    public final void a(e eVar) {
        Object obj = null;
        synchronized (this.ckG) {
            if (this.ckH) {
                obj = 1;
            }
        }
        if (obj != null) {
            eVar.ok();
        } else {
            this.ckJ.ay(eVar);
        }
    }

    public final void b(e eVar) {
        this.ckJ.remove(eVar);
    }

    public static boolean vr() {
        return cky == null || !cky.ckI;
    }

    public static boolean uz() {
        if (vr()) {
            return false;
        }
        vx();
        if (!vu().uz()) {
            return false;
        }
        vx();
        int i = vu().uin;
        vx();
        vu();
        if (i == a.uQ()) {
            return true;
        }
        return false;
    }

    public static c vs() {
        Assert.assertNotNull("mCorePlugins not initialized!", vx().ckE);
        return vx().ckE;
    }

    public static d vt() {
        Assert.assertNotNull("mCoreProcess not initialized!", vx().ckF);
        return vx().ckF;
    }

    public static a vu() {
        Assert.assertNotNull("mCoreAccount not initialized!", vx().ckC);
        return vx().ckC;
    }

    public static b vv() {
        Assert.assertNotNull("mCoreNetwork not initialized!", vx().ckD);
        return vx().ckD;
    }

    public static e vw() {
        Assert.assertNotNull("mCoreStorage not initialized!", vx().ckB);
        return vx().ckB;
    }

    public static g vx() {
        Assert.assertNotNull("Kernel not initialized by MMApplication!", cky);
        return cky;
    }

    public static <T extends com.tencent.mm.kernel.plugin.a> T g(Class<T> cls) {
        vx();
        return vs().g(cls);
    }

    public static <T extends com.tencent.mm.kernel.b.b> T f(Class<T> cls) {
        vx();
        return vs().f(cls);
    }

    public static void a(Class<? extends com.tencent.mm.kernel.b.c> cls, com.tencent.mm.kernel.b.c cVar) {
        vx();
        vs().a((Class) cls, cVar);
    }

    public static n vy() {
        vx();
        return vv().cjC;
    }

    public static bq vz() {
        Assert.assertTrue(vx().ckO);
        return vx().ckA;
    }

    public static ad vA() {
        Assert.assertTrue(vx().ckO);
        return vx().ckz;
    }

    public static y vB() {
        return ckQ;
    }

    public static void a(y yVar) {
        ckQ = yVar;
    }

    public static synchronized void a(String str, Application application, MMApplicationLike mMApplicationLike) {
        synchronized (g.class) {
            if (cky != null) {
                cky.ckF.uZ().updateApplication(application, mMApplicationLike);
                v.i("MicroMsg.MMKernel", "Kernel not null, has initialized.");
            } else {
                v.i("MicroMsg.MMKernel", "Initialize kernel, create whole WeChat world.");
                cky = new g(new ProcessProfileImpl(str, application, mMApplicationLike));
            }
        }
    }

    public final void releaseAll() {
        String str = "MicroMsg.MMKernel";
        String str2 = "release uin:%s ";
        Object[] objArr = new Object[1];
        objArr[0] = this.ckC != null ? o.getString(this.ckC.uin) : "-1";
        v.w(str, str2, objArr);
        if (this.ckD.cjC != null) {
            this.ckD.cjC.reset();
        }
        if (this.ckz != null) {
            this.ckz.a(new com.tencent.mm.sdk.platformtools.ad.b(this) {
                final /* synthetic */ g ckR;

                {
                    this.ckR = r1;
                }

                public final void vC() {
                    if (this.ckR.ckC != null) {
                        this.ckR.ckC.release();
                    }
                }
            });
        }
    }
}
