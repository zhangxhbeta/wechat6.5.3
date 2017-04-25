package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public interface e {

    public static class a {
        private Lock fWu = new ReentrantLock();
        private LinkedBlockingQueue<e> hqF;
        private final int hqG;
        private Callable<e> hqH;
        private volatile int size = 0;

        public a(int i, Callable<e> callable) {
            this.hqG = i;
            this.hqF = new LinkedBlockingQueue(i);
            this.hqH = callable;
        }

        public final e aAM() {
            e eVar = null;
            long Nj = be.Nj();
            v.d("FetcherPool", "acquireFetcher");
            if (this.hqF == null) {
                v.d("FetcherPool", "acquireFetcher no pool directly return null");
            } else {
                this.fWu.lock();
                v.d("FetcherPool", "pool.size() %d, size %d, maxFetcherSize %d", new Object[]{Integer.valueOf(this.hqF.size()), Integer.valueOf(this.size), Integer.valueOf(this.hqG)});
                if (this.hqF == null) {
                    this.fWu.unlock();
                } else {
                    if (!this.hqF.isEmpty() || this.size >= this.hqG) {
                        v.d("FetcherPool", "waiting fetcher");
                        this.fWu.unlock();
                        eVar = (e) this.hqF.poll(5, TimeUnit.SECONDS);
                    } else {
                        v.d("FetcherPool", "new fetcher");
                        this.size++;
                        this.fWu.unlock();
                        eVar = aAN();
                    }
                    v.d("FetcherPool", "time flee, acquireFetcher cost time %d", new Object[]{Long.valueOf(be.az(Nj))});
                }
            }
            return eVar;
        }

        private e aAN() {
            if (this.hqH == null) {
                throw new IllegalStateException("fetcher generator can not be null.");
            }
            try {
                e eVar = (e) this.hqH.call();
                v.d("FetcherPool", "time flee, construct fetcher instance cost %d", new Object[]{Long.valueOf(be.az(be.Nj()))});
                return eVar;
            } catch (Throwable e) {
                v.a("FetcherPool", e, " fetcher generater call error %s", new Object[]{e.getMessage()});
                throw e;
            }
        }

        public final void a(e eVar) {
            v.d("FetcherPool", "reuseFetcher");
            if (eVar == null) {
                v.e("FetcherPool", "Null object can not be reused.");
            } else if (this.hqF == null) {
                eVar.release();
            } else if (this.hqF.contains(eVar)) {
                throw new IllegalStateException("fetcher already in pool");
            } else {
                this.hqF.offer(eVar);
            }
        }

        public final void destroy() {
            if (this.hqF != null) {
                this.fWu.lock();
                if (this.hqF == null) {
                    this.fWu.unlock();
                    return;
                }
                try {
                    Iterator it = this.hqF.iterator();
                    while (it.hasNext()) {
                        ((e) it.next()).release();
                    }
                } catch (Throwable e) {
                    v.a("FetcherPool", e, "destroy fetcher %s", new Object[]{e.getMessage()});
                } finally {
                    this.hqF = null;
                    this.fWu.unlock();
                }
            }
        }
    }

    int getDurationMs();

    Bitmap getFrameAtTime(long j);

    int getScaledHeight();

    int getScaledWidth();

    void init(String str, int i, int i2, int i3);

    void release();

    void reuseBitmap(Bitmap bitmap);
}
