package com.tencent.mm.plugin.soter_mp.b;

import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.z;

public final class d {
    private static String kek = "";

    public static final String aYZ() {
        if (be.kS(kek)) {
            kek = "WeChat_SOTERMP_" + z.Kg(k.xF());
        }
        return kek;
    }
}
