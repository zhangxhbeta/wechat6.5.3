package com.tencent.mm.pluginsdk.g;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import com.tencent.mm.pluginsdk.g.a.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class b implements a {
    private static b lyN = null;

    public final boolean Q(Activity activity) {
        ComponentName componentName = ((RunningTaskInfo) ((ActivityManager) aa.getContext().getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
        String className = componentName != null ? componentName.getClassName() : "";
        v.d("MicroMsg.WalletGuardFilter", "coveredPage: " + className);
        return className == null || className.equals(activity.getClass().getName()) || !className.contains(aa.bth()) || !(className.contains("plugin.mall") || className.contains("plugin.card") || className.contains("plugin.wallet") || className.contains("plugin.wallet_index") || className.contains("plugin.webview") || className.contains("plugin.offline"));
    }

    public static b bmN() {
        if (lyN == null) {
            lyN = new b();
        }
        return lyN;
    }

    private b() {
    }
}
