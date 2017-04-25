package com.tencent.tinker.lib.e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.os.Process;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public final class b extends ShareTinkerInternals {
    private static String pGk = null;

    public static void gi(Context context) {
        String gk = gk(context);
        if (gk != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(gk)) {
                    Process.killProcess(runningAppProcessInfo.pid);
                }
            }
        }
    }

    public static boolean gj(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String gk = gk(context);
        if (gk == null) {
            return false;
        }
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(gk)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            new StringBuilder("isTinkerPatchServiceRunning Exception: ").append(e.toString());
            return false;
        } catch (Error e2) {
            new StringBuilder("isTinkerPatchServiceRunning Error: ").append(e2.toString());
            return false;
        }
    }

    private static String gk(Context context) {
        if (pGk != null) {
            return pGk;
        }
        String b = b(context, TinkerPatchService.class);
        if (b == null) {
            return null;
        }
        pGk = b;
        return b;
    }

    public static boolean gl(Context context) {
        String gx = gx(context);
        String gk = gk(context);
        if (gk == null || gk.length() == 0) {
            return false;
        }
        return gx.equals(gk);
    }

    private static String b(Context context, Class<? extends Service> cls) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 0).processName;
        } catch (Throwable th) {
            return null;
        }
    }
}
