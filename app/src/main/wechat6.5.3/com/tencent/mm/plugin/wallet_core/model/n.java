package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.e.b.db;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n extends db {
    public static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[3];
        aVar.bXK = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "bulletin_scene";
        aVar.nmd.put("bulletin_scene", "TEXT PRIMARY KEY ");
        stringBuilder.append(" bulletin_scene TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "bulletin_scene";
        aVar.bXK[1] = "bulletin_content";
        aVar.nmd.put("bulletin_content", "TEXT");
        stringBuilder.append(" bulletin_content TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "bulletin_url";
        aVar.nmd.put("bulletin_url", "TEXT");
        stringBuilder.append(" bulletin_url TEXT");
        aVar.bXK[3] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public static void B(JSONObject jSONObject) {
        boolean z = true;
        int i = 0;
        d bge = k.bge();
        if (jSONObject == null || bge == null) {
            String str = "MicroMsg.WalletBulletin";
            StringBuilder append = new StringBuilder("json==null?").append(jSONObject == null).append("  stg==null?");
            if (bge != null) {
                z = false;
            }
            v.e(str, append.append(z).toString());
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("banner_map");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("banner_content_array");
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        if (optJSONArray == null || optJSONArray2 == null) {
            String str2 = "MicroMsg.WalletBulletin";
            append = new StringBuilder("scenes==null?").append(optJSONArray == null).append("  contents==null?");
            if (optJSONArray2 != null) {
                z = false;
            }
            v.e(str2, append.append(z).toString());
            return;
        }
        int i2;
        int length = optJSONArray.length();
        for (i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("banner_type");
                String optString2 = optJSONObject.optString("banner_template_id");
                v.i("MicroMsg.WalletBulletin", "sceneid=" + optString + "; contentid=" + optString2);
                if (!(be.kS(optString) || be.kS(optString2))) {
                    hashMap.put(optString, optString2);
                    v.i("MicroMsg.WalletBulletin", "sceneid:" + optString + " map contentid:" + optString2);
                }
            }
        }
        i2 = optJSONArray2.length();
        while (i < i2) {
            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i);
            if (optJSONObject2 != null) {
                hashMap2.put(optJSONObject2.optString("banner_template_id"), Integer.valueOf(i));
            }
            i++;
        }
        if (hashMap.size() > 0) {
            for (String str3 : hashMap.keySet()) {
                String str4 = (String) hashMap.get(str3);
                if (hashMap2.containsKey(str4)) {
                    v.i("MicroMsg.WalletBulletin", "find contentid:" + str4 + "in contentMap");
                    optJSONObject2 = optJSONArray2.optJSONObject(((Integer) hashMap2.get(str4)).intValue());
                    n nVar = new n();
                    nVar.field_bulletin_scene = str3;
                    nVar.field_bulletin_content = optJSONObject2.optString("content");
                    nVar.field_bulletin_url = optJSONObject2.optString("url");
                    bge.b(nVar);
                } else {
                    v.e("MicroMsg.WalletBulletin", "can not find contentid:" + str4 + "in contentMap");
                }
            }
        }
    }
}
