package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i extends a {
    public int haq = 0;
    public String irO = "";
    public String irP = "";
    public int irQ;
    public int irl;

    public i(double d, String str, String str2, String str3, String str4, int i) {
        v.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay create");
        Map hashMap = new HashMap();
        try {
            hashMap.put("transfer_amount", Math.round(100.0d * d));
            hashMap.put("pay_nickname", URLEncoder.encode(str, ProtocolPackage.ServerEncoding));
            hashMap.put("rcvd_username", str2);
            hashMap.put("rcvd_nickname", URLEncoder.encode(str3, ProtocolPackage.ServerEncoding));
            hashMap.put("reason", URLEncoder.encode(be.ah(str4, ""), ProtocolPackage.ServerEncoding));
            hashMap.put("currency", String.valueOf(i));
        } catch (Exception e) {
            v.e("MicroMsg.NetSceneTenpayh5Pay", "error " + e.getMessage());
        }
        u(hashMap);
    }

    public final int axL() {
        return 1;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("MicroMsg.NetSceneTenpayh5Pay", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            v.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay request error");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        this.irO = jSONObject.optString("payurl");
        this.irP = jSONObject.optString("tradeurl");
        this.irl = jSONObject.optInt("transfering_num");
        this.irQ = jSONObject.optInt("transfering_type");
        stringBuffer.append("payurl:" + this.irO);
        stringBuffer.append(" tradeurl:" + this.irP);
        stringBuffer.append(" transfering_num:" + this.irl);
        stringBuffer.append(" transfering_type:" + this.irQ);
        v.i("MicroMsg.NetSceneTenpayh5Pay", "resp " + stringBuffer.toString());
    }

    public final int getType() {
        return 1622;
    }

    public final String axK() {
        return "/cgi-bin/mmpay-bin/h5requesttransfer";
    }
}
