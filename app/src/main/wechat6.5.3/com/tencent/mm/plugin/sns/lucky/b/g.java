package com.tencent.mm.plugin.sns.lucky.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.plugin.luckymoney.c.ag;
import com.tencent.mm.plugin.luckymoney.c.c;
import com.tencent.mm.plugin.luckymoney.c.l;
import com.tencent.mm.plugin.luckymoney.c.z;
import com.tencent.mm.storage.t;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends z {
    public ag haT;
    public String hbU;
    public boolean hbV;
    public int hbW;
    public String hbX;
    public String hbY;
    public ag hbZ;
    public ag hca;
    public ag hcb;

    public g(String str) {
        Map hashMap = new HashMap();
        hashMap.put("scene", "2");
        hashMap.put("ver", str);
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
            c cVar = new c();
            cVar.hak = jSONObject.optString("groupHint");
            cVar.hal = jSONObject.optString("personalHint");
            cVar.haj = ((double) jSONObject.optLong("totalAmount", 200000)) / 100.0d;
            cVar.hai = jSONObject.optInt("totalNum", 100);
            cVar.ham = ((double) jSONObject.optLong("perPersonMaxValue", 20000)) / 100.0d;
            cVar.han = ((double) jSONObject.optLong("perGroupMaxValue", 20000)) / 100.0d;
            cVar.hao = ((double) jSONObject.optLong("perMinValue", 1)) / 100.0d;
            a.axz();
            a.axA().a(cVar);
            this.hbZ = l.r(jSONObject.optJSONObject("operationHeader"));
            this.haT = l.r(jSONObject.optJSONObject("operationTail"));
            this.hca = l.r(jSONObject.optJSONObject("operationNext"));
            this.hcb = l.r(jSONObject.optJSONObject("operationMiddle"));
            int optInt = jSONObject.optInt("sceneSwitch");
            ak.yW();
            com.tencent.mm.model.c.vf().a(t.a.noY, Integer.valueOf(optInt));
        }
    }
}
