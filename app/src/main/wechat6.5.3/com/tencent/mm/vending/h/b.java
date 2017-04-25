package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;

public final class b implements a {
    public Handler mHandler;

    public b(Handler handler) {
        this.mHandler = handler;
    }

    public final void f(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    public final void c(Runnable runnable, long j) {
        this.mHandler.postDelayed(runnable, j);
    }

    public final Looper getLooper() {
        return this.mHandler.getLooper();
    }

    public final void cp() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
