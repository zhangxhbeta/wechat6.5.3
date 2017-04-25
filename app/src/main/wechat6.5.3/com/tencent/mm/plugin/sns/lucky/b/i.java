package com.tencent.mm.plugin.sns.lucky.b;

import com.tencent.mm.plugin.luckymoney.c.z;
import com.tencent.mm.sdk.platformtools.be;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i extends z {
    public String haB;
    public String hci;
    public String hcj;

    public i(int i, long j, String str, String str2, String str3, String str4, String str5) {
        Map hashMap = new HashMap();
        hashMap.put("totalNum", String.valueOf(i));
        hashMap.put("totalAmount", String.valueOf(j));
        hashMap.put("perValue", String.valueOf(j));
        hashMap.put("wishing", URLEncoder.encode(be.ma(str)));
        hashMap.put("headImg", URLEncoder.encode(be.ma(str2)));
        hashMap.put("nickName", URLEncoder.encode(be.ma(str3)));
        hashMap.put("feedId", str4);
        hashMap.put("hbType", "0");
        hashMap.put("userName", URLEncoder.encode(be.ma(str5)));
        u(hashMap);
    }

    public final String axK() {
        return "/cgi-bin/mmpay-bin/cfrequestwxhb";
    }

    public final int axL() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.haB = jSONObject.optString("sendId");
        this.hci = jSONObject.optString("reqkey");
        this.hcj = jSONObject.optString("sendMsgXml");
    }

    public final int getType() {
        return 1639;
    }
}
