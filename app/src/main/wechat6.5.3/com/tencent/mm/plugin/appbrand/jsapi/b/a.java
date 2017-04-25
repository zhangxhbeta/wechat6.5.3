package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.widget.NumberPicker;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.appbrand.widget.b.c;
import com.tencent.mm.plugin.appbrand.widget.b.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

final class a extends b {
    a dKF;
    long dKG = -1;
    long dKH = -1;
    int dKI = -1;
    int dKJ = -1;
    int dKK = -1;

    private enum a {
        YEAR(new SimpleDateFormat("yyyy", Locale.US)),
        MONTH(new SimpleDateFormat("yyyy-MM", Locale.US)),
        DAY(new SimpleDateFormat("yyyy-MM-dd", Locale.US));
        
        final DateFormat dKP;

        private a(DateFormat dateFormat) {
            this.dKP = dateFormat;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static com.tencent.mm.plugin.appbrand.jsapi.b.a.a nI(java.lang.String r4) {
            /*
            r0 = 0;
            r1 = r4.length();
            r2 = 5;
            r1 = java.lang.Math.min(r1, r2);
            r1 = java.lang.Math.max(r0, r1);
            r1 = r4.substring(r0, r1);
            r2 = r1.toLowerCase();
            r1 = -1;
            r3 = r2.hashCode();
            switch(r3) {
                case 99228: goto L_0x003a;
                case 3704893: goto L_0x0025;
                case 104080000: goto L_0x002f;
                default: goto L_0x001e;
            };
        L_0x001e:
            r0 = r1;
        L_0x001f:
            switch(r0) {
                case 0: goto L_0x0045;
                case 1: goto L_0x0048;
                case 2: goto L_0x004b;
                default: goto L_0x0022;
            };
        L_0x0022:
            r0 = MONTH;
        L_0x0024:
            return r0;
        L_0x0025:
            r3 = "year";
            r2 = r2.equals(r3);
            if (r2 == 0) goto L_0x001e;
        L_0x002e:
            goto L_0x001f;
        L_0x002f:
            r0 = "month";
            r0 = r2.equals(r0);
            if (r0 == 0) goto L_0x001e;
        L_0x0038:
            r0 = 1;
            goto L_0x001f;
        L_0x003a:
            r0 = "day";
            r0 = r2.equals(r0);
            if (r0 == 0) goto L_0x001e;
        L_0x0043:
            r0 = 2;
            goto L_0x001f;
        L_0x0045:
            r0 = YEAR;
            goto L_0x0024;
        L_0x0048:
            r0 = MONTH;
            goto L_0x0024;
        L_0x004b:
            r0 = DAY;
            goto L_0x0024;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.b.a.a.nI(java.lang.String):com.tencent.mm.plugin.appbrand.jsapi.b.a$a");
        }

        final Date parse(String str) {
            try {
                return this.dKP.parse(str);
            } catch (Exception e) {
                return null;
            }
        }
    }

    a() {
    }

    final void e(JSONObject jSONObject) {
        Date parse;
        this.dKF = a.nI(jSONObject.optString("fields"));
        JSONObject optJSONObject = jSONObject.optJSONObject("range");
        if (optJSONObject != null) {
            Date parse2 = this.dKF.parse(optJSONObject.optString("start", ""));
            parse = this.dKF.parse(optJSONObject.optString("end", ""));
            if (parse2 != null) {
                this.dKG = parse2.getTime();
            }
            if (parse != null) {
                this.dKH = parse.getTime();
            }
        }
        parse = this.dKF.parse(jSONObject.optString("current", ""));
        if (parse == null) {
            parse = new Date(System.currentTimeMillis());
        }
        this.dKI = parse.getYear() + 1900;
        this.dKJ = parse.getMonth() + 1;
        this.dKK = parse.getDate();
        com.tencent.mm.plugin.appbrand.k.a.runOnUiThread(new Runnable(this) {
            final /* synthetic */ a dKL;

            {
                this.dKL = r1;
            }

            public final void run() {
                boolean z = true;
                int i = 0;
                a aVar = this.dKL;
                e Tn = aVar.Tn();
                if (Tn == null) {
                    aVar.d("fail", null);
                    return;
                }
                if (Tn.dZu == null || !(Tn.dZu instanceof c)) {
                    Tn.a(new c(Tn.getContext()));
                }
                c cVar = (c) Tn.dZu;
                Tn.dZw = new com.tencent.mm.plugin.appbrand.widget.b.e.a(aVar) {
                    final /* synthetic */ a dKL;

                    {
                        this.dKL = r1;
                    }

                    public final void c(boolean z, String str) {
                        b bVar = this.dKL;
                        if (bVar.dZe != null) {
                            if (!z) {
                                bVar.d("cancel", null);
                            }
                            if (be.kS(str)) {
                                bVar.d("fail", null);
                            } else {
                                Map hashMap = new HashMap(1);
                                hashMap.put(Columns.VALUE, str);
                                bVar.d("ok", hashMap);
                            }
                            bVar.dZe.hide();
                        }
                    }
                };
                cVar.init(aVar.dKI, aVar.dKJ, aVar.dKK, null);
                if (aVar.dKG > 0) {
                    cVar.setMinDate(aVar.dKG);
                }
                if (aVar.dKH > 0) {
                    cVar.setMaxDate(aVar.dKH);
                }
                boolean z2 = aVar.dKF.ordinal() >= a.YEAR.ordinal();
                boolean z3 = aVar.dKF.ordinal() >= a.MONTH.ordinal();
                if (aVar.dKF.ordinal() < a.DAY.ordinal()) {
                    z = false;
                }
                cVar.dZf = z2;
                cVar.dZg = z3;
                cVar.dZh = z;
                if (cVar.dZi != null) {
                    cVar.dZi.setEnabled(z2);
                    cVar.dZi.setVisibility(z2 ? 0 : 8);
                }
                if (cVar.dZj != null) {
                    cVar.dZj.setEnabled(z3);
                    cVar.dZj.setVisibility(z3 ? 0 : 8);
                }
                if (cVar.dZk != null) {
                    cVar.dZk.setEnabled(z);
                    NumberPicker numberPicker = cVar.dZk;
                    if (!z) {
                        i = 8;
                    }
                    numberPicker.setVisibility(i);
                }
                Tn.show();
            }
        });
    }
}
