package ct;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentHttpClient;
import com.tencent.map.geolocation.internal.TencentHttpClientFactory;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import ct.b.a;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class bk {
    private static volatile bk l;
    public final Context a;
    private final bl b;
    private final ExecutorService c;
    private final HashMap<String, bo> d;
    private final PackageManager e;
    private final TelephonyManager f;
    private final WifiManager g;
    private final LocationManager h;
    private final TencentHttpClient i;
    private final CountDownLatch j;
    private String k;
    private List<db> m;

    public static bk a(Context context) {
        if (l == null) {
            synchronized (bk.class) {
                if (l == null) {
                    l = new bk(context);
                }
            }
        }
        return l;
    }

    private bk(Context context) {
        this.a = context;
        this.e = context.getPackageManager();
        this.f = (TelephonyManager) context.getSystemService("phone");
        this.g = (WifiManager) context.getSystemService("wifi");
        this.h = (LocationManager) context.getSystemService("location");
        Bundle bundle = new Bundle();
        bundle.putString("channelId", a.d(context.getPackageName()));
        this.i = TencentHttpClientFactory.getInstance().getTencentHttpClient(context, bundle);
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(1, 5, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        if (VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        this.c = threadPoolExecutor;
        this.d = new HashMap();
        this.d.put("cell", new bp("cell"));
        this.d.put("so", new bq(context, "so"));
        this.b = new bl(this);
        try {
            this.b.h = b(context);
        } catch (Exception e) {
            a.b("AppContext", "transactionTooLarge");
        }
        this.j = new CountDownLatch(1);
        new Thread(new Runnable(this) {
            private /* synthetic */ bk a;

            {
                this.a = r1;
            }

            public final void run() {
                this.a.j();
                this.a.j.countDown();
            }
        }).start();
    }

    @Nullable
    public final TelephonyManager a() {
        return this.f;
    }

    @Nullable
    public final WifiManager b() {
        return this.g;
    }

    @Nullable
    public final LocationManager c() {
        return this.h;
    }

    public final boolean d() {
        return this.f != null;
    }

    public final boolean e() {
        return this.g != null;
    }

    public final boolean f() {
        return this.h != null;
    }

    public final bl g() {
        return this.b;
    }

    public final bl a(long j) {
        if (j > 0) {
            try {
                if (!this.j.await(j, TimeUnit.MILLISECONDS)) {
                    return null;
                }
            } catch (InterruptedException e) {
                return null;
            }
        }
        this.j.await();
        return this.b;
    }

    public final ExecutorService h() {
        return this.c;
    }

    public final bo a(String str) {
        bo boVar = (bo) this.d.get(str);
        return boVar != null ? boVar : bn.a;
    }

    public final String a(String str, byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis();
        Pair postSync = this.i.postSync(str, bArr);
        a.a("HalleyTimeCost:" + (System.currentTimeMillis() - currentTimeMillis));
        byte[] b = a.b((byte[]) postSync.first);
        if (b != null) {
            return new String(b, (String) postSync.second);
        }
        a.a("AppContext", "postSync: inflate failed");
        return "{}";
    }

    public final String i() {
        int parseLong;
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 86400000) % 5);
        try {
            parseLong = (int) (Long.parseLong(this.k.substring(1)) % 5);
        } catch (Exception e) {
            parseLong = 0;
        }
        SharedPreferences sharedPreferences = this.a.getSharedPreferences("LocationSDK", 0);
        if (currentTimeMillis != parseLong) {
            sharedPreferences.edit().putBoolean("flag", false).apply();
        } else if (!sharedPreferences.getBoolean("flag", false)) {
            try {
                List<PackageInfo> installedPackages = this.e.getInstalledPackages(8192);
                StringBuilder stringBuilder = new StringBuilder();
                for (PackageInfo packageInfo : installedPackages) {
                    currentTimeMillis = packageInfo.applicationInfo.flags;
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    if ((currentTimeMillis & 1) <= 0) {
                        String obj = packageInfo.applicationInfo.loadLabel(this.e).toString();
                        boolean z = obj.length() > 30 || obj.startsWith("com.") || obj.contains("theme") || obj.contains("CheilPengtai");
                        if (!z) {
                            stringBuilder.append(obj);
                            stringBuilder.append('_');
                            stringBuilder.append(packageInfo.versionName);
                            stringBuilder.append('|');
                        }
                    }
                }
                sharedPreferences.edit().putBoolean("flag", true).apply();
                return b(stringBuilder.toString());
            } catch (Exception e2) {
                sharedPreferences.edit().putBoolean("flag", true).apply();
            }
        }
        return null;
    }

    public final synchronized void a(Object obj) {
        Object obj2;
        if (this.m == null) {
            this.m = new ArrayList();
        }
        for (db dbVar : this.m) {
            if (obj == dbVar.c) {
                obj2 = 1;
                break;
            }
        }
        obj2 = null;
        if (obj2 == null) {
            for (Method method : obj.getClass().getDeclaredMethods()) {
                String name = method.getName();
                if (name.startsWith("on") && name.endsWith("Event")) {
                    Class[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != 1) {
                        throw new IllegalArgumentException("EventHandler methods must specify a single Object paramter.");
                    }
                    this.m.add(new db(parameterTypes[0], method, obj));
                }
            }
        }
    }

    public final synchronized void b(Object obj) {
        List<db> list = this.m;
        if (list != null) {
            List<db> arrayList = new ArrayList();
            for (db dbVar : list) {
                Object obj2 = dbVar.c;
                if (obj2 == null || obj2 == obj) {
                    arrayList.add(dbVar);
                }
            }
            for (db dbVar2 : arrayList) {
                list.remove(dbVar2);
            }
        }
    }

    public final synchronized void c(@Nullable Object obj) {
        if (obj != null) {
            List<db> list = this.m;
            if (list != null) {
                for (db dbVar : list) {
                    if (obj.getClass().equals(dbVar.a)) {
                        try {
                            dbVar.b.invoke(dbVar.c, new Object[]{obj});
                        } catch (Throwable e) {
                            a.a("AppContext", SQLiteDatabase.KeyEmpty, e);
                        }
                    }
                }
            }
        }
    }

    final void j() {
        bl blVar;
        FileInputStream fileInputStream;
        Closeable open;
        byte[] bArr;
        JSONObject jSONObject;
        PackageInfo k;
        int i;
        CharSequence loadLabel;
        TelephonyManager telephonyManager;
        PackageManager packageManager;
        boolean hasSystemFeature;
        StringBuilder stringBuilder;
        try {
            a.a("AppContext", "doInBg: app status init start");
            blVar = this.b;
            fileInputStream = new FileInputStream(new File(Environment.getExternalStorageDirectory(), "c.json"));
        } catch (FileNotFoundException e) {
            fileInputStream = null;
        } catch (Throwable th) {
            a.a("AppContext", "doInBg: app status init error", th);
            return;
        }
        if (fileInputStream == null) {
            try {
                open = this.a.getAssets().open("c.json");
            } catch (IOException e2) {
            }
            if (open == null) {
                bArr = new byte[1024];
                try {
                    jSONObject = new JSONObject(new String(bArr, 0, open.read(bArr)));
                } catch (Throwable th2) {
                    a.a("AppContext", SQLiteDatabase.KeyEmpty, th2);
                    jSONObject = null;
                }
                a.a(open);
            } else {
                jSONObject = null;
            }
            if (jSONObject != null) {
                jSONObject.optBoolean("d", false);
                jSONObject.optBoolean("d_cell", false);
                jSONObject.optBoolean("d_gps", false);
                jSONObject.optBoolean("d_wifi", false);
                jSONObject.optBoolean("d_mgr", false);
                jSONObject.optLong("t_connect", 20000);
                jSONObject.optLong("t_read", 30000);
                blVar.r = jSONObject.optBoolean("o", true);
                blVar.s = jSONObject.optBoolean("s", false);
                blVar.t = jSONObject.optBoolean("a", true);
                String optString = jSONObject.optString("version", "3.2");
                blVar.o = optString;
                blVar.q = optString;
                blVar.p = jSONObject.optString("build", "159494");
            }
            k = k();
            i = k.versionCode;
            blVar.i = k.versionName;
            loadLabel = this.a.getApplicationInfo().loadLabel(this.e);
            blVar.j = loadLabel == null ? loadLabel.toString() : "unknown";
            telephonyManager = this.f;
            if (telephonyManager != null) {
                int[] iArr = new int[2];
                ct.a(telephonyManager, iArr);
                blVar.k = iArr[0];
                blVar.l = iArr[1];
                blVar.b = telephonyManager.getPhoneType();
                String a = cz.a(telephonyManager.getDeviceId(), cz.a);
                String a2 = cz.a(telephonyManager.getSubscriberId(), cz.b);
                String a3 = cz.a(telephonyManager.getLine1Number(), cz.c);
                this.k = a;
                blVar.c = a;
                blVar.d = a2;
                blVar.e = a3;
            }
            blVar.f = cz.a(da.a().replaceAll(":", SQLiteDatabase.KeyEmpty).toUpperCase(Locale.ENGLISH), cz.d);
            packageManager = this.e;
            hasSystemFeature = packageManager.hasSystemFeature("android.hardware.location.gps");
            a.a("AppContext", "doInBg: hasGps=" + hasSystemFeature + ",hasWifi=" + packageManager.hasSystemFeature("android.hardware.wifi") + ",hasCell=" + packageManager.hasSystemFeature("android.hardware.telephony"));
            stringBuilder = new StringBuilder();
            stringBuilder.append("os:").append(Build.MODEL).append(" ").append(VERSION.RELEASE).append(" ").append(blVar.a()).append(" net:").append(blVar.k).append(" ").append(blVar.l).append(" app:").append(k.versionCode).append(" ").append(k.versionName).append(" sdk: ").append(blVar.d()).append(" ").append(blVar.e());
            a.a("AppContext", stringBuilder.toString());
            a.a("AppContext", "doInBg: app status init done");
        }
        Object obj = fileInputStream;
        if (open == null) {
            jSONObject = null;
        } else {
            bArr = new byte[1024];
            jSONObject = new JSONObject(new String(bArr, 0, open.read(bArr)));
            a.a(open);
        }
        if (jSONObject != null) {
            jSONObject.optBoolean("d", false);
            jSONObject.optBoolean("d_cell", false);
            jSONObject.optBoolean("d_gps", false);
            jSONObject.optBoolean("d_wifi", false);
            jSONObject.optBoolean("d_mgr", false);
            jSONObject.optLong("t_connect", 20000);
            jSONObject.optLong("t_read", 30000);
            blVar.r = jSONObject.optBoolean("o", true);
            blVar.s = jSONObject.optBoolean("s", false);
            blVar.t = jSONObject.optBoolean("a", true);
            String optString2 = jSONObject.optString("version", "3.2");
            blVar.o = optString2;
            blVar.q = optString2;
            blVar.p = jSONObject.optString("build", "159494");
        }
        k = k();
        i = k.versionCode;
        blVar.i = k.versionName;
        loadLabel = this.a.getApplicationInfo().loadLabel(this.e);
        if (loadLabel == null) {
        }
        blVar.j = loadLabel == null ? loadLabel.toString() : "unknown";
        telephonyManager = this.f;
        if (telephonyManager != null) {
            int[] iArr2 = new int[2];
            ct.a(telephonyManager, iArr2);
            blVar.k = iArr2[0];
            blVar.l = iArr2[1];
            blVar.b = telephonyManager.getPhoneType();
            String a4 = cz.a(telephonyManager.getDeviceId(), cz.a);
            String a22 = cz.a(telephonyManager.getSubscriberId(), cz.b);
            String a32 = cz.a(telephonyManager.getLine1Number(), cz.c);
            this.k = a4;
            blVar.c = a4;
            blVar.d = a22;
            blVar.e = a32;
        }
        blVar.f = cz.a(da.a().replaceAll(":", SQLiteDatabase.KeyEmpty).toUpperCase(Locale.ENGLISH), cz.d);
        packageManager = this.e;
        hasSystemFeature = packageManager.hasSystemFeature("android.hardware.location.gps");
        a.a("AppContext", "doInBg: hasGps=" + hasSystemFeature + ",hasWifi=" + packageManager.hasSystemFeature("android.hardware.wifi") + ",hasCell=" + packageManager.hasSystemFeature("android.hardware.telephony"));
        stringBuilder = new StringBuilder();
        stringBuilder.append("os:").append(Build.MODEL).append(" ").append(VERSION.RELEASE).append(" ").append(blVar.a()).append(" net:").append(blVar.k).append(" ").append(blVar.l).append(" app:").append(k.versionCode).append(" ").append(k.versionName).append(" sdk: ").append(blVar.d()).append(" ").append(blVar.e());
        a.a("AppContext", stringBuilder.toString());
        a.a("AppContext", "doInBg: app status init done");
    }

    private static String b(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), FileUtils.S_IWUSR).metaData;
            if (bundle != null) {
                if (bundle.containsKey("TencentGeoLocationSDK")) {
                    return bundle.getString("TencentGeoLocationSDK");
                }
                if (bundle.containsKey("TencentMapSDK")) {
                    return bundle.getString("TencentMapSDK");
                }
                return SQLiteDatabase.KeyEmpty;
            }
        } catch (Exception e) {
        }
        return SQLiteDatabase.KeyEmpty;
    }

    private PackageInfo k() {
        try {
            return this.e.getPackageInfo(this.a.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            return new PackageInfo();
        }
    }

    private String b(String str) {
        bl blVar = this.b;
        Map hashMap = new HashMap();
        hashMap.put("version", blVar.d());
        hashMap.put("app_name", c(blVar.i));
        hashMap.put("app_label", c(blVar.j));
        hashMap.put("l", str);
        try {
            bl blVar2 = this.b;
            Map hashMap2 = new HashMap();
            hashMap2.put("imei", c(blVar2.a()));
            hashMap2.put("imsi", c(blVar2.b()));
            hashMap2.put("n", c(a.b(blVar2.e)));
            hashMap2.put("qq", c(a.b(blVar2.g)));
            hashMap2.put("mac", c(blVar2.c().toLowerCase(Locale.ENGLISH)));
            hashMap2.put("model", c(Build.MANUFACTURER + "_" + Build.MODEL));
            return new JSONObject(hashMap).put("attribute", new JSONObject(hashMap2)).toString();
        } catch (JSONException e) {
            return null;
        }
    }

    private static String c(String str) {
        if (str == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        return str;
    }
}
