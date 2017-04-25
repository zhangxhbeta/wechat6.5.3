package com.google.android.gms.analytics.internal;

import com.google.android.gms.c.v;
import com.google.android.gms.common.internal.w;

final class j {
    private final v agn;
    long ago;

    public j(v vVar) {
        w.Z(vVar);
        this.agn = vVar;
    }

    public j(v vVar, long j) {
        w.Z(vVar);
        this.agn = vVar;
        this.ago = j;
    }

    public final boolean f(long j) {
        return this.ago == 0 || this.agn.elapsedRealtime() - this.ago > j;
    }

    public final void start() {
        this.ago = this.agn.elapsedRealtime();
    }
}
