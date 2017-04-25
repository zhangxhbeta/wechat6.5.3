package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.ba.b;
import com.tencent.mm.plugin.exdevice.e.c;
import com.tencent.mm.plugin.exdevice.e.h;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import junit.framework.Assert;

public final class i extends j {
    public i(byte[] bArr, int i, long j) {
        h hVar = new h();
        hVar.fvR = new c();
        hVar.eew = new b(bArr);
        hVar.efm = i;
        this.fre = hVar;
        this.esP = j;
    }

    public final byte[] ait() {
        Assert.assertNotNull(this.fre);
        try {
            return this.fre.toByteArray();
        } catch (IOException e) {
            v.e("MicroMsg.exdevice.ExDevicePushManufacturerSvrSendData", "mResp.toByteArray() Failed!!! %s", new Object[]{e.getMessage()});
            return null;
        }
    }
}
