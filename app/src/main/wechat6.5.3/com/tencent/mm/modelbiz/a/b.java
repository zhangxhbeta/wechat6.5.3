package com.tencent.mm.modelbiz.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.h.h;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class b extends f<a> implements com.tencent.mm.sdk.h.j.b {
    public static final String[] cic = new String[]{f.a(a.chq, "BizChatConversation")};
    final h<a, b> cBg = new h<a, b>(this) {
        final /* synthetic */ b cDz;

        {
            this.cDz = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((a) obj).a((b) obj2);
        }
    };
    public d cie;

    public interface a {

        public enum a {
            ;

            static {
                cDA = 1;
                cDB = 2;
                cDC = 3;
                cDD = new int[]{cDA, cDB, cDC};
            }
        }

        public static class b {
            public String aZU;
            public int cDE;
            public long cDF;
            public a cDG;
        }

        void a(b bVar);
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a((a) cVar);
    }

    public b(d dVar) {
        super(dVar, a.chq, "BizChatConversation", null);
        this.cie = dVar;
        dVar.dF("BizChatConversation", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatConversation ( bizChatId )");
        dVar.dF("BizChatConversation", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatConversation ( brandUserName )");
        dVar.dF("BizChatConversation", "CREATE INDEX IF NOT EXISTS unreadCountIndex ON BizChatConversation ( unReadCount )");
        Object obj = null;
        Cursor rawQuery = dVar.rawQuery("PRAGMA table_info( BizChatConversation)", null);
        while (rawQuery.moveToNext()) {
            int columnIndex = rawQuery.getColumnIndex("name");
            if (columnIndex >= 0) {
                if ("flag".equalsIgnoreCase(rawQuery.getString(columnIndex))) {
                    obj = 1;
                    break;
                }
            }
        }
        rawQuery.close();
        if (obj == null) {
            dVar.dF("BizChatConversation", "update BizChatConversation set flag = lastMsgTime");
        }
        ak.yW();
        com.tencent.mm.model.c.wH().a(this);
    }

    protected final void finalize() {
        ak.yW();
        com.tencent.mm.model.c.wH().b(this);
    }

    public final void a(a aVar, Looper looper) {
        this.cBg.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.cBg != null) {
            this.cBg.remove(aVar);
        }
    }

    public final void a(int i, j jVar, Object obj) {
        v.i("MicroMsg.BizConversationStorage", "onNotifyChange");
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (e.hC(str) && !m.eC(str)) {
                e.v(str, true);
            }
        }
    }

    public final a T(long j) {
        c aVar = new a();
        aVar.field_bizChatId = j;
        super.b(aVar, new String[0]);
        return aVar;
    }

    public final boolean U(long j) {
        c T = T(j);
        boolean c = super.c(T, "bizChatId");
        if (c) {
            b bVar = new b();
            bVar.cDF = T.field_bizChatId;
            bVar.aZU = T.field_brandUserName;
            bVar.cDE = a.cDB;
            bVar.cDG = T;
            this.cBg.bg(bVar);
            this.cBg.Ls();
        }
        return c;
    }

    public final boolean a(a aVar) {
        v.d("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert");
        if (aVar == null) {
            v.w("MicroMsg.BizConversationStorage", "insert wrong argument");
            return false;
        }
        boolean b = super.b(aVar);
        v.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert res:%s", Boolean.valueOf(b));
        if (b) {
            b bVar = new b();
            bVar.cDF = aVar.field_bizChatId;
            bVar.aZU = aVar.field_brandUserName;
            bVar.cDE = a.cDA;
            bVar.cDG = aVar;
            this.cBg.bg(bVar);
            this.cBg.Ls();
        }
        return b;
    }

    public final boolean b(a aVar) {
        if (aVar == null) {
            v.w("MicroMsg.BizConversationStorage", "update wrong argument");
            return false;
        }
        boolean a = super.a((c) aVar);
        v.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage update res:%s", Boolean.valueOf(a));
        if (a) {
            e.g(u.DA().Z(aVar.field_bizChatId));
            b bVar = new b();
            bVar.cDF = aVar.field_bizChatId;
            bVar.aZU = aVar.field_brandUserName;
            bVar.cDE = a.cDC;
            bVar.cDG = aVar;
            this.cBg.bg(bVar);
            this.cBg.Ls();
        }
        return a;
    }

    public final Cursor hP(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from BizChatConversation");
        stringBuilder.append(" where brandUserName = '").append(str).append("'");
        stringBuilder.append(" order by flag desc , ").append("lastMsgTime desc");
        v.d("MicroMsg.BizConversationStorage", "getBizChatConversationCursor: sql:%s", stringBuilder.toString());
        return this.cie.rawQuery(stringBuilder.toString(), null);
    }

    public static void a(a aVar, int i, int i2) {
        if (aVar.field_msgCount == 0) {
            aVar.field_msgCount = ak.yW().cqY.N(aVar.field_brandUserName, aVar.field_bizChatId);
            v.i("MicroMsg.BizConversationStorage", "getMsgCount from message table");
        } else if (i > 0) {
            aVar.field_msgCount -= i;
            if (aVar.field_msgCount < 0) {
                v.e("MicroMsg.BizConversationStorage", "msg < 0 ,some path must be ignore!");
                aVar.field_msgCount = 0;
            }
        } else if (i2 > 0) {
            aVar.field_msgCount += i2;
        }
        v.i("MicroMsg.BizConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", Integer.valueOf(aVar.field_msgCount), Long.valueOf(aVar.field_bizChatId), Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final boolean V(long j) {
        a T = T(j);
        if (!(T.field_unReadCount == 0 && T.field_bizChatId == j)) {
            T.field_unReadCount = 0;
            T.field_atCount = 0;
            b(T);
        }
        return true;
    }

    public static long a(a aVar, int i, long j) {
        if (aVar == null) {
            return 0;
        }
        if (j == 0) {
            j = be.Ni();
        }
        switch (i) {
            case 2:
                return a(aVar, j) | 4611686018427387904L;
            case 3:
                return a(aVar, j) & -4611686018427387905L;
            case 4:
                return a(aVar, j) & 4611686018427387904L;
            default:
                return a(aVar, j);
        }
    }

    private static long a(a aVar, long j) {
        return (aVar.field_flag & -72057594037927936L) | (72057594037927935L & j);
    }

    public final boolean W(long j) {
        return c(T(j));
    }

    public static boolean c(a aVar) {
        if (aVar == null) {
            v.e("MicroMsg.BizConversationStorage", "isPlacedTop failed, conversation null");
            return false;
        } else if (a(aVar, 4, 0) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean X(long j) {
        T(j);
        a T = T(j);
        boolean dF = this.cie.dF("BizChatConversation", "update BizChatConversation set flag = " + a(T, 2, 0) + " where bizChatId = " + T.field_bizChatId);
        if (dF) {
            T = T(T.field_bizChatId);
            b bVar = new b();
            bVar.cDF = T.field_bizChatId;
            bVar.aZU = T.field_brandUserName;
            bVar.cDE = a.cDC;
            bVar.cDG = T;
            this.cBg.bg(bVar);
            this.cBg.Ls();
        }
        return dF;
    }

    public final boolean Y(long j) {
        a T = T(j);
        boolean dF = this.cie.dF("BizChatConversation", "update BizChatConversation set flag = " + a(T, 3, T.field_lastMsgTime) + " where bizChatId = " + T.field_bizChatId);
        if (dF) {
            T = T(T.field_bizChatId);
            b bVar = new b();
            bVar.cDF = T.field_bizChatId;
            bVar.aZU = T.field_brandUserName;
            bVar.cDE = a.cDC;
            bVar.cDG = T;
            this.cBg.bg(bVar);
            this.cBg.Ls();
        }
        return dF;
    }
}
