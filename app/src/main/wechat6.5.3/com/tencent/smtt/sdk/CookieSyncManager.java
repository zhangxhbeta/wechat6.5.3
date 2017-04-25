package com.tencent.smtt.sdk;

import android.content.Context;
import java.lang.reflect.Field;

public class CookieSyncManager {
    private static android.webkit.CookieSyncManager pur;
    private static CookieSyncManager pus;
    private static boolean put = false;

    private CookieSyncManager(Context context) {
        y bNJ = y.bNJ();
        if (bNJ != null && bNJ.bNK()) {
            bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[]{Context.class}, context);
            put = true;
        }
    }

    public static synchronized CookieSyncManager createInstance(Context context) {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            pur = android.webkit.CookieSyncManager.createInstance(context);
            if (pus == null || !put) {
                pus = new CookieSyncManager(context.getApplicationContext());
            }
            cookieSyncManager = pus;
        }
        return cookieSyncManager;
    }

    public static synchronized CookieSyncManager getInstance() {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            if (pus == null) {
                throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
            }
            cookieSyncManager = pus;
        }
        return cookieSyncManager;
    }

    public void startSync() {
        y bNJ = y.bNJ();
        if (bNJ == null || !bNJ.bNK()) {
            pur.startSync();
            try {
                Field declaredField = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
                declaredField.setAccessible(true);
                ((Thread) declaredField.get(pur)).setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
                return;
            } catch (Exception e) {
                return;
            }
        }
        bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
    }

    public void stopSync() {
        y bNJ = y.bNJ();
        if (bNJ == null || !bNJ.bNK()) {
            pur.stopSync();
        } else {
            bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
        }
    }

    public void sync() {
        y bNJ = y.bNJ();
        if (bNJ == null || !bNJ.bNK()) {
            pur.sync();
        } else {
            bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
        }
    }
}
