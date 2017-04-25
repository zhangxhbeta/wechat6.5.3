package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.as;
import com.google.android.gms.common.internal.w;

public class CampaignTrackingReceiver extends BroadcastReceiver {
    static Object afg = new Object();
    static as afh;
    static Boolean afi;

    public static boolean r(Context context) {
        w.Z(context);
        if (afi != null) {
            return afi.booleanValue();
        }
        boolean a = k.a(context, CampaignTrackingReceiver.class, true);
        afi = Boolean.valueOf(a);
        return a;
    }

    public Class<? extends CampaignTrackingService> hk() {
        return CampaignTrackingService.class;
    }

    public void onReceive(Context context, Intent intent) {
        f hZ = q.t(context).hZ();
        String stringExtra = intent.getStringExtra("referrer");
        String action = intent.getAction();
        hZ.d("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty(stringExtra)) {
            hZ.F("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        boolean s = CampaignTrackingService.s(context);
        if (!s) {
            hZ.F("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        t(stringExtra);
        if (com.google.android.gms.common.internal.f.aob) {
            hZ.G("Received unexpected installation campaign on package side");
            return;
        }
        Class hk = hk();
        w.Z(hk);
        Intent intent2 = new Intent(context, hk);
        intent2.putExtra("referrer", stringExtra);
        synchronized (afg) {
            context.startService(intent2);
            if (s) {
                try {
                    if (afh == null) {
                        as asVar = new as(context, "Analytics campaign WakeLock");
                        afh = asVar;
                        asVar.ld();
                    }
                    afh.lc();
                } catch (SecurityException e) {
                    hZ.F("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                }
                return;
            }
        }
    }

    public void t(String str) {
    }
}
