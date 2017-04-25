package com.tencent.mm.pluginsdk.wallet;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.a.jt;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;
import org.json.JSONObject;

public final class d {
    public String appId;
    public String bkj;
    public String bkk;
    public String bkl;
    public String bkm;
    public String bkn;
    public String bko;
    public String bkp;
    public int bkq;
    public int bkr;
    public int bks;
    public String extInfo;
    public int lVM = 0;
    public String url;

    public d(Map<String, Object> map) {
        this.appId = (String) map.get("appId");
        this.bkj = (String) map.get("partnerId");
        this.bkk = (String) map.get("signType");
        this.bkl = (String) map.get("nonceStr");
        this.bkm = (String) map.get("timeStamp");
        this.bkn = (String) map.get("package");
        this.bko = (String) map.get("paySign");
        this.url = (String) map.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        this.bkp = (String) map.get("src_username");
        this.bkq = be.getInt((String) map.get("scene"), 0);
        this.bks = be.getInt((String) map.get("pay_channel"), 0);
        this.extInfo = be.ma((String) map.get("ext_info"));
    }

    public d(JSONObject jSONObject) {
        this.appId = jSONObject.optString("appId");
        this.bkj = jSONObject.optString("partnerId");
        this.bkk = jSONObject.optString("signType");
        this.bkl = jSONObject.optString("nonceStr");
        this.bkm = jSONObject.optString("timeStamp");
        this.bkn = jSONObject.optString("package");
        this.bko = jSONObject.optString("paySign");
        this.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        this.bkp = jSONObject.optString("src_username");
        this.bkq = jSONObject.optInt("scene", 0);
        this.bks = jSONObject.optInt("pay_channel", 0);
        this.extInfo = jSONObject.optString("ext_info", SQLiteDatabase.KeyEmpty);
    }

    public d(jt jtVar) {
        if (jtVar != null && jtVar.bki != null) {
            this.appId = jtVar.bki.appId;
            this.bkj = jtVar.bki.bkj;
            this.bkk = jtVar.bki.bkk;
            this.bkl = jtVar.bki.bkl;
            this.bkm = jtVar.bki.bkm;
            this.bkn = jtVar.bki.bkn;
            this.bko = jtVar.bki.bko;
            this.url = jtVar.bki.url;
            this.bkp = jtVar.bki.bkp;
            this.bkq = jtVar.bki.bkq;
            this.bks = jtVar.bki.bks;
            this.bkr = jtVar.bki.bkr;
        }
    }
}
