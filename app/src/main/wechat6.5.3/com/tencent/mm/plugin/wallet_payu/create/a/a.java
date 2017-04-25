package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.d.a.a {
    public String ecR;
    public String kYN;
    public String kYO;
    public String kYP;
    public String kYQ;
    public String kYR;
    public String pin;

    public a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.kYN = str;
        this.kYO = str2;
        this.pin = str3;
        this.kYQ = str4;
        this.kYP = str4;
        this.kYR = str6;
        Map hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", str2);
        hashMap.put("pin", str3);
        hashMap.put("secret_question_id", str4);
        hashMap.put("secret_question_answer", str5);
        hashMap.put("payu_reference", str6);
        u(hashMap);
    }

    public final int bfC() {
        return 5;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("MicroMsg.NetScenePayUCreateUser", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", new Object[]{Integer.valueOf(i), str, jSONObject.toString()});
        this.ecR = jSONObject.optString("payu_reference");
    }
}
