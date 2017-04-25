package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class h extends j {
    private static int pjc = 0;
    private String hKA;
    public RealnameGuideHelper hKv;
    private String hKw;
    private String hKx;
    private String hKy;
    private String hKz;
    protected int hMR;
    protected Map<String, String> piY = new HashMap();
    public int piZ = 0;
    public int pja = -1;
    public int pjb = -1;
    private boolean pjd = false;
    public int pje = 0;
    public String pjf = null;
    public JSONObject pjg = null;

    public final void a(String str, String str2, int i, int i2, String str3, String str4) {
        pjc++;
        this.piY.put("req_key", str);
        this.piY.put("transaction_id", str2);
        this.piY.put("pay_scene", String.valueOf(i));
        this.piY.put("bank_type", str3);
        this.piY.put("channel", String.valueOf(i2));
        this.piY.put("bind_serial", str4);
    }

    public final Map<String, String> bLs() {
        return this.piY;
    }

    public void a(int i, String str, JSONObject jSONObject) {
        if (!this.pjd) {
            this.pje = i;
            this.pjf = str;
            this.pjg = jSONObject;
            this.pjd = true;
            if (jSONObject != null) {
                v.i("MicroMsg.NetSceneTenpayDelayQueryBase", "hy: need query order to retry");
                this.piZ = jSONObject.optInt("query_order_flag", 0);
                this.pja = jSONObject.optInt("query_order_time", 5) * BaseReportManager.MAX_READ_COUNT;
                this.pjb = jSONObject.optInt("query_order_count", 3);
            }
        }
        if (jSONObject != null && jSONObject.has("real_name_info")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
            this.hKw = optJSONObject.optString("guide_flag");
            this.hKx = optJSONObject.optString("guide_wording");
            this.hKy = optJSONObject.optString("left_button_wording");
            this.hKz = optJSONObject.optString("right_button_wording");
            this.hKA = optJSONObject.optString("upload_credit_url");
            if ("1".equals(this.hKw) || "2".equals(this.hKw)) {
                this.hKv = new RealnameGuideHelper();
                this.hKv.a(this.hKw, this.hKx, this.hKy, this.hKz, this.hKA, this.hMR);
            }
        }
        super.a(i, str, jSONObject);
    }

    public final boolean bLt() {
        return this.piZ == 1;
    }

    public final boolean yz(int i) {
        if (this.pjb <= 0 || this.pjb <= i) {
            return true;
        }
        return false;
    }
}
