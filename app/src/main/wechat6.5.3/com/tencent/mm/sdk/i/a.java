package com.tencent.mm.sdk.i;

import android.os.HandlerThread;
import com.tencent.mm.sdk.i.e.b;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

public final class a {
    private ThreadGroup cOT;
    private final AtomicInteger nmu = new AtomicInteger(1);
    private b nmv;

    static class a extends HandlerThread {
        a(String str, int i) {
            super(str, i);
        }

        public final void start() {
            super.start();
        }

        public final void run() {
            super.run();
        }
    }

    a(b bVar) {
        this.nmv = bVar;
        this.cOT = new ThreadGroup("MM_FREE_THREAD_GROUP");
    }

    final HandlerThread bI(String str, int i) {
        Assert.assertNotNull("newThread arg name is null!", str);
        return new a("MM_Thread_Pool_Free_Handler_Thread#" + this.nmu.getAndIncrement() + "#" + str, i);
    }
}
