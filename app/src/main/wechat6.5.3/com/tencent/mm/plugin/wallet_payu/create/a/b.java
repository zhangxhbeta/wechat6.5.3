package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String bpP;
    public String ecR;
    public String kYN;
    public String pin;

    public final int bfC() {
        return 17;
    }

    public b(String str, String str2, String str3, String str4) {
        this.kYN = str;
        this.bpP = str2;
        this.pin = str3;
        this.ecR = str4;
        Map hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", str2);
        hashMap.put("pin", str3);
        hashMap.put("payu_reference", str4);
        u(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
