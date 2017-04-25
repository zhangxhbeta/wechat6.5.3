package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.c;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends g {
    public String desc;
    public String hNg;
    public double irx;

    public b(String str) {
        Map hashMap = new HashMap();
        hashMap.put("token", str);
        u(hashMap);
    }

    public final int aed() {
        return 123;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            this.hNg = jSONObject.optString("fee_type");
            this.irx = jSONObject.optDouble("total_fee") / 100.0d;
            JSONArray optJSONArray = jSONObject.optJSONArray("Array");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.desc = ((JSONObject) optJSONArray.opt(0)).optString("desc");
            }
            y bgb = k.bgb();
            JSONObject optJSONObject = jSONObject.optJSONObject("bindqueryresp");
            bgb.kQN.clear();
            if (optJSONObject == null) {
                v.e("MicroMsg.WalletRepaymentBankcardMgr", "parse from json error,json is null");
                return;
            }
            JSONObject jSONObject2;
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("Array");
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                v.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list is null");
            } else {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    c bfJ = c.bfJ();
                    try {
                        jSONObject2 = (JSONObject) optJSONArray2.get(i2);
                    } catch (Throwable e) {
                        v.a("MicroMsg.WalletRepaymentBankcardMgr", e, "", new Object[0]);
                        jSONObject2 = null;
                    }
                    if (jSONObject2 != null) {
                        Bankcard y = bfJ.y(jSONObject2);
                        if (y.bfG()) {
                            y.field_desc = y.field_bankName;
                        } else if (y.bfH()) {
                            y.field_desc = aa.getContext().getString(2131236154, new Object[]{y.field_bankName, y.field_bankcardTail});
                        } else if (y.bfF()) {
                            y.field_desc = aa.getContext().getString(2131236551, new Object[]{y.field_bankName, y.field_bankcardTail});
                        } else {
                            y.field_desc = aa.getContext().getString(2131236168, new Object[]{y.field_bankName, y.field_bankcardTail});
                        }
                        bgb.kQN.add(y);
                    }
                }
            }
            jSONObject2 = optJSONObject.optJSONObject("user_info");
            if (jSONObject2 != null) {
                bgb.kQO = jSONObject2.optString("last_card_bind_serialno");
            } else {
                v.e("MicroMsg.WalletRepaymentBankcardMgr", "user_info is null");
            }
        }
    }

    public final int zg() {
        return 1603;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/webankloanordershow";
    }
}
