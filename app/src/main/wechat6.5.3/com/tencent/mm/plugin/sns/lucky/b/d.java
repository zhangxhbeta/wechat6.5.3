package com.tencent.mm.plugin.sns.lucky.b;

import com.tencent.mm.plugin.luckymoney.c.e;
import com.tencent.mm.plugin.luckymoney.c.l;
import com.tencent.mm.plugin.luckymoney.c.z;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends z {
    public e hbH = null;
    public String hbT;

    public d(String str, int i, int i2, long j, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("limit", String.valueOf(i));
        hashMap.put("offset", String.valueOf(i2));
        hashMap.put("befortTimestamp", String.valueOf(j));
        hashMap.put("ver", str2);
        hashMap.put("ticket", str3);
        u(hashMap);
    }

    public final String axK() {
        return "/cgi-bin/mmpay-bin/cfqrydetailwxhb";
    }

    public final int axL() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            this.hbH = l.p(jSONObject);
            this.hbT = jSONObject.optString("processContent");
        } catch (JSONException e) {
            v.w("MicroMsg.NetSceneSnsLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + e.getLocalizedMessage());
        }
    }

    public final int getType() {
        return 1642;
    }
}
