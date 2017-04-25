package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.protocal.c.bjc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.t.h;

public enum g {
    ;

    public static int nb(String str) {
        int i;
        bjc com_tencent_mm_protocal_c_bjc = null;
        if (!(be.kS(str) || a.OO() == null)) {
            j OO = a.OO();
            h hVar = new h();
            hVar.field_appIdHashCode = str.hashCode();
            if (OO.dDN.b(hVar, new String[0])) {
                com_tencent_mm_protocal_c_bjc = hVar.field_appInfo;
            }
        }
        String str2 = "MicroMsg.AppServiceSettingMMManager";
        String str3 = "getAppInfo, appId = %s, (null == storage) = %b, (ret == null) = %b";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = a.OO();
        objArr[2] = Boolean.valueOf(com_tencent_mm_protocal_c_bjc == null);
        v.i(str2, str3, objArr);
        str2 = "MicroMsg.AppServiceSettingMMManager";
        str3 = "readAppFileStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d";
        objArr = new Object[2];
        objArr[0] = str;
        int i2 = (com_tencent_mm_protocal_c_bjc == null || com_tencent_mm_protocal_c_bjc.ndv == null) ? -1 : com_tencent_mm_protocal_c_bjc.ndv.mdb;
        objArr[1] = Integer.valueOf(i2);
        v.i(str2, str3, objArr);
        if (com_tencent_mm_protocal_c_bjc == null || com_tencent_mm_protocal_c_bjc.ndv == null || com_tencent_mm_protocal_c_bjc.ndv.mdb <= 0) {
            i = 5;
        } else {
            i = com_tencent_mm_protocal_c_bjc.ndv.mdb;
        }
        return i * 1048576;
    }
}
