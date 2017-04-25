package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

class n implements a {
    final int aZt = (n.class.hashCode() & 65535);
    final String appId;

    void onReady() {
    }

    void RU() {
    }

    void azS() {
        c.b(aa.getContext(), "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", g.mI(this.appId)).putExtra("showShare", false).putExtra("show_bottom", false).putExtra("isWebwx", false).addFlags(268435456));
        com.tencent.mm.plugin.report.service.g.iuh.a(366, 8, 1, false);
    }

    n(String str) {
        this.appId = str;
    }

    final void j(MMActivity mMActivity) {
        long Ni = be.Ni();
        v.d("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check tbs download, cost = %d, cheTBSRet = %d", new Object[]{Long.valueOf(be.Ni() - Ni), Integer.valueOf(com.tencent.mm.pluginsdk.model.v.a.bnc())});
        switch (com.tencent.mm.pluginsdk.model.v.a.bnc()) {
            case 0:
                v.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check(Activity), onReady");
                onReady();
                return;
            case 1:
                v.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check(Activity), goProxyUI");
                if (mMActivity != null && !mMActivity.isFinishing()) {
                    Intent putExtra = new Intent().putExtra("intent_extra_download_ignore_network_type", true);
                    mMActivity.nDS = this;
                    c.b(mMActivity, "appbrand", ".ui.AppBrandTBSDownloadProxyUI", putExtra, this.aZt);
                    return;
                }
                return;
            case 2:
                v.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check(Activity), dealCannotDownload");
                aPj();
                return;
            default:
                return;
        }
    }

    private void aPj() {
        if (d.dW(17)) {
            onReady();
        } else {
            azS();
        }
    }

    public final void a(int i, int i2, Intent intent) {
        if (this.aZt == i) {
            if (i2 == -1) {
                v.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "onActivityResult, tbs download ok");
                onReady();
            } else if (i2 == 2) {
                v.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "onActivityResult, tbs cancel loading, download in background");
                RU();
            } else {
                v.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "onActivityResult, tbs download unknown error, resultCode = %d, apiLevel = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(VERSION.SDK_INT)});
                aPj();
            }
        }
    }
}
