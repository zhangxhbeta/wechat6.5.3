package com.tencent.mm.pluginsdk.k.a.c;

import android.os.Looper;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

public final class p {
    private volatile ad ckz;
    public final ac handler;
    final s lEA;
    public final n lEB;
    public final j lEC;
    public final boolean lfs;

    private static final class a {
        private static final p lED = new p();
    }

    private static class b implements Runnable {
        private final Runnable djm;

        private b(Runnable runnable) {
            this.djm = runnable;
        }

        public final void run() {
            if ((Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() ? 1 : null) == null && Process.getThreadPriority(Process.myTid()) != 10) {
                Process.setThreadPriority(10);
            }
            if (this.djm != null) {
                this.djm.run();
            }
        }
    }

    private p() {
        this.ckz = null;
        q.init();
        this.lEA = s.boi();
        if (this.lEA == null) {
            this.lfs = false;
            this.lEB = null;
            this.handler = null;
            this.lEC = null;
            return;
        }
        this.lfs = true;
        u uVar = new u();
        this.handler = new ac(Looper.getMainLooper());
        this.lEC = new j(vA().btx());
        this.lEB = new n(uVar, this.lEC);
    }

    public final void q(Runnable runnable) {
        vA().x(new b(runnable));
    }

    final ad vA() {
        if (this.ckz == null) {
            this.ckz = new ad("ResDownloader-WorkerThread");
        }
        return this.ckz;
    }

    public final void a(String str, d dVar) {
        v.d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", str, dVar);
        if (this.lfs) {
            j jVar = this.lEC;
            v.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = " + dVar);
            if (dVar != null) {
                int hashCode = str.hashCode();
                synchronized (jVar.lEl) {
                    List list = (List) jVar.lEk.get(hashCode);
                    if (list == null) {
                        list = new LinkedList();
                    }
                    list.add(dVar);
                    jVar.lEk.put(hashCode, list);
                }
            }
        }
    }

    static com.tencent.mm.pluginsdk.k.a.c.n.a c(l lVar) {
        v.d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
        int hashCode = lVar.Pa().hashCode();
        for (h hVar : q.boh()) {
            v.i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", hVar.getClass().getSimpleName(), hVar.Pa());
            if (hVar.Pa().hashCode() == hashCode) {
                return hVar.c(lVar);
            }
        }
        return null;
    }

    public final void hp(String str) {
        if (this.lfs) {
            this.lEA.hc(str);
        }
    }

    public final void e(r rVar) {
        if (this.lfs) {
            long Ni = be.Ni();
            if (this.lEA.Hg(rVar.field_urlKey) != null) {
                v.i("MicroMsg.ResDownloaderCore", "doUpdate: update existing record");
                this.lEA.f(rVar);
            } else {
                v.i("MicroMsg.ResDownloaderCore", "doUpdate: insert new record");
                this.lEA.g(rVar);
            }
            v.i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, cost = %d", rVar.field_urlKey, Long.valueOf(be.ay(Ni)));
        }
    }

    public final r Hg(String str) {
        if (!this.lfs) {
            return null;
        }
        long Ni = be.Ni();
        r Hg = this.lEA.Hg(str);
        String str2 = "MicroMsg.ResDownloaderCore";
        String str3 = "doQuery: urlKey = %s, cost = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Hg == null ? "null" : Hg.field_urlKey;
        objArr[1] = Long.valueOf(be.ay(Ni));
        v.i(str2, str3, objArr);
        return Hg;
    }

    public final int d(l lVar) {
        if (!this.lfs) {
            return -1;
        }
        if (be.kS(lVar.url)) {
            v.i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", lVar.lCO);
            return 3;
        }
        v.i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", lVar.lCO);
        return this.lEB.b(lVar);
    }

    public final boolean Hh(String str) {
        if (!this.lfs) {
            return false;
        }
        if (this.lEB.Ap(str) || this.lEB.Hd(str)) {
            return true;
        }
        return false;
    }

    public final void Hi(String str) {
        if (this.lfs) {
            g gVar = this.lEB;
            Future future = (Future) gVar.lEg.remove(str);
            if (future != null) {
                future.cancel(true);
            }
            gVar.lEf.remove(str);
        }
    }
}
