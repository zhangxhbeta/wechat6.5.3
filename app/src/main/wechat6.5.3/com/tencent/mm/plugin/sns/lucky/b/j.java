package com.tencent.mm.plugin.sns.lucky.b;

import com.tencent.mm.plugin.luckymoney.c.ag;
import com.tencent.mm.plugin.luckymoney.c.l;
import com.tencent.mm.plugin.luckymoney.c.p;
import com.tencent.mm.sdk.platformtools.be;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j extends p {
    public String haA;
    public int haK;
    public int haN;
    public ag haT;
    public String haU;
    public String haX;
    public int hau;
    public int hav;
    public String haw;
    public String hay;
    public String hcq;
    public long hcr;
    public long hcs;

    public j(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("sendId", URLEncoder.encode(be.ma(str)));
        hashMap.put("ticket", URLEncoder.encode(be.ma(str2)));
        u(hashMap);
    }

    public final String axK() {
        return "/cgi-bin/mmpay-bin/cfreceivewxhb";
    }

    public final int axL() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.hcq = jSONObject.optString("sendNick");
        this.haA = jSONObject.optString("sendHeadImg");
        this.hav = jSONObject.optInt("hbStatus");
        this.haN = jSONObject.optInt("receiveStatus");
        this.haw = jSONObject.optString("statusMess");
        this.hay = jSONObject.optString("wishing");
        this.haK = jSONObject.optInt("isSender");
        this.hcr = jSONObject.optLong("sceneAmount");
        this.hcs = jSONObject.optLong("sceneRecTimeStamp");
        this.hau = jSONObject.optInt("hbType");
        this.haU = jSONObject.optString("watermark");
        this.haX = jSONObject.optString("externMess");
        this.haT = l.r(jSONObject.optJSONObject("operationTail"));
    }

    public final int getType() {
        return 1640;
    }
}
