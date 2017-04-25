package com.tencent.mm.booter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public class TrafficStatsReceiver extends BroadcastReceiver {
    private long bYQ = -1;

    public void onReceive(Context context, Intent intent) {
        v.d("MicroMsg.TrafficStats", "onRecieve");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        bd.update();
        if (this.bYQ >= 0) {
            long j = elapsedRealtime - this.bYQ;
            long buc = bd.buc() + bd.bub();
            long bua = bd.bua() + bd.btZ();
            long bug = bd.bug() + bd.buf();
            long bug2 = bd.bug() + bd.buf();
            v.i("MicroMsg.TrafficStats", "Time: %d ms, System - [Mobile: %d, Wifi: %d, Speed: %.2f], WeChat - [Mobile: %d, Wifi: %d, Speed: %.2f]", Long.valueOf(j), Long.valueOf(buc), Long.valueOf(bua), Double.valueOf(((double) (buc + bua)) / ((double) (j / 1000))), Long.valueOf(bug), Long.valueOf(bug2), Double.valueOf(((double) (bug + bug2)) / ((double) (j / 1000))));
        }
        this.bYQ = elapsedRealtime;
    }

    public static void at(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).setRepeating(3, SystemClock.elapsedRealtime(), 300000, PendingIntent.getBroadcast(context, 1, new Intent("com.tencent.mm.TrafficStatsReceiver"), SQLiteDatabase.CREATE_IF_NECESSARY));
        v.i("MicroMsg.TrafficStats", "Register alarm, interval: %d ms", Long.valueOf(300000));
    }

    public static void au(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 1, new Intent("com.tencent.mm.TrafficStatsReceiver"), SQLiteDatabase.CREATE_IF_NECESSARY));
    }
}
