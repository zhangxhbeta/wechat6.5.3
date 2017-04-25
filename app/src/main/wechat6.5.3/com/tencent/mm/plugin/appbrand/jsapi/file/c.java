package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONObject;

public final class c extends a {
    private static final int CTRL_INDEX = 117;
    private static final String NAME = "removeSavedFile";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        String str = fVar.dzg;
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH, "");
        if (be.kS(optString)) {
            str = "fail:invalid data";
        } else {
            AppBrandLocalMediaObject az = com.tencent.mm.plugin.appbrand.appstorage.c.az(str, optString);
            if (az == null || be.kS(az.cvK)) {
                str = "fail:file doesn't exist";
            } else {
                b.deleteFile(az.cvK);
                str = "ok";
            }
        }
        fVar.y(i, c(str, null));
    }
}
