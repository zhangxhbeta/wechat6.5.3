package com.tencent.mm.plugin.webview.e;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mm.e.a.mh;
import com.tencent.mm.e.a.ml;
import com.tencent.mm.e.a.mm;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    String lgK = null;
    private a lgL;
    private c lgM = new c<mm>(this) {
        final /* synthetic */ d lgP;

        {
            this.lgP = r2;
            this.nhz = mm.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            mm mmVar = (mm) bVar;
            if ((mmVar instanceof mm) && mmVar.bnK.bkU == 1) {
                d.a(this.lgP, this.lgP.lgK);
                d.a(this.lgP);
            }
            return false;
        }
    };
    private c lgN = new c<mh>(this) {
        final /* synthetic */ d lgP;

        {
            this.lgP = r2;
            this.nhz = mh.class.getName().hashCode();
        }

        private boolean a(mh mhVar) {
            if ((mhVar instanceof mh) && "bank".equals(this.lgP.lgK)) {
                if (mhVar.bnu.action == 0) {
                    d.a(this.lgP, this.lgP.lgK);
                } else if (mhVar.bnu.action == 1) {
                    if (be.kS(mhVar.bnu.cardNum)) {
                        d.b(this.lgP, this.lgP.lgK);
                    } else {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bankcard_number", mhVar.bnu.cardNum);
                            d.a(this.lgP, this.lgP.lgK, jSONObject, null);
                        } catch (JSONException e) {
                            v.e("MicroMsg.LicenceScanner", "type = bankcard, add cardNum into json, exp = %s ", new Object[]{e});
                            d.b(this.lgP, this.lgP.lgK);
                        }
                    }
                }
                d.a(this.lgP);
            }
            return false;
        }
    };
    private c lgO = new c<ml>(this) {
        final /* synthetic */ d lgP;

        {
            this.lgP = r2;
            this.nhz = ml.class.getName().hashCode();
        }

        private boolean a(ml mlVar) {
            if ((mlVar instanceof ml) && this.lgP.lgK.equalsIgnoreCase(mlVar.bnF.bnG)) {
                if (mlVar.bnF.bnH == 0) {
                    d.b(this.lgP, this.lgP.lgK);
                } else if (mlVar.bnF.bnH == 2) {
                    d.a(this.lgP, this.lgP.lgK);
                } else {
                    try {
                        if (be.kS(mlVar.bnF.bnI)) {
                            d.a(this.lgP, this.lgP.lgK, null, mlVar.bnF.bnJ);
                        } else {
                            d.a(this.lgP, this.lgP.lgK, new JSONObject(mlVar.bnF.bnI), mlVar.bnF.bnJ);
                        }
                    } catch (Exception e) {
                        v.e("MicroMsg.LicenceScanner", "Failed to parse json string: %s", new Object[]{e.getMessage()});
                        d.b(this.lgP, this.lgP.lgK);
                    }
                }
                d.a(this.lgP);
            }
            return false;
        }
    };

    public interface a {
        void Bj(String str);

        void Ex(String str);

        void a(String str, JSONObject jSONObject, Bitmap bitmap);
    }

    static /* synthetic */ void a(d dVar) {
        dVar.lgL = null;
        com.tencent.mm.sdk.c.a.nhr.f(dVar.lgM);
        com.tencent.mm.sdk.c.a.nhr.f(dVar.lgN);
        com.tencent.mm.sdk.c.a.nhr.f(dVar.lgO);
    }

    static /* synthetic */ void a(d dVar, String str) {
        if (dVar.lgL != null) {
            dVar.lgL.Ex(str);
        }
    }

    static /* synthetic */ void a(d dVar, String str, JSONObject jSONObject, Bitmap bitmap) {
        if (dVar.lgL != null) {
            dVar.lgL.a(str, jSONObject, bitmap);
        }
    }

    static /* synthetic */ void b(d dVar, String str) {
        if (dVar.lgL != null) {
            dVar.lgL.Bj(str);
        }
    }

    public final boolean a(String str, Context context, a aVar) {
        Intent intent;
        if ("bank".equalsIgnoreCase(str)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 7);
            intent.putExtra("scan_bankcard_with_confirm_ui", true);
            intent.addFlags(268435456);
            com.tencent.mm.ay.c.b(context, "scanner", ".ui.BaseScanUI", intent);
            this.lgL = aVar;
            this.lgK = "bank";
            com.tencent.mm.sdk.c.a.nhr.e(this.lgM);
            com.tencent.mm.sdk.c.a.nhr.e(this.lgN);
            return true;
        } else if (!"identity_pay_auth".equalsIgnoreCase(str)) {
            return false;
        } else {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 11);
            com.tencent.mm.ay.c.b(context, "scanner", ".ui.BaseScanUI", intent);
            this.lgL = aVar;
            this.lgK = "identity";
            com.tencent.mm.sdk.c.a.nhr.e(this.lgM);
            com.tencent.mm.sdk.c.a.nhr.e(this.lgO);
            return true;
        }
    }
}
