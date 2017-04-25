package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.appbrand.appcache.d;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class k {
    final int bpD;
    final AppBrandSysConfig dLA;
    final int dLp;
    final boolean owg = false;

    public k(AppBrandSysConfig appBrandSysConfig, int i, int i2) {
        this.dLA = appBrandSysConfig;
        this.bpD = i;
        this.dLp = i2;
    }

    public k(AppBrandSysConfig appBrandSysConfig, int i, int i2, byte b) {
        this.dLA = appBrandSysConfig;
        this.bpD = i;
        this.dLp = i2;
    }

    public final boolean QG() {
        String str = this.dLA.appId;
        v.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkBan, appId %s, username %s, runningFlag %d", new Object[]{str, this.dLA.aWH, Long.valueOf(this.dLA.PA())});
        if (1 != this.bpD || (this.dLA.PA() & 256) <= 0) {
            String str2;
            if (2 == this.bpD) {
                if ((this.dLA.PA() & 1024) > 0) {
                    AppBrand404PageUI.show(2131230984);
                    a.S(str, 11);
                    return true;
                }
                boolean z;
                str2 = null;
                i a = com.tencent.mm.plugin.appbrand.a.a.dzP.a(str, this.bpD, new String[]{"versionMd5"});
                if (a != null) {
                    str2 = a.field_versionMd5;
                }
                int QH = new l(str, str2).QH();
                v.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", new Object[]{str, Integer.valueOf(QH), Boolean.valueOf(this.owg)});
                a hf = a.hf(QH);
                if (hf != null) {
                    if (!this.owg) {
                        switch (hf) {
                            case Ok:
                                z = true;
                                break;
                            case Timeout:
                                f.he(2131230925);
                                a.S(str, 13);
                                z = false;
                                break;
                            default:
                                f.he(2131230924);
                                a.S(str, 13);
                                z = false;
                                break;
                        }
                    }
                    z = true;
                } else {
                    switch (QH) {
                        case -13003:
                            f.he(2131230927);
                            a.S(str, 12);
                            z = false;
                            break;
                        case -13002:
                            f.he(2131230926);
                            a.S(str, 13);
                            z = false;
                            break;
                        default:
                            if (!this.owg) {
                                f.nJ(aa.getResources().getString(2131230968, new Object[]{Integer.valueOf(3), Integer.valueOf(QH)}));
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                    }
                }
                if (!z) {
                    return true;
                }
            }
            str2 = null;
            if ((this.dLA.PA() & 512) > 0 && (1013 == this.dLp || 1012 == this.dLp)) {
                str2 = g.mG(str);
            } else if (!d.a.gY(this.bpD)) {
                AppBrand404PageUI.show(2131231003);
                return true;
            } else if (this.bpD != 0) {
                return false;
            } else {
                if (1 == this.dLA.dDG) {
                    AppBrand404PageUI.show(2131230958);
                    a.S(str, 14);
                    return true;
                }
                if ((this.dLA.PA() & 1) > 0) {
                    str2 = g.cw(str, 1);
                }
                if ((this.dLA.PA() & 2) > 0) {
                    str2 = g.cw(str, 0);
                }
                if ((this.dLA.PA() & 4) > 0 && (1007 == this.dLp || 1008 == this.dLp)) {
                    str2 = g.M(str, 1);
                } else if ((this.dLA.PA() & 8) > 0 && 1009 == this.dLp) {
                    str2 = g.M(str, 2);
                } else if ((this.dLA.PA() & 128) > 0 && (1011 == this.dLp || 1012 == this.dLp || 1013 == this.dLp)) {
                    str2 = g.M(str, 3);
                }
            }
            if (be.kS(str2)) {
                return false;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            intent.putExtra("forceHideShare", true);
            intent.putExtra("MMActivity.OverrideEnterAnimation", 2130968641);
            intent.putExtra("MMActivity.OverrideExitAnimation", 0);
            c.b(aa.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            return true;
        }
        AppBrand404PageUI.show(2131230983);
        a.S(str, 9);
        return true;
    }
}
