package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.page.AppBrandPageActionSheet.c;

public enum j {
    ;

    public interface a {
        void a(c cVar, boolean z);

        boolean a(c cVar);
    }

    public static void a(String str, a aVar) {
        AppBrandSysConfig mr = a.mr(str);
        if (mr != null) {
            aVar.a(c.AboutUs, mr.dDB.dBr != 0);
            int i = a.ms(str).scene;
            if (!aVar.a(c.SendToDesktop)) {
                if (i == 1023) {
                    aVar.a(c.SendToDesktop, true);
                } else {
                    aVar.a(c.SendToDesktop, false);
                }
            }
            if (mr.dDB.dBr == 0 && (mr.PA() & 32) > 0) {
                aVar.a(c.ShareAppMsg, true);
            }
        }
    }
}
