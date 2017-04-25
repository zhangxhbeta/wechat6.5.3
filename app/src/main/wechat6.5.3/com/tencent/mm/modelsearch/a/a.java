package com.tencent.mm.modelsearch.a;

import android.database.Cursor;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsearch.FTSUtils;
import com.tencent.mm.modelsearch.b;
import com.tencent.mmdb.database.SQLiteStatement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a extends b {
    public SQLiteStatement cWT;
    public SQLiteStatement cWU;
    private SQLiteStatement cWV;
    private SQLiteStatement cWW;
    public SQLiteStatement cWX;

    private class a {
        String bkC;
        long cWY;
        long cWZ;
        final /* synthetic */ a cXa;
        long cvX;

        private a(a aVar) {
            this.cXa = aVar;
        }
    }

    protected final String getTableName() {
        return "TopHits";
    }

    public final String getName() {
        return "FTSTopHitsStorage";
    }

    public final int getType() {
        return 1;
    }

    public final int getPriority() {
        return 1;
    }

    protected final void HY() {
        if (aP(-4, 3)) {
            this.cUY.execSQL("DROP TABLE IF EXISTS ContactTopHits2;");
            this.cUY.f(-4, 3);
        }
        this.cUY.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_query ON %s(query);", new Object[]{HZ(), HZ()}));
        this.cUY.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_score ON %s(score);", new Object[]{HZ(), HZ()}));
        this.cUY.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_md5 ON %s(md5);", new Object[]{HZ(), HZ()}));
        this.cWT = this.cUY.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", new Object[]{Ia()}));
        this.cWU = this.cUY.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, query, score, scene, md5) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{HZ()}));
        this.cWV = this.cUY.compileStatement(String.format("UPDATE %s SET content=? WHERE docid=?", new Object[]{Ia()}));
        this.cWW = this.cUY.compileStatement(String.format("UPDATE %s SET md5=? WHERE docid=?", new Object[]{HZ()}));
        this.cWX = this.cUY.compileStatement("SELECT changes();");
    }

    public final void b(int i, int i2, long j, String str, long j2, String str2) {
        String m = g.m(str2.getBytes());
        String format = String.format("SELECT docid, query, score, scene from %s WHERE aux_index=? AND type=? AND subtype=? AND entity_id=? AND md5<>?", new Object[]{HZ()});
        Cursor rawQuery = this.cUY.rawQuery(format, new String[]{str, String.valueOf(i), String.valueOf(i2), String.valueOf(j), m});
        List linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        while (rawQuery.moveToNext()) {
            a aVar = new a();
            aVar.cWY = rawQuery.getLong(0);
            aVar.bkC = rawQuery.getString(1);
            aVar.cWZ = rawQuery.getLong(2);
            aVar.cvX = rawQuery.getLong(3);
            linkedList2.add(aVar);
            linkedList.add(Long.valueOf(aVar.cWY));
        }
        rawQuery.close();
        if (linkedList2.size() > 0) {
            boolean inTransaction = this.cUY.inTransaction();
            if (!inTransaction) {
                this.cUY.beginTransaction();
            }
            N(linkedList);
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                this.cWT.bindString(1, str2);
                this.cWT.execute();
                this.cWU.bindLong(1, (long) i);
                this.cWU.bindLong(2, (long) i2);
                this.cWU.bindLong(3, j);
                this.cWU.bindString(4, str);
                this.cWU.bindLong(5, j2);
                this.cWU.bindString(6, aVar2.bkC);
                this.cWU.bindLong(7, aVar2.cWZ);
                this.cWU.bindLong(8, aVar2.cvX);
                this.cWU.bindString(9, m);
                this.cWU.execute();
            }
            if (!inTransaction) {
                commit();
            }
        }
    }

    public final Cursor a(String str, String[] strArr, int[] iArr, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder(32);
        for (String str2 : strArr) {
            stringBuilder.append('\"');
            stringBuilder.append(str2);
            stringBuilder.append("*\" ");
        }
        String str3 = str.trim() + '%';
        String stringBuilder2 = stringBuilder.toString();
        String str22 = "query LIKE ?";
        String str4 = "AND content MATCH ?";
        String str5 = "AND type IN " + FTSUtils.i(iArr);
        String str6 = "AND status >= 0";
        String str7 = i2 > 0 ? "LIMIT " + i2 : "";
        return this.cUY.rawQuery(String.format("SELECT type, subtype, entity_id, aux_index, timestamp, content, offsets(%s) FROM %s, %s WHERE %s %s %s %s %s AND %s.docid = %s.docid ORDER BY score desc %s;", new Object[]{Ia(), Ia(), HZ(), str22, str4, str5, "AND scene=?", str6, Ia(), HZ(), str7}), new String[]{str3, stringBuilder2, String.valueOf(i)});
    }

    protected final boolean HX() {
        super.HX();
        this.cWT.close();
        this.cWU.close();
        this.cWV.close();
        this.cWW.close();
        this.cWX.close();
        return true;
    }

    protected final String Ic() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, query TEXT COLLATE NOCASE, score INT, scene INT, md5 TEXT);", new Object[]{HZ()});
    }

    public final String Ib() {
        return String.format("INSERT INTO %s(%s) VALUES ('optimize');", new Object[]{Ia(), Ia()});
    }

    protected final boolean Id() {
        return aP(-4, 3);
    }
}
