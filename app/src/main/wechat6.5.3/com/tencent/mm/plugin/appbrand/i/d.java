package com.tencent.mm.plugin.appbrand.i;

import com.tencent.mm.storage.c;

public final class d {
    public static boolean bRN() {
        boolean z;
        c Ls = com.tencent.mm.model.c.c.Au().Ls("100159");
        if (Ls.isValid() && "1".equals(Ls.buX().get("isCloseWeappSearch"))) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        return true;
    }
}
