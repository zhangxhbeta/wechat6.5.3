package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import android.os.Looper;
import com.tencent.mm.e.a.ra;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.k.a.c.d;
import com.tencent.mm.pluginsdk.k.a.c.h;
import com.tencent.mm.pluginsdk.k.a.c.i;
import com.tencent.mm.pluginsdk.k.a.c.j;
import com.tencent.mm.pluginsdk.k.a.c.l;
import com.tencent.mm.pluginsdk.k.a.c.m;
import com.tencent.mm.pluginsdk.k.a.c.n;
import com.tencent.mm.pluginsdk.k.a.c.p;
import com.tencent.mm.pluginsdk.k.a.c.p.a;
import com.tencent.mm.pluginsdk.k.a.c.r;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class WebViewCacheDownloadHelper {
    private static final byte[] lgw = new byte[0];
    private static volatile WebViewCacheDownloadHelper lgx = null;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ List lgy;
        final /* synthetic */ WebViewCacheDownloadHelper lgz;

        public AnonymousClass1(WebViewCacheDownloadHelper webViewCacheDownloadHelper, List list) {
            this.lgz = webViewCacheDownloadHelper;
            this.lgy = list;
        }

        public final void run() {
            for (g gVar : this.lgy) {
                if (!(be.kS(gVar.appId) || be.kS(gVar.bsI) || be.kS(gVar.url))) {
                    a.bog().hp(a.T(gVar.appId, gVar.bsI, gVar.url));
                }
                if (!be.kS(gVar.url)) {
                    b.deleteFile(a.Eu(gVar.url));
                }
            }
        }
    }

    public static final class ResDownloaderPlugin implements h {
        private final d lgB = new d(this) {
            final /* synthetic */ ResDownloaderPlugin lgC;

            {
                this.lgC = r1;
            }

            public final void a(String str, m mVar) {
                b.c(str, mVar);
            }

            public final void b(String str, m mVar) {
                AnonymousClass1.Ew(str);
                b.c(str, mVar);
            }

            public final void Ev(String str) {
                AnonymousClass1.Ew(str);
            }

            public final String Pa() {
                return "WebViewCache";
            }

            private static void Ew(String str) {
                r Hg = a.bog().Hg(str);
                if (Hg != null) {
                    com.tencent.mm.pluginsdk.k.a.d.a.Hl(Hg.field_filePath);
                }
            }
        };

        public final void biS() {
            a.bog().a("WebViewCache", this.lgB);
        }

        public final void th() {
            c.clearCache();
            p bog = a.bog();
            String str = "WebViewCache";
            d dVar = this.lgB;
            if (bog.lfs) {
                j jVar = bog.lEC;
                if (dVar != null) {
                    int hashCode = str.hashCode();
                    synchronized (jVar.lEl) {
                        List list = (List) jVar.lEk.get(hashCode);
                        if (list == null) {
                            return;
                        }
                        list.remove(dVar);
                    }
                }
            }
        }

        public final String Pa() {
            return "WebViewCache";
        }

        public final n.a c(l lVar) {
            if (lVar != null && (lVar instanceof f)) {
                return new c((f) lVar);
            }
            v.e("MicroMsg.ResDownloader.WebViewCacheDownloadHelper", "getNetworkRequestHandler, get invalid request = " + lVar);
            return null;
        }

        public final i biT() {
            return new e();
        }
    }

    private WebViewCacheDownloadHelper() {
    }

    public static WebViewCacheDownloadHelper biQ() {
        if (lgx == null) {
            synchronized (lgw) {
                lgx = new WebViewCacheDownloadHelper();
            }
        }
        return lgx;
    }

    public static void biR() {
        FileOp.B(a.lgv, false);
    }

    public final void a(g gVar) {
        List arrayList = new ArrayList(1);
        arrayList.add(gVar);
        bG(arrayList);
    }

    public final void bG(List<g> list) {
        if (list.size() != 0) {
            final List arrayList = new ArrayList(list.size());
            for (g gVar : list) {
                a aVar = new a(gVar.url);
                aVar.lCO = a.T(gVar.appId, gVar.bsI, gVar.url);
                aVar.GY(gVar.lgE);
                aVar.Hc(a.Eu(gVar.url));
                aVar.dby = 0;
                aVar.bsI = gVar.bsI;
                aVar.appId = gVar.appId;
                aVar.bsK = gVar.bsK;
                aVar.bsJ = gVar.bsJ;
                aVar.networkType = gVar.networkType;
                arrayList.add(aVar.biV());
            }
            a.bog().q(new Runnable(this) {
                final /* synthetic */ WebViewCacheDownloadHelper lgz;

                public final void run() {
                    for (d dVar : arrayList) {
                        r Hg = a.bog().Hg(dVar.lCO);
                        v.d("MicroMsg.ResDownloader.WebViewCache.DoSubmitLogic", "request " + dVar);
                        v.d("MicroMsg.ResDownloader.WebViewCache.DoSubmitLogic", "record " + Hg);
                        if (Hg == null) {
                            v.d("MicroMsg.ResDownloader.WebViewCache.DoSubmitLogic", "record null, insert new ");
                            r biU = dVar.biU();
                            v.d("MicroMsg.ResDownloader.WebViewCache.DoSubmitLogic", " " + biU);
                            a.bog().e(biU);
                            a.a(dVar);
                        } else if (!dVar.lgE.equals(Hg.field_fileVersion)) {
                            v.d("MicroMsg.ResDownloader.WebViewCache.DoSubmitLogic", "need update");
                            com.tencent.mm.pluginsdk.k.a.d.a.Hl(dVar.OZ());
                            Hg.field_fileVersion = dVar.lgE;
                            Hg.field_url = dVar.url;
                            Hg.field_md5 = dVar.aZy;
                            Hg.field_networkType = dVar.networkType;
                            a.bog().e(Hg);
                            a.a(dVar);
                        } else if (Hg.field_status == 1 || Hg.field_status == 0 || Hg.field_status == 2) {
                            if (Hg.field_contentLength <= 0) {
                                v.d("MicroMsg.ResDownloader.WebViewCache.DoSubmitLogic", "record content length invalid");
                                a.a(dVar);
                            } else {
                                long Hj = com.tencent.mm.pluginsdk.k.a.d.a.Hj(dVar.OZ());
                                if (Hj > Hg.field_contentLength) {
                                    v.d("MicroMsg.ResDownloader.WebViewCache.DoSubmitLogic", "fileLength > contentLength");
                                    com.tencent.mm.pluginsdk.k.a.d.a.Hl(Hg.field_filePath);
                                    a.a(dVar);
                                } else if (Hj < Hg.field_contentLength) {
                                    v.d("MicroMsg.ResDownloader.WebViewCache.DoSubmitLogic", "fileLength < contentLength");
                                    a.a(dVar);
                                } else {
                                    v.d("MicroMsg.ResDownloader.WebViewCache.DoSubmitLogic", "mark complete");
                                    Hg.field_status = 2;
                                    a.bog().e(Hg);
                                    h hVar = new h(Hg.field_url, Hg.field_filePath, Hg.field_fileVersion, Hg.field_appId, Hg.field_groupId2, Hg.field_packageId, Hg.field_wvCacheType, Hg.field_contentType, Hg.field_contentLength, null);
                                    WebViewCacheDownloadHelper.biQ();
                                    WebViewCacheDownloadHelper.a(hVar);
                                }
                            }
                        } else if (Hg.field_status == 4 || Hg.field_status == 3) {
                            com.tencent.mm.pluginsdk.k.a.d.a.Hl(Hg.field_filePath);
                            a.a(dVar);
                        }
                    }
                }
            });
        }
    }

    static void a(h hVar) {
        ra raVar = new ra();
        raVar.bsH.url = hVar.url;
        raVar.bsH.filePath = hVar.filePath;
        raVar.bsH.version = hVar.version;
        raVar.bsH.appId = hVar.appId;
        raVar.bsH.bsI = hVar.bsI;
        raVar.bsH.bsJ = hVar.bsJ;
        raVar.bsH.bsK = hVar.bsK;
        raVar.bsH.bsL = hVar.bsL;
        raVar.bsH.bsN = hVar.bsN;
        raVar.bsH.bsM = hVar.bsM;
        com.tencent.mm.sdk.c.a.nhr.a(raVar, Looper.getMainLooper());
    }
}
