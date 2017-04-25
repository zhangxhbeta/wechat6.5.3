package com.tencent.wxop.stat;

import com.tencent.wxop.stat.a.a;
import java.lang.Thread.UncaughtExceptionHandler;

final class l implements UncaughtExceptionHandler {
    l() {
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (b.bPX() && d.pKJ != null) {
            if (b.bQg()) {
                r.gR(d.pKJ).b(new a(d.pKJ, d.a(d.pKJ, false, null), th, thread), null, false, true);
                d.pKH.debug("MTA has caught the following uncaught exception:");
                d.pKH.bQy();
            }
            d.gO(d.pKJ);
            if (d.pKI != null) {
                d.pKH.bz("Call the original uncaught exception handler.");
                if (!(d.pKI instanceof l)) {
                    d.pKI.uncaughtException(thread, th);
                }
            }
        }
    }
}
