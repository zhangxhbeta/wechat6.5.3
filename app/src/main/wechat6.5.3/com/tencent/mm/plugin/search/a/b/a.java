package com.tencent.mm.plugin.search.a.b;

import android.database.Cursor;
import com.tencent.mm.modelsearch.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteException;
import com.tencent.mmdb.database.SQLiteStatement;
import java.util.List;

public final class a extends b {
    public SQLiteStatement cWX;
    private SQLiteStatement iGC;
    private SQLiteStatement iGD;
    public SQLiteStatement iGE;
    public SQLiteStatement iGF;
    private SQLiteStatement iGG;
    public SQLiteStatement iGH;
    public SQLiteStatement iGI;
    private SQLiteStatement iGJ;

    protected final void HY() {
        if (aP(-7, 1)) {
            this.cUY.f(-7, 1);
        }
        this.cUY.execSQL("CREATE TABLE IF NOT EXISTS ChatRoomMembers (chatroom TEXT, member TEXT);");
        this.cUY.execSQL("CREATE INDEX IF NOT EXISTS ChatRoomMembers_chatroom ON ChatRoomMembers(chatroom);");
        this.cUY.execSQL("CREATE INDEX IF NOT EXISTS ChatRoomMembers_member ON ChatRoomMembers(member);");
        this.cUY.execSQL("CREATE TABLE IF NOT EXISTS ContactLabels (user TEXT, label_id INTEGER);");
        this.cUY.execSQL("CREATE INDEX IF NOT EXISTS ContactLabels_user ON ContactLabels(user);");
        this.cUY.execSQL("CREATE INDEX IF NOT EXISTS ContactLabels_label ON ContactLabels(label_id);");
        this.iGD = this.cUY.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", new Object[]{Ia()}));
        this.iGC = this.cUY.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?);", new Object[]{HZ()}));
        this.iGE = this.cUY.compileStatement("INSERT INTO ChatRoomMembers (chatroom, member) VALUES (?, ?);");
        this.iGF = this.cUY.compileStatement("DELETE FROM ChatRoomMembers WHERE chatroom=? AND member=?;");
        this.iGG = this.cUY.compileStatement("DELETE FROM ChatRoomMembers WHERE chatroom=?;");
        this.iGH = this.cUY.compileStatement("INSERT INTO ContactLabels (user, label_id) VALUES (?, ?);");
        this.iGI = this.cUY.compileStatement("DELETE FROM ContactLabels WHERE user=? AND label_id=?;");
        this.iGJ = this.cUY.compileStatement("DELETE FROM ContactLabels WHERE user=?;");
        this.cWX = this.cUY.compileStatement("SELECT changes();");
    }

    protected final boolean HX() {
        super.HX();
        this.iGE.close();
        this.iGF.close();
        this.iGG.close();
        this.iGH.close();
        this.iGI.close();
        this.iGJ.close();
        return true;
    }

    public final void g(String str, List<Long> list) {
        if (list != null && !list.isEmpty()) {
            boolean inTransaction = this.cUY.inTransaction();
            if (!inTransaction) {
                this.cUY.beginTransaction();
            }
            this.iGH.bindString(1, str);
            for (Long longValue : list) {
                this.iGH.bindLong(2, longValue.longValue());
                this.iGH.execute();
            }
            if (!inTransaction) {
                this.cUY.commit();
            }
        }
    }

    public final void zf(String str) {
        this.iGJ.bindString(1, str);
        this.iGJ.execute();
    }

    public final Cursor zg(String str) {
        return this.cUY.rawQuery("SELECT DISTINCT chatroom FROM ChatRoomMembers WHERE member=?;", new String[]{str});
    }

    public final void d(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            boolean inTransaction = this.cUY.inTransaction();
            if (!inTransaction) {
                this.cUY.beginTransaction();
            }
            this.iGE.bindString(1, str);
            for (String bindString : strArr) {
                this.iGE.bindString(2, bindString);
                this.iGE.execute();
            }
            if (!inTransaction) {
                this.cUY.commit();
            }
        }
    }

    public final void zh(String str) {
        this.iGG.bindString(1, str);
        this.iGG.execute();
    }

    protected final String getTableName() {
        return "Contact";
    }

    public final String getName() {
        return "FTSContactStorage";
    }

    public final int getType() {
        return 3;
    }

    public final int getPriority() {
        return 3;
    }

    protected final String Ic() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[]{HZ()});
    }

    protected final boolean Id() {
        return aP(-7, 1);
    }

    public final void c(int i, int i2, long j, String str, long j2, String str2) {
        boolean inTransaction = this.cUY.inTransaction();
        if (!inTransaction) {
            this.cUY.beginTransaction();
        }
        try {
            this.iGD.bindString(1, str2);
            this.iGD.execute();
            this.iGC.bindLong(1, (long) i);
            this.iGC.bindLong(2, (long) i2);
            this.iGC.bindLong(3, j);
            this.iGC.bindString(4, str);
            this.iGC.bindLong(5, j2);
            this.iGC.execute();
            if (this.cUX != null) {
                this.cUX.b(i, i2, j, str, j2, str2);
            }
            if (!inTransaction) {
                this.cUY.commit();
            }
        } catch (SQLiteException e) {
            v.e("MicroMsg.FTS.FTSContactStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str, Long.valueOf(j2)}));
            String simpleQueryForString = this.cVe.simpleQueryForString();
            if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                v.e("MicroMsg.FTS.FTSContactStorage", ">> " + simpleQueryForString);
            }
            throw e;
        }
    }
}
