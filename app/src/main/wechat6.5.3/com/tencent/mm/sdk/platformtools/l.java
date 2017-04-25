package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import java.util.List;

public final class l {
    private static BroadcastReceiver fWx = null;
    private static int nid = 0;
    private static int nie = -1;

    public static boolean dG(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
        } catch (Throwable e) {
            v.e("MicroMsg.GreenManUtil", "isScreenOn ERROR use isScreenOn e:%s", be.e(e));
            return false;
        }
    }

    public static synchronized boolean dH(Context context) {
        boolean z = false;
        synchronized (l.class) {
            if (fWx == null) {
                fWx = new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        if (intent != null) {
                            try {
                                l.nie = intent.getIntExtra("status", -1);
                                l.nid = intent.getIntExtra("plugged", 0);
                            } catch (Throwable th) {
                            }
                            v.i("MicroMsg.GreenManUtil", "isCharging BroadcastReceiver thread:%d status:%d plugged:%d", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(l.nie), Integer.valueOf(l.nid));
                        }
                    }
                };
                try {
                    Intent registerReceiver = context.registerReceiver(fWx, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    nie = registerReceiver.getIntExtra("status", -1);
                    nid = registerReceiver.getIntExtra("plugged", 0);
                } catch (Throwable th) {
                }
            }
            if (nie == 2 || nid == 1 || nid == 2 || (VERSION.SDK_INT >= 17 && nid == 4)) {
                z = true;
            }
        }
        return z;
    }

    public static boolean dI(Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.startsWith("com.tencent.mm")) {
                return true;
            }
        }
        return false;
    }
}
