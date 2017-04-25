package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 115;
    private static final String NAME = "getSavedFileList";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        List<AppBrandLocalMediaObject> mS = c.mS(fVar.dzg);
        JSONArray jSONArray = new JSONArray();
        if (!be.bP(mS)) {
            for (AppBrandLocalMediaObject appBrandLocalMediaObject : mS) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(DownloadInfoColumns.FILEPATH, appBrandLocalMediaObject.bde);
                    jSONObject2.put("size", appBrandLocalMediaObject.dfM);
                    jSONObject2.put("createTime", appBrandLocalMediaObject.dCh);
                    jSONArray.put(jSONObject2);
                } catch (Exception e) {
                }
            }
        }
        Map hashMap = new HashMap(1);
        hashMap.put("fileList", jSONArray);
        fVar.y(i, c("ok", hashMap));
    }
}
