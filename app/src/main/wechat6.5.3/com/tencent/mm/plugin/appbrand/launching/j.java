package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.vending.j.c;
import java.util.Locale;

final class j extends e<AppBrandSysConfig> {
    final String aWH;
    final int bpD;
    final int dLz;

    public final /* synthetic */ Object call() {
        return QE();
    }

    j(String str, int i, int i2) {
        this.aWH = str;
        this.bpD = i;
        this.dLz = i2;
    }

    public final AppBrandSysConfig QE() {
        boolean z;
        String str = this.aWH;
        if (k.ni(this.aWH)) {
            z = true;
        } else if (this.bpD == 0) {
            String nd = a.OO().nd(this.aWH);
            if (be.kS(nd)) {
                v.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "run(), get appId null, forceSync");
                z = true;
            } else {
                i mN = a.dzP.mN(nd);
                if (mN == null) {
                    v.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "run(), get null manifest record by appId %s, forceSync", new Object[]{nd});
                    z = true;
                } else if (this.dLz > 0 && this.dLz > mN.field_version) {
                    v.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "run(), preferVersion %d, localVersion %d, forceSync", new Object[]{Integer.valueOf(this.dLz), Integer.valueOf(mN.field_version)});
                    z = true;
                } else if (be.kS(mN.field_pkgPath) || !e.aR(mN.field_pkgPath)) {
                    v.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "run(), appId %s, pkgPath [ %s ] invalid, forceSync", new Object[]{nd, mN.field_pkgPath});
                    z = true;
                } else {
                    z = !be.ma(g.aX(mN.field_pkgPath)).equals(mN.field_versionMd5);
                    if (z) {
                        b.deleteFile(mN.field_pkgPath);
                    }
                    v.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "run(), realMd5 = %s , versionMd5 = %s , forceSync = %b", new Object[]{r5, mN.field_versionMd5, Boolean.valueOf(z)});
                }
            }
        } else {
            z = false;
        }
        c I = k.I(str, z);
        if (I.get(0) == null) {
            Object[] objArr = new Object[1];
            objArr[0] = I.get(1) == null ? "" : String.format(Locale.US, "(%d,%d)", new Object[]{Integer.valueOf(((com.tencent.mm.v.a.a) I.get(1)).errType), Integer.valueOf(((com.tencent.mm.v.a.a) I.get(1)).errCode)});
            f.nJ(f.d(2131230967, objArr));
            com.tencent.mm.plugin.appbrand.report.a.S("", 7);
        }
        return (AppBrandSysConfig) I.get(0);
    }
}
