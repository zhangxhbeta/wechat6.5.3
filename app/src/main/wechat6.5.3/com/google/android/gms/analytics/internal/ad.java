package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.b;

final class ad implements b {
    private int agr = 2;
    private boolean ahT;

    ad() {
    }

    public final int getLogLevel() {
        return this.agr;
    }

    public final void setLogLevel(int i) {
        this.agr = i;
        if (!this.ahT) {
            aj.aie.get();
            new StringBuilder("Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.").append((String) aj.aie.get()).append(" DEBUG");
            this.ahT = true;
        }
    }
}
