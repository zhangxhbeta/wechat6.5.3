package com.tencent.mm.modelsns;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.c;

public final class b {
    public static int cZO = 0;
    public static b cZP = new b();

    public static void JG() {
        c Ls = com.tencent.mm.model.c.c.Au().Ls("100024");
        v.i("MicroMsg.StatisticsOplogAbTest", "test " + Ls.field_rawXML + " " + Ls.isValid());
        if (Ls.isValid()) {
            cZO = be.KL((String) Ls.buX().get("Switch"));
            v.i("MicroMsg.StatisticsOplogAbTest", "switchVal " + cZO);
        }
    }
}
