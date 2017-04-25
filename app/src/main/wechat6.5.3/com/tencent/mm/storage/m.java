package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelbiz.a.a;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au.b;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class m extends e {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS bizchatmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT ) ", "CREATE INDEX IF NOT EXISTS  bizmessageChatIdIndex ON bizchatmessage ( bizChatId )", "CREATE INDEX IF NOT EXISTS  bizmessageSvrIdIndex ON bizchatmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  bizmessageTalkerIndex ON bizchatmessage ( talker )", "CREATE INDEX IF NOT EXISTS  bizmessageTalerStatusIndex ON bizchatmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTimeIndex ON bizchatmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTaklerTimeIndex ON bizchatmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageSendCreateTimeIndex ON bizchatmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  bizchatmessageTalkerTypeIndex ON bizchatmessage ( talker,type )"};

    public m(au auVar) {
        super(auVar);
        e.a(buZ(), "bizchatmessage");
        a(new b(16, "bizchatmessage", b.a(2500001, 3000000, 99000001, 102000000)));
    }

    public final String Lu(String str) {
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (e.hC(str)) {
            return "bizchatmessage";
        }
        return null;
    }

    private static String ef(long j) {
        return " bizChatId= " + j + " ";
    }

    public final at I(String str, long j) {
        if (be.kS(str)) {
            return null;
        }
        at atVar = new at();
        Cursor rawQuery = buZ().rawQuery("select * from " + Lv(str) + " where" + ef(j) + "order by createTime DESC limit 1", null);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            atVar.b(rawQuery);
        }
        rawQuery.close();
        return atVar;
    }

    public final List<at> h(String str, long j, int i) {
        List<at> arrayList = new ArrayList();
        Cursor rawQuery = buZ().rawQuery("SELECT * FROM " + Lv(str) + " WHERE" + ef(j) + "AND isSend = 0" + " ORDER BY createTime DESC LIMIT " + i, null);
        if (rawQuery.moveToFirst()) {
            while (!rawQuery.isAfterLast()) {
                at atVar = new at();
                atVar.b(rawQuery);
                rawQuery.moveToNext();
                if (atVar.bwm()) {
                    arrayList.add(atVar);
                }
            }
        }
        rawQuery.close();
        return arrayList;
    }

    protected final boolean a(at atVar, aw.b bVar) {
        if (atVar == null) {
            v.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:message == null");
            return false;
        }
        atVar.A(-1);
        if (bVar != null) {
            if (e.hC(atVar.field_talker)) {
                if (be.kS(bVar.ctz)) {
                    v.w("MicroMsg.BizChatMessageStorage", "EnterpriseChat msgSourceValue error: %s", atVar.bNo);
                    return false;
                }
                c cVar = new c();
                cVar.field_bizChatServId = bVar.ctz;
                cVar.field_brandUserName = atVar.field_talker;
                if (!be.kS(bVar.ctA)) {
                    cVar.field_chatVersion = be.getInt(bVar.ctA, -1);
                }
                if (!be.kS(bVar.cty)) {
                    cVar.field_chatType = be.getInt(bVar.cty, -1);
                }
                v.d("MicroMsg.BizChatMessageStorage", "bizchatId:%s,userId:%s", bVar.ctz, bVar.userId);
                cVar = u.DA().c(cVar);
                if (cVar != null) {
                    atVar.A(cVar.field_bizChatLocalId);
                    atVar.field_bizChatUserId = be.ma(bVar.userId);
                    atVar.bNc = true;
                    if (bVar.ctC.equals("1")) {
                        atVar.di(1);
                    }
                    if (!(atVar.field_isSend == 1 || bVar.userId == null)) {
                        if (bVar.userId.equals(u.DC().ii(atVar.field_talker))) {
                            atVar.di(1);
                        }
                    }
                    if (!be.kS(bVar.userId)) {
                        j jVar = new j();
                        jVar.field_userId = bVar.userId;
                        jVar.field_userName = bVar.ctB;
                        jVar.field_brandUserName = atVar.field_talker;
                        u.DC().c(jVar);
                    }
                } else {
                    v.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:bizChatInfo == null!");
                    return false;
                }
            } else if (!be.kS(bVar.ctz)) {
                v.i("MicroMsg.BizChatMessageStorage", "is EnterpriseChat but contact not ready");
                return false;
            }
        }
        return true;
    }

    public final List<at> a(String str, long j, long j2, boolean z) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.BizChatMessageStorage", new StringBuilder("getImgMessage fail, argument is invalid, limit = 10").toString());
            return null;
        }
        long Y = this.nnR.Y(str, j2);
        if (Y == 0) {
            v.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, msg is null");
            return null;
        }
        String str2;
        List<at> arrayList = new ArrayList();
        if (z) {
            str2 = "select * from " + Lv(str) + " where" + this.nnR.MF(str) + "AND " + ef(j) + "AND " + au.bwY() + " AND createTime > " + Y + "  order by createTime ASC limit 10";
        } else {
            str2 = "select * from " + Lv(str) + " where" + this.nnR.MF(str) + "AND " + ef(j) + "AND " + au.bwY() + " AND createTime < " + Y + "  order by createTime DESC limit 10";
        }
        Cursor rawQuery = buZ().rawQuery(str2, null);
        if (rawQuery.moveToFirst()) {
            while (!rawQuery.isAfterLast()) {
                at atVar = new at();
                atVar.b(rawQuery);
                rawQuery.moveToNext();
                if (z) {
                    arrayList.add(atVar);
                } else {
                    arrayList.add(0, atVar);
                }
            }
        }
        rawQuery.close();
        return arrayList;
    }

    public final Cursor J(String str, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        String Lv = Lv(str);
        Cursor rawQuery = buZ().rawQuery("select * from " + Lv + " " + this.nnR.MZ(Lv) + " where" + this.nnR.MF(str) + "AND " + ef(j) + "AND " + au.bwZ() + "  order by createTime", null);
        v.d("MicroMsg.BizChatMessageStorage", "all time: %d, sql: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Lv);
        return rawQuery;
    }

    public final int K(String str, long j) {
        v.w("MicroMsg.BizChatMessageStorage", "deleteByTalker :%s  stack:%s", str, af.btA());
        dI(Lv(str), ef(j));
        int delete = buZ().delete(Lv(str), ef(j), null);
        if (delete != 0) {
            this.nnR.Lf("delete_talker " + str);
            au.c cVar = new au.c(str, "delete", delete);
            cVar.nwx = -1;
            a(cVar);
        }
        return delete;
    }

    public final Cursor L(String str, long j) {
        return buZ().query(Lv(str), null, ef(j), null, null, null, "createTime ASC ");
    }

    public final Cursor i(String str, long j, int i) {
        v.d("MicroMsg.BizChatMessageStorage", "getBizInitCursor talker:%s, bizChatId:%s, limitCount:%s, sql:[%s]", str, Long.valueOf(j), Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM " + Lv(str) + " WHERE" + ef(j) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC");
        return buZ().rawQuery("SELECT * FROM ( SELECT * FROM " + Lv(str) + " WHERE" + ef(j) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC", null);
    }

    public final int M(String str, long j) {
        if (str == null) {
            v.w("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable talker:%s,bizChatId:%s", str, Long.valueOf(j));
            return -1;
        }
        a T = u.DB().T(j);
        if (T.field_msgCount != 0) {
            return T.field_msgCount;
        }
        v.i("MicroMsg.BizChatMessageStorage", "geBiztMsgCount contactMsgCount is 0 ,go normal %s", str);
        return N(str, j);
    }

    public final int N(String str, long j) {
        int i = 0;
        v.v("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable sql:[%s]", "SELECT COUNT(*) FROM " + Lv(str) + " WHERE " + ef(j));
        Cursor rawQuery = buZ().rawQuery(r1, null);
        if (rawQuery.moveToLast()) {
            i = rawQuery.getInt(0);
        }
        rawQuery.close();
        return i;
    }

    public final int O(String str, long j) {
        int i = 0;
        Cursor rawQuery = buZ().rawQuery("SELECT COUNT(*) FROM " + this.nnR.Na(str) + " WHERE " + ef(j) + "AND talker= '" + be.lZ(str) + "' AND " + au.bwY(), null);
        if (rawQuery.moveToLast()) {
            i = rawQuery.getInt(0);
        }
        rawQuery.close();
        return i;
    }

    public final int g(String str, long j, long j2) {
        int i = 0;
        bx ek = this.nnR.ek(j2);
        if (ek.field_msgId == 0) {
            v.e("MicroMsg.BizChatMessageStorage", "getCountEarlyThan fail, msg does not exist");
        } else {
            String Lv = Lv(str);
            Cursor rawQuery = buZ().rawQuery("SELECT COUNT(*) FROM " + Lv + " " + this.nnR.MZ(Lv) + " WHERE " + this.nnR.MF(str) + "AND " + ef(j) + "AND " + au.bwY() + " AND createTime < " + ek.field_createTime, null);
            if (rawQuery.moveToLast()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        return i;
    }

    public final long P(String str, long j) {
        String str2 = "select createTime from " + Lv(str) + " where" + ef(j) + "order by createTime DESC LIMIT 1 ";
        v.d("MicroMsg.BizChatMessageStorage", "get last message create time: " + str2);
        Cursor rawQuery = buZ().rawQuery(str2, null);
        if (rawQuery == null) {
            v.e("MicroMsg.BizChatMessageStorage", "get last message create time failed " + str);
            return -1;
        } else if (rawQuery.moveToFirst()) {
            long j2 = rawQuery.getLong(0);
            rawQuery.close();
            return j2;
        } else {
            rawQuery.close();
            return -1;
        }
    }

    public final int a(String str, long j, long j2, long j3) {
        if (j3 >= j2) {
            long j4 = j3;
            j3 = j2;
            j2 = j4;
        }
        v.d("MicroMsg.BizChatMessageStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", str, Long.valueOf(j3), Long.valueOf(j2));
        String str2 = "SELECT COUNT(msgId) FROM " + Lv(str) + " WHERE" + ef(j) + "AND createTime >= " + j3 + " AND createTime <= " + j2;
        v.d("MicroMsg.BizChatMessageStorage", "get count sql: " + str2);
        Cursor rawQuery = buZ().rawQuery(str2, null);
        if (rawQuery == null) {
            v.w("MicroMsg.BizChatMessageStorage", "get count error, cursor is null");
            return 0;
        } else if (rawQuery.moveToFirst()) {
            v.d("MicroMsg.BizChatMessageStorage", "result msg count %d", Integer.valueOf(rawQuery.getInt(0)));
            rawQuery.close();
            return rawQuery.getInt(0);
        } else {
            rawQuery.close();
            return 0;
        }
    }

    public final Cursor b(String str, long j, long j2, long j3) {
        if (j3 >= j2) {
            long j4 = j3;
            j3 = j2;
            j2 = j4;
        }
        String str2 = "SELECT * FROM " + Lv(str) + " WHERE" + ef(j) + "AND createTime >= " + j3 + " AND createTime <= " + j2 + " ORDER BY createTime ASC ";
        v.d("MicroMsg.BizChatMessageStorage", "get cursor: " + str2);
        return buZ().rawQuery(str2, null);
    }

    public final long h(String str, long j, long j2) {
        v.d("MicroMsg.BizChatMessageStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j2), Integer.valueOf(18));
        v.d("MicroMsg.BizChatMessageStorage", "get up inc msg create time sql: %s", "SELECT createTime FROM " + Lv(str) + " WHERE" + ef(j) + "AND createTime < " + j2 + " ORDER BY createTime DESC  LIMIT " + 18);
        Cursor rawQuery = buZ().rawQuery(r0, null);
        if (rawQuery == null) {
            v.w("MicroMsg.BizChatMessageStorage", "get inc msg create time error, cursor is null");
            return j2;
        } else if (rawQuery.moveToLast()) {
            v.d("MicroMsg.BizChatMessageStorage", "result msg create time %d", Long.valueOf(rawQuery.getLong(0)));
            rawQuery.close();
            return rawQuery.getLong(0);
        } else {
            rawQuery.close();
            v.w("MicroMsg.BizChatMessageStorage", "get result fail");
            return j2;
        }
    }

    public final long i(String str, long j, long j2) {
        v.d("MicroMsg.BizChatMessageStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j2), Integer.valueOf(18));
        v.d("MicroMsg.BizChatMessageStorage", "get down inc msg create time sql: %s", "SELECT createTime FROM " + Lv(str) + " WHERE" + ef(j) + "AND createTime > " + j2 + " ORDER BY createTime ASC  LIMIT " + 18);
        Cursor rawQuery = buZ().rawQuery(r0, null);
        if (rawQuery == null) {
            v.w("MicroMsg.BizChatMessageStorage", "get down inc msg create time error, cursor is null");
            return j2;
        } else if (rawQuery.moveToLast()) {
            v.d("MicroMsg.BizChatMessageStorage", "result msg create time %d", Long.valueOf(rawQuery.getLong(0)));
            rawQuery.close();
            return rawQuery.getLong(0);
        } else {
            rawQuery.close();
            v.w("MicroMsg.BizChatMessageStorage", "get result fail");
            return j2;
        }
    }
}
