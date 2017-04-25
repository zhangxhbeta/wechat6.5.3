package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.backup.f.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;

public final class f {
    private static final String ejl = (b.Vk() + "bakchatUpload.result");
    private static b ejm;
    private static final String ejn = (b.Vk() + "bakchatDownload.result");
    private static a ejo;

    public static void Vs() {
        b Vt = Vt();
        ejm = Vt;
        if (Vt == null) {
            v.e("MicroMsg.BakReportMgr", "yy recordUploadError with a un-started Result.");
            return;
        }
        ejm.ehf++;
        v.v("MicroMsg.BakReportMgr", "yy uploadError: " + ejm.toString());
        a(ejm, ejl);
    }

    public static void a(int i, long j, int i2) {
        b Vt = Vt();
        ejm = Vt;
        if (Vt == null) {
            v.e("MicroMsg.BakReportMgr", "yy recordUploadEnd with a un-started Result.");
            return;
        }
        ejm.cNp = i;
        ejm.ehl = j;
        ejm.ehg = 1;
        v.v("MicroMsg.BakReportMgr", "yy uploadEnd: " + ejm.toString());
        Vt = ejm;
        String str = Vt.cNp + "," + ((Vt.ehl - Vt.ehk) / 1000) + "," + Vt.networkType + "," + Vt.ehf + "," + Vt.ehg + "," + Vt.ehm + "," + Vt.ehn + "," + Vt.ehi + "," + Vt.ehj;
        v.v("MicroMsg.BakReportMgr", "yy upload report result: " + str);
        g.iuh.Y(10339, str);
        com.tencent.mm.loader.stub.b.deleteFile(ejl);
        ejm = null;
    }

    private static b Vt() {
        if (ejm != null) {
            return ejm;
        }
        byte[] pb = pb(ejl);
        if (pb != null) {
            try {
                return (b) new b().az(pb);
            } catch (Throwable e) {
                v.a("MicroMsg.BakReportMgr", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return null;
    }

    public static void Vu() {
        a Vv = Vv();
        ejo = Vv;
        if (Vv == null) {
            v.e("MicroMsg.BakReportMgr", "yy recordDownloadError with a un-started Result.");
            return;
        }
        ejo.ehf++;
        v.v("MicroMsg.BakReportMgr", "yy downloadError: " + ejo.toString());
        a(ejo, ejn);
    }

    public static void aF(long j) {
        a Vv = Vv();
        ejo = Vv;
        if (Vv == null) {
            v.e("MicroMsg.BakReportMgr", "yy recordDownloadEndTime with a un-started Result.");
            return;
        }
        ejo.ehc = j;
        v.v("MicroMsg.BakReportMgr", "yy downloadEndTime: " + ejo.toString());
        a(ejo, ejn);
    }

    public static void c(long j, int i, int i2) {
        a Vv = Vv();
        ejo = Vv;
        if (Vv == null) {
            v.e("MicroMsg.BakReportMgr", "yy recordDownloadEnd with a un-started Result.");
            return;
        }
        ejo.ehd = j;
        ejo.ehg = 1;
        ejo.ehh = i2;
        v.v("MicroMsg.BakReportMgr", "yy downloadEnd: " + ejo.toString());
        Vv = ejo;
        String str = Vv.eha + "," + Vv.djS + "," + ((Vv.ehd - Vv.ehb) / 1000) + "," + ((Vv.ehc - Vv.ehb) / 1000) + "," + Vv.ehe + "," + Vv.networkType + "," + Vv.ehf + "," + Vv.ehg + "," + Vv.ehh + "," + Vv.ehi + "," + Vv.ehj;
        v.v("MicroMsg.BakReportMgr", "yy download report result: " + str);
        g.iuh.Y(10321, str);
        com.tencent.mm.loader.stub.b.deleteFile(ejn);
        ejo = null;
    }

    private static a Vv() {
        if (ejo != null) {
            return ejo;
        }
        byte[] pb = pb(ejl);
        if (pb != null) {
            try {
                return (a) new a().az(pb);
            } catch (Throwable e) {
                v.a("MicroMsg.BakReportMgr", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return null;
    }

    private static boolean a(com.tencent.mm.ba.a aVar, String str) {
        if (aVar == null || be.kS(str)) {
            return false;
        }
        try {
            byte[] toByteArray = aVar.toByteArray();
            e.b(str, toByteArray, toByteArray.length);
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.BakReportMgr", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return false;
        }
    }

    private static byte[] pb(String str) {
        if (e.aR(str)) {
            return e.d(str, 0, -1);
        }
        if (!e.aR(b.Vk())) {
            new File(b.Vk()).mkdirs();
        }
        return null;
    }
}
