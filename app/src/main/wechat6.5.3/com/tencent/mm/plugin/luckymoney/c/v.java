package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.storage.t;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class v extends z {
    public ag haT;
    public int haq;
    public String har;
    public String has;
    public String hbU;
    public boolean hbV;
    public int hbW;
    public String hbX;
    public String hbY;
    public ag hbZ;
    public ag hca;
    public ag hcb;
    public int hcc = 0;
    public LinkedList<k> hcd;

    public v(String str) {
        Map hashMap = new HashMap();
        hashMap.put("scene", "8");
        hashMap.put("ver", str);
        ak.yW();
        hashMap.put("walletType", String.valueOf(c.vf().get(339975, null)));
        u(hashMap);
    }

    public v(String str, byte b) {
        Map hashMap = new HashMap();
        hashMap.put("ver", str);
        ak.yW();
        hashMap.put("walletType", String.valueOf(c.vf().get(339975, null)));
        u(hashMap);
    }

    public final int getType() {
        return 1554;
    }

    public final String axK() {
        return "/cgi-bin/mmpay-bin/operationwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        boolean z = true;
        if (i == 0) {
            this.hbW = jSONObject.optInt("randomAmount");
            this.hbU = jSONObject.optString("randomWishing");
            this.hbX = jSONObject.optString("notice");
            this.hbY = jSONObject.optString("notice_url");
            if (jSONObject.optInt("hasCanShareHongBao") != 1) {
                z = false;
            }
            this.hbV = z;
            this.haq = jSONObject.optInt("currency");
            this.har = jSONObject.optString("currencyUint");
            this.has = jSONObject.optString("currencyWording");
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "currency=" + this.haq + ";currencyUint=" + this.har + ";currencyWording=" + this.has);
            c cVar = new c();
            cVar.hak = jSONObject.optString("groupHint");
            cVar.hal = jSONObject.optString("personalHint");
            cVar.haj = ((double) jSONObject.optLong("totalAmount", 200000)) / 100.0d;
            cVar.hai = jSONObject.optInt("totalNum", 100);
            cVar.ham = ((double) jSONObject.optLong("perPersonMaxValue", 20000)) / 100.0d;
            cVar.han = ((double) jSONObject.optLong("perGroupMaxValue", 20000)) / 100.0d;
            cVar.hao = ((double) jSONObject.optLong("perMinValue", 1)) / 100.0d;
            cVar.hap = jSONObject.optInt("payShowBGFlag");
            cVar.haq = this.haq;
            cVar.har = this.har;
            cVar.has = this.has;
            a.axz();
            a.axA().a(cVar);
            this.hbZ = l.r(jSONObject.optJSONObject("operationHeader"));
            this.haT = l.r(jSONObject.optJSONObject("operationTail"));
            this.hca = l.r(jSONObject.optJSONObject("operationNext"));
            this.hcb = l.r(jSONObject.optJSONObject("operationMiddle"));
            int optInt = jSONObject.optInt("sceneSwitch");
            ak.yW();
            c.vf().a(t.a.noY, Integer.valueOf(optInt));
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "sceneSwitch:" + optInt);
            this.hcc = jSONObject.optInt("scenePicSwitch");
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "scenePicSwitch:" + this.hcc);
            JSONArray optJSONArray = jSONObject.optJSONArray("yearMess");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson is empty!");
                return;
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson length:" + optJSONArray.length());
            this.hcd = new LinkedList();
            for (optInt = 0; optInt < optJSONArray.length(); optInt++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(optInt);
                k kVar = new k();
                kVar.hbs = optJSONObject.optInt("yearAmount", 0);
                kVar.hbt = optJSONObject.optString("yearWish");
                this.hcd.add(kVar);
            }
            return;
        }
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + i + ", errMsg:" + str);
    }
}
