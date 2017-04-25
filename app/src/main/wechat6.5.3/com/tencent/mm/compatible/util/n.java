package com.tencent.mm.compatible.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class n {
    public static String dw(String str) {
        if (str == null || p.ceJ.cdB == 2 || p.ceJ.cdM == 1) {
            return str;
        }
        if (p.ceJ.cdB == 1) {
            if (str.toString().contains("\n")) {
                return str.toString().replace("\n", " ");
            }
            return str;
        } else if (VERSION.SDK_INT == 16 && str.toString().contains("\n") && be.ah(Build.MANUFACTURER, SQLiteDatabase.KeyEmpty).toLowerCase().indexOf("meizu".toLowerCase()) < 0) {
            return str.toString().replace("\n", " ");
        } else {
            return str;
        }
    }
}
