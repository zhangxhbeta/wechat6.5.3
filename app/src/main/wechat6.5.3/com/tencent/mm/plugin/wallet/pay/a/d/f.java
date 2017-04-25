package com.tencent.mm.plugin.wallet.pay.a.d;

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

public class f extends h {
    public boolean hdn = false;
    public Orders hdo = null;
    private int isa = -1;

    public f(l lVar, Orders orders) {
        String str = null;
        int i = -1;
        this.hdo = orders;
        if (lVar.imN != null) {
            this.isa = lVar.imN.bkq;
            i = lVar.imN.bkh;
        }
        List list = orders.kPm;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).eWA;
        }
        a(orders.fTG, str, this.isa, i, lVar.hMt, lVar.hMu);
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        v.i("MicroMsg.NetSceneTenpayVertifyReg", "hy: has pwd: %b", new Object[]{Boolean.valueOf(!be.kS(lVar.kQj))});
        a(lVar.imN, hashMap, hashMap2, r0);
        hashMap.put("flag", lVar.flag);
        hashMap.put("passwd", lVar.kQj);
        hashMap.put("verify_code", lVar.kQk);
        hashMap.put("token", lVar.token);
        hashMap.put("favorcomposedid", lVar.kNe);
        hashMap.put("default_favorcomposedid", lVar.kNd);
        u(hashMap);
        aa(hashMap2);
    }

    public final int aed() {
        return 16;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (i == 0) {
            v.d("MicroMsg.NetSceneTenpayVertifyReg", "Pay Success! saving bind_serial:" + jSONObject.optString("bind_serial"));
            if ("1".equals(jSONObject.optString("pay_flag"))) {
                this.hdn = true;
                this.hdo = Orders.a(jSONObject, this.hdo);
            } else {
                this.hdn = false;
            }
            v.i("MicroMsg.NetSceneTenpayVertifyReg", "mPayScene:" + this.isa);
            if (this.isa == 39) {
                v.i("MicroMsg.NetSceneTenpayVertifyReg", "it's the sns scene, parse the sns pay data");
                b.F(jSONObject);
                return;
            }
            v.i("MicroMsg.NetSceneTenpayVertifyReg", "it's not the sns scene");
        }
    }

    public String getUri() {
        if (this.isa == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveverifyreg";
        }
        if (this.isa == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchverifyreg";
        }
        return "/cgi-bin/mmpay-bin/tenpay/verifyreg";
    }

    public int zg() {
        if (this.isa == 11) {
            return 1684;
        }
        if (this.isa == 21) {
            return 1608;
        }
        return 474;
    }
}
