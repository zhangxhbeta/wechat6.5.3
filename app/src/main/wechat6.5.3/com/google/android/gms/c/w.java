package com.google.android.gms.c;

import android.os.SystemClock;

public final class w implements v {
    private static w ayy;

    public static synchronized v kQ() {
        v vVar;
        synchronized (w.class) {
            if (ayy == null) {
                ayy = new w();
            }
            vVar = ayy;
        }
        return vVar;
    }

    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }
}
