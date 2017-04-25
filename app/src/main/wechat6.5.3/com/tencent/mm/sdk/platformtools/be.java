package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.d;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.lang.Character.UnicodeBlock;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.net.ssl.HttpsURLConnection;
import junit.framework.Assert;

public final class be {
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    private static final char[] dSF = new char[]{'<', '>', '\"', '\'', '&', '\r', '\n', ' ', '\t'};
    private static final String[] dSG = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;"};
    public static final long[] drm = new long[]{300, 200, 300, 200};
    private static final long[] nlR = new long[]{300, 50, 300, 50};

    public static class a {
        private Context context;

        public a(Context context) {
            this.context = context;
        }

        public final String toString() {
            Context context = this.context;
            if (context == null) {
                return null;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String packageName = context.getPackageName();
            if (activityManager == null || be.kS(packageName)) {
                return null;
            }
            List<RunningTaskInfo> runningTasks = activityManager.getRunningTasks(100);
            StringBuffer stringBuffer = new StringBuffer();
            for (RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo.baseActivity.getClassName().startsWith(packageName) || runningTaskInfo.topActivity.getClassName().startsWith(packageName)) {
                    stringBuffer.append(String.format("{id:%d num:%d/%d top:%s base:%s}", new Object[]{Integer.valueOf(runningTaskInfo.id), Integer.valueOf(runningTaskInfo.numRunning), Integer.valueOf(runningTaskInfo.numActivities), runningTaskInfo.topActivity.getShortClassName(), runningTaskInfo.baseActivity.getShortClassName()}));
                }
            }
            return stringBuffer.toString();
        }
    }

    public static String lZ(String str) {
        if (str != null) {
            return str.replace("\\[", "[[]").replace("%", SQLiteDatabase.KeyEmpty).replace("\\^", SQLiteDatabase.KeyEmpty).replace("'", SQLiteDatabase.KeyEmpty).replace("\\{", SQLiteDatabase.KeyEmpty).replace("\\}", SQLiteDatabase.KeyEmpty).replace("\"", SQLiteDatabase.KeyEmpty);
        }
        return str;
    }

    public static String Kt(String str) {
        if (str != null) {
            return str.replace("../", SQLiteDatabase.KeyEmpty);
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

    public static String[] bO(List<String> list) {
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = (String) list.get(i);
        }
        return strArr;
    }

    public static int cW(int i, int i2) {
        Assert.assertTrue(i > i2);
        return new Random(System.currentTimeMillis()).nextInt((i - i2) + 1) + i2;
    }

    public static byte[] buh() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/dev/urandom");
            byte[] bArr = new byte[16];
            int read = fileInputStream.read(bArr);
            fileInputStream.close();
            if (read == 16) {
                return bArr;
            }
        } catch (Throwable e) {
            v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return g.n((UUID.randomUUID().toString() + System.currentTimeMillis()).getBytes());
    }

    public static boolean bui() {
        int i = new GregorianCalendar().get(11);
        return ((long) i) >= 6 && ((long) i) < 18;
    }

    public static String buj() {
        int i;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset() / 1000;
        if (timeZone.useDaylightTime() && timeZone.inDaylightTime(new Date(System.currentTimeMillis()))) {
            i = 1;
        } else {
            i = 0;
        }
        return String.format("%.2f", new Object[]{Double.valueOf((((double) rawOffset) / 3600.0d) + ((double) i))});
    }

    public static String eb(long j) {
        return new SimpleDateFormat("HH:mm:ss").format(new java.util.Date(j));
    }

    public static String ec(long j) {
        return new SimpleDateFormat("[yy-MM-dd HH:mm:ss]").format(new java.util.Date(1000 * j));
    }

