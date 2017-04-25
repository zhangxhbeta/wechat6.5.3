package com.c.a.a;

import android.os.SystemClock;

class p {
    final long aKk;
    final long aKl;
    final int what;

    private p(int i, long j, long j2) {
        this.what = i;
        this.aKk = j;
        this.aKl = j2;
    }

    p(int i) {
        this(i, System.currentTimeMillis(), SystemClock.elapsedRealtime());
    }
}
