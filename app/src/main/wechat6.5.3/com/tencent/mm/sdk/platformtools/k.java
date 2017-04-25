package com.tencent.mm.sdk.platformtools;

import android.os.Build.VERSION;
import android.view.View;

public final class k {
    public static void bw(View view) {
        if (view != null) {
            v.h("MicroMsg.ForceGpuUtil", "setLayerType, view: %s", Integer.valueOf(view.hashCode()));
            if (VERSION.SDK_INT >= 11) {
                m mVar = new m();
                if (view.getLayerType() != 1) {
                    view.setLayerType(1, null);
                }
            }
        }
    }

    public static void h(View view, int i, int i2) {
        if (view != null && VERSION.SDK_INT >= 11) {
            m mVar = new m();
            int i3 = (i >= 2048 || i2 >= 2048) ? 1 : 2;
            if (view.getLayerType() != i3) {
                view.setLayerType(i3, null);
            }
        }
    }
}
