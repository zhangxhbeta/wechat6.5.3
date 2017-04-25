package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ay.c;
import com.tencent.mm.h.j;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

final class m {
    final String appId;

    m(String str) {
        this.appId = str;
    }

    final boolean aBC() {
        if (j.sU().getInt("WeAppForbiddenSwitch", 0) != 1) {
            return false;
        }
        v.i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", new Object[]{this.appId});
        Intent putExtra = new Intent().putExtra("rawUrl", g.mE(this.appId)).putExtra("forceHideShare", true);
        Context context = aa.getContext();
        if (!(context instanceof Activity)) {
            putExtra.addFlags(268435456);
        }
        c.b(context, "webview", ".ui.tools.WebViewUI", putExtra);
        return true;
    }
}
