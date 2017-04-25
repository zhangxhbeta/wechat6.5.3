package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.ba.a;
import com.tencent.mm.sdk.platformtools.v;

public abstract class d extends c {
    protected a frf = null;
    private short frg = (short) -1;
    private short frh = (short) -1;

    protected abstract a ai(byte[] bArr);

    public d(long j, int i, int i2, byte[] bArr) {
        v.i("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "onDeviceRequest deviceId = " + j + " seq = " + i + " cmdId = " + i2);
        this.esP = j;
        this.frg = (short) i2;
        this.frh = (short) i;
        ai(bArr);
    }

    public final short air() {
        return this.frg;
    }

    public final short ais() {
        return this.frh;
    }

    public final a aiu() {
        return this.frf;
    }

    public final byte[] ait() {
        try {
            return this.fre.toByteArray();
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "mResp.toByteArray() Failed!!! %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", e, "", new Object[0]);
            return null;
        }
    }
}
