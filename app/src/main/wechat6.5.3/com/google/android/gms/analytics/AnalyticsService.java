package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.analytics.internal.ah;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.as;
import com.google.android.gms.common.internal.w;

public final class AnalyticsService extends Service {
    private static Boolean afj;
    private final Handler mHandler = new Handler();

    public static boolean s(Context context) {
        w.Z(context);
        if (afj != null) {
            return afj.booleanValue();
        }
        boolean a = k.a(context, AnalyticsService.class);
        afj = Boolean.valueOf(a);
        return a;
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }

    public final void onCreate() {
        super.onCreate();
        f hZ = q.t(this).hZ();
        if (com.google.android.gms.common.internal.f.aob) {
            hZ.C("Device AnalyticsService is starting up");
        } else {
            hZ.C("Local AnalyticsService is starting up");
        }
    }

    public final void onDestroy() {
        f hZ = q.t(this).hZ();
        if (com.google.android.gms.common.internal.f.aob) {
            hZ.C("Device AnalyticsService is shutting down");
        } else {
            hZ.C("Local AnalyticsService is shutting down");
        }
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, final int i2) {
        try {
            synchronized (AnalyticsReceiver.afg) {
                as asVar = AnalyticsReceiver.afh;
                if (asVar != null && asVar.azQ.isHeld()) {
                    asVar.release();
                }
            }
        } catch (SecurityException e) {
        }
        final q t = q.t(this);
        final f hZ = t.hZ();
        String action = intent.getAction();
        if (com.google.android.gms.common.internal.f.aob) {
            hZ.a("Device AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        } else {
            hZ.a("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            t.ib().a(new ah(this) {
                final /* synthetic */ AnalyticsService afn;

                public final void hj() {
                    this.afn.mHandler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 afo;

                        {
                            this.afo = r1;
                        }

                        public final void run() {
                            if (!this.afo.afn.stopSelfResult(i2)) {
                                return;
                            }
                            if (com.google.android.gms.common.internal.f.aob) {
                                hZ.C("Device AnalyticsService processed last dispatch request");
                            } else {
                                hZ.C("Local AnalyticsService processed last dispatch request");
                            }
                        }
                    });
                }
            });
        }
        return 2;
    }
}
