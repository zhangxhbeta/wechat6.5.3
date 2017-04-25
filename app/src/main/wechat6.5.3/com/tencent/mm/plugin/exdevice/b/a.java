package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.plugin.exdevice.i.e;
import com.tencent.mm.plugin.exdevice.i.f;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.v;

public final class a extends com.tencent.mm.plugin.exdevice.service.i.a {
    private static a fqY = null;

    private static class a implements Runnable {
        private int dLU;
        private long esP = -1;
        private int fqZ = -1;
        private int fra = -1;
        private byte[] frb = null;

        public a(int i, long j, int i2, int i3, byte[] bArr) {
            this.esP = j;
            this.fqZ = i2;
            this.fra = i3;
            this.frb = bArr;
            this.dLU = i;
        }

        public final void aiq() {
            if (this.esP == -1 || this.fqZ == -1 || this.fra == -1) {
                v.e("MicroMsg.RequestProcessThread", "invalid arguments, do nothing");
                return;
            }
            switch (this.fra) {
                case 10001:
                    u.ajW().a(new e(this.dLU, this.esP, this.fqZ, this.fra, this.frb));
                    return;
                case 10002:
                    k aiw = k.aiw();
                    aiw.mHandler.obtainMessage(1, this.dLU, 0, new f(this.esP, this.fqZ, this.fra, this.frb)).sendToTarget();
                    return;
                case 10003:
                    u.ajW().a(new f(this.dLU, this.esP, this.fqZ, this.fra, this.frb));
                    return;
                default:
                    v.e("MicroMsg.RequestProcessThread", "unknown cmdId = %d, do nothing", new Object[]{Integer.valueOf(this.fra)});
                    return;
            }
        }

        public final void run() {
            aiq();
        }
    }

    private a() {
    }

    public static a aip() {
        if (fqY != null) {
            return fqY;
        }
        a aVar = new a();
        fqY = aVar;
        return aVar;
    }

    public final void a(int i, long j, int i2, int i3, byte[] bArr) {
        int i4;
        String str = "MicroMsg.exdevice.DeviceRequestManager";
        String str2 = "------onDeviceRequest------ errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, datalength = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        v.i(str, str2, objArr);
        if (i == 0) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        com.tencent.mm.plugin.exdevice.g.a.g(j, i4);
        if (b.ak(bArr) == null) {
            v.e("MicroMsg.exdevice.DeviceRequestManager", "dataIn is null!!! Just leave without process data");
            return;
        }
        v.d("MicroMsg.exdevice.DeviceRequestManager", "data dump = %s", new Object[]{b.ak(bArr)});
        new a(i, j, i2, i3, bArr).aiq();
    }
}
