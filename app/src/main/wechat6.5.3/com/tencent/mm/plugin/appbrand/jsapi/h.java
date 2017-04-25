package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONObject;

public final class h extends a {
    public static final int CTRL_INDEX = 86;
    public static final String NAME = "bindPaymentCard";

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
            final /* synthetic */ h dFr;

            public final void a(int i, int i2, Intent intent) {
                if (i == (this.dFr.hashCode() & 65535)) {
                    if (i2 == -1) {
                        fVar.y(i, this.dFr.c("ok", null));
                    } else {
                        fVar.y(i, this.dFr.c("fail", null));
                    }
                }
            }
        };
        d dVar = new d(jSONObject);
        dVar.bkr = 4;
        e.b(nt, dVar, hashCode() & 65535, anonymousClass1);
    }
}
