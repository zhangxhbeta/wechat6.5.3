package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class e extends h {
    public boolean hdn = false;
    public Orders hdo = null;
    private int isa = -1;

    public e(l lVar, Orders orders) {
        String str = null;
        this.hdo = orders;
        List list = orders.kPm;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).eWA;
        }
        if (lVar.imN == null) {
            v.e("MicroMsg.NetSceneTenpayPayVertify", "empty payInfo");
            return;
        }
        this.isa = lVar.imN.bkq;
        a(orders.fTG, str, lVar.imN.bkq, lVar.imN.bkh, lVar.hMt, lVar.hMu);
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("flag", lVar.flag);
        hashMap.put("passwd", lVar.kQj);
        v.i("MicroMsg.NetSceneTenpayPayVertify", "hy: has pwd: %b", new Object[]{Boolean.valueOf(!be.kS(lVar.kQj))});
        a(lVar.imN, hashMap, hashMap2, r0);
        hashMap.put("verify_code", lVar.kQk);
        hashMap.put("token", lVar.token);
        hashMap.put("bank_type", lVar.hMt);
        hashMap.put("bind_serial", lVar.hMu);
        hashMap.put("arrive_type", lVar.kMZ);
        hashMap.put("default_favorcomposedid", lVar.kNd);
        hashMap.put("favorcomposedid", lVar.kNe);
        u(hashMap);
        aa(hashMap2);
    }

    public int aed() {
        return 1;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (i == 0) {
            v.d("MicroMsg.NetSceneTenpayPayVertify", "Pay Success! saving bind_serial:" + jSONObject.optString("bind_serial"));
            if ("1".equals(jSONObject.optString("pay_flag"))) {
                this.hdn = true;
                this.hdo = Orders.a(jSONObject, this.hdo);
            } else {
                this.hdn = false;
            }
            v.i("MicroMsg.NetSceneTenpayPayVertify", "mPayScene:" + this.isa);
            if (this.isa == 39) {
                v.i("MicroMsg.NetSceneTenpayPayVertify", "it's the sns scene, parse the sns pay data");
                b.F(jSONObject);
                return;
            }
            v.i("MicroMsg.NetSceneTenpayPayVertify", "it's not the sns scene");
        }
    }

    public String getUri() {
        if (this.isa == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveverify";
        }
        if (this.isa == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchverify";
        }
        return "/cgi-bin/mmpay-bin/tenpay/verify";
    }

    public int zg() {
        if (this.isa == 11) {
            return 1607;
        }
        if (this.isa == 21) {
            return 1606;
        }
        return 462;
    }
}
