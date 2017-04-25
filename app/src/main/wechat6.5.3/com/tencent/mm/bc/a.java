package com.tencent.mm.bc;

import com.tencent.recovery.a.b;

public final class a {
    public static b a(String str, long j, long j2, com.tencent.recovery.a.a aVar, boolean z) {
        com.tencent.recovery.a.b.a aVar2 = new com.tencent.recovery.a.b.a();
        aVar2.processName = str;
        aVar2.ptY = j;
        aVar2.ptZ = j2;
        aVar2.ptX = aVar;
        aVar2.pua = z;
        aVar2.pub = true;
        aVar2.puc = "com.tencent.mm.plugin.recovery.service.WXRecoveryHandleService";
        aVar2.pud = String.format("http://dldir1.qq.com/weixin/android/recovery-%s.conf", new Object[]{"0x26050341"});
        return aVar2.bMC();
    }
}
