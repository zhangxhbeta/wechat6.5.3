package com.tencent.mm.ui.contact;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class t {

    public interface a {
        boolean aMM();

        int bHR();

        int bHS();

        int bHT();

        boolean bHU();

        boolean bHV();

        int bwF();

        String getQuery();
    }

    public static final void h(String str, int i, int i2, int i3) {
        if (!be.kS(str)) {
            v.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", String.format("%s,%d,%d,%d,%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0)}));
            g.iuh.Y(13234, r0);
        }
    }
}
