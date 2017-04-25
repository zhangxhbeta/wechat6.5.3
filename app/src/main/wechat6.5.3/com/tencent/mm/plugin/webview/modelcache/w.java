package com.tencent.mm.plugin.webview.modelcache;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.jx;
import com.tencent.mm.e.a.ra;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.pluginsdk.k.a.b.d;
import com.tencent.mm.pluginsdk.k.a.b.f;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.net.SocketTimeoutException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class w {
    private volatile ad ckz;
    private final Object dSD;
    public final c lgc;
    public final c lgd;
    private volatile l lge;
    public volatile n lgf;
    final SparseArray<r> lgg;
    public final d lgh;
    final f lgi;
    public final byte[] lgj;
    public final SparseArray<Set<a>> lgk;

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ w lgl;
        final /* synthetic */ List lgr;

        public AnonymousClass5(w wVar, List list) {
            this.lgl = wVar;
            this.lgr = list;
        }

        public final void run() {
            for (String str : this.lgr) {
                v.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate requestURL = %s", new Object[]{str});
                if (!be.kS(str)) {
                    int sG;
                    if (str.startsWith("http://")) {
                        sG = com.tencent.mm.plugin.webview.modelcache.b.a.sG(0);
                    } else if (str.startsWith("https://")) {
                        sG = com.tencent.mm.plugin.webview.modelcache.b.a.sH(com.tencent.mm.plugin.webview.modelcache.b.a.sG(0));
                    } else {
                        v.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, unsupported scheme, url = %s", new Object[]{str});
                    }
                    String Eo = v.Eo(str);
                    p biL = p.biL();
                    List h = !biL.lfs ? null : be.kS(Eo) ? null : biL.h(String.format("select * from %s where %s=? and %s=?", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", "protocol"}), String.valueOf(z.Kg(Eo).hashCode()), String.valueOf(sG));
                    if (be.bP(r1)) {
                        v.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, not cached requestURL = %s, parsed mainURL = %s, protocol = %s", new Object[]{str, Eo, com.tencent.mm.plugin.webview.modelcache.b.a.toString(sG)});
                    } else {
                        String Eo2 = v.Eo(str);
                        if (!be.kS(Eo2)) {
                            Object obj;
                            long Nh = be.Nh();
                            for (i iVar : r1) {
                                if (Nh - iVar.field_createTime > 60 && Eo2.equals(iVar.field_version)) {
                                    obj = 1;
                                    break;
                                }
                            }
                            obj = null;
                            if (obj == null) {
                                v.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, createTime not exceed 1min, no need to update this mainDocument, url = %s", new Object[]{str});
                            } else {
                                byte[] Er = v.Er(str);
                                if (be.bl(Er)) {
                                    v.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, get empty bytes from requestURL = %s", new Object[]{str});
                                } else {
                                    p biL2 = p.biL();
                                    List h2 = !biL2.lfs ? null : be.kS(Eo) ? null : biL2.h(String.format("select * from %s where %s=? and %s", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", p.sJ(sG)}), String.valueOf(z.Kg(Eo).hashCode()));
                                    if (be.bP(r0)) {
                                        v.e("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, get empty list ");
                                    } else {
                                        String bi = z.bi(Er);
                                        for (i iVar2 : r0) {
                                            v.d("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, cacheRes = %s", new Object[]{iVar2});
                                            if (!be.kS(iVar2.field_localPath)) {
                                                if (bi.equals(iVar2.field_contentMd5)) {
                                                    v.i("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, cache not updated");
                                                } else {
                                                    a Ed = a.Ed(iVar2.field_appId);
                                                    if (Ed != null) {
                                                        String str2 = iVar2.field_localPath;
                                                        if (!(be.kS(str2) || be.bl(Er))) {
                                                            if ((FileOp.l(str2, Er) == 0 ? 1 : null) != null && str2.startsWith(Ed.path)) {
                                                                b.a(Ed.lfo, Ed.appId, (long) Er.length);
                                                            }
                                                        }
                                                        iVar2.field_contentMd5 = bi;
                                                        p.biL().e(iVar2);
                                                        v.i("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, updated cacheRes = %s", new Object[]{iVar2});
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static final class a {
        final String appId;
        final String lgs;
        final String lgt;

        private a(String str, String str2, String str3) {
            this.appId = str;
            this.lgs = str2;
            this.lgt = str3;
        }
    }

    private static final class b {
        private static final w lgu = new w();
    }

    private w() {
        this.lgc = new c<ra>(this) {
            final /* synthetic */ w lgl;

            {
                this.lgl = r2;
                this.nhz = ra.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                ra raVar = (ra) bVar;
                if (raVar != null) {
                    final h hVar = new h(raVar.bsH.url, raVar.bsH.filePath, raVar.bsH.version, raVar.bsH.appId, raVar.bsH.bsI, raVar.bsH.bsJ, raVar.bsH.bsK, raVar.bsH.bsL, raVar.bsH.bsM, raVar.bsH.bsN);
                    this.lgl.vA().x(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 lgn;

                        public final void run() {
                            h hVar = hVar;
                            if (hVar != null) {
                                if (be.kS(hVar.appId) || be.kS(hVar.bsI) || be.kS(hVar.filePath)) {
                                    v.i("MicroMsg.WebViewCacheDownloadResponseLogic", "onResponse, invalid response = %s", new Object[]{hVar});
                                    return;
                                }
                                Object obj;
                                v.i("MicroMsg.WebViewCacheDownloadResponseLogic", "onResponse, response = %s", new Object[]{hVar});
                                List<f.c> k = b.lgu.lgi.k(hVar.url, hVar.appId, hVar.bsI, hVar.bsJ);
                                Exception exception = hVar.bsN;
                                if (exception != null) {
                                    v.i("MicroMsg.WebViewCacheDownloadResponseLogic", "onResponse, response.exception = %s", new Object[]{exception});
                                    if (!be.bP(k)) {
                                        String str = exception instanceof SocketTimeoutException ? "timeout" : exception instanceof d ? "not support redirect resource" : exception instanceof f ? "not support 0kb resource" : (!(exception instanceof com.tencent.mm.pluginsdk.k.a.b.a) || hVar.bsM < 5242880) ? "batch download fail" : "exceed cache threshold";
                                        for (f.c cVar : k) {
                                            j.tl(cVar.lfA).x(cVar.lfB, hVar.bsK == 3 ? "publicCache" : "cache", str);
                                            if (hVar.bsK == 1) {
                                                b.lgu.lgi.a(cVar.lfA, hVar.appId, hVar.bsI, hVar.bsJ, hVar.bsK, hVar.url);
                                            } else {
                                                b.lgu.lgi.a(cVar.lfA, hVar.appId, hVar.bsI, hVar.bsJ, hVar.bsK);
                                            }
                                        }
                                    }
                                    obj = 1;
                                } else {
                                    obj = null;
                                }
                                if (obj != null) {
                                    s.dv(7);
                                    return;
                                }
                                i b;
                                if (e.aQ(hVar.filePath) == 0) {
                                    v.i("MicroMsg.WebViewCacheDownloadResponseLogic", "onResponse, readFileLength = 0, return");
                                    if (!be.bP(k)) {
                                        for (f.c cVar2 : k) {
                                            j.tl(cVar2.lfA).x(cVar2.lfB, hVar.bsK == 3 ? "publicCache" : "cache", "batch download fail");
                                            b.lgu.lgi.a(cVar2.lfA, hVar.appId, hVar.bsI, hVar.bsJ, hVar.bsK, hVar.url);
                                        }
                                    }
                                    obj = null;
                                } else {
                                    r rVar;
                                    String Eo = v.Eo(hVar.url);
                                    w biP = b.lgu;
                                    String str2 = hVar.appId;
                                    String str3 = hVar.bsI;
                                    int i = hVar.bsK;
                                    String str4 = hVar.bsJ;
                                    if (be.kS(str2) || be.kS(str3) || be.kS(Eo)) {
                                        v.e("MicroMsg.WebViewCacheWorkerManager", "getWebViewCacheWriter, invalid params | appId = %s, domain = %s, mainURL = %s", new Object[]{str2, str3, Eo});
                                        rVar = null;
                                    } else {
                                        int hashCode = String.format("%s_%s_%s_%s", new Object[]{str2, str3, Integer.valueOf(i), Eo}).hashCode();
                                        r rVar2 = (r) biP.lgg.get(hashCode);
                                        if (rVar2 == null) {
                                            rVar2 = new r(str2, str3, i, Eo, str4);
                                            biP.lgg.put(hashCode, rVar2);
                                        }
                                        rVar = rVar2;
                                    }
                                    obj = null;
                                    if (rVar != null) {
                                        String str5 = hVar.filePath;
                                        String str6 = hVar.version;
                                        String str7 = hVar.bsL;
                                        if (be.kS(str5)) {
                                            v.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, filePath is null or nil");
                                            obj = -1;
                                        } else if (!e.aR(str5)) {
                                            v.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, file not exists");
                                            obj = -1;
                                        } else if (e.aQ(str5) <= 0) {
                                            v.i("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, file size = 0kb");
                                            obj = 6;
                                        } else if (be.kS(str6)) {
                                            v.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, resVersion is null or nil, return");
                                            obj = -1;
                                        } else if (rVar.lfT == null) {
                                            v.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, appIdDir is null, return");
                                            obj = -1;
                                        } else {
                                            long j;
                                            a aVar = rVar.lfT;
                                            String str8 = rVar.bjG;
                                            if (be.kS(str5) || be.kS(str8)) {
                                                j = 0;
                                            } else {
                                                long p = FileOp.p(str5, str8);
                                                if (p > 0 && str8.startsWith(aVar.path)) {
                                                    b.a(aVar.lfo, aVar.appId, p);
                                                }
                                                j = p;
                                            }
                                            b = p.biL().b(rVar.appId, rVar.bsI, rVar.bsK, rVar.lfS, rVar.bsJ);
                                            if (b == null) {
                                                v.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, no db record stored");
                                                obj = -1;
                                            } else {
                                                b.field_localPath = rVar.bjG;
                                                b.field_version = str6;
                                                b.field_contentType = str7;
                                                b.field_contentMd5 = v.Et(b.field_localPath);
                                                b.field_contentLength = j;
                                                p.biL().e(b);
                                                v.i("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, updated record = %s", new Object[]{b});
                                                obj = null;
                                            }
                                        }
                                        obj = obj == null ? 1 : null;
                                    }
                                    if (obj == null) {
                                        if (!be.bP(k)) {
                                            for (f.c cVar22 : k) {
                                                j.tl(cVar22.lfA).x(cVar22.lfB, hVar.bsK == 3 ? "publicCache" : "cache", "batch save fail");
                                                if (hVar.bsK == 1) {
                                                    b.lgu.lgi.a(cVar22.lfA, hVar.appId, hVar.bsI, hVar.bsJ, hVar.bsK, hVar.url);
                                                } else {
                                                    b.lgu.lgi.a(cVar22.lfA, hVar.appId, hVar.bsI, hVar.bsJ, hVar.bsK);
                                                }
                                            }
                                        }
                                        obj = null;
                                    } else {
                                        obj = 1;
                                    }
                                }
                                if (obj == null) {
                                    s.dv(8);
                                } else if (hVar.bsK != 1) {
                                    p biL = p.biL();
                                    List h = !biL.lfs ? null : (be.kS(hVar.appId) || be.kS(hVar.bsI) || be.kS(hVar.bsJ)) ? null : biL.h(String.format("select * from %s where %s=? and %s=? and %s=?", new Object[]{"WebViewResourceCache", "appId", "domain", "packageId"}), hVar.appId, hVar.bsI, hVar.bsJ);
                                    if (!be.bP(r0)) {
                                        for (i b2 : r0) {
                                            if (!v.g(b2)) {
                                                obj = null;
                                                break;
                                            }
                                        }
                                        int i2 = 1;
                                        if (obj != null && !be.bP(k)) {
                                            for (f.c cVar222 : k) {
                                                j.tl(cVar222.lfA).x(cVar222.lfB, "cache", "ok");
                                                b.lgu.lgi.a(cVar222.lfA, hVar.appId, hVar.bsI, hVar.bsJ, hVar.bsK);
                                            }
                                        }
                                    }
                                } else if (!be.bP(k)) {
                                    for (f.c cVar2222 : k) {
                                        j.tl(cVar2222.lfA).x(cVar2222.lfB, "cache", "ok");
                                        b.lgu.lgi.a(cVar2222.lfA, hVar.appId, hVar.bsI, hVar.bsJ, hVar.bsK, hVar.url);
                                    }
                                }
                            }
                        }
                    });
                }
                return false;
            }
        };
        this.lgd = new c<jx>(this) {
            final /* synthetic */ w lgl;

            {
                this.lgl = r2;
                this.nhz = jx.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                if (!(((jx) bVar) == null || !ak.uz() || ak.uG())) {
                    ak.yW();
                    if (be.a((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nrK, null), 0) < be.Nh()) {
                        long bul = (be.bul() / 1000) + 86400;
                        ak.yW();
                        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nrK, Long.valueOf(bul));
                        d dVar = this.lgl.lgh;
                        if (ak.uz()) {
                            b.lgu.vA().x(new Runnable(dVar) {
                                final /* synthetic */ d lfx;

                                {
                                    this.lfx = r1;
                                }

                                public final void run() {
                                    String string;
                                    List list = null;
                                    p biL = p.biL();
                                    if (biL.lfs) {
                                        Cursor rawQuery = biL.rawQuery(String.format("select DISTINCT %s from %s", new Object[]{"appId", "WebViewResourceCache"}), new String[0]);
                                        if (rawQuery != null) {
                                            list = new LinkedList();
                                            if (rawQuery.moveToFirst()) {
                                                string = rawQuery.getString(0);
                                                if (!be.kS(string)) {
                                                    list.add(string);
                                                }
                                            }
                                            rawQuery.close();
                                        }
                                    }
                                    if (!be.bP(r0)) {
                                        for (String str : r0) {
                                            if (!be.kS(str)) {
                                                a Ed = a.Ed(str);
                                                if (Ed != null) {
                                                    long j;
                                                    Ed.biF();
                                                    b bVar = Ed.lfo;
                                                    string = Ed.appId;
                                                    if (bVar.lfs) {
                                                        a aVar = new a();
                                                        aVar.field_appId = string;
                                                        bVar.b(aVar, new String[0]);
                                                        if (aVar.field_occupation > 0) {
                                                            j = aVar.field_occupation;
                                                            if (j > 5242880) {
                                                                s.h(12674, str);
                                                                this.lfx.Ef(str);
                                                            }
                                                        }
                                                    }
                                                    j = 0;
                                                    if (j > 5242880) {
                                                        s.h(12674, str);
                                                        this.lfx.Ef(str);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            });
                        }
                    }
                }
                return false;
            }
        };
        this.lgg = new SparseArray();
        this.lgh = new d();
        this.lgi = new f();
        this.dSD = new Object();
        this.lgj = new byte[0];
        this.lgk = new SparseArray();
    }

    static void cZ(String str, String str2) {
        if (!be.kS(str2)) {
            SharedPreferences btk = aa.btk();
            if (btk != null) {
                btk.edit().putString(str, str2).apply();
            }
        }
    }

    public final void dj(boolean z) {
        for (int i = 0; i < this.lgg.size(); i++) {
            this.lgg.valueAt(i);
        }
        this.lgg.clear();
        a.clearCache();
        if (this.ckz != null) {
            synchronized (this.dSD) {
                if (this.ckz == null) {
                } else if (z) {
                    this.ckz.htb.quit();
                } else {
                    final ad adVar = this.ckz;
                    this.ckz.x(new Runnable(this) {
                        final /* synthetic */ w lgl;

                        public final void run() {
                            Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                                final /* synthetic */ AnonymousClass4 lgq;

                                {
                                    this.lgq = r1;
                                }

                                public final boolean queueIdle() {
                                    if (VERSION.SDK_INT >= 18) {
                                        adVar.htb.getLooper().quitSafely();
                                    } else {
                                        adVar.htb.getLooper().quit();
                                    }
                                    return false;
                                }
                            });
                        }
                    });
                    this.ckz = null;
                }
            }
        }
    }

    public final l biO() {
        if (this.lge == null) {
            this.lge = new l();
        }
        return this.lge;
    }

    public final ad vA() {
        if (this.ckz == null) {
            synchronized (this.dSD) {
                this.ckz = new ad(this, "WebViewCacheWorkerManager#WorkerThread") {
                    final /* synthetic */ w lgl;

                    public final int x(final Runnable runnable) {
                        return super.x(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 lgo;

                            public final void run() {
                                if ((Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() ? 1 : null) == null && Process.getThreadPriority(Process.myTid()) != 10) {
                                    Process.setThreadPriority(10);
                                }
                                if (runnable != null) {
                                    runnable.run();
                                }
                            }
                        });
                    }
                };
            }
        }
        return this.ckz;
    }

    public final void sL(int i) {
        if (ak.uz()) {
            try {
                Set<a> set;
                b.lgu.lgi.sI(i);
                synchronized (this.lgj) {
                    set = (Set) this.lgk.get(i);
                }
                if (set == null) {
                    return;
                }
                if (set.size() > 0) {
                    for (a aVar : set) {
                        biO().a(aVar.appId, aVar.lgs, aVar.lgt, 0, 0, false);
                    }
                }
            } catch (Exception e) {
                v.e("MicroMsg.WebViewCacheWorkerManager", "onWebViewUIDestroy, accHasReady, but occurred exception = %s", new Object[]{e});
            }
        }
    }
}
