package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class bd extends a {
    public static final int CTRL_INDEX = 57;
    public static final String NAME = "requestPayment";

    bd() {
    }

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
        try {
            jSONObject.put("appId", fVar.dzg);
            final d dVar = new d(jSONObject);
            dVar.bks = 16;
            e.a(nt, dVar, hashCode() & 65535, new a(this) {
                final /* synthetic */ bd dHX;

                public final void a(int i, int i2, Intent intent) {
                    if (i == (this.dHX.hashCode() & 65535)) {
                        if (i2 == -1) {
                            fVar.y(i, this.dHX.c("ok", null));
                            bd bdVar = this.dHX;
                            f fVar = fVar;
                            int i3 = i;
                            String str = dVar.bkn;
                            MainProcessTask reportSubmitFormTask = new ReportSubmitFormTask(fVar.dzg);
                            reportSubmitFormTask.type = 0;
                            reportSubmitFormTask.dJz = str.replace("prepay_id=", "");
                            reportSubmitFormTask.dJA = d.a(fVar).dNn.dOM;
                            AppBrandMainProcessService.a(reportSubmitFormTask);
                            Map hashMap = new HashMap();
                            hashMap.put("eventId", reportSubmitFormTask.dJz);
                            fVar.y(i3, bdVar.c("ok", hashMap));
                        } else if (i2 == 5) {
                            Map hashMap2 = new HashMap();
                            int intExtra = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                            String ma = be.ma(intent.getStringExtra("key_jsapi_pay_err_msg"));
                            hashMap2.put("err_code", Integer.valueOf(intExtra));
                            hashMap2.put("err_desc", ma);
                            v.e("MicroMsg.JsApiRequestPayment", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(intExtra), ma});
                            fVar.y(i, this.dHX.c("fail", hashMap2));
                        } else {
                            fVar.y(i, this.dHX.c("cancel", null));
                        }
                    }
                }
            });
        } catch (Exception e) {
            v.e("MicroMsg.JsApiRequestPayment", e.getMessage());
            fVar.y(i, c("fail", null));
        }
    }
}
