package com.tencent.tinker.loader.shareutil;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ShareTinkerInternals {
    private static final boolean pHf = QF(System.getProperty("java.vm.version"));
    private static String pHg = null;
    private static String processName = null;

    public static boolean bPb() {
        return pHf || VERSION.SDK_INT >= 21;
    }

    public static boolean QE(String str) {
        String str2 = Build.FINGERPRINT;
        if (str == null || str.equals(SQLiteDatabase.KeyEmpty) || str2 == null || str2.equals(SQLiteDatabase.KeyEmpty)) {
            new StringBuilder("fingerprint empty:").append(str).append(",current:").append(str2);
            return false;
        } else if (str.equals(str2)) {
            return false;
        } else {
            new StringBuilder("system OTA,fingerprint not equal:").append(str).append(",").append(str2);
            return true;
        }
    }

    public static boolean kS(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    public static int a(Context context, int i, File file, ShareSecurityCheck shareSecurityCheck) {
        int i2;
        if (shareSecurityCheck.T(file)) {
            String gs = gs(context);
            if (gs == null) {
                i2 = -5;
            } else {
                HashMap bPa = shareSecurityCheck.bPa();
                if (bPa == null) {
                    i2 = -2;
                } else {
                    String str = (String) bPa.get("TINKER_ID");
                    if (str == null) {
                        i2 = -6;
                    } else if (gs.equals(str)) {
                        i2 = 0;
                    } else {
                        new StringBuilder("tinkerId is not equal, base is ").append(gs).append(", but patch is ").append(str);
                        i2 = -7;
                    }
                }
            }
        } else {
            i2 = -1;
        }
        if (i2 != 0) {
            return i2;
        }
        Object obj;
        if (i == 7) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            bPa = shareSecurityCheck.pHd;
            if (!zy(i) && bPa.containsKey("assets/dex_meta.txt")) {
                return -9;
            }
            if (!zz(i) && bPa.containsKey("assets/so_meta.txt")) {
                return -9;
            }
            if (!zA(i) && bPa.containsKey("assets/res_meta.txt")) {
                return -9;
            }
        }
        return 0;
    }

    public static Properties U(File file) {
        Throwable th;
        IOException e;
        ZipFile zipFile;
        Throwable th2;
        if (!file.isFile() || file.length() == 0) {
            return null;
        }
        ZipFile zipFile2;
        try {
            zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("assets/package_meta.txt");
                if (entry == null) {
                    SharePatchFileUtil.a(zipFile2);
                    return null;
                }
                Closeable inputStream;
                try {
                    inputStream = zipFile2.getInputStream(entry);
                    try {
                        Properties properties = new Properties();
                        properties.load(inputStream);
                        SharePatchFileUtil.c(inputStream);
                        SharePatchFileUtil.a(zipFile2);
                        return properties;
                    } catch (Throwable th3) {
                        th = th3;
                        SharePatchFileUtil.c(inputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    SharePatchFileUtil.c(inputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                zipFile = zipFile2;
                try {
                    new StringBuilder("fastGetPatchPackageMeta exception:").append(e.getMessage());
                    SharePatchFileUtil.a(zipFile);
                    return null;
                } catch (Throwable th5) {
                    th2 = th5;
                    zipFile2 = zipFile;
                    SharePatchFileUtil.a(zipFile2);
                    throw th2;
                }
            } catch (Throwable th6) {
                th2 = th6;
                SharePatchFileUtil.a(zipFile2);
                throw th2;
            }
        } catch (IOException e3) {
            e = e3;
            zipFile = null;
            new StringBuilder("fastGetPatchPackageMeta exception:").append(e.getMessage());
            SharePatchFileUtil.a(zipFile);
            return null;
        } catch (Throwable th7) {
            zipFile2 = null;
            th2 = th7;
            SharePatchFileUtil.a(zipFile2);
            throw th2;
        }
    }

    private static String gs(Context context) {
        if (pHg != null) {
            return pHg;
        }
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), FileUtils.S_IWUSR).metaData.get("TINKER_ID");
            if (obj != null) {
                pHg = String.valueOf(obj);
            } else {
                pHg = null;
            }
            return pHg;
        } catch (Exception e) {
            new StringBuilder("getManifestTinkerID exception:").append(e.getMessage());
            return null;
        }
    }

    public static boolean zy(int i) {
        return (i & 1) != 0;
    }

    public static boolean zz(int i) {
        return (i & 2) != 0;
    }

    public static boolean zA(int i) {
        return (i & 4) != 0;
    }

    public static String zB(int i) {
        switch (i) {
            case 1:
                return "patch_file";
            case 2:
                return "patch_info";
            case 3:
                return "dex";
            case 4:
                return "dex_opt";
            case 5:
                return "lib";
            case 6:
                return "resource";
            default:
                return "unknown";
        }
    }

    public static void gt(Context context) {
        context.getSharedPreferences("tinker_share_config", 4).edit().putBoolean("tinker_enable", false).commit();
    }

    public static boolean gu(Context context) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences("tinker_share_config", 4).getBoolean("tinker_enable", true);
    }

    public static boolean zC(int i) {
        return i != 0;
    }

    public static boolean gv(Context context) {
        String packageName = context.getPackageName();
        Object gx = gx(context);
        if (gx == null || gx.length() == 0) {
            gx = SQLiteDatabase.KeyEmpty;
        }
        return packageName.equals(gx);
    }

    public static void gw(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.uid == Process.myUid() && runningAppProcessInfo.pid != Process.myPid()) {
                    Process.killProcess(runningAppProcessInfo.pid);
                }
            }
        }
    }

    public static String gx(Context context) {
        if (processName != null) {
            return processName;
        }
        String gy = gy(context);
        processName = gy;
        return gy;
    }

    private static String gy(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        int myPid = Process.myPid();
        if (context == null || myPid <= 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        RunningAppProcessInfo runningAppProcessInfo;
        try {
            for (RunningAppProcessInfo runningAppProcessInfo2 : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo2.pid == myPid) {
                    break;
                }
            }
            runningAppProcessInfo2 = null;
        } catch (Exception e) {
            new StringBuilder("getProcessNameInternal exception:").append(e.getMessage());
            runningAppProcessInfo2 = null;
        }
        if (runningAppProcessInfo2 != null) {
            return runningAppProcessInfo2.processName;
        }
        byte[] bArr = new byte[FileUtils.S_IWUSR];
        try {
            FileInputStream fileInputStream3 = new FileInputStream("/proc/" + myPid + "/cmdline");
            try {
                int read = fileInputStream3.read(bArr);
                if (read > 0) {
                    int i = 0;
                    while (i < read) {
                        if (bArr[i] > Byte.MIN_VALUE || bArr[i] <= (byte) 0) {
                            read = i;
                            break;
                        }
                        i++;
                    }
                    String str = new String(bArr, 0, read);
                    try {
                        fileInputStream3.close();
                        return str;
                    } catch (Exception e2) {
                        return str;
                    }
                }
                try {
                    fileInputStream3.close();
                } catch (Exception e3) {
                }
                return SQLiteDatabase.KeyEmpty;
            } catch (Exception e4) {
                fileInputStream = fileInputStream3;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e5) {
                    }
                }
                return SQLiteDatabase.KeyEmpty;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream3;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                throw th;
            }
        } catch (Exception e7) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return SQLiteDatabase.KeyEmpty;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    private static boolean QF(String str) {
        if (str == null) {
            return false;
        }
        Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2));
            if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String f(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (th.getCause() != null) {
            try {
                th = th.getCause();
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            }
        }
        th.printStackTrace(printStream);
        String Km = Km(byteArrayOutputStream.toString());
        return Km;
    }

    private static String Km(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            return null;
        }
        char c;
        int i = 0;
        while (i < toCharArray.length) {
            if (toCharArray[i] > '') {
                toCharArray[i] = '\u0000';
                c = '\u0001';
                break;
            }
            i++;
        }
        c = '\u0000';
        if (c != '\u0000') {
            return new String(toCharArray, 0, i);
        }
        return str;
    }
}
