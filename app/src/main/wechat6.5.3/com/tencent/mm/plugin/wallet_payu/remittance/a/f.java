package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.d.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends a {
    public int bdf;
    public int bkU;
    public double eWz;
    public String hNg;
    private String irC;
    public int irD;
    public int lan;
    public int lao;
    public int status;

    public f(String str, String str2, int i) {
        this(str, str2, i, 1, 0);
    }

    public f(String str, String str2, int i, int i2, int i3) {
        this.irC = null;
        this.irC = str;
        this.bdf = 1;
        this.bkU = i3;
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("receiver_name", str2);
        hashMap.put("invalid_time", String.valueOf(i));
        u(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("MicroMsg.NetScenePayURemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.irD = jSONObject.optInt("pay_time");
            this.eWz = jSONObject.optDouble("total_fee") / 100.0d;
            this.hNg = jSONObject.optString("fee_type");
            this.status = jSONObject.optInt("pay_status");
            this.lan = jSONObject.optInt("refund_time");
            this.lao = jSONObject.optInt("receive_time");
        }
    }

    public final int bfC() {
        return 25;
    }
}
