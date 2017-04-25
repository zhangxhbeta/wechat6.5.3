package com.tencent.wxop.stat;

import com.tencent.wxop.stat.b.l;
import java.util.TimerTask;

final class ae extends TimerTask {
    final /* synthetic */ ad pLZ;

    ae(ad adVar) {
        this.pLZ = adVar;
    }

    public final void run() {
        if (b.bPW()) {
            l.bQC().bw("TimerTask run");
        }
        d.gP(this.pLZ.c);
        cancel();
        this.pLZ.a();
    }
}
