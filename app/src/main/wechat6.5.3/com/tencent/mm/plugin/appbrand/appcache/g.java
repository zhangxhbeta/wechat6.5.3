package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import com.tencent.mm.compatible.d.w;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.k.a.c.k;
import com.tencent.mm.pluginsdk.k.a.c.l;
import com.tencent.mm.pluginsdk.k.a.c.m;
import com.tencent.mm.pluginsdk.k.a.c.n;
import com.tencent.mm.pluginsdk.k.a.c.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;

final class g {
    private final e dAA = new e(this);

    static final class a {
        static final Class[] dAB = new Class[]{SSLPeerUnverifiedException.class};
        static final Map<Class, a> dAC;

        interface a {
            boolean a(e eVar, String str, b bVar);
        }

        static void init() {
        }

        static {
            Map hashMap = new HashMap();
            hashMap.put(d.class, new a() {
                public final boolean a(e eVar, String str, b bVar) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(368, 30, 1, false);
                    eVar.b(new d(str.replaceFirst("https", "http"), bVar.OX()));
                    return true;
                }
            });
            hashMap.put(c.class, new a() {
                public final boolean a(e eVar, String str, b bVar) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(368, 31, 1, false);
                    return false;
                }
            });
            hashMap.put(f.class, new a() {
                public final boolean a(e eVar, String str, b bVar) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(368, 31, 1, false);
                    eVar.b(new f(bVar.OV(), null, bVar.OX(), str.replaceFirst("https", "http")));
                    return true;
                }
            });
            dAC = Collections.unmodifiableMap(hashMap);
        }
    }

    private interface b extends com.tencent.mm.pluginsdk.k.a.c.e {
        String OV();

        int OW();

        int OX();

        boolean OY();
    }

    private final class e extends n {
        final /* synthetic */ g dAE;

        e(g gVar) {
            this.dAE = gVar;
            super(new u("WxaPkgDownloaderPool", "WxaPkgDownloaderThread"), new h(gVar));
        }

        protected final com.tencent.mm.pluginsdk.k.a.c.g.d a(l lVar) {
            g gVar = new g((f) lVar);
            gVar.lEz = this.lEx;
            return gVar;
        }

        protected final int b(l lVar) {
            int b = super.b(lVar);
            if (b != 1) {
                return b;
            }
            super.b(lVar);
            return 2;
        }
    }

    private static final class g extends com.tencent.mm.pluginsdk.k.a.c.n.a<f> {
        private final b dAF;
        private volatile long dAG;

        g(f fVar) {
            super(fVar);
            this.dAF = fVar;
        }

        protected final m a(k kVar) {
            int i;
            String str;
            int i2;
            com.tencent.mm.loader.stub.b.deleteFile(((f) this.lEi).OZ());
            this.dAG = be.Ni();
            String str2 = "";
            b bVar = this.dAF;
            if (bVar == null) {
                i = 0;
                str = str2;
            } else if ("@LibraryAppId".equals(bVar.OV())) {
                i = 7;
                str = "";
            } else {
                int i3;
                if (bVar.OW() == 0) {
                    if (com.tencent.mm.plugin.appbrand.a.a.dzP == null) {
                        i3 = 1;
                    } else {
                        i3 = com.tencent.mm.plugin.appbrand.a.a.dzP.P(bVar.OV(), bVar.OW());
                    }
                    i3 = i3 > 1 ? 4 : 1;
                } else {
                    i3 = 1;
                }
                i = i3;
                str = bVar.OV();
            }
            if (1 == i) {
                com.tencent.mm.plugin.report.service.g.iuh.a(368, 1, 1, false);
            } else if (4 == i) {
                com.tencent.mm.plugin.report.service.g.iuh.a(368, 10, 1, false);
            } else if (7 == i) {
                com.tencent.mm.plugin.report.service.g.iuh.a(368, 20, 1, false);
            }
            m a = super.a(kVar);
            int Ni = (int) (be.Ni() - this.dAG);
            if (a == null || a.status == 3) {
                i2 = 2;
            } else if (a.status == 4) {
                i2 = 3;
            } else {
                i2 = 1;
            }
            if (1 == i) {
                if (i2 == 1) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(368, 2, 1, false);
                } else if (i2 == 2) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(368, 3, 1, false);
                }
            } else if (4 == i) {
                if (i2 == 1) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(368, 11, 1, false);
                } else if (i2 == 2) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(368, 12, 1, false);
                }
            } else if (7 == i) {
                if (i2 == 1) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(368, 21, 1, false);
                } else if (i2 == 2) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(368, 22, 1, false);
                }
            }
            if (bVar != null) {
                com.tencent.mm.plugin.appbrand.report.a.b(str, "", i, i2, Ni);
            }
            return a;
        }

        public final String Pa() {
            return "AppBrandWxaPkgDownloader";
        }

        public final boolean Pb() {
            return true;
        }

        public final boolean Pc() {
            return false;
        }

        public final boolean Pd() {
            return true;
        }

        protected final boolean Pe() {
            return false;
        }

        public final boolean Pf() {
            return false;
        }

        public final boolean Pg() {
            switch (w.sb()) {
                case 1:
                    return super.Pg();
                default:
                    return false;
            }
        }

        public final com.tencent.mm.pluginsdk.k.a.c.e Ph() {
            return this.dAF;
        }
    }

    private final class h implements com.tencent.mm.pluginsdk.k.a.c.c {
        volatile e dAA = this;
        final /* synthetic */ g dAE;
        private final ac dAH = new ac(com.tencent.mm.plugin.appbrand.k.a.vA().htb.getLooper());

        h(g gVar) {
            this.dAE = gVar;
        }

        public final void a(final com.tencent.mm.pluginsdk.k.a.c.f fVar, final m mVar) {
            this.dAH.post(new Runnable(this) {
                final /* synthetic */ h dAK;

                public final void run() {
                    com.tencent.mm.pluginsdk.k.a.c.f fVar;
                    m mVar;
                    b bVar;
                    com.tencent.mm.plugin.appbrand.appcache.m.a.b bVar2;
                    switch (mVar.status) {
                        case 2:
                            fVar = fVar;
                            mVar = mVar;
                            bVar = (b) fVar.Ph();
                            if ("@LibraryAppId".equals(bVar.OV()) && bVar.OW() == 0) {
                                m.g(mVar.lCO, mVar.filePath, bVar.OX());
                                return;
                            } else {
                                m.b(mVar.lCO, bVar.OV(), mVar.filePath, bVar.OX(), bVar.OW());
                                return;
                            }
                        case 3:
                            h hVar = this.dAK;
                            com.tencent.mm.pluginsdk.k.a.c.f fVar2 = fVar;
                            m mVar2 = mVar;
                            if (fVar2.getURL().startsWith("https") && ((b) fVar2.Ph()).OY() && mVar2.lEv != null && hVar.dAA != null) {
                                boolean z;
                                a aVar;
                                Class[] clsArr = a.dAB;
                                int length = clsArr.length;
                                int i = 0;
                                while (i < length) {
                                    if (clsArr[i].equals(mVar2.lEv.getClass())) {
                                        z = true;
                                        v.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "dispatchFailed, https connection, canFallback = %b, exp = %s", new Object[]{Boolean.valueOf(z), mVar2.lEv});
                                        bVar = (b) fVar2.Ph();
                                        if (z) {
                                            aVar = (a) a.dAC.get(bVar.getClass());
                                            if (aVar != null && aVar.a(hVar.dAA, mVar2.url, bVar)) {
                                                v.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "dispatchFailed, fallback handler %s", new Object[]{aVar.getClass()});
                                                return;
                                            }
                                        }
                                        v.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "dispatchFailed, https connection, go back to old logic");
                                    } else {
                                        i++;
                                    }
                                }
                                z = false;
                                v.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "dispatchFailed, https connection, canFallback = %b, exp = %s", new Object[]{Boolean.valueOf(z), mVar2.lEv});
                                bVar = (b) fVar2.Ph();
                                if (z) {
                                    aVar = (a) a.dAC.get(bVar.getClass());
                                    v.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "dispatchFailed, fallback handler %s", new Object[]{aVar.getClass()});
                                    return;
                                }
                                v.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "dispatchFailed, https connection, go back to old logic");
                            }
                            mVar = mVar2;
                            fVar = fVar2;
                            break;
                        case 4:
                            com.tencent.mm.pluginsdk.k.a.c.f fVar3 = fVar;
                            fVar = fVar3;
                            mVar = mVar;
                            break;
                        default:
                            return;
                    }
                    com.tencent.mm.loader.stub.b.deleteFile(mVar.filePath);
                    bVar = (b) fVar.Ph();
                    switch (mVar.httpStatusCode) {
                        case 404:
                            bVar2 = com.tencent.mm.plugin.appbrand.appcache.m.a.b.dBp;
                            com.tencent.mm.plugin.appbrand.report.a.S(bVar.OV(), 23);
                            break;
                        default:
                            bVar2 = com.tencent.mm.plugin.appbrand.appcache.m.a.b.dBl;
                            com.tencent.mm.plugin.appbrand.report.a.S(bVar.OV(), 19);
                            break;
                    }
                    m.a(mVar.lCO, bVar.OV(), bVar2);
                }
            });
        }

        public final void j(String str, int i, int i2) {
        }

        public final void m(String str, long j) {
        }
    }

    @SuppressLint({"DefaultLocale"})
    static class f extends l implements b {
        final String appId;
        final int version;

        static String N(String str, int i) {
            return String.format("WxaPkg_%s_%d", new Object[]{str, Integer.valueOf(i)});
        }

        static String O(String str, int i) {
            return g.OU() + String.format("_%d_%d.wxapkg", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i)});
        }

        f(String str, String str2, int i, String str3) {
            String format;
            String N = N(str, i);
            String O = O(str, i);
            String valueOf = String.valueOf(i);
            String str4 = "AppBrandWxaPkgDownloader";
            if (be.kS(str3)) {
                format = String.format("%s%s/%d.wxapkg", new Object[]{str2, str, Integer.valueOf(i)});
            } else {
                format = str3;
            }
            super(N, O, valueOf, str4, format, "GET", 3, 2, 0);
            this.appId = str;
            this.version = i;
        }

        f(String str, String str2, String str3, String str4, int i) {
            super(str, str2, String.valueOf(i), "AppBrandWxaPkgDownloader", str3, "GET", 3, 2, 0);
            this.appId = str4;
            this.version = i;
        }

        public String OZ() {
            String OZ = super.OZ();
            return be.kS(OZ) ? O(this.appId, this.version) : OZ;
        }

        public final String OV() {
            return this.appId;
        }

        public int OW() {
            return 0;
        }

        public final int OX() {
            return this.version;
        }

        public boolean OY() {
            return true;
        }
    }

    @SuppressLint({"DefaultLocale"})
    static class c extends f {
        private final String dAD;
        private final int dzx;

        private static String f(String str, String str2, int i) {
            return g.OU() + String.format("debug_%d_%d_%d.wxapkg", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(str2.hashCode())});
        }

        c(String str, String str2, int i) {
            super(String.format("WxaDebugPkg_%s_%d_%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(str2.hashCode())}), f(str, str2, i), str2, str, String.format("%d-%s", new Object[]{Integer.valueOf(i), str2}).hashCode());
            this.dzx = i;
            this.dAD = str2;
        }

        public final int OW() {
            return this.dzx;
        }

        public final boolean OY() {
            return false;
        }

        public final String OZ() {
            return f(this.appId, this.dAD, this.dzx);
        }
    }

    static class d extends f {
        d(String str, int i) {
            super(f.N("@LibraryAppId", i), f.O("@LibraryAppId", i), str, "@LibraryAppId", i);
        }

        public final boolean OY() {
            return true;
        }

        public final int OW() {
            return 0;
        }
    }

    g() {
        a.init();
    }

    static String OU() {
        ak.yW();
        String xp = com.tencent.mm.model.c.xp();
        if (!xp.endsWith("/")) {
            xp = xp + "/";
        }
        xp = xp + "appbrand/pkg/";
        com.tencent.mm.sdk.platformtools.h.JX(xp);
        return xp;
    }

    final void a(f fVar) {
        this.dAA.b(fVar);
    }
}
