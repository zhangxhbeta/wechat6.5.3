package com.tencent.recovery;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.recovery.b.a;
import com.tencent.recovery.model.RecoveryExceptionItem;

public final class b {
    private static final String TAG = (a.ptH + "Recovery");
    private static Application application;
    private static Context context;
    private static long ptK;
    private static com.tencent.recovery.a.b ptL;
    private static a ptM;
    private static String ptN;
    private static boolean ptO = false;
    private static boolean ptP = false;
    private static int ptQ = 0;
    private static ActivityLifecycleCallbacks ptR = new ActivityLifecycleCallbacks() {
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            if (b.ptL != null && !b.ptP && !b.ptM.hasMessages(3)) {
                b.ptM.removeCallbacksAndMessages(null);
                Editor edit = b.context.getSharedPreferences(b.ptN, 0).edit();
                edit.putBoolean("KeyComponentOnCreateForeground", true);
                edit.putInt("KeyComponentOnCreateExceptionType", 21);
                edit.commit();
                b.ptM.sendEmptyMessageDelayed(3, b.ptL.ptY);
                com.tencent.recovery.c.b.i(b.TAG, "markActivityOnCreated %s %s", b.ptL.processName, Long.valueOf(System.currentTimeMillis() - b.ptK));
            }
        }

