package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class b {
    public static int a(String str, com.tencent.mm.plugin.appbrand.jsapi.b bVar) {
        int i = -be.getInt(q.dqe, 0);
        if (i == -1) {
            v.d("MicroMsg.AppBrandPermissionHelper", "getCtrlByte, appId = %s, apiName = %s, hard code perm on", new Object[]{str, bVar.getName()});
            return 1;
        } else if (i == -2) {
            v.d("MicroMsg.AppBrandPermissionHelper", "getCtrlByte, appId = %s, apiName = %s, hard code perm off", new Object[]{str, bVar.getName()});
            return 0;
        } else {
            AppBrandSysConfig mr = a.mr(str);
            if (mr == null) {
                v.e("MicroMsg.AppBrandPermissionHelper", "getCtrlByte, appId = %s, apiName = %s, get null config");
                return 0;
            }
            byte[] bArr = mr.dDq;
            v.d("MicroMsg.AppBrandPermissionHelper", "getCtrlByte, appId = %s, apiName = %s, apiCtrlIndex = %d, ctrlBytes.length = %d", new Object[]{str, bVar.getName(), Integer.valueOf(bVar.PS()), Integer.valueOf(bArr.length)});
            if (bVar.PS() == -2) {
                return 1;
            }
            if (bVar.PS() == -1) {
                return 0;
            }
            if (bVar.PS() >= bArr.length || bVar.PS() < 0) {
                return 0;
            }
            v.d("MicroMsg.AppBrandPermissionHelper", "getCtrlByte, appId = %s, apiName = %s, given ctrlByte = %d", new Object[]{str, bVar.getName(), Integer.valueOf(bArr[bVar.PS()])});
            return bArr[bVar.PS()];
        }
    }

    public static boolean b(String str, com.tencent.mm.plugin.appbrand.jsapi.b bVar) {
        return a(str, bVar) == 1;
    }
}
