package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.e.a.cs;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.service.q.a;
import com.tencent.mm.sdk.platformtools.v;

public final class e extends a {
    private static e fxp = new e();

    private e() {
    }

    public static e ajL() {
        return fxp;
    }

    public final boolean V(final String str, final boolean z) {
        v.i("MicroMsg.exdevice.ExdeviceIBeaconManager", "ranging, uuid = %s, op = %s", new Object[]{str, String.valueOf(z)});
        if (str == null) {
            v.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "uuid is null");
            return false;
        } else if (u.ajW().frL != null) {
            return u.ajW().frL.a(str, z, (q) this);
        } else {
            v.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "MMExDeviceCore.getTaskQueue().getDispatcher() is null !!!now retry invoke doTaskAfterServiceStarted!");
            ac.ajx().l(new Runnable(this) {
                final /* synthetic */ e fxq;

                public final void run() {
                    if (u.ajW().frL != null) {
                        u.ajW().frL.a(str, z, this.fxq);
                    }
                }
            });
            return false;
        }
    }

    public final void a(double d, int i, int i2, byte[] bArr, double d2, int i3, String str) {
        v.d("MicroMsg.exdevice.ExdeviceIBeaconManager", "onRangdingCallback, distance = %f, major = %d, minor = %d, uuid = %s, rssi = %f,aMac = %s,txPower = %d", new Object[]{Double.valueOf(d), Integer.valueOf(i), Integer.valueOf(i2), b.ak(bArr), Double.valueOf(d2), str, Integer.valueOf(i3)});
        cs csVar = new cs();
        String ak = b.ak(bArr);
        if (ak.length() >= 32) {
            ak = ak.substring(0, 8) + "-" + ak.substring(8, 12) + "-" + ak.substring(12, 16) + "-" + ak.substring(16, 20) + "-" + ak.substring(20);
        }
        csVar.baG.baE = ak;
        csVar.baG.baJ = d;
        csVar.baG.baH = i;
        csVar.baG.baI = i2;
        csVar.baG.baK = d2;
        csVar.baG.baL = str;
        csVar.baG.baM = i3;
        com.tencent.mm.sdk.c.a.nhr.z(csVar);
    }
}
