package com.tencent.mm.plugin.emoji.d;

import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.ae.a.a.c.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class g {
    private static final c fbd;

    public static c bl(String str, String str2) {
        return a(str, str2, new Object[0]);
    }

    public static c a(String str, String str2, Object... objArr) {
        ak.yW();
        String z = EmojiLogic.z(com.tencent.mm.model.c.wY(), str, str2);
        if (be.kS(z)) {
            v.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.cPq = true;
        aVar.cPs = true;
        aVar.cPu = z;
        aVar.cPT = objArr;
        return aVar.GU();
    }

    public static c n(String str, String str2, int i) {
        ak.yW();
        String z = EmojiLogic.z(com.tencent.mm.model.c.wY(), str, str2);
        if (be.kS(z)) {
            v.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.cPq = true;
        aVar.cPs = true;
        aVar.cPu = z;
        aVar.cPz = i;
        aVar.cPy = i;
        return aVar.GU();
    }

    public static c aeY() {
        a aVar = new a();
        aVar.cPq = true;
        aVar.cPs = false;
        aVar.cPx = 3;
        return aVar.GU();
    }

    public static c b(String str, String str2, Object... objArr) {
        ak.yW();
        String xq = com.tencent.mm.model.c.xq();
        ak.yW();
        String z = EmojiLogic.z(com.tencent.mm.model.c.wY(), str, str2);
        if (be.kS(z)) {
            v.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.cPq = true;
        aVar.cPs = true;
        aVar.cPu = z;
        aVar.cPv = xq;
        aVar.cPT = objArr;
        return aVar.GU();
    }

    static {
        a aVar = new a();
        aVar.cPq = true;
        aVar.cPx = 1;
        aVar.cPO = false;
        fbd = aVar.GU();
    }

    public static c c(String str, Object... objArr) {
        if (be.kS(str)) {
            v.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.cPs = true;
        aVar.cPu = str;
        aVar.cPT = objArr;
        return aVar.GU();
    }

    public static c f(String str, Object... objArr) {
        if (be.kS(str)) {
            v.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.cPs = true;
        aVar.cPu = str;
        aVar.cPS = false;
        aVar.cPT = objArr;
        return aVar.GU();
    }

    public static c a(String str, int i, Object... objArr) {
        if (be.kS(str)) {
            v.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.cPs = true;
        aVar.cPu = str;
        aVar.cPz = i;
        aVar.cPy = i;
        aVar.cPT = objArr;
        return aVar.GU();
    }

    public static c bm(String str, String str2) {
        ak.yW();
        String z = EmojiLogic.z(com.tencent.mm.model.c.wY(), str, str2);
        if (be.kS(z)) {
            v.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.cPq = true;
        aVar.cPs = true;
        aVar.cPu = z;
        aVar.cPP = true;
        return aVar.GU();
    }

    public static c c(String str, String str2, Object... objArr) {
        ak.yW();
        String z = EmojiLogic.z(com.tencent.mm.model.c.wY(), str, str2);
        if (be.kS(z)) {
            v.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.cPq = false;
        aVar.cPs = true;
        aVar.cPu = z;
        aVar.cPT = objArr;
        return aVar.GU();
    }

    public static c g(String str, String str2, Object... objArr) {
        ak.yW();
        String z = EmojiLogic.z(com.tencent.mm.model.c.wY(), str, str2);
        if (be.kS(z)) {
            v.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.cPq = true;
        aVar.cPs = true;
        aVar.cPu = z;
        aVar.cPT = objArr;
        return aVar.GU();
    }
}
