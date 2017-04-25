package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public String ecR;
    public String id;
    public String laC;

    public c() {
        this("");
    }

    public c(String str) {
        this.ecR = str;
        Map hashMap = new HashMap();
        hashMap.put("payu_reference", be.ah(str, ""));
        u(hashMap);
    }

    public final int bfC() {
        return 23;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.id = jSONObject.optString(SlookAirButtonFrequentContactAdapter.ID);
        this.laC = jSONObject.optString("description");
    }
}
