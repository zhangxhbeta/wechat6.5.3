package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.widget.input.e;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONObject;

final class bg extends a {
    private static final int CTRL_INDEX = 77;
    private static final String NAME = "setKeyboardValue";

    bg() {
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        com.tencent.mm.plugin.appbrand.page.f mp = a.mp(fVar.dzg);
        if (mp != null && mp.Rm() != null && mp.Rm().QZ() != null) {
            h QZ = mp.Rm().QZ();
            String optString = jSONObject.optString(Columns.VALUE);
            Integer num = null;
            try {
                num = Integer.valueOf(jSONObject.getInt("cursor"));
            } catch (Exception e) {
            }
            e.a(QZ, optString, num);
        }
    }
}
