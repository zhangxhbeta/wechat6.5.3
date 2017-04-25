package com.tencent.mm.app;

import android.app.Application;
import com.tencent.mm.R;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.svg.b.e;
import com.tencent.mm.svg.c.c.a;

public final class k {
    public static void a(Application application) {
        boolean z = true;
        v.i("MicroMsg.SVGInit", "SVG initSVGPreload");
        e.a(new a() {
            public final void i(String str, String str2, Object... objArr) {
                v.i(str, str2, objArr);
            }

            public final void e(String str, String str2, Object... objArr) {
                v.e(str, str2, objArr);
            }

            public final void d(String str, String str2, Object... objArr) {
                v.d(str, str2, objArr);
            }

            public final void a(String str, Throwable th, String str2, Object... objArr) {
                v.a(str, th, str2, objArr);
            }
        });
        e.p(R.a.class);
        e.e(application);
        try {
            boolean z2 = application.getBaseContext().getResources().getDrawable(2131165197) != null;
            b vH = b.vH();
            if (z2) {
                z = false;
            }
            vH.clt = z;
        } catch (Throwable th) {
            v.a("MicroMsg.SVGInit", th, "not support get svg from application context", new Object[0]);
        } finally {
            b.vH().clt = true;
        }
    }
}
