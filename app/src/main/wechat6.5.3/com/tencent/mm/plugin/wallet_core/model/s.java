package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.e.b.dd;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;
import org.json.JSONObject;

public final class s extends dd {
    public static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[6];
        aVar.bXK = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "wallet_tpa_country";
        aVar.nmd.put("wallet_tpa_country", "TEXT PRIMARY KEY ");
        stringBuilder.append(" wallet_tpa_country TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "wallet_tpa_country";
        aVar.bXK[1] = "wallet_type";
        aVar.nmd.put("wallet_type", "INTEGER");
        stringBuilder.append(" wallet_type INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[2] = "wallet_name";
        aVar.nmd.put("wallet_name", "TEXT");
        stringBuilder.append(" wallet_name TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "wallet_selected";
        aVar.nmd.put("wallet_selected", "INTEGER");
        stringBuilder.append(" wallet_selected INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = "wallet_balance";
        aVar.nmd.put("wallet_balance", "INTEGER");
        stringBuilder.append(" wallet_balance INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[5] = "wallet_tpa_country_mask";
        aVar.nmd.put("wallet_tpa_country_mask", "INTEGER");
        stringBuilder.append(" wallet_tpa_country_mask INTEGER");
        aVar.bXK[6] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public static s C(JSONObject jSONObject) {
        if (jSONObject == null) {
            v.e("MicroMsg.WalletKindInfo", "json is null");
            return null;
        }
        s sVar = new s();
        sVar.field_wallet_tpa_country = jSONObject.optString("wallet_tpa_country");
        sVar.field_wallet_name = jSONObject.optString("wallet_name");
        sVar.field_wallet_selected = jSONObject.optInt("wallet_selected");
        sVar.field_wallet_type = jSONObject.optInt("wallet_type");
        sVar.field_wallet_balance = jSONObject.optInt("wallet_balance");
        sVar.field_wallet_tpa_country_mask = jSONObject.optInt("wallet_tpa_country_mask");
        if (!be.kS(sVar.field_wallet_tpa_country)) {
            return sVar;
        }
        v.e("MicroMsg.WalletKindInfo", "wallet_id is illegal");
        return null;
    }
}
