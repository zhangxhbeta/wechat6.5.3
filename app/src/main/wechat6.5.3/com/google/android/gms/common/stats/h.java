package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.c.u;
import com.google.android.gms.c.z;
import com.google.android.gms.common.stats.c.b;
import java.util.List;

public final class h {
    private static String TAG = "WakeLockTracker";
    private static Integer aqA;
    private static h aqR = new h();
    private static IntentFilter aqS = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static final ComponentName aqy = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");

    public static void a(Context context, String str, int i, String str2, String str3, int i2, List<String> list) {
        if (aqA == null) {
            aqA = Integer.valueOf(getLogLevel());
        }
        if ((aqA.intValue() != d.LOG_LEVEL_OFF ? 1 : null) != null && !TextUtils.isEmpty(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (7 == i || 8 == i || 10 == i || 11 == i) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, aqS);
                int i3 = ((z.bR(20) ? ((PowerManager) context.getSystemService("power")).isInteractive() : ((PowerManager) context.getSystemService("power")).isScreenOn() ? 1 : 0) << 1) | ((((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : null) != null ? 1 : 0);
                String packageName = context.getPackageName();
                registerReceiver = context.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                float f = Float.NaN;
                if (registerReceiver != null) {
                    f = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                try {
                    context.startService(new Intent().setComponent(aqy).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(currentTimeMillis, i, str2, i2, list, str, elapsedRealtime, i3, str3, packageName, f)));
                } catch (Throwable e) {
                    Log.wtf(TAG, e);
                }
            }
        }
    }

    private static int getLogLevel() {
        try {
            return u.kP() ? ((Integer) b.aqC.get()).intValue() : d.LOG_LEVEL_OFF;
        } catch (SecurityException e) {
            return d.LOG_LEVEL_OFF;
        }
    }

    public static h ks() {
        return aqR;
    }
}
