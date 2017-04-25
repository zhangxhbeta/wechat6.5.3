package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.StatFs;
import com.tencent.mm.al.i;
import com.tencent.mm.app.d.a;
import com.tencent.mm.as.k;
import com.tencent.mm.as.o;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.e.a.ke;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

public final class g {
    public static void run() {
        SharedPreferences sharedPreferences;
        int i;
        Context context = aa.getContext();
        a anonymousClass1 = new a() {
            public final void cG(int i) {
                v.i("MicroMsg.PostTaskLightweightJob", "CrashStatus report: key %s ", Integer.valueOf(i));
                com.tencent.mm.plugin.report.service.g.iuh.a(25, (long) i, 1, false);
            }
        };
        if (context != null) {
            try {
                sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
                String[] split = sharedPreferences.getString("crashlist", SQLiteDatabase.KeyEmpty).split(";");
                if (split != null && split.length > 0) {
                    Editor edit = sharedPreferences.edit();
                    edit.putString("crashlist", SQLiteDatabase.KeyEmpty);
                    edit.commit();
                    for (i = 0; i < split.length; i++) {
                        String[] split2 = split[i] == null ? null : split[i].split(",");
                        if (split2 != null && split2.length >= 2) {
                            if (split2[1].equals("anr")) {
                                anonymousClass1.cG(10);
                            } else {
                                anonymousClass1.cG(11);
                                if ("com.tencent.mm".equals(split2[0])) {
                                    anonymousClass1.cG(14);
                                }
                                if ("com.tencent.mm:push".equals(split2[0])) {
                                    anonymousClass1.cG(17);
                                }
                                if ("com.tencent.mm:tools".equals(split2[0])) {
                                    anonymousClass1.cG(20);
                                }
                                if (split2[1].equals("java")) {
                                    anonymousClass1.cG(12);
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        anonymousClass1.cG(15);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        anonymousClass1.cG(18);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        anonymousClass1.cG(21);
                                    }
                                }
                                if (split2[1].equals("jni")) {
                                    anonymousClass1.cG(13);
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        anonymousClass1.cG(16);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        anonymousClass1.cG(19);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        anonymousClass1.cG(22);
                                    }
                                }
                                if (split2[1].equals("first")) {
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        anonymousClass1.cG(23);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        anonymousClass1.cG(24);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        anonymousClass1.cG(25);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        context = aa.getContext();
        i = j.sU().getInt("AndroidGooglePlayCrashUploadSizeLimit", 1024);
        if (context != null && i > 0) {
            try {
                sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
                if (sharedPreferences.getInt("googleplaysizelimit", 1024) != i) {
                    edit = sharedPreferences.edit();
                    edit.putInt("googleplaysizelimit", i);
                    edit.commit();
                }
            } catch (Throwable th2) {
            }
        }
        ak.yW();
        if (t.ay(t.e((Long) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_REPORT_LAST_TIME_REPORT_DYNACFG_VER_LONG, null))) > 21600000) {
            com.tencent.mm.plugin.report.service.g.iuh.a(279, (long) (j.sU().getInt("AndroidDynamicConfigVer", 0) % 16), 1, false);
            ak.yW();
            c.vf().a(com.tencent.mm.storage.t.a.USERINFO_REPORT_LAST_TIME_REPORT_DYNACFG_VER_LONG, Long.valueOf(t.Ni()));
        }
        ak.yW();
        if (t.ay(t.e((Long) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_REPORT_LAST_TIME_REPORT_VIDEO_SEND_RECV_COUNT_LONG, null))) > 21600000) {
            ak.yW();
            c.vf().a(com.tencent.mm.storage.t.a.USERINFO_REPORT_LAST_TIME_REPORT_VIDEO_SEND_RECV_COUNT_LONG, Long.valueOf(t.Ni()));
            o KV = k.KV();
            int[] iArr = new int[]{0, 0, 0, 0, 0, 0};
            try {
                v.i("MicroMsg.VideoInfoStorage", "reportVideoMsgCount sql:%s", "select status, videofuncflag, human from videoinfo2 where lastmodifytime > " + (be.Nh() - 21600));
                Cursor rawQuery = KV.cuX.rawQuery(r2, null);
                while (rawQuery.moveToNext()) {
                    int i2 = rawQuery.getInt(0);
                    int i3 = rawQuery.getInt(1);
                    String string = rawQuery.getString(2);
                    if (MMGIFException.D_GIF_ERR_NOT_READABLE == i2) {
                        i2 = i3 == 3 ? 0 : 3;
                        iArr[i2] = iArr[i2] + 1;
                    } else if (199 != i2) {
                        continue;
                    } else if (com.tencent.mm.model.k.xF().equals(string)) {
                        i2 = i3 == 3 ? 1 : 4;
                        iArr[i2] = iArr[i2] + 1;
                    } else {
                        i2 = i3 == 3 ? 2 : 5;
                        iArr[i2] = iArr[i2] + 1;
                    }
                }
                rawQuery.close();
                com.tencent.mm.plugin.report.service.g.iuh.h(12696, Integer.valueOf(10010), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2]), Integer.valueOf(iArr[3]), Integer.valueOf(iArr[4]), Integer.valueOf(iArr[5]));
            } catch (Exception e) {
            }
        }
        if (ak.uE()) {
            v.i("MicroMsg.PostTaskLightweightJob", "is new register, try insert qmessage intro conversation");
            b keVar = new ke();
            keVar.bla.opType = 2;
            com.tencent.mm.sdk.c.a.nhr.z(keVar);
            ak.yQ();
        }
        ak.yW();
        if (be.Ni() - be.a((Long) c.vf().get(81939, null), 0) > 86400000) {
            i iVar = new i();
        }
        long currentTimeMillis = System.currentTimeMillis();
        ak.yW();
        boolean booleanValue = ((Boolean) c.vf().get(233475, Boolean.valueOf(false))).booleanValue();
        ak.yW();
        if (c.wH().bvy() <= 0) {
            if (!booleanValue) {
                ak.yW();
                c.wK().Mf("officialaccounts");
                ak.yW();
                c.vf().set(233475, Boolean.valueOf(true));
            }
        } else if (booleanValue) {
            ak.yW();
            c.vf().set(233475, Boolean.valueOf(false));
        }
        ak.yW();
        long longValue = ((Long) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_REPORT_SD_STATUS_TIME_LONG, Long.valueOf(0))).longValue();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (currentTimeMillis2 - longValue > 259200000 || longValue > currentTimeMillis2) {
            ak.yW();
            c.vf().a(com.tencent.mm.storage.t.a.USERINFO_REPORT_SD_STATUS_TIME_LONG, Long.valueOf(currentTimeMillis2));
            e.a(new Runnable() {
                public final void run() {
                    try {
                        int round;
                        long j;
                        long j2;
                        long j3;
                        long j4;
                        long j5;
                        int i;
                        boolean btW = at.btW();
                        String path = h.getDataDirectory().getPath();
                        String path2 = h.getExternalStorageDirectory().getPath();
                        StatFs statFs = new StatFs(path);
                        long blockSize = (long) statFs.getBlockSize();
                        long blockCount = (long) statFs.getBlockCount();
                        long availableBlocks = (long) statFs.getAvailableBlocks();
                        long j6 = blockSize * blockCount;
                        long j7 = blockSize * availableBlocks;
                        if (blockCount > 0) {
                            round = Math.round((float) ((100 * availableBlocks) / blockCount));
                        } else {
                            round = -1;
                        }
                        statFs = new StatFs(path2);
                        long blockSize2 = (long) statFs.getBlockSize();
                        long blockCount2 = (long) statFs.getBlockCount();
                        long availableBlocks2 = (long) statFs.getAvailableBlocks();
                        long j8 = blockSize2 * blockCount2;
                        long j9 = blockSize2 * availableBlocks2;
                        int i2 = -1;
                        if (blockCount2 > 0) {
                            i2 = Math.round((float) ((100 * availableBlocks2) / blockCount2));
                        }
                        boolean equals = com.tencent.mm.compatible.util.e.cni.equals(path2);
                        if (equals) {
                            j = j9;
                            j2 = j8;
                            j3 = availableBlocks2;
                            j4 = blockCount2;
                            j5 = blockSize2;
                            i = i2;
                        } else {
                            statFs = new StatFs(com.tencent.mm.compatible.util.e.cni);
                            long blockSize3 = (long) statFs.getBlockSize();
                            long blockCount3 = (long) statFs.getBlockCount();
                            long availableBlocks3 = (long) statFs.getAvailableBlocks();
                            long j10 = blockSize3 * blockCount3;
                            long j11 = blockSize3 * availableBlocks3;
                            if (blockCount3 > 0) {
                                j2 = j10;
                                j3 = availableBlocks3;
                                j4 = blockCount3;
                                j5 = blockSize3;
                                i = Math.round((float) ((100 * availableBlocks3) / blockCount3));
                                j = j11;
                            } else {
                                j = j11;
                                j2 = j10;
                                j3 = availableBlocks3;
                                j4 = blockCount3;
                                j5 = blockSize3;
                                i = i2;
                            }
                        }
                        v.i("MicroMsg.PostTaskLightweightJob", "summerStorage [%s, %s, %s] [%s] [%b] [%d,%d,%d,%d,%d,%d] [%d,%d,%d,%d,%d,%d] [%b] [%d,%d,%d,%d,%d,%d]", path, path2, com.tencent.mm.compatible.util.e.cni, at.Kr(com.tencent.mm.compatible.util.e.cni), Boolean.valueOf(btW), Long.valueOf(blockSize), Long.valueOf(blockCount), Long.valueOf(availableBlocks), Long.valueOf(j6), Long.valueOf(j7), Integer.valueOf(round), Long.valueOf(blockSize2), Long.valueOf(blockCount2), Long.valueOf(availableBlocks2), Long.valueOf(j8), Long.valueOf(j9), Integer.valueOf(i2), Boolean.valueOf(equals), Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i));
                        com.tencent.mm.plugin.report.service.g.iuh.a(340, 0, 1, false);
                        com.tencent.mm.plugin.report.service.g.iuh.a(340, btW ? 1 : 2, 1, false);
                        com.tencent.mm.plugin.report.service.g.iuh.a(340, equals ? 3 : 4, 1, false);
                        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(5000);
                        String str = "%s;%s;%s;%s;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d";
                        Object[] objArr2 = new Object[24];
                        objArr2[0] = path;
                        objArr2[1] = path2;
                        objArr2[2] = com.tencent.mm.compatible.util.e.cni;
                        objArr2[3] = r2;
                        objArr2[4] = Integer.valueOf(btW ? 1 : 0);
                        objArr2[5] = Long.valueOf(blockSize);
                        objArr2[6] = Long.valueOf(blockCount);
                        objArr2[7] = Long.valueOf(availableBlocks);
                        objArr2[8] = Long.valueOf(j6);
                        objArr2[9] = Long.valueOf(j7);
                        objArr2[10] = Integer.valueOf(round);
                        objArr2[11] = Long.valueOf(blockSize2);
                        objArr2[12] = Long.valueOf(blockCount2);
                        objArr2[13] = Long.valueOf(availableBlocks2);
                        objArr2[14] = Long.valueOf(j8);
                        objArr2[15] = Long.valueOf(j9);
                        objArr2[16] = Integer.valueOf(i2);
                        objArr2[17] = Integer.valueOf(equals ? 1 : 0);
                        objArr2[18] = Long.valueOf(j5);
                        objArr2[19] = Long.valueOf(j4);
                        objArr2[20] = Long.valueOf(j3);
                        objArr2[21] = Long.valueOf(j2);
                        objArr2[22] = Long.valueOf(j);
                        objArr2[23] = Integer.valueOf(i);
                        objArr[1] = String.format(str, objArr2);
                        gVar.h(11098, objArr);
                        com.tencent.mm.plugin.report.service.g.iuh.a(340, 7, 1, false);
                    } catch (Throwable e) {
                        v.a("MicroMsg.PostTaskLightweightJob", e, "reportSDStatus err!", new Object[0]);
                        com.tencent.mm.plugin.report.service.g.iuh.a(340, 8, 1, false);
                    }
                }
            }, "reportSDStatus");
        }
        ak.yW();
        longValue = ((Long) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_WECHAT_DB_REPORT_LAST_TIME_LONG, Long.valueOf(0))).longValue();
        currentTimeMillis2 = System.currentTimeMillis();
        if (currentTimeMillis2 - longValue > 259200000 || longValue > currentTimeMillis2) {
            ak.yW();
            c.vf().a(com.tencent.mm.storage.t.a.USERINFO_WECHAT_DB_REPORT_LAST_TIME_LONG, Long.valueOf(currentTimeMillis2));
            e.a(new Runnable() {
                public final void run() {
                    try {
                        ak.yW();
                        long length = new File(c.xo()).length();
                        StringBuilder stringBuilder = new StringBuilder();
                        ak.yW();
                        String str = length + ";" + new File(stringBuilder.append(c.xp()).append("SnsMicroMsg.db").toString()).length();
                        ak.yW();
                        com.tencent.mm.bg.g wF = c.wF();
                        if (wF == null || !wF.isOpen()) {
                            v.i("MicroMsg.PostTaskLightweightJob", "summerreportDBInfo db is not open!");
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            ArrayList arrayList = new ArrayList();
                            Cursor rawQuery = wF.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
                            if (rawQuery != null) {
                                if (rawQuery.moveToFirst()) {
                                    while (!rawQuery.isAfterLast()) {
                                        arrayList.add(rawQuery.getString(rawQuery.getColumnIndex("name")));
                                        rawQuery.moveToNext();
                                    }
                                }
                                rawQuery.close();
                            }
                            String str2 = str + ";" + arrayList.size();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                str = (String) it.next();
                                Cursor rawQuery2 = wF.rawQuery("select count(*) from " + str, null);
                                long j = 0;
                                if (rawQuery2 != null) {
                                    if (rawQuery2.moveToFirst()) {
                                        j = rawQuery2.getLong(0);
                                    }
                                    rawQuery2.close();
                                }
                                str2 = str2 + ";" + str + ":" + j;
                            }
                            v.i("MicroMsg.PostTaskLightweightJob", "summerreportDBInfo dump all table count %d last %d", Integer.valueOf(arrayList.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            str = str2;
                        }
                        com.tencent.mm.plugin.report.service.g.iuh.h(13778, Integer.valueOf(1), Integer.valueOf(1), str);
                        com.tencent.mm.plugin.report.service.g.iuh.a(418, 3, 1, false);
                        v.i("MicroMsg.PostTaskLightweightJob", "summerreportDBInfo result[%s]", str);
                    } catch (Throwable e) {
                        v.a("MicroMsg.PostTaskLightweightJob", e, "reportDBInfo err!", new Object[0]);
                        com.tencent.mm.plugin.report.service.g.iuh.a(418, 4, 1, false);
                    }
                }
            }, "reportDBInfo");
        }
        ak.yW();
        longValue = ((Long) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_INSTALL_LAST_REPORT_TIME_LONG, Long.valueOf(0))).longValue();
        currentTimeMillis2 = System.currentTimeMillis();
        if (currentTimeMillis2 - longValue > 259200000 || longValue > currentTimeMillis2) {
            ak.yW();
            c.vf().a(com.tencent.mm.storage.t.a.USERINFO_INSTALL_LAST_REPORT_TIME_LONG, Long.valueOf(currentTimeMillis2));
            e.a(new Runnable() {
                public final void run() {
                    try {
                        long j;
                        ak.yW();
                        int intValue = ((Integer) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0))).intValue();
                        ak.yW();
                        long longValue = ((Long) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0))).longValue();
                        long j2 = 0;
                        ak.yW();
                        if (c.isSDCardAvailable()) {
                            File file = new File(com.tencent.mm.compatible.util.e.cgn);
                            if (file.exists() && file.isDirectory()) {
                                File[] listFiles = file.listFiles();
                                if (listFiles == null || listFiles.length == 0) {
                                    v.i("MicroMsg.PostTaskLightweightJob", "summerreportVersion getOldestXlogDay failed as no files");
                                    j = 0;
                                } else {
                                    Arrays.sort(listFiles, new Comparator<File>() {
                                        public final /* synthetic */ int compare(Object obj, Object obj2) {
                                            long lastModified = ((File) obj).lastModified() - ((File) obj2).lastModified();
                                            if (lastModified > 0) {
                                                return 1;
                                            }
                                            return lastModified == 0 ? 0 : -1;
                                        }

                                        public final boolean equals(Object obj) {
                                            return true;
                                        }
                                    });
                                    for (File name : listFiles) {
                                        String name2 = name.getName();
                                        if (!be.kS(name2) && name2.endsWith(".xlog")) {
                                            j2 = be.getLong(name2.substring(name2.length() - 13, name2.length() - 5), 0);
                                            if (j2 > 0) {
                                                break;
                                            }
                                        }
                                    }
                                    j = j2;
                                }
                            } else {
                                v.i("MicroMsg.PostTaskLightweightJob", "summerreportVersion getOldestXlogDay failed as path not exist");
                                j = 0;
                            }
                        } else {
                            v.i("MicroMsg.PostTaskLightweightJob", "summerreportVersion getOldestXlogDay failed as sdcard not available");
                            j = 0;
                        }
                        Object obj = (intValue <= 0 || d.lWh == intValue) ? 1 : null;
                        String str = intValue + ";" + d.lWh + ";" + (obj != null ? 1 : 0) + ";" + new SimpleDateFormat("yyyyMMdd").format(new Date(longValue)) + ";" + j;
                        com.tencent.mm.plugin.report.service.g.iuh.a(418, 1, 1, false);
                        com.tencent.mm.plugin.report.service.g.iuh.h(13778, Integer.valueOf(3), Integer.valueOf(1), str);
                        v.i("MicroMsg.PostTaskLightweightJob", "summerreportVersion install result[%s]", str);
                    } catch (Throwable e) {
                        v.a("MicroMsg.PostTaskLightweightJob", e, "reportVersion err!", new Object[0]);
                        com.tencent.mm.plugin.report.service.g.iuh.a(418, 2, 1, false);
                    }
                }
            }, "reportVersion");
        }
        v.i("MicroMsg.PostTaskLightweightJob", "use time %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }
}
