package com.tencent.mm.plugin.wallet_core.id_verify.a;

import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends g {
    public String kMA;
    public String kMB;
    public String kMy;
    public String kMz;

    public f() {
        Map hashMap = new HashMap();
        hashMap.put("channel", "1");
        u(hashMap);
    }

    public final int aed() {
        return 1630;
    }

    public final int zg() {
        return 1630;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnameguidequery";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0 && jSONObject != null) {
            this.kMy = jSONObject.optString("guide_flag");
            this.kMz = jSONObject.optString("guide_wording");
            this.kMA = jSONObject.optString("left_button_wording");
            this.kMB = jSONObject.optString("right_button_wording");
        }
    }
}
