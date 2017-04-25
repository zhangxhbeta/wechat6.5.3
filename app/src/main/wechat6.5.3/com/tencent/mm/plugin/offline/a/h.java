package com.tencent.mm.plugin.offline.a;

import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.offline.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.t;
import com.tencent.mm.wallet_core.b.a;
import com.tencent.mm.wallet_core.e.a.g;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h extends g {
    public static String hKJ = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
    public String hKE = "";
    public String hKF = "";
    public String hKG = "";
    public String hKH = "";
    public String hKI = "";
    public String hKK = "";
    public int hKL = 0;
    public String hKM = "";
    public String hKN = "";
    public String hKO = "";
    public int hKP = 20000;
    public String token = "";

    public h(Bankcard bankcard, String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("device_id", p.rK());
        hashMap.put("weixin_ver", "0x" + Integer.toHexString(d.lWh));
        hashMap.put("bind_serialno", bankcard.field_bindSerial);
        hashMap.put("bank_type", bankcard.field_bankcardType);
        hashMap.put("card_tail", bankcard.field_bankcardTail);
        hashMap.put("open_limitfee", String.valueOf(i));
        this.hKP = i;
        String Kg = z.Kg(z.Kg(e.getUsername()) + z.Kg(p.rK()));
        hashMap.put("user_id", Kg);
        hashMap.put("crt_csr", a.bKZ().getCertApplyCSR(Kg));
        hashMap.put("type", hKJ);
        hashMap.put("version_number", hKJ);
        u(hashMap);
    }

    public final int aed() {
        return 46;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hKF = jSONObject.optString("crt_crt");
            this.hKE = jSONObject.optString("cn");
            this.token = jSONObject.optString("token");
            this.hKG = jSONObject.optString("valid_end");
            this.hKH = jSONObject.optString("encrypt_str");
            this.hKI = jSONObject.optString("deviceid");
            if (a.bKZ().importCert(this.hKE, this.hKF)) {
                v.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt success");
            } else {
                v.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt fail");
            }
            this.hKK = jSONObject.optString("token_v2");
            this.hKL = jSONObject.optInt("algorithm_type");
            this.hKM = jSONObject.optString("card_list");
            this.hKN = jSONObject.optString("key_list");
            this.hKO = jSONObject.optString("token_pin");
            String optString = jSONObject.optString("notice_url");
            String optString2 = jSONObject.optString("auth_codes");
            int optInt = jSONObject.optInt("update_interval");
            String optString3 = jSONObject.optString("code_ver");
            j.aEM();
            j.T(196617, this.hKE);
            j.aEM();
            j.T(196626, this.hKG);
            j.aEM();
            j.T(196627, this.hKH);
            j.aEM();
            j.T(196628, this.hKI);
            j.aEM();
            j.T(196630, "1");
            j.aEM();
            j.T(196632, (System.currentTimeMillis() / 1000));
            com.tencent.mm.plugin.offline.b.a.h(this.token, this.hKK, this.hKM, this.hKN);
            com.tencent.mm.plugin.offline.b.a.nT(this.hKL);
            j.aEM();
            j.T(196647, this.hKO);
            com.tencent.mm.plugin.offline.b.a.xu(optString);
            j.aEM();
            optString = j.nO(196617);
            a.bKZ();
            a.clearToken(optString);
            a.bKZ();
            v.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "offlinecreate isOk %s cn: %s", new Object[]{Boolean.valueOf(a.setTokens(this.hKE, optString2)), this.hKE});
            if (a.setTokens(this.hKE, optString2)) {
                v.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens success!");
            } else {
                v.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens failed!");
                StringBuilder stringBuilder = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
                a.bKZ();
                v.e("MicroMsg.NetSceneTenpayWxOfflineCreate", stringBuilder.append(a.getLastError()).toString());
            }
            j.aEM();
            j.T(196649, String.valueOf(optInt));
            ak.yW();
            c.vf().a(t.a.nom, p.rJ());
            ak.yW();
            c.vf().a(t.a.non, optString3);
        }
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        super.a(i, i2, i3, str, pVar, bArr);
        if (!(i2 == 0 && i3 == 0)) {
            j.aEM();
            j.T(196630, "0");
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(135);
        iDKey.SetValue(1);
        iDKey.SetKey(11);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(135);
        iDKey2.SetValue(1);
        if (i3 == 0 && i3 == 0) {
            iDKey2.SetKey(9);
        } else {
            iDKey2.SetKey(10);
        }
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
        com.tencent.mm.plugin.report.service.g.d(arrayList, true);
    }

    public final void a(com.tencent.mm.wallet_core.b.c cVar) {
        a.bKZ().bLa();
    }

    public final int zg() {
        return 565;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinecreate";
    }
}
