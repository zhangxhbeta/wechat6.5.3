package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class d extends g {
    public String brU;
    public String brV;
    public String brW;
    public String brX;
    public String brY;
    public Orders ith = null;
    private String kIr = null;

    public d(PayInfo payInfo, int i) {
        this.kIr = payInfo.fTG;
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("support_cardtag3", "1");
        hashMap.put("req_key", payInfo.fTG);
        hashMap.put("bind_query_scene", String.valueOf(i));
        hashMap.put("is_merge", "1");
        j.g gVar = a.lxX;
        hashMap.put("is_root", "0");
        if (gVar == null || !gVar.ann()) {
            hashMap.put("is_device_open_touch", "0");
            v.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is false");
        } else {
            hashMap.put("is_device_open_touch", "1");
            Map anB = gVar.anB();
            if (anB != null) {
                hashMap.putAll(anB);
            }
            v.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is true");
        }
        a(payInfo, hashMap, hashMap2);
        u(hashMap);
        aa(hashMap2);
    }

    public final int aed() {
        return 112;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            this.ith = Orders.z(jSONObject);
            if (this.ith != null) {
                this.ith.fTG = this.kIr;
            }
            if (!be.kS(jSONObject.optString("query_order_time"))) {
                v.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "hy: has query order time. set to subcore");
                k.bga().De(jSONObject.optString("query_order_time"));
            }
            k.bga().kQZ = jSONObject.optString("pay_remind_wording");
            w.D(jSONObject.optJSONObject("bindqueryresp"));
            j.g gVar = a.lxX;
            if (gVar != null) {
                v.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is not null");
                gVar.anv();
            } else {
                v.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is null");
            }
            if (jSONObject.has("real_name_info")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                this.brU = optJSONObject.optString("guide_flag");
                this.brV = optJSONObject.optString("guide_wording");
                this.brW = optJSONObject.optString("left_button_wording");
                this.brX = optJSONObject.optString("right_button_wording");
                this.brY = optJSONObject.optString("upload_credit_url");
            }
        } catch (Exception e) {
            v.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "hy: " + e.toString());
        }
    }

    public int zg() {
        return 1593;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/qrcodeusebindquery";
    }
}
