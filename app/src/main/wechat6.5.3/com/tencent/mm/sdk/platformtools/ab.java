package com.tencent.mm.sdk.platformtools;

import java.util.HashSet;
import java.util.Set;

public final class ab {
    private static Set<String> niF = new HashSet();

    public static boolean Ki(String str) {
        if (Kk(str)) {
            v.d("MicroMsg.MMEntryLock", "locked-" + str);
            return false;
        }
        v.d("MicroMsg.MMEntryLock", "lock-" + str);
        return niF.add(str);
    }

    public static void Kj(String str) {
        niF.remove(str);
        v.d("MicroMsg.MMEntryLock", "unlock-" + str);
    }

    public static boolean Kk(String str) {
        return niF.contains(str);
    }
}
