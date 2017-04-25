package com.tencent.mm.modelsearch;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class l {
    private static a cWg = new a();

    public static class a {
        int cWh;
        long cWi;
        long cWj;
        long cWk;
        long cWl;
        boolean cWm = true;
        int scene;
    }

    public static void r(int i, String str) {
        g.iuh.Y(i, str);
    }

    public static void a(int i, String str, boolean z, boolean z2, int i2) {
        int i3;
        if (z) {
            i3 = 3;
        } else if (z2) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        g.iuh.h(12042, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(i2), be.ah(str, "").replace(",", " ")});
    }

    public static void fY(int i) {
        cWg.scene = i;
        cWg.cWh = 1;
        cWg.cWi = System.currentTimeMillis();
        cWg.cWj = 0;
        cWg.cWk = System.currentTimeMillis();
        cWg.cWl = 0;
        cWg.cWm = false;
        v.v("MicroMsg.FTS.FTSWebReportLogic", "initReport %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(1)});
    }

    public static void Im() {
        cWg.cWi = System.currentTimeMillis();
        v.v("MicroMsg.FTS.FTSWebReportLogic", "startH5Report %s", new Object[]{Long.valueOf(cWg.cWi)});
    }

    public static void In() {
        a aVar = cWg;
        aVar.cWj += System.currentTimeMillis() - cWg.cWi;
        v.v("MicroMsg.FTS.FTSWebReportLogic", "stopH5Report %s", new Object[]{Long.valueOf(cWg.cWj)});
    }

    public static void Io() {
        a aVar = cWg;
        aVar.cWl += System.currentTimeMillis() - cWg.cWk;
        v.v("MicroMsg.FTS.FTSWebReportLogic", "stopTotalReport %s", new Object[]{Long.valueOf(cWg.cWl)});
    }

    public static void Ip() {
        a aVar = cWg;
        if (!aVar.cWm) {
            g.iuh.h(12044, new Object[]{Integer.valueOf(aVar.scene), Integer.valueOf(aVar.cWh), Long.valueOf(aVar.cWj / 1000), Long.valueOf(aVar.cWl / 1000)});
            aVar.cWm = true;
        }
        v.v("MicroMsg.FTS.FTSWebReportLogic", "reportTime");
    }

    public static void fZ(int i) {
        v.v("MicroMsg.FTS.FTSWebReportLogic", "kvReportWebSearchVisit %d", new Object[]{Integer.valueOf(i)});
        g.iuh.h(12041, new Object[]{Integer.valueOf(i), Integer.valueOf(h.cVT)});
    }

    public static void a(int i, int i2, String str, int i3, int i4, String str2) {
        v.v("MicroMsg.FTS.FTSWebReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2});
        g.iuh.h(12098, new Object[]{Integer.valueOf(i), Integer.valueOf(h.cVT), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2});
    }

    public static void c(String str, int i, int i2, int i3) {
        g.iuh.h(12639, new Object[]{be.ah(str, "").replace(",", " "), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3)});
    }

    public static void ga(int i) {
        g.iuh.h(12845, new Object[]{Integer.valueOf(i)});
    }

    public static void mK(String str) {
        g.iuh.h(12070, new Object[]{Integer.valueOf(15), Integer.valueOf(h.cVT), str, Integer.valueOf(4), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0)});
    }

    public static void g(int i, String str, String str2) {
        g.iuh.h(13809, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(0)});
    }

    public static void a(int i, String str, String str2, int i2, int i3) {
        g.iuh.h(13810, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0)});
    }
}
