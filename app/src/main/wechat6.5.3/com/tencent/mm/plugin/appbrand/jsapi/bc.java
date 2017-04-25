package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.c.a;
import com.tencent.mm.plugin.appbrand.g.e;
import com.tencent.mm.plugin.appbrand.g.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class bc extends a {
    public static final int CTRL_INDEX = 19;
    public static final String NAME = "request";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        final long currentTimeMillis = System.currentTimeMillis();
        final f fVar2 = fVar;
        final int i2 = i;
        AnonymousClass1 anonymousClass1 = new a(this) {
            final /* synthetic */ bc dHV;

            public final void aL(String str, String str2) {
                int i = 0;
                Map hashMap = new HashMap();
                String str3 = "MicroMsg.JsApiRequest";
                String str4 = "onRequestResult, time: %d, data size: %d";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                if (str2 != null) {
                    i = str2.length();
                }
                objArr[1] = Integer.valueOf(i);
                v.d(str3, str4, objArr);
                if (str.equalsIgnoreCase("ok")) {
                    hashMap.put("data", str2);
                } else {
                    str = str + " " + str2;
                }
                fVar2.y(i2, this.dHV.c(str, hashMap));
            }

            public final void v(String str, String str2, String str3) {
                int i = 0;
                String str4 = "MicroMsg.JsApiRequest";
                String str5 = "onRequestResult, time: %d, data size: %d, code %s";
                Object[] objArr = new Object[3];
                objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                if (str2 != null) {
                    i = str2.length();
                }
                objArr[1] = Integer.valueOf(i);
                objArr[2] = str3;
                v.d(str4, str5, objArr);
                Map hashMap = new HashMap();
                if (str.equalsIgnoreCase("ok")) {
                    hashMap.put("data", str2);
                } else {
                    str = str + " " + str2;
                }
                hashMap.put("statusCode", str3);
                fVar2.y(i2, this.dHV.c(str, hashMap));
            }
        };
        String optString = jSONObject.optString("url");
        if (be.kS(optString)) {
            v.e("MicroMsg.JsApiRequest", "url is null");
            Map hashMap = new HashMap();
            hashMap.put("data", "url is null");
            fVar.y(i, c("fail:url is null or nil", hashMap));
            return;
        }
        AppBrandSysConfig mr = com.tencent.mm.plugin.appbrand.a.mr(fVar.dzg);
        int a = i.a(mr, com.tencent.mm.plugin.appbrand.a.mu(fVar.dzg), 0);
        if (a <= 0) {
            a = 60000;
        }
        if (mr.dDt <= 0) {
            v.i("MicroMsg.JsApiRequest", "maxRequestConcurrent <= 0 use default concurrent");
        }
        Map a2 = i.a(jSONObject, mr);
        if (!i.d(mr) || i.b(mr.dDx, optString)) {
            c cVar;
            if (a.dMx.nN(fVar.dzg) == null) {
                cVar = new c(mr.dDt);
                e QQ = a.dMx;
                String str = fVar.dzg;
                if (!QQ.dMl.containsKey(str)) {
                    QQ.dMl.put(str, cVar);
                }
            } else {
                cVar = a.dMx.nN(fVar.dzg);
            }
            v.i("MicroMsg.JsApiRequest", "request url: %s", new Object[]{optString});
            if (cVar == null) {
                fVar.y(i, c("fail:create request error", null));
                return;
            } else if (i.d(mr)) {
                cVar.a(a, jSONObject, a2, mr.dDx, anonymousClass1);
                return;
            } else {
                v.i("MicroMsg.JsApiRequest", "debug type, do not verify domains");
                cVar.a(a, jSONObject, a2, null, anonymousClass1);
                return;
            }
        }
        fVar.y(i, c("fail:url not in domain list", null));
        v.i("MicroMsg.JsApiRequest", "not in domain url %s", new Object[]{optString});
    }
}
