package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.sdk.i.e;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class c extends ThreadPoolExecutor {
    private static volatile c dLo = null;

    private c() {
        super(4, 6, 15000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                return e.d(runnable, "AppBrandPreparingThread", 5);
            }
        }, new RejectedExecutionHandler() {
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                if (runnable != null) {
                    e.a(runnable, "AppBrandPreparingThread");
                }
            }
        });
    }

    public static void QB() {
        if (dLo != null) {
            synchronized (c.class) {
                if (dLo != null) {
                    dLo.shutdownNow();
                }
            }
        }
        dLo = null;
    }

    public static c QC() {
        if (dLo == null) {
            synchronized (c.class) {
                if (dLo == null) {
                    dLo = new c();
                }
            }
        }
        return dLo;
    }
}
