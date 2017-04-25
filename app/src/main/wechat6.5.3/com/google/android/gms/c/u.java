package com.google.android.gms.c;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import com.google.android.gms.common.internal.f;

public final class u {
    public static boolean h(Context context, String str) {
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & 2097152) != 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean kP() {
        return f.aob && j.isInitialized() && j.kG() == Process.myUid();
    }
}
