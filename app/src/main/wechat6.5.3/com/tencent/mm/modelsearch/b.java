package com.tencent.mm.modelsearch;

import android.database.Cursor;
import com.tencent.mm.bg.c;
import com.tencent.mm.modelsearch.a.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteException;
import com.tencent.mmdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public abstract class b implements n {
    private boolean cUN;
    private boolean cUO;
    public a cUX;
    public m cUY;
    private SQLiteStatement cUZ;
    private SQLiteStatement cVa;
    private SQLiteStatement cVb;
    private SQLiteStatement cVc;
    private SQLiteStatement cVd;
    public SQLiteStatement cVe;

    public abstract void HY();

    public /* synthetic */ int compareTo(Object obj) {
        n nVar = (n) obj;
        if (getPriority() < nVar.getPriority()) {
            return -1;
        }
        return getPriority() > nVar.getPriority() ? 1 : 0;
    }

    public b() {
        v.i("MicroMsg.FTS.BaseFTSNativeStorage", "Create %s", new Object[]{getName()});
    }

    public final void create() {
        v.i("MicroMsg.FTS.BaseFTSNativeStorage", "OnCreate %s | isCreated =%b", new Object[]{getName(), Boolean.valueOf(this.cUN)});
        if (!this.cUN) {
            int i;
            if (p.Iu()) {
                this.cUY = p.Is();
                v.i("MicroMsg.FTS.BaseFTSNativeStorage", "Create Success!");
                this.cUX = (a) p.gd(1);
                v.i("MicroMsg.FTS.BaseFTSNativeStorage", "indexTableName=%s | metaTableName=%s | TableName=%s", new Object[]{Ia(), HZ(), getTableName()});
                if (this.cUY.jH(Ia()) && this.cUY.jH(r3) && !Id()) {
                    v.d("MicroMsg.FTS.BaseFTSNativeStorage", "Table Exist, Not Need To Create");
                } else {
                    v.d("MicroMsg.FTS.BaseFTSNativeStorage", "Table Not Exist, Need To Create");
                    String format = String.format("DROP TABLE IF EXISTS %s;", new Object[]{r0});
                    String format2 = String.format("DROP TABLE IF EXISTS %s;", new Object[]{r3});
                    this.cUY.execSQL(format);
                    this.cUY.execSQL(format2);
                    this.cUY.execSQL(String.format("CREATE VIRTUAL TABLE %s USING fts4(content, tokenize=mm, compress=mmenc, uncompress=mmdec);", new Object[]{r0}));
                    this.cUY.execSQL(Ic());
                    this.cUY.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_typeId ON %s(type, entity_id);", new Object[]{r3, r3}));
                    this.cUY.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_aux ON %s(aux_index);", new Object[]{r3, r3}));
                    v.d("MicroMsg.FTS.BaseFTSNativeStorage", "dropIndexTableSql=%s\ndropMetaTableSql=%s\ncreateIndexTableSql=%s\ncreateMetaTableSql=%s\ncreateIndexSql1=%s\ncreateIndexSql2=%s", new Object[]{format, format2, r6, r7, r8, r9});
                }
                this.cUZ = this.cUY.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", new Object[]{r0}));
                this.cVa = this.cUY.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?);", new Object[]{r3}));
                this.cVb = this.cUY.compileStatement(String.format("DELETE FROM %s WHERE docid=?;", new Object[]{r0}));
                this.cVc = this.cUY.compileStatement(String.format("DELETE FROM %s WHERE docid=?;", new Object[]{r3}));
                this.cVd = this.cUY.compileStatement(String.format("UPDATE %s SET status=? WHERE docid=?;", new Object[]{r3}));
                this.cVe = this.cUY.compileStatement("SELECT mm_last_error();");
                HY();
                boolean z = true;
            } else {
                v.i("MicroMsg.FTS.BaseFTSNativeStorage", "Create Fail!");
                i = 0;
            }
            if (i != 0) {
                v.i("MicroMsg.FTS.BaseFTSNativeStorage", "SetCreated");
                this.cUN = true;
            }
        }
    }

    public String getTableName() {
        return "Common";
    }

    public final void a(int i, int i2, long j, String str, long j2, String str2, boolean z) {
        boolean inTransaction = this.cUY.inTransaction();
        if (!inTransaction) {
            this.cUY.beginTransaction();
        }
        try {
            this.cUZ.bindString(1, str2);
            this.cUZ.execute();
            this.cVa.bindLong(1, (long) i);
            this.cVa.bindLong(2, (long) i2);
            this.cVa.bindLong(3, j);
            this.cVa.bindString(4, str);
            this.cVa.bindLong(5, j2);
            this.cVa.execute();
            if (z && this.cUX != null) {
                this.cUX.b(i, i2, j, str, j2, str2);
            }
            if (!inTransaction) {
                this.cUY.commit();
            }
        } catch (SQLiteException e) {
            v.e("MicroMsg.FTS.BaseFTSNativeStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str, Long.valueOf(j2)}));
            String simpleQueryForString = this.cVe.simpleQueryForString();
            if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                v.e("MicroMsg.FTS.BaseFTSNativeStorage", ">> " + simpleQueryForString);
            }
            throw e;
        }
    }

    public final void a(int[] iArr, String str) {
        this.cUX.b(iArr, str);
    }

    public final void a(int[] iArr, Long l) {
        this.cUX.a(iArr, l.longValue());
    }

    public final void f(int[] iArr) {
        this.cUX.g(iArr);
    }

    public final void a(int i, int i2, long j, String str, long j2, String str2) {
        a(i, i2, j, str, j2, str2, false);
    }

    public final void b(int[] iArr, String str) {
        List arrayList = new ArrayList(16);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + FTSUtils.i(iArr) + " AND aux_index=?;", new Object[]{HZ()});
        Cursor rawQuery = this.cUY.rawQuery(format, new String[]{str});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        N(arrayList);
    }

    public final void g(int[] iArr) {
        List arrayList = new ArrayList(2048);
        Cursor rawQuery = this.cUY.rawQuery(String.format("SELECT docid FROM %s WHERE type IN " + FTSUtils.i(iArr) + ";", new Object[]{HZ()}), null);
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        N(arrayList);
    }

    public final void a(int[] iArr, long j) {
        List arrayList = new ArrayList(16);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + FTSUtils.i(iArr) + " AND entity_id=?;", new Object[]{HZ()});
        Cursor rawQuery = this.cUY.rawQuery(format, new String[]{Long.toString(j)});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        N(arrayList);
    }

    public final void N(List<Long> list) {
        boolean inTransaction = this.cUY.inTransaction();
        if (!inTransaction) {
            this.cUY.beginTransaction();
        }
        for (Long longValue : list) {
            this.cVb.bindLong(1, longValue.longValue());
            this.cVb.execute();
        }
        for (Long longValue2 : list) {
            this.cVc.bindLong(1, longValue2.longValue());
            this.cVc.execute();
        }
        if (!inTransaction) {
            commit();
        }
    }

    public final void c(Long l) {
        boolean inTransaction = this.cUY.inTransaction();
        if (!inTransaction) {
            this.cUY.beginTransaction();
        }
        this.cVb.bindLong(1, l.longValue());
        this.cVb.execute();
        this.cVc.bindLong(1, l.longValue());
        this.cVc.execute();
        if (!inTransaction) {
            commit();
        }
    }

    private void c(List<Long> list, int i) {
        boolean inTransaction = this.cUY.inTransaction();
        if (!inTransaction) {
            this.cUY.beginTransaction();
        }
        this.cVd.bindLong(1, (long) i);
        for (Long longValue : list) {
            this.cVd.bindLong(2, longValue.longValue());
            this.cVd.execute();
        }
        if (!inTransaction) {
            this.cUY.commit();
        }
    }

    public final List<Long> a(int[] iArr, String str, int i) {
        String format = String.format("SELECT docid FROM %s WHERE aux_index=? AND type IN " + FTSUtils.i(iArr) + ";", new Object[]{HZ()});
        Cursor rawQuery = this.cUY.rawQuery(format, new String[]{str});
        List arrayList = new ArrayList(rawQuery.getCount());
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        c(arrayList, i);
        return arrayList;
    }

    public final List<q.a> c(int[] iArr, int i) {
        Cursor rawQuery = this.cUY.rawQuery(String.format("SELECT docid, type, subtype, aux_index FROM %s WHERE type IN " + FTSUtils.i(iArr) + ";", new Object[]{HZ()}), null);
        List<q.a> arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        while (rawQuery.moveToNext()) {
            q.a aVar = new q.a();
            aVar.cWQ = rawQuery.getLong(0);
            aVar.type = rawQuery.getInt(1);
            aVar.cWt = rawQuery.getInt(2);
            aVar.cWv = rawQuery.getString(3);
            arrayList.add(aVar);
            arrayList2.add(Long.valueOf(aVar.cWQ));
        }
        rawQuery.close();
        c(arrayList2, i);
        return arrayList;
    }

    public final Cursor a(String[] strArr, int[] iArr) {
        return a(strArr, iArr, null, true);
    }

    public final Cursor a(String[] strArr, int[] iArr, String str, boolean z) {
        return a(strArr, iArr, null, str, true);
    }

    public final Cursor a(String[] strArr, int[] iArr, int[] iArr2, String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder(32);
        for (String str2 : strArr) {
            stringBuilder.append('\"');
            stringBuilder.append(str2);
            stringBuilder.append("*\" ");
        }
        String stringBuilder2 = stringBuilder.toString();
        String str22 = z ? String.format(", offsets(%s)", new Object[]{Ia()}) : "";
        String str3 = str != null ? " AND aux_index = ?" : "";
        String str4 = (iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + FTSUtils.i(iArr2);
        String str5 = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + FTSUtils.i(iArr);
        return this.cUY.rawQuery(String.format("SELECT type, subtype, entity_id, aux_index, timestamp, content" + str22 + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.docid) WHERE content MATCH ?" + str5 + str3 + " AND status >= 0" + str4 + ";", new Object[]{HZ(), Ia(), HZ(), Ia()}), str != null ? new String[]{stringBuilder2, str} : new String[]{stringBuilder2});
    }

    public final Cursor a(int[] iArr, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (!z && !z2 && !z3 && !z4 && !z5) {
            return c.bxW();
        }
        if (iArr == null || iArr.length == 0) {
            return c.bxW();
        }
        StringBuilder stringBuilder = new StringBuilder(64);
        if (z) {
            stringBuilder.append("docid,");
        }
        if (z2) {
            stringBuilder.append("entity_id,");
        }
        if (z3) {
            stringBuilder.append("aux_index,");
        }
        if (z4) {
            stringBuilder.append("timestamp,");
        }
        if (z5) {
            stringBuilder.append("status,");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        String stringBuilder2 = stringBuilder.toString();
        return this.cUY.rawQuery(String.format("SELECT %s FROM %s WHERE type IN " + FTSUtils.i(iArr) + ";", new Object[]{stringBuilder2, HZ()}), null);
    }

    public final void destroy() {
        v.i("MicroMsg.FTS.BaseFTSNativeStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[]{getName(), Boolean.valueOf(this.cUO), Boolean.valueOf(this.cUN)});
        if (!this.cUO && this.cUN) {
            HX();
            v.i("MicroMsg.FTS.BaseFTSNativeStorage", "SetDestroyed");
            this.cUO = true;
        }
    }

    public boolean HX() {
        this.cUY = null;
        this.cUX = null;
        this.cUZ.close();
        this.cVa.close();
        this.cVb.close();
        this.cVc.close();
        this.cVd.close();
        this.cVe.close();
        return true;
    }

    public final String HZ() {
        return "FtsMeta" + getTableName();
    }

    public final String Ia() {
        return "FtsIndex" + getTableName();
    }

    public final void beginTransaction() {
        this.cUY.beginTransaction();
    }

    public final void commit() {
        this.cUY.commit();
    }

    public final long e(long j, long j2) {
        return this.cUY.e(j, j2);
    }

    public final void f(long j, long j2) {
        this.cUY.f(j, j2);
    }

    public final boolean aP(int i, int i2) {
        return this.cUY.aP(i, i2);
    }

    public String Ib() {
        return String.format("INSERT INTO %s(%s) VALUES ('optimize');", new Object[]{Ia(), Ia()});
    }

    public String Ic() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[]{HZ()});
    }

    public boolean Id() {
        return false;
    }

    public final long Ie() {
        Cursor rawQuery = this.cUY.rawQuery(String.format("SELECT count(*) FROM %s", new Object[]{HZ()}), null);
        long j = 0;
        if (rawQuery != null && rawQuery.moveToNext()) {
            j = rawQuery.getLong(0);
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return j;
    }

    public final long h(int[] iArr) {
        Cursor rawQuery = this.cUY.rawQuery(String.format("SELECT count(*) FROM %s WHERE type IN %s", new Object[]{HZ(), FTSUtils.i(iArr)}), null);
        long j = 0;
        if (rawQuery != null && rawQuery.moveToNext()) {
            j = rawQuery.getLong(0);
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return j;
    }
}
