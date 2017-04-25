package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p {
    public static l qF(String str) {
        int i = 1;
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData jsonContent is null");
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("list");
            if (optJSONObject == null) {
                v.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData resultJson is null");
                return null;
            }
            int i2;
            l lVar = new l();
            lVar.eEF = optJSONObject.optString("local_city");
            lVar.eED = qG(optJSONObject.optString("local_city_list"));
            lVar.eEE = qG(optJSONObject.optString("other_city_list"));
            lVar.eEG = optJSONObject.optBoolean("local_end");
            lVar.eEH = optJSONObject.optBoolean("other_end");
            lVar.eEI = optJSONObject.optBoolean("show_red_dot");
            lVar.eEJ = optJSONObject.optBoolean("show_new");
            lVar.eEL = optJSONObject.optString("tips");
            lVar.eEK = qH(optJSONObject.optString("icons"));
            lVar.eEM = optJSONObject.optInt("newest_sharecard_time_second");
            String str2 = "MicroMsg.ShareCardLayoutDataParser";
            String str3 = "localEnd:%d, otherEnd:%d, showRedDot:%d, showNew:%d, tips:%s";
            Object[] objArr = new Object[5];
            if (lVar.eEG) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(lVar.eEH ? 1 : 0);
            objArr[2] = Integer.valueOf(lVar.eEI ? 1 : 0);
            if (!lVar.eEJ) {
                i = 0;
            }
            objArr[3] = Integer.valueOf(i);
            objArr[4] = lVar.eEL;
            v.i(str2, str3, objArr);
            return lVar;
        } catch (Throwable e) {
            v.a("MicroMsg.ShareCardLayoutDataParser", e, "", new Object[0]);
            return null;
        }
    }

    private static LinkedList<m> qG(String str) {
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem jsonContent is null");
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("item_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                v.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem itemListJson is null");
                return null;
            }
            LinkedList<m> linkedList = new LinkedList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                m mVar = new m();
                mVar.bol = optJSONObject.optString("card_id");
                mVar.eBK = optJSONObject.optString("card_tp_id");
                mVar.eEN = optJSONObject.optString("announcement");
                mVar.eEO = (long) optJSONObject.optInt("end_time", 0);
                mVar.eEP = (long) optJSONObject.optInt("update_time", 0);
                mVar.eEQ = optJSONObject.optInt("item_type", 0);
                mVar.top = optJSONObject.optInt("top", 0);
                v.i("MicroMsg.ShareCardLayoutDataParser", "ljd: card_tp_id:" + mVar.eBK + " top:" + mVar.top);
                linkedList.add(mVar);
            }
            return linkedList;
        } catch (Throwable e) {
            v.a("MicroMsg.ShareCardLayoutDataParser", e, "", new Object[0]);
            return null;
        }
    }

    private static LinkedList<String> qH(String str) {
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons jsonContent is null");
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                v.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons itemListJson is null");
                return null;
            }
            LinkedList<String> linkedList = new LinkedList();
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(jSONArray.optString(i));
            }
            return linkedList;
        } catch (Throwable e) {
            v.a("MicroMsg.ShareCardLayoutDataParser", e, "", new Object[0]);
            return null;
        }
    }
}
