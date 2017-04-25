package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.plugin.exdevice.e.c;
import com.tencent.mm.plugin.exdevice.e.n;
import com.tencent.mm.sdk.platformtools.v;

public final class h extends j {
    public h(int i, int i2, long j) {
        n nVar = new n();
        nVar.fvR = new c();
        nVar.fvV = i;
        nVar.fvW = i2;
        this.fre = nVar;
        this.esP = j;
    }

    public final byte[] ait() {
        byte[] bArr = null;
        try {
            bArr = this.fre.toByteArray();
        } catch (Exception e) {
            v.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "mResp.toByteArray() Failed!!! %s", new Object[]{e.getMessage()});
        }
        return bArr;
    }

    public final int aiv() {
        n nVar = (n) this.fre;
        if (nVar != null) {
            return nVar.fvV;
        }
        v.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "null = pushReq");
        return -1;
    }
}
