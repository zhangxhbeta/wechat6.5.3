package com.tencent.mm.ui;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.aa;

public final class u {
    private static float neH = 0.0f;

    public static float ds(Context context) {
        float f = context.getSharedPreferences(aa.bti(), 0).getFloat("text_size_scale_key", 1.0f);
        neH = f;
        return f;
    }

    public static void c(Context context, float f) {
        Editor edit = context.getSharedPreferences(aa.bti(), 0).edit();
        edit.putFloat("text_size_scale_key", f);
        edit.commit();
        neH = f;
    }
}
