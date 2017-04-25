package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.protocal.c.akm;
import com.tencent.mm.protocal.c.akn;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;
import org.json.JSONObject;

public final class b extends k {
    private final com.tencent.mm.v.b cif;
    private e cii;
    private String hKA;
    public String hKp = "";
    public int hKq = -1;
    private String hKr = "";
    public int hKs = -1;
    public String hKt = "";
    public int hKu = 1;
    public RealnameGuideHelper hKv;
    private String hKw;
    private String hKx;
    private String hKy;
    private String hKz;

    public b(int i, String str, String str2) {
        a aVar = new a();
        aVar.czn = new akm();
        aVar.czo = new akn();
        aVar.uri = "/cgi-bin/mmpay-bin/offlinepayconfirm";
        aVar.czm = 609;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        akm com_tencent_mm_protocal_c_akm = (akm) this.cif.czk.czs;
        com_tencent_mm_protocal_c_akm.mLu = i;
        com_tencent_mm_protocal_c_akm.gID = str;
        com_tencent_mm_protocal_c_akm.kQj = str2;
        com_tencent_mm_protocal_c_akm.mkb = f.bfP();
        this.hKu = i;
    }

    public final int getType() {
        return 609;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void c(int i, int i2, String str, p pVar) {
        if (i != 0) {
            v.e("MicroMsg.NetSceneOfflinePayConfirm", "Cmd : 609" + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        akn com_tencent_mm_protocal_c_akn = (akn) ((com.tencent.mm.v.b) pVar).czl.czs;
        if (i == 0 && i2 == 0) {
            try {
                if (com_tencent_mm_protocal_c_akn.mzD != null) {
                    JSONObject jSONObject = new JSONObject(com_tencent_mm_protocal_c_akn.mzD);
                    this.hKp = jSONObject.optString("transaction_id");
                    this.hKq = jSONObject.optInt("retcode");
                    this.hKr = jSONObject.optString("retmsg");
                    this.hKs = jSONObject.optInt("wx_error_type");
                    this.hKt = jSONObject.optString("wx_error_msg");
                    v.d("MicroMsg.NetSceneOfflinePayConfirm", "onGYNetEnd %s", new Object[]{jSONObject.toString()});
                    if (jSONObject.has("real_name_info")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                        this.hKw = optJSONObject.optString("guide_flag");
                        this.hKx = optJSONObject.optString("guide_wording");
                        this.hKy = optJSONObject.optString("left_button_wording");
                        this.hKz = optJSONObject.optString("right_button_wording");
                        this.hKA = optJSONObject.optString("upload_credit_url");
                        if ("1".equals(this.hKw) || "2".equals(this.hKw)) {
                            this.hKv = new RealnameGuideHelper();
                            this.hKv.a(this.hKw, this.hKx, this.hKy, this.hKz, this.hKA, 0);
                        }
                    }
                }
            } catch (Throwable e) {
                v.a("MicroMsg.NetSceneOfflinePayConfirm", e, "", new Object[0]);
                i = 1000;
                i2 = 2;
                str = aa.getContext().getString(2131236155);
            }
        }
        if (this.cii != null) {
            this.cii.a(i, i2, str, this);
        }
    }
}
