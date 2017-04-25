package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.DisplayMetrics;

public final class b {
    public static int bv(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return context.getResources().getDimensionPixelSize(2131493014);
        }
        return context.getResources().getDimensionPixelSize(2131493015);
    }
}
