package com.tencent.mm.av;

import com.tencent.mm.vending.h.d;

public final class c extends d {
    public final void g(Runnable runnable) {
        runnable.run();
    }

    public final void d(Runnable runnable, long j) {
        runnable.run();
    }

    public final String getType() {
        return "WxNoLooperScheduler";
    }

    public final void cancel() {
    }
}
