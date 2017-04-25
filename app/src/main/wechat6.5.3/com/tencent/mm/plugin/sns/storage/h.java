package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.b.cq;
import com.tencent.mm.pluginsdk.j.q.a;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;

public final class h extends f<g> implements a {
    public static final String[] cic = new String[]{f.a(g.chq, "SnsComment")};
    public g cuX;

    public h(g gVar) {
        super(gVar, g.chq, "SnsComment", cq.btd);
        this.cuX = gVar;
    }

    public static String aUt() {
        return "select *, rowid from SnsComment";
    }

    public final int Kw() {
        int i = 0;
        Cursor rawQuery = this.cuX.rawQuery(" select count(*) from SnsComment where isRead = ? ", new String[]{"0"});
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        return i;
    }

    public final Cursor aUu() {
        String stringBuilder = new StringBuilder("select *, rowid from SnsComment where isRead = ?  order by createTime desc").toString();
        return this.cuX.rawQuery(stringBuilder, new String[]{"0"});
    }

    public final boolean a(long j, String str, int i, String str2) {
        String str3;
        if (be.kS(str2)) {
            str3 = "select count(*) from SnsComment where snsID = " + j + " and createTime = " + i + " and talker = '" + str + "'";
        } else {
            str3 = "select count(*) from SnsComment where snsID = " + j + " and clientId = '" + str2 + "'";
        }
        Cursor rawQuery = rawQuery(str3, new String[0]);
        if (rawQuery == null) {
            return false;
        }
        rawQuery.moveToFirst();
        int i2 = rawQuery.getInt(0);
        rawQuery.close();
        if (i2 > 0) {
            return true;
        }
        return false;
    }

    public final int aUv() {
        Cursor rawQuery = rawQuery(new StringBuilder("select count(*) from SnsComment where isSend = 0").toString(), new String[0]);
        if (rawQuery == null) {
            return 0;
        }
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i;
    }

    public final g d(long j, long j2, int i) {
        int i2;
        if (i == 9) {
            i2 = 2;
        } else {
            i2 = i;
        }
        if (i2 == 10) {
            i2 = 8;
        }
        Cursor rawQuery = rawQuery("select *, rowid from SnsComment where snsID = " + j + " and commentSvrID = " + j2 + " and type = " + i2, new String[0]);
        if (rawQuery == null) {
            return null;
        }
        g gVar;
        if (rawQuery.moveToFirst()) {
            gVar = new g();
            gVar.b(rawQuery);
        } else {
            gVar = null;
        }
        rawQuery.close();
        return gVar;
    }

    public final boolean cX(long j) {
        return this.cuX.dF("SnsComment", "delete from SnsComment where snsID = " + j);
    }

    public final boolean e(long j, long j2, int i) {
        int i2;
        if (i == 9) {
            i2 = 2;
        } else {
            i2 = i;
        }
        if (i2 == 10) {
            i2 = 8;
        }
        return this.cuX.dF("SnsComment", "delete from SnsComment where snsID = " + j + " and commentSvrID = " + j2 + " and type = " + i2);
    }

    public final boolean aaf() {
        return this.cuX.dF("SnsComment", " update SnsComment set isRead = 1 where isRead = 0");
    }

    public final void aUw() {
        this.cuX.NQ("SnsComment");
    }
}
