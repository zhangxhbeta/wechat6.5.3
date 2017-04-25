package com.tencent.mm.modelsearch;

import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.c;

public final class e {
    public static boolean y(String str, int i) {
        if (!ak.uz()) {
            return false;
        }
        c Ls = com.tencent.mm.model.c.c.Au().Ls("100065");
        return Ls.isValid() ? be.getInt((String) Ls.buX().get(str), i) > 0 : i > 0;
    }
}
