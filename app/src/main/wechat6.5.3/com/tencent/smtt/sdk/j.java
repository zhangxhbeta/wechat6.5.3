package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDebug;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.e;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.p;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j {
    private static Context aLg;
    private static String pwd;
    private static Handler pwe;
    private static String pwf;
    public static boolean pwg = false;
    private static Object pwh = new byte[0];
    private static f pwi;
    private static HandlerThread pwj;
    static boolean pwk;
    private static boolean pwl = false;
    private static boolean pwm = false;
    private static boolean pwn = false;

    public interface a {
        void d(boolean z, int i);
    }

    private static JSONObject K(boolean z, boolean z2) {
        Object simCountryIso;
        JSONObject jSONObject;
        int fn;
        int i;
        JSONArray bNi;
        f fVar;
        File eX;
        boolean z3;
        boolean booleanValue;
        Object obj = null;
        i fb = i.fb(aLg);
        String bNg = bNg();
        String fU = c.fU(aLg);
        String V = c.V(aLg);
        String fW = c.fW(aLg);
        String str = SQLiteDatabase.KeyEmpty;
        String str2 = SQLiteDatabase.KeyEmpty;
        String id = TimeZone.getDefault().getID();
        if (id != null) {
            Object obj2 = id;
        } else {
            String str3 = str;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) aLg.getSystemService("phone");
            if (telephonyManager != null) {
                simCountryIso = telephonyManager.getSimCountryIso();
                if (simCountryIso == null) {
                    str = str2;
                }
                jSONObject = new JSONObject();
                jSONObject.put("TIMEZONEID", obj2);
                jSONObject.put("COUNTRYISO", simCountryIso);
                jSONObject.put("PROTOCOLVERSION", 1);
                if (q.fz(aLg)) {
                    fn = m.bNm().fn(aLg);
                    if (!z && fn == 0 && m.bNm().fm(aLg)) {
                        fn = -1;
                    }
                    TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] tbsLocalVersion=" + fn + " isDownloadForeground=" + z2);
                    if (z2) {
                        i = fn;
                        if (z) {
                            jSONObject.put("FUNCTION", i != 0 ? 0 : 1);
                        } else {
                            jSONObject.put("FUNCTION", 2);
                        }
                        if (q.fz(aLg)) {
                            bNi = bNi();
                            if (b.fS(aLg) != 3 && bNi.length() != 0 && i == 0 && z) {
                                jSONObject.put("TBSBACKUPARR", bNi);
                            }
                        } else {
                            bNi = bNf();
                            jSONObject.put("TBSVLARR", bNi);
                            fb.pwb.put("last_thirdapp_sendrequest_coreversion", bNi.toString());
                            fb.commit();
                            if (QbSdk.puD) {
                                jSONObject.put("THIRDREQ", 1);
                            }
                        }
                        jSONObject.put("APPN", aLg.getPackageName());
                        jSONObject.put("APPVN", Ql(fb.pwc.getString("app_versionname", null)));
                        jSONObject.put("APPVC", fb.pwc.getInt("app_versioncode", 0));
                        jSONObject.put("APPMETA", Ql(fb.pwc.getString("app_metadata", null)));
                        jSONObject.put("TBSSDKV", 36901);
                        jSONObject.put("TBSV", i);
                        if (i != 0) {
                            str3 = "TBSBACKUPV";
                            fVar = pwi;
                            eX = f.eX(fVar.mContext);
                            if (eX != null) {
                                fn = 0;
                            } else {
                                fn = com.tencent.smtt.utils.a.b(fVar.mContext, new File(eX, fe(fVar.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
                            }
                            jSONObject.put(str3, fn);
                        }
                        jSONObject.put("CPU", pwf);
                        jSONObject.put("UA", bNg);
                        jSONObject.put("IMSI", Ql(fU));
                        jSONObject.put("IMEI", Ql(V));
                        jSONObject.put("ANDROID_ID", Ql(fW));
                        if (!q.fz(aLg)) {
                            if (i == 0) {
                                jSONObject.put("STATUS", QbSdk.Z(aLg, i) ? 0 : 1);
                            } else {
                                jSONObject.put("STATUS", 0);
                            }
                        }
                        z3 = i.fb(aLg).pwc.getBoolean("request_full_package", false);
                        simCountryIso = QbSdk.c(aLg, "can_unlzma", null);
                        booleanValue = (simCountryIso == null && (simCountryIso instanceof Boolean)) ? ((Boolean) simCountryIso).booleanValue() : false;
                        if (booleanValue && !z3) {
                            obj = 1;
                        }
                        if (obj != null) {
                            jSONObject.put("REQUEST_LZMA", 1);
                        }
                        if (fe(aLg)) {
                            jSONObject.put("OVERSEA", 1);
                        }
                        if (z2) {
                            jSONObject.put("DOWNLOAD_FOREGROUND", 1);
                        }
                        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                        return jSONObject;
                    } else if (!m.bNm().fm(aLg)) {
                        fn = 0;
                    }
                } else {
                    fn = QbSdk.puD ? q.bNz() : i.fb(aLg).pwc.getInt("tbs_download_version", 0);
                }
                i = fn;
                if (z) {
                    if (i != 0) {
                    }
                    jSONObject.put("FUNCTION", i != 0 ? 0 : 1);
                } else {
                    jSONObject.put("FUNCTION", 2);
                }
                if (q.fz(aLg)) {
                    bNi = bNi();
                    jSONObject.put("TBSBACKUPARR", bNi);
                } else {
                    bNi = bNf();
                    jSONObject.put("TBSVLARR", bNi);
                    fb.pwb.put("last_thirdapp_sendrequest_coreversion", bNi.toString());
                    fb.commit();
                    if (QbSdk.puD) {
                        jSONObject.put("THIRDREQ", 1);
                    }
                }
                jSONObject.put("APPN", aLg.getPackageName());
                jSONObject.put("APPVN", Ql(fb.pwc.getString("app_versionname", null)));
                jSONObject.put("APPVC", fb.pwc.getInt("app_versioncode", 0));
                jSONObject.put("APPMETA", Ql(fb.pwc.getString("app_metadata", null)));
                jSONObject.put("TBSSDKV", 36901);
                jSONObject.put("TBSV", i);
                if (i != 0) {
                    str3 = "TBSBACKUPV";
                    fVar = pwi;
                    eX = f.eX(fVar.mContext);
                    if (eX != null) {
                        if (fe(fVar.mContext)) {
                        }
                        fn = com.tencent.smtt.utils.a.b(fVar.mContext, new File(eX, fe(fVar.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
                    } else {
                        fn = 0;
                    }
                    jSONObject.put(str3, fn);
                }
                jSONObject.put("CPU", pwf);
                jSONObject.put("UA", bNg);
                jSONObject.put("IMSI", Ql(fU));
                jSONObject.put("IMEI", Ql(V));
                jSONObject.put("ANDROID_ID", Ql(fW));
                if (q.fz(aLg)) {
                    if (i == 0) {
                        jSONObject.put("STATUS", 0);
                    } else {
                        if (QbSdk.Z(aLg, i)) {
                        }
                        jSONObject.put("STATUS", QbSdk.Z(aLg, i) ? 0 : 1);
                    }
                }
                z3 = i.fb(aLg).pwc.getBoolean("request_full_package", false);
                simCountryIso = QbSdk.c(aLg, "can_unlzma", null);
                if (simCountryIso == null) {
                }
                obj = 1;
                if (obj != null) {
                    jSONObject.put("REQUEST_LZMA", 1);
                }
                if (fe(aLg)) {
                    jSONObject.put("OVERSEA", 1);
                }
                if (z2) {
                    jSONObject.put("DOWNLOAD_FOREGROUND", 1);
                }
                TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                return jSONObject;
            }
        } catch (Exception e) {
        }
        str = id;
        if (simCountryIso == null) {
            str = str2;
        }
        jSONObject = new JSONObject();
        try {
            jSONObject.put("TIMEZONEID", obj2);
            jSONObject.put("COUNTRYISO", simCountryIso);
            jSONObject.put("PROTOCOLVERSION", 1);
            if (q.fz(aLg)) {
                fn = m.bNm().fn(aLg);
                fn = -1;
                TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] tbsLocalVersion=" + fn + " isDownloadForeground=" + z2);
                if (z2) {
                    i = fn;
                    if (z) {
                        jSONObject.put("FUNCTION", 2);
                    } else {
                        if (i != 0) {
                        }
                        jSONObject.put("FUNCTION", i != 0 ? 0 : 1);
                    }
                    if (q.fz(aLg)) {
                        bNi = bNf();
                        jSONObject.put("TBSVLARR", bNi);
                        fb.pwb.put("last_thirdapp_sendrequest_coreversion", bNi.toString());
                        fb.commit();
                        if (QbSdk.puD) {
                            jSONObject.put("THIRDREQ", 1);
                        }
                    } else {
                        bNi = bNi();
                        jSONObject.put("TBSBACKUPARR", bNi);
                    }
                    jSONObject.put("APPN", aLg.getPackageName());
                    jSONObject.put("APPVN", Ql(fb.pwc.getString("app_versionname", null)));
                    jSONObject.put("APPVC", fb.pwc.getInt("app_versioncode", 0));
                    jSONObject.put("APPMETA", Ql(fb.pwc.getString("app_metadata", null)));
                    jSONObject.put("TBSSDKV", 36901);
                    jSONObject.put("TBSV", i);
                    if (i != 0) {
                        str3 = "TBSBACKUPV";
                        fVar = pwi;
                        eX = f.eX(fVar.mContext);
                        if (eX != null) {
                            fn = 0;
                        } else {
                            if (fe(fVar.mContext)) {
                            }
                            fn = com.tencent.smtt.utils.a.b(fVar.mContext, new File(eX, fe(fVar.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
                        }
                        jSONObject.put(str3, fn);
                    }
                    jSONObject.put("CPU", pwf);
                    jSONObject.put("UA", bNg);
                    jSONObject.put("IMSI", Ql(fU));
                    jSONObject.put("IMEI", Ql(V));
                    jSONObject.put("ANDROID_ID", Ql(fW));
                    if (q.fz(aLg)) {
                        if (i == 0) {
                            if (QbSdk.Z(aLg, i)) {
                            }
                            jSONObject.put("STATUS", QbSdk.Z(aLg, i) ? 0 : 1);
                        } else {
                            jSONObject.put("STATUS", 0);
                        }
                    }
                    z3 = i.fb(aLg).pwc.getBoolean("request_full_package", false);
                    simCountryIso = QbSdk.c(aLg, "can_unlzma", null);
                    if (simCountryIso == null) {
                    }
                    obj = 1;
                    if (obj != null) {
                        jSONObject.put("REQUEST_LZMA", 1);
                    }
                    if (fe(aLg)) {
                        jSONObject.put("OVERSEA", 1);
                    }
                    if (z2) {
                        jSONObject.put("DOWNLOAD_FOREGROUND", 1);
                    }
                    TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                    return jSONObject;
                } else if (m.bNm().fm(aLg)) {
                    fn = 0;
                }
            } else if (QbSdk.puD) {
            }
            i = fn;
            if (z) {
                if (i != 0) {
                }
                jSONObject.put("FUNCTION", i != 0 ? 0 : 1);
            } else {
                jSONObject.put("FUNCTION", 2);
            }
            if (q.fz(aLg)) {
                bNi = bNi();
                jSONObject.put("TBSBACKUPARR", bNi);
            } else {
                bNi = bNf();
                jSONObject.put("TBSVLARR", bNi);
                fb.pwb.put("last_thirdapp_sendrequest_coreversion", bNi.toString());
                fb.commit();
                if (QbSdk.puD) {
                    jSONObject.put("THIRDREQ", 1);
                }
            }
            jSONObject.put("APPN", aLg.getPackageName());
            jSONObject.put("APPVN", Ql(fb.pwc.getString("app_versionname", null)));
            jSONObject.put("APPVC", fb.pwc.getInt("app_versioncode", 0));
            jSONObject.put("APPMETA", Ql(fb.pwc.getString("app_metadata", null)));
            jSONObject.put("TBSSDKV", 36901);
            jSONObject.put("TBSV", i);
            if (i != 0) {
                str3 = "TBSBACKUPV";
                fVar = pwi;
                eX = f.eX(fVar.mContext);
                if (eX != null) {
                    if (fe(fVar.mContext)) {
                    }
                    fn = com.tencent.smtt.utils.a.b(fVar.mContext, new File(eX, fe(fVar.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
                } else {
                    fn = 0;
                }
                jSONObject.put(str3, fn);
            }
            jSONObject.put("CPU", pwf);
            jSONObject.put("UA", bNg);
            jSONObject.put("IMSI", Ql(fU));
            jSONObject.put("IMEI", Ql(V));
            jSONObject.put("ANDROID_ID", Ql(fW));
            if (q.fz(aLg)) {
                if (i == 0) {
                    jSONObject.put("STATUS", 0);
                } else {
                    if (QbSdk.Z(aLg, i)) {
                    }
                    jSONObject.put("STATUS", QbSdk.Z(aLg, i) ? 0 : 1);
                }
            }
            z3 = i.fb(aLg).pwc.getBoolean("request_full_package", false);
            simCountryIso = QbSdk.c(aLg, "can_unlzma", null);
            if (simCountryIso == null) {
            }
            obj = 1;
            if (obj != null) {
                jSONObject.put("REQUEST_LZMA", 1);
            }
            if (fe(aLg)) {
                jSONObject.put("OVERSEA", 1);
            }
            if (z2) {
                jSONObject.put("DOWNLOAD_FOREGROUND", 1);
            }
        } catch (Exception e2) {
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
        return jSONObject;
    }

    private static boolean L(final boolean z, boolean z2) {
        TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest]isQuery: " + z);
        if (m.bNm().fg(aLg)) {
            TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
            return false;
        }
        int i;
        boolean b;
        final i fb = i.fb(aLg);
        File file = new File(e.ae(aLg, 1), fe(aLg) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        File file2 = new File(e.ae(aLg, 2), fe(aLg) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        File file3 = new File(e.ae(aLg, 3), fe(aLg) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        File file4 = new File(e.ae(aLg, 4), fe(aLg) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        if (!file4.exists()) {
            if (file3.exists()) {
                file3.renameTo(file4);
            } else if (file2.exists()) {
                file2.renameTo(file4);
            } else if (file.exists()) {
                file.renameTo(file4);
            }
        }
        fb.pwb.put("last_check", Long.valueOf(System.currentTimeMillis()));
        fb.pwb.put("app_versionname", c.getAppVersionName(aLg));
        fb.pwb.put("app_versioncode", Integer.valueOf(c.getAppVersionCode(aLg)));
        fb.pwb.put("app_metadata", c.bu(aLg, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
        fb.commit();
        if (pwf == null) {
            pwf = c.bNO();
            fb.pwb.put("device_cpuabi", pwf);
            fb.commit();
        }
        if (!TextUtils.isEmpty(pwf)) {
            Matcher matcher = null;
            try {
                matcher = Pattern.compile("i686|mips|x86_64").matcher(pwf);
            } catch (Exception e) {
            }
            if (matcher != null && matcher.find()) {
                if (z) {
                    fb.yK(-104);
                    return false;
                }
                fb.yK(-205);
                return false;
            }
        }
        JSONObject K = K(z, z2);
        try {
            i = K.getInt("TBSV");
        } catch (Exception e2) {
            i = -1;
        }
        if (i != -1) {
            try {
                String str = p.ge(aLg).pzA;
                TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] postUrl=" + str);
                b = b(f.a(str, K.toString().getBytes("utf-8"), new com.tencent.smtt.utils.f.a() {
                    public final void yN(int i) {
                        TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] httpResponseCode=" + i);
                        if (i < SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD) {
                            return;
                        }
                        if (z) {
                            fb.yK(-107);
                        } else {
                            fb.yK(-207);
                        }
                    }
                }, false), i, z, z2);
            } catch (Throwable th) {
                if (z) {
                    fb.yK(-106);
                    b = false;
                } else {
                    fb.yK(-206);
                }
            }
            return b;
        }
        b = false;
        return b;
    }

    private static String Ql(String str) {
        return str == null ? SQLiteDatabase.KeyEmpty : str;
    }

    private static boolean a(Context context, boolean z, a aVar) {
        Matcher matcher = null;
        i fb = i.fb(context);
        if (VERSION.SDK_INT < 8) {
            fb.yK(-102);
            return false;
        }
        if (!fb.pwc.contains("is_oversea")) {
            if (z && !"com.tencent.mm".equals(context.getApplicationInfo().packageName)) {
                TbsLog.i("TbsDownload", "needDownload-oversea is true, but not WX");
                z = false;
            }
            fb.pwb.put("is_oversea", Boolean.valueOf(z));
            fb.commit();
            pwm = z;
            TbsLog.i("TbsDownload", "needDownload-first-called--isoversea = " + z);
        }
        if (!fe(context) || VERSION.SDK_INT == 16 || VERSION.SDK_INT == 17 || VERSION.SDK_INT == 18) {
            CharSequence string = fb.pwc.getString("device_cpuabi", matcher);
            pwf = string;
            if (!TextUtils.isEmpty(string)) {
                try {
                    matcher = Pattern.compile("i686|mips|x86_64").matcher(pwf);
                } catch (Exception e) {
                }
                if (matcher != null && matcher.find()) {
                    if (aVar != null) {
                        aVar.d(false, 0);
                    }
                    fb.yK(-104);
                    return false;
                }
            }
            return true;
        }
        TbsLog.i("TbsDownload", "needDownload- return false,  because of  version is " + VERSION.SDK_INT + ", and overea");
        if (aVar != null) {
            aVar.d(false, 0);
        }
        fb.yK(-103);
        return false;
    }

    public static boolean a(Context context, boolean z, boolean z2, a aVar) {
        TbsLog.initIfNeed(context);
        if (!m.pwF) {
            TbsLog.app_extra("TbsDownload", context);
            Context applicationContext = context.getApplicationContext();
            aLg = applicationContext;
            i fb = i.fb(applicationContext);
            fb.yK(-100);
            if (!a(aLg, z, aVar)) {
                return false;
            }
            bNd();
            if (pwl) {
                if (aVar != null) {
                    aVar.d(false, 0);
                }
                fb.yK(-105);
                return false;
            }
            boolean contains;
            boolean c = c(aLg, z2, false);
            if (c) {
                TbsLog.i("TbsDownload", "[TbsDownloader.queryConfig]");
                pwe.removeMessages(100);
                Message obtain = Message.obtain(pwe, 100);
                if (aVar != null) {
                    obtain.obj = aVar;
                }
                obtain.arg1 = 0;
                obtain.arg1 = z2 ? 1 : 0;
                obtain.sendToTarget();
                fb.yK(-114);
            }
            pwe.removeMessages(MMGIFException.D_GIF_ERR_READ_FAILED);
            Message.obtain(pwe, MMGIFException.D_GIF_ERR_READ_FAILED).sendToTarget();
            if (QbSdk.puD || !q.fz(context)) {
                contains = fb.pwc.contains("tbs_needdownload");
                TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] hasNeedDownloadKey=" + contains);
                contains = (contains || q.fz(context)) ? fb.pwc.getBoolean("tbs_needdownload", false) : true;
            } else {
                contains = false;
            }
            if (!contains) {
                int fn = m.bNm().fn(aLg);
                if (c || fn <= 0) {
                    pwe.removeMessages(MMGIFException.D_GIF_ERR_NOT_GIF_FILE);
                    if (fn > 0 || c) {
                        Message.obtain(pwe, MMGIFException.D_GIF_ERR_NOT_GIF_FILE, 1, 0, aLg).sendToTarget();
                    } else {
                        Message.obtain(pwe, MMGIFException.D_GIF_ERR_NOT_GIF_FILE, 0, 0, aLg).sendToTarget();
                    }
                    fb.yK(-121);
                } else {
                    fb.yK(-119);
                }
            } else if (bNh()) {
                fb.yK(-118);
            } else {
                contains = false;
            }
            if (!(c || aVar == null)) {
                aVar.d(false, 0);
            }
            TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] needDownload=" + contains);
            return contains;
        } else if (aVar == null) {
            return false;
        } else {
            aVar.d(false, 0);
            return false;
        }
    }

    public static synchronized boolean alC() {
        boolean z;
        synchronized (j.class) {
            TbsLog.i("TbsDownload", "[TbsDownloader.isDownloading]");
            z = pwk;
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(11)
    private static boolean b(java.lang.String r27, int r28, boolean r29, boolean r30) {
        /*
        r2 = "TbsDownload";
        r3 = new java.lang.StringBuilder;
        r4 = "[TbsDownloader.readResponse] response=";
        r3.<init>(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        r2 = aLg;
        r10 = com.tencent.smtt.sdk.i.fb(r2);
        r2 = android.text.TextUtils.isEmpty(r27);
        if (r2 == 0) goto L_0x0033;
    L_0x0024:
        if (r29 == 0) goto L_0x002d;
    L_0x0026:
        r2 = -108; // 0xffffffffffffff94 float:NaN double:NaN;
        r10.yK(r2);
    L_0x002b:
        r2 = 0;
    L_0x002c:
        return r2;
    L_0x002d:
        r2 = -208; // 0xffffffffffffff30 float:NaN double:NaN;
        r10.yK(r2);
        goto L_0x002b;
    L_0x0033:
        r11 = new org.json.JSONObject;
        r0 = r27;
        r11.<init>(r0);
        r2 = "RET";
        r2 = r11.getInt(r2);
        if (r2 == 0) goto L_0x0052;
    L_0x0043:
        if (r29 == 0) goto L_0x004c;
    L_0x0045:
        r2 = -109; // 0xffffffffffffff93 float:NaN double:NaN;
        r10.yK(r2);
    L_0x004a:
        r2 = 0;
        goto L_0x002c;
    L_0x004c:
        r2 = -209; // 0xffffffffffffff2f float:NaN double:NaN;
        r10.yK(r2);
        goto L_0x004a;
    L_0x0052:
        r2 = "RESPONSECODE";
        r12 = r11.getInt(r2);
        r2 = "DOWNLOADURL";
        r13 = r11.getString(r2);
        r2 = "URLLIST";
        r3 = "";
        r14 = r11.optString(r2, r3);
        r2 = "TBSAPKSERVERVERSION";
        r15 = r11.getInt(r2);
        r2 = "DOWNLOADMAXFLOW";
        r16 = r11.getInt(r2);
        r2 = "DOWNLOAD_MIN_FREE_SPACE";
        r17 = r11.getInt(r2);
        r2 = "DOWNLOAD_SUCCESS_MAX_RETRYTIMES";
        r18 = r11.getInt(r2);
        r2 = "DOWNLOAD_FAILED_MAX_RETRYTIMES";
        r19 = r11.getInt(r2);
        r2 = "DOWNLOAD_SINGLE_TIMEOUT";
        r20 = r11.getLong(r2);
        r2 = "TBSAPKFILESIZE";
        r22 = r11.getLong(r2);
        r2 = "RETRY_INTERVAL";
        r4 = 0;
        r8 = r11.optLong(r2, r4);
        r2 = "FLOWCTR";
        r3 = -1;
        r24 = r11.optInt(r2, r3);
        r2 = 0;
        r3 = "USEBBACKUPVER";
        r2 = r11.getInt(r3);	 Catch:{ Exception -> 0x045c }
    L_0x00b4:
        r3 = r10.pwb;
        r4 = "use_backup_version";
        r2 = java.lang.Integer.valueOf(r2);
        r3.put(r4, r2);
        r7 = 0;
        r6 = 0;
        r5 = 0;
        r4 = 0;
        r3 = "";
        r2 = "PKGMD5";
        r7 = r11.getString(r2);	 Catch:{ Exception -> 0x015d }
        r2 = "RESETX5";
        r6 = r11.getInt(r2);	 Catch:{ Exception -> 0x0455 }
        r2 = "UPLOADLOG";
        r5 = r11.getInt(r2);	 Catch:{ Exception -> 0x0455 }
        r2 = "RESETTOKEN";
        r2 = r11.has(r2);	 Catch:{ Exception -> 0x0455 }
        if (r2 == 0) goto L_0x00f0;
    L_0x00e5:
        r2 = "RESETTOKEN";
        r2 = r11.getInt(r2);	 Catch:{ Exception -> 0x0455 }
        if (r2 == 0) goto L_0x015b;
    L_0x00ee:
        r2 = 1;
    L_0x00ef:
        r4 = r2;
    L_0x00f0:
        r2 = "SETTOKEN";
        r2 = r11.has(r2);	 Catch:{ Exception -> 0x0455 }
        if (r2 == 0) goto L_0x0465;
    L_0x00f9:
        r2 = "SETTOKEN";
        r2 = r11.getString(r2);	 Catch:{ Exception -> 0x0455 }
    L_0x0100:
        r3 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r7;
    L_0x0104:
        r7 = pwh;
        monitor-enter(r7);
        if (r3 == 0) goto L_0x0116;
    L_0x0109:
        r3 = r10.pwb;	 Catch:{ all -> 0x0168 }
        r11 = "tbs_deskey_token";
        r25 = "";
        r0 = r25;
        r3.put(r11, r0);	 Catch:{ all -> 0x0168 }
    L_0x0116:
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x0168 }
        if (r3 != 0) goto L_0x0148;
    L_0x011c:
        r3 = r2.length();	 Catch:{ all -> 0x0168 }
        r11 = 96;
        if (r3 != r11) goto L_0x0148;
    L_0x0124:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0168 }
        r3.<init>();	 Catch:{ all -> 0x0168 }
        r2 = r3.append(r2);	 Catch:{ all -> 0x0168 }
        r3 = "&";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0168 }
        r3 = com.tencent.smtt.utils.i.bNY();	 Catch:{ all -> 0x0168 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x0168 }
        r2 = r2.toString();	 Catch:{ all -> 0x0168 }
        r3 = r10.pwb;	 Catch:{ all -> 0x0168 }
        r11 = "tbs_deskey_token";
        r3.put(r11, r2);	 Catch:{ all -> 0x0168 }
    L_0x0148:
        monitor-exit(r7);	 Catch:{ all -> 0x0168 }
        r2 = 1;
        if (r5 != r2) goto L_0x0171;
    L_0x014c:
        if (r29 == 0) goto L_0x016b;
    L_0x014e:
        r2 = -110; // 0xffffffffffffff92 float:NaN double:NaN;
        r10.yK(r2);
    L_0x0153:
        r2 = aLg;
        com.tencent.smtt.sdk.QbSdk.reset(r2);
        r2 = 0;
        goto L_0x002c;
    L_0x015b:
        r2 = 0;
        goto L_0x00ef;
    L_0x015d:
        r2 = move-exception;
        r2 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r7;
    L_0x0162:
        r26 = r3;
        r3 = r2;
        r2 = r26;
        goto L_0x0104;
    L_0x0168:
        r2 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x0168 }
        throw r2;
    L_0x016b:
        r2 = -210; // 0xffffffffffffff2e float:NaN double:NaN;
        r10.yK(r2);
        goto L_0x0153;
    L_0x0171:
        r2 = 1;
        if (r4 != r2) goto L_0x0186;
    L_0x0174:
        r2 = pwe;
        r3 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r2.removeMessages(r3);
        r2 = pwe;
        r3 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r2 = android.os.Message.obtain(r2, r3);
        r2.sendToTarget();
    L_0x0186:
        r4 = 86400; // 0x15180 float:1.21072E-40 double:4.26873E-319;
        r2 = 1;
        r0 = r24;
        if (r0 != r2) goto L_0x045f;
    L_0x018e:
        r2 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0462;
    L_0x0195:
        r2 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
    L_0x0198:
        r8 = 0;
        r7 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r7 <= 0) goto L_0x045f;
    L_0x019e:
        r4 = r10.pwb;
        r5 = "retry_interval";
        r2 = java.lang.Long.valueOf(r2);
        r4.put(r5, r2);
        r2 = android.text.TextUtils.isEmpty(r13);
        if (r2 == 0) goto L_0x01dc;
    L_0x01b0:
        r2 = aLg;
        r2 = com.tencent.smtt.sdk.q.fz(r2);
        if (r2 == 0) goto L_0x01dc;
    L_0x01b8:
        r2 = r10.pwb;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        r10.commit();
        if (r29 == 0) goto L_0x01d9;
    L_0x01ca:
        r2 = "TbsDownload";
        r3 = "downloadUrl is empty --> disable current tbs!";
        com.tencent.smtt.utils.TbsLog.e(r2, r3);
        r2 = aLg;
        r3 = 0;
        com.tencent.smtt.sdk.q.c(r2, r15, r3);
    L_0x01d9:
        r2 = 0;
        goto L_0x002c;
    L_0x01dc:
        if (r12 != 0) goto L_0x0215;
    L_0x01de:
        r2 = r10.pwb;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        if (r29 == 0) goto L_0x0201;
    L_0x01ed:
        r2 = r10.pwb;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -111; // 0xffffffffffffff91 float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
    L_0x01fb:
        r10.commit();
        r2 = 0;
        goto L_0x002c;
    L_0x0201:
        r2 = r10.pwb;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -211; // 0xffffffffffffff2d float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
        r2 = -211; // 0xffffffffffffff2d float:NaN double:NaN;
        r10.yK(r2);
        goto L_0x01fb;
    L_0x0215:
        r2 = aLg;
        r2 = com.tencent.smtt.sdk.i.fb(r2);
        r2 = r2.pwc;
        r3 = "tbs_download_version";
        r4 = 0;
        r3 = r2.getInt(r3, r4);
        if (r3 <= r15) goto L_0x0234;
    L_0x0227:
        r2 = pwi;
        r2.clearCache();
        com.tencent.smtt.sdk.m.bNm();
        r2 = aLg;
        com.tencent.smtt.sdk.m.fq(r2);
    L_0x0234:
        r0 = r28;
        if (r0 >= r15) goto L_0x023e;
    L_0x0238:
        r2 = android.text.TextUtils.isEmpty(r13);
        if (r2 == 0) goto L_0x02fa;
    L_0x023e:
        r2 = r10.pwb;
        r4 = "tbs_needdownload";
        r5 = 0;
        r5 = java.lang.Boolean.valueOf(r5);
        r2.put(r4, r5);
        if (r29 == 0) goto L_0x02d3;
    L_0x024d:
        r2 = android.text.TextUtils.isEmpty(r13);
        if (r2 == 0) goto L_0x02a0;
    L_0x0253:
        r2 = r10.pwb;
        r4 = "tbs_download_interrupt_code_reason";
        r5 = -124; // 0xffffffffffffff84 float:NaN double:NaN;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r4, r5);
    L_0x0261:
        r10.commit();
        r2 = "TbsDownload";
        r4 = new java.lang.StringBuilder;
        r5 = "version error or downloadUrl empty ,return ahead tbsLocalVersion=";
        r4.<init>(r5);
        r0 = r28;
        r4 = r4.append(r0);
        r5 = " tbsDownloadVersion=";
        r4 = r4.append(r5);
        r4 = r4.append(r15);
        r5 = " tbsLastDownloadVersion=";
        r4 = r4.append(r5);
        r3 = r4.append(r3);
        r4 = " downloadUrl=";
        r3 = r3.append(r4);
        r3 = r3.append(r13);
        r3 = r3.toString();
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        r2 = 0;
        goto L_0x002c;
    L_0x02a0:
        if (r15 > 0) goto L_0x02b1;
    L_0x02a2:
        r2 = r10.pwb;
        r4 = "tbs_download_interrupt_code_reason";
        r5 = -125; // 0xffffffffffffff83 float:NaN double:NaN;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r4, r5);
        goto L_0x0261;
    L_0x02b1:
        r0 = r28;
        if (r0 < r15) goto L_0x02c4;
    L_0x02b5:
        r2 = r10.pwb;
        r4 = "tbs_download_interrupt_code_reason";
        r5 = -127; // 0xffffffffffffff81 float:NaN double:NaN;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r4, r5);
        goto L_0x0261;
    L_0x02c4:
        r2 = r10.pwb;
        r4 = "tbs_download_interrupt_code_reason";
        r5 = -112; // 0xffffffffffffff90 float:NaN double:NaN;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r4, r5);
        goto L_0x0261;
    L_0x02d3:
        r2 = -212; // 0xffffffffffffff2c float:NaN double:NaN;
        r4 = android.text.TextUtils.isEmpty(r13);
        if (r4 == 0) goto L_0x02ee;
    L_0x02db:
        r2 = -217; // 0xffffffffffffff27 float:NaN double:NaN;
    L_0x02dd:
        r4 = r10.pwb;
        r5 = "tbs_download_interrupt_code_reason";
        r6 = java.lang.Integer.valueOf(r2);
        r4.put(r5, r6);
        r10.yK(r2);
        goto L_0x0261;
    L_0x02ee:
        if (r15 > 0) goto L_0x02f3;
    L_0x02f0:
        r2 = -218; // 0xffffffffffffff26 float:NaN double:NaN;
        goto L_0x02dd;
    L_0x02f3:
        r0 = r28;
        if (r0 < r15) goto L_0x02dd;
    L_0x02f7:
        r2 = -219; // 0xffffffffffffff25 float:NaN double:NaN;
        goto L_0x02dd;
    L_0x02fa:
        r2 = r10.pwc;
        r3 = "tbs_downloadurl";
        r4 = 0;
        r2 = r2.getString(r3, r4);
        r2 = r13.equals(r2);
        if (r2 != 0) goto L_0x0329;
    L_0x030a:
        r2 = pwi;
        r2.clearCache();
        r2 = r10.pwb;
        r3 = "tbs_download_failed_retrytimes";
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
        r2 = r10.pwb;
        r3 = "tbs_download_success_retrytimes";
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
    L_0x0329:
        r2 = r10.pwb;
        r3 = "tbs_download_version";
        r4 = java.lang.Integer.valueOf(r15);
        r2.put(r3, r4);
        r2 = r10.pwb;
        r3 = "tbs_downloadurl";
        r2.put(r3, r13);
        r2 = r10.pwb;
        r3 = "tbs_downloadurl_list";
        r2.put(r3, r14);
        r2 = r10.pwb;
        r3 = "tbs_responsecode";
        r4 = java.lang.Integer.valueOf(r12);
        r2.put(r3, r4);
        r2 = r10.pwb;
        r3 = "tbs_download_maxflow";
        r4 = java.lang.Integer.valueOf(r16);
        r2.put(r3, r4);
        r2 = r10.pwb;
        r3 = "tbs_download_min_free_space";
        r4 = java.lang.Integer.valueOf(r17);
        r2.put(r3, r4);
        r2 = r10.pwb;
        r3 = "tbs_download_success_max_retrytimes";
        r4 = java.lang.Integer.valueOf(r18);
        r2.put(r3, r4);
        r2 = r10.pwb;
        r3 = "tbs_download_failed_max_retrytimes";
        r4 = java.lang.Integer.valueOf(r19);
        r2.put(r3, r4);
        r2 = r10.pwb;
        r3 = "tbs_single_timeout";
        r4 = java.lang.Long.valueOf(r20);
        r2.put(r3, r4);
        r2 = r10.pwb;
        r3 = "tbs_apkfilesize";
        r4 = java.lang.Long.valueOf(r22);
        r2.put(r3, r4);
        r10.commit();
        if (r6 == 0) goto L_0x03a6;
    L_0x039e:
        r2 = r10.pwb;
        r3 = "tbs_apk_md5";
        r2.put(r3, r6);
    L_0x03a6:
        if (r30 != 0) goto L_0x03eb;
    L_0x03a8:
        r2 = com.tencent.smtt.sdk.m.bNm();
        r3 = aLg;
        r2 = r2.ac(r3, r15);
        if (r2 == 0) goto L_0x03eb;
    L_0x03b4:
        if (r29 == 0) goto L_0x03d7;
    L_0x03b6:
        r2 = r10.pwb;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -113; // 0xffffffffffffff8f float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
    L_0x03c4:
        r2 = r10.pwb;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
    L_0x03d1:
        r10.commit();
        r2 = 1;
        goto L_0x002c;
    L_0x03d7:
        r2 = r10.pwb;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -213; // 0xffffffffffffff2b float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
        r2 = -213; // 0xffffffffffffff2b float:NaN double:NaN;
        r10.yK(r2);
        goto L_0x03c4;
    L_0x03eb:
        if (r30 != 0) goto L_0x043f;
    L_0x03ed:
        r3 = pwi;
        r2 = 1;
        if (r12 == r2) goto L_0x03f5;
    L_0x03f2:
        r2 = 2;
        if (r12 != r2) goto L_0x043d;
    L_0x03f5:
        r2 = 1;
    L_0x03f6:
        r2 = r3.ky(r2);
        if (r2 == 0) goto L_0x043f;
    L_0x03fc:
        r2 = r10.pwb;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        r2 = aLg;
        r2 = com.tencent.smtt.sdk.o.fx(r2);
        r3 = 100;
        r2.setErrorCode(r3);
        r2 = aLg;
        r2 = com.tencent.smtt.sdk.o.fx(r2);
        r3 = new java.lang.StringBuilder;
        r4 = "use local backup apk in needDownload";
        r3.<init>(r4);
        r4 = pwi;
        r4 = r4.pvN;
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2.Qn(r3);
        r2 = aLg;
        r2 = com.tencent.smtt.sdk.o.fx(r2);
        r3 = com.tencent.smtt.sdk.o.a.TYPE_DOWNLOAD;
        r2.a(r3);
        goto L_0x03d1;
    L_0x043d:
        r2 = 0;
        goto L_0x03f6;
    L_0x043f:
        if (r29 != 0) goto L_0x0446;
    L_0x0441:
        r2 = -216; // 0xffffffffffffff28 float:NaN double:NaN;
        r10.yK(r2);
    L_0x0446:
        r2 = r10.pwb;
        r3 = "tbs_needdownload";
        r4 = 1;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        goto L_0x03d1;
    L_0x0455:
        r2 = move-exception;
        r2 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r7;
        goto L_0x0162;
    L_0x045c:
        r3 = move-exception;
        goto L_0x00b4;
    L_0x045f:
        r2 = r4;
        goto L_0x019e;
    L_0x0462:
        r2 = r8;
        goto L_0x0198;
    L_0x0465:
        r2 = r3;
        goto L_0x0100;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.j.b(java.lang.String, int, boolean, boolean):boolean");
    }

    public static boolean bNc() {
        if (pwi != null) {
            f fVar = pwi;
            TbsLog.i("TbsDownload", "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + fVar.pvM);
            if (fVar.pvM) {
                return true;
            }
        }
        return false;
    }

    private static synchronized void bNd() {
        synchronized (j.class) {
            if (pwj == null) {
                pwj = k.bNl();
                try {
                    pwi = new f(aLg);
                    pwe = new Handler(pwj.getLooper()) {
                        public final void handleMessage(Message message) {
                            boolean z = true;
                            switch (message.what) {
                                case 100:
                                    boolean z2 = message.arg1 == 1;
                                    z = j.L(true, false);
                                    if (message.obj != null && (message.obj instanceof a)) {
                                        TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish needStartDownload=" + z);
                                        if (!z || z2) {
                                            ((a) message.obj).d(z, i.fb(j.aLg).pwc.getInt("tbs_download_version", 0));
                                        }
                                    }
                                    if (q.fz(j.aLg) && z) {
                                        j.fd(j.aLg);
                                        return;
                                    }
                                    return;
                                case MMGIFException.D_GIF_ERR_OPEN_FAILED /*101*/:
                                    FileLock fileLock = null;
                                    FileOutputStream b = e.b(j.aLg, false, "tbs_download_lock_file" + i.fb(j.aLg).pwc.getInt("tbs_download_version", 0) + ".txt");
                                    if (b != null) {
                                        fileLock = e.a(b);
                                        if (fileLock == null) {
                                            TbsLog.i("TbsDownload", "file lock locked,wx or qq is downloading");
                                            i.fb(j.aLg).yK(-203);
                                            return;
                                        }
                                    } else if (e.fY(j.aLg)) {
                                        i.fb(j.aLg).yK(-204);
                                        return;
                                    }
                                    if (message.arg1 != 1) {
                                        z = false;
                                    }
                                    i fb = i.fb(j.aLg);
                                    if (!j.L(false, z)) {
                                        QbSdk.puW.hp(MMGIFException.D_GIF_ERR_CLOSE_FAILED);
                                    } else if (z && m.bNm().ac(j.aLg, i.fb(j.aLg).pwc.getInt("tbs_download_version", 0))) {
                                        QbSdk.puW.hp(122);
                                        fb.yK(-213);
                                    } else if (fb.pwc.getBoolean("tbs_needdownload", false)) {
                                        i.fb(j.aLg).yK(-215);
                                        j.pwi.kz(z);
                                    } else {
                                        QbSdk.puW.hp(MMGIFException.D_GIF_ERR_CLOSE_FAILED);
                                    }
                                    TbsLog.i("TbsDownload", "------freeFileLock called :");
                                    e.a(fileLock, b);
                                    return;
                                case MMGIFException.D_GIF_ERR_READ_FAILED /*102*/:
                                    TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                                    int bNz = q.fz(j.aLg) ? q.bNz() : m.bNm().fn(j.aLg);
                                    TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] localTbsVersion=" + bNz);
                                    f bNk = j.pwi;
                                    try {
                                        File file = new File(bNk.pvx, "x5.tbs");
                                        int b2 = com.tencent.smtt.utils.a.b(bNk.mContext, file);
                                        if (-1 == b2 || (bNz > 0 && bNz == b2)) {
                                            file.delete();
                                        }
                                    } catch (Exception e) {
                                    }
                                    o.fx(j.aLg).bNr();
                                    return;
                                case MMGIFException.D_GIF_ERR_NOT_GIF_FILE /*103*/:
                                    TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                                    if (message.arg1 == 0) {
                                        m.bNm().s((Context) message.obj, true);
                                        return;
                                    } else {
                                        m.bNm().s((Context) message.obj, false);
                                        return;
                                    }
                                case MMGIFException.D_GIF_ERR_NO_SCRN_DSCR /*104*/:
                                    TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
                                    o.fx(j.aLg).bNq();
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                } catch (Exception e) {
                    pwl = true;
                    TbsLog.e("TbsDownload", "TbsApkDownloader init has Exception");
                }
            }
        }
    }

    private static boolean bNe() {
        try {
            return i.fb(aLg).pwc.getString("last_thirdapp_sendrequest_coreversion", SQLiteDatabase.KeyEmpty).equals(bNf().toString());
        } catch (Exception e) {
            return false;
        }
    }

    private static JSONArray bNf() {
        if (!q.fz(aLg)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Object bNu = q.bNu();
        String packageName = aLg.getApplicationContext().getPackageName();
        if (!packageName.equals(q.fB(aLg))) {
            return jSONArray;
        }
        Object obj = new String[5];
        System.arraycopy(bNu, 0, obj, 0, 4);
        obj[4] = packageName;
        return jSONArray;
    }

    static String bNg() {
        if (!TextUtils.isEmpty(pwd)) {
            return pwd;
        }
        String str;
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = VERSION.RELEASE;
        try {
            str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e) {
            str = str2;
        }
        if (str.length() > 0) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append("1.0");
        }
        stringBuffer.append("; ");
        str = locale.getLanguage();
        if (str != null) {
            stringBuffer.append(str.toLowerCase());
            str = locale.getCountry();
            if (str != null) {
                stringBuffer.append("-");
                stringBuffer.append(str.toLowerCase());
            }
        } else {
            stringBuffer.append("en");
        }
        if ("REL".equals(VERSION.CODENAME)) {
            str2 = Build.MODEL;
            try {
                str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
            } catch (Exception e2) {
                str = str2;
            }
            if (str.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str);
            }
        }
        str = Build.ID.replaceAll("[一-龥]", SQLiteDatabase.KeyEmpty);
        if (str.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(str);
        }
        str = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[]{stringBuffer});
        pwd = str;
        return str;
    }

    private static boolean bNh() {
        i fb = i.fb(aLg);
        if (fb.pwc.getInt("tbs_download_success_retrytimes", 0) >= fb.bMZ()) {
            TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            fb.yK(-115);
            return false;
        } else if (fb.pwc.getInt("tbs_download_failed_retrytimes", 0) >= fb.bNa()) {
            TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            fb.yK(-116);
            return false;
        } else if (e.fZ(aLg)) {
            if (System.currentTimeMillis() - fb.pwc.getLong("tbs_downloadstarttime", 0) <= 86400000) {
                long j = fb.pwc.getLong("tbs_downloadflow", 0);
                TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] downloadFlow=" + j);
                if (j >= fb.bMW()) {
                    TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
                    fb.yK(-120);
                    return false;
                }
            }
            return true;
        } else {
            TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            fb.yK(-117);
            return false;
        }
    }

    private static JSONArray bNi() {
        JSONArray jSONArray = new JSONArray();
        String[] bNu = q.bNu();
        for (int i = 0; i < 4; i++) {
            File file = new File(e.a(aLg, bNu[i], 4, false), fe(aLg) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (file.exists()) {
                long b = (long) com.tencent.smtt.utils.a.b(aLg, file);
                if (b > 0) {
                    boolean z;
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        if (((long) jSONArray.optInt(i2)) == b) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        jSONArray.put(b);
                    }
                }
            }
        }
        return jSONArray;
    }

    private static boolean c(Context context, boolean z, boolean z2) {
        i fb = i.fb(context);
        if (z) {
            return true;
        }
        String string = fb.pwc.getString("app_versionname", null);
        int i = fb.pwc.getInt("app_versioncode", 0);
        String string2 = fb.pwc.getString("app_metadata", null);
        String appVersionName = c.getAppVersionName(aLg);
        int appVersionCode = c.getAppVersionCode(aLg);
        String bu = c.bu(aLg, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] appVersionName=" + appVersionName + " oldAppVersionName=" + string + " appVersionCode=" + appVersionCode + " oldAppVersionCode=" + i + " appMetadata=" + bu + " oldAppVersionMetadata=" + string2);
        long currentTimeMillis = System.currentTimeMillis();
        long j = fb.pwc.getLong("last_check", 0);
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] timeLastCheck=" + j + " timeNow=" + currentTimeMillis);
        if (z2) {
            boolean contains = fb.pwc.contains("last_check");
            TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=" + contains);
            if (contains && j == 0) {
                j = currentTimeMillis;
            }
        }
        long bMX = fb.bMX();
        TbsLog.i("TbsDownload", "retryInterval = " + bMX + " s");
        if (currentTimeMillis - j <= 1000 * bMX) {
            if (q.fz(aLg) && q.bNA() == 0 && !bNe()) {
                e.F(aLg.getDir("tbs", 0));
                m.pwC.set(Integer.valueOf(0));
                return true;
            } else if (appVersionName == null || appVersionCode == 0 || bu == null || (appVersionName.equals(string) && appVersionCode == i && bu.equals(string2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean fc(Context context) {
        boolean z = true;
        aLg = context.getApplicationContext();
        TbsLog.initIfNeed(context);
        if (!a(aLg, false, null)) {
            return false;
        }
        int fn = m.bNm().fn(context);
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] localTbsVersion=" + fn);
        if (fn > 0) {
            return false;
        }
        if (c(aLg, false, true)) {
            return true;
        }
        i fb = i.fb(aLg);
        boolean contains = fb.pwc.contains("tbs_needdownload");
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] hasNeedDownloadKey=" + contains);
        boolean z2 = !contains ? true : fb.pwc.getBoolean("tbs_needdownload", false);
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] needDownload=" + z2);
        if (!(z2 && bNh())) {
            z = false;
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] ret=" + z);
        return z;
    }

    public static void fd(Context context) {
        p(context, false);
    }

    public static synchronized boolean fe(Context context) {
        boolean z;
        synchronized (j.class) {
            if (!pwn) {
                pwn = true;
                i fb = i.fb(context);
                if (fb.pwc.contains("is_oversea")) {
                    pwm = fb.pwc.getBoolean("is_oversea", false);
                    TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  first called. sOverSea = " + pwm);
                }
                TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  sOverSea = " + pwm);
            }
            z = pwm;
        }
        return z;
    }

    @TargetApi(11)
    static void ff(Context context) {
        i fb = i.fb(context);
        try {
            fb.pwb.clear();
            Editor edit = fb.pwc.edit();
            edit.clear();
            edit.commit();
        } catch (Exception e) {
        }
        o fx = o.fx(context);
        try {
            fx.bMM();
            edit = fx.bNs().edit();
            edit.clear();
            edit.commit();
        } catch (Exception e2) {
        }
        f.eZ(context);
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_extension_config", 4) : context.getSharedPreferences("tbs_extension_config", 0)).edit().clear().commit();
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit().clear().commit();
    }

    public static boolean o(Context context, boolean z) {
        return a(context, z, false, null);
    }

    public static synchronized void p(Context context, boolean z) {
        int i = 1;
        synchronized (j.class) {
            TbsLog.i("TbsDownload", "[TbsDownloader.startDownload] sAppContext=" + aLg);
            if (!m.pwF) {
                pwk = true;
                Context applicationContext = context.getApplicationContext();
                aLg = applicationContext;
                i.fb(applicationContext).yK(-200);
                if (VERSION.SDK_INT < 8) {
                    QbSdk.puW.hp(MMGIFException.D_GIF_ERR_CLOSE_FAILED);
                    i.fb(aLg).yK(-201);
                } else {
                    bNd();
                    if (pwl) {
                        QbSdk.puW.hp(121);
                        i.fb(aLg).yK(-202);
                    } else {
                        if (z) {
                            stopDownload();
                        }
                        pwe.removeMessages(MMGIFException.D_GIF_ERR_OPEN_FAILED);
                        pwe.removeMessages(100);
                        Message obtain = Message.obtain(pwe, MMGIFException.D_GIF_ERR_OPEN_FAILED, QbSdk.puW);
                        if (!z) {
                            i = 0;
                        }
                        obtain.arg1 = i;
                        obtain.sendToTarget();
                    }
                }
            }
        }
    }

    public static void stopDownload() {
        if (!pwl) {
            TbsLog.i("TbsDownload", "[TbsDownloader.stopDownload]");
            if (pwi != null) {
                pwi.QK = true;
            }
            if (pwe != null) {
                pwe.removeMessages(100);
                pwe.removeMessages(MMGIFException.D_GIF_ERR_OPEN_FAILED);
            }
        }
    }

    protected static File yM(int i) {
        String[] bNu = q.bNu();
        File file = null;
        for (int i2 = 0; i2 < 4; i2++) {
            String str = bNu[i2];
            if (!str.equals(aLg.getApplicationInfo().packageName)) {
                file = new File(e.a(aLg, str, 4, false), fe(aLg) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                if (!file.exists()) {
                    TbsLog.i("TbsDownload", "can not find local backup core file");
                } else if (com.tencent.smtt.utils.a.b(aLg, file) == i) {
                    TbsLog.i("TbsDownload", "local tbs version fond,path = " + file.getAbsolutePath());
                    break;
                } else {
                    TbsLog.i("TbsDownload", "version is not match");
                }
            }
        }
        return file;
    }
}
