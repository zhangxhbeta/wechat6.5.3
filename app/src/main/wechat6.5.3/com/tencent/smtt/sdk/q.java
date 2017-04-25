package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public final class q {
    private static Context aLg;
    private static boolean pxl;
    private static String pxm = null;
    private static int pxn = 0;
    private static String pxo = null;
    private static boolean pxp = false;
    private static boolean pxq = false;
    private static String pxr = null;
    private static boolean pxs = false;

    private static void a(Context context, TbsLinuxToolsJni tbsLinuxToolsJni, File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            tbsLinuxToolsJni.ef(file.getAbsolutePath(), "755");
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    if (file2.getAbsolutePath().indexOf(".so") > 0) {
                        tbsLinuxToolsJni.ef(file2.getAbsolutePath(), "755");
                    } else {
                        tbsLinuxToolsJni.ef(file2.getAbsolutePath(), "644");
                    }
                } else if (file2.isDirectory()) {
                    a(context, tbsLinuxToolsJni, file2);
                } else {
                    TbsLog.e("TbsShareManager", "unknown file type.", true);
                }
            }
        }
    }

    private static void b(Context context, String str, String str2, String str3, String str4) {
        FileInputStream fileInputStream;
        Throwable th;
        int i = 0;
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream2 = null;
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3;
        try {
            File bs = bs(context, "core_info");
            if (bs == null) {
                i.fb(aLg).yK(-405);
                try {
                    fileInputStream2.close();
                } catch (Exception e) {
                }
                try {
                    fileOutputStream2.close();
                    return;
                } catch (Exception e2) {
                    return;
                }
            }
            fileInputStream2 = new FileInputStream(bs);
            try {
                Properties properties = new Properties();
                properties.load(fileInputStream2);
                try {
                    i = Integer.parseInt(str);
                } catch (Exception e3) {
                }
                if (i != 0) {
                    properties.setProperty("core_version", str);
                    properties.setProperty("core_disabled", "false");
                    properties.setProperty("core_packagename", str2);
                    properties.setProperty("core_path", str3);
                    properties.setProperty("app_version", str4);
                } else {
                    properties.setProperty("core_disabled", "true");
                }
                fileOutputStream3 = new FileOutputStream(bs);
                try {
                    properties.store(fileOutputStream3, null);
                    pxs = false;
                    i.fb(aLg).yK(-406);
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                    }
                    fileOutputStream3.close();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        fileInputStream2.close();
                    } catch (Exception e5) {
                    }
                    try {
                        fileOutputStream3.close();
                    } catch (Exception e6) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileOutputStream3 = null;
                th = th4;
                fileInputStream2.close();
                fileOutputStream3.close();
                throw th;
            }
        } catch (Throwable th32) {
            fileInputStream2 = null;
            th = th32;
            fileOutputStream3 = null;
            fileInputStream2.close();
            fileOutputStream3.close();
            throw th;
        }
    }

    public static int bNA() {
        return pxn;
    }

    static boolean bNB() {
        TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE, null, new Object[0]);
        return false;
    }

    public static String[] bNu() {
        return new String[]{"com.tencent.x5sdk.demo", "com.tencent.mm", "com.tencent.mobileqq", "com.qzone"};
    }

    public static long bNv() {
        String[] bNu = bNu();
        for (int i = 0; i < 4; i++) {
            String str = bNu[i];
            if (!(str.equalsIgnoreCase("com.tencent.mm") || str.equalsIgnoreCase("com.tencent.mobileqq"))) {
                str.equalsIgnoreCase("com.qzone");
            }
        }
        return 0;
    }

    public static boolean bNw() {
        return pxp;
    }

    static String bNx() {
        return pxm;
    }

    static int bNy() {
        return pxn;
    }

    static int bNz() {
        return pxn;
    }

    private static File bs(Context context, String str) {
        m.bNm();
        File fs = m.fs(context);
        if (fs == null) {
            return null;
        }
        File file = new File(fs, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            return null;
        }
    }

    private static Context bt(Context context, String str) {
        Context context2 = null;
        try {
            context2 = context.createPackageContext(str, 2);
        } catch (NameNotFoundException e) {
        } catch (Exception e2) {
        }
        return context2;
    }

    public static synchronized void c(Context context, int i, boolean z) {
        Throwable th;
        FileOutputStream fileOutputStream = null;
        synchronized (q.class) {
            if (i == 0) {
                fA(context);
                i.fb(aLg).yK(-401);
            } else {
                int fC = fC(context);
                if (fC < 0) {
                    i.fb(aLg).yK(-402);
                } else if (i == fC) {
                    FileInputStream fileInputStream = null;
                    FileOutputStream fileOutputStream2 = null;
                    FileInputStream fileInputStream2;
                    FileOutputStream fileOutputStream3;
                    try {
                        File bs = bs(context, "core_info");
                        if (bs == null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e) {
                            }
                            try {
                                fileOutputStream2.close();
                            } catch (Exception e2) {
                            }
                            i.fb(aLg).yK(-403);
                        } else {
                            fileInputStream2 = new FileInputStream(bs);
                            try {
                                Properties properties = new Properties();
                                properties.load(fileInputStream2);
                                properties.setProperty("core_disabled", "false");
                                if (z) {
                                    m.bNm();
                                    r1 = m.fr(context).getAbsolutePath();
                                    r6 = context.getApplicationContext().getPackageName();
                                    r7 = c.getAppVersionCode(context);
                                    properties.setProperty("core_packagename", r6);
                                    properties.setProperty("core_path", r1);
                                    properties.setProperty("app_version", String.valueOf(r7));
                                }
                                fileOutputStream3 = new FileOutputStream(bs);
                                try {
                                    properties.store(fileOutputStream3, null);
                                    try {
                                        fileInputStream2.close();
                                    } catch (Exception e3) {
                                    }
                                    fileOutputStream3.close();
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        fileInputStream2.close();
                                    } catch (Exception e4) {
                                    }
                                    try {
                                        fileOutputStream3.close();
                                    } catch (Exception e5) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                Throwable th4 = th3;
                                fileOutputStream3 = null;
                                th = th4;
                                fileInputStream2.close();
                                fileOutputStream3.close();
                                throw th;
                            }
                            i.fb(aLg).yK(-403);
                        }
                    } catch (Throwable th32) {
                        fileInputStream2 = null;
                        th = th32;
                        fileOutputStream3 = null;
                        fileInputStream2.close();
                        fileOutputStream3.close();
                        throw th;
                    }
                } else if (i < fC) {
                    fA(context);
                    i.fb(aLg).yK(-404);
                } else {
                    String[] bNu = bNu();
                    String[] strArr;
                    if (z) {
                        strArr = new String[]{context.getApplicationContext().getPackageName()};
                    } else {
                        strArr = bNu;
                    }
                    for (String str : r2) {
                        if (i == 0) {
                            Context bt = bt(context, str);
                            m.bNm();
                            r6 = m.fr(bt).getAbsolutePath();
                            r7 = c.getAppVersionCode(context);
                            m.bNm();
                            if (m.fi(bt)) {
                                if (!str.equals(context.getApplicationContext().getPackageName())) {
                                    TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i);
                                    m.bNm();
                                    try {
                                        e.F(m.fr(context));
                                        TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                                    } catch (Throwable th5) {
                                    }
                                }
                                b(context, Integer.toString(i), str, r6, Integer.toString(r7));
                                try {
                                    File bs2 = bs(context, "core_info");
                                    if (!(pxq || bs2 == null)) {
                                        TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(aLg);
                                        tbsLinuxToolsJni.ef(bs2.getAbsolutePath(), "644");
                                        m.bNm();
                                        tbsLinuxToolsJni.ef(m.fs(context).getAbsolutePath(), "755");
                                        pxq = true;
                                    }
                                } catch (Throwable th6) {
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean fA(Context context) {
        if (context == null) {
            return false;
        }
        b(context, Integer.toString(0), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, Integer.toString(0));
        return true;
    }

    static synchronized String fB(Context context) {
        String str;
        Throwable th;
        synchronized (q.class) {
            FileInputStream fileInputStream = null;
            FileInputStream fileInputStream2;
            try {
                File bs = bs(context, "core_info");
                if (bs == null) {
                    if (null != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                        }
                    }
                    str = null;
                } else {
                    fileInputStream2 = new FileInputStream(bs);
                    try {
                        Properties properties = new Properties();
                        properties.load(fileInputStream2);
                        str = properties.getProperty("core_packagename", SQLiteDatabase.KeyEmpty);
                        if (SQLiteDatabase.KeyEmpty.equals(str)) {
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception e2) {
                                }
                            }
                            str = null;
                        } else if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e3) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = null;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                throw th;
            }
        }
        return str;
    }

    private static synchronized int fC(Context context) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        int i = 0;
        synchronized (q.class) {
            FileInputStream fileInputStream3 = null;
            try {
                File bs = bs(context, "core_info");
                if (bs == null) {
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                        } catch (Exception e) {
                        }
                    }
                } else {
                    fileInputStream = new FileInputStream(bs);
                    try {
                        Properties properties = new Properties();
                        properties.load(fileInputStream);
                        String property = properties.getProperty("core_version", SQLiteDatabase.KeyEmpty);
                        if (SQLiteDatabase.KeyEmpty.equals(property)) {
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } else {
                            i = Math.max(Integer.parseInt(property), 0);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream3;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
        return i;
    }

    static void fy(Context context) {
        try {
            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(context);
            m.bNm();
            a(context, tbsLinuxToolsJni, m.fr(context));
            m.bNm();
            tbsLinuxToolsJni.ef(m.fs(context).getAbsolutePath(), "755");
        } catch (Throwable th) {
        }
    }

    public static boolean fz(Context context) {
        try {
            if (aLg != null && aLg.equals(context.getApplicationContext())) {
                return pxl;
            }
            Context applicationContext = context.getApplicationContext();
            aLg = applicationContext;
            String packageName = applicationContext.getPackageName();
            String[] bNu = bNu();
            for (int i = 0; i < 4; i++) {
                if (packageName.equals(bNu[i])) {
                    pxl = false;
                    return false;
                }
            }
            pxl = true;
            return true;
        } catch (Throwable th) {
        }
    }

    public static void u(Context context, boolean z) {
        try {
            if (fz(context)) {
                m.bNm();
                File fs = m.fs(context);
                if (fs == null) {
                    return;
                }
                if (!z || !new File(fs, "core_info").exists()) {
                    bNu();
                }
            }
        } catch (Exception e) {
        }
    }
}
