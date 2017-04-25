package com.tencent.mm.plugin.wallet_core.id_verify.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends g {
    public c(String str, String str2, int i) {
        this(str, str2, i, (byte) 0);
    }

    private c(String str, String str2, int i, byte b) {
        Map hashMap = new HashMap();
        hashMap.put("flag", "1");
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        hashMap.put("realname_scene", String.valueOf(i));
        v.i("MicroMsg.NetSceneRealNameReg", "realname_scene=%d", new Object[]{Integer.valueOf(i)});
        u(hashMap);
    }

    public final int aed() {
        return 1648;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("MicroMsg.NetSceneRealNameReg", "errCode=" + str + ";errMsg=" + str);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamereg";
    }

    public final int zg() {
        return 1648;
    }
}
