package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.appbrand.widget.b.e;
import com.tencent.mm.plugin.appbrand.widget.b.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class f extends b {
    int dKX = -1;
    int dKY = -1;
    int dKZ = -1;
    int dLa = -1;
    int dLb = -1;
    int dLc = -1;

    f() {
    }

    final void e(JSONObject jSONObject) {
        int[] oP;
        JSONObject optJSONObject = jSONObject.optJSONObject("range");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("start");
            String optString2 = optJSONObject.optString("end");
            int[] oP2 = i.oP(optString);
            if (oP2 != null) {
                this.dKX = oP2[0];
                this.dKY = oP2[1];
            }
            oP = i.oP(optString2);
            if (oP != null) {
                this.dKZ = oP[0];
                this.dLa = oP[1];
            }
        }
        oP = i.oP(jSONObject.optString("current"));
        if (oP != null) {
            this.dLb = oP[0];
            this.dLc = oP[1];
        }
        a.runOnUiThread(new Runnable(this) {
            final /* synthetic */ f dLd;

            {
                this.dLd = r1;
            }

            public final void run() {
                f fVar = this.dLd;
                e Tn = fVar.Tn();
                if (Tn == null) {
                    fVar.d("fail", null);
                    return;
                }
                if (Tn.dZu == null || !(Tn.dZu instanceof com.tencent.mm.plugin.appbrand.widget.b.f)) {
                    Tn.a(new com.tencent.mm.plugin.appbrand.widget.b.f(Tn.getContext()));
                }
                com.tencent.mm.plugin.appbrand.widget.b.f fVar2 = (com.tencent.mm.plugin.appbrand.widget.b.f) Tn.dZu;
                int i = fVar.dKX;
                int i2 = fVar.dKY;
                fVar2.dKX = i;
                fVar2.dKY = i2;
                if (i.hN(fVar2.dKX) && fVar2.dZz != null) {
                    fVar2.dZz.setMinValue(fVar2.dKX);
                }
                i = fVar.dKZ;
                i2 = fVar.dLa;
                fVar2.dKZ = i;
                fVar2.dLa = i2;
                if (i.hN(fVar2.dKZ) && fVar2.dZz != null) {
                    fVar2.dZz.setMaxValue(fVar2.dKZ);
                }
                i = fVar.dLb;
                i2 = fVar.dLc;
                if (i.hN(i) && i.hM(i2)) {
                    fVar2.setCurrentHour(Integer.valueOf(i));
                    fVar2.setCurrentMinute(Integer.valueOf(i2));
                }
                fVar2.Tp();
                Tn.dZw = new e.a(fVar) {
                    final /* synthetic */ f dLd;

                    {
                        this.dLd = r1;
                    }

                    public final void c(boolean z, String str) {
                        b bVar = this.dLd;
                        if (bVar.dZe != null) {
                            bVar.dZe.hide();
                        }
                        if (!z) {
                            bVar.d("cancel", null);
                        } else if (be.kS(str)) {
                            bVar.d("fail", null);
                        } else {
                            Map hashMap = new HashMap(1);
                            hashMap.put(Columns.VALUE, str);
                            bVar.d("ok", hashMap);
                        }
                    }
                };
                Tn.show();
            }
        });
    }
}
