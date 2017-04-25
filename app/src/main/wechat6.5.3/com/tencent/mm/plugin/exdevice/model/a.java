package com.tencent.mm.plugin.exdevice.model;

import android.os.Bundle;
import com.tencent.mm.e.a.cy;
import com.tencent.mm.sdk.platformtools.v;

public final class a extends com.tencent.mm.plugin.exdevice.service.n.a {
    private static final a frJ = new a();

    private a() {
    }

    public static a aiJ() {
        return frJ;
    }

    public final Bundle d(int i, Bundle bundle) {
        v.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "onExdeviceInvoke, action code = %d", new Object[]{Integer.valueOf(i)});
        if (bundle != null) {
            switch (i) {
                case 0:
                    if (bundle != null) {
                        int i2 = bundle.getInt("key_state");
                        v.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "handleOnBluetoothStateChange, state = %d", new Object[]{Integer.valueOf(i2)});
                        if (-1 != i2) {
                            cy cyVar = new cy();
                            cyVar.baW.baX = i2;
                            if (!com.tencent.mm.sdk.c.a.nhr.z(cyVar)) {
                                v.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "EventCenter.instance.publish failed!!!");
                                break;
                            }
                        }
                        v.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "invalid state, just leave!!!");
                        break;
                    }
                    v.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
                    break;
                    break;
                default:
                    break;
            }
        }
        v.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
        return null;
    }
}