    public static boolean d(char c) {
        UnicodeBlock of = UnicodeBlock.of(c);
        if (of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == UnicodeBlock.GENERAL_PUNCTUATION || of == UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    public static boolean Ku(String str) {
        if (kS(str)) {
            return false;
        }
        return Pattern.compile("[\\u4e00-\\u9fa5]+").matcher(str).find();
    }

    public static boolean i(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static boolean Kv(String str) {
        for (char c : str.toCharArray()) {
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                return false;
            }
        }
        return true;
    }

    public static boolean j(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean Kw(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        try {
            long longValue = Long.valueOf(str.trim()).longValue();
            if (longValue <= 0 || longValue > 4294967295L) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return false;
        }
    }

    public static boolean Kx(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.trim().matches("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
    }

    public static byte[] I(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        v.i("MicroMsg.Util", "recycle bitmap:%s", bitmap);
        bitmap.recycle();
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Throwable e) {
            v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return toByteArray;
    }

    public static boolean Ky(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (trim.length() < 6 || trim.length() > 20 || !i(trim.charAt(0))) {
            return false;
        }
        for (int i = 0; i < trim.length(); i++) {
            char charAt = trim.charAt(i);
            if (!i(charAt) && !j(charAt) && charAt != '-' && charAt != '_') {
                return false;
            }
        }
        return true;
    }

    public static boolean Kz(String str) {
        if (str == null || str.length() < 8) {
            return false;
        }
        try {
            Long.parseLong(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static String aw(long j) {
        if ((j >> 30) > 0) {
            return b(j, 10.0d);
        }
        if ((j >> 20) > 0) {
            return a(j, 10.0d);
        }
        if ((j >> 9) <= 0) {
            return j + " B";
        }
        return (((double) Math.round((((double) j) * 10.0d) / 1024.0d)) / 10.0d) + " KB";
    }

    public static String a(long j, double d) {
        return (((double) Math.round((((double) j) * d) / 1048576.0d)) / d) + " MB";
    }

    public static String ed(long j) {
        return a(j, 10.0d);
    }

    public static String b(long j, double d) {
        return (((double) Math.round((((double) j) * d) / 1.073741824E9d)) / d) + " GB";
    }

    public static String bj(byte[] bArr) {
        return A(bArr, 0);
    }

    public static String A(byte[] bArr, int i) {
        int i2 = 0;
        if (bArr == null) {
            return "(null)";
        }
        if (i <= 0) {
            i = bArr.length;
        }
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[((i * 3) + (i / 16))];
        int i3 = 0;
        while (i3 < i + 0) {
            byte b = bArr[i3];
            int i4 = i2 + 1;
            cArr2[i2] = ' ';
            i2 = i4 + 1;
            cArr2[i4] = cArr[(b >>> 4) & 15];
            i4 = i2 + 1;
            cArr2[i2] = cArr[b & 15];
            if (i3 % 16 != 0 || i3 <= 0) {
                i2 = i4;
            } else {
                i2 = i4 + 1;
                cArr2[i4] = '\n';
            }
            i3++;
        }
        return new String(cArr2);
    }

    public static String bk(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            return "(null)";
        }
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int length = bArr.length;
        char[] cArr2 = new char[(length * 3)];
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr2[i2] = ' ';
            int i4 = i3 + 1;
            cArr2[i3] = cArr[(b >>> 4) & 15];
            i2 = i4 + 1;
            cArr2[i4] = cArr[b & 15];
            i++;
        }
        return new String(cArr2);
    }

    public static Intent KA(String str) {
        boolean z = (str == null || str.equals(SQLiteDatabase.KeyEmpty)) ? false : true;
        Assert.assertTrue(z);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        return intent;
    }

    public static void i(String str, Context context) {
        context.startActivity(KA(str));
    }

    public static void j(Context context, boolean z) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator == null) {
            v.w("MicroMsg.Util", "shake:vibrator is null!");
        } else if (z) {
            vibrator.vibrate(drm, -1);
        } else {
            vibrator.cancel();
        }
    }

    public static void dV(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(nlR, -1);
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

    public static long buk() {
        return (System.currentTimeMillis() / 86400000) * 86400000;
    }

    public static long bul() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        return instance.getTimeInMillis();
    }

    public static boolean r(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        if (instance.get(1) == instance2.get(1) && instance.get(5) == instance2.get(5) && instance.get(2) == instance2.get(2)) {
            return true;
        }
        return false;
    }

    public static String dW(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            String deviceId = telephonyManager.getDeviceId();
            return deviceId == null ? null : deviceId.trim();
        } catch (SecurityException e) {
            v.e("MicroMsg.Util", "getDeviceId failed, security exception");
            return null;
        } catch (Throwable e2) {
            v.a("MicroMsg.Util", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }

    public static long bum() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            if (VERSION.SDK_INT < 18) {
                return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } catch (Exception e) {
            v.e("MicroMsg.Util", "getDataAvailableSize exception:%s", e.getMessage());
            return 0;
        }
    }

    public static long dX(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return 0;
        }
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return (memoryInfo.availMem / 1024) / 1024;
    }

    public static String dY(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getLine1Number();
            }
            v.e("MicroMsg.Util", "getLine1Number failed, null tm");
            return null;
        } catch (Throwable e) {
            v.e("MicroMsg.Util", "getLine1Number failed:%s ", af.e(e));
            return null;
        }
    }

    public static String bun() {
        TelephonyManager telephonyManager = (TelephonyManager) aa.getContext().getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        String networkCountryIso = telephonyManager.getNetworkCountryIso();
        if (kS(networkCountryIso)) {
            return null;
        }
        return networkCountryIso.toLowerCase().trim();
    }

