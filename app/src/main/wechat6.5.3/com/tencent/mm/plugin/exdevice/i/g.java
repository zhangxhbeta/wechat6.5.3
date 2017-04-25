package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.i;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.v;

public final class g extends ad {
    private c fyl;
    private a fym;

    public g(byte[] bArr, int i, long j) {
        this.fyl = new i(bArr, i, j);
    }

    public final boolean a(m mVar, d dVar) {
        if (u.ajV().bk(this.fyl.esP)) {
            this.fym = new a(this.fyl, dVar);
            return this.fym.b(mVar);
        }
        v.w("MicroMsg.exdevice.MMPushManufacturerSvrSendDataLogic", "Service push data to device before it do auth, device id = %d", new Object[]{Long.valueOf(this.fyl.esP)});
        return true;
    }
}
