package com.tencent.wxop.stat;

import android.content.Context;

final class h implements Runnable {
    final /* synthetic */ Context a;

    h(Context context) {
        this.a = context;
    }

    public final void run() {
        try {
            new Thread(new m(this.a), "NetworkMonitorTask").start();
        } catch (Throwable th) {
            d.pKH.i(th);
            d.a(this.a, th);
        }
    }
}
