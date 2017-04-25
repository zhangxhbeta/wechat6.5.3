package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h extends a {
    public int haq = 0;
    public String hbX;
    public String irL = "";
    public String irM = "";
    public String irN;

    public h(int i) {
        v.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTenpayh5Index create");
        Map hashMap = new HashMap();
        hashMap.put("wallet_type", String.valueOf(i));
        u(hashMap);
    }

    public final int axL() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("MicroMsg.NetSceneTenpayh5Index", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            v.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTransferChargeQuery request error");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        this.haq = jSONObject.optInt("currency");
        this.irL = jSONObject.optString("currencyUint");
        this.irM = jSONObject.optString("currencyWording");
        this.hbX = jSONObject.optString("notice");
        this.irN = jSONObject.optString("notice_url");
        stringBuffer.append("currency:" + this.haq);
        stringBuffer.append(" currencyuint:" + this.irL);
        stringBuffer.append(" currencywording:" + this.irM);
        stringBuffer.append(" notice:" + this.hbX);
        stringBuffer.append(" notice_url:" + this.irN);
        v.i("MicroMsg.NetSceneTenpayh5Index", "resp " + stringBuffer.toString());
    }

    public final int getType() {
        return 1574;
    }

    public final String axK() {
        return "/cgi-bin/mmpay-bin/h5transferoperate";
    }
}
