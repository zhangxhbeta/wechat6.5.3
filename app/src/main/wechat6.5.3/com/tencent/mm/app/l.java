package com.tencent.mm.app;

import com.tencent.tinker.lib.d.b;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public final class l {
    public static boolean a(StackTraceElement[] stackTraceElementArr) {
        for (StackTraceElement className : stackTraceElementArr) {
            String className2 = className.getClassName();
            if (className2 != null && (className2.contains("de.robv.android.xposed.XposedBridge") || className2.contains("com.zte.heartyservice.SCC.FrameworkBridge"))) {
                return true;
            }
        }
        return false;
    }

    public static void b(Throwable th) {
        if (a(th.getStackTrace())) {
            ApplicationLike tinkerApplicationLike = MMApplicationLike.getTinkerApplicationLike();
            if (tinkerApplicationLike != null && tinkerApplicationLike.getApplication() != null && b.b(tinkerApplicationLike)) {
                int i;
                if ((th instanceof IllegalAccessError) && th.getMessage().contains("Class ref in pre-verified class resolved to unexpected implementation")) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    a.e("TinkerCrashProtect", "have xposed: just clean tinker", new Object[0]);
                    ShareTinkerInternals.gw(tinkerApplicationLike.getApplication());
                    b.d(tinkerApplicationLike);
                    ShareTinkerInternals.gt(tinkerApplicationLike.getApplication());
                }
            }
        }
    }
}
