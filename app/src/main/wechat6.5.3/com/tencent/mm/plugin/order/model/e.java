package com.tencent.mm.plugin.order.model;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends g {
    public List<i> hNK = null;
    public List<d> hNL = null;
    public String hNM;
    public int haG;
    private int hbB;

    public e(int i, String str) {
        Map hashMap = new HashMap();
        hashMap.put("Limit", "10");
        hashMap.put("Offset", String.valueOf(i));
        hashMap.put("Extbuf", str);
        u(hashMap);
    }

    public final int aed() {
        return 105;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        int i2 = 0;
        v.d("MicroMsg.NetScenePatchQueryUserRoll", "errCode " + i + " errMsg: " + str);
        this.hNK = new LinkedList();
        try {
            this.haG = jSONObject.getInt("TotalNum");
            this.hbB = jSONObject.getInt("RecNum");
            this.hNM = jSONObject.optString("Extbuf");
            JSONArray jSONArray = jSONObject.getJSONArray("UserRollList");
            if (jSONArray != null) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    i iVar = new i();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    iVar.hNX = jSONObject2.optInt("PayType");
                    iVar.hNP = jSONObject2.optString("Transid");
                    iVar.hNQ = jSONObject2.optDouble("TotalFee");
                    iVar.hNR = jSONObject2.optString("GoodsName");
                    iVar.hNS = jSONObject2.optInt("CreateTime");
                    iVar.hNU = jSONObject2.optInt("ModifyTime");
                    iVar.hNV = jSONObject2.optString("FeeType");
                    iVar.hOb = jSONObject2.optString("AppThumbUrl");
                    iVar.hNT = jSONObject2.optString("TradeStateName");
                    iVar.hOg = jSONObject2.optString("StatusColor");
                    iVar.hOh = jSONObject2.optString("FeeColor");
                    iVar.hOi = jSONObject2.optDouble("ActualPayFee");
                    iVar.hOj = jSONObject2.optString("BillId");
                    this.hNK.add(iVar);
                }
            }
            this.hNL = new LinkedList();
            JSONArray optJSONArray = jSONObject.optJSONArray("month_info");
            if (optJSONArray != null) {
                while (i2 < optJSONArray.length()) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                    d dVar = new d();
                    dVar.year = jSONObject3.optInt("year");
                    dVar.month = jSONObject3.optInt("month");
                    dVar.hNJ = jSONObject3.optString("feetext");
                    this.hNL.add(dVar);
                    i2++;
                }
            }
        } catch (JSONException e) {
            v.e("MicroMsg.NetScenePatchQueryUserRoll", "Parse Json exp:" + e.getLocalizedMessage());
        }
    }
}
