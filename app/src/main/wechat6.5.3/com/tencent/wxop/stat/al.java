package com.tencent.wxop.stat;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.wxop.stat.b.l;

final class al implements Runnable {
    final /* synthetic */ Context a;

    al(Context context) {
        this.a = context;
    }

    public final void run() {
        f gQ = f.gQ(d.pKJ);
        gQ.pKN.getApplicationContext().registerReceiver(new x(gQ), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        l.v(this.a, true);
        r.gR(this.a);
        ai.hu(this.a);
        d.pKI = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new l());
        if (b.bPV() == c.APP_LAUNCH) {
            d.gN(this.a);
        }
        if (b.bPW()) {
            d.pKH.bz("Init MTA StatService success.");
        }
    }
}
