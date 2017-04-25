package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONObject;

public final class g {
    public static f qs(String str) {
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.CardMallItemParser", "parseCardMallItem jsonContent is null");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f fVar = new f();
            fVar.eCG = jSONObject.optString("empty_tips");
            fVar.eCH = jSONObject.optString("shoppingmall_title");
            fVar.eCI = jSONObject.optString("shoppingmall_url");
            fVar.eCJ = jSONObject.optInt("is_show") != 0;
            return fVar;
        } catch (Throwable e) {
            v.a("MicroMsg.CardMallItemParser", e, "", new Object[0]);
            return null;
        }
    }
}
