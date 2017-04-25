package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.offline.j;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k extends g {
    public static String hKC = "";
    public static String hKT = "";
    public String hKU = "";
    public String hKV = "";
    public String hKW = "";
    private int hKq = -1;
    private String hKr = "";
    public int hKs = -1;
    public String hKt = "";

    public k(String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("device_id", p.rK());
        hashMap.put("timestamp", str);
        hashMap.put("scene", String.valueOf(i));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(p.rK());
        stringBuilder.append("&");
        stringBuilder.append(str);
        hashMap.put("sign", z.Kg(stringBuilder.toString()));
        StringBuilder stringBuilder2 = new StringBuilder();
        ak.yW();
        hashMap.put("code_ver", stringBuilder2.append(c.vf().get(a.non, "")).toString());
        u(hashMap);
    }

    public final int aed() {
        return 49;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            hKC = jSONObject.optString("limit_fee");
            hKT = jSONObject.optString("is_show_order_detail");
            String optString = jSONObject.optString("pay_amount");
            String optString2 = jSONObject.optString("pay_number");
            String optString3 = jSONObject.optString("card_logos");
            j.aEM();
            j.T(196629, hKC);
            j.aEM();
            j.T(196641, hKT);
            j.aEM();
            j.T(196645, optString);
            j.aEM();
            j.T(196646, optString2);
            com.tencent.mm.plugin.offline.b.a.xv(optString3);
            this.hKq = jSONObject.optInt("retcode");
            this.hKr = jSONObject.optString("retmsg");
            this.hKs = jSONObject.optInt("wx_error_type");
            this.hKt = jSONObject.optString("wx_error_msg");
            this.hKU = jSONObject.optString("get_code_flag");
            this.hKV = jSONObject.optString("micropay_pause_flag");
            this.hKW = jSONObject.optString("micropay_pause_word");
        }
    }

    public final int zg() {
        return 568;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinequeryuser";
    }
}
