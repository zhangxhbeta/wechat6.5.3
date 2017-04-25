package com.google.android.gms.c;

import android.content.Context;
import java.util.regex.Pattern;

public final class t {
    private static Pattern ayx = null;

    public static boolean I(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int bP(int i) {
        return i / 1000;
    }

    public static boolean bQ(int i) {
        return (i % 1000) / 100 == 3;
    }
}
