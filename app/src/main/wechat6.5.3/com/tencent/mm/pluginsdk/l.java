package com.tencent.mm.pluginsdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.d.d;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class l {
    private static final AtomicInteger lyn = new AtomicInteger(0);

    public static boolean isLocked() {
        return lyn.get() > 0;
    }

    public static void lock() {
        if (aa.btq()) {
            lyn.incrementAndGet();
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_LOCK_TOOLS_PROCESS");
        aa.getContext().sendBroadcast(intent);
    }

    public static void unlock() {
        if (aa.getContext() != null) {
            ActivityManager activityManager = (ActivityManager) aa.getContext().getSystemService("activity");
            if (activityManager != null) {
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (!be.bP(runningAppProcesses)) {
                    Object obj;
                    for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if ("com.tencent.mm:tools".equals(runningAppProcessInfo.processName)) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        return;
                    }
                    if (aa.btq()) {
                        lyn.decrementAndGet();
                        return;
                    }
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                    intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_UNLOCK_TOOLS_PROCESS");
                    aa.getContext().sendBroadcast(intent);
                }
            }
        }
    }
}
