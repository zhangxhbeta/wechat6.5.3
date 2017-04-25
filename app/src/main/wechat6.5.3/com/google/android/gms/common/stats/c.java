package com.google.android.gms.common.stats;

import com.google.android.gms.c.j;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class c {
    public static j<Integer> aqB = j.a("gms:common:stats:max_num_of_events", Integer.valueOf(100));

    public static final class a {
        public static j<Integer> aqC = j.a("gms:common:stats:connections:level", Integer.valueOf(d.LOG_LEVEL_OFF));
        public static j<String> aqD = j.j("gms:common:stats:connections:ignored_calling_processes", SQLiteDatabase.KeyEmpty);
        public static j<String> aqE = j.j("gms:common:stats:connections:ignored_calling_services", SQLiteDatabase.KeyEmpty);
        public static j<String> aqF = j.j("gms:common:stats:connections:ignored_target_processes", SQLiteDatabase.KeyEmpty);
        public static j<String> aqG = j.j("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
        public static j<Long> aqH = j.a("gms:common:stats:connections:time_out_duration", Long.valueOf(600000));
    }

    public static final class b {
        public static j<Integer> aqC = j.a("gms:common:stats:wakeLocks:level", Integer.valueOf(d.LOG_LEVEL_OFF));
        public static j<Long> aqH = j.a("gms:common:stats:wakelocks:time_out_duration", Long.valueOf(600000));
    }
}
