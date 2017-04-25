package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.g;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.v;

public final class i extends ad {
    private a fym;
    private g fyo;

    public i(int i) {
        this.fyo = new g(i);
    }

    public final boolean a(m mVar, d dVar) {
        if (u.ajV().bk(this.fyo.esP)) {
            this.fym = new a(this.fyo, dVar);
            return this.fym.b(mVar);
        }
        v.w("MicroMsg.exdevice.MMSwitchBackGroudTaskExcuter", "push switch backgroud event to device before it do auth, device id = %d", new Object[]{Long.valueOf(this.fyo.esP)});
        return true;
    }
}
