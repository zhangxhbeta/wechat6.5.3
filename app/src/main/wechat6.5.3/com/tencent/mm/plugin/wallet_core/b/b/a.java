package com.tencent.mm.plugin.wallet_core.b.b;

import com.tencent.mm.network.e;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.b.m;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.d.a.a {
    private boolean kLJ;

    public a() {
        this("");
    }

    public a(String str) {
        this(str, true);
    }

    public a(String str, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("req_key", str);
        u(hashMap);
        this.kLJ = z;
    }

    public final int bfC() {
        return 1;
    }

    public final int a(e eVar, com.tencent.mm.v.e eVar2) {
        return super.a(eVar, eVar2);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("MicroMsg.NetScenePayUQueryBoundBankcard", "hy: payu query bind on gy net end. errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (i == 0) {
            try {
                Bankcard bankcard;
                String optString = jSONObject.optString("time_stamp");
                if (!be.kS(optString)) {
                    m.setTimeStamp(optString);
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
                aa aaVar = new aa();
                if (jSONObject2 == null || jSONObject2.length() <= 0) {
                    aaVar = null;
                } else {
                    aaVar.field_is_reg = be.getInt(jSONObject2.optString("is_reg"), 0);
                    aaVar.field_true_name = jSONObject2.optString("true_name");
                    aaVar.field_main_card_bind_serialno = jSONObject2.optString("main_card_bind_serialno");
                    aaVar.field_ftf_pay_url = jSONObject2.optString("transfer_url");
                    k.bga();
                    ab.Df(aaVar.field_main_card_bind_serialno);
                }
                aaVar.field_switchConfig = jSONObject.getJSONObject("switch_info").getInt("switch_bit");
                JSONArray optJSONArray = jSONObject.optJSONArray("Array");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                        jSONObject3.put("extra_bind_flag", "NORMAL");
                        Bankcard y = com.tencent.mm.plugin.wallet_core.model.a.a.bgP().y(jSONObject3);
                        if (y != null) {
                            arrayList.add(y);
                        }
                    }
                }
                jSONObject2 = jSONObject.optJSONObject("balance_info");
                if (jSONObject2 == null || jSONObject2.length() <= 0) {
                    bankcard = null;
                } else {
                    bankcard = new Bankcard((byte) 0);
                    bankcard.kNv = ((double) jSONObject2.optInt("avail_balance")) / 100.0d;
                    bankcard.kNx = ((double) jSONObject2.optInt("fetch_balance")) / 100.0d;
                    bankcard.field_bankcardType = jSONObject2.optString("balance_bank_type");
                    bankcard.field_bindSerial = jSONObject2.optString("balance_bind_serial");
                    bankcard.field_forbidWord = jSONObject2.optString("balance_forbid_word");
                    bankcard.field_desc = com.tencent.mm.sdk.platformtools.aa.getContext().getString(2131236188);
                    bankcard.field_cardType |= Bankcard.kNo;
                }
                k.bga().a(aaVar, arrayList, null, bankcard, null, null, null, 0);
            } catch (Throwable e) {
                v.a("MicroMsg.NetScenePayUQueryBoundBankcard", e, "", new Object[0]);
            }
            if (this.kLJ && !k.bga().bgv()) {
                this.cii.a(BaseReportManager.MAX_READ_COUNT, -100869, "", this);
                this.piB = true;
            }
        }
    }
}
