package com.tencent.mm.plugin.appbrand.widget.b;

import com.tencent.mm.sdk.platformtools.be;

public final class i {
    public static boolean hM(int i) {
        return i >= 0 && i <= 59;
    }

    public static boolean hN(int i) {
        return i >= 0 && i <= 23;
    }

    public static int[] oP(String str) {
        if (be.kS(str)) {
            return null;
        }
        String[] split = str.split(":");
        if (split == null || split.length != 2) {
            return null;
        }
        int oQ = oQ(split[0]);
        int oQ2 = oQ(split[1]);
        if (!hN(oQ) || !hM(oQ2)) {
            return null;
        }
        return new int[]{oQ, oQ2};
    }

    private static int oQ(String str) {
        try {
            return Integer.parseInt(str, 10);
        } catch (Exception e) {
            return -1;
        }
    }
}
