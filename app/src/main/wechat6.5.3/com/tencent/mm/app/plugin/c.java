package com.tencent.mm.app.plugin;

import com.tencent.mm.h.j;
import com.tencent.mm.sdk.platformtools.be;

public final class c {
    public static boolean oP() {
        if (!com.tencent.mm.ay.c.EH("translate")) {
            return false;
        }
        String value = j.sU().getValue("TranslateMsgOff");
        if (be.kS(value)) {
            return true;
        }
        if (be.KL(value) == 0) {
            return true;
        }
        return false;
    }
}
