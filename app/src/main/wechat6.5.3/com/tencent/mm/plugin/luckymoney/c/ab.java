package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab extends z {
    long bao;
    public String bdo;
    public String cCj;
    public String haB;
    public e hbH = null;
    public RealnameGuideHelper hbI;

    public ab(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6) {
        this.haB = str;
        this.cCj = str2;
        this.bdo = str5;
        Map hashMap = new HashMap();
        hashMap.put("msgType", String.valueOf(i));
        hashMap.put(DownloadInfoColumns.CHANNELID, String.valueOf(i2));
        hashMap.put("sendId", str);
        if (!be.kS(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        if (!be.kS(str3)) {
            hashMap.put("headImg", URLEncoder.encode(str3));
            hashMap.put("nickName", URLEncoder.encode(be.ma(str4)));
        }
        hashMap.put("sessionUserName", str5);
        hashMap.put("ver", str6);
        u(hashMap);
    }

    public final int getType() {
        return 1685;
    }

    public final String axK() {
        return "/cgi-bin/mmpay-bin/openwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            this.hbH = l.p(jSONObject);
            if (i == 0 && jSONObject.has("real_name_info")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("guide_flag");
                    String optString2 = optJSONObject.optString("guide_wording");
                    String optString3 = optJSONObject.optString("left_button_wording");
                    String optString4 = optJSONObject.optString("right_button_wording");
                    String optString5 = optJSONObject.optString("upload_credit_url");
                    this.hbI = new RealnameGuideHelper();
                    this.hbI.a(optString, optString2, optString3, optString4, optString5, 1003);
                }
            }
        } catch (JSONException e) {
            v.w("NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + e.getLocalizedMessage());
        }
    }
}
