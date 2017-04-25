package com.tencent.mm.plugin.sns.i;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private static Map<String, a> jtH = new ConcurrentHashMap();
    private static volatile long jtI = 0;

    private static class a {
        int QW;
        int Zx;
        String jtJ;
        int jtK;
        int jtL;
        long jtM;
        long jtN;
        long jtO;
        String mMimeType;

        private a() {
            this.jtJ = "";
            this.jtK = 0;
            this.mMimeType = "";
            this.Zx = -1;
            this.QW = -1;
            this.jtL = -1;
            this.jtM = -1;
            this.jtN = -1;
            this.jtO = -1;
        }
    }

    private static class b {
        int QW;
        int Zx;
        String jtJ;
        int jtL;
        long jtM;
        String mMimeType;

        private b() {
            this.jtJ = "";
            this.mMimeType = "";
            this.Zx = -1;
            this.QW = -1;
            this.jtL = -1;
            this.jtM = -1;
        }
    }

    private static void aTv() {
        synchronized (jtH) {
            if (be.az(jtI) <= 120000) {
                return;
            }
            jtI = be.Nj();
            jtH.clear();
        }
    }

    private static String Ba(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        indexOf = str.indexOf("://");
        if (indexOf >= 0) {
            str = str.substring(indexOf + 3);
        }
        indexOf = str.indexOf(47);
        if (indexOf >= 0) {
            return str.substring(indexOf + 1);
        }
        return str;
    }

    public static void a(String str, String str2, int i, int i2, int i3, long j) {
        try {
            b bVar = new b();
            bVar.jtJ = Ba(str);
            bVar.mMimeType = str2;
            bVar.Zx = i;
            bVar.QW = i2;
            bVar.jtL = i3;
            bVar.jtM = j;
            StringBuilder stringBuilder = new StringBuilder(1024);
            stringBuilder.append(bVar.jtJ).append(',').append(bVar.mMimeType).append(',').append(bVar.Zx).append(',').append(bVar.QW).append(',').append(bVar.jtL).append(',').append(bVar.jtM);
            String stringBuilder2 = stringBuilder.toString();
            v.i("MicroMsg.SnsImgStats", "report up: " + stringBuilder2);
            g.iuh.Y(13512, stringBuilder2);
        } catch (Exception e) {
        }
    }

    public static void a(String str, String str2, int i, String str3, int i2, int i3, int i4, long j, long j2) {
        try {
            a aVar = new a();
            aVar.jtJ = Ba(str2);
            aVar.jtK = i;
            aVar.mMimeType = str3;
            aVar.Zx = i2;
            aVar.QW = i3;
            aVar.jtL = i4;
            aVar.jtM = j;
            aVar.jtN = j2;
            jtH.put(str, aVar);
        } catch (Exception e) {
        }
    }

    public static void y(String str, long j) {
        try {
            a aVar = (a) jtH.remove(str);
            if (aVar != null) {
                aVar.jtO = j;
                StringBuilder stringBuilder = new StringBuilder(1024);
                stringBuilder.append(aVar.jtJ).append(',').append(aVar.jtK).append(',').append(aVar.mMimeType).append(',').append(aVar.Zx).append(',').append(aVar.QW).append(',').append(aVar.jtL).append(',').append(aVar.jtM).append(',').append(aVar.jtN).append(',').append(aVar.jtO);
                String stringBuilder2 = stringBuilder.toString();
                v.i("MicroMsg.SnsImgStats", "report dl: " + stringBuilder2);
                g.iuh.Y(13513, stringBuilder2);
                aTv();
            }
        } catch (Exception e) {
        } finally {
            aTv();
        }
    }
}
