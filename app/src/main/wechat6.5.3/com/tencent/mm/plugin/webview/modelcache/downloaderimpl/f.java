package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.pluginsdk.k.a.c.l;
import java.util.HashMap;
import java.util.Map;

final class f extends l {
    public f(String str, String str2, String str3, String str4, int i, int i2) {
        super(str, str2, str3, "WebViewCache", str4, "GET", i, i2, 0);
        Map hashMap = new HashMap(1);
        hashMap.put("MM-WebCache", "webcache");
        R(hashMap);
    }

    public final String Pa() {
        return "WebViewCache";
    }
}
