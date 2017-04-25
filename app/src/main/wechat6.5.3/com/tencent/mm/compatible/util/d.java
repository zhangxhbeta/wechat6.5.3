package com.tencent.mm.compatible.util;

import android.os.Build.VERSION;

public final class d {
    public static boolean dW(int i) {
        return VERSION.SDK_INT >= i;
    }

    public static boolean dX(int i) {
        return VERSION.SDK_INT < i;
    }

    public static boolean dY(int i) {
        return VERSION.SDK_INT > i;
    }
}
