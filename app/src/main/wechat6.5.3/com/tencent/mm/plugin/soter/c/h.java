package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONObject;

public final class h {
    public String bCj = "";
    String bgr = "";
    private long kdd = -1;
    String kde = "";
    public String kdf = "";
    int uid = -1;

    public final String toString() {
        return "SoterPubKeyModel{counter=" + this.kdd + ", uid=" + this.uid + ", cpu_id='" + this.bgr + '\'' + ", pub_key_in_x509='" + this.kde + '\'' + ", rawJson='" + this.kdf + '\'' + ", signature='" + this.bCj + '\'' + '}';
    }

    public h(String str, String str2) {
        this.kdf = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.kdd = jSONObject.optLong("counter");
            this.uid = jSONObject.optInt("uid");
            this.bgr = jSONObject.optString("cpu_id");
            this.kde = jSONObject.optString("pub_key");
        } catch (Throwable e) {
            v.a("MicroMsg.SoterPubKeyModel", e, "hy: pub key model failed", new Object[0]);
        }
        this.bCj = str2;
    }
}
