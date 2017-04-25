package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.e;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

public final class f {
    public static ArrayList<iv> al(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.CardListItemParser", "parseCardListItemArray jsonContent is null");
            return null;
        }
        if (i == 8 || i == 0) {
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            } catch (Throwable e) {
                v.a("MicroMsg.CardListItemParser", e, "", new Object[0]);
                return null;
            }
        }
        optJSONArray = new JSONArray(str);
        if (optJSONArray == null || optJSONArray.length() == 0) {
            v.e("MicroMsg.CardListItemParser", "parseCardListItemArray cardItemListJson is null");
            return null;
        }
        ArrayList<iv> arrayList = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            iv ivVar = new iv();
            ivVar.eBK = optJSONObject.optString("card_id");
            ivVar.bom = optJSONObject.optString("card_ext");
            arrayList.add(ivVar);
        }
        return arrayList;
    }

    public static String a(LinkedList<e> linkedList, boolean z, int i) {
        if (linkedList.size() == 0) {
            v.e("MicroMsg.CardListItemParser", "parseCardListItemToJson list == null || list.size() == 0");
            return "";
        }
        v.i("MicroMsg.CardListItemParser", "parseCardListItemToJson is_succ:" + z + " scene:" + i);
        JSONStringer jSONStringer = new JSONStringer();
        if (i == 8) {
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
            } catch (Throwable e) {
                v.a("MicroMsg.CardListItemParser", e, "", new Object[0]);
                return "";
            }
        }
        jSONStringer.array();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            jSONStringer.object();
            jSONStringer.key("card_id");
            jSONStringer.value(eVar.eBK);
            jSONStringer.key("card_ext");
            jSONStringer.value(eVar.bom == null ? "" : eVar.bom);
            jSONStringer.key("is_succ");
            if (z) {
                jSONStringer.value(1);
            } else {
                jSONStringer.value(0);
            }
            jSONStringer.key("code");
            jSONStringer.value(eVar.code == null ? "" : eVar.code);
            jSONStringer.endObject();
        }
        jSONStringer.endArray();
        if (i == 8) {
            jSONStringer.endObject();
        }
        return jSONStringer.toString();
    }

    public static String qr(String str) {
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.CardListItemParser", "parseCardListItemArray jsonContent is null");
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                v.e("MicroMsg.CardListItemParser", "parseCardListItemArray cardItemListJson is null");
                return null;
            }
            JSONStringer jSONStringer = new JSONStringer();
            jSONStringer.array();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                jSONStringer.object();
                jSONStringer.key("card_id");
                jSONStringer.value(optJSONObject.optString("card_id"));
                jSONStringer.key("card_ext");
                jSONStringer.value(optJSONObject.optString("card_ext"));
                jSONStringer.key("is_succ");
                jSONStringer.value((long) optJSONObject.optInt("is_succ"));
                jSONStringer.key("code");
                if (TextUtils.isEmpty(optJSONObject.optString("encrypt_code"))) {
                    jSONStringer.value(optJSONObject.optString("code"));
                } else {
                    jSONStringer.value(optJSONObject.optString("encrypt_code"));
                }
                jSONStringer.endObject();
                v.i("MicroMsg.CardListItemParser", "parseJsonToArray item" + i + "  is_succ:" + optJSONObject.optInt("is_succ"));
            }
            jSONStringer.endArray();
            return jSONStringer.toString();
        } catch (Throwable e) {
            v.a("MicroMsg.CardListItemParser", e, "", new Object[0]);
            return "";
        }
    }
}
