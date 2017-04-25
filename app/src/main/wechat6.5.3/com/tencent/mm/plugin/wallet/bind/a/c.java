package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.mm.a.o;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends g {
    public boolean brM = false;
    public ArrayList<Bankcard> kFq = null;
    public boolean kGl = true;
    public String kGm;
    public String kGn;
    private String kGo;
    public String token;

    public c(String str, PayInfo payInfo) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        a(payInfo, hashMap, hashMap2);
        ak.yW();
        o oVar = new o(be.a((Integer) com.tencent.mm.model.c.vf().get(9, null), 0));
        this.kGo = str;
        hashMap.put("import_code", str);
        hashMap.put("qqid", oVar.toString());
        u(hashMap);
        aa(hashMap2);
    }

    public final int aed() {
        return 37;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            this.kFq = new ArrayList();
            try {
                this.brM = "1".equals(jSONObject.optString("is_reg", "0"));
                this.token = jSONObject.optString("token", "");
                JSONArray jSONArray = jSONObject.getJSONArray("Array");
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    Bankcard y = com.tencent.mm.plugin.wallet_core.model.c.bfJ().y(jSONObject2);
                    if (y != null) {
                        if ((2 == jSONObject2.optInt("bank_acc_type", 2) ? 1 : null) != null) {
                            y.field_cardType |= Bankcard.kNm;
                        }
                        y.field_bankcardTail = jSONObject2.optString("bank_tail");
                        y.kNr = "************" + y.field_bankcardTail;
                        y.field_trueName = jSONObject2.optString("true_name");
                        y.kNq = jSONObject2.optString("cre_id");
                        y.kMU = jSONObject2.optInt("cre_type", -1);
                        y.kNB = this.kGo;
                        y.kNC = 1 == jSONObject2.optInt("samecardexist", 0);
                        if (y.bfG()) {
                            y.field_desc = y.field_bankName;
                        } else if (y.bfH()) {
                            y.field_desc = aa.getContext().getString(2131236154, new Object[]{y.field_bankName, y.field_bankcardTail});
                        } else if (y.bfF()) {
                            y.field_desc = aa.getContext().getString(2131236551, new Object[]{y.field_bankName, y.field_bankcardTail});
                        } else {
                            y.field_desc = aa.getContext().getString(2131236168, new Object[]{y.field_bankName, y.field_bankcardTail});
                        }
                        JSONObject optJSONObject = jSONObject2.optJSONObject("bankappservice");
                        if (optJSONObject != null) {
                            this.kGm = optJSONObject.optString("username");
                            this.kGn = optJSONObject.optString("app_recommend_desc");
                        }
                        this.kFq.add(y);
                    }
                }
                v.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "got data---isReg:" + this.brM + ",bankcard.size:" + this.kFq.size());
            } catch (Throwable e) {
                v.a("MicroMsg.NetSceneTenpayQueryBindBankcard", e, "", new Object[0]);
            }
        }
    }
}
