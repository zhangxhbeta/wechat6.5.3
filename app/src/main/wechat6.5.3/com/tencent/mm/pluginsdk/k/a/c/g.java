package com.tencent.mm.pluginsdk.k.a.c;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class g<T extends b> {
    final Map<String, b> lEf = new ConcurrentHashMap();
    final Map<String, Future<?>> lEg = new ConcurrentHashMap();

    protected class a extends ThreadPoolExecutor {
        final /* synthetic */ g lEh;

        public a(g gVar, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, u uVar) {
            this.lEh = gVar;
            super(i, i2, j, timeUnit, blockingQueue, uVar);
        }

        protected final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
            if (runnable instanceof d) {
                return new c(runnable, v, ((d) runnable).lEi);
            }
            return super.newTaskFor(runnable, v);
        }

        protected final void terminated() {
            this.lEh.lEg.clear();
            super.terminated();
        }

        protected final void beforeExecute(Thread thread, Runnable runnable) {
            if (runnable instanceof c) {
                c cVar = (c) runnable;
                if (this.lEh.lEg.containsKey(cVar.lEi.bnQ())) {
                    cVar.cancel(false);
                } else {
                    this.lEh.lEg.put(cVar.lEi.bnQ(), cVar);
                    this.lEh.lEf.remove(cVar.lEi.bnQ());
                }
            } else {
                v.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", runnable.getClass().getSimpleName());
            }
            super.beforeExecute(thread, runnable);
        }

        protected final void afterExecute(Runnable runnable, Throwable th) {
            if (runnable instanceof c) {
                c cVar = (c) runnable;
                this.lEh.lEg.remove(cVar.lEi.bnQ());
                this.lEh.lEf.remove(cVar.lEi.bnQ());
            } else {
                v.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", runnable.getClass().getSimpleName());
            }
            super.afterExecute(runnable, th);
        }
    }

    public interface b {
        String bnQ();
    }

    protected static class c<V> extends FutureTask<V> {
        protected final b lEi;

        public c(Runnable runnable, V v, b bVar) {
            super(runnable, v);
            this.lEi = bVar;
        }
    }

    protected static abstract class d<Req extends b> implements Runnable {
        public final Req lEi;

        public d(Req req) {
            this.lEi = req;
        }

        public void run() {
            if (Process.getThreadPriority(Process.myTid()) != 10) {
                Process.setThreadPriority(10);
            }
        }
    }

    public abstract d a(T t);

    public abstract a bnU();

    public final void b(T t) {
        this.lEf.put(t.bnQ(), t);
        bnU().submit(a(t));
    }

    public final boolean Hd(String str) {
        return this.lEg.containsKey(str) || this.lEf.containsKey(str);
    }
}
