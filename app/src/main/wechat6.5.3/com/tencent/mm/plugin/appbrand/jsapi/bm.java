package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.widget.input.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.h.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class bm extends a {
    private static final int CTRL_INDEX = 104;
    private static final String NAME = "showModal";
    boolean dIF = false;

    public final void a(f fVar, JSONObject jSONObject, int i) {
        h a = d.a(fVar);
        if (a == null) {
            v.w("MicroMsg.JsApiShowModal", "invoke JsApi JsApiShowModal failed, current page view is null.");
            fVar.y(i, c("fail", null));
            return;
        }
        e.m(a);
        final String optString = jSONObject.optString("title");
        final String optString2 = jSONObject.optString("confirmText", fVar.mContext.getString(2131231107));
        final String optString3 = jSONObject.optString("cancelText", fVar.mContext.getString(2131231010));
        final Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean("showCancel", true));
        final int ac = d.ac(jSONObject.optString("confirmColor", ""), Color.parseColor("#3CC51F"));
        final int ac2 = d.ac(jSONObject.optString("cancelColor", ""), Color.parseColor("#000000"));
        final String optString4 = jSONObject.optString("content");
        final f fVar2 = fVar;
        final int i2 = i;
        ad.o(new Runnable(this) {
            final /* synthetic */ bm dIL;

            public final void run() {
                a aVar = new a(d.nt(fVar2.dzg));
                aVar.Op(optString);
                aVar.Oq(optString4);
                aVar.Os(optString2);
                aVar.a(new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 dIM;

                    {
                        this.dIM = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Map hashMap = new HashMap();
                        hashMap.put("confirm", Boolean.valueOf(true));
                        fVar2.y(i2, this.dIM.dIL.c("ok", hashMap));
                    }
                });
                if (valueOf.booleanValue()) {
                    aVar.Ot(optString3);
                    aVar.b(new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 dIM;

                        {
                            this.dIM = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.dIM.dIL.dIF = true;
                            Map hashMap = new HashMap();
                            hashMap.put("confirm", Boolean.valueOf(false));
                            fVar2.y(i2, this.dIM.dIL.c("ok", hashMap));
                        }
                    });
                }
                aVar.c(new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass1 dIM;

                    {
                        this.dIM = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        if (!this.dIM.dIL.dIF) {
                            Map hashMap = new HashMap();
                            hashMap.put("confirm", Boolean.valueOf(false));
                            fVar2.y(i2, this.dIM.dIL.c("ok", hashMap));
                        }
                        this.dIM.dIL.dIF = false;
                    }
                });
                com.tencent.mm.ui.base.h RX = aVar.RX();
                RX.wk(ac);
                if (valueOf.booleanValue()) {
                    RX.wl(ac2);
                }
                RX.show();
            }
        });
    }
}
