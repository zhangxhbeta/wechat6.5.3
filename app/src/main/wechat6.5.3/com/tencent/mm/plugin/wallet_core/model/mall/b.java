package com.tencent.mm.plugin.wallet_core.model.mall;

import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static int kRi = -256;
    public static int kRj = 621019136;
    public static int kRk = 637534720;

    public static ArrayList<MallNews> r(JSONArray jSONArray) {
        try {
            ArrayList<MallNews> arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                MallNews mallNews = new MallNews(jSONObject.optString("activity_jump_funcid"));
                mallNews.kRq = jSONObject.optString("activity_icon_link");
                mallNews.kRo = jSONObject.optString("activity_msg_content");
                mallNews.kRs = jSONObject.optString("activity_tips");
                arrayList.add(mallNews);
            }
            return arrayList;
        } catch (Throwable e) {
            v.a("MicroMsg.MallLogic", e, "", new Object[0]);
            return null;
        }
    }

    public static ArrayList<a> s(JSONArray jSONArray) {
        try {
            ArrayList<a> arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                a aVar = new a();
                aVar.kRb = jSONObject.optInt("banner_id");
                aVar.kRc = jSONObject.optString("banner_title");
                aVar.kRd = jSONObject.optString("banner_link");
                arrayList.add(aVar);
            }
            return arrayList;
        } catch (JSONException e) {
            v.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + e.getMessage());
            return null;
        }
    }

    public static SparseArray<String> t(JSONArray jSONArray) {
        try {
            SparseArray<String> sparseArray = new SparseArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int optInt = jSONObject.optInt("type_id", 0);
                if (optInt != 0) {
                    sparseArray.put(optInt, jSONObject.optString("type_name"));
                }
            }
            return sparseArray;
        } catch (JSONException e) {
            v.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + e.getMessage());
            return null;
        }
    }

    public static void bB(List<a> list) {
        if (list == null || list.size() <= 0) {
            v.w("MicroMsg.MallLogic", "func[setBannerRedDotClick] actList null or empty");
            return;
        }
        int i = ((a) list.get(0)).kRb;
        v.d("MicroMsg.MallLogic", "func[setBannerRedDotClick], lastClickedListMaxId" + i);
        ak.yW();
        c.vf().set(270342, Integer.valueOf(i));
        ak.yW();
        c.vf().iB(true);
    }

    public static ArrayList<MallFunction> u(JSONArray jSONArray) {
        try {
            ArrayList<MallFunction> arrayList = new ArrayList();
            int length = jSONArray.length();
            v.d("MicroMsg.MallLogic", "functions.jsonArray.length : " + length);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                MallFunction mallFunction = new MallFunction();
                mallFunction.imm = jSONObject.getString("func_id");
                mallFunction.bpZ = jSONObject.getString("func_name");
                mallFunction.kRe = jSONObject.optString("func_icon_url");
                mallFunction.hiB = jSONObject.optString("hd_icon_url");
                mallFunction.hiC = jSONObject.optString("func_foregroud_icon_url");
                mallFunction.cCj = jSONObject.optString("native_url");
                mallFunction.gxI = jSONObject.optString("h5_url");
                mallFunction.type = jSONObject.optInt("property_type", 0);
                mallFunction.kRh = jSONObject.optString("third_party_disclaimer");
                JSONArray optJSONArray = jSONObject.optJSONArray("remark_name_list");
                if (optJSONArray != null) {
                    mallFunction.kRf = new ArrayList();
                    int length2 = optJSONArray.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        mallFunction.kRf.add(optJSONArray.getString(i2));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("activity_info_list");
                if (!(optJSONArray2 == null || optJSONArray2.length() == 0)) {
                    String str = mallFunction.imm;
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(0);
                    MallNews mallNews = new MallNews(str);
                    mallNews.keV = jSONObject2.optString("activity_id");
                    mallNews.bax = jSONObject2.optString("activity_ticket");
                    mallNews.kRo = jSONObject2.optString("activity_msg_content");
                    mallNews.kRp = jSONObject2.optString("activity_link");
                    mallNews.kRq = jSONObject2.optString("activity_icon_link");
                    mallNews.kRr = jSONObject2.optInt("activity_expired_time");
                    mallNews.kRs = jSONObject2.optString("activity_tips");
                    mallNews.kPK = jSONObject2.optInt("activity_type");
                    mallNews.kRv = jSONObject2.optString("activity_url");
                    mallNews.kRt = jSONObject2.optInt("is_msg_reserved");
                    mallFunction.kRg = mallNews;
                }
                arrayList.add(mallFunction);
            }
            return arrayList;
        } catch (Throwable e) {
            v.a("MicroMsg.MallLogic", e, "", new Object[0]);
            return null;
        }
    }

    public static String bgK() {
        TelephonyManager telephonyManager = (TelephonyManager) aa.getContext().getSystemService("phone");
        String str = "";
        if (telephonyManager != null) {
            return telephonyManager.getNetworkCountryIso();
        }
        return str;
    }

    public static void so(int i) {
        boolean z;
        if ((d.lWh & kRi) == i) {
            ak.yW();
            int intValue = ((Integer) c.vf().get(270343, Integer.valueOf(0))).intValue();
            if (i != intValue) {
                v.d("MicroMsg.MallLogic", "Mall reddot show, targetV=" + i + ", clickedV=" + intValue);
                z = true;
                if (z && k.xO()) {
                    v.d("MicroMsg.MallLogic", "Show mall entry redot");
                    com.tencent.mm.p.c.us().s(262156, true);
                    ak.yW();
                    c.vf().set(270343, Integer.valueOf(i));
                    return;
                }
            }
        }
        z = false;
        if (z) {
        }
    }
}
