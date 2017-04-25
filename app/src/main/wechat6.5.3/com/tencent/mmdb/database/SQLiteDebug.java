package com.tencent.mmdb.database;

import android.util.Log;
import java.util.ArrayList;

public final class SQLiteDebug {
    public static final int CHILD_THREAD_SLOW_QUERY_THRESHOLD = 500;
    public static final int CHILD_THREAD_SLOW_UPDATE_THRESHOLD = 1000;
    public static final boolean DEBUG_LOG_SLOW_QUERIES;
    public static final boolean DEBUG_SQL_LOG = Log.isLoggable("SQLiteLog", 2);
    public static final boolean DEBUG_SQL_STATEMENTS = Log.isLoggable("SQLiteStatements", 2);
    public static final boolean DEBUG_SQL_TIME = Log.isLoggable("SQLiteTime", 2);
    public static final int MAIN_THREAD_SLOW_ATTACH_DB_THRESHOLD = 1000;
    public static final int MAIN_THREAD_SLOW_PRAGMA_THRESHOLD = 1000;
    public static final int MAIN_THREAD_SLOW_QUERY_THRESHOLD = 300;
    public static final int MAIN_THREAD_SLOW_TRACSATION_THRESHOLD = 2000;
    public static final int MAIN_THREAD_SLOW_UPDATE_THRESHOLD = 500;

    public static class DbStats {
        public String cache;
        public String dbName;
        public long dbSize;
        public int lookaside;
        public long pageSize;

        public DbStats(String str, long j, long j2, int i, int i2, int i3, int i4) {
            this.dbName = str;
            this.pageSize = j2 / 1024;
            this.dbSize = (j * j2) / 1024;
            this.lookaside = i;
            this.cache = i2 + "/" + i3 + "/" + i4;
        }
    }

    public static class PagerStats {
        public ArrayList<DbStats> dbStats;
        public int largestMemAlloc;
        public int memoryUsed;
        public int pageCacheOverflow;
    }

    private static native void nativeGetPagerStats(PagerStats pagerStats);

    static {
        boolean z = true;
        if (getSystemDebuggable() != 1) {
            z = false;
        }
        DEBUG_LOG_SLOW_QUERIES = z;
    }

    private static final int getSystemDebuggable() {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return ((Integer) cls.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(cls, new Object[]{"ro.debuggable", Integer.valueOf(0)})).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    private SQLiteDebug() {
    }

    public static final boolean shouldLogSlowQuery(long j) {
        return j > 300;
    }

    public static PagerStats getDatabaseInfo() {
        PagerStats pagerStats = new PagerStats();
        nativeGetPagerStats(pagerStats);
        pagerStats.dbStats = SQLiteDatabase.getDbStats();
        return pagerStats;
    }

    public static void dump(String[] strArr) {
        boolean z = false;
        for (String equals : strArr) {
            if (equals.equals("-v")) {
                z = true;
            }
        }
        SQLiteDatabase.dumpAll(z);
    }
}
