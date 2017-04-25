package com.tencent.mm.ui.c.a;

import android.view.animation.DecelerateInterpolator;

public final class c extends DecelerateInterpolator {
    public final float getInterpolation(float f) {
        if (((double) f) <= 0.5d) {
            return super.getInterpolation(2.0f * f);
        }
        return 1.0f;
    }
}
