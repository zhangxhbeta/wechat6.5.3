package com.tencent.mm.ax;

import android.os.Build.VERSION;

public final class a {
    public static int bmo() {
        if (VERSION.SDK_INT < 19) {
            return 2130838802;
        }
        return 2130838803;
    }
}
