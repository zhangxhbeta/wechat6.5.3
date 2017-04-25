package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.mm.plugin.appbrand.widget.b.d;
import com.tencent.mm.plugin.appbrand.widget.b.e.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class e extends b {

    class AnonymousClass2 implements a {
        final /* synthetic */ e dKU;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.widget.b.a dKV;
        final /* synthetic */ d dKW;

        AnonymousClass2(e eVar, com.tencent.mm.plugin.appbrand.widget.b.a aVar, d dVar) {
            this.dKU = eVar;
            this.dKV = aVar;
            this.dKW = dVar;
        }

        public final void c(boolean z, String str) {
            this.dKV.hide();
            if (z) {
                Map hashMap = new HashMap(2);
                hashMap.put(Columns.VALUE, this.dKW.To());
                hashMap.put("index", Integer.valueOf(this.dKW.getValue()));
                this.dKU.d("ok", hashMap);
                return;
            }
            this.dKU.d("cancel", null);
        }
    }

    e() {
    }

    final void e(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("array");
        final int optInt = jSONObject.optInt("current", 0);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            d("fail:invalid data", null);
            return;
        }
        final String[] strArr = new String[optJSONArray.length()];
        int i = 0;
        while (i < optJSONArray.length()) {
            try {
                strArr[i] = optJSONArray.getString(i);
                i++;
            } catch (Throwable e) {
                v.e("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "opt data.array, exp = %s", new Object[]{be.e(e)});
                d("fail", null);
                return;
            }
        }
        com.tencent.mm.plugin.appbrand.k.a.runOnUiThread(new Runnable(this) {
            final /* synthetic */ e dKU;

            public final void run() {
                e eVar = this.dKU;
                String[] strArr = strArr;
                int i = optInt;
                com.tencent.mm.plugin.appbrand.widget.b.e Tn = eVar.Tn();
                if (Tn == null) {
                    eVar.d("fail", null);
                    return;
                }
                if (Tn.dZu == null || !(Tn.dZu instanceof d)) {
                    Tn.a(new d(Tn.getContext()));
                }
                d dVar = (d) Tn.dZu;
                if (strArr != null) {
                    dVar.dZq = strArr;
                    dVar.setDisplayedValues(null);
                    dVar.setMinValue(0);
                    dVar.setMaxValue(Math.max(strArr.length - 1, 0));
                    dVar.setDisplayedValues(strArr);
                }
                dVar.setValue(i);
                Tn.dZw = new AnonymousClass2(eVar, Tn, dVar);
                Tn.show();
            }
        });
    }
}
