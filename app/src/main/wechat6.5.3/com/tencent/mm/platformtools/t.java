package com.tencent.mm.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Debug;
import android.os.IBinder;
import android.os.StatFs;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.j.ad;
import com.tencent.mm.pluginsdk.j.ai;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class t {
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    private static final long[] drm = new long[]{300, 200, 300, 200};

    public static class a {
        public final String toString() {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace == null || stackTrace.length < 4) {
                return SQLiteDatabase.KeyEmpty;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 3; i < stackTrace.length; i++) {
                if (stackTrace[i].getClassName().contains("com.tencent.mm")) {
                    stringBuilder.append("[");
                    stringBuilder.append(stackTrace[i].getClassName().substring(15));
                    stringBuilder.append(":");
                    stringBuilder.append(stackTrace[i].getMethodName());
                    stringBuilder.append("(" + stackTrace[i].getLineNumber() + ")]");
                }
            }
            return stringBuilder.toString();
        }
    }

    public static String lZ(String str) {
        if (str != null) {
            return str.replace("\\[", "[[]").replace("%", SQLiteDatabase.KeyEmpty).replace("\\^", SQLiteDatabase.KeyEmpty).replace("'", SQLiteDatabase.KeyEmpty).replace("\\{", SQLiteDatabase.KeyEmpty).replace("\\}", SQLiteDatabase.KeyEmpty).replace("\"", SQLiteDatabase.KeyEmpty);
        }
        return str;
    }

    public static String b(List<String> list, String str) {
        if (list == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        StringBuilder stringBuilder = new StringBuilder(SQLiteDatabase.KeyEmpty);
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                stringBuilder.append(((String) list.get(i)).trim());
            } else {
                stringBuilder.append(((String) list.get(i)).trim() + str);
            }
        }
        return stringBuilder.toString();
    }

    public static List<String> g(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        for (Object add : strArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static String aw(long j) {
        if ((j >> 20) > 0) {
            return (((float) Math.round((((float) j) * 10.0f) / 1048576.0f)) / 10.0f) + "MB";
        } else if ((j >> 9) <= 0) {
            return j + "B";
        } else {
            return (((float) Math.round((((float) j) * 10.0f) / 1024.0f)) / 10.0f) + "KB";
        }
    }

    public static long Nh() {
        return System.currentTimeMillis() / 1000;
    }

    public static String gH(int i) {
        return String.format("%d:%02d", new Object[]{Long.valueOf(((long) i) / 60), Long.valueOf(((long) i) % 60)});
    }

    public static long Ni() {
        return System.currentTimeMillis();
    }

    public static long ax(long j) {
        return (System.currentTimeMillis() / 1000) - j;
    }

    public static long ay(long j) {
        return System.currentTimeMillis() - j;
    }

    public static long az(long j) {
        return SystemClock.elapsedRealtime() - j;
    }

    public static long Nj() {
        return SystemClock.elapsedRealtime();
    }

    public static boolean bm(Context context) {
        String name = context.getClass().getName();
        String bf = bf(context);
        v.d("MicroMsg.Util", "top activity=" + bf + ", context=" + name);
        return bf.equalsIgnoreCase(name);
    }

    private static String bf(Context context) {
        try {
            String className = ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
            v.i("MicroMsg.Util", "top activity name =" + className);
            return className;
        } catch (Throwable e) {
            v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return "(null)";
        }
    }

    private static boolean m(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static boolean gI(int i) {
        long j = ((long) i) * 1000;
        long currentTimeMillis = j - System.currentTimeMillis();
        v.d("MicroMsg.Util", "time " + j + "  systime " + System.currentTimeMillis() + " diff " + currentTimeMillis);
        if (currentTimeMillis < 0) {
            return true;
        }
        return false;
    }

    public static void Nk() {
        v.w("MicroMsg.Util", "memory usage: h=%s/%s, e=%s/%s, n=%s/%s", aw((long) Debug.getGlobalAllocSize()), aw((long) (Debug.getGlobalAllocSize() + Debug.getGlobalFreedSize())), aw((long) Debug.getGlobalExternalAllocSize()), aw((long) (Debug.getGlobalExternalAllocSize() + Debug.getGlobalExternalFreedSize())), aw(Debug.getNativeHeapAllocatedSize()), aw(Debug.getNativeHeapSize()));
    }

    public static int f(Integer num) {
        return num == null ? 0 : num.intValue();
    }

    public static long d(Long l) {
        return l == null ? 0 : l.longValue();
    }

    public static String ma(String str) {
        return str == null ? SQLiteDatabase.KeyEmpty : str;
    }

    public static boolean b(Boolean bool) {
        return bool == null ? true : bool.booleanValue();
    }

    public static boolean c(Boolean bool) {
        return bool == null ? false : bool.booleanValue();
    }

    public static int g(Integer num) {
        return num == null ? 0 : num.intValue();
    }

    public static long e(Long l) {
        return l == null ? 0 : l.longValue();
    }

    public static boolean a(Boolean bool, boolean z) {
        return bool == null ? z : bool.booleanValue();
    }

    public static String ah(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static int az(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return ((Long) obj).intValue();
        }
        return 0;
    }

    public static boolean kS(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static int getInt(String str, int i) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.parseInt(str);
                }
            } catch (Throwable e) {
                v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return i;
    }

    public static boolean Nl() {
        long blockSize;
        Exception e;
        long j;
        long j2;
        if (!f.sj()) {
            return false;
        }
        StatFs statFs;
        long j3 = 0;
        long j4 = 0;
        StatFs statFs2;
        try {
            statFs2 = new StatFs(e.cni);
            try {
                j3 = (long) statFs2.getBlockCount();
                j4 = (long) statFs2.getAvailableBlocks();
                statFs = statFs2;
                blockSize = (long) statFs2.getBlockSize();
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.Util", "checkSDCardFull", e);
                statFs = statFs2;
                blockSize = 0;
                if (statFs != null) {
                    return false;
                }
                if (j3 > 0) {
                    return false;
                }
                if (j3 - j4 >= 0) {
                    return false;
                }
                j = blockSize * j4;
                j2 = blockSize * j3;
                v.i("MicroMsg.Util", "checkSDCardFull blockCount: %d, availCount: %d, blockSize: %d, totalSize: %d, availSize: %d, used percent: %d", Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(blockSize), Long.valueOf(j2), Long.valueOf(j), Integer.valueOf((int) (((j3 - j4) * 100) / j3)));
                if (95 <= ((int) (((j3 - j4) * 100) / j3))) {
                    return false;
                }
                if (j <= 104857600) {
                    return false;
                }
                v.i("MicroMsg.Util", "checkSDCardFull is full!");
                return true;
            }
        } catch (Exception e3) {
            e = e3;
            statFs2 = null;
            v.e("MicroMsg.Util", "checkSDCardFull", e);
            statFs = statFs2;
            blockSize = 0;
            if (statFs != null) {
                return false;
            }
            if (j3 > 0) {
                return false;
            }
            if (j3 - j4 >= 0) {
                return false;
            }
            j = blockSize * j4;
            j2 = blockSize * j3;
            v.i("MicroMsg.Util", "checkSDCardFull blockCount: %d, availCount: %d, blockSize: %d, totalSize: %d, availSize: %d, used percent: %d", Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(blockSize), Long.valueOf(j2), Long.valueOf(j), Integer.valueOf((int) (((j3 - j4) * 100) / j3)));
            if (95 <= ((int) (((j3 - j4) * 100) / j3))) {
                return false;
            }
            if (j <= 104857600) {
                return false;
            }
            v.i("MicroMsg.Util", "checkSDCardFull is full!");
            return true;
        }
        if (statFs != null) {
            return false;
        }
        if (j3 > 0) {
            return false;
        }
        if (j3 - j4 >= 0) {
            return false;
        }
        j = blockSize * j4;
        j2 = blockSize * j3;
        v.i("MicroMsg.Util", "checkSDCardFull blockCount: %d, availCount: %d, blockSize: %d, totalSize: %d, availSize: %d, used percent: %d", Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(blockSize), Long.valueOf(j2), Long.valueOf(j), Integer.valueOf((int) (((j3 - j4) * 100) / j3)));
        if (95 <= ((int) (((j3 - j4) * 100) / j3))) {
            return false;
        }
        if (j <= 104857600) {
            return false;
        }
        v.i("MicroMsg.Util", "checkSDCardFull is full!");
        return true;
    }

    public static boolean E(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (m(context, intent)) {
            context.startActivity(intent);
            return true;
        }
        v.e("MicroMsg.Util", "jump to url failed, " + str);
        return false;
    }

    public static boolean aY(int i, int i2) {
        return ((double) i2) > ((double) i) * 2.0d;
    }

    public static boolean aZ(int i, int i2) {
        return ((double) i) > ((double) i2) * 2.0d;
    }

    public static a Nm() {
        return new a();
    }

    public static List<String> ai(String str, String str2) {
        List<String> list = null;
        if (str != null) {
            Matcher matcher = Pattern.compile(str2).matcher(str);
            int groupCount = matcher.groupCount();
            list = new ArrayList();
            if (matcher.find()) {
                for (int i = 1; i <= groupCount; i++) {
                    list.add(matcher.group(i));
                }
            }
        }
        return list;
    }

    public static boolean bn(Context context) {
        if (ai.bmA() != null) {
            ai.bmA().aKN();
        }
        if ((com.tencent.mm.sdk.platformtools.f.aPY & 1) != 0) {
            v.e("MicroMsg.Util", "package has set external update mode");
            Uri parse = Uri.parse(com.tencent.mm.sdk.platformtools.f.nhW);
            Intent addFlags = new Intent("android.intent.action.VIEW", parse).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (parse == null || addFlags == null || !m(context, addFlags)) {
                v.e("MicroMsg.Util", "parse market uri failed, jump to weixin.qq.com");
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
                return true;
            }
            v.i("MicroMsg.Util", "parse market uri ok");
            context.startActivity(addFlags);
            return true;
        }
        aa.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", System.currentTimeMillis() / 1000).commit();
        if (ai.bmA() == null) {
            return true;
        }
        ad a = ai.bmA().a(context, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        if (a == null) {
            return false;
        }
        a.update(3);
        return true;
    }

    public static boolean a(Context context, View view) {
        if (view == null) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            v.e("MicroMsg.Util", "hide VKB(View) exception %s", e);
            hideSoftInputFromWindow = false;
        }
        return hideSoftInputFromWindow;
    }
}
