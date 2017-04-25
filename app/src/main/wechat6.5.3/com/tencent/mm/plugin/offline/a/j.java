package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.offline.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j extends e {
    public String hKG = "";
    public String hKH = "";
    public String hKI = "";
    public String hKK = "";
    public int hKL = 0;
    public String hKM = "";
    public String hKN = "";
    public String hKO = "";
    private String hKQ;
    private int hKR;
    public String hKS;
    public String token = "";

    public j(String str, int i) {
        int i2;
        CharSequence genUserSig;
        Object axY = a.axY();
        com.tencent.mm.plugin.offline.j.aEM();
        String nO = com.tencent.mm.plugin.offline.j.nO(196628);
        if (TextUtils.isEmpty(nO)) {
            nO = p.rK();
        }
        if (TextUtils.isEmpty(axY)) {
            nO = nO + "&" + str + "&" + (((int) (Math.random() * 1000000.0d)) + 1000000);
        } else {
            nO = nO + "&" + str + "&" + (((int) (Math.random() * 1000000.0d)) + 1000000) + "&" + axY;
        }
        Map hashMap = new HashMap();
        hashMap.put("token_src", nO);
        String str2 = "";
        com.tencent.mm.plugin.offline.j.aEM();
        String nO2 = com.tencent.mm.plugin.offline.j.nO(196617);
        switch (i) {
            case 0:
                i2 = 12;
                break;
            case 1:
                i2 = 13;
                break;
            case 2:
                i2 = 14;
                break;
            case 3:
                i2 = 15;
                break;
            case 4:
                i2 = 16;
                break;
            case 5:
                i2 = 17;
                break;
            case 6:
                i2 = 18;
                break;
            case 7:
                i2 = 19;
                break;
            case 8:
                i2 = 20;
                break;
            default:
                i2 = 12;
                break;
        }
        g.iuh.a(135, (long) i2, 1, true);
        com.tencent.mm.wallet_core.b.a.bKZ();
        if (com.tencent.mm.wallet_core.b.a.isCertExist(nO2)) {
            com.tencent.mm.wallet_core.b.a.bKZ();
            genUserSig = com.tencent.mm.wallet_core.b.a.genUserSig(nO2, nO);
            v.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().isCertExist(cn) true");
        } else {
            StringBuilder stringBuilder = new StringBuilder("NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().getLastError():");
            com.tencent.mm.wallet_core.b.a.bKZ();
            v.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", stringBuilder.append(com.tencent.mm.wallet_core.b.a.getLastError()).toString());
            g.iuh.a(135, 6, 1, true);
            ak.yW();
            nO = (String) c.vf().get(t.a.nom, "");
            if (nO == null || !nO.equals(p.rJ())) {
                v.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is diff between create and getToken");
                g.iuh.a(135, 5, 1, true);
            } else {
                v.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is same between create and getToken");
            }
            v.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().isCertExist return false! cn: " + nO2);
            Object obj = str2;
        }
        if (TextUtils.isEmpty(genUserSig)) {
            v.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken sign is empty!");
            g.iuh.a(135, 4, 1, true);
        } else {
            v.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "sign is valid");
        }
        hashMap.put("sign", genUserSig);
        hashMap.put("cert_no", nO2);
        hashMap.put("type", h.hKJ);
        hashMap.put("version_number", h.hKJ);
        if (a.aFw() == 2) {
            hashMap.put("last_token", a.aFx());
        } else {
            hashMap.put("last_token", a.axY());
        }
        hashMap.put("scene", String.valueOf(i));
        u(hashMap);
    }

    public final int aed() {
        return 52;
    }

    public final void a(int i, JSONObject jSONObject) {
        if (i == 0) {
            this.token = jSONObject.optString("token");
            this.hKG = jSONObject.optString("valid_end");
            this.hKH = jSONObject.optString("encrypt_str");
            this.hKI = jSONObject.optString("deviceid");
            this.hKK = jSONObject.optString("token_v2");
            this.hKL = jSONObject.optInt("algorithm_type");
            this.hKM = jSONObject.optString("card_list");
            this.hKN = jSONObject.optString("key_list");
            this.hKO = jSONObject.optString("token_pin");
            this.hKQ = jSONObject.optString("auth_codes");
            this.hKR = jSONObject.optInt("update_interval");
            this.hKS = jSONObject.optString("code_ver");
        }
    }

    public final void aER() {
        v.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "do save token");
        com.tencent.mm.plugin.offline.j.aEM();
        com.tencent.mm.plugin.offline.j.T(196626, this.hKG);
        com.tencent.mm.plugin.offline.j.aEM();
        com.tencent.mm.plugin.offline.j.T(196627, this.hKH);
        com.tencent.mm.plugin.offline.j.aEM();
        com.tencent.mm.plugin.offline.j.T(196628, this.hKI);
        com.tencent.mm.plugin.offline.j.aEM();
        com.tencent.mm.plugin.offline.j.T(196632, (System.currentTimeMillis() / 1000));
        a.h(this.token, this.hKK, this.hKM, this.hKN);
        a.nT(this.hKL);
        com.tencent.mm.plugin.offline.j.aEM();
        com.tencent.mm.plugin.offline.j.T(196647, this.hKO);
        com.tencent.mm.plugin.offline.j.aEM();
        String nO = com.tencent.mm.plugin.offline.j.nO(196617);
        com.tencent.mm.wallet_core.b.a.bKZ();
        com.tencent.mm.wallet_core.b.a.clearToken(nO);
        com.tencent.mm.wallet_core.b.a.bKZ();
        if (com.tencent.mm.wallet_core.b.a.setTokens(nO, this.hKQ)) {
            v.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens success!");
        } else {
            v.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens failed!");
            StringBuilder stringBuilder = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
            com.tencent.mm.wallet_core.b.a.bKZ();
            v.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", stringBuilder.append(com.tencent.mm.wallet_core.b.a.getLastError()).toString());
        }
        com.tencent.mm.plugin.offline.j.aEM();
        com.tencent.mm.plugin.offline.j.T(196649, this.hKR);
        ak.yW();
        c.vf().a(t.a.non, this.hKS);
    }

    public final int zg() {
        return 571;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinegettoken";
    }
}