        public final void onActivityStarted(Activity activity) {
            b.bMz();
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
            b.bMA();
            if (b.ptQ == 0) {
                com.tencent.recovery.c.b.i(b.TAG, "onActivityStopped: activityForegroundCount is 0", new Object[0]);
                b.yH(12);
            }
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }
    };

    static /* synthetic */ int bMA() {
        int i = ptQ;
        ptQ = i - 1;
        return i;
    }

    static /* synthetic */ int bMz() {
        int i = ptQ;
        ptQ = i + 1;
        return i;
    }

    public static void a(Application application, Context context, com.tencent.recovery.a.b bVar, com.tencent.recovery.d.a aVar) {
        if (bVar != null) {
            try {
                if (bVar.processName != null) {
                    if (aVar == null) {
                        aVar = new com.tencent.recovery.d.a();
                    }
                    ptL = bVar;
                    com.tencent.recovery.c.b.i(TAG, "Recovery.init start ============================== %s", bVar.toString());
                    if (ptM == null) {
                        ptM = new a();
                    }
                    ptK = System.currentTimeMillis();
                    context = context;
                    application = application;
                    if (application != null) {
                        application.registerActivityLifecycleCallbacks(ptR);
                    }
                    ptN = "recovery-" + bVar.processName;
                    SharedPreferences sharedPreferences = context.getSharedPreferences(ptN, 0);
                    int i = sharedPreferences.getInt("KeyVersion", 0);
                    Editor edit = sharedPreferences.edit();
                    if (i != 39858256) {
                        edit.clear();
                        edit.putInt("KeyVersion", 39858256);
                        edit.commit();
                        com.tencent.recovery.c.b.i(TAG, "recovery sp version not equal lastVersion %d currentVersion", Integer.valueOf(i), Integer.valueOf(39858256));
                        edit = sharedPreferences.edit();
                    }
                    c cVar = new c();
                    cVar.f(sharedPreferences);
                    boolean z;
                    RecoveryExceptionItem recoveryExceptionItem;
                    if (sharedPreferences.contains("KeyAppOnCreateExceptionType")) {
                        com.tencent.recovery.c.b.i(TAG, "contains KeyAppOnCreateExceptionType", new Object[0]);
                        z = sharedPreferences.getBoolean("KeyAppOnCreateForeground", false);
                        recoveryExceptionItem = new RecoveryExceptionItem();
                        recoveryExceptionItem.pua = z;
                        recoveryExceptionItem.dyp = 1;
                        recoveryExceptionItem.type = sharedPreferences.getInt("KeyAppOnCreateExceptionType", 21);
                        cVar.b(recoveryExceptionItem);
                        aVar.a(recoveryExceptionItem);
                    } else if (sharedPreferences.contains("KeyComponentOnCreateExceptionType")) {
                        com.tencent.recovery.c.b.i(TAG, "contains KeyComponentOnCreateExceptionType", new Object[0]);
                        z = sharedPreferences.getBoolean("KeyComponentOnCreateForeground", false);
                        recoveryExceptionItem = new RecoveryExceptionItem();
                        recoveryExceptionItem.pua = z;
                        recoveryExceptionItem.dyp = 2;
                        recoveryExceptionItem.type = sharedPreferences.getInt("KeyComponentOnCreateExceptionType", 21);
                        cVar.b(recoveryExceptionItem);
                        aVar.a(recoveryExceptionItem);
                    } else {
                        cVar.clear();
                        if (!sharedPreferences.contains("KeyAppOnCreateNormalType")) {
                            com.tencent.recovery.c.b.i(TAG, "DefaultNormal", new Object[0]);
                            aVar.brQ();
                        } else if (sharedPreferences.contains("KeyComponentOnCreateNormalType")) {
                            com.tencent.recovery.c.b.i(TAG, "contains KeyComponentOnCreateNormalType", new Object[0]);
                            sharedPreferences.getInt("KeyComponentOnCreateNormalType", 10);
                            aVar.brQ();
                        } else {
                            com.tencent.recovery.c.b.i(TAG, "contains KeyAppOnCreateNormalType", new Object[0]);
                            sharedPreferences.getInt("KeyAppOnCreateNormalType", 10);
                            aVar.brQ();
                        }
                    }
                    edit.remove("KeyAppOnCreateForeground");
                    edit.remove("KeyAppOnCreateExceptionType");
                    edit.remove("KeyAppOnCreateNormalType");
                    edit.remove("KeyComponentOnCreateForeground");
                    edit.remove("KeyComponentOnCreateExceptionType");
                    edit.remove("KeyComponentOnCreateNormalType");
                    if (bVar.ptX.a(cVar)) {
                        if (bVar.pub) {
                            if (d.a(context, bVar, cVar.ptS)) {
                                aVar.uS(0);
                            } else {
                                aVar.uS(1);
                            }
                        }
                        cVar.clear();
                    } else {
                        boolean bl = d.bl(context, bVar.processName);
                        com.tencent.recovery.c.b.i(TAG, "isForegroundProcess %s %b", bVar.processName, Boolean.valueOf(bl));
                        edit.putBoolean("KeyAppOnCreateForeground", bl);
                        edit.putBoolean("KeyComponentOnCreateForeground", bl);
                        edit.putInt("KeyAppOnCreateExceptionType", 21);
                    }
                    cVar.a(edit);
                    edit.commit();
                    long currentTimeMillis = System.currentTimeMillis();
                    com.tencent.recovery.c.b.i(TAG, "Recovery.init end  ============================== use time %d", Long.valueOf(currentTimeMillis - ptK));
                    return;
                }
            } catch (Throwable th) {
                return;
            }
        }
        com.tencent.recovery.c.b.i(TAG, "Recovery.init not support process", new Object[0]);
    }

    public static void bMu() {
        if (ptL != null && !ptO) {
            ptO = true;
            com.tencent.recovery.c.b.i(TAG, "markApplicationOnCreateNormal %d", Long.valueOf(System.currentTimeMillis() - ptK));
            Editor edit = context.getSharedPreferences(ptN, 0).edit();
            edit.remove("KeyAppOnCreateExceptionType");
            edit.putInt("KeyAppOnCreateNormalType", 13);
            if (!ptL.pua) {
                edit.putBoolean("KeyComponentOnCreateForeground", false);
                edit.putInt("KeyComponentOnCreateExceptionType", 21);
                ptM.sendEmptyMessageDelayed(2, ptL.ptZ);
            }
            edit.commit();
        }
    }

    private static void destroy() {
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(ptR);
        }
    }

    public static void bMv() {
        if (ptL != null && !ptP) {
            ptP = true;
            com.tencent.recovery.c.b.i(TAG, "Recovery.crash %d", Long.valueOf(System.currentTimeMillis() - ptK));
            Editor edit = context.getSharedPreferences(ptN, 0).edit();
            if (ptO) {
                edit.putInt("KeyComponentOnCreateExceptionType", 22);
            } else {
                edit.putInt("KeyAppOnCreateExceptionType", 22);
            }
            edit.commit();
            destroy();
        }
    }

    public static void bMw() {
        if (ptL != null && !ptP) {
            ptP = true;
            com.tencent.recovery.c.b.i(TAG, "Recovery.anr %d", Long.valueOf(System.currentTimeMillis() - ptK));
            Editor edit = context.getSharedPreferences(ptN, 0).edit();
            if (ptO) {
                edit.putInt("KeyComponentOnCreateExceptionType", 23);
            } else {
                edit.putInt("KeyAppOnCreateExceptionType", 23);
            }
            edit.commit();
            destroy();
        }
    }

    public static void yH(int i) {
        if (ptL != null && !ptP) {
            ptP = true;
            SharedPreferences sharedPreferences = context.getSharedPreferences(ptN, 0);
            com.tencent.recovery.c.b.i(TAG, "Recovery.normal %d %d", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - ptK));
            ptM.removeCallbacksAndMessages(null);
            Editor edit = sharedPreferences.edit();
            edit.remove("KeyComponentOnCreateExceptionType");
            edit.putInt("KeyComponentOnCreateNormalType", i);
            edit.commit();
            destroy();
        }
    }

    public static void a(com.tencent.recovery.c.b.a aVar) {
        com.tencent.recovery.c.b.a(aVar);
    }
}
