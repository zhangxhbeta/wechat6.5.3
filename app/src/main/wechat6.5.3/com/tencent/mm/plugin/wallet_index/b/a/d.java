package com.tencent.mm.plugin.wallet_index.b.a;

import java.util.ArrayList;
import org.json.JSONObject;

public final class d {
    public String cKN;
    public String fdU;
    String gpe;
    public String jXL;
    String kXe;
    public String kXf;
    long kXg;
    int kXh;
    public String kXi;
    public String kXj;
    public String kXk;
    public String kXl;

    public d(String str, String str2, String str3) {
        this.kXe = str;
        this.kXj = str2;
        JSONObject jSONObject = new JSONObject(this.kXj);
        this.kXf = jSONObject.optString("orderId");
        this.gpe = jSONObject.optString("packageName");
        this.fdU = jSONObject.optString("productId");
        this.kXg = jSONObject.optLong("purchaseTime");
        this.kXh = jSONObject.optInt("purchaseState");
        String optString = jSONObject.optString("developerPayload");
        ArrayList DB = DB(optString);
        if (DB.size() == 3) {
            this.kXi = (String) DB.get(0);
            this.kXl = (String) DB.get(1);
            this.kXk = (String) DB.get(2);
        } else {
            this.kXi = optString;
        }
        this.cKN = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.jXL = str3;
    }

    public d(String str, String str2, String str3, String str4) {
        this.fdU = str;
        this.kXi = str2;
        this.kXk = str3;
        this.kXl = str4;
    }

    private static ArrayList<String> DB(String str) {
        ArrayList<String> arrayList = new ArrayList();
        while (str.indexOf("[#]") >= 0) {
            String substring = str.substring(0, str.indexOf("[#]"));
            str = str.substring(substring.length() + 3);
            arrayList.add(substring);
        }
        arrayList.add(str);
        return arrayList;
    }

    public final String toString() {
        return "PurchaseInfo(type:" + this.kXe + "):" + this.kXj;
    }
}
