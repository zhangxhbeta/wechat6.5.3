package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String ecR;
    public String hbw;
    public String id;
    public boolean kRC;
    public String laB;

    public b(String str, String str2, String str3) {
        this.id = str2;
        this.hbw = str3;
        this.ecR = str;
        Map hashMap = new HashMap();
        hashMap.put(SlookAirButtonFrequentContactAdapter.ID, str2);
        hashMap.put("answer", str3);
        hashMap.put("payu_reference", str);
        u(hashMap);
    }

    public final int bfC() {
        return 18;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.kRC = jSONObject.optBoolean("verified");
        this.laB = jSONObject.optString("payu_reference");
    }
}
