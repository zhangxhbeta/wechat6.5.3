package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import android.os.HandlerThread;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.UnsupportedEncodingException;

public final class a {
    private static HandlerThread dPG;
    private static ac dPH = new ac(dPG.getLooper());
    private static long[] dPI = new long[7];

    static {
        HandlerThread bJ = e.bJ("app_brand_report_thread", 1);
        dPG = bJ;
        bJ.start();
    }

    public static String br(Context context) {
        String str;
        if (!ak.isConnected(context)) {
            str = "offline";
        } else if (ak.isWifi(context)) {
            str = "wifi";
        } else if (ak.is4G(context)) {
            str = "4g";
        } else if (ak.is3G(context)) {
            str = "3g";
        } else if (ak.is2G(context)) {
            str = "2g";
        } else {
            str = "unknown";
        }
        v.i("MicroMsg.AppBrandReporterManager", "get networkType %s", new Object[]{str});
        return str;
    }

    public static void j(int i, String str, String str2) {
        v.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, appid %s, appversion %d, appidlist %s", new Object[]{Integer.valueOf(13533), Integer.valueOf(i), be.ma(str), Integer.valueOf(0), str2});
        g.iuh.h(13533, new Object[]{Integer.valueOf(i), be.ma(str), Integer.valueOf(0), str2});
    }

    public static void g(String str, int i, String str2) {
        v.d("MicroMsg.AppBrandReporterManager", "stev report(%s), appId %s, appVersion %s, appState : %d, eventId %d, scene %d, sceneId %s", new Object[]{Integer.valueOf(13801), str, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(3), Integer.valueOf(1), str2});
        g.iuh.h(13801, new Object[]{str, Integer.valueOf(0), Integer.valueOf(i), Long.valueOf(be.Nh()), Integer.valueOf(3), Integer.valueOf(1), str2});
    }

