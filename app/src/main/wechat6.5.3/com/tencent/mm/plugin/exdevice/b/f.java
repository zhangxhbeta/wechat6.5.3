package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;
import com.tencent.mm.plugin.exdevice.e.j;
import com.tencent.mm.plugin.exdevice.e.k;
import com.tencent.mm.plugin.exdevice.e.l;
import com.tencent.mm.sdk.platformtools.v;

public final class f extends d {
    public f(long j, int i, int i2, byte[] bArr) {
        super(j, i, i2, bArr);
        v.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "ExDeviceCmdSendDataToManufacturer deviceId = " + j + " seq = " + i + " cmdId = " + i2);
    }

    public final void b(int i, String str, byte[] bArr) {
        v.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "setSendDataToManufacturerResponse ret = " + i + str);
        j lVar = new l();
        lVar.fvT = F(i, str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        lVar.eew = new b(bArr);
        this.fre = lVar;
        this.frc = (short) 20002;
    }

    protected final a ai(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            v.e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "data is null");
            return null;
        }
        a kVar = new k();
        try {
            kVar.az(bArr);
            this.frf = kVar;
            v.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest cmd has been received");
            return kVar;
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest.parseFrom Failed!!! %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", e, "", new Object[0]);
            return null;
        }
    }
}
