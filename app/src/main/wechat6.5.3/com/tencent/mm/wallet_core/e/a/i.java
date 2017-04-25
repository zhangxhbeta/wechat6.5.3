package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.sdk.platformtools.v;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i extends g {
    public String aZD;
    public String appId;
    public int bkh;
    public String fTG;
    public String gTq;
    public String kXn;
    public String pjh;
    public int scene;

    public i(String str, int i, int i2, int i3, int i4, String str2) {
        this.scene = i;
        this.bkh = i3;
        Map hashMap = new HashMap();
        hashMap.put("url", URLEncoder.encode(str));
        hashMap.put("scene", String.valueOf(i2));
        hashMap.put("a8key_scene", String.valueOf(i));
        hashMap.put("channel", String.valueOf(i3));
        v.d("MicroMsg.NetSceneTenpayNativeAuthen", "sourceType: %d, source: %s", new Object[]{Integer.valueOf(i4), str2});
        if (i4 < 0) {
            v.e("MicroMsg.NetSceneTenpayNativeAuthen", "illegal sourceType: %d, source: %s", new Object[]{Integer.valueOf(i4), str2});
            hashMap.put("source_type", "0");
            hashMap.put("source", "");
        } else {
            hashMap.put("source_type", String.valueOf(i4));
            hashMap.put("source", str2);
        }
        u(hashMap);
    }

    public final int aed() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("MicroMsg.NetSceneTenpayNativeAuthen", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        v.d("MicroMsg.NetSceneTenpayNativeAuthen", "json: %s", new Object[]{jSONObject.toString()});
        this.fTG = jSONObject.optString("reqkey");
        this.appId = jSONObject.optString("appid");
        this.kXn = jSONObject.optString("appsource");
        this.aZD = jSONObject.optString("productid");
        this.pjh = jSONObject.optString("retcode");
        this.gTq = jSONObject.optString("retmsg");
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/payauthnative";
    }

    public final int zg() {
        return 1694;
    }
}
