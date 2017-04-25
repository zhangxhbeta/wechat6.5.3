package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.h;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.v;

public final class j extends ad {
    private a fyp;
    private h fyq;

    public j(int i, int i2, long j) {
        this.fyq = new h(i, i2, j);
    }

    public final boolean a(m mVar, d dVar) {
        if (u.ajV().bk(this.fyq.esP)) {
            this.fyp = new b(this.fyq, dVar);
            return this.fyp.b(mVar);
        }
        v.w("MicroMsg.exdevice.MMSwitchViewPushTaskExcuter", "push switchview event to device before it do auth, device id = %d", new Object[]{Long.valueOf(this.fyq.esP)});
        return true;
    }
}
