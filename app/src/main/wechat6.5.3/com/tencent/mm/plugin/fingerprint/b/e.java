package com.tencent.mm.plugin.fingerprint.b;

import android.text.TextUtils;
import com.tencent.mm.network.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends g implements j {
    public String bft = "";
    public String fTO = "";
    public String fUn = "";

    public e(String str) {
        Map hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is empty");
        } else {
            v.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is not empty");
        }
        hashMap.put("encrypted_cert_info", URLEncoder.encode(str));
        hashMap.put("ver", "0x1.0");
        u(hashMap);
    }

    public final int aed() {
        return 118;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fTO = jSONObject.optString("encrypted_device_info");
            this.bft = jSONObject.optString("encrypted_rsa_sign");
            this.fUn = jSONObject.optString("cert");
            if (TextUtils.isEmpty(this.fTO)) {
                v.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is empty");
            } else {
                v.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is not empty");
            }
            if (TextUtils.isEmpty(this.bft)) {
                v.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is empty");
            } else {
                v.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is not empty");
            }
            if (TextUtils.isEmpty(this.fUn)) {
                v.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is empty");
            } else {
                v.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is not empty");
            }
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getopentouchcert";
    }

    public final int zg() {
        return 1598;
    }
}
