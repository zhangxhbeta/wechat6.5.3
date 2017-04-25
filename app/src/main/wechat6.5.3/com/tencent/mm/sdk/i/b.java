package com.tencent.mm.sdk.i;

import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

final class b {
    private ThreadGroup cOT;
    private final AtomicInteger nmu = new AtomicInteger(1);
    private com.tencent.mm.sdk.i.e.b nmv;

    static class a extends Thread {
        private g nmw;

        a(ThreadGroup threadGroup, g gVar, String str) {
            super(threadGroup, gVar, str);
            this.nmw = gVar;
        }

        public final void start() {
            super.start();
        }

        public final void run() {
            super.run();
        }
    }

    b(com.tencent.mm.sdk.i.e.b bVar) {
        this.nmv = bVar;
        this.cOT = new ThreadGroup("MM_FREE_THREAD_GROUP");
    }

    final Thread a(Runnable runnable, String str, int i) {
        Assert.assertNotNull("newThread arg name is null!", str);
        if (runnable != null) {
            Thread aVar = new a(this.cOT, new g(runnable, str, i, false, this.nmv), "MM_Thread_Pool_Free_Thread#" + this.nmu.getAndIncrement() + "#" + str);
            aVar.setPriority(i);
            return aVar;
        }
        Thread aVar2 = new a(this.cOT, null, "MM_Thread_Pool_Free_Thread#" + this.nmu.getAndIncrement() + "#" + str);
        aVar2.setPriority(i);
        return aVar2;
    }
}
