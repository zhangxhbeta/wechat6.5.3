package com.tencent.mm.compatible.util;

import android.os.Build;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class l {
    public static boolean qA() {
        if (be.ah(Build.MANUFACTURER, SQLiteDatabase.KeyEmpty).toLowerCase().indexOf("samsung".toLowerCase()) >= 0) {
            return true;
        }
        return false;
    }
}
