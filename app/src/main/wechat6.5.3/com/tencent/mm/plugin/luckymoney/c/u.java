package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class u extends z {
    long bao;
    String bdo;
    public e hbH;
    public String hbT;

    public u(String str, String str2, String str3) {
        this(str, 11, 0, str2, str3, "");
    }

    public u(String str, int i, String str2, long j, String str3, String str4) {
        this.hbH = null;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("limit", "11");
        hashMap.put("offset", String.valueOf(i));
        if (!be.kS(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("befortTimestamp", String.valueOf(j));
        hashMap.put("ver", str3);
        hashMap.put("processContent", str4);
        u(hashMap);
    }

    public u(String str, int i, int i2, String str2, String str3, String str4) {
        this.hbH = null;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("limit", new StringBuilder("11").toString());
        hashMap.put("offset", String.valueOf(i2));
        if (!be.kS(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("ver", str3);
        hashMap.put("processContent", str4);
        u(hashMap);
    }

    public final int getType() {
        return 1585;
    }

    public final String axK() {
        return "/cgi-bin/mmpay-bin/qrydetailwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            this.hbH = l.p(jSONObject);
            this.hbT = jSONObject.optString("processContent");
        } catch (JSONException e) {
            v.w("MicroMsg.NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + e.getLocalizedMessage());
        }
    }
}
