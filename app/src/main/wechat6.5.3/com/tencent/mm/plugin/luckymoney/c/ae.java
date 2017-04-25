package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ae extends z {
    public int aPW;
    long bao;
    String bdo;
    public String cCj;
    public String haA;
    public String haB;
    public int haK;
    public int haN;
    public ag haT;
    public String haU;
    public String haX;
    public int hau;
    public int hav;
    public String haw;
    public String hay;
    public int hbM = 1;
    public String hbN = null;
    public String hbO = null;
    public String hbP = null;
    public String hbQ = null;
    public String hbR = null;
    public long hbS = 0;
    public int hcc = 0;
    public String hcq;
    public long hcr;
    public long hcs;
    public int hct;
    public int msgType = 1;

    public ae(int i, String str, String str2, int i2, String str3) {
        this.aPW = i;
        this.haB = str;
        this.cCj = str2;
        Map hashMap = new HashMap();
        hashMap.put("msgType", "1");
        hashMap.put(DownloadInfoColumns.CHANNELID, String.valueOf(i));
        hashMap.put("sendId", str);
        hashMap.put("inWay", String.valueOf(i2));
        hashMap.put("ver", str3);
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
        if (!be.kS(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        u(hashMap);
    }

    public final int getType() {
        return 1581;
    }

    public final String axK() {
        return "/cgi-bin/mmpay-bin/receivewxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.hcq = jSONObject.optString("sendNick");
        this.haA = jSONObject.optString("sendHeadImg");
        this.hav = jSONObject.optInt("hbStatus");
        this.haN = jSONObject.optInt("receiveStatus");
        this.haw = jSONObject.optString("statusMess");
        this.hay = jSONObject.optString("wishing");
        this.haK = jSONObject.optInt("isSender");
        this.hcr = jSONObject.optLong("sceneAmount");
        this.hcs = jSONObject.optLong("sceneRecTimeStamp");
        this.hau = jSONObject.optInt("hbType");
        this.haU = jSONObject.optString("watermark");
        this.haX = jSONObject.optString("externMess");
        this.haT = l.r(jSONObject.optJSONObject("operationTail"));
        this.hcc = jSONObject.optInt("scenePicSwitch");
        JSONObject optJSONObject = jSONObject.optJSONObject("agree_duty");
        if (optJSONObject != null) {
            this.hbN = optJSONObject.optString("agreed_flag", "-1");
            this.hbO = optJSONObject.optString("title", "");
            this.hbP = optJSONObject.optString("service_protocol_wording", "");
            this.hbQ = optJSONObject.optString("service_protocol_url", "");
            this.hbR = optJSONObject.optString("button_wording", "");
            this.hbS = optJSONObject.optLong("delay_expired_time", 0);
        }
        if (this.hbS > 0) {
            ak.yW();
            c.vf().a(a.nsD, Long.valueOf(System.currentTimeMillis() + (this.hbS * 1000)));
        }
        v.i("MicroMsg.NetSceneReceiveLuckyMoney", "scenePicSwitch:" + this.hcc);
        this.hct = jSONObject.optInt("preStrainFlag", 1);
        v.i("MicroMsg.NetSceneReceiveLuckyMoney", "preStrainFlag:" + this.hct);
        ak.yW();
        c.vf().a(a.nss, Integer.valueOf(this.hct));
    }

    public final boolean axP() {
        return this.haK == 1;
    }
}
