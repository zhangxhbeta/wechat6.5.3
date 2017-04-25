package com.tencent.mm.modelsearch;

import android.support.v7.a.a.k;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import java.util.ArrayList;

public final class j {
    public static void l(int i, long j) {
        v.v("MicroMsg.FTS.FTSReportLogic", "reportIDKey: type=%d time=%d", Integer.valueOf(i), Long.valueOf(j));
        switch (i) {
            case 0:
            case 3:
            case 6:
            case 9:
            case 12:
                IDKey iDKey = new IDKey();
                iDKey.SetID(79);
                iDKey.SetKey(i + 1);
                iDKey.SetValue((int) j);
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(79);
                iDKey2.SetKey(i + 2);
                iDKey2.SetValue(1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(iDKey);
                arrayList.add(iDKey2);
                g gVar = g.iuh;
                g.d(arrayList, false);
                return;
            default:
                return;
        }
    }

    public static void fW(int i) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(146);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        if (i != 1) {
            iDKey = new IDKey();
            iDKey.SetID(146);
            iDKey.SetKey(2);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(146);
            iDKey.SetKey(i);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        } else {
            iDKey = new IDKey();
            iDKey.SetID(146);
            iDKey.SetKey(1);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        g gVar = g.iuh;
        g.d(arrayList, false);
    }

    public static void m(int i, long j) {
        if (i > 0) {
            int i2 = ((i - 1) * 2) + 1;
            v.v("MicroMsg.FTS.FTSReportLogic", "reportIDKeySearchTime: reportKey=%d taskId=%d", Integer.valueOf(i2), Integer.valueOf(i));
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(149);
            iDKey.SetKey(i2);
            iDKey.SetValue((int) j);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(149);
            iDKey.SetKey(i2 + 1);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            g gVar = g.iuh;
            g.d(arrayList, false);
        }
    }

    public static void a(String str, boolean z, int i, int i2, boolean z2) {
        int i3;
        String format;
        switch (i2) {
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                i3 = 2;
                break;
            case 0:
                i3 = 1;
                break;
            default:
                i3 = 0;
                break;
        }
        String str2;
        Object[] objArr;
        if (z) {
            str2 = "%s,%s,%s,%s";
            objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(3);
            objArr[2] = Integer.valueOf(i3);
            if (z2) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            objArr[3] = Integer.valueOf(i3);
            format = String.format(str2, objArr);
        } else if (i > 0) {
            str2 = "%s,%s,%s,%s";
            objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(2);
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = Integer.valueOf(z2 ? 1 : 0);
            format = String.format(str2, objArr);
        } else {
            str2 = "%s,%s,%s,%s";
            objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(1);
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = Integer.valueOf(z2 ? 1 : 0);
            format = String.format(str2, objArr);
        }
        v.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", Integer.valueOf(11062), format);
        g.iuh.Y(11062, format);
    }

    public static final int f(int i, int i2, boolean z) {
        if (z) {
            return 15;
        }
        if (i == 131072) {
            switch (i2) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 8:
                case 9:
                case 10:
                case 11:
                    return 8;
                case 15:
                    return 16;
                case 16:
                    return 10;
                case 17:
                case k.MG /*18*/:
                    return 9;
                default:
                    return 0;
            }
        } else if (i == 131075) {
            switch (i2) {
                case 1:
                case 5:
                    return 12;
                case 2:
                case 6:
                    return 13;
                case 3:
                case 7:
                    return 14;
                case 29:
                case 30:
                case 31:
                case FileUtils.S_IRGRP /*32*/:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                    return 11;
                default:
                    return 0;
            }
        } else if (i == 65536) {
            return 17;
        } else {
            return 0;
        }
    }

    public static int fX(int i) {
        switch (i) {
            case 29:
                return 1;
            case 30:
                return 2;
            case 31:
                return 3;
            case FileUtils.S_IRGRP /*32*/:
                return 4;
            case 34:
                return 5;
            case 35:
            case 36:
                return 6;
            case 37:
                return 16;
            default:
                return 0;
        }
    }
}
