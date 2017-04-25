package com.tencent.mm.plugin.appbrand.launching;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;

enum f {
    ;

    static void he(int i) {
        nJ(aa.getResources().getString(i));
    }

    static void nJ(final String str) {
        ad.o(new Runnable() {
            public final void run() {
                Toast.makeText(aa.getContext(), str, 0).show();
            }
        });
    }

    static String d(int i, Object... objArr) {
        return a.d(i, objArr);
    }
}
