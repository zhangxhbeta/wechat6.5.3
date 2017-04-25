package com.tencent.mm.plugin.appbrand.launching;

import android.net.Uri;
import com.tencent.mm.e.a.ol;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class b extends c<ol> {
    public b() {
        this.nhz = ol.class.getName().hashCode();
    }

    private static boolean a(ol olVar) {
        if (!be.kS(olVar.bpK.bpL)) {
            Uri parse;
            try {
                parse = Uri.parse(olVar.bpK.bpL);
            } catch (Exception e) {
                v.e("MicroMsg.AppBrandLaunchFromSpecificNativeLinkEventListener", "handle nativeLink = %s, exp = %s", new Object[]{r2, e});
                parse = null;
            }
            if (parse != null) {
                v.i("MicroMsg.AppBrandLaunchFromSpecificNativeLinkEventListener", "handle nativeLink = %s", new Object[]{r2});
                String queryParameter = parse.getQueryParameter("username");
                if (!be.kS(queryParameter) && queryParameter.endsWith("@app")) {
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = olVar.bpK.scene;
                    AppBrandLaunchingLogic.a(null, queryParameter, null, 0, -1, appBrandStatObject);
                }
            }
        }
        return true;
    }
}
