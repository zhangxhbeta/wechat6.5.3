package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class be extends a {
    public static final int CTRL_INDEX = 57;
    public static final String NAME = "requestPaymentToBank";

    public final void a(final f fVar, JSONObject jSONObject, final int i) {
        MMActivity nt = d.nt(fVar.dzg);
        if (nt == null) {
            fVar.y(i, c("fail", null));
            return;
        }
        try {
            jSONObject.put("appId", fVar.dzg);
            d dVar = new d(jSONObject);
            dVar.bks = 16;
            AnonymousClass1 anonymousClass1 = new a(this) {
                final /* synthetic */ be dHY;

                public final void a(int i, int i2, Intent intent) {
                    if (i == (this.dHY.hashCode() & 65535)) {
                        if (i2 == -1) {
                            Map hashMap = new HashMap();
                            String ah = com.tencent.mm.sdk.platformtools.be.ah(intent.getStringExtra("token"), "");
                            String ah2 = com.tencent.mm.sdk.platformtools.be.ah(intent.getStringExtra("bind_serial"), "");
                            hashMap.put("token", ah);
                            hashMap.put("bindSerial", ah2);
                            fVar.y(i, this.dHY.c("ok", hashMap));
                            return;
                        }
                        fVar.y(i, this.dHY.c("fail", null));
                    }
                }
            };
            Intent intent = new Intent();
            intent.putExtra("appId", dVar.appId);
            intent.putExtra("timeStamp", dVar.bkm);
            intent.putExtra("nonceStr", dVar.bkl);
            intent.putExtra("packageExt", dVar.bkn);
            intent.putExtra("signtype", dVar.bkk);
            intent.putExtra("paySignature", dVar.bko);
            intent.putExtra("url", dVar.url);
            nt.nDS = anonymousClass1;
            c.a(nt, "wallet", ".pay.ui.WalletLoanRepaymentUI", intent, hashCode() & 65535, false);
        } catch (Exception e) {
            v.e("MicroMsg.JsApiRequestPaymentToBank", e.getMessage());
            fVar.y(i, c("fail", null));
        }
    }
}
