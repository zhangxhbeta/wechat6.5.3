package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.protocal.c.ol;

public final class e {
    public static boolean a(ol olVar) {
        if (olVar == null) {
            return false;
        }
        return bx(olVar.mqi, 1);
    }

    public static boolean b(ol olVar) {
        if (!(olVar == null ? false : bx(olVar.mqh, 4))) {
            if (!(olVar == null ? false : bx(olVar.mqh, 8))) {
                return false;
            }
        }
        return true;
    }

    public static boolean jL(int i) {
        return bx(i, 4) || bx(i, 8);
    }

    public static boolean bx(int i, int i2) {
        return (i & i2) == i2;
    }
}
