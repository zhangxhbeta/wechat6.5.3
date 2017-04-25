package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.o.a;
import com.tencent.mm.sdk.platformtools.v;
import junit.framework.Assert;

public final class n extends a {
    private c fyd = null;

    public n(c cVar) {
        Assert.assertNotNull(cVar);
        this.fyd = cVar;
    }

    public final long ajN() {
        v.i("MicroMsg.exdevice.RemoteExDeviceTaskRequest", "getDeviceId : " + this.fyd.esP);
        return this.fyd.esP;
    }

    public final byte[] ajO() {
        return this.fyd.ait();
    }

    public final int ajP() {
        return this.fyd.air();
    }

    public final int ajQ() {
        return this.fyd.frc;
    }

    public final int ajR() {
        return this.fyd.ais();
    }
}
