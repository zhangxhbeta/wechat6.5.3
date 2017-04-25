package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.t.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class t extends q {
    public String cCj;
    public String haB;
    public int haN;
    public ag haT;
    public String haU;
    public int hau;
    public int hav;
    public String haw;
    public String hbA;
    public int hbD;
    public String hbE;
    public String hbF;
    public int hbG;
    public int hbJ;
    public String hbK;
    public String hbL;
    public int hbM = 1;
    public String hbN = null;
    public String hbO = null;
    public String hbP = null;
    public String hbQ = null;
    public String hbR = null;
    public long hbS = 0;
    public String hbz;

    public t(String str, String str2, int i, String str3) {
        this.cCj = str2;
        this.haB = str;
        this.hbJ = i;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        if (!be.kS(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("way", String.valueOf(i));
        hashMap.put("channelId", "2");
        hashMap.put("package", str3);
        ak.yW();
        long longValue = ((Long) c.vf().get(a.nsD, Long.valueOf(0))).longValue();
        if (longValue > 0) {
            if (System.currentTimeMillis() < longValue) {
                hashMap.put("agreeDuty", "0");
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                ak.yW();
                hashMap.put("agreeDuty", stringBuilder.append((Integer) c.vf().get(a.nsE, Integer.valueOf(1))).toString());
            }
        }
        u(hashMap);
    }

    public final int axL() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.hbK = jSONObject.optString("spidLogo");
        this.hbL = jSONObject.optString("spidWishing");
        this.hbz = jSONObject.optString("spidName");
        this.hbK = jSONObject.optString("spidLogo");
        this.hav = jSONObject.optInt("hbStatus");
        this.haN = jSONObject.optInt("receiveStatus");
        this.haw = jSONObject.optString("statusMess");
        this.hbA = jSONObject.optString("hintMess");
        this.haU = jSONObject.optString("watermark");
        this.haB = jSONObject.optString("sendId");
        this.hbD = jSONObject.optInt("focusFlag");
        this.hbE = jSONObject.optString("focusWording");
        this.hbF = jSONObject.optString("focusAppidUserName");
        this.hbG = jSONObject.optInt("isFocus");
        this.hau = jSONObject.optInt("hbType");
        JSONObject optJSONObject = jSONObject.optJSONObject("agree_duty");
        if (optJSONObject != null) {
            this.hbN = optJSONObject.optString("agreed_flag", "-1");
            this.hbO = optJSONObject.optString(FFmpegMetadataRetriever.METADATA_KEY_TITLE, "");
            this.hbP = optJSONObject.optString("service_protocol_wording", "");
            this.hbQ = optJSONObject.optString("service_protocol_url", "");
            this.hbR = optJSONObject.optString("button_wording", "");
            this.hbS = optJSONObject.optLong("delay_expired_time", 0);
        }
        if (this.hbS > 0) {
            ak.yW();
            c.vf().a(a.nsD, Long.valueOf(System.currentTimeMillis() + (this.hbS * 1000)));
        }
        this.haT = l.r(jSONObject.optJSONObject("operationTail"));
    }
}
