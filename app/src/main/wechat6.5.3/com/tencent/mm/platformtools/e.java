package com.tencent.mm.platformtools;

import android.os.Build.VERSION;
import android.view.View;

public final class e {
    public static void bw(View view) {
        if (view != null && VERSION.SDK_INT >= 11) {
            h hVar = new h();
            if (VERSION.SDK_INT >= 11) {
                view.setLayerType(1, null);
            }
        }
    }
}
