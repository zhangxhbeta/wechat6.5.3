package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.e;
import com.tencent.smtt.utils.n;
import com.tencent.smtt.utils.s;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@SuppressLint({"NewApi"})
public class QbSdk {
    public static final int EXTENSION_INIT_FAILURE = -99999;
    public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
    public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
    public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
    public static final int SVNVERSION = 433748;
    public static final String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;
    private static Object puA;
    static boolean puB = false;
    static boolean puC = false;
    static boolean puD = true;
    private static boolean puE = false;
    private static String[] puF;
    private static String puG = "NULL";
    private static String puH = "UNKNOWN";
    static String puI;
    static boolean puJ = false;
    static long puK = 0;
    static Object puL = new Object();
    private static int puM = 0;
    private static int puN = 170;
    private static String puO = null;
    private static String puP = null;
    static volatile boolean puQ = puB;
    private static boolean puR = true;
    private static n puS = null;
    private static n puT = null;
    private static boolean puU = false;
    private static boolean puV = false;
    static n puW = new n() {
        public final void hp(int i) {
            j.pwk = false;
            if (QbSdk.puS != null) {
                QbSdk.puS.hp(i);
            }
            if (QbSdk.puT != null) {
                QbSdk.puT.hp(i);
            }
        }

        public final void hq(int i) {
            QbSdk.setTBSInstallingStatus(false);
            j.pwk = false;
            if (QbSdk.puS != null) {
                QbSdk.puS.hq(i);
            }
            if (QbSdk.puT != null) {
                QbSdk.puT.hq(i);
            }
        }

        public final void hr(int i) {
            if (QbSdk.puT != null) {
                QbSdk.puT.hr(i);
            }
            if (QbSdk.puS != null) {
                QbSdk.puS.hr(i);
            }
        }
    };
    static Map<String, Object> puX = null;
    private static int pux = 0;
    private static String puy = SQLiteDatabase.KeyEmpty;
    private static Class<?> puz;
    public static boolean sIsVersionPrinted = false;
    static long sWifiConnectedTime = 0;

    public interface a {
        void RT();

        void by(boolean z);
    }

    static boolean Z(Context context, int i) {
        if (eW(context)) {
            Object a = n.a(puA, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(36901), Integer.valueOf(20000));
            if (a != null) {
                return ((Boolean) a).booleanValue();
            }
            a = n.a(puA, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(36901));
            if (a != null) {
                return ((Boolean) a).booleanValue();
            }
        }
        return true;
    }

    static String bMF() {
        return puy;
    }

    static synchronized void bo(Context context, String str) {
        synchronized (QbSdk.class) {
            if (!puB) {
                puB = true;
                puH = "forceSysWebViewInner: " + str;
                TbsLog.e("QbSdk", "QbSdk.SysWebViewForcedInner..." + puH);
                g.bMS().a(context, 401, new Throwable(puH));
            }
        }
    }

    static Object c(Context context, String str, Bundle bundle) {
        if (!eV(context)) {
            return Integer.valueOf(EXTENSION_INIT_FAILURE);
        }
        Object a = n.a(puA, "miscCall", new Class[]{String.class, Bundle.class}, str, bundle);
        return a == null ? null : a;
    }

