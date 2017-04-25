package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ao extends a {
    public static final int CTRL_INDEX = 62;
    public static final String NAME = "openAddress";

    public final void a(final f fVar, JSONObject jSONObject, final int i) {
        Intent intent = new Intent();
        intent.putExtra("req_app_id", fVar.dzg);
        intent.putExtra("launch_from_appbrand", true);
        MMActivity nt = d.nt(fVar.dzg);
        if (nt == null) {
            fVar.y(i, c("fail", null));
            return;
        }
        nt.nDS = new a(this) {
            final /* synthetic */ ao dHr;

            public final void a(int i, int i2, Intent intent) {
                if (i == (this.dHr.hashCode() & 65535)) {
                    if (i2 == -1 && intent != null) {
                        String ah = be.ah(intent.getStringExtra("nationalCode"), "");
                        String ah2 = be.ah(intent.getStringExtra("userName"), "");
                        String ah3 = be.ah(intent.getStringExtra("telNumber"), "");
                        String ah4 = be.ah(intent.getStringExtra("addressPostalCode"), "");
                        String ah5 = be.ah(intent.getStringExtra("proviceFirstStageName"), "");
                        String ah6 = be.ah(intent.getStringExtra("addressCitySecondStageName"), "");
                        String ah7 = be.ah(intent.getStringExtra("addressCountiesThirdStageName"), "");
                        String ah8 = be.ah(intent.getStringExtra("addressDetailInfo"), "");
                        v.i("MicroMsg.JsApiOpenAddress", "first =  " + ah5 + " ; detail =" + ah8 + "; second = " + ah6 + " ; tel = " + ah3 + "; third = " + ah7);
                        if (!be.kS(ah2)) {
                            Map hashMap = new HashMap();
                            hashMap.put("nationalCode", ah);
                            hashMap.put("userName", ah2);
                            hashMap.put("telNumber", ah3);
                            hashMap.put("addressPostalCode", ah4);
                            hashMap.put("proviceFirstStageName", ah5);
                            hashMap.put("addressCitySecondStageName", ah6);
                            hashMap.put("addressCountiesThirdStageName", ah7);
                            hashMap.put("addressDetailInfo", ah8);
                            fVar.y(i, this.dHr.c("ok", hashMap));
                            return;
                        }
                    }
                    if (i2 == 0) {
                        fVar.y(i, this.dHr.c("cancel", null));
                    } else {
                        fVar.y(i, this.dHr.c("fail", null));
                    }
                }
            }
        };
        c.a(nt, "address", ".ui.WalletSelectAddrUI", intent, hashCode() & 65535, false);
    }
}
