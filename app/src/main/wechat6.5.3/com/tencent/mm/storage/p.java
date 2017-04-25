package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bg.f.a;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class p extends f<o> implements a {
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS serverChatRoomUserIndex ON chatroom ( chatroomname )"};
    public static final String[] cic = new String[]{f.a(o.chq, "chatroom")};
    public d cie;

    public final /* synthetic */ boolean a(c cVar) {
        return b((o) cVar);
    }

    public p(d dVar) {
        super(dVar, o.chq, "chatroom", btd);
        this.cie = dVar;
    }

    private static List<String> LB(String str) {
        List<String> linkedList = new LinkedList();
        if (str.equals(SQLiteDatabase.KeyEmpty)) {
            return linkedList;
        }
        String[] split = str.split(";");
        for (Object add : split) {
            linkedList.add(add);
        }
        return linkedList;
    }

    public final o LC(String str) {
        c oVar = new o();
        oVar.field_chatroomname = str;
        return super.b(oVar, "chatroomname") ? oVar : null;
    }

    public final o LD(String str) {
        c oVar = new o();
        oVar.field_chatroomname = str;
        return super.b(oVar, "chatroomname") ? oVar : oVar;
    }

    public final boolean b(o oVar) {
        if (super.a((c) oVar)) {
            Lf(oVar.field_chatroomname);
            return true;
        }
        v.w("MicroMsg.ChatroomStorage", "replace error");
        return false;
    }

    public final List<String> bvi() {
        v.d("MicroMsg.ChatroomStorage", "getAllGroupCard : select * from chatroom where chatroomname like '%@groupcard'");
        Cursor rawQuery = this.cie.rawQuery("select * from chatroom where chatroomname like '%@groupcard'", null);
        int count = rawQuery.getCount();
        String str = SQLiteDatabase.KeyEmpty;
        if (count == 0) {
            rawQuery.close();
            return null;
        }
        rawQuery.moveToFirst();
        do {
            o oVar = new o();
            oVar.b(rawQuery);
            str = str + oVar.field_chatroomname + ";";
        } while (rawQuery.moveToNext());
        rawQuery.close();
        return LB(str);
    }

    public final String LE(String str) {
        boolean z = true;
        Assert.assertTrue(str.length() > 0);
        Cursor rawQuery = this.cie.rawQuery("select memberlist from chatroom where chatroomname='" + be.lZ(str) + "'", null);
        int count = rawQuery.getCount();
        if (count > 1) {
            z = false;
        }
        Assert.assertTrue(z);
        if (count <= 0) {
            v.e("MicroMsg.ChatroomStorage", "getMemberListByChatroomName chatroomName:" + str + " getCount ==0");
            rawQuery.close();
            return null;
        }
        rawQuery.moveToFirst();
        o oVar = new o();
        oVar.b(rawQuery);
        rawQuery.close();
        return oVar.field_memberlist;
    }

    public final String er(String str) {
        boolean z = true;
        Assert.assertTrue(str.length() > 0);
        Cursor rawQuery = this.cie.rawQuery("select displayname from chatroom where chatroomname='" + be.lZ(str) + "'", null);
        int count = rawQuery.getCount();
        if (count > 1) {
            z = false;
        }
        Assert.assertTrue(z);
        if (count <= 0) {
            v.e("MicroMsg.ChatroomStorage", "getDisplayName:" + str + " getCount ==0");
            rawQuery.close();
            return null;
        }
        rawQuery.moveToFirst();
        o oVar = new o();
        oVar.b(rawQuery);
        rawQuery.close();
        return oVar.field_displayname;
    }

    public final List<String> LF(String str) {
        String LE = LE(str);
        if (LE == null) {
            return null;
        }
        return LB(LE);
    }

    public final boolean LG(String str) {
        Assert.assertTrue(str.length() > 0);
        if (this.cie.delete("chatroom", "chatroomname=?", new String[]{str}) == 0) {
            return false;
        }
        Lf(str);
        return true;
    }

    public final int a(com.tencent.mm.bg.f fVar) {
        return 0;
    }
}
