package com.tencent.mm.plugin.webview.e;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public static boolean a(WebViewUI webViewUI, int i, int i2, Intent intent) {
        if (2 != i) {
            return false;
        }
        if (-1 == i2 && intent != null) {
            String stringExtra = intent.getStringExtra("selectpkg");
            Bundle bundleExtra = intent.getBundleExtra("transferback");
            boolean booleanExtra = intent.getBooleanExtra("isalways", false);
            v.i("MicroMsg.BrowserChooserHelper", "App Chooser Browser is %s", new Object[]{stringExtra});
            t.bmX();
            p pVar = (p) t.o(0, null);
            Intent intent2;
            if (pVar.Gn(stringExtra)) {
                if (pVar.dc(webViewUI)) {
                    p.aL(webViewUI, bundleExtra.getString("targeturl"));
                } else {
                    intent2 = new Intent((Intent) bundleExtra.getParcelable("targetintent"));
                    intent2.setPackage(stringExtra);
                    intent2.addFlags(524288);
                    webViewUI.startActivity(intent2);
                }
                if (booleanExtra) {
                    g.iuh.h(10998, new Object[]{Integer.valueOf(4), Integer.valueOf(2)});
                } else {
                    g.iuh.h(10998, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
                }
            } else {
                intent2 = new Intent((Intent) bundleExtra.getParcelable("targetintent"));
                intent2.setPackage(stringExtra);
                intent2.addFlags(524288);
                webViewUI.startActivity(intent2);
                g.iuh.h(10998, new Object[]{Integer.valueOf(5)});
                if (booleanExtra) {
                    g.iuh.h(10998, new Object[]{Integer.valueOf(5), Integer.valueOf(2)});
                } else {
                    g.iuh.h(10998, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
                }
            }
        }
        return true;
    }
}
