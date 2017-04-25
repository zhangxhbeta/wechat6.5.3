package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.ba.a;
import com.tencent.mm.sdk.platformtools.v;

public final class b extends d {
    public b(long j, int i, int i2, byte[] bArr) {
        super(j, i, i2, bArr);
        v.i("MicroMsg.exdevice.ExDeviceCmdAuth", "ExDeviceCmdAuth deviceId = " + j + " seq = " + i + " cmdId = " + i2);
    }

    public final void a(int i, String str, byte[] bArr) {
        v.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------setAuthResponse------ret = " + i + "errMsg = " + str);
        com.tencent.mm.plugin.exdevice.e.b bVar = new com.tencent.mm.plugin.exdevice.e.b();
        bVar.fvT = F(i, str);
        bVar.fvA = com.tencent.mm.ba.b.aT(bArr);
        this.fre = bVar;
        this.frc = (short) 20001;
    }

    protected final a ai(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            v.e("MicroMsg.exdevice.ExDeviceCmdAuth", "paras body is null");
            return null;
        }
        a aVar = new com.tencent.mm.plugin.exdevice.e.a();
        try {
            aVar.az(bArr);
            this.frf = aVar;
            v.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------AuthRequest------ ClientVersion = " + aVar.fvt + " DeviceName = " + aVar.eeA + " Language = " + aVar.fvz + " TimeZone = " + aVar.fvy);
            return aVar;
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.ExDeviceCmdAuth", "AuthRequest.parseFrom Failed!!! %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.exdevice.ExDeviceCmdAuth", e, "", new Object[0]);
            return null;
        }
    }
}
