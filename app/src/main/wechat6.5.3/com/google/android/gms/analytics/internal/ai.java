package com.google.android.gms.analytics.internal;

import android.os.Build.VERSION;

public final class ai {
    public static int version() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            e.c("Invalid version number", VERSION.SDK);
            return 0;
        }
    }
}
