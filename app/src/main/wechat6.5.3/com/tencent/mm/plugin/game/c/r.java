package com.tencent.mm.plugin.game.c;

import android.database.Cursor;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import java.util.LinkedList;

public final class r extends f<n> {
    public static final String[] cic = new String[]{f.a(n.chq, "GameRawMessage")};

    public r(d dVar) {
        super(dVar, n.chq, "GameRawMessage", null);
    }

    public final n bX(long j) {
        n nVar = new n();
        nVar.field_msgId = j;
        return b(nVar, new String[0]) ? nVar : null;
    }

    public final LinkedList<n> a(int i, long j, int i2, int i3) {
        Object obj;
        String str;
        if (j == 0) {
            obj = "9223372036854775807";
        } else {
            String valueOf = String.valueOf(j);
        }
        if (i2 == 0) {
            str = "(isRead=1 or isRead=0) ";
        } else if (i2 == 1) {
            str = "isRead=0 ";
        } else if (i2 != 2) {
            return null;
        } else {
            str = "isRead=1 ";
        }
        String str2 = "";
        if (i != 65536) {
            str2 = "msgType=" + i + " and ";
        }
        String valueOf2 = String.valueOf(i3);
        str2 = String.format("select * from GameRawMessage where " + str2 + "msgId<%s and " + str + "order by createTime desc limit %s", new Object[]{obj, valueOf2});
        LinkedList<n> linkedList = new LinkedList();
        Cursor rawQuery = rawQuery(str2, new String[0]);
        if (rawQuery == null) {
            return linkedList;
        }
        if (rawQuery.moveToFirst()) {
            do {
                n nVar = new n();
                nVar.b(rawQuery);
                linkedList.add(nVar);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        return linkedList;
    }

    public final LinkedList<n> ary() {
        LinkedList<n> linkedList = new LinkedList();
        Cursor rawQuery = rawQuery("select * from GameRawMessage where msgType=20", new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    n nVar = new n();
                    nVar.b(rawQuery);
                    linkedList.add(nVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        return linkedList;
    }

    public final n ue(String str) {
        Cursor rawQuery = rawQuery("select * from GameRawMessage where msgType=20 and appId= \"" + str + "\" limit 1", new String[0]);
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.moveToFirst()) {
            n nVar = new n();
            nVar.b(rawQuery);
            return nVar;
        }
        rawQuery.close();
        return null;
    }

    public final boolean e(long[] jArr) {
        if (jArr.length == 0) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("msgId in (");
        for (int i = 0; i < jArr.length; i++) {
            stringBuilder.append(jArr[i]);
            if (i != jArr.length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        String stringBuilder2 = stringBuilder.toString();
        return dF("GameRawMessage", String.format("update GameRawMessage set isRead=1 where %s", new Object[]{stringBuilder2}));
    }

    public final void arz() {
        String str = "GameRawMessage";
        dF(str, "update GameRawMessage set isRead=1 where isRead=0 and " + m(2, 5, 6, 10, 11, 100) + " and isHidden = 0");
    }

    public final int arA() {
        int i = 0;
        Cursor rawQuery = rawQuery("select count(*) from GameRawMessage where " + m(2, 5, 6, 10, 11, 100) + " and isRead=0 and " + "showInMsgList = 1" + " and isHidden = 0", new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        return i;
    }

    public static String m(int... iArr) {
        String str = "" + "(";
        for (int i = 0; i < 5; i++) {
            str = str + "msgType=" + iArr[i] + " or ";
        }
        return (str + "msgType=" + iArr[5]) + ")";
    }
}
