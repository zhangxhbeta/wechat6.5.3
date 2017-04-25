package com.tencent.mm.au;

import android.content.Context;

public final class a {
    public static float au(long j) {
        float f = 1.0f;
        float f2 = ((float) j) / 1000.0f;
        if (f2 >= 1.0f) {
            f = f2;
        }
        return ((float) Math.round(f * 10.0f)) / 10.0f;
    }

    public static CharSequence s(Context context, int i) {
        if (i <= 0) {
            return context.getString(2131232727, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
        }
        int i2 = i % 60;
        return context.getString(2131232727, new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i2)});
    }
}
