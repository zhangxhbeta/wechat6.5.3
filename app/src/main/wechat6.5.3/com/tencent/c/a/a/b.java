package com.tencent.c.a.a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Locale;
import java.util.TimeZone;

final class b {
    static a aOg;
    Integer aOh = null;
    String aOi = null;

    static class a {
        String aOj;
        String aOk;
        DisplayMetrics aOl;
        int aOm;
        String aOn;
        String aOo;
        String aOp;
        String aOq;
        String aOr;
        int aOs;
        String aOt;
        String aOu;
        Context ctx;
        String imsi;
        String model;
        String packageName;
        String timezone;

        private a(Context context) {
            this.aOk = "2.21";
            this.aOm = VERSION.SDK_INT;
            this.model = Build.MODEL;
            this.aOn = Build.MANUFACTURER;
            this.aOo = Locale.getDefault().getLanguage();
            this.aOp = "WX";
            this.aOs = 0;
            this.packageName = null;
            this.ctx = null;
            this.aOt = null;
            this.aOu = null;
            this.ctx = context.getApplicationContext();
            try {
                this.aOj = this.ctx.getPackageManager().getPackageInfo(this.ctx.getPackageName(), 0).versionName;
            } catch (NameNotFoundException e) {
            }
            this.aOl = new DisplayMetrics();
            ((WindowManager) this.ctx.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.aOl);
            if (s.l(context, "android.permission.READ_PHONE_STATE")) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    this.aOq = telephonyManager.getSimOperator();
                    this.imsi = telephonyManager.getSubscriberId();
                }
            }
            this.timezone = TimeZone.getDefault().getID();
            this.aOr = s.aa(this.ctx);
            this.packageName = this.ctx.getPackageName();
            this.aOu = s.nX();
        }
    }

    private static synchronized a Q(Context context) {
        a aVar;
        synchronized (b.class) {
            if (aOg == null) {
                aOg = new a(context.getApplicationContext());
            }
            aVar = aOg;
        }
        return aVar;
    }

    public b(Context context) {
        try {
            Q(context);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                this.aOh = Integer.valueOf(telephonyManager.getNetworkType());
            }
            this.aOi = s.ab(context);
        } catch (Throwable th) {
        }
    }
}