    public static boolean canLoadVideo(Context context) {
        Object a = n.a(puA, "canLoadVideo", new Class[]{Integer.TYPE}, Integer.valueOf(0));
        if (a == null) {
            g.bMS().ab(context, 314);
        } else if (!((Boolean) a).booleanValue()) {
            g.bMS().ab(context, 313);
        }
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public static boolean canLoadX5(Context context) {
        return n(context, false);
    }

    public static boolean canLoadX5FirstTimeThirdApp(Context context) {
        try {
            if (puz == null) {
                m.bNm();
                File fr = m.fr(context);
                if (fr == null) {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
                    return false;
                }
                File file = new File(q.bNx(), "tbs_sdk_extension_dex.jar");
                if (file.exists()) {
                    puz = new DexClassLoader(file.getAbsolutePath(), fr.getAbsolutePath(), file.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                } else {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
                    return false;
                }
            }
            if (puA == null) {
                puA = puz.getConstructor(new Class[]{Context.class, Context.class}).newInstance(new Object[]{context, context});
            }
            Object a = n.a(puA, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
            return (a == null || !(a instanceof Boolean)) ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public static void canOpenFile(final Context context, final String str, final u<Boolean> uVar) {
        new Thread() {
            public final void run() {
                boolean booleanValue;
                y bNJ = y.bNJ();
                bNJ.b(context, null);
                if (bNJ.bNK()) {
                    z bNL = bNJ.bNL();
                    Context context = context;
                    String str = str;
                    Object invokeStaticMethod = bNL.pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[]{Context.class, String.class}, context, str);
                    booleanValue = invokeStaticMethod instanceof Boolean ? ((Boolean) invokeStaticMethod).booleanValue() : false;
                } else {
                    booleanValue = false;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 puZ;

                    public final void run() {
                        uVar.onReceiveValue(Boolean.valueOf(booleanValue));
                    }
                });
            }
        }.start();
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        return !m(context, false) ? false : false;
    }

    public static boolean canOpenWebPlus(Context context) {
        InputStream fileInputStream;
        boolean z;
        Throwable th;
        InputStream inputStream = null;
        if (puM == 0) {
            puM = a.bME();
        }
        TbsLog.i("QbSdk", "canOpenWebPlus - totalRAM: " + puM);
        if (VERSION.SDK_INT < 7 || puM < puN || context == null) {
            return false;
        }
        InputStream fileInputStream2;
        try {
            m.bNm();
            fileInputStream2 = new FileInputStream(new File(m.fr(context), "tbs.conf"));
            try {
                Properties properties = new Properties();
                properties.load(fileInputStream2);
                String property = properties.getProperty("android_sdk_max_supported");
                String property2 = properties.getProperty("android_sdk_min_supported");
                int parseInt = Integer.parseInt(property);
                int parseInt2 = Integer.parseInt(property2);
                int parseInt3 = Integer.parseInt(VERSION.SDK);
                if (parseInt3 > parseInt || parseInt3 < parseInt2) {
                    TbsLog.i("QbSdk", "canOpenWebPlus - sdkVersion: " + parseInt3);
                    try {
                        fileInputStream2.close();
                        return false;
                    } catch (Exception e) {
                        return false;
                    }
                }
                parseInt = Integer.parseInt(properties.getProperty("tbs_core_version"));
                try {
                    fileInputStream2.close();
                } catch (Exception e2) {
                }
                try {
                    fileInputStream = new FileInputStream(new File(m.ft(context), "tbs_extension.conf"));
                    try {
                        Properties properties2 = new Properties();
                        properties2.load(fileInputStream);
                        int parseInt4 = Integer.parseInt(properties2.getProperty("tbs_local_version"));
                        parseInt2 = Integer.parseInt(properties2.getProperty("app_versioncode_for_switch"));
                        if (parseInt == 88888888 || parseInt4 == 88888888) {
                            z = false;
                        } else if (parseInt > parseInt4) {
                            z = false;
                        } else if (parseInt == parseInt4) {
                            if (parseInt2 > 0) {
                                if (parseInt2 != c.getAppVersionCode(context)) {
                                    z = false;
                                }
                            }
                            z = Boolean.parseBoolean(properties2.getProperty("x5_disabled")) && !i.fb(context.getApplicationContext()).pwc.getBoolean("switch_backupcore_enable", false);
                        } else {
                            z = false;
                        }
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
                if (z) {
                }
            } catch (Throwable th4) {
                try {
                    TbsLog.i("QbSdk", "canOpenWebPlus - canLoadX5 Exception");
                    if (fileInputStream2 != null) {
                        return false;
                    }
                    try {
                        fileInputStream2.close();
                        return false;
                    } catch (Exception e4) {
                        return false;
                    }
                } catch (Throwable th5) {
                    inputStream = fileInputStream2;
                    th = th5;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public static boolean canUseVideoFeatrue(Context context, int i) {
        Object a = n.a(puA, "canUseVideoFeatrue", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        return (a == null || !(a instanceof Boolean)) ? false : ((Boolean) a).booleanValue();
    }

    public static void clear(Context context) {
    }

    public static void clearAllWebViewCache(Context context, boolean z) {
        z bNL;
        try {
            new WebView(context).clearCache(true);
            if (z) {
                CookieSyncManager.createInstance(context);
                CookieManager.getInstance().removeAllCookie();
            }
            WebViewDatabase.getInstance(context).clearUsernamePassword();
            WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
            WebViewDatabase.getInstance(context).clearFormData();
            WebStorage.getInstance().deleteAllData();
            WebIconDatabase.getInstance().removeAllIcons();
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(th));
        }
        try {
            if (new WebView(context).getWebViewClientExtension() != null) {
                y bNJ = y.bNJ();
                if (bNJ != null && bNJ.bNK()) {
                    bNL = bNJ.bNL();
                    TbsLog.w("desktop", " tbsWizard clearAllX5Cache");
                    if (z) {
                        bNL.pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class}, context);
                        return;
                    }
                    bNL.pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class, Boolean.TYPE}, context, Boolean.valueOf(z));
                }
            }
        } catch (Exception e) {
            bNL.pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
            bNL.pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
            bNL.pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
            bNL.pxC.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new Object[0]);
            bNL.pxC.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new Object[0]);
            Object invokeStaticMethod = bNL.pxC.invokeStaticMethod("com.tencent.smtt.net.http.DnsManager", "getInstance", null, new Object[0]);
            if (invokeStaticMethod != null) {
                bNL.pxC.invokeMethod(invokeStaticMethod, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new Object[0]);
            }
            invokeStaticMethod = bNL.pxC.invokeStaticMethod("com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new Object[0]);
            if (invokeStaticMethod != null) {
                bNL.pxC.invokeMethod(invokeStaticMethod, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new Object[0]);
            }
            bNL.pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
        } catch (Throwable th2) {
        }
    }

    public static void closeFileReader(Context context) {
        y bNJ = y.bNJ();
        bNJ.b(context, null);
        if (bNJ.bNK()) {
            bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
        }
    }

    public static boolean createMiniQBShortCut(Context context, String str, String str2, Drawable drawable) {
        if (context == null) {
            return false;
        }
        if (j.fe(context)) {
            return false;
        }
        if (isMiniQBShortCutExist(context, str, str2)) {
            return false;
        }
        y bNJ = y.bNJ();
        if (bNJ == null || !bNJ.bNK()) {
            return false;
        }
        Bitmap bitmap = null;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        }
        DexLoader dexLoader = bNJ.bNL().pxC;
        TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
        Object invokeStaticMethod = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[]{Context.class, String.class, String.class, Bitmap.class}, context, str, str2, bitmap);
        TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + invokeStaticMethod);
        return invokeStaticMethod != null;
    }

    static Bundle d(Context context, Bundle bundle) {
        if (eV(context)) {
            Object a = n.a(puA, "incrUpdate", new Class[]{Context.class, Bundle.class}, context, bundle);
            if (a != null) {
                return (Bundle) a;
            }
            o.fx(context).aA(216, "incrUpdate return null!");
            return null;
        }
        o.fx(context).aA(216, "initForPatch return false!");
        return null;
    }

    public static boolean deleteMiniQBShortCut(Context context, String str, String str2) {
        if (context == null || j.fe(context)) {
            return false;
        }
        y bNJ = y.bNJ();
        if (bNJ == null || !bNJ.bNK()) {
            return false;
        }
        return bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[]{Context.class, String.class, String.class}, context, str, str2) != null;
    }

