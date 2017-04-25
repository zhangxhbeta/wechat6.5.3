package com.google.android.gms.analytics.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.common.internal.w;

public final class ag extends o {
    boolean ahZ;
    boolean aia;
    private AlarmManager aib = ((AlarmManager) this.afY.mContext.getSystemService("alarm"));

    protected ag(q qVar) {
        super(qVar);
    }

    private PendingIntent iQ() {
        Intent intent = new Intent(this.afY.mContext, AnalyticsReceiver.class);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        return PendingIntent.getBroadcast(this.afY.mContext, 0, intent, 0);
    }

    public final void cancel() {
        hX();
        this.aia = false;
        this.aib.cancel(iQ());
    }

    protected final void hm() {
        try {
            this.aib.cancel(iQ());
            if (ac.iF() > 0) {
                ActivityInfo receiverInfo = this.afY.mContext.getPackageManager().getReceiverInfo(new ComponentName(this.afY.mContext, AnalyticsReceiver.class), 2);
                if (receiverInfo != null && receiverInfo.enabled) {
                    C("Receiver registered. Using alarm for local dispatch.");
                    this.ahZ = true;
                }
            }
        } catch (NameNotFoundException e) {
        }
    }

    public final void iP() {
        hX();
        w.a(this.ahZ, "Receiver not registered");
        long iF = ac.iF();
        if (iF > 0) {
            cancel();
            long elapsedRealtime = this.afY.agn.elapsedRealtime() + iF;
            this.aia = true;
            this.aib.setInexactRepeating(2, elapsedRealtime, 0, iQ());
        }
    }
}
