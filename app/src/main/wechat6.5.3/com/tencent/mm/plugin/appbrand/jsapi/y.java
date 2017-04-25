package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class y extends a {
    public static final int CTRL_INDEX = 39;
    public static final String NAME = "getNetworkType";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        Map hashMap = new HashMap();
        if (!ak.isConnected(fVar.mContext)) {
            hashMap.put("networkType", "none");
        } else if (ak.is2G(fVar.mContext)) {
            hashMap.put("networkType", "2g");
        } else if (ak.is3G(fVar.mContext)) {
            hashMap.put("networkType", "3g");
        } else if (ak.is4G(fVar.mContext)) {
            hashMap.put("networkType", "4g");
        } else if (ak.isWifi(fVar.mContext)) {
            hashMap.put("networkType", "wifi");
        } else {
            hashMap.put("networkType", "unknown");
        }
        fVar.y(i, c("ok", hashMap));
    }
}
