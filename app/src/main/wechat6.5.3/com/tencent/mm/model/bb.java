package com.tencent.mm.model;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Process;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import com.tencent.mm.a.g;
import com.tencent.mm.b.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.z;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.NorMsgSource.a;
import com.tencent.mm.model.ba.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class bb {
    private static String[] cuF = new String[]{"/dev/socket/qemud", "/dev/qemu_pipe"};
    private static String[] cuG = new String[]{"goldfish"};
    private static String[] cuH = new String[]{"/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props"};
    static boolean cuI = false;
    static boolean cuJ = false;
    static boolean cuK = false;
    static boolean cuL = false;

    public static String zw() {
        Context context = aa.getContext();
        if (context == null) {
            return null;
        }
        return be.dZ(context);
    }

    public static b zx() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object m;
        NetworkInfo activeNetworkInfo;
        Object extraInfo;
        PackageInfo packageInfo;
        Object obj5;
        int i;
        int i2;
        int i3;
        String rR;
        String rS;
        String rJ;
        String androidId;
        String rV;
        String rO;
        int rX;
        String rL;
        String c;
        int i4;
        Context context;
        String str;
        b bVar;
        byte[] checkSoftType;
        Map rW = p.rW();
        String str2 = (String) rW.get("model name");
        if (str2 == null) {
            obj = p.rP()[0];
        } else {
            String str3 = str2;
        }
        str2 = (String) rW.get("features");
        if (str2 == null) {
            obj2 = (String) rW.get("flags");
        } else {
            String str4 = str2;
        }
        WifiInfo connectionInfo = ((WifiManager) aa.getContext().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo != null) {
            String ssid = connectionInfo.getSSID();
            str2 = connectionInfo.getBSSID();
            obj3 = ssid;
            obj4 = str2;
        } else {
            obj3 = null;
            obj4 = null;
        }
        str2 = be.ma(be.dY(aa.getContext()));
        if (str2.length() > 0) {
            m = g.m(str2.getBytes());
        } else {
            String str5 = str2;
        }
        Object obj6 = SQLiteDatabase.KeyEmpty;
        try {
            activeNetworkInfo = ((ConnectivityManager) aa.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                obj6 = "wifi";
            } else {
                String str6 = activeNetworkInfo.getSubtype();
            }
        } catch (Throwable e) {
            v.e("MicroMsg.NorMsgSource", "getNetTypeStr: %s", be.e(e));
        }
        String ax = p.ax(aa.getContext());
        activeNetworkInfo = ((ConnectivityManager) aa.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            extraInfo = activeNetworkInfo.getExtraInfo();
        } else {
            extraInfo = null;
        }
        int i5 = 0;
        try {
            packageInfo = aa.getContext().getPackageManager().getPackageInfo(aa.getPackageName(), 0);
        } catch (NameNotFoundException e2) {
            packageInfo = null;
            v.w("MicroMsg.NorMsgSource", "app not installed, packageName = " + aa.getPackageName());
        }
        if (packageInfo != null) {
            i5 = packageInfo.versionCode;
        }
        byte[] checkSoftType3 = a.checkSoftType3(aa.getContext());
        Context context2 = aa.getContext();
        if (context2 == null) {
            v.w("MicroMsg.NorMsgSource", "Failed checking mock location: application context not initialized.");
        } else if (Secure.getInt(context2.getContentResolver(), "mock_location", 0) != 0) {
            obj5 = 1;
            i = obj5 == null ? 1 : 0;
            i2 = a.checkMsgLevel() ? 1 : 0;
            i3 = Debug.isDebuggerConnected() ? 1 : 0;
            rR = p.rR();
            rS = p.rS();
            rJ = p.rJ();
            androidId = p.getAndroidId();
            rV = p.rV();
            rO = p.rO();
            rX = p.rX();
            rL = p.rL();
            c = c(checkSoftType3, 0, checkSoftType3.length);
            i4 = (zy() || zz() || zA()) ? 1 : 0;
            context = aa.getContext();
            str = context.getApplicationInfo().sourceDir;
            bVar = new b();
            bVar.ctP = Integer.valueOf(i);
            bVar.ctQ = Integer.valueOf(i2);
            bVar.ctR = Integer.valueOf(i3);
            com.tencent.mm.kernel.g.vx();
            checkSoftType = a.checkSoftType(str, com.tencent.mm.kernel.g.vu().uin);
            bVar.ctS = c(checkSoftType, 0, checkSoftType.length);
            com.tencent.mm.kernel.g.vx();
            checkSoftType = a.checkSoftType2(context, str, com.tencent.mm.kernel.g.vu().uin);
            bVar.ctT = c(checkSoftType, 0, checkSoftType.length);
            bVar.ctU = c;
            bVar.ctV = obj;
            bVar.ctW = rR;
            bVar.ctX = rS;
            bVar.ctY = rJ;
            bVar.ctZ = androidId;
            bVar.cua = rV;
            bVar.cub = rO;
            bVar.cuc = Integer.valueOf(rX);
            bVar.cud = rW.get("hardware");
            bVar.cue = rW.get("revision");
            bVar.cuf = rW.get("serial");
            bVar.cug = rL;
            bVar.cuh = obj2;
            bVar.cui = obj3;
            bVar.cuj = ax;
            bVar.cuk = obj4;
            bVar.cul = extraInfo;
            bVar.cum = aa.getPackageName();
            bVar.cun = z.get("ro.build.fingerprint");
            bVar.cuo = Build.BOARD;
            bVar.cup = Build.BOOTLOADER;
            bVar.cuq = Build.BRAND;
            bVar.cur = Build.DEVICE;
            bVar.cus = Build.HARDWARE;
            bVar.cut = Build.PRODUCT;
            bVar.cuu = Integer.valueOf(i4);
            bVar.cuv = z.get("ro.product.manufacturer");
            bVar.cuw = m;
            bVar.cux = obj6;
            bVar.cuy = e.cnf;
            bVar.cuz = Integer.valueOf(cuJ ? 1 : 0);
            bVar.cuA = Integer.valueOf(cuL ? 1 : 0);
            bVar.cuB = Integer.valueOf(i5);
            bVar.cuC = aa.getContext().getClassLoader().getClass().getName();
            bVar.cuD = aa.getContext().getPackageManager().getApplicationLabel(aa.getContext().getApplicationInfo());
            bVar.cuE = zB();
            return bVar;
        }
        obj5 = null;
        if (obj5 == null) {
        }
        if (a.checkMsgLevel()) {
        }
        if (Debug.isDebuggerConnected()) {
        }
        rR = p.rR();
        rS = p.rS();
        rJ = p.rJ();
        androidId = p.getAndroidId();
        rV = p.rV();
        rO = p.rO();
        rX = p.rX();
        rL = p.rL();
        c = c(checkSoftType3, 0, checkSoftType3.length);
        if (!zy()) {
        }
        context = aa.getContext();
        str = context.getApplicationInfo().sourceDir;
        bVar = new b();
        bVar.ctP = Integer.valueOf(i);
        bVar.ctQ = Integer.valueOf(i2);
        bVar.ctR = Integer.valueOf(i3);
        com.tencent.mm.kernel.g.vx();
        checkSoftType = a.checkSoftType(str, com.tencent.mm.kernel.g.vu().uin);
        bVar.ctS = c(checkSoftType, 0, checkSoftType.length);
        com.tencent.mm.kernel.g.vx();
        checkSoftType = a.checkSoftType2(context, str, com.tencent.mm.kernel.g.vu().uin);
        bVar.ctT = c(checkSoftType, 0, checkSoftType.length);
        bVar.ctU = c;
        bVar.ctV = obj;
        bVar.ctW = rR;
        bVar.ctX = rS;
        bVar.ctY = rJ;
        bVar.ctZ = androidId;
        bVar.cua = rV;
        bVar.cub = rO;
        bVar.cuc = Integer.valueOf(rX);
        bVar.cud = rW.get("hardware");
        bVar.cue = rW.get("revision");
        bVar.cuf = rW.get("serial");
        bVar.cug = rL;
        bVar.cuh = obj2;
        bVar.cui = obj3;
        bVar.cuj = ax;
        bVar.cuk = obj4;
        bVar.cul = extraInfo;
        bVar.cum = aa.getPackageName();
        bVar.cun = z.get("ro.build.fingerprint");
        bVar.cuo = Build.BOARD;
        bVar.cup = Build.BOOTLOADER;
        bVar.cuq = Build.BRAND;
        bVar.cur = Build.DEVICE;
        bVar.cus = Build.HARDWARE;
        bVar.cut = Build.PRODUCT;
        bVar.cuu = Integer.valueOf(i4);
        bVar.cuv = z.get("ro.product.manufacturer");
        bVar.cuw = m;
        bVar.cux = obj6;
        bVar.cuy = e.cnf;
        if (cuJ) {
        }
        bVar.cuz = Integer.valueOf(cuJ ? 1 : 0);
        if (cuL) {
        }
        bVar.cuA = Integer.valueOf(cuL ? 1 : 0);
        bVar.cuB = Integer.valueOf(i5);
        bVar.cuC = aa.getContext().getClassLoader().getClass().getName();
        bVar.cuD = aa.getContext().getPackageManager().getApplicationLabel(aa.getContext().getApplicationInfo());
        bVar.cuE = zB();
        return bVar;
    }

    public static String eN(int i) {
        Object obj;
        PackageInfo packageInfo;
        b zx = zx();
        String str = SQLiteDatabase.KeyEmpty;
        if (com.tencent.mm.kernel.g.uz()) {
            com.tencent.mm.kernel.g.vx();
            str = (String) com.tencent.mm.kernel.g.vw().vf().get(79, SQLiteDatabase.KeyEmpty);
        }
        com.tencent.mm.kernel.g.vA().f(new Runnable() {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r10 = this;
                r9 = 0;
                r0 = com.tencent.mm.kernel.g.uz();
                if (r0 != 0) goto L_0x0008;
            L_0x0007:
                return;
            L_0x0008:
                r0 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0114 }
                r2 = com.tencent.mm.sdk.platformtools.aa.getContext();	 Catch:{ Exception -> 0x0114 }
                r3 = r2.getApplicationInfo();	 Catch:{ Exception -> 0x0114 }
                r3 = r3.sourceDir;	 Catch:{ Exception -> 0x0114 }
                com.tencent.mm.kernel.g.vx();	 Catch:{ Exception -> 0x0114 }
                r4 = com.tencent.mm.kernel.g.vu();	 Catch:{ Exception -> 0x0114 }
                r4 = r4.uin;	 Catch:{ Exception -> 0x0114 }
                r4 = com.tencent.mm.model.NorMsgSource.a.checkSoftType(r3, r4);	 Catch:{ Exception -> 0x0114 }
                com.tencent.mm.kernel.g.vx();	 Catch:{ Exception -> 0x0114 }
                r5 = com.tencent.mm.kernel.g.vu();	 Catch:{ Exception -> 0x0114 }
                r5 = r5.uin;	 Catch:{ Exception -> 0x0114 }
                r2 = com.tencent.mm.model.NorMsgSource.a.checkSoftType2(r2, r3, r5);	 Catch:{ Exception -> 0x0114 }
                r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0114 }
                r6 = r6 - r0;
                r0 = "<k25>%s</k25>";
                r1 = 1;
                r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0114 }
                r3 = 0;
                r5 = 0;
                r8 = r4.length;	 Catch:{ Exception -> 0x0114 }
                r4 = com.tencent.mm.model.bb.c(r4, r5, r8);	 Catch:{ Exception -> 0x0114 }
                r1[r3] = r4;	 Catch:{ Exception -> 0x0114 }
                r1 = java.lang.String.format(r0, r1);	 Catch:{ Exception -> 0x0114 }
                if (r2 == 0) goto L_0x00ad;
            L_0x004a:
                r0 = r2.length;	 Catch:{ Exception -> 0x0114 }
                r3 = 8;
                if (r0 != r3) goto L_0x0122;
            L_0x004f:
                r0 = 0;
                r0 = r2[r0];	 Catch:{ Exception -> 0x0114 }
                r3 = 0;
                r4 = 3;
                r4 = r2[r4];	 Catch:{ Exception -> 0x0114 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0114 }
                r3 = 3;
                r2[r3] = r0;	 Catch:{ Exception -> 0x0114 }
                r0 = 1;
                r0 = r2[r0];	 Catch:{ Exception -> 0x0114 }
                r3 = 1;
                r4 = 2;
                r4 = r2[r4];	 Catch:{ Exception -> 0x0114 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0114 }
                r3 = 2;
                r2[r3] = r0;	 Catch:{ Exception -> 0x0114 }
                r0 = 4;
                r0 = r2[r0];	 Catch:{ Exception -> 0x0114 }
                r3 = 4;
                r4 = 7;
                r4 = r2[r4];	 Catch:{ Exception -> 0x0114 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0114 }
                r3 = 7;
                r2[r3] = r0;	 Catch:{ Exception -> 0x0114 }
                r0 = 5;
                r0 = r2[r0];	 Catch:{ Exception -> 0x0114 }
                r3 = 5;
                r4 = 6;
                r4 = r2[r4];	 Catch:{ Exception -> 0x0114 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0114 }
                r3 = 6;
                r2[r3] = r0;	 Catch:{ Exception -> 0x0114 }
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0114 }
                r0.<init>();	 Catch:{ Exception -> 0x0114 }
                r0 = r0.append(r1);	 Catch:{ Exception -> 0x0114 }
                r1 = "<k28>%s</k28><k29>%s</k29>";
                r3 = 2;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0114 }
                r4 = 0;
                r5 = 0;
                r8 = 4;
                r5 = com.tencent.mm.model.bb.c(r2, r5, r8);	 Catch:{ Exception -> 0x0114 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0114 }
                r4 = 1;
                r5 = 4;
                r8 = 8;
                r2 = com.tencent.mm.model.bb.c(r2, r5, r8);	 Catch:{ Exception -> 0x0114 }
                r3[r4] = r2;	 Catch:{ Exception -> 0x0114 }
                r1 = java.lang.String.format(r1, r3);	 Catch:{ Exception -> 0x0114 }
                r0 = r0.append(r1);	 Catch:{ Exception -> 0x0114 }
                r1 = r0.toString();	 Catch:{ Exception -> 0x0114 }
            L_0x00ad:
                r0 = "mp.weixin.qq.com";
                r0 = java.net.Inet4Address.getByName(r0);	 Catch:{ Exception -> 0x0148 }
                r0 = r0.getHostAddress();	 Catch:{ Exception -> 0x0148 }
                r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0148 }
                r2.<init>();	 Catch:{ Exception -> 0x0148 }
                r2 = r2.append(r1);	 Catch:{ Exception -> 0x0148 }
                r3 = "<k32>%s</k32>";
                r4 = 1;
                r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0148 }
                r5 = 0;
                r0 = com.tencent.mm.sdk.platformtools.be.ma(r0);	 Catch:{ Exception -> 0x0148 }
                r4[r5] = r0;	 Catch:{ Exception -> 0x0148 }
                r0 = java.lang.String.format(r3, r4);	 Catch:{ Exception -> 0x0148 }
                r0 = r2.append(r0);	 Catch:{ Exception -> 0x0148 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0148 }
            L_0x00da:
                r1 = "MicroMsg.NorMsgSource";
                r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0114 }
                r3 = "checkSoftType2 [time: ";
                r2.<init>(r3);	 Catch:{ Exception -> 0x0114 }
                r2 = r2.append(r6);	 Catch:{ Exception -> 0x0114 }
                r3 = ", value: ";
                r2 = r2.append(r3);	 Catch:{ Exception -> 0x0114 }
                r2 = r2.append(r0);	 Catch:{ Exception -> 0x0114 }
                r3 = "]";
                r2 = r2.append(r3);	 Catch:{ Exception -> 0x0114 }
                r2 = r2.toString();	 Catch:{ Exception -> 0x0114 }
                com.tencent.mm.sdk.platformtools.v.i(r1, r2);	 Catch:{ Exception -> 0x0114 }
                com.tencent.mm.kernel.g.vx();	 Catch:{ Exception -> 0x0114 }
                r1 = com.tencent.mm.kernel.g.vw();	 Catch:{ Exception -> 0x0114 }
                r1 = r1.vf();	 Catch:{ Exception -> 0x0114 }
                r2 = 79;
                r1.set(r2, r0);	 Catch:{ Exception -> 0x0114 }
                goto L_0x0007;
            L_0x0114:
                r0 = move-exception;
                r1 = "MicroMsg.NorMsgSource";
                r2 = "Failed checkSoftType2.";
                r3 = new java.lang.Object[r9];
                com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);
                goto L_0x0007;
            L_0x0122:
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0114 }
                r0.<init>();	 Catch:{ Exception -> 0x0114 }
                r0 = r0.append(r1);	 Catch:{ Exception -> 0x0114 }
                r1 = "<k27>%s</k27>";
                r3 = 1;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0114 }
                r4 = 0;
                r5 = 0;
                r8 = r2.length;	 Catch:{ Exception -> 0x0114 }
                r2 = com.tencent.mm.model.bb.c(r2, r5, r8);	 Catch:{ Exception -> 0x0114 }
                r3[r4] = r2;	 Catch:{ Exception -> 0x0114 }
                r1 = java.lang.String.format(r1, r3);	 Catch:{ Exception -> 0x0114 }
                r0 = r0.append(r1);	 Catch:{ Exception -> 0x0114 }
                r1 = r0.toString();	 Catch:{ Exception -> 0x0114 }
                goto L_0x00ad;
            L_0x0148:
                r0 = move-exception;
                r2 = "MicroMsg.NorMsgSource";
                r3 = "exception:%s";
                r4 = 1;
                r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0114 }
                r5 = 0;
                r0 = com.tencent.mm.sdk.platformtools.be.e(r0);	 Catch:{ Exception -> 0x0114 }
                r4[r5] = r0;	 Catch:{ Exception -> 0x0114 }
                com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ Exception -> 0x0114 }
                r0 = r1;
                goto L_0x00da;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.bb.1.run():void");
            }

            public final String toString() {
                return super.toString() + "|checkSoftTypeExtra";
            }
        }, 5000);
        String str2 = SQLiteDatabase.KeyEmpty;
        if (com.tencent.mm.kernel.g.uz()) {
            com.tencent.mm.kernel.g.vx();
            obj = com.tencent.mm.kernel.g.vw().ckb.nxK.nxu ? "1" : "0";
        } else {
            String str3 = str2;
        }
        PackageManager packageManager = aa.getContext().getPackageManager();
        str2 = SQLiteDatabase.KeyEmpty;
        try {
            packageInfo = packageManager.getPackageInfo(aa.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
            v.w("MicroMsg.NorMsgSource", "app not installed, packageName = " + aa.getPackageName());
        }
        if (packageInfo != null) {
            com.tencent.mm.plugin.report.b bVar;
            Object[] objArr;
            try {
                String i2 = c.i(new File(packageInfo.applicationInfo.sourceDir));
                if (be.kS(i2)) {
                    com.tencent.mm.plugin.report.b.itm.a(322, 13, 1, true);
                    bVar = com.tencent.mm.plugin.report.b.itm;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(4013);
                    objArr[1] = String.format("%d|%d", new Object[]{zx.cuB, Integer.valueOf(i)});
                    bVar.h(11098, objArr);
                }
                str2 = i2;
            } catch (Exception e2) {
                v.w("MicroMsg.NorMsgSource", "summertoken getSecurityCode e: " + e2.getMessage());
                com.tencent.mm.plugin.report.b.itm.a(322, 12, 1, true);
                bVar = com.tencent.mm.plugin.report.b.itm;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4012);
                objArr[1] = String.format("%d|%d|%s", new Object[]{zx.cuB, Integer.valueOf(i), r11.getMessage()});
                bVar.h(11098, objArr);
                str2 = "0";
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<softtype>").append(String.format("<lctmoc>%d</lctmoc>", new Object[]{zx.ctP})).append(String.format("<level>%d</level>", new Object[]{zx.ctQ})).append(String.format("<k26>%d</k26>", new Object[]{zx.ctR})).append(String.format("%s", new Object[]{str})).append(String.format("<k1>%s</k1>", new Object[]{zx.ctV})).append(String.format("<k2>%s</k2>", new Object[]{zx.ctW})).append(String.format("<k3>%s</k3>", new Object[]{zx.ctX})).append(String.format("<k4>%s</k4>", new Object[]{zx.ctY})).append(String.format("<k5>%s</k5>", new Object[]{p.rT()})).append(String.format("<k6>%s</k6>", new Object[]{p.rU()})).append(String.format("<k7>%s</k7>", new Object[]{zx.ctZ})).append(String.format("<k8>%s</k8>", new Object[]{zx.cua})).append(String.format("<k9>%s</k9>", new Object[]{zx.cub})).append(String.format("<k10>%s</k10>", new Object[]{zx.cuc})).append(String.format("<k11>%s</k11>", new Object[]{be.ma((String) zx.cud)})).append(String.format("<k12>%s</k12>", new Object[]{be.ma((String) zx.cue)})).append(String.format("<k13>%s</k13>", new Object[]{be.ma((String) zx.cuf)})).append(String.format("<k14>%s</k14>", new Object[]{zx.cug})).append(String.format("<k15>%s</k15>", new Object[]{p.rQ()})).append(String.format("<k16>%s</k16>", new Object[]{be.ma((String) zx.cuh)})).append(String.format("<k18>%s</k18>", new Object[]{zx.ctU})).append(String.format("<k21>%s</k21>", new Object[]{be.ma((String) zx.cui)})).append(String.format("<k22>%s</k22>", new Object[]{be.ma((String) zx.cuj)})).append(String.format("<k24>%s</k24>", new Object[]{be.ma((String) zx.cuk)})).append(String.format("<k30>%s</k30>", new Object[]{be.ma((String) zx.cul)})).append(String.format("<k33>%s</k33>", new Object[]{zx.cum})).append(String.format("<k34>%s</k34>", new Object[]{be.ma((String) zx.cun)})).append(String.format("<k35>%s</k35>", new Object[]{be.ma((String) zx.cuo)})).append(String.format("<k36>%s</k36>", new Object[]{be.ma((String) zx.cup)})).append(String.format("<k37>%s</k37>", new Object[]{be.ma((String) zx.cuq)})).append(String.format("<k38>%s</k38>", new Object[]{be.ma((String) zx.cur)})).append(String.format("<k39>%s</k39>", new Object[]{be.ma((String) zx.cus)})).append(String.format("<k40>%s</k40>", new Object[]{be.ma((String) zx.cut)})).append(String.format("<k41>%d</k41>", new Object[]{zx.cuu})).append(String.format("<k42>%s</k42>", new Object[]{be.ma((String) zx.cuv)})).append(String.format("<k43>%s</k43>", new Object[]{System.getString(aa.getContext().getContentResolver(), "89884a87498ef44f")})).append(String.format("<k44>%s</k44>", new Object[]{new StringBuilder("0").toString()})).append(String.format("<k45>%s</k45>", new Object[]{zx.cuw})).append(String.format("<k46>%s</k46>", new Object[]{obj})).append(String.format("<k47>%s</k47>", new Object[]{zx.cux})).append(String.format("<k48>%s</k48>", new Object[]{zx.ctY})).append(String.format("<k49>%s</k49>", new Object[]{e.cnf})).append(String.format("<k52>%d</k52>", new Object[]{zx.cuz})).append(String.format("<k53>%d</k53>", new Object[]{zx.cuA})).append(String.format("<k57>%d</k57>", new Object[]{zx.cuB})).append(String.format("<k58>%s</k58>", new Object[]{be.ma(str2)})).append(String.format("<k59>%d</k59>", new Object[]{Integer.valueOf(i)})).append("</softtype>");
        return stringBuilder.toString();
    }

    public static boolean checkMsgLevel() {
        return a.checkMsgLevel();
    }

    private static String c(byte[] bArr, int i, int i2) {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[((i2 - i) * 2)];
        int i3 = 0;
        while (i < i2) {
            byte b = bArr[i];
            int i4 = i3 + 1;
            cArr2[i3] = cArr[(b >>> 4) & 15];
            i3 = i4 + 1;
            cArr2[i4] = cArr[b & 15];
            i++;
        }
        return new String(cArr2);
    }

    private static boolean zy() {
        for (String file : cuF) {
            if (new File(file).exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean zz() {
        InputStream fileInputStream;
        String str;
        Throwable th;
        File file = new File("/proc/tty/drivers");
        if (!file.exists() || !file.canRead() || file.length() <= 0) {
            return false;
        }
        byte[] bArr = new byte[((int) file.length())];
        InputStream inputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileInputStream.read(bArr);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                }
            } catch (Exception e2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                str = new String(bArr);
                for (String indexOf : cuG) {
                    if (str.indexOf(indexOf) == -1) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            str = new String(bArr);
            while (r1 < r4) {
                if (str.indexOf(indexOf) == -1) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
        str = new String(bArr);
        while (r1 < r4) {
            if (str.indexOf(indexOf) == -1) {
                return true;
            }
        }
        return false;
    }

    private static boolean zA() {
        for (String file : cuH) {
            if (new File(file).exists()) {
                return true;
            }
        }
        return false;
    }

    public static String c(String str, long j, long j2) {
        ZipFile zipFile;
        Throwable e;
        String str2;
        InputStream inputStream = null;
        try {
            if (str.startsWith("@")) {
                zipFile = new ZipFile(aa.getContext().getApplicationInfo().sourceDir);
                try {
                    inputStream = zipFile.getInputStream(zipFile.getEntry(str.substring(1)));
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.a("MicroMsg.NorMsgSource", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        str2 = SQLiteDatabase.KeyEmpty;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e4) {
                            }
                        }
                        return str2;
                    } catch (Throwable th) {
                        e = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e6) {
                            }
                        }
                        throw e;
                    }
                }
            }
            zipFile = null;
            inputStream = FileOp.openRead(str);
            while (j > 0) {
                j -= inputStream.skip(j);
            }
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[2048];
            while (j2 > 0) {
                int read = inputStream.read(bArr, 0, (int) Math.min(2048, j2));
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
                j2 -= (long) read;
            }
            str2 = be.bn(instance.digest());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                }
            }
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e8) {
                }
            }
        } catch (Exception e9) {
            e = e9;
            zipFile = null;
            v.a("MicroMsg.NorMsgSource", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            str2 = SQLiteDatabase.KeyEmpty;
            if (inputStream != null) {
                inputStream.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
            return str2;
        } catch (Throwable th2) {
            e = th2;
            zipFile = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
            throw e;
        }
        return str2;
    }

    public static long fV(String str) {
        ZipFile zipFile;
        Throwable e;
        Throwable th;
        long j = -1;
        if (!str.startsWith("@")) {
            return FileOp.jP(str);
        }
        try {
            zipFile = new ZipFile(aa.getContext().getApplicationInfo().sourceDir);
            try {
                ZipEntry entry = zipFile.getEntry(str.substring(1));
                if (entry == null) {
                    try {
                        zipFile.close();
                        return j;
                    } catch (IOException e2) {
                        return j;
                    }
                }
                j = entry.getSize();
                try {
                    zipFile.close();
                    return j;
                } catch (IOException e3) {
                    return j;
                }
            } catch (IOException e4) {
                e = e4;
                try {
                    v.a("MicroMsg.NorMsgSource", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (zipFile != null) {
                        return j;
                    }
                    try {
                        zipFile.close();
                        return j;
                    } catch (IOException e5) {
                        return j;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e7) {
            e = e7;
            zipFile = null;
            v.a("MicroMsg.NorMsgSource", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (zipFile != null) {
                return j;
            }
            zipFile.close();
            return j;
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
            if (zipFile != null) {
                zipFile.close();
            }
            throw th;
        }
    }

    public static String zB() {
        Object treeSet = new TreeSet();
        a.checkSoftType4(aa.getContext(), treeSet);
        StringBuilder stringBuilder = new StringBuilder(8192);
        Iterator it = treeSet.iterator();
        treeSet = 1;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (treeSet != null) {
                treeSet = null;
            } else {
                stringBuilder.append(',');
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static String zC() {
        List<PackageInfo> installedPackages = aa.getContext().getPackageManager().getInstalledPackages(0);
        StringBuilder stringBuilder = new StringBuilder(8192);
        for (PackageInfo packageInfo : installedPackages) {
            stringBuilder.append(packageInfo.packageName).append('\n');
        }
        return stringBuilder.toString();
    }

    public static boolean zD() {
        if (cuI) {
            return cuJ;
        }
        long nanoTime = System.nanoTime();
        try {
            cuJ = false;
            cuI = true;
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) aa.getContext().getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals("com.tencent.mm") && runningAppProcessInfo.pid != Process.myPid() && runningAppProcessInfo.uid == Process.myUid()) {
                    cuJ = true;
                    v.i("MicroMsg.NorMsgSource", "Check duplicated app, result: %b, time: %d ns", Boolean.valueOf(cuJ), Long.valueOf(System.nanoTime() - nanoTime));
                    return true;
                }
            }
            v.i("MicroMsg.NorMsgSource", "Check duplicated app, result: %b, time: %d ns", Boolean.valueOf(cuJ), Long.valueOf(System.nanoTime() - nanoTime));
            return false;
        } catch (Throwable th) {
            v.i("MicroMsg.NorMsgSource", "Check duplicated app, result: %b, time: %d ns", Boolean.valueOf(cuJ), Long.valueOf(System.nanoTime() - nanoTime));
        }
    }

    public static boolean zE() {
        if (cuK) {
            return cuL;
        }
        long nanoTime = System.nanoTime();
        try {
            cuL = false;
            cuK = true;
            if (VERSION.SDK_INT < 21) {
                v.i("MicroMsg.NorMsgSource", "Check Qiku shadow instance, result: %b, time: %d ns", Boolean.valueOf(cuL), Long.valueOf(System.nanoTime() - nanoTime));
                return false;
            }
            try {
                Field declaredField = RecentTaskInfo.class.getDeclaredField("instanceId");
                declaredField.setAccessible(true);
                try {
                    List recentTasks = ((ActivityManager) aa.getContext().getSystemService("activity")).getRecentTasks(1, 2);
                    if (recentTasks == null || recentTasks.size() == 0) {
                        v.i("MicroMsg.NorMsgSource", "Check Qiku shadow instance, result: %b, time: %d ns", Boolean.valueOf(cuL), Long.valueOf(System.nanoTime() - nanoTime));
                        return false;
                    }
                    if (declaredField.getInt((RecentTaskInfo) recentTasks.get(0)) > 0) {
                        cuL = true;
                        v.i("MicroMsg.NorMsgSource", "Check Qiku shadow instance, result: %b, time: %d ns", Boolean.valueOf(cuL), Long.valueOf(System.nanoTime() - nanoTime));
                        return true;
                    }
                    v.i("MicroMsg.NorMsgSource", "Check Qiku shadow instance, result: %b, time: %d ns", Boolean.valueOf(cuL), Long.valueOf(System.nanoTime() - nanoTime));
                    return false;
                } catch (IllegalAccessException e) {
                }
            } catch (NoSuchFieldException e2) {
                v.i("MicroMsg.NorMsgSource", "Check Qiku shadow instance, result: %b, time: %d ns", Boolean.valueOf(cuL), Long.valueOf(System.nanoTime() - nanoTime));
                return false;
            }
        } catch (Throwable th) {
            v.i("MicroMsg.NorMsgSource", "Check Qiku shadow instance, result: %b, time: %d ns", Boolean.valueOf(cuL), Long.valueOf(System.nanoTime() - nanoTime));
        }
    }

    public static String d(Object... objArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            for (Object obj : objArr) {
                if (obj instanceof String) {
                    byteArrayOutputStream.write(((String) obj).getBytes());
                } else if (obj instanceof Integer) {
                    int intValue = ((Integer) obj).intValue();
                    for (r0 = 0; r0 < 4; r0++) {
                        byteArrayOutputStream.write(intValue & WebView.NORMAL_MODE_ALPHA);
                        intValue >>= 8;
                    }
                } else if (obj instanceof Long) {
                    long longValue = ((Long) obj).longValue();
                    for (r0 = 0; r0 < 8; r0++) {
                        byteArrayOutputStream.write((int) (255 & longValue));
                        longValue >>= 8;
                    }
                } else if (obj instanceof Boolean) {
                    if (((Boolean) obj).booleanValue()) {
                        r0 = 1;
                    } else {
                        r0 = 0;
                    }
                    byteArrayOutputStream.write(r0);
                } else {
                    v.e("MicroMsg.NorMsgSource", "Invalid object class: %s", obj);
                    return SQLiteDatabase.KeyEmpty;
                }
            }
            return be.bn(MessageDigest.getInstance("MD5").digest(byteArrayOutputStream.toByteArray()));
        } catch (Throwable e) {
            v.a("MicroMsg.NorMsgSource", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return SQLiteDatabase.KeyEmpty;
        }
    }
}
