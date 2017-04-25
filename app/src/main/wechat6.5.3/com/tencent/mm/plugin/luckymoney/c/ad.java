package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.sdk.platformtools.be;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ad extends z {
    public String haB;
    public String hci;
    public String hcj;

    public ad(int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, int i3) {
        Map hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(i));
        hashMap.put("wishing", URLEncoder.encode(be.ma(str)));
        hashMap.put("sendUserName", str4);
        if (!be.kS(str3)) {
            hashMap.put("username", str3);
        }
        if (!be.kS(str2)) {
            hashMap.put("headImg", URLEncoder.encode(str2));
        }
        if (!be.kS(str5)) {
            hashMap.put("nickName", URLEncoder.encode(be.ma(str5)));
        }
        hashMap.put("inWay", String.valueOf(i2));
        hashMap.put("imageId", str6);
        hashMap.put("imageAesKey", str7);
        hashMap.put("imageLength", String.valueOf(i3));
        u(hashMap);
    }

    public final String axK() {
        return "/cgi-bin/mmpay-bin/yearrequestwxhb";
    }

    public final int getType() {
        return 1643;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.haB = jSONObject.optString("sendId");
        this.hci = jSONObject.optString("reqkey");
        this.hcj = jSONObject.optString("sendMsgXml");
    }
}
