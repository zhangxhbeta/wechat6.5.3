package com.tencent.mm.plugin.report.service;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.os.StatFs;
import android.support.v7.a.a.k;
import android.util.SparseArray;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class f {
    private static SparseArray<Long> itW = new SparseArray();
    private static SparseArray<HashMap<Integer, Integer>> itX = new SparseArray();
    private static boolean itY = true;
    private static long itZ = 0;
    private static long iua = 0;
    private static long iub = 0;

    public static final class a {
        public static a iug;
        public volatile boolean hasInit;
        public long[] iuc;
        public int iud;
        public String iue;
        public long iuf;

        class a implements FileFilter {
            a() {
            }

            public final boolean accept(File file) {
                if (Pattern.matches("cpu[0-9]", file.getName())) {
                    return true;
                }
                return false;
            }
        }

        public static synchronized a aKC() {
            a aVar;
            synchronized (a.class) {
                if (iug == null) {
                    aVar = new a();
                    iug = aVar;
                    aVar.iud = rG();
                    iug.iue = rA();
                    a aVar2 = iug;
                    ActivityManager activityManager = (ActivityManager) aa.getContext().getSystemService("activity");
                    MemoryInfo memoryInfo = new MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    aVar2.iuf = memoryInfo.availMem >> 10;
                    aVar = iug;
                    long[] jArr = new long[2];
                    StatFs statFs = new StatFs(h.getDataDirectory().getPath());
                    jArr[0] = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
                    StatFs statFs2 = new StatFs(h.getDataDirectory().getPath());
                    jArr[1] = ((long) statFs2.getAvailableBlocks()) * ((long) statFs2.getBlockSize());
                    aVar.iuc = jArr;
                    iug.hasInit = true;
                }
                aVar = iug;
            }
            return aVar;
        }

        private static String rA() {
            String trim;
            Throwable e;
            Throwable th;
            String str = "N/A";
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
                trim = bufferedReader.readLine().trim();
                try {
                    bufferedReader.close();
                } catch (FileNotFoundException e2) {
                    e = e2;
                    v.a("MicroMsg.ReportLogInfo", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return trim;
                } catch (IOException e3) {
                    e = e3;
                    v.a("MicroMsg.ReportLogInfo", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return trim;
                }
            } catch (Throwable e4) {
                th = e4;
                trim = str;
                e = th;
                v.a("MicroMsg.ReportLogInfo", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                return trim;
            } catch (Throwable e42) {
                th = e42;
                trim = str;
                e = th;
                v.a("MicroMsg.ReportLogInfo", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                return trim;
            }
            return trim;
        }

        private static int rG() {
            try {
                return new File("/sys/devices/system/cpu/").listFiles(new a()).length;
            } catch (Throwable e) {
                v.a("MicroMsg.ReportLogInfo", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                return 1;
            }
        }
    }

    public static void oR(int i) {
        if (itY) {
            itW.put(i, Long.valueOf(be.Ni()));
            v.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  time:%d", Integer.valueOf(i), Long.valueOf(be.Ni()));
        }
    }

    public static void cw(long j) {
        if (itY) {
            v.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  with time:%d", Integer.valueOf(8), Long.valueOf(j));
            itW.put(8, Long.valueOf(j));
        }
    }

    public static void oS(int i) {
        if (itY) {
            Long l = (Long) itW.get(i);
            if (l != null && l.longValue() != -1) {
                itW.put(i, Long.valueOf(-1));
                long Ni = be.Ni() - l.longValue();
                if (Ni > 0) {
                    switch (i) {
                        case 8:
                            if (!aa.niD) {
                                w(1, Ni);
                                v(227, Ni);
                                g.iuh.c(23, 1, 2, (int) Ni, false);
                                break;
                            }
                            g.iuh.c(23, 4, 5, (int) Ni, false);
                            break;
                        case 9:
                            w(3, Ni);
                            v(229, Ni);
                            g.iuh.c(27, 1, 2, (int) Ni, false);
                            break;
                        case 10:
                            w(2, Ni);
                            v(228, Ni);
                            g.iuh.c(28, 1, 2, (int) Ni, false);
                            break;
                        case 12:
                            w(6, Ni);
                            break;
                        case 13:
                            w(7, Ni);
                            break;
                        case 14:
                            w(8, Ni);
                            break;
                        case k.MG /*18*/:
                            w(10, Ni);
                            break;
                        case 19:
                            w(9, Ni);
                            break;
                        case 20:
                            w(12, Ni);
                            break;
                        case 21:
                            w(11, Ni);
                            break;
                        case k.MM /*22*/:
                            w(13, Ni);
                            break;
                        case k.Nb /*23*/:
                            w(16, Ni);
                            break;
                        case 24:
                            w(15, Ni);
                            break;
                        case 25:
                            w(14, Ni);
                            break;
                    }
                    v.i("MicroMsg.ReportLogInfo", "ReportLogInfo operationEnd eventID:%d  time:%d", Integer.valueOf(i), Long.valueOf(Ni));
                }
            }
        }
    }

    private static void v(int i, long j) {
        if (j > 0) {
            if (j < 1000) {
                g.iuh.I(i, 0, 1);
            } else if (j < 2000) {
                g.iuh.I(i, 0, 3);
            } else if (j < 5000) {
                g.iuh.I(i, 0, 5);
            } else if (j < 10000) {
                g.iuh.I(i, 0, 7);
            } else {
                g.iuh.I(i, 0, 9);
            }
        }
    }

    private static void w(int i, long j) {
        long currentTimeMillis;
        if (i == 6) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= itZ + 60000) {
                itZ = currentTimeMillis;
            } else {
                return;
            }
        } else if (i == 7) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= iua + 60000) {
                iua = currentTimeMillis;
            } else {
                return;
            }
        } else if (i == 8) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= iub + 60000) {
                iub = currentTimeMillis;
            } else {
                return;
            }
        }
        if (a.aKC().hasInit) {
            g.iuh.a(11335, true, false, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(r0.iud), Long.valueOf(r0.iuc[0]), Long.valueOf(r0.iuc[1]), Long.valueOf(r0.iuf));
            return;
        }
        g.iuh.a(11335, true, false, Integer.valueOf(i), Long.valueOf(j));
    }

    public static void oT(int i) {
        if (itY) {
            v.d("MicroMsg.ReportLogInfo", "ReportLogInfo stopOperation stop eventID:%d", Integer.valueOf(i));
            itW.put(i, Long.valueOf(-1));
        }
    }
}
