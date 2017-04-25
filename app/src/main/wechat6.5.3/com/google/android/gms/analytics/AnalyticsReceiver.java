package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.as;
import com.google.android.gms.common.internal.w;

public final class AnalyticsReceiver extends BroadcastReceiver {
    static Object afg = new Object();
    static as afh;
    static Boolean afi;

    public static boolean r(Context context) {
        w.Z(context);
        if (afi != null) {
            return afi.booleanValue();
        }
        boolean a = k.a(context, AnalyticsReceiver.class, false);
        afi = Boolean.valueOf(a);
        return a;
    }

    public final void onReceive(Context context, Intent intent) {
        f hZ = q.t(context).hZ();
        String action = intent.getAction();
        if (com.google.android.gms.common.internal.f.aob) {
            hZ.d("Device AnalyticsReceiver got", action);
        } else {
            hZ.d("Local AnalyticsReceiver got", action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean s = AnalyticsService.s(context);
            Intent intent2 = new Intent(context, AnalyticsService.class);
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (afg) {
                context.startService(intent2);
                if (s) {
                    try {
                        if (afh == null) {
                            as asVar = new as(context, "Analytics WakeLock");
                            afh = asVar;
                            asVar.ld();
                        }
                        afh.lc();
                    } catch (SecurityException e) {
                        hZ.F("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                    return;
                }
            }
        }
    }
}
