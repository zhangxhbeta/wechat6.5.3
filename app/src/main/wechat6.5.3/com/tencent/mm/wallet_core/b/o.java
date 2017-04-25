package com.tencent.mm.wallet_core.b;

import org.json.JSONObject;

public final class o {
    public String mWk = "";
    public String piH = "";
    public String piI = "";
    public String piJ = "";
    public int piK = 0;

    public o(JSONObject jSONObject) {
        this.piH = jSONObject.optString("device_id");
        this.piI = jSONObject.optString("device_name");
        this.piJ = jSONObject.optString("device_os");
        this.piK = jSONObject.optInt("Is_cur_device");
        this.mWk = jSONObject.optString("crt_no");
    }
}
