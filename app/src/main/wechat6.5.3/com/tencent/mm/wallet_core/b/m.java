package com.tencent.mm.wallet_core.b;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class m {
    private static long eEP = 0;
    private static String kNT = "";

    public static void setTimeStamp(String str) {
        kNT = str;
        eEP = System.currentTimeMillis() / 1000;
    }

    public static boolean bLe() {
        long ax = be.ax(eEP);
        v.d("MicroMsg.TimeStampHelper", "pass time " + ax);
        return ax > 300;
    }

    public static String bLf() {
        return kNT;
    }
}
