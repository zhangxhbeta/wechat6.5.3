package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.appcache.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.page.f;
import com.tencent.mm.plugin.appbrand.page.f.AnonymousClass4;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static Map<String, f> dyP = new HashMap();
    private static Map<String, f> dyQ = new HashMap();
    private static Map<String, android.support.v4.app.a.a> dyR = new HashMap();
    private static Map<String, AppBrandSysConfig> dyS = new HashMap();
    private static Map<String, com.tencent.mm.plugin.appbrand.config.a> dyT = new HashMap();
    private static Map<String, AppBrandStatObject> dyU = new HashMap();

    public static void a(String str, f fVar) {
        if (be.kS(str)) {
            v.e("MicroMsg.AppBrandBridge", "No service appId specified");
            return;
        }
        if (dyP.containsKey(str)) {
            v.w("MicroMsg.AppBrandBridge", "Service exists, do cleanup");
            f fVar2 = (f) dyP.get(str);
            fVar2.ZO = false;
            for (com.tencent.mm.plugin.appbrand.f.a onDestroy : fVar2.dzi) {
                onDestroy.onDestroy();
            }
            fVar2 = (f) dyP.get(str);
            fVar2.dzh.OE();
            fVar2.dWV.OE();
        }
        if (fVar == null) {
            v.i("MicroMsg.AppBrandBridge", "Service removed");
            dyP.remove(str);
            return;
        }
        dyP.put(str, fVar);
    }

    public static void a(String str, f fVar) {
        dyQ.put(str, fVar);
    }

    public static f mp(String str) {
        return (f) dyQ.get(str);
    }

    public static void a(String str, String str2, String str3, int i) {
        if (be.kS(str) || !dyP.containsKey(str)) {
            v.e("MicroMsg.AppBrandBridge", "Service not found");
        } else {
            ((f) dyP.get(str)).e(str2, str3, i);
        }
    }

    public static void a(String str, String str2, String str3, int[] iArr) {
        if (be.kS(str) || !dyQ.containsKey(str)) {
            v.e("MicroMsg.AppBrandBridge", "Page Container not found");
            return;
        }
        f fVar = (f) dyQ.get(str);
        fVar.runOnUiThread(new AnonymousClass4(fVar, str2, str3, iArr));
    }

    public static void a(String str, android.support.v4.app.a.a aVar) {
        dyR.put(str, aVar);
    }

    public static void a(String str, int i, String[] strArr, int[] iArr) {
        if (dyR.containsKey(str)) {
            ((android.support.v4.app.a.a) dyR.get(str)).onRequestPermissionsResult(i, strArr, iArr);
            dyR.remove(str);
        }
    }

    public static void mq(String str) {
        dyR.remove(str);
    }

    public static void a(AppBrandSysConfig appBrandSysConfig) {
        dyS.put(appBrandSysConfig.appId, appBrandSysConfig);
    }

    public static AppBrandSysConfig mr(String str) {
        return (AppBrandSysConfig) dyS.get(str);
    }

    public static void a(AppBrandStatObject appBrandStatObject) {
        dyU.put(appBrandStatObject.appId, appBrandStatObject);
    }

    public static AppBrandStatObject ms(String str) {
        return (AppBrandStatObject) dyU.get(str);
    }

    public static com.tencent.mm.plugin.appbrand.config.a mt(String str) {
        com.tencent.mm.plugin.appbrand.config.a mY = com.tencent.mm.plugin.appbrand.config.a.mY(b.aq(str, "app-config.json"));
        dyT.put(str, mY);
        return mY;
    }

    public static com.tencent.mm.plugin.appbrand.config.a mu(String str) {
        return (com.tencent.mm.plugin.appbrand.config.a) dyT.get(str);
    }

    public static void mv(String str) {
        dyT.remove(str);
    }
}
