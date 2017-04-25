package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

final class h {
    public static int version() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            new StringBuilder("Invalid version number: ").append(VERSION.SDK);
            m.lL();
            return 0;
        }
    }
}
