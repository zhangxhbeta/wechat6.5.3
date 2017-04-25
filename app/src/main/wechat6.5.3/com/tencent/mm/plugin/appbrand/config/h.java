package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.sdk.platformtools.v;

public enum h {
    ;

    public static long nc(String str) {
        long j;
        AppBrandSysConfig mr = a.mr(str);
        String str2 = "MicroMsg.AppServiceSettingRemoteManager";
        String str3 = "getMaxFileStorageSize, (null == config) = %b, MaxFileStorageSize = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(mr == null);
        objArr[1] = Long.valueOf(mr == null ? -1 : mr.dDw);
        v.i(str2, str3, objArr);
        if (mr == null || mr.dDw <= 0) {
            j = 10;
        } else {
            j = mr.dDw;
        }
        return j * 1048576;
    }
}
