package com.tencent.mm.sdk.f;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public final class a {

    public static class a extends com.tencent.mm.sdk.e.b {
        public List<b> nhI;

        public a(Bundle bundle) {
            u(bundle);
        }

        public final int getType() {
            return 9;
        }

        public final void t(Bundle bundle) {
            super.t(bundle);
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
                jSONStringer.array();
                for (b bVar : this.nhI) {
                    jSONStringer.object();
                    jSONStringer.key("card_id");
                    jSONStringer.value(bVar.bns);
                    jSONStringer.key("card_ext");
                    jSONStringer.value(bVar.nhJ == null ? "" : bVar.nhJ);
                    jSONStringer.key("is_succ");
                    jSONStringer.value((long) bVar.nhK);
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                jSONStringer.endObject();
            } catch (Throwable e) {
                v.a("MicroMsg.AddCardToWXCardPackage", e, "", new Object[0]);
            }
            bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
        }

        public final void u(Bundle bundle) {
            super.u(bundle);
            if (this.nhI == null) {
                this.nhI = new LinkedList();
            }
            String string = bundle.getString("_wxapi_add_card_to_wx_card_list");
            if (string != null && string.length() > 0) {
                try {
                    JSONArray jSONArray = ((JSONObject) new JSONTokener(string).nextValue()).getJSONArray("card_list");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        b bVar = new b();
                        bVar.bns = jSONObject.optString("card_id");
                        bVar.nhJ = jSONObject.optString("card_ext");
                        bVar.nhK = jSONObject.optInt("is_succ");
                        this.nhI.add(bVar);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public static final class b {
        public String bns;
        public String nhJ;
        public int nhK;
    }
}
