package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class l extends g {
    public String brU;
    public String brV;
    public String brW;
    public String brX;
    public String brY;

    public l(String str) {
        this(str, 0);
    }

    public l(String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("req_key", str);
        hashMap.put("bind_query_scene", String.valueOf(i));
        j.g gVar = a.lxX;
        hashMap.put("is_root", "0");
        if (gVar != null) {
            hashMap.put("is_device_open_touch", "1");
            Map anB = gVar.anB();
            if (anB != null) {
                hashMap.putAll(anB);
            }
            v.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is true");
        } else {
            hashMap.put("is_device_open_touch", "0");
            v.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is false");
        }
        u(hashMap);
        Map hashMap2 = new HashMap();
        ak.yW();
        String str2 = (String) c.vf().get(196612, null);
        ak.yW();
        String str3 = (String) c.vf().get(196613, null);
        hashMap2.put("bind_serial", str2);
        hashMap2.put("last_bind_serial", str3);
        aa(hashMap2);
    }

    public final int aed() {
        return 72;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            if (jSONObject.has("real_name_info")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                v.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "get real_name_info %s", new Object[]{optJSONObject.toString()});
                this.brU = optJSONObject.optString("guide_flag");
                this.brV = optJSONObject.optString("guide_wording");
                this.brW = optJSONObject.optString("left_button_wording");
                this.brX = optJSONObject.optString("right_button_wording");
                this.brY = optJSONObject.optString("upload_credit_url");
            }
            w.D(jSONObject);
            j.g gVar = a.lxX;
            if (gVar != null) {
                v.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is not null");
                gVar.anv();
                return;
            }
            v.e("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is null");
        }
    }

    public final int zg() {
        return 1501;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindquerynew";
    }
}