    private static boolean eV(Context context) {
        try {
            if (puz != null) {
                return true;
            }
            m.bNm();
            File fr = m.fr(context);
            if (fr == null) {
                TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
                return false;
            }
            File file = new File(fr, "tbs_sdk_extension_dex.jar");
            if (file.exists()) {
                Class loadClass = new DexClassLoader(file.getAbsolutePath(), fr.getAbsolutePath(), file.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                puz = loadClass;
                puA = loadClass.getConstructor(new Class[]{Context.class, Context.class}).newInstance(new Object[]{context, context});
                return true;
            }
            TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
            return false;
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    private static boolean eW(Context context) {
        try {
            if (puz != null) {
                return true;
            }
            m.bNm();
            File fr = m.fr(context);
            if (fr == null) {
                TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
                return false;
            } else if (q.fz(context)) {
                g.bMS().ab(context, 304);
                return false;
            } else {
                m.bNm();
                File file = new File(m.fr(context), "tbs_sdk_extension_dex.jar");
                if (file.exists()) {
                    Class loadClass = new DexClassLoader(file.getAbsolutePath(), fr.getAbsolutePath(), file.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    puz = loadClass;
                    Constructor constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                    if (q.fz(context)) {
                        puA = constructor.newInstance(new Object[]{context, null});
                    } else {
                        puA = constructor.newInstance(new Object[]{context, context});
                    }
                    n.a(puA, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, c.aKA, c.pyD, c.pyE, c.aOw);
                    n.a(puA, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                    return true;
                }
                g.bMS().a(context, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
                return false;
            }
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public static void forceSysWebView() {
        puC = true;
        puG = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
        TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    }

    public static long getApkFileSize(Context context) {
        return context != null ? i.fb(context.getApplicationContext()).pwc.getLong("tbs_apkfilesize", 0) : 0;
    }

    public static String[] getDexLoaderFileList(Context context, Context context2, String str) {
        int i = 0;
        if (puF instanceof String[]) {
            int length = puF.length;
            String[] strArr = new String[length];
            while (i < length) {
                strArr[i] = str + puF[i];
                i++;
            }
            return strArr;
        }
        Object a = n.a(puA, "getJarFiles", new Class[]{Context.class, Context.class, String.class}, context, context2, str);
        if (!(a instanceof String[])) {
            a = new String[]{SQLiteDatabase.KeyEmpty};
        }
        return (String[]) a;
    }

    public static boolean getDownloadWithoutWifi() {
        return puU;
    }

    public static String getMiniQBVersion(Context context) {
        y bNJ = y.bNJ();
        bNJ.b(context, null);
        if (bNJ == null || !bNJ.bNK()) {
            return null;
        }
        Object invokeStaticMethod = bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? null : (String) invokeStaticMethod;
    }

    public static String getQQBuildNumber() {
        return puP;
    }

    public static boolean getTBSInstalling() {
        return puV;
    }

    public static String getTID() {
        return puO;
    }

    public static int getTbsVersion(Context context) {
        return q.fz(context) ? q.bNz() : m.bNm().fl(context);
    }

    public static void initTbsSettings(Map<String, Object> map) {
        if (puX == null) {
            puX = map;
            return;
        }
        try {
            puX.putAll(map);
        } catch (Exception e) {
        }
    }

    public static void initX5Environment(final Context context, final a aVar) {
        puT = new n() {
            public final void hp(int i) {
            }

            public final void hq(int i) {
                QbSdk.preInit(context, aVar);
            }

            public final void hr(int i) {
            }
        };
        if (q.fz(context)) {
            m.bNm().t(context, true);
        }
        j.a(context, false, false, new com.tencent.smtt.sdk.j.a() {
            public final void d(boolean z, int i) {
                if (q.bNA() != 0 || q.bNw()) {
                    QbSdk.preInit(context, aVar);
                } else {
                    q.u(context, false);
                }
            }
        });
    }

    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        c kx = c.kx(true);
        kx.a(context, null);
        if (kx == null || !kx.pve) {
            return false;
        }
        Object invokeStaticMethod = kx.bMI().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[]{Context.class, String.class, String.class, Bundle.class}, context, str, str2, bundle);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    public static boolean intentDispatch(WebView webView, Intent intent, String str, String str2) {
        if (webView == null) {
            return false;
        }
        if (str.startsWith("mttbrowser://miniqb/ch=icon?")) {
            Context context = webView.getContext();
            int indexOf = str.indexOf("url=");
            String substring = indexOf > 0 ? str.substring(indexOf + 4) : null;
            HashMap hashMap = new HashMap();
            Object obj = "unknown";
            try {
                obj = context.getApplicationInfo().packageName;
            } catch (Exception e) {
            }
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, obj);
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "14004");
            if (com.tencent.smtt.sdk.a.c.a(context, "miniqb://home".equals(substring) ? "qb://navicard/addCard?cardId=168&cardName=168" : substring, hashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
                y bNJ = y.bNJ();
                if (bNJ != null && bNJ.bNK() && bNJ.bNL().a(context, substring, null, str2, null) == 0) {
                    return true;
                }
                webView.loadUrl(substring);
            }
        } else {
            webView.loadUrl(str);
        }
        return false;
    }

    public static boolean isMiniQBShortCutExist(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        if (j.fe(context)) {
            return false;
        }
        y bNJ = y.bNJ();
        if (bNJ == null || !bNJ.bNK()) {
            return false;
        }
        Object invokeStaticMethod = bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[]{Context.class, String.class}, context, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return (invokeStaticMethod instanceof Boolean ? (Boolean) invokeStaticMethod : Boolean.valueOf(false)).booleanValue();
    }

    public static boolean isTbsCoreInited() {
        c kx = c.kx(false);
        return kx != null && kx.pvf;
    }

    public static boolean isX5DisabledSync(Context context) {
        if (h.fa(context).Qi("install_status") == 2) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (i != 0) {
            return false;
        }
        if (!eW(context)) {
            return true;
        }
        i = m.bNm().fl(context);
        Object a = n.a(puA, "isX5DisabledSync", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(36901));
        return a != null ? ((Boolean) a).booleanValue() : true;
    }

    @SuppressLint({"NewApi"})
    private static boolean m(Context context, boolean z) {
        SharedPreferences sharedPreferences;
        int i;
        Throwable th;
        Editor edit;
        File bMT;
        File fr;
        Class loadClass;
        Constructor constructor;
        int i2 = -1;
        TbsLog.initIfNeed(context);
        if (!sIsVersionPrinted) {
            TbsLog.i("QbSdk", "svn revision: 433748; SDK_VERSION_CODE: 36901; SDK_VERSION_NAME: 2.6.0.1061");
            sIsVersionPrinted = true;
        }
        if (puB && !z) {
            TbsLog.e("QbSdk", "QbSdk init: " + puH, false);
            g.bMS().a(context, 414, new Throwable(puH));
            return false;
        } else if (puC) {
            TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
            g.bMS().a(context, 402, new Throwable(puG));
            return false;
        } else {
            if (!puR) {
                puR = true;
                int i3;
                int i4;
                try {
                    sharedPreferences = VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
                    try {
                        i3 = sharedPreferences.getInt("tbs_preload_x5_recorder", -1);
                        if (i3 >= 0) {
                            i3++;
                            if (i3 <= 4) {
                                i = i3;
                            }
                        } else {
                            i = i3;
                            i3 = -1;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i3 = -1;
                        i4 = -1;
                        TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th));
                        i = -1;
                        if (i <= 3) {
                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                            y.bNJ().b(context, null);
                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                            i2 = 0;
                            try {
                                i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                if (i > 0) {
                                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                                }
                            } catch (Throwable th3) {
                                TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(th3));
                            }
                            TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
                        } else {
                            try {
                                i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                edit = sharedPreferences.edit();
                                if (i != i4) {
                                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i);
                                } else {
                                    m.bNm();
                                    e.d(m.fr(context), false);
                                    h.fa(context);
                                    bMT = h.bMT();
                                    if (bMT != null) {
                                        e.d(bMT, false);
                                    }
                                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                                }
                                edit.putInt("tbs_precheck_disable_version", i);
                                edit.commit();
                            } catch (Throwable th32) {
                                TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(th32));
                            }
                        }
                        m.bNm();
                        fr = m.fr(context);
                        if (fr == null) {
                            TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                            g.bMS().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                            return false;
                        }
                        if (!q.fz(context)) {
                            if (pux != 0) {
                                i = m.bNm().a(true, context);
                                if (pux != i) {
                                    puz = null;
                                    puA = null;
                                    TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i, true);
                                    TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + pux, true);
                                    g.bMS().a(context, 303, new Throwable("sTbsVersion: " + pux + "; tbsCoreInstalledVer: " + i));
                                    return false;
                                }
                            }
                            i = 0;
                            pux = i;
                        }
                        if (puz != null) {
                            return true;
                        }
                        if (q.fz(context)) {
                            g.bMS().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                            return false;
                        }
                        m.bNm();
                        bMT = new File(m.fr(context), "tbs_sdk_extension_dex.jar");
                        if (bMT.exists()) {
                            loadClass = new DexClassLoader(bMT.getAbsolutePath(), fr.getAbsolutePath(), bMT.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                            puz = loadClass;
                            constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                            if (q.fz(context)) {
                                puA = constructor.newInstance(new Object[]{context, null});
                            } else {
                                puA = constructor.newInstance(new Object[]{context, context});
                            }
                            n.a(puA, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, c.aKA, c.pyD, c.pyE, c.aOw);
                            n.a(puA, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                            return true;
                        }
                        try {
                            TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                            i = m.bNm().fl(context);
                            if (new File(bMT.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                                if (i > 0) {
                                    g.bMS().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                } else {
                                    g.bMS().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                }
                            } else if (i > 0) {
                                g.bMS().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                            } else {
                                g.bMS().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                            }
                        } catch (Throwable th4) {
                        }
                        return false;
                    }
                    try {
                        i4 = m.bNm().fl(context);
                        if (i4 > 0) {
                            if (i <= 4) {
                                try {
                                    sharedPreferences.edit().putInt("tbs_preload_x5_recorder", i).commit();
                                } catch (Throwable th5) {
                                    th32 = th5;
                                    TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th32));
                                    i = -1;
                                    if (i <= 3) {
                                        i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                        edit = sharedPreferences.edit();
                                        if (i != i4) {
                                            m.bNm();
                                            e.d(m.fr(context), false);
                                            h.fa(context);
                                            bMT = h.bMT();
                                            if (bMT != null) {
                                                e.d(bMT, false);
                                            }
                                            TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                                        } else {
                                            TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i);
                                        }
                                        edit.putInt("tbs_precheck_disable_version", i);
                                        edit.commit();
                                    } else {
                                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                        y.bNJ().b(context, null);
                                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                                        i2 = 0;
                                        i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                        if (i > 0) {
                                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                                        }
                                        TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
                                    }
                                    m.bNm();
                                    fr = m.fr(context);
                                    if (fr == null) {
                                        if (q.fz(context)) {
                                            if (pux != 0) {
                                                i = 0;
                                            } else {
                                                i = m.bNm().a(true, context);
                                                if (pux != i) {
                                                    puz = null;
                                                    puA = null;
                                                    TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i, true);
                                                    TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + pux, true);
                                                    g.bMS().a(context, 303, new Throwable("sTbsVersion: " + pux + "; tbsCoreInstalledVer: " + i));
                                                    return false;
                                                }
                                            }
                                            pux = i;
                                        }
                                        if (puz != null) {
                                            return true;
                                        }
                                        if (q.fz(context)) {
                                            m.bNm();
                                            bMT = new File(m.fr(context), "tbs_sdk_extension_dex.jar");
                                            if (bMT.exists()) {
                                                loadClass = new DexClassLoader(bMT.getAbsolutePath(), fr.getAbsolutePath(), bMT.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                                                puz = loadClass;
                                                constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                                                if (q.fz(context)) {
                                                    puA = constructor.newInstance(new Object[]{context, context});
                                                } else {
                                                    puA = constructor.newInstance(new Object[]{context, null});
                                                }
                                                n.a(puA, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, c.aKA, c.pyD, c.pyE, c.aOw);
                                                n.a(puA, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                                                return true;
                                            }
                                            TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                                            i = m.bNm().fl(context);
                                            if (new File(bMT.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                                                if (i > 0) {
                                                    g.bMS().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                                                } else {
                                                    g.bMS().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                                                }
                                            } else if (i > 0) {
                                                g.bMS().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                            } else {
                                                g.bMS().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                            }
                                            return false;
                                        }
                                        g.bMS().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                                        return false;
                                    }
                                    TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                                    g.bMS().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                                    return false;
                                }
                            }
                            i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                            if (i >= 0) {
                                i++;
                                sharedPreferences.edit().putInt("tbs_preload_x5_counter", i).commit();
                                if (i <= 3) {
                                    i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                    edit = sharedPreferences.edit();
                                    if (i != i4) {
                                        m.bNm();
                                        e.d(m.fr(context), false);
                                        h.fa(context);
                                        bMT = h.bMT();
                                        if (bMT != null) {
                                            e.d(bMT, false);
                                        }
                                        TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                                    } else {
                                        TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i);
                                    }
                                    edit.putInt("tbs_precheck_disable_version", i);
                                    edit.commit();
                                } else {
                                    if (i3 > 0 && i3 <= 3) {
                                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                        y.bNJ().b(context, null);
                                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                                        i2 = 0;
                                    }
                                    i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                    if (i > 0) {
                                        sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                                    }
                                    TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
                                }
                            }
                            i = -1;
                            if (i <= 3) {
                                TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                y.bNJ().b(context, null);
                                TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                                i2 = 0;
                                i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                if (i > 0) {
                                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                                }
                                TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
                            } else {
                                i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                edit = sharedPreferences.edit();
                                if (i != i4) {
                                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i);
                                } else {
                                    m.bNm();
                                    e.d(m.fr(context), false);
                                    h.fa(context);
                                    bMT = h.bMT();
                                    if (bMT != null) {
                                        e.d(bMT, false);
                                    }
                                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                                }
                                edit.putInt("tbs_precheck_disable_version", i);
                                edit.commit();
                            }
                        }
                    } catch (Throwable th6) {
                        th32 = th6;
                        i4 = -1;
                        TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th32));
                        i = -1;
                        if (i <= 3) {
                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                            y.bNJ().b(context, null);
                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                            i2 = 0;
                            i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                            if (i > 0) {
                                sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                            }
                            TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
                        } else {
                            i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                            edit = sharedPreferences.edit();
                            if (i != i4) {
                                TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i);
                            } else {
                                m.bNm();
                                e.d(m.fr(context), false);
                                h.fa(context);
                                bMT = h.bMT();
                                if (bMT != null) {
                                    e.d(bMT, false);
                                }
                                TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                            }
                            edit.putInt("tbs_precheck_disable_version", i);
                            edit.commit();
                        }
                        m.bNm();
                        fr = m.fr(context);
                        if (fr == null) {
                            TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                            g.bMS().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                            return false;
                        }
                        if (q.fz(context)) {
                            if (pux != 0) {
                                i = m.bNm().a(true, context);
                                if (pux != i) {
                                    puz = null;
                                    puA = null;
                                    TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i, true);
                                    TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + pux, true);
                                    g.bMS().a(context, 303, new Throwable("sTbsVersion: " + pux + "; tbsCoreInstalledVer: " + i));
                                    return false;
                                }
                            }
                            i = 0;
                            pux = i;
                        }
                        if (puz != null) {
                            return true;
                        }
                        if (q.fz(context)) {
                            g.bMS().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                            return false;
                        }
                        m.bNm();
                        bMT = new File(m.fr(context), "tbs_sdk_extension_dex.jar");
                        if (bMT.exists()) {
                            TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                            i = m.bNm().fl(context);
                            if (new File(bMT.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                                if (i > 0) {
                                    g.bMS().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                } else {
                                    g.bMS().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                }
                            } else if (i > 0) {
                                g.bMS().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                            } else {
                                g.bMS().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                            }
                            return false;
                        }
                        loadClass = new DexClassLoader(bMT.getAbsolutePath(), fr.getAbsolutePath(), bMT.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                        puz = loadClass;
                        constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                        if (q.fz(context)) {
                            puA = constructor.newInstance(new Object[]{context, null});
                        } else {
                            puA = constructor.newInstance(new Object[]{context, context});
                        }
                        n.a(puA, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, c.aKA, c.pyD, c.pyE, c.aOw);
                        n.a(puA, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                        return true;
                    }
                } catch (Throwable th7) {
                    th32 = th7;
                    sharedPreferences = null;
                    i4 = -1;
                    i3 = -1;
                    TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th32));
                    i = -1;
                    if (i <= 3) {
                        i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                        edit = sharedPreferences.edit();
                        if (i != i4) {
                            m.bNm();
                            e.d(m.fr(context), false);
                            h.fa(context);
                            bMT = h.bMT();
                            if (bMT != null) {
                                e.d(bMT, false);
                            }
                            TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                        } else {
                            TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i);
                        }
                        edit.putInt("tbs_precheck_disable_version", i);
                        edit.commit();
                    } else {
                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                        y.bNJ().b(context, null);
                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                        i2 = 0;
                        i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                        if (i > 0) {
                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                        }
                        TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
                    }
                    m.bNm();
                    fr = m.fr(context);
                    if (fr == null) {
                        if (q.fz(context)) {
                            if (pux != 0) {
                                i = 0;
                            } else {
                                i = m.bNm().a(true, context);
                                if (pux != i) {
                                    puz = null;
                                    puA = null;
                                    TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i, true);
                                    TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + pux, true);
                                    g.bMS().a(context, 303, new Throwable("sTbsVersion: " + pux + "; tbsCoreInstalledVer: " + i));
                                    return false;
                                }
                            }
                            pux = i;
                        }
                        if (puz != null) {
                            return true;
                        }
                        if (q.fz(context)) {
                            m.bNm();
                            bMT = new File(m.fr(context), "tbs_sdk_extension_dex.jar");
                            if (bMT.exists()) {
                                loadClass = new DexClassLoader(bMT.getAbsolutePath(), fr.getAbsolutePath(), bMT.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                                puz = loadClass;
                                constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                                if (q.fz(context)) {
                                    puA = constructor.newInstance(new Object[]{context, context});
                                } else {
                                    puA = constructor.newInstance(new Object[]{context, null});
                                }
                                n.a(puA, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, c.aKA, c.pyD, c.pyE, c.aOw);
                                n.a(puA, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                                return true;
                            }
                            TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                            i = m.bNm().fl(context);
                            if (new File(bMT.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                                if (i > 0) {
                                    g.bMS().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                                } else {
                                    g.bMS().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                                }
                            } else if (i > 0) {
                                g.bMS().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                            } else {
                                g.bMS().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                            }
                            return false;
                        }
                        g.bMS().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                        return false;
                    }
                    TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                    g.bMS().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                    return false;
                }
            }
            try {
                m.bNm();
                fr = m.fr(context);
                if (fr == null) {
                    TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                    g.bMS().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                    return false;
                }
                if (q.fz(context)) {
                    if (pux != 0) {
                        i = m.bNm().a(true, context);
                        if (pux != i) {
                            puz = null;
                            puA = null;
                            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i, true);
                            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + pux, true);
                            g.bMS().a(context, 303, new Throwable("sTbsVersion: " + pux + "; tbsCoreInstalledVer: " + i));
                            return false;
                        }
                    }
                    i = 0;
                    pux = i;
                }
                if (puz != null) {
                    return true;
                }
                if (q.fz(context)) {
                    g.bMS().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                    return false;
                }
                m.bNm();
                bMT = new File(m.fr(context), "tbs_sdk_extension_dex.jar");
                if (bMT.exists()) {
                    TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                    i = m.bNm().fl(context);
                    if (new File(bMT.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                        if (i > 0) {
                            g.bMS().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                        } else {
                            g.bMS().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                        }
                    } else if (i > 0) {
                        g.bMS().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                    } else {
                        g.bMS().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                    }
                    return false;
                }
                loadClass = new DexClassLoader(bMT.getAbsolutePath(), fr.getAbsolutePath(), bMT.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                puz = loadClass;
                constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                if (q.fz(context)) {
                    puA = constructor.newInstance(new Object[]{context, null});
                } else {
                    puA = constructor.newInstance(new Object[]{context, context});
                }
                n.a(puA, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, c.aKA, c.pyD, c.pyE, c.aOw);
                n.a(puA, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                return true;
            } catch (Throwable th322) {
                TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(th322));
                g.bMS().a(context, 306, th322);
                return false;
            }
        }
    }

    static boolean n(Context context, boolean z) {
        int i = 1;
        boolean z2 = false;
        if (q.fz(context)) {
            q.bNB();
            g.bMS().ab(context, 302);
        } else if (m(context, false)) {
            Object a = n.a(puA, "canLoadX5Core", new Class[]{Integer.TYPE}, Integer.valueOf(36901));
            boolean Z;
            if (a == null) {
                a = n.a(puA, "canLoadX5", new Class[]{Integer.TYPE}, Integer.valueOf(a.bME()));
                if (a == null) {
                    g.bMS().ab(context, 308);
                } else if (!((a instanceof String) && ((String) a).equalsIgnoreCase("AuthenticationFail"))) {
                    if (a instanceof Boolean) {
                        pux = c.bMJ();
                        Z = Z(context, c.bMJ());
                        if (((Boolean) a).booleanValue() && !Z) {
                            z2 = true;
                        }
                        if (!z2) {
                            TbsLog.e("loaderror", "318");
                            TbsLog.w("loaderror", "isX5Disable:" + Z);
                            TbsLog.w("loaderror", "(Boolean) ret:" + ((Boolean) a));
                        }
                    }
                }
            } else if (!((a instanceof String) && ((String) a).equalsIgnoreCase("AuthenticationFail"))) {
                if (a instanceof Bundle) {
                    Bundle bundle = (Bundle) a;
                    if (bundle.isEmpty()) {
                        g.bMS().a(context, 331, new Throwable(String.valueOf(a)));
                        TbsLog.e("loaderror", "empty bundle");
                    } else {
                        int i2 = bundle.getInt("result_code", -1);
                        Z = i2 == 0;
                        String valueOf;
                        if (q.fz(context)) {
                            c.yI(q.bNy());
                            valueOf = String.valueOf(q.bNy());
                            puy = valueOf;
                            if (valueOf.length() == 5) {
                                puy = "0" + puy;
                            }
                            if (puy.length() != 6) {
                                puy = SQLiteDatabase.KeyEmpty;
                            }
                        } else {
                            if (VERSION.SDK_INT >= 12) {
                                puy = bundle.getString("tbs_core_version", "0");
                            } else {
                                valueOf = bundle.getString("tbs_core_version");
                                puy = valueOf;
                                if (valueOf == null) {
                                    puy = "0";
                                }
                            }
                            try {
                                pux = Integer.parseInt(puy);
                            } catch (NumberFormatException e) {
                                pux = 0;
                            }
                            c.yI(pux);
                            if (pux == 0) {
                                g.bMS().a(context, 307, new Throwable("sTbsVersion is 0"));
                            } else {
                                if ((pux <= 0 || pux > 25442) && pux != 25472) {
                                    i = 0;
                                }
                                if (i != 0) {
                                    TbsLog.e("TbsDownload", "is_obsolete --> delete old core:" + pux);
                                    m.bNm();
                                    e.F(m.fr(context));
                                    g.bMS().a(context, 307, new Throwable("is_obsolete --> delete old core:" + pux));
                                }
                            }
                        }
                        try {
                            puF = bundle.getStringArray("tbs_jarfiles");
                            if (puF instanceof String[]) {
                                puI = bundle.getString("tbs_librarypath");
                                a = null;
                                if (i2 != 0) {
                                    try {
                                        a = n.a(puA, "getErrorCodeForLogReport", new Class[0], new Object[0]);
                                    } catch (Exception e2) {
                                    }
                                }
                                switch (i2) {
                                    case -2:
                                        if (!(a instanceof Integer)) {
                                            g.bMS().a(context, TencentLocation.ERROR_UNKNOWN, new Throwable("detail: " + a));
                                            z2 = Z;
                                            break;
                                        }
                                        g.bMS().a(context, ((Integer) a).intValue(), new Throwable("detail: " + a));
                                        z2 = Z;
                                        break;
                                    case -1:
                                        if (!(a instanceof Integer)) {
                                            g.bMS().a(context, 307, new Throwable("detail: " + a));
                                            z2 = Z;
                                            break;
                                        }
                                        g.bMS().a(context, ((Integer) a).intValue(), new Throwable("detail: " + a));
                                        z2 = Z;
                                        break;
                                    case 0:
                                        z2 = Z;
                                        break;
                                    default:
                                        g.bMS().a(context, 415, new Throwable("detail: " + a + "errcode" + i2));
                                        z2 = Z;
                                        break;
                                }
                            }
                            g.bMS().a(context, 307, new Throwable("sJarFiles not instanceof String[]: " + puF));
                        } catch (Throwable th) {
                            g.bMS().a(context, 329, th);
                        }
                    }
                } else {
                    g.bMS().a(context, 330, new Throwable(String.valueOf(a)));
                    TbsLog.e("loaderror", "ret not instance of bundle");
                }
            }
            if (!z2) {
                TbsLog.e("loaderror", "319");
            }
        } else {
            TbsLog.e("QbSdk", "QbSdk.init failure!");
        }
        return z2;
    }

    public static synchronized void preInit(Context context) {
        synchronized (QbSdk.class) {
            preInit(context, null);
        }
    }

    public static synchronized void preInit(final Context context, final a aVar) {
        synchronized (QbSdk.class) {
            TbsLog.initIfNeed(context);
            puQ = puB;
            if (!puE) {
                final Handler anonymousClass2 = new Handler(Looper.getMainLooper()) {
                    public final void handleMessage(Message message) {
                        switch (message.what) {
                            case 1:
                                z bNL = y.bNJ().bNL();
                                if (bNL != null) {
                                    bNL.fL(context);
                                }
                                if (aVar != null) {
                                    aVar.by(true);
                                    return;
                                }
                                return;
                            case 2:
                                if (aVar != null) {
                                    aVar.by(false);
                                    return;
                                }
                                return;
                            case 3:
                                if (aVar != null) {
                                    aVar.RT();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                };
                Thread anonymousClass3 = new Thread() {
                    public final void run() {
                        if (m.bNm().a(true, context) == 0) {
                            m.bNm().t(context, true);
                        }
                        c.kx(true).a(context, null);
                        y bNJ = y.bNJ();
                        bNJ.b(context, null);
                        boolean bNK = bNJ.bNK();
                        anonymousClass2.sendEmptyMessage(3);
                        if (bNK) {
                            anonymousClass2.sendEmptyMessage(1);
                        } else {
                            anonymousClass2.sendEmptyMessage(2);
                        }
                    }
                };
                anonymousClass3.setPriority(10);
                anonymousClass3.start();
                puE = true;
            }
        }
    }

    public static void reset(Context context) {
        TbsLog.e("QbSdk", "QbSdk reset!", true);
        try {
            j.stopDownload();
            j.ff(context);
            e.F(context.getDir("tbs", 0));
            TbsLog.i("QbSdk", "delete downloaded apk success", true);
            m.pwC.set(Integer.valueOf(0));
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(th));
        }
    }

    public static void setCurrentID(String str) {
        if (str != null && str.startsWith(TID_QQNumber_Prefix)) {
            String substring = str.substring(3);
            puO = "0000000000000000".substring(substring.length()) + substring;
        }
    }

    public static void setDeviceInfo(String str, String str2, String str3, String str4) {
        c.aKA = str;
        c.pyD = str2;
        c.pyE = str3;
        c.aOw = str4;
    }

    public static void setDownloadWithoutWifi(boolean z) {
        puU = z;
    }

    public static void setQQBuildNumber(String str) {
        puP = str;
    }

    public static void setTBSInstallingStatus(boolean z) {
        puV = z;
    }

    public static void setTbsListener(n nVar) {
        puS = nVar;
    }

    public static void setTbsLogClient(s sVar) {
        TbsLog.setTbsLogClient(sVar);
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        if (context == null) {
            return -100;
        }
        y bNJ = y.bNJ();
        bNJ.b(context, null);
        return bNJ.bNK() ? (context == null || !context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") || getTbsVersion(context) >= 25487) ? bNJ.bNL().a(context, str, hashMap, null, valueCallback) : -101 : -102;
    }

    public static boolean startQBForDoc(Context context, String str, int i, int i2, String str2, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        return com.tencent.smtt.sdk.a.c.a(context, str, i2, str2, hashMap, bundle);
    }

    public static boolean startQBForVideo(Context context, String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        return com.tencent.smtt.sdk.a.c.a(context, str, hashMap);
    }

    public static boolean startQBToLoadurl(Context context, String str, int i, WebView webView) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        if (webView == null) {
            try {
                String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                if (str2 == "com.tencent.mm" || str2 == "com.tencent.mobileqq") {
                    y bNJ = y.bNJ();
                    if (bNJ != null && bNJ.bNK()) {
                        Object invokeStaticMethod = bNJ.bNL().pxC.invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
                        if (invokeStaticMethod != null) {
                            IX5WebViewBase iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod;
                            if (iX5WebViewBase != null) {
                                webView = (WebView) iX5WebViewBase.getView().getParent();
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return com.tencent.smtt.sdk.a.c.a(context, str, hashMap, "QbSdk.startQBToLoadurl", webView) == 0;
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, u<String> uVar) {
        if (context == null) {
            return false;
        }
        y bNJ = y.bNJ();
        bNJ.b(context, null);
        String str2 = "QbSdk.startMiniQBToLoadUrl";
        if (hashMap != null && "5".equals(hashMap.get(LOGIN_TYPE_KEY_PARTNER_CALL_POS)) && bNJ.bNK()) {
            bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
        }
        if (com.tencent.smtt.sdk.a.c.a(context, str, hashMap, str2, null) == 0) {
            return true;
        }
        if (bNJ.bNK()) {
            if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
                return false;
            }
            if (bNJ.bNL().a(context, str, hashMap, null, uVar) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void unForceSysWebView() {
        puC = false;
        TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
    }

    public static boolean useSoftWare() {
        if (puA == null) {
            return false;
        }
        Object a = n.a(puA, "useSoftWare", new Class[0], new Object[0]);
        if (a == null) {
            a = n.a(puA, "useSoftWare", new Class[]{Integer.TYPE}, Integer.valueOf(a.bME()));
        }
        return a == null ? false : ((Boolean) a).booleanValue();
    }
}
