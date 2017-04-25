package com.tencent.mm.plugin.wallet_payu.bind.model;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.d.a.a {
    public String brR;
    public String description;
    public String kRB;
    public String kYe;
    public String kYo;
    public String kYp;
    public String kYq;
    public String pin;

    public final int bfC() {
        return 0;
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.kYo = str;
        this.kRB = str2;
        this.brR = str3;
        this.kYp = str4;
        this.kYq = str5;
        this.description = str6;
        this.kYe = str7;
        this.pin = str8;
        Map hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("information", str2);
        hashMap.put("name_on_card", str3);
        hashMap.put("card_number", str4);
        hashMap.put("card_expiry", str5);
        hashMap.put("description", str6);
        hashMap.put("cvv", str7);
        hashMap.put("pin", str8);
        u(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
