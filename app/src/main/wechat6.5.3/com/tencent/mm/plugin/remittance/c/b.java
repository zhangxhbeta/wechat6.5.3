package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends g {
    public b(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("receiver_user_name", str);
        hashMap.put("transfer_qrcode_id", str2);
        u(hashMap);
    }

    public final int aed() {
        return 0;
    }

    public final int zg() {
        return 1535;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfersendcancelf2f";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("MicroMsg.NetSenceTenPayBase", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
        }
    }
}
