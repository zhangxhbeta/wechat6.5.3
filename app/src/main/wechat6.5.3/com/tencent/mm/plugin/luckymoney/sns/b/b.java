package com.tencent.mm.plugin.luckymoney.sns.b;

import com.tencent.mm.plugin.luckymoney.sns.c.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends g {
    public int hdr = 0;

    public b(int i, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("flag", String.valueOf(i));
        hashMap.put("passwd", str);
        hashMap.put("req_key", str2);
        this.hdr = i;
        u(hashMap);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/snspaymanage";
    }

    public final int zg() {
        return 1697;
    }

    public final int aed() {
        return 1697;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("MicroMsg.NetSceneSnsPayManage", " errCode: " + i + " errMsg :" + str);
        if (i != 0) {
            v.e("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() NetSceneSnsPayManage is false!");
        } else if (this.hdr == 1) {
            a.mz(1);
            v.i("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() setIsOpenSnsPay with 1");
        } else {
            a.mz(0);
            v.i("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() setIsOpenSnsPay with 0");
        }
    }
}
