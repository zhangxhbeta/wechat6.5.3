package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends g {
    public c(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Map hashMap = new HashMap();
        hashMap.put("toUser", str);
        hashMap.put("receiverTitle", str2);
        hashMap.put("senderTitle", str3);
        hashMap.put("tempId", str4);
        hashMap.put("receiverdes", str6);
        hashMap.put("senderdes", str5);
        hashMap.put("Url", str7);
        hashMap.put("Scene", str8);
        u(hashMap);
    }

    public final int aed() {
        return 104;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("Micromsg.NetSceneSendC2CMsg", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
        }
    }
}
