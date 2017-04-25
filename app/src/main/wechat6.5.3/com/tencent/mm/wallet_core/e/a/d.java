package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;
import org.json.JSONObject;

public class d extends j {
    protected JSONObject piW;

    public d(Map<String, String> map) {
        v.i("MicroMsg.NetSceneDelayQueryOrder", "NetSceneDelayQueryOrder call");
        u(map);
    }

    public final int aed() {
        return 1525;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/payorderquery";
    }

    public int zg() {
        return 1525;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        v.i("MicroMsg.NetSceneDelayQueryOrder", "errCode = " + i + "errMsg=" + str);
        this.piW = jSONObject;
    }

    public final JSONObject bLr() {
        return this.piW;
    }
}
