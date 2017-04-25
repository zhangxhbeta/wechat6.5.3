package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ac extends z {
    public String haB;
    public int haG;
    public String hci;
    public String hcj;
    public String hck;
    public String hcl;
    public String hcm = "";
    public String hcn = "";
    public String hco = "";
    public a hcp;

    public ac(int i, long j, long j2, int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3) {
        this.haG = i;
        Map hashMap = new HashMap();
        hashMap.put("totalNum", String.valueOf(i));
        hashMap.put("totalAmount", String.valueOf(j));
        hashMap.put("perValue", String.valueOf(j2));
        hashMap.put("hbType", String.valueOf(i2));
        hashMap.put("wishing", URLEncoder.encode(be.ma(str)));
        hashMap.put("sendUserName", str5);
        if (!be.kS(str3)) {
            hashMap.put("username", str3);
        }
        if (!be.kS(str2)) {
            hashMap.put("headImg", URLEncoder.encode(str2));
            hashMap.put("nickName", URLEncoder.encode(be.ma(str6)));
            if (!be.kS(str4)) {
                hashMap.put("receiveNickName", URLEncoder.encode(str4));
            }
        }
        hashMap.put("inWay", String.valueOf(i3));
        if (i3 == 0 || i3 == 1 || i3 == 7) {
            hashMap.put("needSendToMySelf", "0");
        }
        u(hashMap);
    }

    public final int getType() {
        return 1575;
    }

    public final String axK() {
        return "/cgi-bin/mmpay-bin/requestwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.haB = jSONObject.optString("sendId");
        this.hci = jSONObject.optString("reqkey");
        this.hcj = jSONObject.optString("sendMsgXml");
        this.hck = jSONObject.optString("guide_flag", "0");
        this.hcl = jSONObject.optString("guide_wording");
        this.hcm = jSONObject.optString("left_button_wording", "");
        this.hcn = jSONObject.optString("right_button_wording", "");
        this.hco = jSONObject.optString("upload_credit_url", "");
        if (jSONObject.has("showmess")) {
            v.i("MicroMsg.NetSceneLuckyMoneyNormalBase", "has alert item");
            a aVar = new a();
            aVar.bhe = jSONObject.optString("retmsg");
            JSONObject optJSONObject = jSONObject.optJSONObject("showmess");
            aVar.hcm = optJSONObject.optString("left_button_wording");
            aVar.hcn = optJSONObject.optString("right_button_wording");
            aVar.kMP = optJSONObject.optString("right_button_url");
            this.hcp = aVar;
        }
    }

    public final boolean axN() {
        return true;
    }
}
