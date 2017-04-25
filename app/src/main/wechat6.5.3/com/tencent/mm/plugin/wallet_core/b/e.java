package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends g {
    public e() {
        u(new HashMap());
    }

    public final int aed() {
        return 1631;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("MicroMsg.NetSceneQueryUserWallet", "errCode is : " + i);
        if (i == 0) {
            k.bgd().cie.dF("WalletKindInfo", "delete from WalletKindInfo");
            if (jSONObject != null) {
                v.i("MicroMsg.NetSceneQueryUserWallet", "resp json " + jSONObject.toString());
                JSONArray optJSONArray = jSONObject.optJSONArray("UserWalletInfoList");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        s C = s.C(optJSONArray.optJSONObject(i2));
                        if (C != null) {
                            k.bgd().b(C);
                        }
                    }
                    return;
                }
                v.e("MicroMsg.NetSceneQueryUserWallet", "wallet array is null");
                return;
            }
            v.e("MicroMsg.NetSceneQueryUserWallet", "response json is null");
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/queryuserwallet";
    }

    public final int zg() {
        return 1631;
    }
}
