package com.tencent.mm.memory;

import com.tencent.mm.sdk.platformtools.v;
import java.util.NavigableMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentSkipListMap;

public abstract class e<T, S extends Comparable> {
    protected NavigableMap<S, d<T, S>> cnr = new ConcurrentSkipListMap();
    private Vector<a> cns = new Vector();
    protected long cnt = 0;

    public abstract class a {
        final /* synthetic */ e cnu;

        public abstract S wf();

        public abstract long wg();

        public abstract int wh();

        public a(e eVar) {
            this.cnu = eVar;
        }
    }

    public abstract long as(T t);

    public abstract S at(T t);

    public abstract S b(S s);

    public abstract d<T, S> c(S s);

    public abstract T d(S s);

    public abstract long wa();

    public abstract long wb();

    static /* synthetic */ void a(e eVar) {
        while (eVar.cns.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            a aVar = (a) eVar.cns.remove(0);
            d c = eVar.c(eVar.b(aVar.wf()));
            long j = 0;
            int i = 0;
            long wg = aVar.wg();
            int wh = aVar.wh();
            v.i("MicroMsg.BucketPool", "%s preload start preloadSize: %s sizeInBytes: %s  preLoadBytes: %s and nums: %s", eVar, aVar.wf(), eVar.b(aVar.wf()), Long.valueOf(wg), Integer.valueOf(wh));
            while (eVar.cnt < eVar.wa() && ((wg <= 0 || j < wg) && (wh <= 0 || i < wh))) {
                Object d = eVar.d(aVar.wf());
                c.put(d);
                j += eVar.as(d);
                i++;
                eVar.I(eVar.as(d));
            }
            j = System.currentTimeMillis();
            v.d("MicroMsg.BucketPool", "%s preload finished, put %d elements, used %dms", eVar, Integer.valueOf(c.size()), Long.valueOf(j - currentTimeMillis));
            eVar.cnr.put(eVar.b(aVar.wf()), c);
        }
    }

    public final void a(a aVar) {
        this.cns.add(aVar);
        v.i("MicroMsg.BucketPool", "%s addPreload: %s", this, aVar);
        we();
    }

    public final void we() {
        if (this.cns.size() > 0) {
            com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                final /* synthetic */ e cnu;

                {
                    this.cnu = r1;
                }

                public final void run() {
                    e.a(this.cnu);
                }
            }, "BucketPool_preload");
        }
    }

    public synchronized T a(S s) {
        T t;
        d dVar = (d) this.cnr.get(s);
        if (dVar == null || dVar.size() <= 0) {
            v.d("MicroMsg.BucketPool", "BucketPool get cannot get %s size", s);
            t = null;
        } else {
            T pop = dVar.pop();
            this.cnr.put(dVar.wd(), dVar);
            J(as(pop));
            t = pop;
        }
        return t;
    }

    public synchronized void ar(T t) {
        if (t != null) {
            Comparable at = at(t);
            long as = as(t);
            if (as > wb()) {
                v.e("MicroMsg.BucketPool", "release, reach maximum element size: %s, ignore this", Long.valueOf(as));
            } else if (this.cnt + as > wa()) {
                v.e("MicroMsg.BucketPool", "release, reach maximum size, just ignore %s %s", Long.valueOf(as), Long.valueOf(this.cnt));
            } else {
                d dVar = (d) this.cnr.get(at);
                if (dVar == null) {
                    dVar = c(at);
                }
                dVar.put(t);
                this.cnr.put(at, dVar);
                I(as);
            }
        }
    }

    private synchronized void I(long j) {
        this.cnt += j;
    }

    protected final synchronized void J(long j) {
        this.cnt -= j;
    }

    public void wc() {
        v.i("MicroMsg.BucketPool", "freeAll: %s", getClass().getName());
        this.cnr.clear();
        this.cnt = 0;
    }
}
