package com.tencent.recovery;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.recovery.a.b;
import com.tencent.recovery.model.RecoveryExceptionItem;
import com.tencent.recovery.model.RecoveryHandleInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class d {
    private static final String TAG = (a.ptH + "Recovery.RecoveryLogic");
    public static Field ptT = null;
    private static String ptU;

    public static boolean a(Context context, b bVar, ArrayList<RecoveryExceptionItem> arrayList) {
        if (bVar.puc == null) {
            com.tencent.recovery.c.b.i(TAG, "startRecoveryProcess not set handle service", new Object[0]);
            return false;
        } else if (bm(context, bVar.puc)) {
            com.tencent.recovery.c.b.i(TAG, "already run handle service %s", bVar.processName);
            return false;
        } else {
            com.tencent.recovery.c.b.i(TAG, "startRecoveryProcess %s", bVar.processName);
            Parcelable recoveryHandleInfo = new RecoveryHandleInfo();
            recoveryHandleInfo.processName = bVar.processName;
            recoveryHandleInfo.puk = Process.myPid();
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                recoveryHandleInfo.versionCode = packageInfo.versionCode;
                recoveryHandleInfo.versionName = packageInfo.versionName;
            } catch (Exception e) {
            }
            recoveryHandleInfo.pul = arrayList;
            recoveryHandleInfo.pud = bVar.pud;
            Intent intent = new Intent();
            intent.setClassName(context, bVar.puc);
            intent.putExtra("KeyRecoveryTransformInfo", recoveryHandleInfo);
            context.startService(intent);
            return true;
        }
    }

    public static boolean bl(Context context, String str) {
        if (ptT == null) {
            try {
                ptT = RunningAppProcessInfo.class.getDeclaredField("processState");
            } catch (Exception e) {
            }
        }
        if (ptT == null) {
            return false;
        }
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
            com.tencent.recovery.c.b.i(TAG, "can not get running app process", new Object[0]);
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.importance == 100 && runningAppProcessInfo.importanceReasonCode == 0) {
                Integer valueOf;
                try {
                    valueOf = Integer.valueOf(ptT.getInt(runningAppProcessInfo));
                } catch (Exception e2) {
                    valueOf = null;
                }
                if (valueOf != null && valueOf.intValue() == 2) {
                    break;
                }
            }
        }
        RunningAppProcessInfo runningAppProcessInfo2 = null;
        if (runningAppProcessInfo2 != null) {
            com.tencent.recovery.c.b.i(TAG, "%s %s", str, runningAppProcessInfo2.processName);
            return str.equals(runningAppProcessInfo2.processName);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (RunningAppProcessInfo runningAppProcessInfo22 : runningAppProcesses) {
            if (runningAppProcessInfo22 != null) {
                stringBuffer.append(runningAppProcessInfo22.processName + ":" + runningAppProcessInfo22.importance + " ");
            }
        }
        com.tencent.recovery.c.b.i(TAG, "foregroundInfo is null %s %s", Integer.valueOf(runningAppProcesses.size()), stringBuffer.toString());
        return false;
    }

    public static boolean bm(Context context, String str) {
        Object obj;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (ptU != null) {
            obj = ptU;
        } else {
            obj = bn(context, str);
            if (obj == null) {
                obj = null;
            } else {
                ptU = obj;
            }
        }
        if (obj == null) {
            return false;
        }
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(obj)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        } catch (Error e2) {
            return false;
        }
    }

    private static String bn(Context context, String str) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context, str), 0).processName;
        } catch (NameNotFoundException e) {
            return null;
        }
    }
}
