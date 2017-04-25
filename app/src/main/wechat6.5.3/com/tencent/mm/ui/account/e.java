package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

public final class e {

    static class AnonymousClass1 implements c {
        final /* synthetic */ int kMO;
        final /* synthetic */ Context val$context;

        AnonymousClass1(int i, Context context) {
            this.kMO = i;
            this.val$context = context;
        }

        public final void a(l lVar) {
            if ((this.kMO & 1) != 0) {
                lVar.d(1, this.val$context.getString(2131234374));
            }
            if ((this.kMO & 2) != 0) {
                lVar.d(2, this.val$context.getString(2131234375));
            }
            if ((this.kMO & 4) != 0) {
                lVar.d(4, this.val$context.getString(2131234373));
            }
            if ((this.kMO & 8) > 0) {
                lVar.d(8, this.val$context.getString(2131233558));
            }
        }
    }

    static class AnonymousClass2 implements d {
        final /* synthetic */ String nIx = null;
        final /* synthetic */ String nIy = null;
        final /* synthetic */ String nIz = null;
        final /* synthetic */ Context val$context;

        AnonymousClass2(Context context, String str, String str2, String str3) {
            this.val$context = context;
        }

        public final void c(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 1:
                    b.mi("F100_100_QQ");
                    b.b(true, ak.uR() + "," + this.val$context.getClass().getName() + ",F100_100_QQ," + ak.dR("F100_100_QQ") + ",1");
                    e.h(this.val$context, this.val$context.getString(2131235737), false);
                    return;
                case 2:
                    b.mi("F100_100_Email");
                    b.b(true, ak.uR() + "," + this.val$context.getClass().getName() + ",F100_100_Email," + ak.dR("F100_100_Email") + ",1");
                    e.h(this.val$context, this.val$context.getString(2131235736), false);
                    return;
                case 4:
                    e.f(this.val$context, this.nIx, this.nIy, this.nIz);
                    return;
                case 8:
                    String string = this.val$context.getString(2131236652);
                    if (u.bsY().equals("zh_CN")) {
                        string = string + "zh_CN";
                    } else {
                        string = "https://help.wechat.com/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=";
                    }
                    e.h(this.val$context, string, false);
                    return;
                default:
                    return;
            }
        }
    }

    public static void h(Context context, String str, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
        intent.putExtra("KFromLoginHistory", false);
        com.tencent.mm.ay.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    public static void f(Context context, String str, String str2, String str3) {
        b.mi("F100_100_phone");
        b.b(true, ak.uR() + "," + context.getClass().getName() + ",F100_100_phone," + ak.dR("F100_100_phone") + ",1");
        if (com.tencent.mm.protocal.d.lWk) {
            Toast.makeText(context, context.getString(2131230894), 0).show();
            return;
        }
        Intent intent = new Intent(context, MobileInputUI.class);
        if (str2 != null) {
            int indexOf = str2.indexOf("+");
            if (indexOf != -1 && str2.length() > 0) {
                str2 = str2.substring(indexOf + 1);
            }
            intent.putExtra("couttry_code", str2);
        }
        if (str != null) {
            intent.putExtra("country_name", str);
        }
        if (str3 != null) {
            intent.putExtra("bindmcontact_shortmobile", str3);
        }
        intent.putExtra("mobile_input_purpose", 1);
        context.startActivity(intent);
    }

    public static void V(Context context, int i) {
        String str = be.dW(context) + "_" + System.currentTimeMillis();
        v.d("MicroMsg.ForgotPwdMenu", "cpan showProblemH5 randomID:%s", str);
        String string = context.getString(2131233554);
        if (u.bsY().equals("zh_CN")) {
            string = string + "zh_CN";
        } else if (u.bsY().equals("zh_TW") || u.bsY().equals("zh_HK")) {
            string = string + "zh_TW";
        } else {
            string = string + "en";
        }
        h(context, string + "&rid=" + str, false);
        g.iuh.h(11930, str, Integer.valueOf(i));
        aa.getContext().getSharedPreferences("randomid_prefs", 4).edit().putString("randomID", str).commit();
    }
}
