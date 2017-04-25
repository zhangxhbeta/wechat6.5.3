package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class x extends z {
    public String hbT;
    public g hce;
    public List<String> hcf;
    public String hcg;
    public String hch = null;

    public x(int i, int i2, int i3, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("limit", String.valueOf(i));
        hashMap.put("offset", String.valueOf(i2));
        hashMap.put(Columns.TYPE, String.valueOf(i3));
        hashMap.put("year", str);
        hashMap.put("ver", str2);
        hashMap.put("processContent", str3);
        u(hashMap);
    }

    public final int getType() {
        return 1514;
    }

    public final String axK() {
        return "/cgi-bin/mmpay-bin/qrylistwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            int i2;
            g gVar = new g();
            gVar.hbc = jSONObject.optInt("recTotalNum");
            gVar.hbd = jSONObject.optLong("recTotalAmount");
            gVar.hbe = jSONObject.optInt("sendTotalNum");
            gVar.hbf = jSONObject.optLong("sendTotalAmount");
            gVar.haL = jSONObject.optInt("isContinue");
            gVar.cWd = jSONObject.optInt("gameCount");
            JSONArray optJSONArray = jSONObject.optJSONArray("record");
            LinkedList linkedList = new LinkedList();
            if (optJSONArray != null) {
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    h hVar = new h();
                    hVar.hbg = jSONObject2.optString("sendName");
                    hVar.haA = jSONObject2.optString("sendHeadImg");
                    hVar.hbh = jSONObject2.optLong("receiveAmount");
                    hVar.hbi = jSONObject2.optString("receiveTime");
                    hVar.hau = jSONObject2.optInt("hbType");
                    hVar.hbj = jSONObject2.optString("sendTitle");
                    hVar.hbk = jSONObject2.optString("sendTime");
                    hVar.haH = jSONObject2.optLong("totalAmount");
                    hVar.hbl = jSONObject2.optLong("totalNum");
                    hVar.haE = jSONObject2.optLong("recNum");
                    hVar.status = jSONObject2.optInt(DownloadInfo.STATUS);
                    hVar.hbm = jSONObject2.optInt("thxCount");
                    hVar.haI = jSONObject2.optString("receiveId");
                    hVar.haB = jSONObject2.optString("sendId");
                    hVar.haW = jSONObject2.optInt("hbKind");
                    linkedList.add(hVar);
                }
            }
            gVar.haY = linkedList;
            this.hce = gVar;
            this.hcf = new ArrayList();
            String optString = jSONObject.optString("years");
            if (!be.kS(optString)) {
                String[] split = optString.split("\\|");
                if (split != null) {
                    for (Object add : split) {
                        this.hcf.add(add);
                    }
                }
            }
            this.hcg = jSONObject.optString("recordYear");
            this.hch = jSONObject.optString("clickedUrl");
            this.hbT = jSONObject.optString("processContent");
        } catch (Throwable e) {
            v.a("MicroMsg.NetSceneLuckyMoneyNormalBase", e, "", new Object[0]);
        }
    }

    public final boolean axO() {
        if (this.hce == null || this.hce.haL == 1) {
            return true;
        }
        return false;
    }
}
