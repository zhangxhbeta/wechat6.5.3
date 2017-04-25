package com.tencent.mm.plugin.emoji.h;

import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.protocal.c.ol;

public final class a {
    public static boolean agV() {
        return g.afx().fci.bxm();
    }

    public static boolean d(ol olVar) {
        return olVar == null ? false : rX(olVar.mdM);
    }

    public static boolean b(com.tencent.mm.storage.a.a aVar) {
        return aVar == null ? false : rX(aVar.field_productID);
    }

    public static boolean rX(String str) {
        return str == null ? false : str.equals(ail());
    }

    public static final String ail() {
        return com.tencent.mm.storage.a.a.nwJ;
    }
}
