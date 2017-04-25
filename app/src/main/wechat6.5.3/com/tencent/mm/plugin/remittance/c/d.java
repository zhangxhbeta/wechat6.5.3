package com.tencent.mm.plugin.remittance.c;

import android.text.TextUtils;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends g {
    public String bfr = null;
    private int hMR;
    public a hcp;
    public int irl = 0;
    public String irm;
    public String irn;
    public double iro;
    public double irp;
    public String irq;
    public boolean irr;
    public double irs;
    public String irt;
    public double iru;
    public double irv;
    public String irw;
    public double irx = 0.0d;

    public d(double d, String str, String str2, int i, int i2, String str3, String str4) {
        this.irx = d;
        this.hMR = i;
        Map hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        hashMap.put("transfer_scene", String.valueOf(i2));
        hashMap.put("fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str);
        hashMap.put("receiver_name", str2);
        if (!be.kS(str3)) {
            try {
                hashMap.put("desc", p.encode(str3, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                v.e("Micromsg.NetSceneTenpayRemittanceGen", e.getMessage(), new Object[]{e});
            }
        }
        hashMap.put("transfer_qrcode_id", str4);
        if (i2 == 0 || i2 == 2) {
            ak.yW();
            long longValue = ((Long) c.vf().get(147457, null)).longValue();
            int i3 = 0;
            if ((16 & longValue) != 0) {
                i3 = 2;
            } else if ((longValue & 32) != 0) {
                i3 = 1;
            }
            hashMap.put("delay_confirm_flag", String.valueOf(i3));
            v.d("Micromsg.NetSceneTenpayRemittanceGen", "delay flag: %d", new Object[]{Integer.valueOf(i3)});
        }
        u(hashMap);
    }

    public final int zg() {
        if (this.hMR == 32 || this.hMR == 33) {
            return 1582;
        }
        return 1544;
    }

    public final int aed() {
        return 0;
    }

    public final String getUri() {
        if (this.hMR == 32 || this.hMR == 33) {
            return "/cgi-bin/mmpay-bin/f2fplaceorder";
        }
        return "/cgi-bin/mmpay-bin/transferplaceorder";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        boolean z = true;
        v.d("Micromsg.NetSceneTenpayRemittanceGen", "errCode " + i + " errMsg: " + str);
        if (i == 0 || i == 2) {
            if (jSONObject.has("used_fee")) {
                this.irv = jSONObject.optDouble("used_fee");
            } else {
                v.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
            }
            this.bfr = jSONObject.optString("req_key");
            this.irl = jSONObject.optInt("tansfering_num", 0);
            this.irm = jSONObject.optString("transfer_interrupt_desc");
            this.irn = jSONObject.optString("appmsgcontent");
            this.irq = jSONObject.optString("transfer_interrupt_charge_desc");
            if (jSONObject.optInt("is_show_charge") != 1) {
                z = false;
            }
            this.irr = z;
            this.irw = jSONObject.optString("receiver_true_name");
            if (be.kS(this.irw)) {
                v.e("Micromsg.NetSceneTenpayRemittanceGen", "receiver_true_name is null");
            }
            if (jSONObject.has("remain_fee")) {
                this.irs = jSONObject.optDouble("remain_fee");
            } else {
                v.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
            }
            if (jSONObject.has("exceed_fee")) {
                this.iru = jSONObject.optDouble("exceed_fee");
            } else {
                v.e("Micromsg.NetSceneTenpayRemittanceGen", "exceed_fee is null");
            }
            if (jSONObject.has("charge_fee")) {
                this.iro = jSONObject.optDouble("charge_fee");
            } else {
                v.e("Micromsg.NetSceneTenpayRemittanceGen", "charge_fee is null");
            }
            if (jSONObject.has("free_limit")) {
                this.irp = jSONObject.optDouble("free_limit");
            } else {
                v.e("Micromsg.NetSceneTenpayRemittanceGen", "free_limit is null");
            }
            if (jSONObject.has("showmessage")) {
                v.i("Micromsg.NetSceneTenpayRemittanceGen", "has alert item");
                a aVar = new a();
                JSONObject optJSONObject = jSONObject.optJSONObject("showmessage");
                aVar.hcm = optJSONObject.optString("left_button_wording");
                aVar.hcn = optJSONObject.optString("right_button_wording");
                aVar.kMP = optJSONObject.optString("right_button_url");
                this.hcp = aVar;
                this.hcp.bhe = str;
            }
            if (TextUtils.isEmpty(this.irn)) {
                v.e("Micromsg.NetSceneTenpayRemittanceGen", "appmsgcontent is null");
            }
        }
    }

    public final boolean aKe() {
        return true;
    }
}
