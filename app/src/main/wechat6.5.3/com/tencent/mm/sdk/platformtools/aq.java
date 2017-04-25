package com.tencent.mm.sdk.platformtools;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class aq {
    private static final ConcurrentLinkedQueue<Runnable> nkE = new ConcurrentLinkedQueue();
    private static ExecutorService nkF = null;

    aq() {
    }

    public static ExecutorService btL() {
        ExecutorService executorService;
        synchronized (aq.class) {
            if (nkF == null) {
                nkF = Executors.newSingleThreadExecutor();
            }
            executorService = nkF;
        }
        return executorService;
    }

    public static void D(Runnable runnable) {
        nkE.add(runnable);
    }

    public static void E(Runnable runnable) {
        nkE.remove(runnable);
    }
}
