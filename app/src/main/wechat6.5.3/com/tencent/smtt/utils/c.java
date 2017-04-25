package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class c {
    public static String aKA = SQLiteDatabase.KeyEmpty;
    public static String aOw = SQLiteDatabase.KeyEmpty;
    public static String pyD = SQLiteDatabase.KeyEmpty;
    public static String pyE = SQLiteDatabase.KeyEmpty;
    public static String pyF = SQLiteDatabase.KeyEmpty;

    private static String D(File file) {
        try {
            JarFile jarFile = new JarFile(file);
            byte[] bArr = new byte[8192];
            String bx = bx(a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), bArr)[0].getEncoded());
            Enumeration entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry jarEntry = (JarEntry) entries.nextElement();
                String name = jarEntry.getName();
                if (name != null) {
                    Certificate[] a = a(jarFile, jarEntry, bArr);
                    String bx2 = a != null ? bx(a[0].getEncoded()) : null;
                    if (bx2 == null) {
                        if (!name.startsWith("META-INF/")) {
                            return null;
                        }
                    } else if (!bx2.equals(bx)) {
                        return null;
                    }
                }
            }
            return bx;
        } catch (Exception e) {
            return null;
        }
    }

    private static String Ql(String str) {
        return str == null ? SQLiteDatabase.KeyEmpty : str;
    }

    private static PackageInfo Qp(String str) {
        try {
            Class cls = Class.forName("android.content.pm.PackageParser");
            for (Class cls2 : cls.getDeclaredClasses()) {
                if (cls2.getName().compareTo("android.content.pm.PackageParser$Package") == 0) {
                    break;
                }
            }
            Class cls22 = null;
            Constructor constructor = cls.getConstructor(new Class[]{String.class});
            Method declaredMethod = cls.getDeclaredMethod("parsePackage", new Class[]{File.class, String.class, DisplayMetrics.class, Integer.TYPE});
            Method declaredMethod2 = cls.getDeclaredMethod("collectCertificates", new Class[]{cls22, Integer.TYPE});
            Method declaredMethod3 = cls.getDeclaredMethod("generatePackageInfo", new Class[]{cls22, int[].class, Integer.TYPE, Long.TYPE, Long.TYPE});
            constructor.setAccessible(true);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            declaredMethod3.setAccessible(true);
            Object newInstance = constructor.newInstance(new Object[]{str});
            new DisplayMetrics().setToDefaults();
            if (declaredMethod.invoke(newInstance, new Object[]{new File(str), str, new DisplayMetrics(), Integer.valueOf(0)}) == null) {
                return null;
            }
            declaredMethod2.invoke(newInstance, new Object[]{declaredMethod.invoke(newInstance, new Object[]{new File(str), str, new DisplayMetrics(), Integer.valueOf(0)}), Integer.valueOf(0)});
            return (PackageInfo) declaredMethod3.invoke(null, new Object[]{r3, null, Integer.valueOf(65), Integer.valueOf(0), Integer.valueOf(0)});
        } catch (Exception e) {
            return null;
        }
    }

    public static String V(Context context) {
        String str = SQLiteDatabase.KeyEmpty;
        if (!TextUtils.isEmpty(aKA)) {
            return aKA;
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return str;
        }
    }

    private static String a(Context context, File file, boolean z) {
        Signature signature;
        PackageInfo Qp = z ? Qp(file.getAbsolutePath()) : context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 65);
        if (Qp != null) {
            if (Qp.signatures == null || Qp.signatures.length <= 0) {
                TbsLog.w("AppUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
            } else {
                signature = Qp.signatures[0];
                return signature == null ? signature.toCharsString() : null;
            }
        }
        signature = null;
        if (signature == null) {
        }
    }

    private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InputStream inputStream = jarFile.getInputStream(jarEntry);
        do {
        } while (inputStream.read(bArr, 0, 8192) != -1);
        inputStream.close();
        return jarEntry != null ? jarEntry.getCertificates() : null;
    }

    public static String bNO() {
        BufferedReader bufferedReader;
        Throwable th;
        if (!TextUtils.isEmpty(pyE)) {
            return pyE;
        }
        InputStreamReader inputStreamReader;
        String Ql;
        try {
            inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream());
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    Ql = bufferedReader.readLine().contains("x86") ? Ql("i686") : Ql(System.getProperty("os.arch"));
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                        }
                    }
                    if (inputStreamReader == null) {
                        return Ql;
                    }
                    try {
                        inputStreamReader.close();
                        return Ql;
                    } catch (IOException e2) {
                        return Ql;
                    }
                } catch (Throwable th2) {
                    try {
                        Ql = Ql(System.getProperty("os.arch"));
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                            }
                        }
                        if (inputStreamReader != null) {
                            return Ql;
                        }
                        inputStreamReader.close();
                        return Ql;
                    } catch (Throwable th3) {
                        th = th3;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                Throwable th5 = th4;
                bufferedReader = null;
                th = th5;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                throw th;
            }
        } catch (Throwable th42) {
            inputStreamReader = null;
            th = th42;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            throw th;
        }
    }

    public static String bu(Context context, String str) {
        String str2 = null;
        try {
            try {
                str2 = String.valueOf(Integer.toHexString(Integer.parseInt(String.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), FileUtils.S_IWUSR).metaData.get(str)))));
            } catch (Exception e) {
            }
        } catch (Exception e2) {
        }
        return str2;
    }

    private static String bx(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = (b >> 4) & 15;
            cArr[i * 2] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            i2 = b & 15;
            cArr[(i * 2) + 1] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
        }
        return new String(cArr);
    }

    public static String c(Context context, File file) {
        String a = a(context, file, false);
        if (a == null) {
            a = D(file);
        }
        return a == null ? a(context, file, true) : a;
    }

    public static String fU(Context context) {
        String str = SQLiteDatabase.KeyEmpty;
        if (!TextUtils.isEmpty(pyD)) {
            return pyD;
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            return str;
        }
    }

    public static String fV(Context context) {
        String str = SQLiteDatabase.KeyEmpty;
        if (!TextUtils.isEmpty(aOw)) {
            return aOw;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
            return connectionInfo == null ? SQLiteDatabase.KeyEmpty : connectionInfo.getMacAddress();
        } catch (Exception e) {
            return str;
        }
    }

    public static String fW(Context context) {
        if (!TextUtils.isEmpty(pyF)) {
            return pyF;
        }
        try {
            pyF = Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
        }
        return pyF;
    }

    public static int getAppVersionCode(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            return i;
        }
    }

    public static String getAppVersionName(Context context) {
        String str = null;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return str;
        }
    }
}
