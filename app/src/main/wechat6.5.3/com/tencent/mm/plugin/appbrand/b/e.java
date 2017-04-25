package com.tencent.mm.plugin.appbrand.b;

import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.appbrand.config.j;
import com.tencent.mm.sdk.platformtools.be;

public final class e {

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String aSi;
        final /* synthetic */ int dzu;

        public AnonymousClass1(String str, int i) {
            this.aSi = str;
            this.dzu = i;
        }

        public final void run() {
            String str;
            String str2 = this.aSi;
            int i = this.dzu;
            a.dzP.cx(str2, i);
            j OO = a.OO();
            if (be.kS(str2)) {
                str = "";
            } else {
                Cursor query = OO.dBf.query("AppBrandWxaAppInfo", new String[]{"brandId"}, String.format("%s=?", new Object[]{"appId"}), new String[]{str2}, null, null, null);
                if (query == null) {
                    str = "";
                } else {
                    str = "";
                    if (query.moveToFirst()) {
                        str = query.getString(0);
                    }
                    query.close();
                }
            }
            a.OO().wT(str);
            if (i == 0) {
                a.dzM.clear(str2);
            }
        }
    }
}
