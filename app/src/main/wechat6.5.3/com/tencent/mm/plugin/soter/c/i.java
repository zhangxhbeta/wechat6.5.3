package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONException;
import org.json.JSONObject;

public final class i {
    private long kdd = -1;
    private String kdg = null;
    private String kdh = null;
    private String kdi = "";
    private String kdj = "";
    private String kdk = "";
    private String kdl = "";
    private String kdm = "";
    public String kdn = "";
    public String kdo = "";

    public final String toString() {
        return "SoterSignatureResult{rawValue='" + this.kdg + '\'' + ", fid='" + this.kdh + '\'' + ", counter=" + this.kdd + ", TEEName='" + this.kdi + '\'' + ", TEEVersion='" + this.kdj + '\'' + ", FpName='" + this.kdk + '\'' + ", FpVersion='" + this.kdl + '\'' + ", cpuId='" + this.kdm + '\'' + ", signaure='" + this.kdo + '\'' + '}';
    }

    public static i Cj(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            i iVar = new i();
            iVar.kdn = str;
            iVar.kdg = jSONObject.optString("raw");
            iVar.kdh = jSONObject.optString("fid");
            iVar.kdd = jSONObject.optLong("counter");
            iVar.kdi = jSONObject.optString("tee_n");
            iVar.kdj = jSONObject.optString("tee_v");
            iVar.kdk = jSONObject.optString("fp_n");
            iVar.kdl = jSONObject.optString("fp_v");
            iVar.kdm = jSONObject.optString("cpu_id");
            return iVar;
        } catch (JSONException e) {
            v.e("MicroMsg.SoterSignatureResult", "hy: convert from json failed." + e.toString());
            return null;
        }
    }
}
