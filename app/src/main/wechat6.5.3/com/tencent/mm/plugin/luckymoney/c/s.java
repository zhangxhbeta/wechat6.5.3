package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class s extends q {
    public long bst;
    public String haB;
    public int haG;
    public int haN;
    public a haP;
    public int hav;
    public String haw;
    public String hbA;
    public int hbB;
    public String hbC;
    public int hbD;
    public String hbE;
    public String hbF;
    public int hbG;
    public e hbH = null;
    public RealnameGuideHelper hbI;
    public String hbz;

    public s(String str, String str2, int i, String str3, String str4) {
        this.haB = str;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        if (!be.kS(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("way", String.valueOf(i));
        hashMap.put("channelId", "2");
        hashMap.put("package", str3);
        hashMap.put("sessionUserName", str4);
        u(hashMap);
    }

    public final int axL() {
        return 1;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.hbz = jSONObject.optString("spidName");
        this.hav = jSONObject.optInt("hbStatus");
        this.haN = jSONObject.optInt("receiveStatus");
        this.haw = jSONObject.optString("statusMess");
        this.hbA = jSONObject.optString("hintMess");
        this.bst = jSONObject.optLong("amount");
        this.hbB = jSONObject.optInt("recNum");
        this.haG = jSONObject.optInt("totalNum");
        this.haP = new a();
        JSONObject optJSONObject = jSONObject.optJSONObject("atomicFunc");
        if (optJSONObject != null) {
            this.haP.cdf = optJSONObject.optInt("enable");
            this.haP.haf = optJSONObject.optString("fissionContent");
            this.haP.hae = optJSONObject.optString("fissionUrl");
        }
        this.hbD = jSONObject.optInt("focusFlag");
        this.hbE = jSONObject.optString("focusWording");
        this.hbF = jSONObject.optString("focusAppidUserName");
        this.hbG = jSONObject.optInt("isFocus");
        this.hbC = jSONObject.optString("smallHbButtonMess");
        try {
            this.hbH = l.p(jSONObject);
            this.hbH.haA = jSONObject.optString("spidLogo");
            this.hbH.haz = jSONObject.optString("spidName");
            this.hbH.hay = jSONObject.optString("spidWishing");
        } catch (JSONException e) {
            v.w("MicroMsg.NetSceneLuckyMoneyBusiBase", "parse luckyMoneyDetail fail: " + e.getLocalizedMessage());
        }
        if (i == 0 && jSONObject.has("real_name_info")) {
            optJSONObject = jSONObject.optJSONObject("real_name_info");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("guide_flag");
                String optString2 = optJSONObject.optString("guide_wording");
                String optString3 = optJSONObject.optString("left_button_wording");
                String optString4 = optJSONObject.optString("right_button_wording");
                String optString5 = optJSONObject.optString("upload_credit_url");
                this.hbI = new RealnameGuideHelper();
                this.hbI.a(optString, optString2, optString3, optString4, optString5, 1005);
            }
        }
    }
}
