package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class d {
    public static int hzf = 0;
    public static int hzg = 0;
    public static int hzh = 0;
    public static int hzi = 0;
    public static int hzj = 0;

    public static final void a(boolean z, long j, String str) {
        int i;
        v.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectSuccess %b %d %s", new Object[]{Boolean.valueOf(z), Long.valueOf(j), str});
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        g.iuh.h(12725, new Object[]{Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(j), str});
    }

    public static final void a(boolean z, long j, String str, int i) {
        int i2;
        v.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectFail %b %d %s %d", new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, Integer.valueOf(i)});
        if (z) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        g.iuh.h(12725, new Object[]{Integer.valueOf(2), Integer.valueOf(i2), Long.valueOf(j), str, Integer.valueOf(i)});
    }

    public static final void aBW() {
        v.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailSuccess");
        g.iuh.h(12722, new Object[]{Integer.valueOf(1)});
    }

    public static final void aBX() {
        v.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailFail");
        g.iuh.h(12722, new Object[]{Integer.valueOf(2)});
    }

    public static final void S(int i, String str) {
        v.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkReceiveCall %d %s", new Object[]{Integer.valueOf(i), str});
        g.iuh.h(12723, new Object[]{Integer.valueOf(i), str});
    }

    public static final void h(long j, String str) {
        v.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMutliTalkDuration %d %s", new Object[]{Long.valueOf(j), str});
        g.iuh.h(12726, new Object[]{Long.valueOf(j), str});
    }

    public static final void a(int i, boolean z, int i2, String str, int i3) {
        int i4;
        v.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkSelectContact %d %b %d %s %d", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3)});
        if (z) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        g.iuh.h(12727, new Object[]{Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(i3)});
    }

    public static final void i(long j, String str) {
        long j2 = j > 1000 ? j / 1000 : 1;
        v.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkVideoDuration %d %s", new Object[]{Long.valueOf(j2), str});
        g.iuh.h(12728, new Object[]{Long.valueOf(j2), str});
    }

    public static final void wE(String str) {
        v.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkFunction %s %d %d %d %d %d", new Object[]{str, Integer.valueOf(hzf), Integer.valueOf(hzg), Integer.valueOf(hzh), Integer.valueOf(hzi), Integer.valueOf(hzj)});
        g.iuh.h(12729, new Object[]{str, Integer.valueOf(hzf), Integer.valueOf(hzg), Integer.valueOf(hzh), Integer.valueOf(hzi), Integer.valueOf(hzj)});
        bX(9, hzf);
        bX(10, hzj);
        bX(11, hzg);
        bX(12, hzh);
        bX(13, hzi);
        hzf = 0;
        hzg = 0;
        hzh = 0;
        hzi = 0;
        hzj = 0;
    }

    public static final void b(String str, boolean z, boolean z2) {
        if (z && z2) {
            g.iuh.h(12917, new Object[]{str, Integer.valueOf(2), Integer.valueOf(1)});
        } else if (z) {
            g.iuh.h(12917, new Object[]{str, Integer.valueOf(2), Integer.valueOf(2)});
        } else if (z2) {
            g.iuh.h(12917, new Object[]{str, Integer.valueOf(1), Integer.valueOf(1)});
        } else {
            g.iuh.h(12917, new Object[]{str, Integer.valueOf(1), Integer.valueOf(2)});
        }
    }

    public static final void aBY() {
        g.iuh.a(220, 0, 1, false);
    }

    public static final void ez(boolean z) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(3);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            iDKey = new IDKey();
            iDKey.SetID(220);
            iDKey.SetKey(4);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        g gVar = g.iuh;
        g.d(arrayList, false);
    }

    public static final void aBZ() {
        g.iuh.a(220, 1, 1, false);
    }

    public static final void eA(boolean z) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(5);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            iDKey = new IDKey();
            iDKey.SetID(220);
            iDKey.SetKey(6);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        g gVar = g.iuh;
        g.d(arrayList, false);
    }

    public static final void nm(int i) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(7);
        iDKey.SetValue(i);
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(8);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        g gVar = g.iuh;
        g.d(arrayList, false);
    }

    private static void bX(int i, int i2) {
        g.iuh.a(220, (long) i, (long) i2, false);
    }
}
