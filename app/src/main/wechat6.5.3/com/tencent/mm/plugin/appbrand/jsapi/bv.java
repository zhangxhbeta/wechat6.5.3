package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.g.f.a;
import com.tencent.mm.plugin.appbrand.g.h;
import com.tencent.mm.plugin.appbrand.g.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class bv extends a {
    public static final int CTRL_INDEX = 27;
    public static final String NAME = "uploadFile";

    public final void a(final f fVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            fVar.y(i, c("fail", null));
            return;
        }
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH);
        if (be.kS(optString)) {
            fVar.y(i, c("fail:filePath is null", null));
            return;
        }
        v.i("MicroMsg.JsApiUploadFile", "tempFilePath " + optString);
        AppBrandLocalMediaObject az = c.az(fVar.dzg, optString);
        if (az == null) {
            fVar.y(i, c("fail:file doesn't exist", null));
            return;
        }
        final String str = az.cvK;
        String str2 = az.mimeType;
        v.i("MicroMsg.JsApiUploadFile", "filePath(%s), tempFilePath(%s)", new Object[]{str, optString});
        a anonymousClass1 = new a(this) {
            final /* synthetic */ bv dJl;

            public final void nD(String str) {
                new HashMap().put("data", str);
                v.e("MicroMsg.JsApiUploadFile", "error: file name %s, result %s , errMsg %d", new Object[]{str, str, Integer.valueOf(-1)});
                fVar.y(i, this.dJl.c("fail:" + str, null));
            }

            public final void i(int i, String str, String str2) {
                Map hashMap = new HashMap();
                hashMap.put("data", str);
                hashMap.put("statusCode", str2);
                if (i == 0) {
                    v.d("MicroMsg.JsApiUploadFile", "success: file name %s, result %s , errMsg %d", new Object[]{str, str, Integer.valueOf(i)});
                    fVar.y(i, this.dJl.c("ok", hashMap));
                    return;
                }
                v.e("MicroMsg.JsApiUploadFile", "error: file name %s, result %s , errMsg %d", new Object[]{str, str, Integer.valueOf(i)});
                fVar.y(i, this.dJl.c("fail:" + str, hashMap));
            }
        };
        AppBrandSysConfig mr = com.tencent.mm.plugin.appbrand.a.mr(fVar.dzg);
        com.tencent.mm.plugin.appbrand.config.a mu = com.tencent.mm.plugin.appbrand.a.mu(fVar.dzg);
        Map a = i.a(jSONObject, mr);
        String optString2 = jSONObject.optString("url");
        if (be.kS(optString2)) {
            v.i("MicroMsg.JsApiUploadFile", "url is null");
            fVar.y(i, c("fail", null));
        } else if (!i.d(mr) || i.b(mr.dDz, optString2)) {
            com.tencent.mm.plugin.appbrand.g.f fVar2;
            if (mr.dDu <= 0) {
                v.i("MicroMsg.JsApiUploadFile", "concurrent <= 0 ");
            }
            int a2 = i.a(mr, mu, 2);
            if (a2 <= 0) {
                a2 = 60000;
            }
            if (a.dME.nO(fVar.dzg) == null) {
                fVar2 = new com.tencent.mm.plugin.appbrand.g.f(mr.dDu);
                h QR = a.dME;
                String str3 = fVar.dzg;
                if (!QR.dMl.containsKey(str3)) {
                    QR.dMl.put(str3, fVar2);
                }
            } else {
                fVar2 = a.dME.nO(fVar.dzg);
            }
            if (fVar2 == null) {
                return;
            }
            if (i.d(mr)) {
                fVar2.a(a2, str2, str, jSONObject, a, mr.dDz, anonymousClass1);
                return;
            }
            v.i("MicroMsg.JsApiUploadFile", "debug type, do not verify domains");
            fVar2.a(a2, str2, str, jSONObject, a, null, anonymousClass1);
        } else {
            fVar.y(i, c("fail:url not in domain list", null));
            v.i("MicroMsg.JsApiUploadFile", "not in domain url %s", new Object[]{optString2});
        }
    }
}
