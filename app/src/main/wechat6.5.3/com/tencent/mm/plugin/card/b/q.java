package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q {
    public static ArrayList<ix> qI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("used_store_list");
            if (jSONArray == null || jSONArray.length() == 0) {
                return null;
            }
            ArrayList<ix> arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject == null) {
                    obj = null;
                } else {
                    obj = new ix();
                    obj.name = jSONObject.optString("name");
                    obj.descriptor = jSONObject.optString("descriptor");
                    obj.eBY = jSONObject.optString("phone");
                    obj.cJg = jSONObject.optString("country");
                    obj.bCk = jSONObject.optString("province");
                    obj.bCl = jSONObject.optString("city");
                    obj.cJf = jSONObject.optString("address");
                    obj.mkD = (float) jSONObject.optDouble("distance");
                    obj.biH = (float) jSONObject.optDouble("longitude");
                    obj.bhs = (float) jSONObject.optDouble("latitude");
                    obj.eDc = jSONObject.optString("jump_url");
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        } catch (Throwable e) {
            v.a("MicroMsg.ShopInfoItemParser", e, "", new Object[0]);
            return null;
        }
    }
}
