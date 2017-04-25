package com.tencent.mm.h;

import com.tencent.mm.sdk.platformtools.be;

public final class g {
    public static boolean sX() {
        String value = j.sU().getValue("LinkedinAddContactClose");
        if (be.kS(value) || Integer.valueOf(value).intValue() != 1) {
            return true;
        }
        return false;
    }
}
