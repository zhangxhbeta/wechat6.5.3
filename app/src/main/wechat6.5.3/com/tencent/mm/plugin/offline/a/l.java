package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class l extends g {
    public l(int i, int i2, int i3) {
        Map hashMap = new HashMap();
        hashMap.put("residue_num", String.valueOf(i));
        hashMap.put("entry_scene", String.valueOf(i2));
        hashMap.put("is_snapshot", String.valueOf(i3));
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        hashMap.put("code_ver", stringBuilder.append(c.vf().get(a.non, "")).toString());
        hashMap.put("card_id", com.tencent.mm.plugin.offline.b.a.eAS);
        hashMap.put("user_card_id", com.tencent.mm.plugin.offline.b.a.hMo);
        hashMap.put("card_code", com.tencent.mm.plugin.offline.b.a.hMp);
        u(hashMap);
        v.i("MicroMsg.NetSceneTenpayWxOfflineShowCode", "hy: residue_num == %d, entryscene = %d,is_snapshot = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        v.d("MicroMsg.NetSceneTenpayWxOfflineShowCode", "card_id=%s,  user_card_id=%s,  card_code:%s ", new Object[]{com.tencent.mm.plugin.offline.b.a.eAS, com.tencent.mm.plugin.offline.b.a.hMo, com.tencent.mm.plugin.offline.b.a.hMp});
    }

    public final int aed() {
        return 102;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final int zg() {
        return 572;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineshowcode";
    }
}
