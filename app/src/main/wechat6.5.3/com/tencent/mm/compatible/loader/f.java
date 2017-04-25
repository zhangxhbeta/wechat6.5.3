package com.tencent.mm.compatible.loader;

import android.app.Application;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class f {
    public static e a(Application application, String str) {
        try {
            e eVar = (e) aa.getContext().getClassLoader().loadClass(aa.bth() + str).newInstance();
            eVar.app = application;
            return eVar;
        } catch (Throwable e) {
            v.a("MicroMsg.ProfileFactoryImpl", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }
}
