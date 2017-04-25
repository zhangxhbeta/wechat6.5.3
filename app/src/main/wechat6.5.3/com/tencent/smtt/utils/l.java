package com.tencent.smtt.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.a.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class l {
    private static l pzi = null;
    private Handler mHandler;

    private l() {
        this.mHandler = null;
        this.mHandler = new Handler(this, Looper.getMainLooper()) {
            final /* synthetic */ l pzj;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void handleMessage(android.os.Message r4) {
                /*
                r3 = this;
                r0 = r4.what;	 Catch:{ Exception -> 0x001d }
                switch(r0) {
                    case 0: goto L_0x0009;
                    case 1: goto L_0x001f;
                    case 2: goto L_0x0030;
                    default: goto L_0x0005;
                };
            L_0x0005:
                super.handleMessage(r4);
                return;
            L_0x0009:
                r0 = r4.obj;	 Catch:{ Exception -> 0x001d }
                r0 = (java.lang.Object[]) r0;	 Catch:{ Exception -> 0x001d }
                r0 = (java.lang.Object[]) r0;	 Catch:{ Exception -> 0x001d }
                r1 = 0;
                r1 = r0[r1];	 Catch:{ Exception -> 0x001d }
                r1 = (android.content.Context) r1;	 Catch:{ Exception -> 0x001d }
                r2 = 1;
                r0 = r0[r2];	 Catch:{ Exception -> 0x001d }
                r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x001d }
                com.tencent.smtt.utils.l.bx(r1, r0);	 Catch:{ Exception -> 0x001d }
                goto L_0x0005;
            L_0x001d:
                r0 = move-exception;
                goto L_0x0005;
            L_0x001f:
                r0 = r4.obj;	 Catch:{ Exception -> 0x001d }
                r0 = (java.lang.Object[]) r0;	 Catch:{ Exception -> 0x001d }
                r0 = (java.lang.Object[]) r0;	 Catch:{ Exception -> 0x001d }
                r1 = r3.pzj;	 Catch:{ Exception -> 0x001d }
                r2 = 0;
                r0 = r0[r2];	 Catch:{ Exception -> 0x001d }
                r0 = (android.content.Context) r0;	 Catch:{ Exception -> 0x001d }
                com.tencent.smtt.utils.l.a(r1, r0);	 Catch:{ Exception -> 0x001d }
                goto L_0x0005;
            L_0x0030:
                r0 = r4.obj;	 Catch:{ Exception -> 0x001d }
                r0 = (java.lang.Object[]) r0;	 Catch:{ Exception -> 0x001d }
                r0 = (java.lang.Object[]) r0;	 Catch:{ Exception -> 0x001d }
                r1 = 0;
                r1 = r0[r1];	 Catch:{ Exception -> 0x001d }
                r1 = (android.content.Context) r1;	 Catch:{ Exception -> 0x001d }
                r2 = 1;
                r0 = r0[r2];	 Catch:{ Exception -> 0x001d }
                r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x001d }
                com.tencent.smtt.utils.l.by(r1, r0);	 Catch:{ Exception -> 0x001d }
                goto L_0x0005;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.l.1.handleMessage(android.os.Message):void");
            }
        };
    }

    private static Map<String, String> Qr(String str) {
        if (str.length() <= 0) {
            return null;
        }
        try {
            Map<String, String> hashMap = new HashMap();
            try {
                for (String str2 : str.split("\n")) {
                    if (str2 != null && str2.length() > 0) {
                        String[] split = str2.trim().split("=", 2);
                        if (split != null && split.length >= 2) {
                            String str3 = split[0];
                            Object obj = split[1];
                            if (str3 != null && str3.length() > 0) {
                                hashMap.put(str3, obj);
                            }
                        }
                    }
                }
                return hashMap;
            } catch (Throwable th) {
                return hashMap;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    static /* synthetic */ void a(l lVar, Context context) {
        try {
            Object bOe = lVar.bOe();
            if (!TextUtils.isEmpty(bOe)) {
                File file = new File(bOe);
                if (file.exists()) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    context.startActivity(intent);
                    m.ga(context);
                    String str = context.getApplicationInfo().processName;
                    if (!TextUtils.isEmpty(str)) {
                        m.Qs(str);
                        m.Qt(str);
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    public static l bOc() {
        if (pzi == null) {
            pzi = new l();
        }
        return pzi;
    }

    private static Map<String, String> bOd() {
        Throwable th;
        FileInputStream fileInputStream = null;
        String str = SQLiteDatabase.KeyEmpty;
        try {
            FileInputStream fileInputStream2;
            String str2 = "/data/data/com.tencent.mobileqq/app_tbs/share/QQBrowserDownloadInfo.ini";
            String str3 = "/data/data/com.qzone/app_tbs/share/QQBrowserDownloadInfo.ini";
            File file = new File("/data/data/com.tencent.mm/app_tbs/share/QQBrowserDownloadInfo.ini");
            if (!file.exists()) {
                file = new File(str2);
            }
            File file2 = !file.exists() ? new File(str3) : file;
            if (file2.exists()) {
                fileInputStream2 = new FileInputStream(file2);
                try {
                    byte[] n = e.n(fileInputStream2);
                    if (n != null) {
                        str = new String(n, "utf-8");
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                        }
                    }
                    throw th;
                }
            }
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e2) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return Qr(str);
    }

    private String bOe() {
        Map bOd = bOd();
        if (bOd != null && bOd.size() > 0) {
            String str = (String) bOd.get("FileDownloadPath");
            String str2 = (String) bOd.get("FileDownloadVerifyInfo");
            if (TextUtils.isEmpty(str)) {
                return SQLiteDatabase.KeyEmpty;
            }
            if (TextUtils.isEmpty(str2)) {
                return SQLiteDatabase.KeyEmpty;
            }
            File file = new File(str);
            if (!file.exists()) {
                return SQLiteDatabase.KeyEmpty;
            }
            if (TextUtils.equals(h.aX(file.lastModified()), str2)) {
                return str;
            }
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public static void bx(Context context, String str) {
        if (context != null && str != null && str.length() > 0) {
            c.a(context, str, null, null);
        }
    }

    static /* synthetic */ void by(Context context, String str) {
        if (context != null && str != null && str.length() > 0) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
        }
    }

    private static PackageInfo m(String str, Context context) {
        PackageInfo packageInfo = null;
        if (!(context == null || TextUtils.isEmpty(str))) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, FileUtils.S_IWUSR);
            } catch (Throwable th) {
            }
        }
        return packageInfo;
    }

    public final boolean bw(Context context, String str) {
        if (str != null) {
            try {
                if (str.startsWith("tbsqbdownload://")) {
                    String substring;
                    String str2;
                    String[] split = str.substring(16).split(",");
                    if (split.length > 1) {
                        String[] split2 = split[0].split("=");
                        substring = (split2.length <= 1 || !SlookSmartClipMetaTag.TAG_TYPE_URL.equalsIgnoreCase(split2[0])) ? null : split[0].substring(4);
                        String[] split3 = split[1].split("=");
                        if (split3.length <= 1 || !"downloadurl".equalsIgnoreCase(split3[0])) {
                            str2 = substring;
                            substring = null;
                        } else {
                            str2 = substring;
                            substring = split[1].substring(12);
                        }
                    } else {
                        substring = null;
                        str2 = null;
                    }
                    if (str2 == null || substring == null) {
                        return false;
                    }
                    boolean z = m("com.tencent.mtt", context) != null ? true : !TextUtils.isEmpty(bOe());
                    Object obj;
                    Message message;
                    if (z) {
                        obj = new Object[]{context, str2};
                        message = new Message();
                        message.what = 0;
                        message.obj = obj;
                        this.mHandler.sendMessage(message);
                        return true;
                    } else if (z) {
                        obj = new Object[]{context};
                        message = new Message();
                        message.what = 1;
                        message.obj = obj;
                        this.mHandler.sendMessage(message);
                        return true;
                    } else {
                        obj = new Object[]{context, substring};
                        message = new Message();
                        message.what = 2;
                        message.obj = obj;
                        this.mHandler.sendMessage(message);
                        return true;
                    }
                }
            } catch (Exception e) {
            }
        }
        return false;
    }
}