    public static String buo() {
        TelephonyManager telephonyManager = (TelephonyManager) aa.getContext().getSystemService("phone");
        if (telephonyManager == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        String simCountryIso = telephonyManager.getSimCountryIso();
        if (kS(simCountryIso)) {
            return SQLiteDatabase.KeyEmpty;
        }
        return simCountryIso.toUpperCase().trim();
    }

    public static boolean bm(Context context) {
        String name = context.getClass().getName();
        String bf = bf(context);
        v.d("MicroMsg.Util", "top activity=" + bf + ", context=" + name);
        return bf.equalsIgnoreCase(name);
    }

    public static boolean aY(Context context, String str) {
        for (RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            if (runningServiceInfo != null && runningServiceInfo.service != null && runningServiceInfo.service.getClassName().toString().equals(str)) {
                v.w("MicroMsg.Util", "service " + str + " is running");
                return true;
            }
        }
        v.w("MicroMsg.Util", "service " + str + " is not running");
        return false;
    }

    public static boolean aZ(Context context, String str) {
        try {
            if (str.equals("com.tencent.mm") || str.startsWith("com.tencent.mm:") || VERSION.SDK_INT < 21) {
                v.i("MicroMsg.Util", "isProcessRunning, use ActivityManager. process = %s", str);
                List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    return false;
                }
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.processName != null && runningAppProcessInfo.processName.equals(str)) {
                        v.w("MicroMsg.Util", "process " + str + " is running");
                        return true;
                    }
                }
            } else {
                v.i("MicroMsg.Util", "isProcessRunning, use ps command. process = %s", str);
                for (String str2 : buv()) {
                    v.d("MicroMsg.Util", "isProcessRunning, process command line = %s", str2);
                    if (str2 != null && str2.contains(str)) {
                        String[] split = str2.split("\\s+");
                        for (Object equals : split) {
                            if (str.equals(equals)) {
                                v.i("MicroMsg.Util", "process %s is running", str);
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
            v.w("MicroMsg.Util", "process " + str + " is not running");
        } catch (Throwable e) {
            v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return false;
    }

    public static String p(Context context, int i) {
        return d.p(context, i);
    }

    public static String bf(Context context) {
        try {
            return ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
        } catch (Throwable e) {
            v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return "(null)";
        }
    }

    public static boolean m(Context context, Intent intent) {
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static String be(Object obj) {
        if (obj != null) {
            return obj.toString();
        }
        return "null";
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

    public static int a(Integer num, int i) {
        return num == null ? i : num.intValue();
    }

    public static byte[] k(byte[] bArr, byte[] bArr2) {
        return bArr == null ? bArr2 : bArr;
    }

    public static long a(Long l, long j) {
        return l == null ? j : l.longValue();
    }

    public static boolean a(Boolean bool, boolean z) {
        return bool == null ? z : bool.booleanValue();
    }

    public static String ah(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static int n(Object obj, int i) {
        if (obj == null) {
            return i;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return ((Long) obj).intValue();
        }
        return i;
    }

    public static long bf(Object obj) {
        if (obj != null && (obj instanceof Long)) {
            return ((Long) obj).longValue();
        }
        return 0;
    }

    public static boolean bP(List list) {
        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean kS(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    public static boolean D(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() <= 0) {
            return true;
        }
        return false;
    }

    public static boolean bl(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return true;
        }
        return false;
    }

    public static int KB(String str) {
        if (str == null) {
            return -1;
        }
        return str.length();
    }

    public static int bm(byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        return bArr.length;
    }

    public static int KC(String str) {
        int i = 0;
        if (kS(str)) {
            return i;
        }
        try {
            return (int) (new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime() / 1000);
        } catch (Throwable e) {
            v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[i]);
            return i;
        }
    }

    public static int getInt(String str, int i) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.decode(str).intValue();
                }
            } catch (Throwable e) {
                v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return i;
    }

    public static long getLong(String str, long j) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    j = Long.decode(str).longValue();
                }
            } catch (Throwable e) {
                v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return j;
    }

    public static float getFloat(String str, float f) {
        if (str != null) {
            try {
                f = Float.parseFloat(str);
            } catch (Throwable e) {
                v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return f;
    }

    public static double getDouble(String str, double d) {
        if (str != null) {
            try {
                d = Double.parseDouble(str);
            } catch (Throwable e) {
                v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return d;
    }

    public static int KD(String str) {
        int i = 0;
        if (str == null) {
            return i;
        }
        try {
            return (int) (Long.decode(str).longValue() & 4294967295L);
        } catch (Throwable e) {
            v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[i]);
            return i;
        }
    }

    public static boolean cw(View view) {
        boolean hideSoftInputFromWindow;
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager == null) {
                return false;
            }
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
            v.v("MicroMsg.Util", "hide VKB result %B", Boolean.valueOf(hideSoftInputFromWindow));
            return hideSoftInputFromWindow;
        } catch (Throwable e) {
            v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.Util", "hide VKB exception %s", e);
            hideSoftInputFromWindow = false;
        }
    }

    public static String KE(String str) {
        if (str == null) {
            str = SQLiteDatabase.KeyEmpty;
        }
        if (str.length() <= 16) {
            return g.m(str.getBytes());
        }
        return g.m(str.substring(0, 16).getBytes());
    }

    public static String KF(String str) {
        return g.m(str.getBytes());
    }

    public static String e(InputStream inputStream) {
        return d.e(inputStream);
    }

    public static String bn(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(SQLiteDatabase.KeyEmpty);
        if (bArr != null) {
            for (int i = 0; i < bArr.length; i++) {
                stringBuilder.append(String.format("%02x", new Object[]{Integer.valueOf(bArr[i] & WebView.NORMAL_MODE_ALPHA)}));
            }
        }
        return stringBuilder.toString();
    }

    public static byte[] KG(String str) {
        if (str == null || str.length() <= 0) {
            return new byte[0];
        }
        try {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) (Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16) & WebView.NORMAL_MODE_ALPHA);
            }
            return bArr;
        } catch (Throwable e) {
            v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return new byte[0];
        }
    }

