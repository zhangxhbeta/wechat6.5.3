package com.tencent.mm.plugin.voip.b;

import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.widget.Toast;
import com.tencent.mm.e.a.al;
import com.tencent.mm.e.a.ao;
import com.tencent.mm.e.a.at;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.h.j;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class d {
    public static Context kzS = null;
    private static final String kzT;
    private static final Uri kzU = Uri.parse("content://com.lbe.security.miui.permmgr/active");

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VERSION.RELEASE:[" + VERSION.RELEASE);
        stringBuilder.append("] VERSION.CODENAME:[" + VERSION.CODENAME);
        stringBuilder.append("] VERSION.INCREMENTAL:[" + VERSION.INCREMENTAL);
        stringBuilder.append("] BOARD:[" + Build.BOARD);
        stringBuilder.append("] DEVICE:[" + Build.DEVICE);
        stringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
        stringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
        stringBuilder.append("] HOST:[" + Build.HOST);
        stringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
        stringBuilder.append("] MODEL:[" + Build.MODEL);
        stringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
        stringBuilder.append("] TAGS:[" + Build.TAGS);
        stringBuilder.append("] TYPE:[" + Build.TYPE);
        stringBuilder.append("] USER:[" + Build.USER + "]");
        kzT = stringBuilder.toString();
    }

    public static boolean dt(long j) {
        int i;
        long currentTimeMillis = System.currentTimeMillis() - j;
        v.d("VoipUtil", "timeDif:%d ", new Object[]{Long.valueOf(currentTimeMillis)});
        try {
            String ah = be.ah(j.sU().getValue("VoipTimeLogicValue"), "0");
            v.i("VoipUtil", "config value: " + ah);
            i = be.getInt(ah, 0);
        } catch (Exception e) {
            v.e("VoipUtil", "voipCanTalk parseInt error");
            i = 0;
        }
        if (i == -1) {
            v.v("VoipUtil", "voipCanTalk, dynamic config always can talk");
            return true;
        }
        if (i == 0) {
            i = j.sV().sM();
            if (i <= 0) {
                i = 10;
            } else {
                v.i("VoipUtil", "voipCanTalk, dynamic config can talk in %d minute", new Object[]{Integer.valueOf(i)});
            }
        }
        if (currentTimeMillis < ((long) (-i)) * 60000 || currentTimeMillis > ((long) i) * 60000) {
            return false;
        }
        v.i("VoipUtil", "voip can talk");
        return true;
    }

    public static int bdw() {
        return VERSION.SDK_INT;
    }

    private static boolean bdx() {
        FileInputStream fileInputStream;
        boolean z = false;
        try {
            Properties properties = new Properties();
            fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            try {
                properties.load(fileInputStream);
                String property = properties.getProperty("ro.miui.ui.version.name", null);
                if (property != null && property.equals("V6")) {
                    z = true;
                }
            } catch (IOException e) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                v.d("VoipUtil", "isMIUIv6 " + z);
                return z;
            }
        } catch (IOException e3) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            v.d("VoipUtil", "isMIUIv6 " + z);
            return z;
        }
        v.d("VoipUtil", "isMIUIv6 " + z);
        return z;
    }

    public static boolean cF(Context context) {
        boolean z = false;
        if (bdx()) {
            z = cI(context);
        }
        v.d("VoipUtil", "isLbePermissionEnable ret:" + z);
        return z;
    }

    public static boolean cG(Context context) {
        boolean z = false;
        if (bdx()) {
            z = cH(context);
        }
        v.d("VoipUtil", "setLbePermissionEnable ret:" + z);
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean cH(android.content.Context r13) {
        /*
        r11 = 2;
        r9 = 0;
        r10 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r7 = 1;
        r8 = 0;
        r6 = -1;
        r0 = r13.getContentResolver();	 Catch:{ Throwable -> 0x00ad, all -> 0x00d2 }
        r1 = kzU;	 Catch:{ Throwable -> 0x00f7, all -> 0x00d2 }
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x00f7, all -> 0x00d2 }
        r3 = 0;
        r4 = "userAccept";
        r2[r3] = r4;	 Catch:{ Throwable -> 0x00f7, all -> 0x00d2 }
        r3 = "pkgName='com.tencent.mm'";
        r4 = 0;
        r5 = 0;
        r2 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x00f7, all -> 0x00d2 }
        if (r2 == 0) goto L_0x0107;
    L_0x0021:
        r1 = r2.getCount();	 Catch:{ Throwable -> 0x00fa }
        if (r1 <= 0) goto L_0x0107;
    L_0x0027:
        r1 = r2.moveToLast();	 Catch:{ Throwable -> 0x00fa }
        if (r1 == 0) goto L_0x0107;
    L_0x002d:
        r1 = 0;
        r6 = r2.getInt(r1);	 Catch:{ Throwable -> 0x00fa }
        r1 = r6;
    L_0x0033:
        if (r2 == 0) goto L_0x0102;
    L_0x0035:
        r2.close();
        r12 = r1;
        r1 = r0;
        r0 = r12;
    L_0x003b:
        r2 = "VoipUtil";
        r3 = "setLbePermissionEnable query ua: ";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = java.lang.Integer.valueOf(r0);
        r4[r8] = r5;
        r5 = " flag: ";
        r4[r7] = r5;
        r5 = java.lang.Integer.valueOf(r10);
        r4[r11] = r5;
        com.tencent.mm.sdk.platformtools.v.d(r2, r3, r4);
        r2 = -1;
        r3 = -1;
        if (r0 == r3) goto L_0x00fc;
    L_0x005c:
        if (r1 == 0) goto L_0x00fc;
    L_0x005e:
        r3 = r0 | r10;
        r0 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00da }
        r0.<init>();	 Catch:{ Throwable -> 0x00da }
        r4 = "userAccept";
        r5 = java.lang.Integer.valueOf(r3);	 Catch:{ Throwable -> 0x00da }
        r0.put(r4, r5);	 Catch:{ Throwable -> 0x00da }
        r4 = kzU;	 Catch:{ Throwable -> 0x00da }
        r5 = "pkgName='com.tencent.mm'";
        r6 = 0;
        r0 = r1.update(r4, r0, r5, r6);	 Catch:{ Throwable -> 0x00da }
        r1 = "VoipUtil";
        r2 = "serLbePermissionEnable update ua: ";
        r4 = 5;
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x00f1 }
        r5 = 0;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Throwable -> 0x00f1 }
        r4[r5] = r3;	 Catch:{ Throwable -> 0x00f1 }
        r3 = 1;
        r5 = " flag: ";
        r4[r3] = r5;	 Catch:{ Throwable -> 0x00f1 }
        r3 = 2;
        r5 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x00f1 }
        r4[r3] = r5;	 Catch:{ Throwable -> 0x00f1 }
        r3 = 3;
        r5 = " ret: ";
        r4[r3] = r5;	 Catch:{ Throwable -> 0x00f1 }
        r3 = 4;
        r5 = java.lang.Integer.valueOf(r0);	 Catch:{ Throwable -> 0x00f1 }
        r4[r3] = r5;	 Catch:{ Throwable -> 0x00f1 }
        com.tencent.mm.sdk.platformtools.v.d(r1, r2, r4);	 Catch:{ Throwable -> 0x00f1 }
    L_0x00a8:
        r2 = r0;
    L_0x00a9:
        if (r2 <= 0) goto L_0x00ef;
    L_0x00ab:
        r0 = r7;
    L_0x00ac:
        return r0;
    L_0x00ad:
        r0 = move-exception;
        r1 = r0;
        r2 = r9;
        r0 = r9;
    L_0x00b1:
        r3 = "VoipUtil";
        r4 = "isLbePermissionEnable query ";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00f5 }
        r9 = 0;
        r5[r9] = r1;	 Catch:{ all -> 0x00f5 }
        r1 = 1;
        r9 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x00f5 }
        r5[r1] = r9;	 Catch:{ all -> 0x00f5 }
        com.tencent.mm.sdk.platformtools.v.w(r3, r4, r5);	 Catch:{ all -> 0x00f5 }
        if (r2 == 0) goto L_0x00fe;
    L_0x00cb:
        r2.close();
        r1 = r0;
        r0 = r6;
        goto L_0x003b;
    L_0x00d2:
        r0 = move-exception;
        r2 = r9;
    L_0x00d4:
        if (r2 == 0) goto L_0x00d9;
    L_0x00d6:
        r2.close();
    L_0x00d9:
        throw r0;
    L_0x00da:
        r0 = move-exception;
    L_0x00db:
        r1 = "VoipUtil";
        r3 = "isLbePermissionEnable update ";
        r4 = new java.lang.Object[r11];
        r4[r8] = r0;
        r0 = java.lang.Integer.valueOf(r10);
        r4[r7] = r0;
        com.tencent.mm.sdk.platformtools.v.w(r1, r3, r4);
        goto L_0x00a9;
    L_0x00ef:
        r0 = r8;
        goto L_0x00ac;
    L_0x00f1:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x00db;
    L_0x00f5:
        r0 = move-exception;
        goto L_0x00d4;
    L_0x00f7:
        r1 = move-exception;
        r2 = r9;
        goto L_0x00b1;
    L_0x00fa:
        r1 = move-exception;
        goto L_0x00b1;
    L_0x00fc:
        r0 = r2;
        goto L_0x00a8;
    L_0x00fe:
        r1 = r0;
        r0 = r6;
        goto L_0x003b;
    L_0x0102:
        r12 = r1;
        r1 = r0;
        r0 = r12;
        goto L_0x003b;
    L_0x0107:
        r1 = r6;
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.b.d.cH(android.content.Context):boolean");
    }

    private static boolean cI(Context context) {
        Cursor query;
        Throwable th;
        try {
            query = context.getContentResolver().query(kzU, new String[]{"suggestAccept", "userAccept", "userPrompt", "userReject"}, "pkgName='com.tencent.mm'", null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0 && query.moveToLast()) {
                        boolean z = ((query.getInt(0) & 131072) == 131072 && (query.getInt(2) & 131072) == 0 && (query.getInt(3) & 131072) == 0) || (query.getInt(1) & 131072) == 131072;
                        if (query == null) {
                            return z;
                        }
                        query.close();
                        return z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        v.w("gray", "isLbePermissionEnable", new Object[]{th, Integer.valueOf(131072)});
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return false;
    }

    public static void cJ(Context context) {
        Toast.makeText(context, 2131235917, 0).show();
    }

    public static int lR(String str) {
        int i = 0;
        try {
            i = be.getInt(j.sU().getValue(str), 0);
        } catch (Exception e) {
            v.e("VoipUtil", "getIntValFromDynamicConfig parseInt failed, val: " + str);
        }
        return i;
    }

    public static boolean bdy() {
        ao aoVar = new ao();
        a.nhr.z(aoVar);
        return aoVar.aYh.aYi;
    }

    public static boolean bdz() {
        qi qiVar = new qi();
        qiVar.brC.bdn = 2;
        a.nhr.z(qiVar);
        return qiVar.brD.brE;
    }

    public static boolean bdA() {
        at atVar = new at();
        a.nhr.z(atVar);
        return atVar.aYv.aYi;
    }

    public static boolean bdB() {
        al alVar = new al();
        a.nhr.z(alVar);
        return alVar.aYe.aYf;
    }

    public static Notification a(Builder builder) {
        if (com.tencent.mm.compatible.util.d.dX(16)) {
            return builder.getNotification();
        }
        return builder.build();
    }
}
