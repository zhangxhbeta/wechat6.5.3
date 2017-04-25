package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import com.tencent.mm.e.a.jg;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchingLogic;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.AppBrandTaskManager;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.net.URLDecoder;

public final class a extends c<jg> {
    public a() {
        this.nhz = jg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jg jgVar = (jg) bVar;
        if (!(jgVar == null || be.kS(jgVar.bjL.url))) {
            String queryParameter;
            v.i("MicroMsg.AppBrand.QRCodeRedirectURLHandler", "get url = %s", new Object[]{jgVar.bjL.url});
            Uri parse = Uri.parse(queryParameter);
            String queryParameter2;
            if ((be.getInt(parse.getQueryParameter("debug"), 0) > 0 ? 1 : null) != null) {
                int i = be.getInt(parse.getQueryParameter("ret"), 0);
                if (i == 1) {
                    AppBrand404PageUI.show(2131230979);
                    com.tencent.mm.plugin.appbrand.report.a.S("", 4);
                } else if (i == 2) {
                    AppBrand404PageUI.os(aa.getContext().getString(2131230978));
                    com.tencent.mm.plugin.appbrand.report.a.S("", 3);
                } else {
                    queryParameter2 = parse.getQueryParameter("appid");
                    String queryParameter3 = parse.getQueryParameter("username");
                    String decode = URLDecoder.decode(be.ma(parse.getQueryParameter("path")));
                    String queryParameter4 = parse.getQueryParameter("codeurl");
                    String queryParameter5 = parse.getQueryParameter("md5");
                    long j = be.getLong(parse.getQueryParameter("test_lifespan"), 7200);
                    if (be.kS(queryParameter2) || be.kS(queryParameter3) || be.kS(queryParameter4)) {
                        v.i("MicroMsg.AppBrand.QRCodeRedirectURLHandler", "appId = %s, username = %s, codeURL = %s, invalid, return", new Object[]{queryParameter2, queryParameter3, queryParameter4});
                        AppBrand404PageUI.show(2131230988);
                        com.tencent.mm.plugin.appbrand.report.a.S(queryParameter2, 2);
                    } else {
                        if (com.tencent.mm.plugin.appbrand.a.a.dzP.a(queryParameter2, 1, queryParameter4, queryParameter5, 0, j + be.Nh())) {
                            AppBrandTaskManager.ab(queryParameter2, 1);
                        }
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        appBrandStatObject.scene = jgVar.bjL.scene;
                        appBrandStatObject.aWP = jgVar.bjL.url;
                        AppBrandLaunchingLogic.a(aa.getContext(), queryParameter3, decode, 1, -1, appBrandStatObject);
                    }
                }
            } else {
                queryParameter = parse.getQueryParameter("username");
                queryParameter2 = URLDecoder.decode(be.ma(parse.getQueryParameter("path")));
                int i2 = be.getInt(parse.getQueryParameter("version"), 0);
                if (be.kS(queryParameter)) {
                    v.i("MicroMsg.AppBrand.QRCodeRedirectURLHandler", "username = %s, invalid, return", new Object[]{queryParameter});
                    AppBrand404PageUI.show(2131230988);
                    com.tencent.mm.plugin.appbrand.report.a.S("", 2);
                } else {
                    AppBrandStatObject appBrandStatObject2 = new AppBrandStatObject();
                    appBrandStatObject2.scene = jgVar.bjL.scene;
                    appBrandStatObject2.aWP = jgVar.bjL.url;
                    AppBrandLaunchingLogic.a(queryParameter, queryParameter2, i2, appBrandStatObject2);
                }
            }
        }
        return true;
    }
}