    public static int[] KH(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        List arrayList = new ArrayList();
        for (String str2 : split) {
            if (str2 != null && str2.length() > 0) {
                try {
                    arrayList.add(Integer.valueOf(Integer.valueOf(str2).intValue()));
                } catch (Throwable e) {
                    v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.e("MicroMsg.Util", "invalid port num, ignore");
                }
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return iArr;
    }

    public static int dB(String str, String str2) {
        ZipInputStream zipInputStream;
        Throwable e;
        try {
            zipInputStream = new ZipInputStream(new FileInputStream(str));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!(name.contains("../") || name.contains("..\\"))) {
                            if (nextEntry.isDirectory()) {
                                new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                            } else {
                                File file = new File(str2 + File.separator + name);
                                file.createNewFile();
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                    fileOutputStream.flush();
                                }
                                fileOutputStream.close();
                            }
                        }
                    } else {
                        try {
                            zipInputStream.close();
                            return 0;
                        } catch (IOException e2) {
                            v.e("MicroMsg.Util", "close zip stream failed.");
                            return 0;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                } catch (IOException e4) {
                    e = e4;
                }
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            zipInputStream = null;
            try {
                v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                if (zipInputStream != null) {
                    try {
                        zipInputStream.close();
                    } catch (IOException e6) {
                        v.e("MicroMsg.Util", "close zip stream failed.");
                    }
                }
                return -1;
            } catch (Throwable th) {
                e = th;
                if (zipInputStream != null) {
                    try {
                        zipInputStream.close();
                    } catch (IOException e7) {
                        v.e("MicroMsg.Util", "close zip stream failed.");
                    }
                }
                throw e;
            }
        } catch (IOException e8) {
            e = e8;
            zipInputStream = null;
            v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (IOException e9) {
                    v.e("MicroMsg.Util", "close zip stream failed.");
                }
            }
            return -2;
        } catch (Throwable th2) {
            e = th2;
            zipInputStream = null;
            if (zipInputStream != null) {
                zipInputStream.close();
            }
            throw e;
        }
    }

    public static final String KI(String str) {
        if (kS(str)) {
            return SQLiteDatabase.KeyEmpty;
        }
        try {
            return new URL(str).getHost();
        } catch (Throwable e) {
            v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.w("MicroMsg.Util", "get host error");
            return str;
        }
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

    public static String KJ(String str) {
        if (str == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            Object obj = 1;
            for (int length2 = dSF.length - 1; length2 >= 0; length2--) {
                if (dSF[length2] == charAt) {
                    stringBuffer.append(dSG[length2]);
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static String KK(String str) {
        if (str == null || str.length() == 0 || VERSION.SDK_INT >= 8) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        while (i < length) {
            char charAt = str.charAt(i);
            int i4 = i2 + 1;
            cArr[i2] = charAt;
            if (charAt == '&' && i3 == -1) {
                i3 = i4;
            } else if (!(i3 == -1 || Character.isLetter(charAt) || Character.isDigit(charAt) || charAt == '#')) {
                if (charAt == ';') {
                    i2 = a(cArr, i3, (i4 - i3) - 1);
                    if (i2 > 65535) {
                        i4 = i2 - 65536;
                        cArr[i3 - 1] = (char) ((i4 >> 10) + 55296);
                        cArr[i3] = (char) ((i4 & 1023) + 56320);
                        i3++;
                    } else if (i2 != 0) {
                        cArr[i3 - 1] = (char) i2;
                    } else {
                        i3 = i4;
                    }
                    i4 = i3;
                    i3 = -1;
                } else {
                    i3 = -1;
                }
            }
            i++;
            i2 = i4;
        }
        return new String(cArr, 0, i2);
    }

    private static int a(char[] cArr, int i, int i2) {
        int i3 = 0;
        if (i2 > 0) {
            if (cArr[i] != '#') {
                String str = new String(cArr, i, i2);
            } else if (i2 <= 1 || !(cArr[i + 1] == 'x' || cArr[i + 1] == 'X')) {
                try {
                    i3 = Integer.parseInt(new String(cArr, i + 1, i2 - 1), 10);
                } catch (NumberFormatException e) {
                }
            } else {
                try {
                    i3 = Integer.parseInt(new String(cArr, i + 2, i2 - 2), 16);
                } catch (NumberFormatException e2) {
                }
            }
        }
        return i3;
    }

    public static String a(LinkedHashMap<String, String> linkedHashMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<key>");
        for (Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key == null) {
                key = "unknow";
            }
            if (value == null) {
                value = "unknow";
            }
            stringBuilder.append("<" + key + ">");
            stringBuilder.append(value);
            stringBuilder.append("</" + key + ">");
        }
        stringBuilder.append("</key>");
        return stringBuilder.toString();
    }

    public static int KL(String str) {
        int i = 0;
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            if (str != null) {
                v.e("MicroMsg.Util", "parserInt error " + str);
            }
        }
        return i;
    }

    public static long KM(String str) {
        long j = 0;
        try {
            j = Long.parseLong(str);
        } catch (Exception e) {
            if (str != null) {
                v.e("MicroMsg.Util", "parseLong error " + str);
            }
        }
        return j;
    }

    public static double KN(String str) {
        double d = 0.0d;
        try {
            d = Double.parseDouble(str);
        } catch (Exception e) {
            if (str != null) {
                v.e("MicroMsg.Util", "parseDouble error " + str);
            }
        }
        return d;
    }

    public static boolean deleteFile(String str) {
        if (kS(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            return false;
        }
        return file.delete();
    }

    public static void f(String str, String str2, long j) {
        if (!kS(str)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        if (file2.isFile() && file2.getName().startsWith(str2) && (System.currentTimeMillis() - file2.lastModified()) - j >= 0) {
                            file2.delete();
                        }
                    }
                }
            }
        }
    }

    public static byte[] readFromFile(String str) {
        FileInputStream fileInputStream;
        Throwable e;
        Throwable e2;
        if (kS(str)) {
            v.w("MicroMsg.Util", "readFromFile error, path is null or empty");
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            try {
                int length = (int) file.length();
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[length];
                    if (fileInputStream.read(bArr) != length) {
                        v.w("MicroMsg.Util", "readFromFile error, size is not equal, path = %s, file length is %d, count is %d", str, Integer.valueOf(length), Integer.valueOf(fileInputStream.read(bArr)));
                        try {
                            fileInputStream.close();
                            return null;
                        } catch (Throwable e3) {
                            v.a("MicroMsg.Util", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                            return null;
                        }
                    }
                    v.d("MicroMsg.Util", "readFromFile ok!");
                    try {
                        fileInputStream.close();
                    } catch (Throwable e22) {
                        v.a("MicroMsg.Util", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                    return bArr;
                } catch (Exception e4) {
                    e3 = e4;
                    try {
                        v.a("MicroMsg.Util", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                        if (fileInputStream != null) {
                            return null;
                        }
                        try {
                            fileInputStream.close();
                            return null;
                        } catch (Throwable e32) {
                            v.a("MicroMsg.Util", e32, SQLiteDatabase.KeyEmpty, new Object[0]);
                            return null;
                        }
                    } catch (Throwable th) {
                        e22 = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e322) {
                                v.a("MicroMsg.Util", e322, SQLiteDatabase.KeyEmpty, new Object[0]);
                            }
                        }
                        throw e22;
                    }
                }
            } catch (Exception e5) {
                e322 = e5;
                fileInputStream = null;
                v.a("MicroMsg.Util", e322, SQLiteDatabase.KeyEmpty, new Object[0]);
                if (fileInputStream != null) {
                    return null;
                }
                fileInputStream.close();
                return null;
            } catch (Throwable e3222) {
                fileInputStream = null;
                e22 = e3222;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e22;
            }
        }
        v.w("MicroMsg.Util", "readFromFile error, file is not exit, path = %s", str);
        return null;
    }

    public static boolean p(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Throwable e;
        if (kS(str) || bl(bArr)) {
            v.w("MicroMsg.Util", "write to file error, path is null or empty, or data is empty");
            return false;
        }
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (Throwable e2) {
                    v.a("MicroMsg.Util", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                v.d("MicroMsg.Util", "writeToFile ok!");
                return true;
            } catch (Exception e3) {
                e2 = e3;
                try {
                    v.a("MicroMsg.Util", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.w("MicroMsg.Util", "write to file error");
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Throwable e22) {
                        v.a("MicroMsg.Util", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            v.a("MicroMsg.Util", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            fileOutputStream = null;
            v.a("MicroMsg.Util", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.w("MicroMsg.Util", "write to file error");
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th2) {
            e22 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e22;
        }
    }

    public static String dZ(Context context) {
        if (context == null) {
            return null;
        }
        return j(context.getPackageName(), context);
    }

    public static String j(String str, Context context) {
        String str2 = null;
        if (context == null || kS(str)) {
            return str2;
        }
        try {
            return g.m(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
        } catch (Throwable e) {
            v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return str2;
        }
    }

    public static boolean bup() {
        String e = u.e(aa.getContext().getSharedPreferences(aa.bti(), 0));
        String bsY = u.bsY();
        if (!e.equals("language_default")) {
            bsY = e;
        }
        if (!bsY.equals("zh_CN")) {
            return true;
        }
        if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            return true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) aa.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            bsY = telephonyManager.getNetworkCountryIso();
            if (!(kS(bsY) || bsY.contains("cn") || bsY.contains("CN"))) {
                return true;
            }
        }
        return false;
    }

    public static boolean He() {
        if (!Locale.getDefault().equals(Locale.CHINA)) {
            return true;
        }
        if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            return true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) aa.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!(kS(networkCountryIso) || networkCountryIso.contains("cn") || networkCountryIso.contains("CN"))) {
                return true;
            }
        }
        return false;
    }

    public static OnTouchListener buq() {
        return new OnTouchListener() {
            public final boolean onTouch(final View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        break;
                    case 1:
                    case 3:
                    case 4:
                        view.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 nlS;

                            public final void run() {
                                view.setPressed(false);
                            }
                        });
                        break;
                }
                return false;
            }
        };
    }

    public static byte[] KO(String str) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.Util", "httpGet, url is null");
            return null;
        } else if (URLUtil.isDataUrl(str)) {
            return KR(str);
        } else {
            if (URLUtil.isHttpsUrl(str)) {
                return KQ(str);
            }
            return KP(str);
        }
    }

    private static byte[] KP(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            if (httpURLConnection.getResponseCode() != 200) {
                v.e("MicroMsg.Util", "http get response code = %d", Integer.valueOf(httpURLConnection.getResponseCode()));
                return null;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            for (int read = bufferedInputStream.read(bArr); read > 0; read = bufferedInputStream.read(bArr)) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            bufferedInputStream.close();
            byteArrayOutputStream.close();
            return toByteArray;
        } catch (Exception e) {
            v.e("MicroMsg.Util", "http download failed : %s", e.getMessage());
            return null;
        }
    }

    private static byte[] KQ(String str) {
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setRequestMethod("GET");
            if (httpsURLConnection.getResponseCode() != 200) {
                v.e("MicroMsg.Util", "https get response code = %d", Integer.valueOf(httpsURLConnection.getResponseCode()));
                return null;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpsURLConnection.getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            for (int read = bufferedInputStream.read(bArr); read > 0; read = bufferedInputStream.read(bArr)) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            bufferedInputStream.close();
            byteArrayOutputStream.close();
            return toByteArray;
        } catch (Exception e) {
            v.e("MicroMsg.Util", "getHttpsData failed : %s", e.getMessage());
            return null;
        }
    }

    private static byte[] KR(String str) {
        try {
            int indexOf = str.indexOf("base64");
            if (indexOf > 0) {
                str = str.substring(indexOf + 7);
            }
            return Base64.decode(str, 0);
        } catch (Exception e) {
            v.e("MicroMsg.Util", "decode base64 url failed : %s", e.getMessage());
            return null;
        }
    }

    public static CharSequence E(CharSequence charSequence) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static String vt(String str) {
        return str.replaceAll("[\\.\\-]", SQLiteDatabase.KeyEmpty).trim();
    }

    public static String KS(String str) {
        int i = 0;
        if (kS(str) || str.startsWith("+")) {
            return SQLiteDatabase.KeyEmpty;
        }
        if (str.length() <= 5) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.subSequence(0, 3));
        while (i < str.length() - 5) {
            char charAt = str.charAt(i + 3);
            if (charAt < '0' || charAt > '9') {
                stringBuffer.append(charAt);
            } else {
                stringBuffer.append('*');
            }
            i++;
        }
        stringBuffer.append(str.charAt(str.length() - 2));
        stringBuffer.append(str.charAt(str.length() - 1));
        return stringBuffer.toString();
    }

    public static Boolean KT(String str) {
        boolean z = Pattern.compile("^[+][0-9]{10,13}$").matcher(str).matches() || Pattern.compile("^1[0-9]{10}$").matcher(str).matches();
        return Boolean.valueOf(z);
    }

    public static String formatNumber(String str) {
        if (kS(str)) {
            return SQLiteDatabase.KeyEmpty;
        }
        String replaceAll = str.replaceAll(",", SQLiteDatabase.KeyEmpty);
        if (replaceAll.length() <= 3) {
            return replaceAll;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = replaceAll.length() - 1;
        while (length >= 0) {
            stringBuffer.append(replaceAll.charAt(length));
            if ((replaceAll.length() - length) % 3 == 0 && length != 0) {
                stringBuffer.append(",");
            }
            length--;
        }
        return stringBuffer.reverse().toString();
    }

    public static af bur() {
        return new af();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String k(java.io.InputStream r6) {
        /*
        r5 = 0;
        if (r6 != 0) goto L_0x0005;
    L_0x0003:
        r0 = 0;
    L_0x0004:
        return r0;
    L_0x0005:
        r0 = new java.lang.StringBuffer;
        r0.<init>();
        r1 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r1 = new byte[r1];	 Catch:{ Exception -> 0x001f, all -> 0x0046 }
    L_0x000e:
        r2 = r6.read(r1);	 Catch:{ Exception -> 0x001f, all -> 0x0046 }
        r3 = -1;
        if (r2 == r3) goto L_0x0028;
    L_0x0015:
        r3 = new java.lang.String;	 Catch:{ Exception -> 0x001f, all -> 0x0046 }
        r4 = 0;
        r3.<init>(r1, r4, r2);	 Catch:{ Exception -> 0x001f, all -> 0x0046 }
        r0.append(r3);	 Catch:{ Exception -> 0x001f, all -> 0x0046 }
        goto L_0x000e;
    L_0x001f:
        r1 = move-exception;
        r6.close();	 Catch:{ IOException -> 0x0039 }
    L_0x0023:
        r0 = r0.toString();
        goto L_0x0004;
    L_0x0028:
        r6.close();	 Catch:{ IOException -> 0x002c }
        goto L_0x0023;
    L_0x002c:
        r1 = move-exception;
        r2 = "MicroMsg.Util";
        r3 = "";
        r4 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
        goto L_0x0023;
    L_0x0039:
        r1 = move-exception;
        r2 = "MicroMsg.Util";
        r3 = "";
        r4 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
        goto L_0x0023;
    L_0x0046:
        r0 = move-exception;
        r6.close();	 Catch:{ IOException -> 0x004b }
    L_0x004a:
        throw r0;
    L_0x004b:
        r1 = move-exception;
        r2 = "MicroMsg.Util";
        r3 = "";
        r4 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.be.k(java.io.InputStream):java.lang.String");
    }

    public static String KU(String str) {
        if (str == null || str.length() <= 0) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf("@");
        if (lastIndexOf != -1) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static long KV(String str) {
        if (kS(str)) {
            return 0;
        }
        try {
            v.i("MicroMsg.Util", "todate:[%d], now date:[%d]", Long.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime()), Long.valueOf(System.currentTimeMillis()));
            return System.currentTimeMillis() - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
        } catch (Throwable e) {
            v.a("MicroMsg.Util", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return 0;
        }
    }

    public static String KW(String str) {
        if (kS(str)) {
            return SQLiteDatabase.KeyEmpty;
        }
        int length = str.length();
        if (length < 4) {
            return "*~" + length;
        }
        if (length < 8) {
            return str.substring(0, 1) + "*" + str.substring(length - 2, length - 1) + "~" + length;
        }
        return str.substring(0, 2) + "*" + str.substring(length - 3, length - 1) + "~" + length;
    }

    public static String e(Throwable th) {
        return af.e(th);
    }

    public static int bus() {
        return new Random().nextInt();
    }

    private static String a(Context context, Uri uri, String str, String[] strArr) {
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int columnIndex = query.getColumnIndex("_data");
                        if (columnIndex == -1) {
                            v.e("MicroMsg.Util", "getDataColumn : columnIdx is -1, column with columnName = _data does not exist");
                            query.close();
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        }
                        String string = query.getString(columnIndex);
                        if (query == null) {
                            return string;
                        }
                        query.close();
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @TargetApi(19)
    public static String d(Context context, Uri uri) {
        Uri uri2 = null;
        if (context == null || uri == null) {
            v.e("MicroMsg.Util", "getFilePath : context is null or uri is null");
            return null;
        }
        String scheme = uri.getScheme();
        if (kS(scheme)) {
            v.e("MicroMsg.Util", "input uri error. %s", uri);
            return null;
        } else if (scheme.equalsIgnoreCase("file")) {
            v.i("MicroMsg.Util", "getFilePath : scheme is SCHEME_FILE");
            return uri.getPath();
        } else {
            if (scheme.equalsIgnoreCase("content")) {
                v.i("MicroMsg.Util", "getFilePath : scheme is SCHEME_CONTENT: " + uri.toString());
                if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
                    return uri.getLastPathSegment();
                }
                try {
                    context.grantUriPermission(uri.getAuthority(), uri, 1);
                    scheme = a(context, uri, null, null);
                } catch (SecurityException e) {
                    v.e("MicroMsg.Util", "getFilePath : exception = " + e);
                    scheme = null;
                }
                if (!kS(scheme)) {
                    return scheme;
                }
                if (VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(context, uri)) {
                    String[] split;
                    if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                        split = DocumentsContract.getDocumentId(uri).split(":");
                        if ("primary".equalsIgnoreCase(split[0])) {
                            return Environment.getExternalStorageDirectory() + "/" + split[1];
                        }
                        return null;
                    } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                        return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    } else if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                        Object obj = DocumentsContract.getDocumentId(uri).split(":")[0];
                        if ("image".equals(obj)) {
                            uri2 = Media.EXTERNAL_CONTENT_URI;
                        } else if ("video".equals(obj)) {
                            uri2 = Video.Media.EXTERNAL_CONTENT_URI;
                        } else if ("audio".equals(obj)) {
                            uri2 = Audio.Media.EXTERNAL_CONTENT_URI;
                        }
                        return a(context, uri2, "_id=?", new String[]{split[1]});
                    }
                }
            }
            v.e("MicroMsg.Util", "unknown scheme");
            return null;
        }
    }

    public static boolean l(Uri uri) {
        if (uri == null) {
            return false;
        }
        if ("file".equals(uri.getScheme())) {
            return ts(uri.getPath());
        }
        return true;
    }

    public static boolean ts(String str) {
        if (kS(str)) {
            return false;
        }
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            if (canonicalPath.contains("/com.tencent.mm/cache/")) {
                return true;
            }
            if (canonicalPath.contains("/com.tencent.mm/")) {
                return false;
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean KX(String str) {
        if (kS(str)) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1) {
            return KY(str.substring(lastIndexOf + 1));
        }
        return false;
    }

    public static boolean KY(String str) {
        if (kS(str)) {
            return false;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.equals("webp") && VERSION.SDK_INT >= 14) {
            return true;
        }
        if (toLowerCase.equals("jpg") || toLowerCase.equals("gif") || toLowerCase.equals("bmp") || toLowerCase.equals("jpeg") || toLowerCase.equals("png")) {
            return true;
        }
        return false;
    }

    public static a ea(Context context) {
        return new a(context);
    }

    public static ComponentName eb(Context context) {
        try {
            List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            if (runningTasks == null || runningTasks.size() <= 0) {
                return null;
            }
            return ((RunningTaskInfo) runningTasks.get(0)).topActivity;
        } catch (Exception e) {
            v.e("MicroMsg.Util", "get Top Activity Exception:%s", e.getMessage());
            return null;
        }
    }

    public static String ec(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String className;
            if (VERSION.SDK_INT >= 23) {
                List appTasks = activityManager.getAppTasks();
                if (appTasks == null || appTasks.size() <= 0) {
                    return SQLiteDatabase.KeyEmpty;
                }
                Iterator it = appTasks.iterator();
                if (it.hasNext()) {
                    ComponentName componentName = ((AppTask) it.next()).getTaskInfo().topActivity;
                    if (componentName == null) {
                        return null;
                    }
                    className = componentName.getClassName();
                    if (className.contains(".")) {
                        return className.substring(className.lastIndexOf(".") + 1);
                    }
                    return className;
                }
                return SQLiteDatabase.KeyEmpty;
            }
            className = ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity.getClassName();
            if (className.contains(".")) {
                return className.substring(className.lastIndexOf(".") + 1);
            }
            return className;
        } catch (Throwable e) {
            v.e("MicroMsg.Util", "getTopActivityName Exception:%s stack:%s", e.getMessage(), af.e(e));
        }
    }

    public static RunningTaskInfo U(Context context, int i) {
        for (RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1000)) {
            if (runningTaskInfo.id == i) {
                return runningTaskInfo;
            }
        }
        return null;
    }

    public static String N(float f) {
        if (f < 1024.0f) {
            return String.format("%.1fB", new Object[]{Float.valueOf(f)});
        } else if (f < 1048576.0f) {
            return String.format("%.1fKB", new Object[]{Float.valueOf(f / 1024.0f)});
        } else if (f < 1.07374182E9f) {
            return String.format("%.1fMB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
        } else {
            return String.format("%.1fGB", new Object[]{Float.valueOf(((f / 1024.0f) / 1024.0f) / 1024.0f)});
        }
    }

    public static boolean r(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null || !obj.equals(obj2)) {
            return false;
        }
        return true;
    }

    public static void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                v.a("MicroMsg.Util", e, "qualityClose", new Object[0]);
            }
        }
    }

    public static Locale ed(Context context) {
        String d = u.d(context.getSharedPreferences(aa.bti(), 0));
        if (d.equals("language_default")) {
            u.a(context, Locale.ENGLISH);
            return Locale.getDefault();
        }
        Locale Ke = u.Ke(d);
        u.a(context, Ke);
        return Ke;
    }

    public static String but() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            stringBuffer.append(str.charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    public static void k(View view, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i2;
        rect.bottom += i4;
        rect.left -= i;
        rect.right += i3;
        TouchDelegate touchDelegate = new TouchDelegate(rect, view);
        if (View.class.isInstance(view.getParent())) {
            ((View) view.getParent()).setTouchDelegate(touchDelegate);
        }
    }

    public static String KZ(String str) {
        return kS(str) ? str : str.replaceAll("‮", SQLiteDatabase.KeyEmpty);
    }

    public static long bo(byte[] bArr) {
        if (bl(bArr)) {
            return 0;
        }
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        return crc32.getValue();
    }

    public static int aA(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        return wrap.getInt();
    }

    public static final String La(String str) {
        if (kS(str)) {
            return null;
        }
        return Uri.parse(str).getHost();
    }

    public static boolean buu() {
        String property = System.getProperty("java.vm.version");
        if (kS(property) || !property.startsWith("2")) {
            return false;
        }
        return true;
    }

    private static List<String> buv() {
        LineNumberReader lineNumberReader;
        Exception e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        try {
            Process exec = Runtime.getRuntime().exec("ps");
            lineNumberReader = new LineNumberReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = lineNumberReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.length() > 0) {
                        arrayList.add(readLine);
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            exec.waitFor();
            exec.destroy();
            try {
                lineNumberReader.close();
            } catch (Exception e3) {
                v.e("MicroMsg.Util", "getRunningProcessesByPs finally got ex = %s", e3.getMessage());
            }
        } catch (Exception e4) {
            e3 = e4;
            lineNumberReader = null;
            try {
                v.e("MicroMsg.Util", "getRunningAppProcessesByPs fail, ex = %s", e3.getMessage());
                if (lineNumberReader != null) {
                    try {
                        lineNumberReader.close();
                    } catch (Exception e32) {
                        v.e("MicroMsg.Util", "getRunningProcessesByPs finally got ex = %s", e32.getMessage());
                    }
                }
                v.i("MicroMsg.Util", "getRunningAppProcessesByPs, result list size = %d", Integer.valueOf(arrayList.size()));
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                if (lineNumberReader != null) {
                    try {
                        lineNumberReader.close();
                    } catch (Exception e5) {
                        v.e("MicroMsg.Util", "getRunningProcessesByPs finally got ex = %s", e5.getMessage());
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            lineNumberReader = null;
            if (lineNumberReader != null) {
                lineNumberReader.close();
            }
            throw th;
        }
        v.i("MicroMsg.Util", "getRunningAppProcessesByPs, result list size = %d", Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    public static boolean dC(String str, String str2) {
        if (kS(str) && kS(str2)) {
            return true;
        }
        if (kS(str) && !kS(str2)) {
            return false;
        }
        if (kS(str) || !kS(str2)) {
            return str.equals(str2);
        }
        return false;
    }

    public static boolean cX(int i, int i2) {
        return i == i2;
    }

    public static boolean s(long j, long j2) {
        return j == j2;
    }

    public static boolean isEqual(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    public static boolean buw() {
        return f.aPW == 1;
    }

    public static int bux() {
        Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) aa.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()});
        if (processMemoryInfo == null || processMemoryInfo.length <= 0) {
            return 0;
        }
        return processMemoryInfo[0].getTotalPss() / 1024;
    }

    public static String g(String str, Object... objArr) {
        try {
            str = String.format(str, objArr);
        } catch (Exception e) {
            v.i("MicroMsg.Util", "error safeFormatString %s", e.getMessage());
        }
        return str;
    }

    public static Intent v(Context context, Intent intent) {
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        ResolveInfo resolveInfo = (ResolveInfo) queryIntentServices.get(0);
        v.d("MicroMsg.Util", "createExplicitFromImplicitIntent pa:%s, cl:%s", resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        ComponentName componentName = new ComponentName(r1, r0);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        return intent2;
    }

    public static int am(String str, int i) {
        if (str != null && str.length() == 7 && str.startsWith("#")) {
            try {
                String toUpperCase = str.substring(1).toUpperCase();
                i = Color.argb(WebView.NORMAL_MODE_ALPHA, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
            } catch (Throwable e) {
                v.a("MicroMsg.Util", e, "colorString:%s", str);
            }
        } else {
            v.e("MicroMsg.Util", "string format error, colorString:%s", str);
        }
        return i;
    }

    public static int ee(long j) {
        return Math.round(((float) j) / 1000.0f);
    }
}
