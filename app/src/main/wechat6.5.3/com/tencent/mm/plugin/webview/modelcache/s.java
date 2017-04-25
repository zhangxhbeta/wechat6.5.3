package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.plugin.report.service.g;

public final class s {
    public static void sK(int i) {
        int i2;
        if (2 == i) {
            i2 = 11;
        } else if (1 == i) {
            i2 = 10;
        } else {
            i2 = -1;
        }
        if (-1 != i2) {
            g.iuh.a(238, (long) i2, 1, false);
        }
    }

    public static void dv(long j) {
        g.iuh.a(238, j, 1, false);
    }

    public static void h(int i, Object... objArr) {
        g.iuh.h(i, objArr);
    }
}