    public static void a(Context context, String str, String str2, long j, int i, long j2) {
        String encode;
        Throwable e;
        String str3 = "";
        if (be.kS(str)) {
            v.e("MicroMsg.AppBrandReporterManager", "appId is Null!");
            return;
        }
        AppBrandStatObject ms = com.tencent.mm.plugin.appbrand.a.ms(str);
        if (ms == null) {
            v.e("MicroMsg.AppBrandReporterManager", "statObject is Null!");
            return;
        }
        Long valueOf = Long.valueOf(ms.dPP);
        long j3 = ms.dPR;
        String str4 = ms.dPS;
        String str5 = ms.dPT;
        if (i == 6 || i == 3) {
            j2 = ms.dOa;
        }
        ms.dOa = 0;
        if (!be.kS(str2)) {
            if (str2.contains(".html")) {
                String str6 = str2;
                str3 = str6.substring(0, str2.lastIndexOf(".html") + 5);
            }
        }
        String ma = be.ma(ms.aWP);
        String ma2 = be.ma(ms.aZj);
        if (ms.scene == 0) {
            ms.scene = BaseReportManager.MAX_READ_COUNT;
        }
        if (context == null) {
            Integer num = ms.dPB;
        } else {
            Object br = br(context);
        }
        if (j3 > 0 && valueOf.longValue() >= j3 && j >= valueOf.longValue()) {
            long longValue = valueOf.longValue() - j3;
            long longValue2 = j - valueOf.longValue();
            if (longValue2 > j2) {
                longValue2 -= j2;
            }
            String str7 = "";
            String str8 = "";
            String str9 = "";
            try {
                str7 = p.encode(be.ma(str4), "UTF-8");
                encode = p.encode(be.ma(str3), "UTF-8");
                try {
                    str9 = p.encode(be.ma(str5), "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    v.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
                    v.a("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
                    v.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, sessionId %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, networkType %s, costTime %s,stayTime %s, referPagePath %s, targetAction %s, targetPagePath %s, clickTimestamp %s", new Object[]{Integer.valueOf(13536), Integer.valueOf(ms.scene), ma, ma2, str, Integer.valueOf(ms.bpy), Integer.valueOf(ms.dJB), Integer.valueOf(ms.dPC), str4, num, Long.valueOf(longValue), Long.valueOf(longValue2), str5, Integer.valueOf(i), str3, Long.valueOf(j3)});
                    g.iuh.h(13536, new Object[]{Integer.valueOf(ms.scene), ma, ma2, str, Integer.valueOf(ms.bpy), Integer.valueOf(ms.dJB), Integer.valueOf(ms.dPC), str7, num, Long.valueOf(longValue), Long.valueOf(longValue2), str9, Integer.valueOf(i), encode, Long.valueOf(j3)});
                    if (i != 2) {
                    }
                    ms.dPT = str4;
                    ms.dPS = str3;
                    ms.dPR = j;
                }
            } catch (Throwable e3) {
                Throwable th = e3;
                encode = str8;
                e = th;
                v.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
                v.a("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
                v.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, sessionId %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, networkType %s, costTime %s,stayTime %s, referPagePath %s, targetAction %s, targetPagePath %s, clickTimestamp %s", new Object[]{Integer.valueOf(13536), Integer.valueOf(ms.scene), ma, ma2, str, Integer.valueOf(ms.bpy), Integer.valueOf(ms.dJB), Integer.valueOf(ms.dPC), str4, num, Long.valueOf(longValue), Long.valueOf(longValue2), str5, Integer.valueOf(i), str3, Long.valueOf(j3)});
                g.iuh.h(13536, new Object[]{Integer.valueOf(ms.scene), ma, ma2, str, Integer.valueOf(ms.bpy), Integer.valueOf(ms.dJB), Integer.valueOf(ms.dPC), str7, num, Long.valueOf(longValue), Long.valueOf(longValue2), str9, Integer.valueOf(i), encode, Long.valueOf(j3)});
                if (i != 2) {
                }
                ms.dPT = str4;
                ms.dPS = str3;
                ms.dPR = j;
            }
            v.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, sessionId %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, networkType %s, costTime %s,stayTime %s, referPagePath %s, targetAction %s, targetPagePath %s, clickTimestamp %s", new Object[]{Integer.valueOf(13536), Integer.valueOf(ms.scene), ma, ma2, str, Integer.valueOf(ms.bpy), Integer.valueOf(ms.dJB), Integer.valueOf(ms.dPC), str4, num, Long.valueOf(longValue), Long.valueOf(longValue2), str5, Integer.valueOf(i), str3, Long.valueOf(j3)});
            g.iuh.h(13536, new Object[]{Integer.valueOf(ms.scene), ma, ma2, str, Integer.valueOf(ms.bpy), Integer.valueOf(ms.dJB), Integer.valueOf(ms.dPC), str7, num, Long.valueOf(longValue), Long.valueOf(longValue2), str9, Integer.valueOf(i), encode, Long.valueOf(j3)});
        }
        if (i != 2 || i == 1) {
            ms.dPT = str4;
            ms.dPS = str3;
            ms.dPR = j;
        }
    }

    public static void b(String str, String str2, int i, int i2, int i3) {
        AppBrandStatObject ms = com.tencent.mm.plugin.appbrand.a.ms(str);
        if (ms == null) {
            ms = new AppBrandStatObject();
            v.i("MicroMsg.AppBrandReporterManager", "statObject is Null!");
        }
        String str3 = "";
        if (!be.kS(str2) && str2.contains(".html")) {
            str3 = str2.substring(0, str2.lastIndexOf(".html") + 5);
        }
        String str4 = "";
        try {
            str4 = p.encode(be.ma(str3), "UTF-8");
        } catch (Throwable e) {
            v.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
            v.a("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
        }
        String ma = be.ma(ms.aWP);
        String ma2 = be.ma(ms.aZj);
        long Nh = be.Nh();
        v.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, sessionId %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, networkType %s, eventId %d,eventRusult %d, eventPercent %d, installCostTime %s, eventTime %s", new Object[]{Integer.valueOf(13537), Integer.valueOf(ms.scene), ma, ma2, str, Integer.valueOf(ms.bpy), Integer.valueOf(ms.dJB), Integer.valueOf(ms.dPC), str3, ms.dPB, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3), Long.valueOf(Nh)});
        g.iuh.h(13537, new Object[]{Integer.valueOf(ms.scene), ma, ma2, str, Integer.valueOf(ms.bpy), Integer.valueOf(ms.dJB), Integer.valueOf(ms.dPC), str4, ms.dPB, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3), Long.valueOf(Nh)});
    }

    public static void a(String str, String str2, int i, String str3, long j, int i2, int i3) {
        AppBrandStatObject ms = com.tencent.mm.plugin.appbrand.a.ms(str);
        if (ms == null) {
            v.e("MicroMsg.AppBrandReporterManager", "statObject is Null!");
            return;
        }
        String str4 = "";
        if (!be.kS(str2) && str2.contains(".html")) {
            str4 = str2.substring(0, str2.lastIndexOf(".html") + 5);
        }
        String str5 = "";
        try {
            str5 = p.encode(be.ma(str4), "UTF-8");
        } catch (Throwable e) {
            v.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
            v.a("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
        }
        String ma = be.ma(str3);
        String ma2 = be.ma(ms.aWP);
        String ma3 = be.ma(ms.aZj);
        v.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, sessionId %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, action %d, actionNote %s,actionTime %s, actionResult %d, actionErrorcode %d", new Object[]{Integer.valueOf(13539), Integer.valueOf(ms.scene), ma2, ma3, str, Integer.valueOf(ms.bpy), Integer.valueOf(ms.dJB), Integer.valueOf(ms.dPC), str4, Integer.valueOf(i), ma, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3)});
        g.iuh.h(13539, new Object[]{Integer.valueOf(ms.scene), ma2, ma3, str, Integer.valueOf(ms.bpy), Integer.valueOf(ms.dJB), Integer.valueOf(ms.dPC), str5, Integer.valueOf(i), ma, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public static void a(String str, String str2, int i, String str3, String str4, int i2, String str5, long j, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        if (!be.kS(str)) {
            AppBrandSysConfig nh = com.tencent.mm.plugin.appbrand.a.a.OO().nh(str);
            if (nh != null) {
                i5 = be.f(Integer.valueOf(nh.dDB.dBs));
                i6 = nh.dDB.dBr + 1;
            }
            String str6 = "";
            if (!be.kS(str4)) {
                if (str4.contains(".html")) {
                    String str7 = str4;
                    str6 = str7.substring(0, str4.lastIndexOf(".html") + 5);
                }
            }
            String str8 = "";
            try {
                str8 = p.encode(be.ma(str6), "UTF-8");
            } catch (Throwable e) {
                v.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
                v.a("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
            }
            String ma = be.ma(str3);
            String ma2 = be.ma(str5);
            String ma3 = be.ma(str2);
            v.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, action %d, actionNote %s,actionTime %s, actionResult %d, actionErrorcode %d", new Object[]{Integer.valueOf(13540), Integer.valueOf(i), ma, ma3, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(0), str6, Integer.valueOf(i2), ma2, Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(i4)});
            g.iuh.h(13540, new Object[]{Integer.valueOf(i), ma, ma3, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(0), str8, Integer.valueOf(i2), ma2, Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, int i, int i2, long j, String str5) {
        final Context context2 = context;
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str4;
        final int i3 = i;
        final int i4 = i2;
        final long j2 = j;
        final String str10 = str5;
        dPH.post(new Runnable() {
            public final void run() {
                a.b(context2, str6, str7, str8, str9, i3, i4, j2, str10);
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, int r21, long r22, java.lang.String r24) {
        /*
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r16);
        if (r1 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r6 = com.tencent.mm.plugin.appbrand.a.ms(r16);
        if (r6 != 0) goto L_0x0017;
    L_0x000d:
        r1 = "MicroMsg.AppBrandReporterManager";
        r2 = "statObject is Null!";
        com.tencent.mm.sdk.platformtools.v.e(r1, r2);
        goto L_0x0006;
    L_0x0017:
        r1 = 9;
        r2 = new java.lang.String[r1];
        r1 = 0;
        r3 = "updateMap";
        r2[r1] = r3;
        r1 = 1;
        r3 = "addMapMarkers";
        r2[r1] = r3;
        r1 = 2;
        r3 = "addMapLines";
        r2[r1] = r3;
        r1 = 3;
        r3 = "addMapCircles";
        r2[r1] = r3;
        r1 = 4;
        r3 = "addMapControls";
        r2[r1] = r3;
        r1 = 5;
        r3 = "moveToMapLocation";
        r2[r1] = r3;
        r1 = 6;
        r3 = "getMapCenterLocation";
        r2[r1] = r3;
        r1 = 7;
        r3 = "drawCanvas";
        r2[r1] = r3;
        r1 = 8;
        r3 = "updateCanvas";
        r2[r1] = r3;
        r1 = 0;
    L_0x0053:
        r3 = 9;
        if (r1 >= r3) goto L_0x0064;
    L_0x0057:
        r3 = r2[r1];
        r0 = r18;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x0006;
    L_0x0061:
        r1 = r1 + 1;
        goto L_0x0053;
    L_0x0064:
        r1 = "";
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r19);
        if (r2 != 0) goto L_0x00d7;
    L_0x006d:
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r18);
        if (r2 != 0) goto L_0x00d7;
    L_0x0073:
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x025e }
        r0 = r19;
        r2.<init>(r0);	 Catch:{ JSONException -> 0x025e }
        r3 = "url";
        r3 = r2.has(r3);	 Catch:{ JSONException -> 0x025e }
        if (r3 == 0) goto L_0x021b;
    L_0x0083:
        r3 = "openLink";
        r0 = r18;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x025e }
        if (r3 != 0) goto L_0x00d0;
    L_0x008e:
        r3 = "redirectTo";
        r0 = r18;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x025e }
        if (r3 != 0) goto L_0x00d0;
    L_0x0099:
        r3 = "navigateTo";
        r0 = r18;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x025e }
        if (r3 != 0) goto L_0x00d0;
    L_0x00a4:
        r3 = "request";
        r0 = r18;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x025e }
        if (r3 != 0) goto L_0x00d0;
    L_0x00af:
        r3 = "connectSocket";
        r0 = r18;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x025e }
        if (r3 != 0) goto L_0x00d0;
    L_0x00ba:
        r3 = "uploadFile";
        r0 = r18;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x025e }
        if (r3 != 0) goto L_0x00d0;
    L_0x00c5:
        r3 = "downloadFile";
        r0 = r18;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x025e }
        if (r3 == 0) goto L_0x021b;
    L_0x00d0:
        r3 = "url";
        r1 = r2.optString(r3);	 Catch:{ JSONException -> 0x025e }
    L_0x00d7:
        r2 = "";
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r17);
        if (r3 != 0) goto L_0x00fd;
    L_0x00e0:
        r3 = ".html";
        r0 = r17;
        r3 = r0.contains(r3);
        if (r3 == 0) goto L_0x00fd;
    L_0x00eb:
        r2 = 0;
        r3 = ".html";
        r0 = r17;
        r3 = r0.lastIndexOf(r3);
        r3 = r3 + 5;
        r0 = r17;
        r2 = r0.substring(r2, r3);
    L_0x00fd:
        r3 = "";
        r4 = com.tencent.mm.sdk.platformtools.be.ma(r2);	 Catch:{ UnsupportedEncodingException -> 0x02de }
        r5 = "UTF-8";
        r3 = com.tencent.mm.compatible.util.p.encode(r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x02de }
    L_0x010b:
        r4 = "";
        r5 = com.tencent.mm.sdk.platformtools.be.ma(r1);	 Catch:{ UnsupportedEncodingException -> 0x02f6 }
        r7 = "UTF-8";
        r4 = com.tencent.mm.compatible.util.p.encode(r5, r7);	 Catch:{ UnsupportedEncodingException -> 0x02f6 }
    L_0x0119:
        r7 = com.tencent.mm.sdk.platformtools.be.ma(r18);
        r8 = com.tencent.mm.sdk.platformtools.be.ma(r24);
        r5 = r6.aWP;
        r9 = com.tencent.mm.sdk.platformtools.be.ma(r5);
        if (r15 != 0) goto L_0x030e;
    L_0x0129:
        r5 = r6.dPB;
    L_0x012b:
        r10 = "MicroMsg.AppBrandReporterManager";
        r11 = "stev report(%s), scene : %s, sceneNote %s, appId %s, appVersion %d, appState %d, pagePath %s, networkType %s, functionName %s, keyParam %s, result %d, permissionValue %d, errorCode %d, costTime %s, errCode %d, errMsg %s, usedState %d";
        r12 = 17;
        r12 = new java.lang.Object[r12];
        r13 = 0;
        r14 = 13542; // 0x34e6 float:1.8976E-41 double:6.6906E-320;
        r14 = java.lang.Integer.valueOf(r14);
        r12[r13] = r14;
        r13 = 1;
        r14 = r6.scene;
        r14 = java.lang.Integer.valueOf(r14);
        r12[r13] = r14;
        r13 = 2;
        r12[r13] = r9;
        r13 = 3;
        r12[r13] = r16;
        r13 = 4;
        r14 = r6.bpy;
        r14 = java.lang.Integer.valueOf(r14);
        r12[r13] = r14;
        r13 = 5;
        r14 = r6.dJB;
        r14 = java.lang.Integer.valueOf(r14);
        r12[r13] = r14;
        r13 = 6;
        r12[r13] = r2;
        r2 = 7;
        r12[r2] = r5;
        r2 = 8;
        r12[r2] = r7;
        r2 = 9;
        r12[r2] = r1;
        r1 = 10;
        r2 = java.lang.Integer.valueOf(r20);
        r12[r1] = r2;
        r1 = 11;
        r2 = java.lang.Integer.valueOf(r21);
        r12[r1] = r2;
        r1 = 12;
        r2 = 0;
        r2 = java.lang.Integer.valueOf(r2);
        r12[r1] = r2;
        r1 = 13;
        r2 = java.lang.Long.valueOf(r22);
        r12[r1] = r2;
        r1 = 14;
        r2 = 0;
        r2 = java.lang.Integer.valueOf(r2);
        r12[r1] = r2;
        r1 = 15;
        r12[r1] = r8;
        r1 = 16;
        r2 = r6.dPC;
        r2 = java.lang.Integer.valueOf(r2);
        r12[r1] = r2;
        com.tencent.mm.sdk.platformtools.v.d(r10, r11, r12);
        r1 = com.tencent.mm.plugin.report.service.g.iuh;
        r2 = 13542; // 0x34e6 float:1.8976E-41 double:6.6906E-320;
        r10 = 16;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r12 = r6.scene;
        r12 = java.lang.Integer.valueOf(r12);
        r10[r11] = r12;
        r11 = 1;
        r10[r11] = r9;
        r9 = 2;
        r10[r9] = r16;
        r9 = 3;
        r11 = r6.bpy;
        r11 = java.lang.Integer.valueOf(r11);
        r10[r9] = r11;
        r9 = 4;
        r11 = r6.dJB;
        r11 = java.lang.Integer.valueOf(r11);
        r10[r9] = r11;
        r9 = 5;
        r10[r9] = r3;
        r3 = 6;
        r10[r3] = r5;
        r3 = 7;
        r10[r3] = r7;
        r3 = 8;
        r10[r3] = r4;
        r3 = 9;
        r4 = java.lang.Integer.valueOf(r20);
        r10[r3] = r4;
        r3 = 10;
        r4 = java.lang.Integer.valueOf(r21);
        r10[r3] = r4;
        r3 = 11;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r10[r3] = r4;
        r3 = 12;
        r4 = java.lang.Long.valueOf(r22);
        r10[r3] = r4;
        r3 = 13;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r10[r3] = r4;
        r3 = 14;
        r10[r3] = r8;
        r3 = 15;
        r4 = r6.dPC;
        r4 = java.lang.Integer.valueOf(r4);
        r10[r3] = r4;
        r1.h(r2, r10);
        goto L_0x0006;
    L_0x021b:
        r3 = "authorize";
        r0 = r18;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x025e }
        if (r3 == 0) goto L_0x027c;
    L_0x0226:
        r3 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0248 }
        r4 = "scope";
        r2 = r2.optString(r4);	 Catch:{ Exception -> 0x0248 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0248 }
        r4 = new java.util.LinkedList;	 Catch:{ JSONException -> 0x025e }
        r4.<init>();	 Catch:{ JSONException -> 0x025e }
        r2 = 0;
    L_0x0238:
        r5 = r3.length();	 Catch:{ JSONException -> 0x025e }
        if (r2 >= r5) goto L_0x0276;
    L_0x023e:
        r5 = r3.optString(r2);	 Catch:{ JSONException -> 0x025e }
        r4.add(r5);	 Catch:{ JSONException -> 0x025e }
        r2 = r2 + 1;
        goto L_0x0238;
    L_0x0248:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandReporterManager";
        r4 = "Exception %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ JSONException -> 0x025e }
        r7 = 0;
        r2 = r2.getMessage();	 Catch:{ JSONException -> 0x025e }
        r5[r7] = r2;	 Catch:{ JSONException -> 0x025e }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ JSONException -> 0x025e }
        goto L_0x0006;
    L_0x025e:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandReporterManager";
        r4 = "get keyParam error!";
        com.tencent.mm.sdk.platformtools.v.e(r3, r4);
        r3 = "MicroMsg.AppBrandReporterManager";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x00d7;
    L_0x0276:
        r1 = r4.toString();	 Catch:{ JSONException -> 0x025e }
        goto L_0x00d7;
    L_0x027c:
        r3 = "shareAppMessage";
        r0 = r18;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x025e }
        if (r3 == 0) goto L_0x02a7;
    L_0x0287:
        r2 = r2.toString();	 Catch:{ UnsupportedEncodingException -> 0x0298 }
        r2 = com.tencent.mm.sdk.platformtools.be.ma(r2);	 Catch:{ UnsupportedEncodingException -> 0x0298 }
        r3 = "UTF-8";
        r1 = com.tencent.mm.compatible.util.p.encode(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x0298 }
        goto L_0x00d7;
    L_0x0298:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandReporterManager";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ JSONException -> 0x025e }
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);	 Catch:{ JSONException -> 0x025e }
        goto L_0x00d7;
    L_0x02a7:
        r3 = "requestPayment";
        r0 = r18;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x025e }
        if (r3 == 0) goto L_0x02bb;
    L_0x02b2:
        r3 = "package";
        r1 = r2.optString(r3);	 Catch:{ JSONException -> 0x025e }
        goto L_0x00d7;
    L_0x02bb:
        r3 = "reportSubmitForm";
        r0 = r18;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x025e }
        if (r3 == 0) goto L_0x02ca;
    L_0x02c6:
        r1 = r6.dJz;	 Catch:{ JSONException -> 0x025e }
        goto L_0x00d7;
    L_0x02ca:
        r3 = "makePhoneCall";
        r0 = r18;
        r3 = r0.equals(r3);	 Catch:{ JSONException -> 0x025e }
        if (r3 == 0) goto L_0x00d7;
    L_0x02d5:
        r3 = "phoneNumber";
        r1 = r2.optString(r3);	 Catch:{ JSONException -> 0x025e }
        goto L_0x00d7;
    L_0x02de:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandReporterManager";
        r7 = "encode page path error!";
        com.tencent.mm.sdk.platformtools.v.e(r5, r7);
        r5 = "MicroMsg.AppBrandReporterManager";
        r7 = "";
        r8 = 0;
        r8 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.v.a(r5, r4, r7, r8);
        goto L_0x010b;
    L_0x02f6:
        r5 = move-exception;
        r7 = "MicroMsg.AppBrandReporterManager";
        r8 = "encode keyParam path error!";
        com.tencent.mm.sdk.platformtools.v.e(r7, r8);
        r7 = "MicroMsg.AppBrandReporterManager";
        r8 = "";
        r9 = 0;
        r9 = new java.lang.Object[r9];
        com.tencent.mm.sdk.platformtools.v.a(r7, r5, r8, r9);
        goto L_0x0119;
    L_0x030e:
        r5 = br(r15);
        goto L_0x012b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.report.a.b(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, long, java.lang.String):void");
    }

    public static void b(String str, long j, int i) {
        AppBrandStatObject ms = com.tencent.mm.plugin.appbrand.a.ms(str);
        if (ms == null) {
            v.e("MicroMsg.AppBrandReporterManager", "statObject is Null!");
            return;
        }
        int i2 = ms.bpy;
        v.d("MicroMsg.AppBrandReporterManager", "stev report(%s), appId %s, appVersion %s, costTime : %s, type %d", new Object[]{Integer.valueOf(13543), str, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i)});
        g.iuh.h(13543, new Object[]{str, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i)});
    }

    public static void S(String str, int i) {
        int i2 = BaseReportManager.MAX_READ_COUNT;
        String str2 = "";
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        if (!be.kS(str)) {
            AppBrandStatObject ms = com.tencent.mm.plugin.appbrand.a.ms(str);
            if (ms != null) {
                i5 = ms.scene == 0 ? BaseReportManager.MAX_READ_COUNT : ms.scene;
                String ma = be.ma(ms.aWP);
                int i6 = ms.bpy;
                i4 = ms.dJB;
                i3 = i6;
                str2 = ma;
                i2 = i5;
                i5 = ms.dPC;
            }
            AppBrandSysConfig mr = com.tencent.mm.plugin.appbrand.a.mr(str);
            if (!(i3 != 0 || mr == null || mr.dDB == null)) {
                i3 = mr.dDB.dBs;
            }
            if (!(i4 != 0 || mr == null || mr.dDB == null)) {
                i4 = mr.dDB.dBr + 1;
            }
        }
        v.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %s, sceneNote %s, appId %s, appVersion %s, appState %s, usedState %s, pagetype %s, targetAction %s", new Object[]{Integer.valueOf(13541), Integer.valueOf(i2), str2, str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(3)});
        g.iuh.h(13541, new Object[]{Integer.valueOf(i2), str2, str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(3), ""});
    }

    public static void A(int i, String str) {
        v.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene %d, nearbyListId %s", new Object[]{Integer.valueOf(13917), Integer.valueOf(i), str});
        g.iuh.h(13917, new Object[]{Integer.valueOf(i), Integer.valueOf(0), str, Long.valueOf(be.Nh())});
    }

    public static void c(long j, boolean z) {
        int i = j <= 2000 ? z ? 8 : 1 : j <= 3000 ? z ? 9 : 2 : j <= 4000 ? z ? 10 : 3 : j <= 5000 ? z ? 11 : 4 : j <= 6000 ? z ? 12 : 5 : z ? 13 : 6;
        g.iuh.a(367, (long) i, 1, false);
        if (z) {
            g.iuh.a(367, 7, 1, false);
        } else {
            g.iuh.a(367, 0, 1, false);
        }
        v.v("MicroMsg.AppBrandReporterManager", "startApp cost %s msec(hasDownload : %b).", new Object[]{Long.valueOf(j), Boolean.valueOf(z)});
    }

    public static void RK() {
        int bux = be.bux();
        v.i("MicroMsg.AppBrandReporterManager", "report now process mem : %d", new Object[]{Integer.valueOf(be.bux())});
        if (bux <= 90) {
            bux = 2;
        } else if (bux <= 130) {
            bux = 3;
        } else if (bux <= 170) {
            bux = 4;
        } else if (bux <= 210) {
            bux = 5;
        } else {
            bux = 6;
        }
        g.iuh.a(386, 1, 1, false);
        g.iuh.a(386, (long) bux, 1, false);
    }

    public static void n(int i, long j) {
        if (i == 0) {
            for (int i2 = 0; i2 < dPI.length; i2++) {
                dPI[i2] = 0;
            }
        }
        if (i < dPI.length && dPI[i] == 0) {
            dPI[i] = j;
        }
    }

    public static void ok(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (long append : dPI) {
            stringBuilder.append(append);
            stringBuilder.append(",");
        }
        v.i("MicroMsg.AppBrandReporterManager", "Report Startup Time: %s, %s", new Object[]{str, stringBuilder.toString()});
        u(str, 1, 0);
        u(str, 2, 1);
        u(str, 3, 2);
        u(str, 4, 3);
        u(str, 6, 4);
        u(str, 7, 6);
        u(str, 8, 5);
    }

    private static void u(String str, int i, int i2) {
        g.iuh.h(13886, new Object[]{str, Integer.valueOf(com.tencent.mm.plugin.appbrand.a.mr(str).dDB.dBs), Integer.valueOf(com.tencent.mm.plugin.appbrand.a.mr(str).dDB.dBr + 1), Integer.valueOf(i), "", "", Long.valueOf(dPI[i2])});
    }
}
