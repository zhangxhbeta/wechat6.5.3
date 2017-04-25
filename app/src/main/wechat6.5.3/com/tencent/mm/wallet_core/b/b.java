package com.tencent.mm.wallet_core.b;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONObject;

public final class b {
    public String bfi = "";
    public String pir = "";
    public String pis = "";
    public String pit = "";
    public String title = "";

    public b(String str) {
        if (!be.kS(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.title = jSONObject.optString("title");
                this.pir = jSONObject.optString("body1");
                this.pis = jSONObject.optString("body2");
                this.pit = jSONObject.optString("button");
            } catch (Exception e) {
                v.e("MicroMsg.CrtRtnWoding", "crtwoding error %s", new Object[]{e.getMessage()});
            }
        }
    }
}
