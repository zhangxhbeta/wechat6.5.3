package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends g {
    public double eWz;
    public String hNE;
    public int hNO;
    public String hNg;
    private String irC = null;
    public int irD;
    public String irE;
    private String irF;
    public String irG;
    public int irH;
    public String irI;
    public String irJ;
    public int irK;
    public int status;

    public f(int i, String str, String str2, int i2) {
        this.irC = str;
        this.hNO = i;
        Map hashMap = new HashMap();
        hashMap.put("transfer_id", str2);
        hashMap.put("trans_id", str);
        hashMap.put("invalid_time", String.valueOf(i2));
        u(hashMap);
    }

    public final int aed() {
        return 0;
    }

    public final int zg() {
        return 1628;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferquery";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.irD = jSONObject.optInt("pay_time");
            this.eWz = jSONObject.optDouble("fee") / 100.0d;
            this.hNg = jSONObject.optString("fee_type");
            this.status = jSONObject.optInt("trans_status");
            this.irF = jSONObject.optString("trans_status_name");
            this.irH = jSONObject.optInt("modify_time");
            this.irG = jSONObject.optString("payer_name");
            this.irE = jSONObject.optString("receiver_name");
            this.hNE = jSONObject.optString("refund_bank_type");
            this.irI = jSONObject.optString("status_desc");
            this.irJ = jSONObject.optString("status_supplementary");
            this.irK = jSONObject.optInt("delay_confirm_flag");
        }
    }
}
