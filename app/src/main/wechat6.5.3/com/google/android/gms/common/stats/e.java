package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.e.i;

public final class e {
    private final long aqO;
    private final int aqP;
    private final i<String, Long> aqQ;

    public e() {
        this.aqO = 60000;
        this.aqP = 10;
        this.aqQ = new i(10);
    }

    public e(long j) {
        this.aqO = j;
        this.aqP = 1024;
        this.aqQ = new i();
    }

    public final Long Y(String str) {
        Long l;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.aqO;
        synchronized (this) {
            long j2 = j;
            while (this.aqQ.size() >= this.aqP) {
                for (int size = this.aqQ.size() - 1; size >= 0; size--) {
                    if (elapsedRealtime - ((Long) this.aqQ.valueAt(size)).longValue() > j2) {
                        this.aqQ.removeAt(size);
                    }
                }
                j = j2 / 2;
                new StringBuilder("The max capacity ").append(this.aqP).append(" is not enough. Current durationThreshold is: ").append(j);
                j2 = j;
            }
            l = (Long) this.aqQ.put(str, Long.valueOf(elapsedRealtime));
        }
        return l;
    }

    public final boolean Z(String str) {
        boolean z;
        synchronized (this) {
            z = this.aqQ.remove(str) != null;
        }
        return z;
    }
}
