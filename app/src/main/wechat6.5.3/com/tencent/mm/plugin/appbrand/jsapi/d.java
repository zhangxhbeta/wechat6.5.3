package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.plugin.appbrand.page.f;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class d extends b {
    public final String c(String str, Map<String, ? extends Object> map) {
        Map hashMap = new HashMap();
        hashMap.put("errMsg", getName() + ":" + str);
        if (map != null) {
            hashMap.putAll(map);
        }
        a.p(hashMap);
        return new JSONObject(hashMap).toString();
    }

    public static MMActivity nt(String str) {
        f mp = com.tencent.mm.plugin.appbrand.a.mp(str);
        if (mp == null) {
            return null;
        }
        Context context = mp.getContext();
        if (context instanceof MMActivity) {
            return (MMActivity) context;
        }
        return null;
    }

    public static h a(com.tencent.mm.plugin.appbrand.f fVar) {
        f mp = com.tencent.mm.plugin.appbrand.a.mp(fVar.dzg);
        if (mp == null || mp.Rm() == null) {
            return null;
        }
        return mp.Rm().QZ();
    }
}
