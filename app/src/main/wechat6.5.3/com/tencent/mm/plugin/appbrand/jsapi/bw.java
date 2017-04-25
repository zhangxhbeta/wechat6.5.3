package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class bw extends a {
    public static final int CTRL_INDEX = 85;
    public static final String NAME = "verifyPaymentPassword";

    public final void a(final f fVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            fVar.y(i, c("fail", null));
            return;
        }
        MMActivity nt = d.nt(fVar.dzg);
        if (nt == null) {
            fVar.y(i, c("fail", null));
            return;
        }
        AnonymousClass1 anonymousClass1 = new a(this) {
            final /* synthetic */ bw dJm;

            public final void a(int i, int i2, Intent intent) {
                if (i == (this.dJm.hashCode() & 65535)) {
                    if (i2 == -1) {
                        CharSequence charSequence = "";
                        if (intent != null) {
                            charSequence = be.ah(intent.getStringExtra("token"), "");
                        }
                        Map hashMap = new HashMap();
                        if (TextUtils.isEmpty(charSequence)) {
                            v.i("MicroMsg.JsApiVerifyPaymentPassword", "checkPwdToken is empty, verifyWCPayPassword:fail");
                            fVar.y(i, this.dJm.c("fail", null));
                            return;
                        }
                        hashMap.put("token", charSequence);
                        fVar.y(i, this.dJm.c("ok", hashMap));
                        v.i("MicroMsg.JsApiVerifyPaymentPassword", "checkPwdToken is valid, verifyWCPayPassword:ok");
                        return;
                    }
                    fVar.y(i, this.dJm.c("fail", null));
                }
            }
        };
        d dVar = new d(jSONObject);
        Intent intent = new Intent();
        intent.putExtra("appId", dVar.appId);
        intent.putExtra("timeStamp", dVar.bkm);
        intent.putExtra("nonceStr", dVar.bkl);
        intent.putExtra("packageExt", dVar.bkn);
        intent.putExtra("signtype", dVar.bkk);
        intent.putExtra("paySignature", dVar.bko);
        intent.putExtra("url", dVar.url);
        intent.putExtra("scene", 1);
        nt.nDS = anonymousClass1;
        c.a(nt, "wallet_core", ".ui.WalletCheckPwdUI", intent, hashCode() & 65535, false);
    }
}
