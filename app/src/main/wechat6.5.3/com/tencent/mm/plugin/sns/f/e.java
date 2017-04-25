package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.c;

public final class e {
    public static void AV(String str) {
        v.i("MicroMsg.SnsABTestStrategy", "dump id " + str);
        c Ls = com.tencent.mm.model.c.c.Au().Ls(str);
        if (!Ls.isValid()) {
            v.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
        }
        if (Ls.buX() != null) {
            v.i("MicroMsg.SnsABTestStrategy", "dump feed abtest " + Ls.field_rawXML);
        }
    }
}
