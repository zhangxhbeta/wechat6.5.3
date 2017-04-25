package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.sdk.platformtools.v;

public class u extends Thread {
    private boolean ejL = false;

    public final synchronized void kill() {
        this.ejL = true;
        v.i("MicroMsg.MMThread", "interrupt before");
        interrupt();
        v.i("MicroMsg.MMThread", "interrupt after");
    }

    final synchronized boolean Wa() {
        if (this.ejL) {
            v.w("MicroMsg.MMThread", "the thread has beed killed!!");
        }
        return this.ejL;
    }
}
