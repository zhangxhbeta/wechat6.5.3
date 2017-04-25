package com.tencent.pb.common.c;

import android.os.Handler;
import android.os.Looper;

public final class i {
    public static Handler jh = new Handler(Looper.getMainLooper());

    public static void S(Runnable runnable) {
        if ((Looper.getMainLooper().getThread() == Thread.currentThread() ? 1 : null) != null) {
            runnable.run();
        } else {
            jh.post(runnable);
        }
    }
}
