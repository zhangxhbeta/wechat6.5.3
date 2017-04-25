package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class e {
    private static final Set<String> dAp;

    static {
        Set hashSet = new HashSet();
        hashSet.add("/WAService.js");
        hashSet.add("/WAVConsole.js");
        hashSet.add("/WAWebview.js");
        dAp = Collections.unmodifiableSet(hashSet);
    }

    static InputStream openRead(String str) {
        String mJ = c.mJ(str);
        if (dAp.contains(mJ)) {
            try {
                return aa.getContext().getAssets().open("wxa_library" + mJ);
            } catch (Throwable e) {
                v.e("MicroMsg.AppBrand.WxaLocalLibPkg", "openRead file( %s ) failed, exp = %s", new Object[]{mJ, be.e(e)});
            }
        }
        return null;
    }

    public static WxaPkgWrappingInfo OR() {
        WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
        wxaPkgWrappingInfo.dBz = true;
        wxaPkgWrappingInfo.dBs = 30;
        wxaPkgWrappingInfo.dBu = true;
        return wxaPkgWrappingInfo;
    }
}
