package com.tencent.wxop.stat.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wxop.stat.b;
import com.tencent.wxop.stat.e;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public final class l {
    private static String a = null;
    private static String b = null;
    private static String c = null;
    private static String d = null;
    private static String g = null;
    private static String h = "";
    private static String i = "";
    private static int j = -1;
    private static String l = null;
    private static String m = null;
    private static volatile int n = -1;
    private static String o = null;
    private static String p = null;
    private static String pLK = "";
    private static Random pLS = null;
    private static DisplayMetrics pLT = null;
    private static b pLU = null;
    private static o pLV = null;
    private static long q = -1;
    private static String t = "__MTA_FIRST_ACTIVATE__";
    private static int u = -1;
    private static long v = -1;
    private static int w = 0;
    private static String x = "";

    public static long QZ(String str) {
        return a(str, ".", Long.valueOf(0)).longValue();
    }

    public static int a() {
        return bQA().nextInt(Integer.MAX_VALUE);
    }

    private static Long a(String str, String str2, Long l) {
        if (str == null) {
            return l;
        }
        if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
            str2 = "\\" + str2;
        }
        String[] split = str.split(str2);
        if (split.length != 3) {
            return l;
        }
        try {
            Long valueOf = Long.valueOf(0);
            int i = 0;
            while (i < split.length) {
                Long valueOf2 = Long.valueOf(100 * (valueOf.longValue() + Long.valueOf(split[i]).longValue()));
                i++;
                valueOf = valueOf2;
            }
            return valueOf;
        } catch (NumberFormatException e) {
            return l;
        }
    }

    public static String a(String str) {
        if (str == null) {
            return "0";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            return "0";
        }
    }

    public static boolean a(e eVar) {
        return eVar == null ? false : c(eVar.a);
    }

    public static byte[] a(byte[] bArr) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[Downloads.RECV_BUFFER_SIZE];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return bArr2;
            }
        }
    }

    public static void af(Context context, int i) {
        w = i;
        q.n(context, "mta.qq.com.difftime", i);
    }

    public static synchronized String b(Context context) {
        String a;
        synchronized (l.class) {
            if (a == null || a.trim().length() == 0) {
                a = r.a(context);
                a = a;
                if (a == null || a.trim().length() == 0) {
                    a = Integer.toString(bQA().nextInt(Integer.MAX_VALUE));
                }
                a = a;
            } else {
                a = a;
            }
        }
        return a;
    }

    public static String bC(Context context, String str) {
        if (!b.bQl()) {
            return str;
        }
        if (m == null) {
            m = hf(context);
        }
        return m != null ? str + "_" + m : str;
    }

    private static synchronized Random bQA() {
        Random random;
        synchronized (l.class) {
            if (pLS == null) {
                pLS = new Random();
            }
            random = pLS;
        }
        return random;
    }

    public static int bQB() {
        if (j != -1) {
            return j;
        }
        try {
            if (p.a()) {
                j = 1;
            }
        } catch (Throwable th) {
            pLU.i(th);
        }
        j = 0;
        return 0;
    }

    public static synchronized b bQC() {
        b bVar;
        synchronized (l.class) {
            if (pLU == null) {
                bVar = new b("MtaSDK");
                pLU = bVar;
                bVar.b = false;
            }
            bVar = pLU;
        }
        return bVar;
    }

    public static String bQD() {
        Calendar instance = Calendar.getInstance();
        instance.roll(6, 0);
        return new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
    }

    private static long bQE() {
        if (q > 0) {
            return q;
        }
        long j = 1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            j = (long) (Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024);
            bufferedReader.close();
        } catch (Exception e) {
        }
        q = j;
        return j;
    }

    public static JSONObject bQF() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", m.a());
            String d = m.d();
            if (d != null && d.length() > 0) {
                jSONObject.put("na", d);
            }
            int b = m.b();
            if (b > 0) {
                jSONObject.put("fx", b / 1000000);
            }
            b = m.c();
            if (b > 0) {
                jSONObject.put("fn", b / 1000000);
            }
        } catch (Throwable th) {
        }
        return jSONObject;
    }

    public static long c() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTimeInMillis() + 86400000;
        } catch (Throwable th) {
            pLU.i(th);
            return System.currentTimeMillis() + 86400000;
        }
    }

    public static synchronized String c(Context context) {
        String str;
        synchronized (l.class) {
            if (c == null || c.trim().length() == 0) {
                c = r.b(context);
            }
            str = c;
        }
        return str;
    }

    public static boolean c(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static String d() {
        if (c(p)) {
            return p;
        }
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        String str = String.valueOf((((long) statFs2.getAvailableBlocks()) * ((long) statFs2.getBlockSize())) / 1000000) + "/" + String.valueOf(blockCount);
        p = str;
        return str;
    }

    public static String eM(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    public static String f(Context context) {
        if (b != null) {
            return b;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("TA_APPKEY");
                if (string != null) {
                    b = string;
                    return string;
                }
                pLU.bw("Could not read APPKEY meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            pLU.bw("Could not read APPKEY meta-data from AndroidManifest.xml");
        }
        return null;
    }

    public static HttpHost gU(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return null;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo == null) {
                return null;
            }
            if (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap")) {
                return new HttpHost("10.0.0.172", 80);
            }
            if (extraInfo.equals("ctwap")) {
                return new HttpHost("10.0.0.200", 80);
            }
            String defaultHost = Proxy.getDefaultHost();
            if (defaultHost != null && defaultHost.trim().length() > 0) {
                return new HttpHost(defaultHost, Proxy.getDefaultPort());
            }
            return null;
        } catch (Throwable th) {
            pLU.i(th);
        }
    }

    public static DisplayMetrics gV(Context context) {
        if (pLT == null) {
            pLT = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(pLT);
        }
        return pLT;
    }

    public static boolean gW(Context context) {
        try {
            if (r.k(context, "android.permission.ACCESS_WIFI_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                    if (allNetworkInfo != null) {
                        int i = 0;
                        while (i < allNetworkInfo.length) {
                            if (allNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i].isConnected()) {
                                return true;
                            }
                            i++;
                        }
                    }
                }
                return false;
            }
            pLU.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        } catch (Throwable th) {
            pLU.i(th);
        }
    }

    public static String gX(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData.get("InstallChannel");
                if (obj != null) {
                    return obj.toString();
                }
                pLU.bx("Could not read InstallChannel meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            pLU.by("Could not read InstallChannel meta-data from AndroidManifest.xml");
        }
        return null;
    }

    public static String gY(Context context) {
        return context == null ? null : context.getClass().getName();
    }

    public static String gZ(Context context) {
        if (g != null) {
            return g;
        }
        try {
            if (r.k(context, "android.permission.READ_PHONE_STATE")) {
                if ((context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) != 0 ? null : 1) != null) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        g = telephonyManager.getSimOperator();
                    }
                }
            } else {
                pLU.by("Could not get permission of android.permission.READ_PHONE_STATE");
            }
        } catch (Throwable th) {
            pLU.i(th);
        }
        return g;
    }

    public static String ha(Context context) {
        if (c(h)) {
            return h;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            h = str;
            if (str == null) {
                return "";
            }
        } catch (Throwable th) {
            pLU.i(th);
        }
        return h;
    }

    public static String hb(Context context) {
        String str = "";
        try {
            if (r.k(context, "android.permission.INTERNET") && r.k(context, "android.permission.ACCESS_NETWORK_STATE")) {
                String typeName;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    typeName = activeNetworkInfo.getTypeName();
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (typeName != null) {
                        if (typeName.equalsIgnoreCase("WIFI")) {
                            return "WIFI";
                        }
                        if (typeName.equalsIgnoreCase("MOBILE")) {
                            return extraInfo != null ? extraInfo : "MOBILE";
                        } else {
                            if (extraInfo != null) {
                                return extraInfo;
                            }
                            return typeName;
                        }
                    }
                }
                typeName = str;
                return typeName;
            }
            pLU.by("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return str;
        } catch (Throwable th) {
            pLU.i(th);
            return str;
        }
    }

    public static Integer hc(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static String hd(Context context) {
        if (c(i)) {
            return i;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            i = str;
            if (str == null || i.length() == 0) {
                return "unknown";
            }
        } catch (Throwable th) {
            pLU.i(th);
        }
        return i;
    }

    public static String he(Context context) {
        if (c(l)) {
            return l;
        }
        try {
            if (r.k(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equals("mounted")) {
                    externalStorageState = Environment.getExternalStorageDirectory().getPath();
                    if (externalStorageState != null) {
                        StatFs statFs = new StatFs(externalStorageState);
                        long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
                        externalStorageState = String.valueOf((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1000000) + "/" + String.valueOf(blockCount);
                        l = externalStorageState;
                        return externalStorageState;
                    }
                }
                return null;
            }
            pLU.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th) {
            pLU.i(th);
        }
    }

    static String hf(Context context) {
        try {
            if (m != null) {
                return m;
            }
            int myPid = Process.myPid();
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    m = runningAppProcessInfo.processName;
                    break;
                }
            }
            return m;
        } catch (Throwable th) {
        }
    }

    public static String hg(Context context) {
        return bC(context, a.pLD);
    }

    public static synchronized Integer hh(Context context) {
        Integer valueOf;
        int i = 0;
        synchronized (l.class) {
            if (n <= 0) {
                n = q.m(context, "MTA_EVENT_INDEX", 0);
                q.n(context, "MTA_EVENT_INDEX", n + 1000);
            } else if (n % 1000 == 0) {
                try {
                    int i2 = n + 1000;
                    if (n < 2147383647) {
                        i = i2;
                    }
                    q.n(context, "MTA_EVENT_INDEX", i);
                } catch (Throwable th) {
                    pLU.bx(th);
                }
            }
            i = n + 1;
            n = i;
            valueOf = Integer.valueOf(i);
        }
        return valueOf;
    }

    public static String hi(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            MemoryInfo memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return String.valueOf(memoryInfo.availMem / 1000000) + "/" + String.valueOf(bQE() / 1000000);
        } catch (Throwable th) {
            return null;
        }
    }

    public static String hj(Context context) {
        if (c(pLK)) {
            return pLK;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null) {
                List sensorList = sensorManager.getSensorList(-1);
                if (sensorList != null) {
                    StringBuilder stringBuilder = new StringBuilder(sensorList.size() * 10);
                    for (int i = 0; i < sensorList.size(); i++) {
                        stringBuilder.append(((Sensor) sensorList.get(i)).getType());
                        if (i != sensorList.size() - 1) {
                            stringBuilder.append(",");
                        }
                    }
                    pLK = stringBuilder.toString();
                }
            }
        } catch (Throwable th) {
            pLU.i(th);
        }
        return pLK;
    }

    public static synchronized int hk(Context context) {
        int i;
        synchronized (l.class) {
            if (u != -1) {
                i = u;
            } else {
                hl(context);
                i = u;
            }
        }
        return i;
    }

    public static void hl(Context context) {
        int m = q.m(context, t, 1);
        u = m;
        if (m == 1) {
            q.n(context, t, 0);
        }
    }

    public static boolean hm(Context context) {
        if (v < 0) {
            v = q.bD(context, "mta.qq.com.checktime");
        }
        return Math.abs(System.currentTimeMillis() - v) > 86400000;
    }

    public static void hn(Context context) {
        v = System.currentTimeMillis();
        q.a(context, "mta.qq.com.checktime", v);
    }

    public static String ho(Context context) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        return (resolveActivity.activityInfo == null || resolveActivity.activityInfo.packageName.equals("android")) ? null : resolveActivity.activityInfo.packageName;
    }

    public static int v(Context context, boolean z) {
        if (z) {
            w = q.m(context, "mta.qq.com.difftime", 0);
        }
        return w;
    }
}
