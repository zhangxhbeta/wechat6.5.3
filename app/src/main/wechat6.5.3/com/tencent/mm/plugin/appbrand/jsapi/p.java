package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.g.a.a;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.i;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends a {
    public static final int CTRL_INDEX = 28;
    public static final String NAME = "downloadFile";

    public final void a(final f fVar, JSONObject jSONObject, final int i) {
        final String str = fVar.dzg;
        a anonymousClass1 = new a(this) {
            final /* synthetic */ p dGd;

            public final void b(int i, String str, String str2, String str3) {
                v.i("MicroMsg.JsApiDownloadFile", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %s", new Object[]{Integer.valueOf(i), str, str2, str3});
                if (com.tencent.mm.plugin.appbrand.g.a.FAILED != i) {
                    AppBrandLocalMediaObject b = c.b(str, str2, s.Ij(str), false);
                    if (b != null) {
                        String str4 = b.bde;
                        v.i("MicroMsg.JsApiDownloadFile", "onDownloadResultWithCode attached tempFilePath " + str4);
                        Map hashMap = new HashMap();
                        hashMap.put("tempFilePath", str4);
                        hashMap.put("statusCode", Integer.valueOf(Integer.parseInt(str3, 10)));
                        fVar.y(i, this.dGd.c("ok", hashMap));
                        return;
                    }
                }
                Map hashMap2 = new HashMap();
                hashMap2.put("statusCode", str3);
                fVar.y(i, this.dGd.c("fail", hashMap2));
            }

            public final void nz(String str) {
                fVar.y(i, this.dGd.c("fail:" + str, null));
            }
        };
        int i2 = 60000;
        AppBrandSysConfig mr = com.tencent.mm.plugin.appbrand.a.mr(fVar.dzg);
        com.tencent.mm.plugin.appbrand.config.a mu = com.tencent.mm.plugin.appbrand.a.mu(fVar.dzg);
        Map a = i.a(jSONObject, mr);
        String optString = jSONObject.optString("url");
        if (be.kS(optString)) {
            v.i("MicroMsg.JsApiDownloadFile", "url is null");
            fVar.y(i, c("fail:url is null or nil", null));
        } else if (!i.d(mr) || i.b(mr.dDA, optString)) {
            com.tencent.mm.plugin.appbrand.g.a aVar;
            if (mr.dDv <= 0) {
                v.i("MicroMsg.JsApiDownloadFile", "maxDownloadConcurrent <= 0 ");
            }
            int a2 = i.a(mr, mu, 3);
            if (a2 > 0) {
                i2 = a2;
            }
            b QP = a.dMm;
            optString = fVar.dzg;
            com.tencent.mm.plugin.appbrand.g.a aVar2 = QP.dMl.containsKey(optString) ? (com.tencent.mm.plugin.appbrand.g.a) QP.dMl.get(optString) : null;
            if (aVar2 == null) {
                aVar2 = new com.tencent.mm.plugin.appbrand.g.a(mr.dDv);
                b QP2 = a.dMm;
                String str2 = fVar.dzg;
                if (!QP2.dMl.containsKey(str2)) {
                    QP2.dMl.put(str2, aVar2);
                }
                aVar = aVar2;
            } else {
                aVar = aVar2;
            }
            if (aVar != null) {
                ArrayList arrayList;
                v.i("MicroMsg.JsApiDownloadFile", "before do download, checkDomains = %b", new Object[]{Boolean.valueOf(i.d(mr))});
                int i3 = com.tencent.mm.plugin.appbrand.a.mr(str).dDD.dDd;
                if (i.d(mr)) {
                    arrayList = mr.dDA;
                } else {
                    arrayList = null;
                }
                String optString2 = jSONObject.optString("url");
                if (aVar.dMi.size() >= aVar.dMg) {
                    anonymousClass1.nz("max_connected");
                    v.i("MicroMsg.AppBrandNetworkDownload", "max connected");
                } else if (be.kS(optString2)) {
                    v.i("MicroMsg.AppBrandNetworkDownload", "url is null");
                    anonymousClass1.nz("url is null");
                } else if (aVar.nK(optString2) != null) {
                    v.i("MicroMsg.AppBrandNetworkDownload", "the same task is working");
                    anonymousClass1.nz("the same task is working");
                } else {
                    Runnable bVar = new com.tencent.mm.plugin.appbrand.g.a.b(optString2, aVar.dMh + z.Kg(optString2) + "temp", new com.tencent.mm.plugin.appbrand.g.a.AnonymousClass1(aVar, anonymousClass1));
                    bVar.dMM = a;
                    bVar.dMN = i2;
                    bVar.aHp = true;
                    bVar.dMv = arrayList;
                    bVar.dMO = i3;
                    synchronized (aVar.dMi) {
                        aVar.dMi.add(bVar);
                    }
                    e.a(bVar, "appbrand_download_thread");
                }
            }
        } else {
            fVar.y(i, c("fail:url not in domain list", null));
            v.i("MicroMsg.JsApiDownloadFile", "not in domain url %s", new Object[]{optString});
        }
    }
}
