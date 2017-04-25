package com.google.android.gms.common;

import android.content.Context;
import android.content.Intent;

public final class b {
    public static final int akq = e.akq;
    private static final b akr = new b();

    b() {
    }

    public static Intent bD(int i) {
        return e.bE(i);
    }

    public static b iZ() {
        return akr;
    }

    public static boolean k(Context context, int i) {
        return e.k(context, i);
    }

    public static int v(Context context) {
        int v = e.v(context);
        return e.k(context, v) ? 18 : v;
    }

    public static void w(Context context) {
        e.w(context);
    }
}
