package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends g {
    public double irs;
    public String isi;
    public double kLA;
    public String kLz;

    public p(int i) {
        v.i("Micromsg.NetSceneTransferChargeQuery", "NetSceneTransferChargeQuery create");
        Map hashMap = new HashMap();
        hashMap.put("pay_scene", String.valueOf(i));
        u(hashMap);
    }

    public final int aed() {
        return 0;
    }

    public final int zg() {
        return 1689;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfergetchargefee";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("Micromsg.NetSceneTransferChargeQuery", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            v.i("Micromsg.NetSceneTransferChargeQuery", "NetSceneTransferChargeQuery request error");
            return;
        }
        this.kLz = jSONObject.optString("short_desc");
        this.isi = jSONObject.optString("charge_desc");
        this.kLA = jSONObject.optDouble("acc_fee");
        this.irs = jSONObject.optDouble("remain_fee") / 100.0d;
    }
}
