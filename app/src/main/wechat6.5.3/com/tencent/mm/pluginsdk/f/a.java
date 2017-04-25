package com.tencent.mm.pluginsdk.f;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    private static int lyL = -1;
    private static int lyM = -1;

    public static void tr(int i) {
        lyL = i;
    }

    public static void bmI() {
        if (lyL == -1) {
            v.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            return;
        }
        g.iuh.h(12925, new Object[]{Integer.valueOf(lyL)});
    }

    public static void bmJ() {
        if (lyL == -1) {
            v.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            return;
        }
        g.iuh.h(12926, new Object[]{Integer.valueOf(lyL)});
    }

    public static void b(int i, int i2, int i3, String str) {
        if (lyL == -1) {
            v.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            return;
        }
        g.iuh.h(13413, new Object[]{Integer.valueOf(lyL), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
    }

    public static void bmK() {
        lyM = (int) (System.currentTimeMillis() / 1000);
    }

    public static void ts(int i) {
        if (lyM == -1) {
            v.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
            return;
        }
        g.iuh.h(12927, new Object[]{Integer.valueOf(lyM), Integer.valueOf(i)});
        lyL = -1;
    }

    public static boolean bmL() {
        return lyL >= 0;
    }
}
