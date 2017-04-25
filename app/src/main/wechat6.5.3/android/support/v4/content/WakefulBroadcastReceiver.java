package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.SparseArray;

public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final SparseArray<WakeLock> tp = new SparseArray();
    private static int tq = 1;

    public static ComponentName a(Context context, Intent intent) {
        synchronized (tp) {
            int i = tq;
            int i2 = tq + 1;
            tq = i2;
            if (i2 <= 0) {
                tq = 1;
            }
            intent.putExtra("android.support.content.wakelockid", i);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(60000);
            tp.put(i, newWakeLock);
            return startService;
        }
    }

    public static boolean b(Intent intent) {
        int intExtra = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (tp) {
            WakeLock wakeLock = (WakeLock) tp.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                tp.remove(intExtra);
                return true;
            }
            return true;
        }
    }
}
