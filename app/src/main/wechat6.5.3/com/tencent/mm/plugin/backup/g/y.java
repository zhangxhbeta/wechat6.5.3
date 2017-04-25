package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.sdk.platformtools.v;

public final class y {
    private long cvj = 0;
    private long ejX = -1;
    boolean ejY = false;

    public final void begin() {
        v.d("MicroMsg.Recoverfaster", "begin");
        if (b.Vd().ckb != null) {
            this.ejX = b.Vd().ckb.er(Thread.currentThread().getId());
            this.ejY = true;
        }
        this.cvj = System.currentTimeMillis();
    }

    public final void end() {
        if (this.ejY && b.Vd().ckb != null) {
            b.Vd().ckb.es(this.ejX);
            this.ejY = false;
        }
    }

    public final void Wd() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cvj > 10000) {
            end();
            begin();
            this.cvj = currentTimeMillis;
        }
    }
}
