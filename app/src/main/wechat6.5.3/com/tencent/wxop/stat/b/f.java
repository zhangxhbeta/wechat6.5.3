package com.tencent.wxop.stat.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class f {
    ExecutorService pLL;

    public f() {
        this.pLL = null;
        this.pLL = Executors.newSingleThreadExecutor();
    }

    public final void a(Runnable runnable) {
        this.pLL.execute(runnable);
    }
}
