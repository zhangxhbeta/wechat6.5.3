package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 51;
    public static final String NAME = "saveFile";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        String str = fVar.dzg;
        String optString = jSONObject.optString("tempFilePath");
        if (be.kS(optString)) {
            v.e("MicroMsg.JsApiSaveFile", "temp localId is null or nil");
            fVar.y(i, c("fail", null));
            return;
        }
        AppBrandLocalMediaObject az = c.az(str, optString);
        boolean z = az != null && e.aR(az.cvK);
        v.i("MicroMsg.JsApiSaveFile", "get temp obj = %s, fileExists = %b", new Object[]{az, Boolean.valueOf(z)});
        if (!z || be.kS(az.cvK)) {
            fVar.y(i, c("fail:file doesn't exist", null));
        } else if (az.dCg) {
            fVar.y(i, c("ok", null));
        } else {
            v.i("MicroMsg.JsApiSaveFile", "before markPermanent, quota = %d, occupation = %d, fileLength = %d", new Object[]{Long.valueOf(h.nc(str)), Long.valueOf(c.mU(str)), Long.valueOf(new File(az.cvK).length())});
            if (c.mU(str) + new File(az.cvK).length() > h.nc(str)) {
                fVar.y(i, c(String.format(Locale.US, "fail:exceed quota %dM", new Object[]{Long.valueOf(r4 / 1048576)}), null));
                return;
            }
            AppBrandLocalMediaObject a = c.a(az);
            String str2 = "MicroMsg.JsApiSaveFile";
            String str3 = "after markPermanent, (obj==null): %b, obj.localId: %s, obj.path: %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(a == null);
            objArr[1] = a == null ? null : a.bde;
            objArr[2] = a == null ? null : a.cvK;
            v.i(str2, str3, objArr);
            if (a == null || be.kS(a.bde) || be.kS(a.cvK)) {
                fVar.y(i, c("fail", null));
                return;
            }
            Map hashMap = new HashMap(1);
            hashMap.put("savedFilePath", a.bde);
            fVar.y(i, c("ok", hashMap));
        }
    }
}
