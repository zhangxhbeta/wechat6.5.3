package com.google.android.gms.common;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.c.t;
import com.google.android.gms.c.z;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.o;
import com.tencent.mmdb.FileUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e {
    private static final Object afg = new Object();
    @Deprecated
    public static final int akq = 7887000;
    public static boolean aks = false;
    public static boolean akt = false;
    private static int aku = -1;
    private static String akv = null;
    private static Integer akw = null;
    static final AtomicBoolean akx = new AtomicBoolean();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(int r10, android.app.Activity r11, android.support.v4.app.Fragment r12, android.content.DialogInterface.OnCancelListener r13) {
        /*
        r9 = 3;
        r8 = 2;
        r4 = 0;
        r2 = 1;
        r3 = 0;
        if (r10 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r4;
    L_0x0008:
        if (r0 != 0) goto L_0x01b0;
    L_0x000a:
        return r3;
    L_0x000b:
        r0 = com.google.android.gms.c.t.I(r11);
        if (r0 == 0) goto L_0x0015;
    L_0x0011:
        if (r10 != r8) goto L_0x0015;
    L_0x0013:
        r10 = 42;
    L_0x0015:
        r0 = 14;
        r0 = com.google.android.gms.c.z.bR(r0);
        if (r0 == 0) goto L_0x01e7;
    L_0x001d:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r1 = r11.getTheme();
        r5 = 16843529; // 0x1010309 float:2.3695736E-38 double:8.321809E-317;
        r1.resolveAttribute(r5, r0, r2);
        r1 = r11.getResources();
        r0 = r0.resourceId;
        r0 = r1.getResourceEntryName(r0);
        r1 = "Theme.Dialog.Alert";
        r0 = r1.equals(r0);
        if (r0 == 0) goto L_0x01e7;
    L_0x003f:
        r0 = new android.app.AlertDialog$Builder;
        r1 = 5;
        r0.<init>(r11, r1);
    L_0x0045:
        if (r0 != 0) goto L_0x004c;
    L_0x0047:
        r0 = new android.app.AlertDialog$Builder;
        r0.<init>(r11);
    L_0x004c:
        r5 = z(r11);
        r6 = r11.getResources();
        switch(r10) {
            case 1: goto L_0x0095;
            case 2: goto L_0x0101;
            case 3: goto L_0x00e9;
            case 5: goto L_0x012d;
            case 7: goto L_0x0125;
            case 9: goto L_0x0119;
            case 16: goto L_0x0135;
            case 17: goto L_0x0141;
            case 18: goto L_0x00f5;
            case 42: goto L_0x010d;
            default: goto L_0x0057;
        };
    L_0x0057:
        r1 = com.google.android.gms.R.string.common_google_play_services_unknown_issue;
        r1 = r6.getString(r1);
    L_0x005d:
        r0.setMessage(r1);
        if (r13 == 0) goto L_0x0065;
    L_0x0062:
        r0.setOnCancelListener(r13);
    L_0x0065:
        r5 = bE(r10);
        if (r12 != 0) goto L_0x0149;
    L_0x006b:
        r1 = new com.google.android.gms.common.internal.i;
        r1.<init>(r11, r5, r8);
    L_0x0070:
        r5 = r11.getResources();
        switch(r10) {
            case 1: goto L_0x0150;
            case 2: goto L_0x0160;
            case 3: goto L_0x0158;
            case 42: goto L_0x0160;
            default: goto L_0x0077;
        };
    L_0x0077:
        r6 = 17039370; // 0x104000a float:2.42446E-38 double:8.4185673E-317;
        r5 = r5.getString(r6);
    L_0x007e:
        if (r5 == 0) goto L_0x0083;
    L_0x0080:
        r0.setPositiveButton(r5, r1);
    L_0x0083:
        r1 = r11.getResources();
        switch(r10) {
            case 1: goto L_0x0168;
            case 2: goto L_0x0180;
            case 3: goto L_0x0170;
            case 4: goto L_0x008a;
            case 5: goto L_0x01a0;
            case 6: goto L_0x008a;
            case 7: goto L_0x0198;
            case 8: goto L_0x008a;
            case 9: goto L_0x0190;
            case 10: goto L_0x008a;
            case 11: goto L_0x008a;
            case 16: goto L_0x008a;
            case 17: goto L_0x01a8;
            case 18: goto L_0x0178;
            case 42: goto L_0x0188;
            default: goto L_0x008a;
        };
    L_0x008a:
        if (r4 == 0) goto L_0x008f;
    L_0x008c:
        r0.setTitle(r4);
    L_0x008f:
        r0 = r0.create();
        goto L_0x0008;
    L_0x0095:
        if (r6 == 0) goto L_0x00db;
    L_0x0097:
        r1 = r6.getConfiguration();
        r1 = r1.screenLayout;
        r1 = r1 & 15;
        if (r1 <= r9) goto L_0x00d5;
    L_0x00a1:
        r1 = r2;
    L_0x00a2:
        r7 = 11;
        r7 = com.google.android.gms.c.z.bR(r7);
        if (r7 == 0) goto L_0x00ac;
    L_0x00aa:
        if (r1 != 0) goto L_0x00c7;
    L_0x00ac:
        r1 = r6.getConfiguration();
        r7 = 13;
        r7 = com.google.android.gms.c.z.bR(r7);
        if (r7 == 0) goto L_0x00d9;
    L_0x00b8:
        r7 = r1.screenLayout;
        r7 = r7 & 15;
        if (r7 > r9) goto L_0x00d7;
    L_0x00be:
        r1 = r1.smallestScreenWidthDp;
        r7 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        if (r1 < r7) goto L_0x00d7;
    L_0x00c4:
        r1 = r2;
    L_0x00c5:
        if (r1 == 0) goto L_0x00db;
    L_0x00c7:
        r1 = r2;
    L_0x00c8:
        if (r1 == 0) goto L_0x00dd;
    L_0x00ca:
        r1 = com.google.android.gms.R.string.common_google_play_services_install_text_tablet;
        r7 = new java.lang.Object[r2];
        r7[r3] = r5;
        r1 = r6.getString(r1, r7);
        goto L_0x005d;
    L_0x00d5:
        r1 = r3;
        goto L_0x00a2;
    L_0x00d7:
        r1 = r3;
        goto L_0x00c5;
    L_0x00d9:
        r1 = r3;
        goto L_0x00c5;
    L_0x00db:
        r1 = r3;
        goto L_0x00c8;
    L_0x00dd:
        r1 = com.google.android.gms.R.string.common_google_play_services_install_text_phone;
        r7 = new java.lang.Object[r2];
        r7[r3] = r5;
        r1 = r6.getString(r1, r7);
        goto L_0x005d;
    L_0x00e9:
        r1 = com.google.android.gms.R.string.common_google_play_services_enable_text;
        r7 = new java.lang.Object[r2];
        r7[r3] = r5;
        r1 = r6.getString(r1, r7);
        goto L_0x005d;
    L_0x00f5:
        r1 = com.google.android.gms.R.string.common_google_play_services_updating_text;
        r7 = new java.lang.Object[r2];
        r7[r3] = r5;
        r1 = r6.getString(r1, r7);
        goto L_0x005d;
    L_0x0101:
        r1 = com.google.android.gms.R.string.common_google_play_services_update_text;
        r7 = new java.lang.Object[r2];
        r7[r3] = r5;
        r1 = r6.getString(r1, r7);
        goto L_0x005d;
    L_0x010d:
        r1 = com.google.android.gms.R.string.common_android_wear_update_text;
        r7 = new java.lang.Object[r2];
        r7[r3] = r5;
        r1 = r6.getString(r1, r7);
        goto L_0x005d;
    L_0x0119:
        r1 = com.google.android.gms.R.string.common_google_play_services_unsupported_text;
        r7 = new java.lang.Object[r2];
        r7[r3] = r5;
        r1 = r6.getString(r1, r7);
        goto L_0x005d;
    L_0x0125:
        r1 = com.google.android.gms.R.string.common_google_play_services_network_error_text;
        r1 = r6.getString(r1);
        goto L_0x005d;
    L_0x012d:
        r1 = com.google.android.gms.R.string.common_google_play_services_invalid_account_text;
        r1 = r6.getString(r1);
        goto L_0x005d;
    L_0x0135:
        r1 = com.google.android.gms.R.string.common_google_play_services_api_unavailable_text;
        r7 = new java.lang.Object[r2];
        r7[r3] = r5;
        r1 = r6.getString(r1, r7);
        goto L_0x005d;
    L_0x0141:
        r1 = com.google.android.gms.R.string.common_google_play_services_sign_in_failed_text;
        r1 = r6.getString(r1);
        goto L_0x005d;
    L_0x0149:
        r1 = new com.google.android.gms.common.internal.i;
        r1.<init>(r12, r5, r8);
        goto L_0x0070;
    L_0x0150:
        r6 = com.google.android.gms.R.string.common_google_play_services_install_button;
        r5 = r5.getString(r6);
        goto L_0x007e;
    L_0x0158:
        r6 = com.google.android.gms.R.string.common_google_play_services_enable_button;
        r5 = r5.getString(r6);
        goto L_0x007e;
    L_0x0160:
        r6 = com.google.android.gms.R.string.common_google_play_services_update_button;
        r5 = r5.getString(r6);
        goto L_0x007e;
    L_0x0168:
        r4 = com.google.android.gms.R.string.common_google_play_services_install_title;
        r4 = r1.getString(r4);
        goto L_0x008a;
    L_0x0170:
        r4 = com.google.android.gms.R.string.common_google_play_services_enable_title;
        r4 = r1.getString(r4);
        goto L_0x008a;
    L_0x0178:
        r4 = com.google.android.gms.R.string.common_google_play_services_updating_title;
        r4 = r1.getString(r4);
        goto L_0x008a;
    L_0x0180:
        r4 = com.google.android.gms.R.string.common_google_play_services_update_title;
        r4 = r1.getString(r4);
        goto L_0x008a;
    L_0x0188:
        r4 = com.google.android.gms.R.string.common_android_wear_update_title;
        r4 = r1.getString(r4);
        goto L_0x008a;
    L_0x0190:
        r4 = com.google.android.gms.R.string.common_google_play_services_unsupported_title;
        r4 = r1.getString(r4);
        goto L_0x008a;
    L_0x0198:
        r4 = com.google.android.gms.R.string.common_google_play_services_network_error_title;
        r4 = r1.getString(r4);
        goto L_0x008a;
    L_0x01a0:
        r4 = com.google.android.gms.R.string.common_google_play_services_invalid_account_title;
        r4 = r1.getString(r4);
        goto L_0x008a;
    L_0x01a8:
        r4 = com.google.android.gms.R.string.common_google_play_services_sign_in_failed_title;
        r4 = r1.getString(r4);
        goto L_0x008a;
    L_0x01b0:
        r1 = r11 instanceof android.support.v4.app.FragmentActivity;
        if (r1 == 0) goto L_0x01c7;
    L_0x01b4:
        r11 = (android.support.v4.app.FragmentActivity) r11;
        r1 = r11.aS();
        r0 = com.google.android.gms.common.f.b(r0, r13);
        r3 = "GooglePlayServicesErrorDialog";
        r0.a(r1, r3);
    L_0x01c4:
        r3 = r2;
        goto L_0x000a;
    L_0x01c7:
        r1 = 11;
        r1 = com.google.android.gms.c.z.bR(r1);
        if (r1 == 0) goto L_0x01de;
    L_0x01cf:
        r1 = r11.getFragmentManager();
        r0 = com.google.android.gms.common.a.a(r0, r13);
        r3 = "GooglePlayServicesErrorDialog";
        r0.show(r1, r3);
        goto L_0x01c4;
    L_0x01de:
        r0 = new java.lang.RuntimeException;
        r1 = "This Activity does not support Fragments.";
        r0.<init>(r1);
        throw r0;
    L_0x01e7:
        r0 = r4;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.e.a(int, android.app.Activity, android.support.v4.app.Fragment, android.content.DialogInterface$OnCancelListener):boolean");
    }

    public static boolean a(Context context, int i, String str) {
        if (z.bR(19)) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(PackageManager packageManager) {
        synchronized (afg) {
            if (aku == -1) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
                    k.kx();
                    if (k.a(packageInfo, j.aqW[1]) != null) {
                        aku = 1;
                    } else {
                        aku = 0;
                    }
                } catch (NameNotFoundException e) {
                    aku = 0;
                }
            }
        }
        return aku != 0;
    }

    public static boolean b(PackageManager packageManager) {
        if (!a(packageManager)) {
            if (aks ? akt : "user".equals(Build.TYPE)) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public static Intent bE(int i) {
        switch (i) {
            case 1:
            case 2:
                return o.T("com.google.android.gms");
            case 3:
                return o.S("com.google.android.gms");
            case 42:
                return o.ka();
            default:
                return null;
        }
    }

    @Deprecated
    public static boolean bF(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    private static boolean g(Context context, String str) {
        if (z.bR(21)) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        try {
            if (context.getPackageManager().getApplicationInfo(str, 8192).enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    @Deprecated
    public static boolean k(Context context, int i) {
        return i == 18 ? true : i == 1 ? g(context, "com.google.android.gms") : false;
    }

    public static boolean l(Context context, int i) {
        if (a(context, i, "com.google.android.gms")) {
            if (k.kx().a(context.getPackageManager(), "com.google.android.gms")) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static int v(Context context) {
        if (f.aob) {
            return 0;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            Integer num;
            synchronized (afg) {
                if (akv == null) {
                    akv = context.getPackageName();
                    try {
                        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), FileUtils.S_IWUSR).metaData;
                        if (bundle != null) {
                            akw = Integer.valueOf(bundle.getInt("com.google.android.gms.version"));
                        } else {
                            akw = null;
                        }
                    } catch (Throwable e) {
                        Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
                    }
                } else if (!akv.equals(context.getPackageName())) {
                    throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + akv + "' and this call used package '" + context.getPackageName() + "'.");
                }
                num = akw;
            }
            if (num == null) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (num.intValue() != akq) {
                throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + akq + " but found " + num + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
            k.kx();
            if (!t.bQ(packageInfo.versionCode) && !t.I(context)) {
                try {
                    if (k.a(packageManager.getPackageInfo("com.android.vending", 64), aw.ara) == null) {
                        return 9;
                    }
                    if (k.a(packageInfo, k.a(packageManager.getPackageInfo("com.android.vending", 64), aw.ara)) == null) {
                        return 9;
                    }
                } catch (NameNotFoundException e2) {
                    if (!g(context, "com.android.vending")) {
                        return 9;
                    }
                    if (k.a(packageInfo, aw.ara) == null) {
                        return 9;
                    }
                }
            } else if (k.a(packageInfo, aw.ara) == null) {
                return 9;
            }
            if (t.bP(packageInfo.versionCode) < t.bP(akq)) {
                new StringBuilder("Google Play services out of date.  Requires ").append(akq).append(" but found ").append(packageInfo.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (NameNotFoundException e3) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e4) {
            return 1;
        }
    }

    @Deprecated
    public static void w(Context context) {
        if (!akx.getAndSet(true)) {
            try {
                ((NotificationManager) context.getSystemService("notification")).cancel(10436);
            } catch (SecurityException e) {
            }
        }
    }

    @Deprecated
    public static void x(Context context) {
        int v = v(context);
        if (v != 0) {
            Intent bE = bE(v);
            if (bE == null) {
                throw new c(v);
            }
            throw new d(v, "Google Play Services not available", bE);
        }
    }

    public static Context y(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    private static String z(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo applicationInfo;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }
}
