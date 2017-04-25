package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.f;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.v;

public final class h extends ad {
    private f fro;
    private a fyn;

    public h(f fVar) {
        this.fro = fVar;
    }

    public final boolean a(m mVar, d dVar) {
        this.fyn = new a(this.fro, dVar);
        v.i("MicroMsg.exdevice.MMSendDataToDeviceExcuter", "send data to devide : %b", new Object[]{Boolean.valueOf(this.fyn.b(mVar))});
        return this.fyn.b(mVar);
    }
}
