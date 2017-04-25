package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.sdk.platformtools.be;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aa extends z {
    public String haI;
    public String hay;

    public aa(String str, String str2, String str3, String str4) {
        this.haI = str3;
        this.hay = str2;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("receiveId", str3);
        hashMap.put("wishing", URLEncoder.encode(be.ma(str2)));
        hashMap.put("ver", str4);
        u(hashMap);
    }

    public final int getType() {
        return 1682;
    }

    public final String axK() {
        return "/cgi-bin/mmpay-bin/wishwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
