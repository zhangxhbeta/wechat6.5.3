package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.b;
import com.tencent.wxop.stat.a.f;

final class j implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ e pLh;

    j(Context context, String str, e eVar) {
        this.a = context;
        this.b = str;
        this.pLh = eVar;
    }

    public final void run() {
        try {
            Long l;
            d.gO(this.a);
            synchronized (d.pKF) {
                l = (Long) d.pKF.remove(this.b);
            }
            if (l != null) {
                Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                if (valueOf.longValue() <= 0) {
                    valueOf = Long.valueOf(1);
                }
                String j = d.n;
                if (j != null && j.equals(this.b)) {
                    j = "-";
                }
                b fVar = new f(this.a, j, this.b, d.a(this.a, false, this.pLh), valueOf, this.pLh);
                if (!this.b.equals(d.m)) {
                    d.pKH.warn("Invalid invocation since previous onResume on diff page.");
                }
                new n(fVar).a();
                d.n = this.b;
                return;
            }
            d.pKH.by("Starttime for PageID:" + this.b + " not found, lost onResume()?");
        } catch (Throwable th) {
            d.pKH.i(th);
            d.a(this.a, th);
        }
    }
}
