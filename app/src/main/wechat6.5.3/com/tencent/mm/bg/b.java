package com.tencent.mm.bg;

import android.database.Cursor;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

final class b {
    private static int index = 0;
    private static a nxw = null;
    private static long nxx = 0;
    private static int nxy = 0;
    private static boolean on = false;

    public static void i(Exception exception) {
        if (on) {
            v.e("MicroMsg.DKTest", "exception:%s", be.e((Throwable) exception));
        }
    }

    static void begin() {
        if (on) {
            nxw = new a();
            index++;
        }
    }

    private static void g(Cursor cursor) {
        if (on && cursor != null) {
            nxy = cursor.getCount();
            a aVar = new a();
            for (int i = 0; i < nxy; i++) {
                cursor.moveToPosition(i);
            }
            cursor.moveToPosition(-1);
            nxx = aVar.sn();
        }
    }

    static void a(String str, Cursor cursor, long j) {
        if (on) {
            String str2 = ("Thread:[" + Thread.currentThread().getId() + "," + Thread.currentThread().getName() + "]") + "[" + index + "][" + nxw.sn() + "]";
            if (j != 0) {
                str2 = str2 + "[INTRANS]";
            }
            if (cursor != null) {
                g(cursor);
                str2 = str2 + "[cuCnt:" + nxy + ",cuTime:" + nxx + "]";
            }
            str2 = str2 + "[" + str + "]--";
            v.v("MicroMsg.dbtest", str2 + be.bur());
        }
    }
}
