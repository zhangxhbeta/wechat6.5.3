package com.tencent.mm.plugin.sns.lucky.b;

import com.tencent.mm.plugin.luckymoney.c.e;
import com.tencent.mm.plugin.luckymoney.c.l;
import com.tencent.mm.plugin.luckymoney.c.z;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class h extends z {
    public String haB;
    public e hbH = null;

    public h(String str, String str2, String str3, String str4, String str5) {
        this.haB = str;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        if (!be.kS(str2)) {
            hashMap.put("headImg", URLEncoder.encode(str2));
            hashMap.put("nickName", URLEncoder.encode(be.ma(str3)));
        }
        hashMap.put("sessionUserName", str4);
        hashMap.put("ticket", str5);
        u(hashMap);
    }

    public final String axK() {
        return "/cgi-bin/mmpay-bin/cfopenwxhb";
    }

    public final int axL() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            this.hbH = l.p(jSONObject);
        } catch (JSONException e) {
            v.w("MicroMsg.NetSceneSnsOpenLuckyMoney", "parse luckyMoneyDetail fail: " + e.getLocalizedMessage());
        }
    }

    public final int getType() {
        return 1641;
    }
}
