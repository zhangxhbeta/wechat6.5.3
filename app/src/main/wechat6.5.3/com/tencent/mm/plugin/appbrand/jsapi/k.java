package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.ay.c;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k extends a {
    public static final int CTRL_INDEX = 103;
    public static final String NAME = "chooseLocation";
    int dFQ = 0;

    public final void a(final f fVar, JSONObject jSONObject, int i) {
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 8);
        MMActivity nt = d.nt(fVar.dzg);
        if (nt == null) {
            fVar.y(i, c("fail", null));
            v.e("MicroMsg.JsApiChooseLocation", "mmActivity is null, invoke fail!");
            return;
        }
        this.dFQ = i;
        nt.nDS = new a(this) {
            final /* synthetic */ k dFR;

            public final void a(int i, int i2, Intent intent) {
                if (i != 1) {
                    return;
                }
                if (i2 == -1) {
                    if (intent == null) {
                        fVar.y(this.dFR.dFQ, this.dFR.c("fail", null));
                        v.e("MicroMsg.JsApiChooseLocation", "location result is empty!");
                        return;
                    }
                    Addr addr = (Addr) intent.getParcelableExtra("key_pick_addr");
                    Map hashMap = new HashMap();
                    if (addr != null) {
                        v.i("MicroMsg.JsApiChooseLocation", "addr: " + addr.toString());
                        StringBuilder stringBuilder = new StringBuilder();
                        if (TextUtils.isEmpty(addr.cJf)) {
                            stringBuilder.append(addr.FV());
                        } else {
                            stringBuilder.append(addr.cJf);
                        }
                        hashMap.put("address", stringBuilder.toString());
                        hashMap.put("name", addr.cJp);
                        hashMap.put("latitude", addr.cJq);
                        hashMap.put("longitude", addr.cJr);
                        fVar.y(this.dFR.dFQ, this.dFR.c("ok", hashMap));
                        return;
                    }
                    fVar.y(this.dFR.dFQ, this.dFR.c("fail", null));
                    v.e("MicroMsg.JsApiChooseLocation", "location result is empty!");
                } else if (i2 == 0) {
                    fVar.y(this.dFR.dFQ, this.dFR.c("cancel", null));
                    v.e("MicroMsg.JsApiChooseLocation", "location result is cancel!");
                } else {
                    fVar.y(this.dFR.dFQ, this.dFR.c("fail", null));
                    v.e("MicroMsg.JsApiChooseLocation", "location result is fail!");
                }
            }
        };
        c.b(nt, "location", ".ui.RedirectUI", intent, 1);
    }
}
