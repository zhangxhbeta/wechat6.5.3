package com.tencent.mmdb.database;

import android.os.StatFs;

public final class SQLiteGlobal {
    private static final String TAG = "SQLiteGlobal";
    private static boolean forceOptimization = false;
    private static boolean optimization = false;
    private static int sDefaultPageSize;
    private static final Object sLock = new Object();

    private static native int nativeReleaseMemory();

    private SQLiteGlobal() {
    }

    public static int releaseMemory() {
        return nativeReleaseMemory();
    }

    public static void enableForceOptimization() {
        forceOptimization = true;
    }

    public static void disableForceOptimization() {
        forceOptimization = false;
    }

    public static void enableOptimization() {
        optimization = true;
    }

    public static void disableOptimization() {
        optimization = false;
    }

    public static int getDefaultPageSize() {
        int intValue;
        synchronized (sLock) {
            if (sDefaultPageSize == 0) {
                sDefaultPageSize = new StatFs("/data").getBlockSize();
            }
            int i = sDefaultPageSize;
            try {
                Class cls = Class.forName("android.os.SystemProperties");
                intValue = ((Integer) cls.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(cls, new Object[]{"debug.sqlite.pagesize", Integer.valueOf(i)})).intValue();
            } catch (Exception e) {
                intValue = i;
            }
        }
        return intValue;
    }

    public static String getDefaultJournalMode() {
        return "DELETE";
    }

    public static int getJournalSizeLimit() {
        return 1048576;
    }

    public static String getDefaultSyncMode() {
        return "FULL";
    }

    public static String getWALSyncMode() {
        return "FULL";
    }

    public static int getWALAutoCheckpoint() {
        return 100;
    }

    public static int getWALConnectionPoolSize() {
        return 4;
    }
}
