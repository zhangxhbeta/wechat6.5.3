package com.tencent.mm.plugin.wallet_core.a.a;

import com.tencent.mm.a.o;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends g {
    private Map<String, String> hdk = new HashMap();
    private Map<String, String> hdl = new HashMap();
    public String kIr = null;
    public String token = null;

    public a(Authen authen) {
        a(authen.imN, this.hdk, this.hdl);
        this.hdk.put("flag", authen.bkU);
        this.hdk.put("bank_type", authen.hMt);
        if (!be.kS(authen.kMR)) {
            this.hdk.put("passwd", authen.kMR);
        }
        if (!be.kS(authen.token)) {
            this.hdk.put("token", authen.token);
        }
        if (!be.kS(authen.kGo)) {
            ak.yW();
            o oVar = new o(be.a((Integer) c.vf().get(9, null), 0));
            this.hdk.put("import_code", authen.kGo);
            this.hdk.put("qqid", oVar.toString());
            if (authen.kMU > 0) {
                this.hdk.put("cre_type", authen.kMU);
            }
            this.hdk.put("bind_serailno", authen.hMu);
        }
        if (!be.kS(authen.kNa)) {
            this.hdk.put("first_name", authen.kNa);
            this.hdk.put("last_name", authen.kNb);
            this.hdk.put("country", authen.cJg);
            this.hdk.put("area", authen.bCk);
            this.hdk.put("city", authen.bCl);
            this.hdk.put("address", authen.cJf);
            this.hdk.put("phone_number", authen.kNc);
            this.hdk.put("zip_code", authen.dxo);
            this.hdk.put("email", authen.bCc);
            this.hdk.put("language", u.bsY());
        }
        if (!be.kS(authen.kMS)) {
            this.hdk.put("true_name", authen.kMS);
        }
        if (!be.kS(authen.kMT)) {
            this.hdk.put("identify_card", authen.kMT);
        }
        if (authen.kMU > 0) {
            this.hdk.put("cre_type", authen.kMU);
        }
        if (!be.kS(authen.kLp)) {
            this.hdk.put("mobile_no", authen.kLp);
        }
        this.hdk.put("bank_card_id", authen.kMV);
        if (!be.kS(authen.kMW)) {
            this.hdk.put("cvv2", authen.kMW);
        }
        if (!be.kS(authen.kMX)) {
            this.hdk.put("valid_thru", authen.kMX);
        }
        u(this.hdk);
        aa(this.hdl);
    }

    public final boolean axX() {
        super.axX();
        this.hdk.put("is_repeat_send", "1");
        u(this.hdk);
        return true;
    }

    public final int aed() {
        return 12;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.kIr = jSONObject.optString("req_key");
            this.token = jSONObject.optString("token");
        }
    }

    public final String axY() {
        return this.token;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindauthen";
    }

    public final int zg() {
        return 471;
    }
}
