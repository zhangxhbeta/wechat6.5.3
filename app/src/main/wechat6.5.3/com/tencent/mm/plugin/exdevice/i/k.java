package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.s;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;

public final class k extends ad implements e {
    private int fdR = -1;
    private String fto = null;
    private String ftp = null;
    private String fyr = null;

    public k(String str, String str2, String str3, int i) {
        this.fto = str;
        this.fyr = str2;
        this.ftp = str3;
        this.fdR = i;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "onSceneEnd. errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        ak.vy().b(1090, this);
    }

    public final boolean a(m mVar, d dVar) {
        v.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "excute MMWifiStatusSubscribeTaskExcuter. brandName=" + this.fto + ",deviceType=" + this.fyr + ",deviceId=" + this.ftp + ",reqType=" + this.fdR);
        ak.vy().a(1090, this);
        ak.vy().a(new s(this.fto, this.fyr, this.ftp, this.fdR), 0);
        return false;
    }
}
