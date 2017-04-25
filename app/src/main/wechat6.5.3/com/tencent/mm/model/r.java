package com.tencent.mm.model;

import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.ax;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class r {
    public static ap fB(String str) {
        return new ap("@black.android", null, str, null, true, true);
    }

    public static ap fC(String str) {
        ak.yW();
        ax Nr = c.wN().Nr("@t.qq.com");
        if (Nr == null) {
            return null;
        }
        return new ap("@t.qq.com", null, str, null, Nr.aeX(), Nr.bxf());
    }

    public static ap H(String str, String str2) {
        ap apVar = null;
        if (str != null && str.length() > 0) {
            ak.yW();
            ax Nr = c.wN().Nr(str);
            if (Nr != null) {
                if (Nr.nwD == 1) {
                    String str3 = "@domain.android";
                    String str4 = Nr.name;
                    String Nq = Nr.nwC.Nq(SQLiteDatabase.KeyEmpty);
                    String str5 = SQLiteDatabase.KeyEmpty;
                    if (Nq != null) {
                        str5 = str5 + Nq.replace("@", SQLiteDatabase.KeyEmpty);
                    }
                    if (str2 != null) {
                        str5 = str5 + str2;
                    }
                    apVar = new ap(str3, str4, str5, Nr.nwC.Nq(SQLiteDatabase.KeyEmpty), Nr.aeX(), true);
                }
            }
        }
        return apVar;
    }
}
