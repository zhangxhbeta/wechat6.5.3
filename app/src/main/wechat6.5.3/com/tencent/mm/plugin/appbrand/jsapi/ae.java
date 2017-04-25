package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Build.VERSION;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class ae extends g {
    public static final int CTRL_INDEX = 40;
    public static final String NAME = "getSystemInfo";

    ae() {
    }

    public final String a(f fVar, JSONObject jSONObject) {
        Map hashMap = new HashMap();
        hashMap.put("model", p.rO());
        float f = fVar.mContext.getResources().getDisplayMetrics().density;
        hashMap.put("pixelRatio", Float.valueOf(f));
        hashMap.put("windowWidth", Float.valueOf(((float) d.a(fVar).dNn.getWidth()) / f));
        hashMap.put("windowHeight", Float.valueOf(((float) d.a(fVar).dNn.getHeight()) / f));
        hashMap.put("language", u.dJ(fVar.mContext));
        hashMap.put("version", com.tencent.mm.sdk.platformtools.f.S(null, d.lWh));
        hashMap.put("system", "Android " + VERSION.RELEASE);
        return c("ok", hashMap);
    }
}
