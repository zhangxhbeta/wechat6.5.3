package com.tencent.mm.pluginsdk.k.a.c;

import com.tencent.mm.sdk.i.e;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class u implements ThreadFactory {
    private static final AtomicInteger lEL = new AtomicInteger(1);
    private final AtomicInteger cOU;
    private String cOV;

    public u() {
        this("ResDownloaderPool", "ResDownloaderThread");
    }

    public u(String str, String str2) {
        this.cOU = new AtomicInteger(1);
        this.cOV = String.format("%s-%d-%s-", new Object[]{str, Integer.valueOf(lEL.getAndIncrement()), str2});
    }

    public final Thread newThread(Runnable runnable) {
        Thread d = e.d(runnable, this.cOV + this.cOU.getAndIncrement(), 1);
        if (d.isDaemon()) {
            d.setDaemon(false);
        }
        return d;
    }
}
