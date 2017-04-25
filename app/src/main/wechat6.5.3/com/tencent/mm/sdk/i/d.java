package com.tencent.mm.sdk.i;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class d implements ThreadFactory {
    private ThreadGroup cOT = new ThreadGroup("MM_THREAD_POOL_GROUP");
    private final AtomicInteger nmu = new AtomicInteger(1);

    d() {
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.cOT, runnable, "MM_Thread_Pool_Thread#" + this.nmu.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
