package com.tencent.mm.plugin.wallet_core.b;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k extends g {
    public String eAS;
    public List<ElementQuery> kLr;
    public ElementQuery kLs;
    public String kLt;
    private int kLu;
    public String mTimeStamp;

    public k(String str, String str2, PayInfo payInfo) {
        this(3, str, str2, payInfo, null, -1, -1);
    }

    public k(String str, String str2, PayInfo payInfo, int i) {
        this(3, str, str2, payInfo, null, -1, i);
    }

    public k(String str, String str2, PayInfo payInfo, String str3, int i, int i2) {
        this(3, str, str2, payInfo, str3, i, i2);
    }

    public k() {
        this(3, null, null, null, null, -1, -1);
    }

    private k(int i, String str, String str2, PayInfo payInfo, String str3, int i2, int i3) {
        this.kLr = null;
        this.kLs = null;
        this.mTimeStamp = null;
        this.eAS = null;
        this.kLt = null;
        this.kLu = 3;
        this.eAS = str2;
        this.kLu = 3;
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        a(payInfo, hashMap, hashMap2);
        hashMap.put("req_key", str);
        hashMap.put("flag", "4");
        hashMap.put("card_id", str2);
        if (i3 > 0) {
            hashMap.put("realname_scene", String.valueOf(i3));
            v.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[]{Integer.valueOf(i3)});
        }
        if (i2 == 8) {
            hashMap.put("scene", "1003");
        }
        hashMap.put("bank_card_tag", new StringBuilder("3").toString());
        hashMap.put("token", str3);
        u(hashMap);
        aa(hashMap2);
    }

    public final int aed() {
        return 73;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.kLr = new ArrayList();
        try {
            String str2;
            int i2;
            JSONObject jSONObject2;
            this.mTimeStamp = jSONObject.optString("time_stamp");
            String optString = jSONObject.optString("bank_type");
            if (be.kS(this.kLt)) {
                str2 = optString;
            } else {
                str2 = this.kLt;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("Array");
            int length = jSONArray.length();
            for (i2 = 0; i2 < length; i2++) {
                jSONObject2 = jSONArray.getJSONObject(i2);
                ElementQuery elementQuery = new ElementQuery();
                elementQuery.cBx = jSONObject2;
                elementQuery.kNS = jSONObject2.optString("bank_name");
                elementQuery.hMt = jSONObject2.optString("bank_type");
                elementQuery.kOc = jSONObject2.optString("bankacc_type_name");
                elementQuery.kOe = jSONObject2.optString("bank_phone");
                elementQuery.kOh = jSONObject2.optString("forbid_word");
                elementQuery.kOg = jSONObject2.optString("bank_recommend_desc");
                elementQuery.kOf = jSONObject2.optString("bank_app_user_name");
                elementQuery.kOb = jSONObject2.optInt("bankacc_type", 1);
                elementQuery.kNU = e.e(jSONObject2, "canModifyName");
                elementQuery.kNV = e.e(jSONObject2, "canModifyCreID");
                elementQuery.kNZ = "0".equals(jSONObject2.optString("is_sure"));
                elementQuery.kNW = "1".equals(jSONObject2.optString("needCVV"));
                elementQuery.kNX = "1".equals(jSONObject2.optString("needValiDate"));
                elementQuery.kNT = jSONObject2.optString("time_stamp");
                elementQuery.kNY = jSONObject2.optString("uesr_name");
                elementQuery.kOd = jSONObject2.optString("bank_flag");
                elementQuery.kOi = e.e(jSONObject2, "needFirstName");
                elementQuery.kOj = e.e(jSONObject2, "needLastName");
                elementQuery.kOk = e.e(jSONObject2, "needCountry");
                elementQuery.kOl = e.e(jSONObject2, "needArea");
                elementQuery.kOm = e.e(jSONObject2, "needCity");
                elementQuery.kOn = e.e(jSONObject2, "needAddress");
                elementQuery.kOo = e.e(jSONObject2, "needZip");
                elementQuery.kOp = e.e(jSONObject2, "needPhone");
                elementQuery.kOq = e.e(jSONObject2, "needEmail");
                elementQuery.kOt = e.e(jSONObject2, "needShowProtocol");
                elementQuery.kOr = jSONObject2.optString("support_cre_type");
                elementQuery.kLu = jSONObject2.optInt("bank_card_tag", 1);
                if (elementQuery.kLu == 1) {
                    if (!e.e(jSONObject2, "IsSaveYfq")) {
                        elementQuery.kOa = 0;
                    } else if (e.e(jSONObject2, "canReturnYfq")) {
                        elementQuery.kOa = 4;
                    } else {
                        elementQuery.kOa = 3;
                    }
                } else if (jSONObject2.optInt("auth_mode") == 1) {
                    elementQuery.kOa = 1;
                } else {
                    elementQuery.kOa = 2;
                }
                CharSequence optString2 = jSONObject2.optString("support_micropay");
                if (TextUtils.isEmpty(optString2)) {
                    elementQuery.kOu = true;
                } else if ("1".equals(optString2)) {
                    elementQuery.kOu = true;
                } else if ("0".equals(optString2)) {
                    elementQuery.kOu = false;
                }
                elementQuery.kMZ = jSONObject2.optString("arrive_type");
                if (Bankcard.cI(this.kLu, elementQuery.kLu)) {
                    this.kLr.add(elementQuery);
                }
                if (str2 != null && str2.equals(elementQuery.hMt)) {
                    this.kLs = elementQuery;
                }
            }
            SparseArray sparseArray = new SparseArray();
            jSONArray = jSONObject.getJSONArray("cre_type_map");
            length = jSONArray.length();
            for (i2 = 0; i2 < length; i2++) {
                jSONObject2 = jSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("key", 0);
                if (optInt > 0) {
                    sparseArray.put(optInt, jSONObject2.getString("val"));
                }
            }
            m bgi = com.tencent.mm.plugin.wallet_core.model.k.bgi();
            List list = this.kLr;
            bgi.kQm = sparseArray;
            bgi.kLr = list;
        } catch (Throwable e) {
            v.a("MicroMsg.NetSenceTenPayBase", e, "", new Object[0]);
        }
    }

    public final int zg() {
        return 1505;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/elementquerynew";
    }
}
