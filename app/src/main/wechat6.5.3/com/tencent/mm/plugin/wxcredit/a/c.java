package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class c extends g {
    public double lvP = 0.0d;

    public c(List<l> list, String str) {
        Map hashMap = new HashMap();
        hashMap.put("session_key", str);
        int i = 0;
        for (l lVar : list) {
            int i2;
            hashMap.put("qt_id_" + i, lVar.id);
            hashMap.put("ans_cont_" + i, lVar.hbw);
            hashMap.put("level_" + i, lVar.level);
            hashMap.put("parent_id_" + i, lVar.lwl);
            i++;
            if (lVar.lwn == null || !"Y".equals(lVar.hbw)) {
                i2 = i;
            } else {
                hashMap.put("qt_id_" + i, lVar.lwn.id);
                hashMap.put("ans_cont_" + i, lVar.lwn.hbw);
                hashMap.put("level_" + i, lVar.lwn.level);
                hashMap.put("parent_id_" + i, lVar.lwn.lwl);
                i2 = i + 1;
            }
            i = i2;
        }
        hashMap.put("total_num", String.valueOf(i));
        u(hashMap);
    }

    public final int aed() {
        return 60;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            try {
                this.lvP = ((double) jSONObject.getInt("credit_amount")) / 100.0d;
            } catch (Throwable e) {
                v.a("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            }
        }
    }
}
