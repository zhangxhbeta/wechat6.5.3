package com.tencent.mm.plugin.luckymoney.sns.b;

import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends j {
    private Map<String, String> hdk;
    private Map<String, String> hdl;
    private boolean hdm = false;
    public boolean hdn = false;
    public Orders hdo = null;
    private Authen hdp;
    public int hdq = 0;
    private String token = null;

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/snsfreepasswdauthen";
    }

    public final int zg() {
        return 1625;
    }

    public a(Authen authen) {
        this.hdp = authen;
        this.hdo = null;
        if (authen.imN == null) {
            throw new IllegalArgumentException("authen.payInfo == null");
        }
        this.hdk = new HashMap();
        this.hdl = new HashMap();
        a(authen.imN, this.hdk, this.hdl);
        this.hdk.put("passwd", authen.kMR);
        this.hdk.put("pay_way", new StringBuilder("1").toString());
        this.hdk.put("hb_flag", new StringBuilder("1").toString());
        this.hdk.put("default_favorcomposedid", authen.kNd);
        this.hdk.put("favorcomposedid", authen.kNe);
        this.hdk.put("arrive_type", authen.kMZ);
        switch (authen.bkU) {
            case 1:
                this.hdk.put("flag", "1");
                this.hdk.put("bank_type", authen.hMt);
                this.hdk.put("true_name", authen.kMS);
                this.hdk.put("identify_card", authen.kMT);
                if (authen.kMU > 0) {
                    this.hdk.put("cre_type", authen.kMU);
                }
                this.hdk.put("mobile_no", authen.kLp);
                this.hdk.put("bank_card_id", authen.kMV);
                if (!be.kS(authen.kMW)) {
                    this.hdk.put("cvv2", authen.kMW);
                }
                if (!be.kS(authen.kMX)) {
                    this.hdk.put("valid_thru", authen.kMX);
                    break;
                }
                break;
            case 2:
                this.hdk.put("flag", "2");
                this.hdk.put("bank_type", authen.hMt);
                this.hdk.put("h_bind_serial", authen.hMu);
                this.hdk.put("card_tail", authen.kMY);
                if (!be.kS(authen.kMS)) {
                    this.hdk.put("true_name", authen.kMS);
                }
                if (!be.kS(authen.kMT)) {
                    this.hdk.put("identify_card", authen.kMT);
                }
                this.hdk.put("cre_type", authen.kMU);
                this.hdk.put("mobile_no", authen.kLp);
                this.hdk.put("bank_card_id", authen.kMV);
                if (!be.kS(authen.kMW)) {
                    this.hdk.put("cvv2", authen.kMW);
                }
                if (!be.kS(authen.kMX)) {
                    this.hdk.put("valid_thru", authen.kMX);
                    break;
                }
                break;
            case 3:
                if (authen.kMQ == 1) {
                    this.hdk.put("reset_flag", "1");
                    if (!be.kS(authen.kLp)) {
                        this.hdk.put("mobile_no", authen.kLp);
                    }
                    if (!be.kS(authen.kMW)) {
                        this.hdk.put("cvv2", authen.kMW);
                    }
                    if (!be.kS(authen.kMX)) {
                        this.hdk.put("valid_thru", authen.kMX);
                    }
                }
                this.hdk.put("flag", "3");
                this.hdk.put("bank_type", authen.hMt);
                this.hdk.put("bind_serial", authen.hMu);
                break;
            case 4:
                this.hdk.put("flag", "4");
                this.hdk.put("bank_type", authen.hMt);
                this.hdk.put("first_name", authen.kNa);
                this.hdk.put("last_name", authen.kNb);
                this.hdk.put("country", authen.cJg);
                this.hdk.put("area", authen.bCk);
                this.hdk.put("city", authen.bCl);
                this.hdk.put("address", authen.cJf);
                this.hdk.put("phone_number", authen.kNc);
                this.hdk.put("zip_code", authen.dxo);
                this.hdk.put("email", authen.bCc);
                this.hdk.put("bank_card_id", authen.kMV);
                if (!be.kS(authen.kMW)) {
                    this.hdk.put("cvv2", authen.kMW);
                }
                if (!be.kS(authen.kMX)) {
                    this.hdk.put("valid_thru", authen.kMX);
                    break;
                }
                break;
            case 5:
                this.hdk.put("flag", "5");
                this.hdk.put("bank_type", authen.hMt);
                this.hdk.put("first_name", authen.kNa);
                this.hdk.put("last_name", authen.kNb);
                this.hdk.put("country", authen.cJg);
                this.hdk.put("area", authen.bCk);
                this.hdk.put("city", authen.bCl);
                this.hdk.put("address", authen.cJf);
                this.hdk.put("phone_number", authen.kNc);
                this.hdk.put("zip_code", authen.dxo);
                this.hdk.put("email", authen.bCc);
                this.hdk.put("bank_card_id", authen.kMV);
                if (!be.kS(authen.kMW)) {
                    this.hdk.put("cvv2", authen.kMW);
                }
                if (!be.kS(authen.kMX)) {
                    this.hdk.put("valid_thru", authen.kMX);
                }
                this.hdk.put("h_bind_serial", authen.hMu);
                this.hdk.put("card_tail", authen.kMY);
                break;
            case 6:
                if (authen.kMQ == 1) {
                    this.hdk.put("reset_flag", "1");
                    if (!be.kS(authen.kMW)) {
                        this.hdk.put("cvv2", authen.kMW);
                    }
                    if (!be.kS(authen.kMX)) {
                        this.hdk.put("valid_thru", authen.kMX);
                    }
                }
                this.hdk.put("phone_number", authen.kLp);
                this.hdk.put("flag", "6");
                this.hdk.put("bank_type", authen.hMt);
                this.hdk.put("bind_serial", authen.hMu);
                break;
        }
        u(this.hdk);
        Map anD = com.tencent.mm.pluginsdk.j.a.lxX.anD();
        if (anD != null) {
            this.hdl.putAll(anD);
        }
        aa(this.hdl);
    }

    public final boolean axX() {
        super.axX();
        this.hdk.put("is_repeat_send", "1");
        u(this.hdk);
        return true;
    }

    public final int aed() {
        return 1625;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        v.i("MicroMsg.NetSceneSnsFreePasswordAuthen", "SnsFreePasswordAuthen errCode: " + i + " errMsg :" + str);
        if (i != 0) {
            this.hdq = jSONObject.optInt("use_cashier_desk", 0);
            v.e("MicroMsg.NetSceneSnsFreePasswordAuthen", "SnsFreePasswordAuthen onGYNetEnd() failed!");
            return;
        }
        this.hdm = "1".equals(jSONObject.optString("is_free_sms"));
        this.token = jSONObject.optString("token");
        String optString = jSONObject.optString("bind_serial");
        if (!be.kS(optString)) {
            v.i("MicroMsg.NetSceneSnsFreePasswordAuthen", "Pay Success! saving bind_serial:" + optString);
        }
        if ("1".equals(jSONObject.optString("pay_flag"))) {
            this.hdn = true;
            this.hdo = Orders.a(jSONObject, this.hdo);
        } else {
            this.hdn = false;
        }
        v.i("MicroMsg.NetSceneSnsFreePasswordAuthen", "pay_scene:" + this.hdp.imN.bkq);
        if (this.hdp.imN.bkq == 39) {
            v.i("MicroMsg.NetSceneSnsFreePasswordAuthen", "it's the sns scene, parse the sns pay data");
            b.F(jSONObject);
            this.hdq = jSONObject.optInt("use_cashier_desk", 0);
            return;
        }
        v.i("MicroMsg.NetSceneSnsFreePasswordAuthen", "it's not the sns scene");
    }

    public final String axY() {
        return this.token;
    }
}
