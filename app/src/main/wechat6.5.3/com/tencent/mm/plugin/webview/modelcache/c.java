package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;

public final class c {
    private static final String lfw = "100052";

    public static boolean biH() {
        if (!ak.uz()) {
            return false;
        }
        com.tencent.mm.storage.c Ls = com.tencent.mm.model.c.c.Au().Ls(lfw);
        if (Ls.isValid()) {
            return be.getInt((String) Ls.buX().get("enableCache"), 0) > 0;
        } else {
            return false;
        }
    }

    public static boolean biI() {
        if (!ak.uz()) {
            return false;
        }
        com.tencent.mm.storage.c Ls = com.tencent.mm.model.c.c.Au().Ls(lfw);
        if (Ls.isValid()) {
            return be.getInt((String) Ls.buX().get("enableBrandPrePush"), 0) > 0;
        } else {
            return false;
        }
    }
}
