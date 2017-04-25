package com.tencent.mm.ui.c.a;

import android.view.animation.CycleInterpolator;

public final class b extends CycleInterpolator {
    public b() {
        super(0.5f);
    }

    public final float getInterpolation(float f) {
        return (float) (1.0d - Math.pow((double) ((2.0f * f) - 1.0f), 2.0d));
    }
}
