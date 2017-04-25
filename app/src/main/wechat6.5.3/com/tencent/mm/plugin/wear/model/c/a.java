package com.tencent.mm.plugin.wear.model.c;

import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class a {
    public static final void cL(int i, int i2) {
        if (com.tencent.mm.plugin.wear.model.a.bhH().laR.lbj.lcb != null) {
            v.v("MicroMsg.Wear.ReportKVUtil", "report kv operation=%d scene=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            g.iuh.h(11632, new Object[]{Integer.valueOf(i), r0.eeB, r0.ncs, Integer.valueOf(i2)});
        }
    }

    public static final void sy(int i) {
        g.iuh.a(249, (long) i, 1, false);
    }

    public static final void ht(boolean z) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(249);
        iDKey.SetKey(12);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            iDKey = new IDKey();
            iDKey.SetID(249);
            iDKey.SetKey(13);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        g gVar = g.iuh;
        g.d(arrayList, false);
    }
}
