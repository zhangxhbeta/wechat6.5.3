package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.smtt.sdk.QbSdk;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class z extends g {
    private static final int CTRL_INDEX = 97;
    private static final String NAME = "getPublicLibVersion";

    z() {
    }

    public final String a(f fVar, JSONObject jSONObject) {
        return nA(fVar.dzg);
    }

    public final String a(h hVar) {
        return nA(hVar.dzg);
    }

    private String nA(String str) {
        boolean z = true;
        AppBrandSysConfig mr = a.mr(str);
        if (mr == null) {
            return c("fail", null);
        }
        Map hashMap = new HashMap();
        hashMap.put("appDebug", Boolean.valueOf(mr.dDB.dBr != 0));
        hashMap.put("appMd5", be.ma(mr.dDB.dBv));
        hashMap.put("appVersion", Integer.valueOf(mr.dDB.dBs));
        String str2 = "libDebug";
        if (mr.dDC.dBr == 0) {
            z = false;
        }
        hashMap.put(str2, Boolean.valueOf(z));
        hashMap.put("libMd5", be.ma(mr.dDC.dBv));
        hashMap.put("libVersion", Integer.valueOf(mr.dDC.dBs));
        hashMap.put("clientVersion", Integer.valueOf(d.lWh));
        hashMap.put("system", "android");
        hashMap.put("systemVersion", Integer.valueOf(VERSION.SDK_INT));
        hashMap.put("x5Version", Integer.valueOf(QbSdk.getTbsVersion(aa.getContext())));
        return c("ok", hashMap);
    }
}
