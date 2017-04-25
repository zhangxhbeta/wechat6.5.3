package com.tencent.wxop.stat;

import android.content.Context;

final class ap implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ e pLh;

    ap(String str, Context context, e eVar) {
        this.a = str;
        this.b = context;
        this.pLh = eVar;
    }

    public final void run() {
        try {
            synchronized (d.pKF) {
                if (d.pKF.size() >= b.bQf()) {
                    d.pKH.error("The number of page events exceeds the maximum value " + Integer.toString(b.bQf()));
                    return;
                }
                d.m = this.a;
                if (d.pKF.containsKey(d.m)) {
                    d.pKH.by("Duplicate PageID : " + d.m + ", onResume() repeated?");
                    return;
                }
                d.pKF.put(d.m, Long.valueOf(System.currentTimeMillis()));
                d.a(this.b, true, this.pLh);
            }
        } catch (Throwable th) {
            d.pKH.i(th);
            d.a(this.b, th);
        }
    }
}
