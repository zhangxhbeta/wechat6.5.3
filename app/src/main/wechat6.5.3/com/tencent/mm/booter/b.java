package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class b {
    public static boolean s(Context context, String str) {
        if ((!str.equals("noop") || (f.nhZ && f.nhY)) && context.getSharedPreferences("system_config_prefs", 4).getBoolean("settings_fully_exit", true)) {
            v.i("MicroMsg.CoreServiceHelper", "fully exited, no need to start service");
            return false;
        }
        v.d("MicroMsg.CoreServiceHelper", "ensure service running, type=" + str);
        Intent intent = new Intent(context, CoreService.class);
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("START_TYPE", str);
        context.startService(intent);
        return true;
    }
}
