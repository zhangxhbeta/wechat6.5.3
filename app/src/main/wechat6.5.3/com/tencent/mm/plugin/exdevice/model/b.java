package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b implements e {
    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.exdevice.ExDeviceMessageService", "onScenend, errType = %d, errCode = %d, errMsg = ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }
}
