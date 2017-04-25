package com.tencent.pb.common.c;

import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.pb.talkroom.sdk.e;
import com.tencent.wecall.talkroom.model.f;

public final class c {
    public static int level = 0;
    private static int psO = 2;
    private static boolean psP = false;

    public static void s(boolean z, int i) {
        psO = 0;
        psP = true;
    }

    private static void A(int i, String str, String str2) {
        e bPL = f.bPL();
        if (bPL != null) {
            bPL.o(i, "MTSDK" + str, str2);
        }
    }

    public static void d(String str, Object... objArr) {
        if (psP && psO <= 1 && str != null) {
            A(1, str, " " + v(objArr));
        }
    }

    public static void h(String str, Object... objArr) {
        if (psP && psO <= 2) {
            A(2, str, " " + v(objArr));
        }
    }

    public static void i(String str, Object... objArr) {
        if (psP && psO <= 3 && str != null) {
            A(3, str, " " + v(objArr));
        }
    }

    public static void e(String str, Object... objArr) {
        if (psP && psO <= 4) {
            A(4, str, " " + v(objArr));
        }
    }

    private static String v(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        StringBuffer stringBuffer = new StringBuffer(250);
        for (Object obj : objArr) {
            if (obj != null) {
                stringBuffer.append("|");
                if (obj instanceof Throwable) {
                    stringBuffer.append(((Throwable) obj).getMessage());
                } else {
                    stringBuffer.append(obj.toString());
                }
            }
        }
        return stringBuffer.toString();
    }
}
