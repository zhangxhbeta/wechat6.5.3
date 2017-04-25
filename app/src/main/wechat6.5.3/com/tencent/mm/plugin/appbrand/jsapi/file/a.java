package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 116;
    private static final String NAME = "getSavedFileInfo";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        String str = fVar.dzg;
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH, "");
        if (be.kS(optString)) {
            fVar.y(i, c("fail:invalid data", null));
            return;
        }
        AppBrandLocalMediaObject az = c.az(str, optString);
        if (az == null) {
            fVar.y(i, c("fail:file doesn't exist", null));
            return;
        }
        File file = new File(az.cvK);
        Map hashMap = new HashMap(3);
        hashMap.put("size", Long.valueOf(file.length()));
        hashMap.put("createTime", Long.valueOf(file.lastModified()));
        fVar.y(i, c("ok", hashMap));
    }
}
