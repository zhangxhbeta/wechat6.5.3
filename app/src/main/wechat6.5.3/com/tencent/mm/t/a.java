package com.tencent.mm.t;

import com.tencent.mm.e.a.ol;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public final class a {
    public static boolean gq(String str) {
        if (be.kS(str)) {
            return false;
        }
        boolean z;
        for (String startsWith : c.cxd) {
            if (str.startsWith(startsWith)) {
                z = true;
                break;
            }
        }
        z = false;
        if (!z) {
            return false;
        }
        ol olVar = new ol();
        olVar.bpK.bpL = str;
        if (str.startsWith("weapp://wallet/")) {
            olVar.bpK.scene = 1019;
        } else if (str.startsWith("weapp://wallet/")) {
            olVar.bpK.scene = 1006;
        } else {
            olVar.bpK.scene = BaseReportManager.MAX_READ_COUNT;
        }
        com.tencent.mm.sdk.c.a.nhr.z(olVar);
        return true;
    }
}
