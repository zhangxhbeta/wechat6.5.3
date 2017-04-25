package com.tencent.mm.av;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.h.a;

public final class b implements a {
    private ac mHandler;

    private b(ac acVar) {
        this.mHandler = acVar;
    }

    public static b b(ac acVar) {
        return new b(acVar);
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
