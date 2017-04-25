package com.tencent.mm.model;

import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;

public final class ax {
    private static ap ctF = null;
    private static boolean ctG = false;
    public static int ctH = 0;

    public static void q(String str, boolean z) {
        if (!"bizflag".equals(str)) {
            return;
        }
        if (z) {
            ctH |= 1;
        } else {
            ctH &= -2;
        }
    }

    public static String zq() {
        StringBuilder stringBuilder = new StringBuilder();
        if (ctH != 0) {
            stringBuilder.append("<");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
            stringBuilder.append(ctH);
            stringBuilder.append("</");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
        }
        return stringBuilder.toString();
    }

    public static int g(at atVar) {
        if (atVar == null) {
            return 0;
        }
        int i;
        Map q = bf.q(atVar.bNo, "msgsource");
        if (q != null) {
            String str = (String) q.get(".msgsource.bizflag");
            if (!be.kS(str)) {
                i = be.getInt(str, 0);
                return i;
            }
        }
        i = 0;
        return i;
    }

    public static String zr() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(be.ma(zq()));
        if (stringBuilder.length() <= 0) {
            return null;
        }
        stringBuilder.insert(0, "<msgsource>");
        stringBuilder.append("</msgsource>");
        return stringBuilder.toString();
    }

    public static String zs() {
        ak.yW();
        String str = (String) c.vf().get(70, null);
        if (!be.kS(str)) {
            ak.yW();
            c.vf().set(70, SQLiteDatabase.KeyEmpty);
        }
        v.d("MicroMsg.MsgSourceHelper", "getMsg ccr[%s]", str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<msgsource>");
        stringBuilder.append(be.ma(str));
        if (ctH != 0) {
            stringBuilder.append("<");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
            stringBuilder.append(ctH);
            stringBuilder.append("</");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
        }
        stringBuilder.append("</msgsource>");
        return stringBuilder.toString();
    }

    public static void fR(String str) {
        v.i("MicroMsg.MsgSourceHelper", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", str, SQLiteDatabase.KeyEmpty);
    }
}
