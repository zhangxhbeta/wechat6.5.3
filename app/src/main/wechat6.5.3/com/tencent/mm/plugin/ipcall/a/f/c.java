package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.a.b;
import com.tencent.mm.plugin.ipcall.a.d.f;
import com.tencent.mm.sdk.platformtools.v;

public final class c extends b {
    private f gIt;

    public final int[] aux() {
        return new int[]{824};
    }

    public final void onStop() {
        if (this.gIt != null) {
            ak.vy().c(this.gIt);
        }
    }

    public final int CV() {
        return 5;
    }

    public final void op() {
    }

    public final void onDestroy() {
    }

    public final void b(com.tencent.mm.plugin.ipcall.a.a.c cVar) {
        if (this.gFa != null) {
            this.gIt = new f(this.gFa.gFG, this.gFa.gFH, this.gFa.gFI);
            ak.vy().a(this.gIt, 0);
        }
    }

    public final int auy() {
        return 50000;
    }

    public final void auz() {
        v.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopSuccess");
    }

    public final void auA() {
        v.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopFailed");
    }
}
