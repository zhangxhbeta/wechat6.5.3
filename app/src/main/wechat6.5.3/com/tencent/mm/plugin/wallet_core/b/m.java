package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m extends g {
    public Orders kLv;

    public m(String str) {
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        u(hashMap);
    }

    public m(String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("pay_type", String.valueOf(i));
        u(hashMap);
    }

    public final int aed() {
        return 3;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2;
                this.kLv = new Orders();
                Commodity commodity = new Commodity();
                commodity.hMS = jSONObject.getString("buy_uin");
                commodity.hMT = jSONObject.getString("buy_name");
                commodity.hMU = jSONObject.optString("sale_uin");
                commodity.hMV = jSONObject.optString("sale_name");
                commodity.eWA = jSONObject.getString("trans_id");
                commodity.desc = jSONObject.optString("goods_name");
                commodity.eWz = jSONObject.optDouble("pay_num") / 100.0d;
                commodity.hMZ = jSONObject.getString("trade_state");
                commodity.hNa = jSONObject.getString("trade_state_name");
                commodity.hNe = jSONObject.getString("buy_bank_name");
                commodity.hNl = jSONObject.optString("discount", "");
                commodity.hNc = jSONObject.optInt("modify_timestamp");
                commodity.hNg = jSONObject.optString("fee_type");
                commodity.hNh = jSONObject.optString("appusername");
                commodity.hMJ = jSONObject.optString("app_telephone");
                commodity.kPw = jSONObject.optDouble("original_total_fee", -1.0d) / 100.0d;
                commodity.hNg = jSONObject.optString("fee_type", "");
                int i2 = 1;
                JSONObject optJSONObject = jSONObject.optJSONObject("subscribe_biz_info");
                if (optJSONObject != null) {
                    b bVar = new b();
                    bVar.type = Orders.kPu;
                    bVar.name = optJSONObject.optString("nickname");
                    bVar.hNh = optJSONObject.optString("username");
                    commodity.kPx = bVar.hNh;
                    bVar.hRr = optJSONObject.optString("logo_round_url");
                    bVar.url = optJSONObject.optString("subscribe_biz_url");
                    i2 = optJSONObject.optInt("recommend_level");
                    commodity.kPd = i2;
                    if (!be.kS(bVar.name)) {
                        commodity.kPC.add(bVar);
                    }
                }
                int i3 = i2;
                JSONArray jSONArray = jSONObject.getJSONArray("activity_info");
                int length = jSONArray.length();
                for (i2 = 0; i2 < length; i2++) {
                    jSONObject2 = jSONArray.getJSONObject(i2);
                    b bVar2 = new b();
                    bVar2.type = Orders.kPv;
                    bVar2.hRr = jSONObject2.optString("icon");
                    bVar2.name = jSONObject2.optString("wording");
                    bVar2.url = jSONObject2.optString("url");
                    bVar2.kPJ = jSONObject2.optString("btn_text");
                    bVar2.kPK = jSONObject2.optInt(Columns.TYPE);
                    bVar2.title = jSONObject2.optString("title");
                    bVar2.kPL = jSONObject2.optLong("activity_id");
                    bVar2.kPM = jSONObject2.optInt("activity_type", 0);
                    bVar2.kPN = jSONObject2.optInt("award_id");
                    bVar2.kPO = jSONObject2.optInt("send_record_id");
                    bVar2.kPP = jSONObject2.optInt("user_record_id");
                    commodity.kPC.add(bVar2);
                }
                jSONArray = jSONObject.optJSONArray("discount_array");
                if (jSONArray != null && jSONArray.length() > 0) {
                    length = jSONArray.length();
                    commodity.kPz = new ArrayList();
                    for (i2 = 0; i2 < length; i2++) {
                        jSONObject2 = jSONArray.optJSONObject(i2);
                        DiscountInfo discountInfo = new DiscountInfo();
                        discountInfo.kPH = jSONObject2.optDouble("payment_amount");
                        discountInfo.kPI = jSONObject2.optString("favor_desc");
                        commodity.kPz.add(discountInfo);
                    }
                }
                commodity.kPA = jSONObject.optString("rateinfo");
                commodity.kPB = jSONObject.optString("original_feeinfo");
                this.kLv.kPm = new ArrayList();
                this.kLv.kPm.add(commodity);
                this.kLv.kPf = jSONObject.optString("trade_state_name");
                this.kLv.kPd = i3;
            } catch (Throwable e) {
                v.a("MicroMsg.NetSceneTenpayQueryOrderInfo", e, "", new Object[0]);
            } catch (Throwable e2) {
                v.a("MicroMsg.NetSceneTenpayQueryOrderInfo", e2, "", new Object[0]);
            }
        }
    }
}
