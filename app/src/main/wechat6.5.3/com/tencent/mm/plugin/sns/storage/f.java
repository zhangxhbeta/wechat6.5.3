package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.plugin.sns.e.ad;

public final class f {
    public static k Bp(String str) {
        if (s.zG(str)) {
            return ad.aSE().dd(s.BK(str));
        }
        c cV = ad.aSF().cV(s.BK(str));
        if (cV != null) {
            return cV.aUr();
        }
        return null;
    }

    public static boolean a(String str, k kVar) {
        if (s.zG(str)) {
            return ad.aSE().b(s.BK(str), kVar);
        }
        return ad.aSF().b(s.BK(str), kVar.aUS());
    }

    public static k Bq(String str) {
        if (s.zG(str)) {
            return ad.aSE().qG(s.BL(str));
        }
        c qB = ad.aSF().qB(s.BL(str));
        if (qB != null) {
            return qB.aUr();
        }
        return null;
    }
}
