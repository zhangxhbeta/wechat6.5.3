package com.tencent.wxop.stat;

import android.content.Context;

final class g implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ int b = -1;

    g(Context context, int i) {
        this.a = context;
    }

    public final void run() {
        try {
            d.gO(this.a);
            r.gR(this.a).a(this.b);
        } catch (Throwable th) {
            d.pKH.i(th);
            d.a(this.a, th);
        }
    }
}
