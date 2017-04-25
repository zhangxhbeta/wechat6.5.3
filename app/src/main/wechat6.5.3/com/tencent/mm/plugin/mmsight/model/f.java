package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.sdk.platformtools.ad;

public final class f {
    private static ad hnp = new ad("MMSightHandler");

    public static void q(Runnable runnable) {
        hnp.x(runnable);
    }

    public static void r(Runnable runnable) {
        hnp.f(runnable, 2000);
    }
}
