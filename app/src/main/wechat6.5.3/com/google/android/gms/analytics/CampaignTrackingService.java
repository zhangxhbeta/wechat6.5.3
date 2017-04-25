package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.ac;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.n;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.as;
import com.google.android.gms.common.internal.w;

public class CampaignTrackingService extends Service {
    private static Boolean afj;
    private Handler mHandler;

    public static boolean s(Context context) {
        w.Z(context);
        if (afj != null) {
            return afj.booleanValue();
        }
        boolean a = k.a(context, CampaignTrackingService.class);
        afj = Boolean.valueOf(a);
        return a;
    }

    protected final void a(final f fVar, Handler handler, final int i) {
        handler.post(new Runnable(this) {
            final /* synthetic */ CampaignTrackingService afq;

            public final void run() {
                boolean stopSelfResult = this.afq.stopSelfResult(i);
                if (stopSelfResult) {
                    fVar.d("Install campaign broadcast processed", Boolean.valueOf(stopSelfResult));
                }
            }
        });
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        q.t(this).hZ().C("CampaignTrackingService is starting up");
    }

    public void onDestroy() {
        q.t(this).hZ().C("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, final int i2) {
        try {
            synchronized (CampaignTrackingReceiver.afg) {
                as asVar = CampaignTrackingReceiver.afh;
                if (asVar != null && asVar.azQ.isHeld()) {
                    asVar.release();
                }
            }
        } catch (SecurityException e) {
        }
        q t = q.t(this);
        final f hZ = t.hZ();
        String str = null;
        if (com.google.android.gms.common.internal.f.aob) {
            hZ.G("Unexpected installation campaign (package side)");
        } else {
            str = intent.getStringExtra("referrer");
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            handler = new Handler(getMainLooper());
            this.mHandler = handler;
        }
        if (TextUtils.isEmpty(str)) {
            if (!com.google.android.gms.common.internal.f.aob) {
                hZ.F("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            t.ia().c(new Runnable(this) {
                final /* synthetic */ CampaignTrackingService afq;

                public final void run() {
                    this.afq.a(hZ, handler, i2);
                }
            });
        } else {
            int iD = ac.iD();
            if (str.length() > iD) {
                hZ.c("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(str.length()), Integer.valueOf(iD));
                str = str.substring(0, iD);
            }
            hZ.a("CampaignTrackingService called. startId, campaign", Integer.valueOf(i2), str);
            n ib = t.ib();
            Runnable anonymousClass2 = new Runnable(this) {
                final /* synthetic */ CampaignTrackingService afq;

                public final void run() {
                    this.afq.a(hZ, handler, i2);
                }
            };
            w.i(str, "campaign param can't be empty");
            ib.afY.ia().c(new com.google.android.gms.analytics.internal.m.AnonymousClass2(ib, str, anonymousClass2));
        }
        return 2;
    }
}
