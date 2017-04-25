package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class d {

    public interface a {
        void cG(int i);
    }

    public static int ae(Context context) {
        int i = 0;
        if (context != null) {
            try {
                i = context.getSharedPreferences("crash_status_file", 4).getInt("channel", -1);
            } catch (Throwable th) {
            }
        }
        return i;
    }

    public static int af(Context context) {
        int i = 0;
        if (context != null) {
            try {
                i = context.getSharedPreferences("crash_status_file", 4).getInt("googleplaysizelimit", 1024);
            } catch (Throwable th) {
            }
        }
        return i;
    }

    public static void d(Context context, String str, String str2) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
            String string = sharedPreferences.getString("crashlist", SQLiteDatabase.KeyEmpty);
            Editor edit = sharedPreferences.edit();
            edit.putString("crashlist", string + ";" + str + "," + str2);
            edit.commit();
        } catch (Throwable th) {
        }
    }
}
