package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.protocal.c.jd;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i {
    public static LinkedList<jd> qu(String str) {
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray jsonContent is null");
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                v.e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray cardItemListJson is null");
                return null;
            }
            LinkedList<jd> linkedList = new LinkedList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                jd jdVar = new jd();
                jdVar.eBK = optJSONObject.optString("card_id");
                jdVar.code = optJSONObject.optString("code");
                linkedList.add(jdVar);
            }
            return linkedList;
        } catch (Throwable e) {
            v.a("MicroMsg.CardListItemParser", e, "", new Object[0]);
            return null;
        }
    }
}
