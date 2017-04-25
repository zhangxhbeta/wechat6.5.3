package com.tencent.mm.pluginsdk.k.a.c;

import com.tencent.mm.compatible.d.w;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class n extends g<l> {
    private final a lEw;
    public final c lEx;

    private static final class c extends PriorityBlockingQueue<Runnable> {
        public final /* synthetic */ boolean offer(Object obj) {
            Runnable runnable = (Runnable) obj;
            boolean offer = super.offer(runnable);
            v.d("MicroMsg.ResDownloader.NetworkWorker.BlockingQueue", "offer() | tid = %d | " + y(runnable), Long.valueOf(Thread.currentThread().getId()));
            return offer;
        }

        public final /* synthetic */ Object poll(long j, TimeUnit timeUnit) {
            Runnable runnable = (Runnable) super.poll(j, timeUnit);
            if (runnable != null) {
                v.d("MicroMsg.ResDownloader.NetworkWorker.BlockingQueue", "poll(long, TimeUnit) | tid = %d | " + y(runnable), Long.valueOf(Thread.currentThread().getId()));
            }
            return runnable;
        }

        public c() {
            super(11, new Comparator<Runnable>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    int random;
                    Runnable runnable = (Runnable) obj;
                    Runnable runnable2 = (Runnable) obj2;
                    if ((runnable instanceof c) && (runnable2 instanceof c) && (((c) runnable).lEi instanceof l) && (((c) runnable2).lEi instanceof l)) {
                        l lVar = (l) ((c) runnable).lEi;
                        l lVar2 = (l) ((c) runnable2).lEi;
                        int i = lVar.priority - lVar2.priority;
                        random = (lVar.bnS() && lVar2.bnS()) ? i != 0 ? i : ((int) (Math.random() * 50.0d)) - 25 : i;
                    } else {
                        random = 0;
                    }
                    return 0 - random;
                }
            });
        }

        private static String y(Runnable runnable) {
            if (!(runnable instanceof c)) {
                return String.format("unknown runnable = %s", new Object[]{runnable});
            } else if (((c) runnable).lEi instanceof l) {
                return String.format("priority = %d, urlKey = %s", new Object[]{Integer.valueOf(((l) ((c) runnable).lEi).priority), ((c) runnable).lEi.bnQ()});
            } else {
                return String.format("unknown request = %s", new Object[]{((c) runnable).lEi});
            }
        }
    }

    public static abstract class a<Req extends l> extends d<Req> implements f {
        private static final ThreadLocal<k> lEy = new ThreadLocal<k>() {
            protected final /* synthetic */ Object initialValue() {
                return new k();
            }
        };
        private volatile int cTV = this.lCY;
        private final int lCY;
        public volatile c lEz;

        public a(Req req) {
            super(req);
            this.lCY = req.lCY;
        }

        public m a(k kVar) {
            if (!Pe()) {
                return kVar.a(this);
            }
            r Hg = a.lED.Hg(bnQ());
            if (Hg != null) {
                Hg.field_status = 1;
                a.lED.e(Hg);
            }
            return kVar.a(this);
        }

        public boolean Pe() {
            return true;
        }

        public final void run() {
            m a = a((k) lEy.get());
            if (a != null) {
                this.lEz.a(this, a);
                return;
            }
            v.e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", Pa());
        }

        public boolean Pb() {
            return false;
        }

        public boolean Pc() {
            return true;
        }

        public boolean Pd() {
            return false;
        }

        public boolean Pf() {
            return true;
        }

        public final String getURL() {
            return ((l) this.lEi).url;
        }

        public final String boa() {
            return "GET";
        }

        public final Collection<b> bob() {
            Map requestHeaders = ((l) this.lEi).getRequestHeaders();
            if (requestHeaders == null || requestHeaders.size() == 0) {
                return null;
            }
            Set<String> keySet = requestHeaders.keySet();
            if (keySet == null || keySet.size() == 0) {
                return null;
            }
            Collection<b> linkedList = new LinkedList();
            for (String str : keySet) {
                String str2 = (String) requestHeaders.get(str);
                if (!be.kS(str2)) {
                    linkedList.add(new b(str, str2));
                }
            }
            return linkedList;
        }

        public final int getConnectTimeout() {
            return ((l) this.lEi).getConnectTimeout();
        }

        public final int getReadTimeout() {
            return ((l) this.lEi).getReadTimeout();
        }

        public final int boc() {
            return ((l) this.lEi).boc();
        }

        public final String bod() {
            return "application/x-www-form-urlencoded;charset=utf-8";
        }

        public final String bnQ() {
            return ((l) this.lEi).lCO;
        }

        public final String OZ() {
            return ((l) this.lEi).OZ();
        }

        public boolean Pg() {
            int i = this.cTV - 1;
            this.cTV = i;
            boolean z = i > 0;
            this.lEz.j(bnQ(), this.lCY, this.cTV);
            return z;
        }

        public boolean dw(long j) {
            this.lEz.m(bnQ(), j);
            v.i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", bnQ(), Long.valueOf(at.btV()));
            if (at.btV() >= j) {
                return true;
            }
            return false;
        }

        public e Ph() {
            return null;
        }
    }

    private static class b extends a<l> {
        b(l lVar) {
            super(lVar);
        }

        public final String Pa() {
            return "ResDownload";
        }
    }

    public n(u uVar, c cVar) {
        this(uVar, cVar, (byte) 0);
    }

    private n(u uVar, c cVar, byte b) {
        this.lEw = new a(this, 4, 4, 3000, TimeUnit.MILLISECONDS, new c(), uVar);
        this.lEw.setKeepAliveTime(30000, TimeUnit.MILLISECONDS);
        this.lEw.allowCoreThreadTimeOut(true);
        this.lEx = cVar;
    }

    public int b(l lVar) {
        if (Hd(lVar.lCO) || Ap(lVar.lCO)) {
            v.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s is already queueing, skip repeated task", lVar.lCO);
            return 0;
        }
        int sb = w.sb();
        v.i("MicroMsg.ResDownloader.NetworkWorker", "currentNetType(%d), requestNetType(%d)", Integer.valueOf(sb), Integer.valueOf(lVar.networkType));
        if (sb != 0) {
            if (2 == lVar.networkType) {
                sb = 1;
            } else if (sb == 1) {
                sb = 1;
            }
            if (sb != 0) {
                v.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", lVar.lCO);
                return 1;
            }
            super.b(lVar);
            return 2;
        }
        sb = 0;
        if (sb != 0) {
            super.b(lVar);
            return 2;
        }
        v.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", lVar.lCO);
        return 1;
    }

    public final boolean Ap(String str) {
        return this.lEg.containsKey(str);
    }

    protected final a bnU() {
        return this.lEw;
    }

    public d a(l lVar) {
        v.i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + lVar.getClass().getSimpleName());
        a.lED;
        d c = p.c(lVar);
        if (c == null) {
            v.i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
            c = new b(lVar);
        }
        c.lEz = this.lEx;
        return c;
    }
}
