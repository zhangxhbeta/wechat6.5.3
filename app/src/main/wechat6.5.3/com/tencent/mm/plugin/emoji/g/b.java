package com.tencent.mm.plugin.emoji.g;

import com.tencent.mm.ae.a.c.h;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class b {
    public final int cOW;
    public final int feI;
    public final Executor feJ;

    public static class a {
        int cOW = 10;
        int feI = 1;
        ExecutorService feK;
    }

    public static class b extends ThreadPoolExecutor implements h {
        private boolean cOX;
        private ReentrantLock cOY = new ReentrantLock();
        private Condition cOZ = this.cOY.newCondition();

        public b(int i, int i2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i, i2, 0, timeUnit, blockingQueue, threadFactory);
        }

        protected final void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            this.cOY.lock();
            while (this.cOX) {
                try {
                    this.cOZ.await();
                } catch (Exception e) {
                    thread.interrupt();
                    v.w("MicroMsg.imageloader.DefaultThreadPoolExecutor", "[cpan] before execute exception:%s", new Object[]{e.toString()});
                } finally {
                    this.cOY.unlock();
                }
            }
        }

        public final void pause() {
            this.cOY.lock();
            try {
                this.cOX = true;
            } finally {
                this.cOY.unlock();
            }
        }

        public final void resume() {
            this.cOY.lock();
            try {
                this.cOX = false;
                this.cOZ.signalAll();
            } finally {
                this.cOY.unlock();
            }
        }

        public final void execute(Runnable runnable) {
            super.execute(runnable);
        }

        public final boolean oZ() {
            return this.cOX;
        }

        public final void remove(Object obj) {
        }
    }

    public static class c implements ThreadFactory {
        private static final AtomicInteger cOS = new AtomicInteger(1);
        private final ThreadGroup cOT;
        private final AtomicInteger cOU = new AtomicInteger(1);
        private final String cOV;
        private final int cOW;

        c(int i, String str) {
            this.cOW = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.cOT = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.cOV = str + cOS.getAndIncrement() + "-thread-";
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.cOT, runnable, this.cOV + this.cOU.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.cOW);
            return thread;
        }
    }

    public b(a aVar) {
        this.feI = aVar.feI;
        this.cOW = aVar.cOW;
        this.feJ = aVar.feK;
    }
}
