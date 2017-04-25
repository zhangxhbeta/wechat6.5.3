package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class b extends h {
    private Map<String, String> hdk;
    private Map<String, String> hdl;
    public boolean hdm;
    public boolean hdn;
    public Orders hdo;
    public Authen hdp;
    public String kIp;
    public String kIq;
    public String token;

    public b(Authen authen, Orders orders) {
        this(authen, orders, false);
    }

    public b(Authen authen, Orders orders, boolean z) {
        this(authen, orders, z, (byte) 0);
    }

    private b(Authen authen, Orders orders, boolean z, byte b) {
        String str = null;
        this.hdm = false;
        this.hdn = false;
        this.hdo = null;
        this.token = null;
        this.kIp = null;
        this.kIq = null;
        this.hdp = authen;
        this.hdo = orders;
        List list = orders.kPm;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).eWA;
        }
        a(orders.fTG, str, authen.imN.bkq, authen.imN.bkh, authen.hMt, authen.hMu);
        if (authen.imN == null) {
            throw new IllegalArgumentException("authen.payInfo == null");
        }
        v.i("MicroMsg.NetSceneTenpayAuthen", "pay channel :" + authen.imN.bkh);
        this.hdk = new HashMap();
        this.hdl = new HashMap();
        boolean z2 = (z || be.kS(this.hdp.kMR)) ? false : true;
        v.i("MicroMsg.NetSceneTenpayAuthen", "hy: has pwd: %b", new Object[]{Boolean.valueOf(z2)});
        a(authen.imN, this.hdk, this.hdl, z2);
        if (z) {
            this.hdk.put("brief_reg", "1");
        } else {
            this.hdk.put("passwd", authen.kMR);
        }
        this.hdk.put("default_favorcomposedid", authen.kNd);
        this.hdk.put("favorcomposedid", authen.kNe);
        this.hdk.put("arrive_type", authen.kMZ);
        this.hdk.put("sms_flag", authen.kNf);
        this.hdk.put("ban_sms_bind_serial", authen.kNg);
        this.hdk.put("ban_sms_bank_type", authen.kNh);
        this.hdk.put("busi_sms_flag", authen.kNi);
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
        Map anD = a.lxX.anD();
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

    public int aed() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        v.i("MicroMsg.NetSceneTenpayAuthen", " errCode: " + i + " errMsg :" + str);
        v.d("MicroMsg.NetSceneTenpayAuthen", "banlance_mobile: %s", new Object[]{this.kIp});
        this.hdm = "1".equals(jSONObject.optString("is_free_sms"));
        this.token = jSONObject.optString("token");
        this.kIp = jSONObject.optString("balance_mobile");
        this.kIq = jSONObject.optString("balance_help_url");
        String optString = jSONObject.optString("bind_serial");
        if (!be.kS(optString)) {
            v.i("MicroMsg.NetSceneTenpayAuthen", "Pay Success! saving bind_serial:" + optString);
        }
        if ("1".equals(jSONObject.optString("pay_flag"))) {
            this.hdn = true;
            this.hdo = Orders.a(jSONObject, this.hdo);
        } else {
            this.hdn = false;
        }
        v.i("MicroMsg.NetSceneTenpayAuthen", "pay_scene:" + this.hdp.imN.bkq);
        if (i == 0 && this.hdp.imN.bkq == 39) {
            v.i("MicroMsg.NetSceneTenpayAuthen", "it's the sns scene, parse the sns pay data");
            com.tencent.mm.plugin.wallet_core.d.b.F(jSONObject);
            return;
        }
        v.i("MicroMsg.NetSceneTenpayAuthen", "it's not the sns scene or occurs error,  errCode:" + i);
    }

    public final String axY() {
        return this.token;
    }

    public String getUri() {
        if (this.hdp.imN.bkq == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveauthen";
        }
        if (this.hdp.imN.bkq == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchauthen";
        }
        return "/cgi-bin/mmpay-bin/tenpay/authen";
    }

    public int zg() {
        if (this.hdp.imN.bkq == 11) {
            return 1610;
        }
        if (this.hdp.imN.bkq == 21) {
            return 1605;
        }
        return 461;
    }

    public final boolean beS() {
        return this.hdp.imN.lVE == 1;
    }
}
