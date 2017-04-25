package com.tencent.mm.plugin.search.a;

import android.database.Cursor;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsearch.FTSUtils;
import com.tencent.mm.modelsearch.j;
import com.tencent.mm.modelsearch.m;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDatabaseCorruptException;
import com.tencent.mmdb.database.SQLiteDoneException;
import com.tencent.mmdb.database.SQLiteStatement;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements m {
    private SQLiteDatabase iEk;
    private SQLiteStatement iEl;
    private SQLiteStatement iEm;

    public a(String str) {
        v.i("MicroMsg.FTS.FTSIndexDB", "Create SearchStorage: %s", new Object[]{str});
        try {
            ze(str);
        } catch (SQLiteDatabaseCorruptException e) {
            if (this.iEk != null) {
                this.iEk.close();
                this.iEk = null;
            }
            new File(str, "IndexMicroMsg.db").delete();
            SQLiteDatabaseCorruptException sQLiteDatabaseCorruptException = new SQLiteDatabaseCorruptException("Database corruption detected, reboot and rebuild completely.");
            sQLiteDatabaseCorruptException.initCause(e);
            throw sQLiteDatabaseCorruptException;
        }
    }

    private void ze(String str) {
        if (this.iEk != null) {
            v.w("MicroMsg.FTS.FTSIndexDB", "before initDB, pre DB is not close, why?");
            this.iEk.close();
        }
        String absolutePath = new File(str, "IndexMicroMsg.db").getAbsolutePath();
        long currentTimeMillis = System.currentTimeMillis();
        this.iEk = SQLiteDatabase.openOrCreateDatabase(absolutePath, null);
        absolutePath = p.rJ();
        ak.yW();
        FTSUtils.a(this.iEk, g.n((absolutePath + ((long) c.ww())).getBytes()));
        j.m(18, System.currentTimeMillis() - currentTimeMillis);
        v.i("MicroMsg.FTS.FTSIndexDB", "initDB index params %d", new Object[]{Long.valueOf(r0 - currentTimeMillis)});
        this.iEk.rawQuery("PRAGMA journal_mode=WAL;", null).close();
        this.iEk.execSQL("PRAGMA synchronous=NORMAL;");
        this.iEk.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[]{"IndexVersion"}));
        this.iEl = this.iEk.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[]{"IndexVersion"}));
        this.iEm = this.iEk.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[]{"IndexVersion"}));
        if (aP(0, 9)) {
            this.iEk.execSQL("DROP TABLE IF EXISTS IndexContent;");
            this.iEk.execSQL("DROP TABLE IF EXISTS IndexMeta;");
            v.i("MicroMsg.FTS.FTSIndexDB", "IndexTable: %s", new Object[]{aMa().toString()});
            v.i("MicroMsg.FTS.FTSIndexDB", "MetaTable: %s", new Object[]{aMb().toString()});
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(r0);
            linkedList.addAll(r1);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                v.d("MicroMsg.FTS.FTSIndexDB", "execSQL sql=%s", new Object[]{String.format("DROP TABLE IF EXISTS %s;", new Object[]{(String) it.next()})});
                this.iEk.execSQL(absolutePath);
            }
            f(0, 9);
        }
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        return this.iEk.rawQuery(str, strArr);
    }

    public final SQLiteStatement compileStatement(String str) {
        return this.iEk.compileStatement(str);
    }

    public final boolean aP(int i, int i2) {
        int i3;
        int i4;
        boolean z;
        if (!jH("IndexVersion") || this.iEl == null) {
            i3 = 0;
            i4 = 0;
        } else {
            i4 = (int) e(0, 0);
            i3 = (int) e((long) i, 0);
        }
        if ((i4 * BaseReportManager.MAX_READ_COUNT) + i3 < i2 + 9000) {
            z = true;
        } else {
            z = false;
        }
        v.i("MicroMsg.FTS.FTSIndexDB", "dbMasterVersion=%d dbVersion=%d | targetMasterVerson=%d targetVersion=%d | result=%b", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(9), Integer.valueOf(i2), Boolean.valueOf(z)});
        return z;
    }

    public final long e(long j, long j2) {
        this.iEl.bindLong(1, j);
        try {
            j2 = this.iEl.simpleQueryForLong();
        } catch (SQLiteDoneException e) {
        }
        return j2;
    }

    public final void f(long j, long j2) {
        this.iEm.bindLong(1, j);
        this.iEm.bindLong(2, j2);
        this.iEm.execute();
    }

    public final boolean jH(String str) {
        com.tencent.mmdb.Cursor rawQuery = this.iEk.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[]{str});
        boolean moveToNext = rawQuery.moveToNext();
        rawQuery.close();
        return moveToNext;
    }

    private LinkedList<String> aMa() {
        LinkedList<String> linkedList = new LinkedList();
        com.tencent.mmdb.Cursor rawQuery = this.iEk.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name LIKE ?;", new String[]{"FtsIndex%"});
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            return linkedList;
        }
        do {
            linkedList.add(rawQuery.getString(0));
        } while (rawQuery.moveToNext());
        if (rawQuery != null) {
            rawQuery.close();
        }
        return linkedList;
    }

    private LinkedList<String> aMb() {
        LinkedList<String> linkedList = new LinkedList();
        com.tencent.mmdb.Cursor rawQuery = this.iEk.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name LIKE ?;", new String[]{"FtsMeta%"});
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            return linkedList;
        }
        do {
            linkedList.add(rawQuery.getString(0));
        } while (rawQuery.moveToNext());
        if (rawQuery != null) {
            rawQuery.close();
        }
        return linkedList;
    }

    public final void execSQL(String str) {
        this.iEk.execSQL(str);
    }

    public final void execSQL(String str, Object[] objArr) {
        this.iEk.execSQL(str, objArr);
    }

    public final void close() {
        String str = "MicroMsg.FTS.FTSIndexDB";
        String str2 = "close db:%s isOpen:%b ";
        Object[] objArr = new Object[2];
        objArr[0] = this.iEk;
        objArr[1] = Boolean.valueOf(this.iEk == null ? false : this.iEk.isOpen());
        v.w(str, str2, objArr);
        if (this.iEk != null && this.iEk.isOpen()) {
            v.w("MicroMsg.FTS.FTSIndexDB", "close in trans :%b ", new Object[]{Boolean.valueOf(this.iEk.inTransaction())});
            while (this.iEk.inTransaction()) {
                this.iEk.endTransaction();
            }
            this.iEl.close();
            this.iEm.close();
            this.iEk.close();
            this.iEk = null;
        }
    }

    public final synchronized void beginTransaction() {
        if (!(this.iEk == null || this.iEk.inTransaction())) {
            this.iEk.beginTransaction();
        }
    }

    public final boolean inTransaction() {
        if (this.iEk == null || !this.iEk.inTransaction()) {
            return false;
        }
        return true;
    }

    public final synchronized void commit() {
        if (this.iEk != null && this.iEk.inTransaction()) {
            try {
                this.iEk.setTransactionSuccessful();
                this.iEk.endTransaction();
            } catch (Throwable e) {
                v.a("MicroMsg.FTS.FTSIndexDB", e, "occur error \n%s", new Object[]{e});
            }
        }
    }

    public final synchronized void rollback() {
        if (this.iEk != null && this.iEk.isOpen() && this.iEk.inTransaction()) {
            v.i("MicroMsg.FTS.FTSIndexDB", "rollback");
            try {
                this.iEk.endTransaction();
            } catch (Throwable e) {
                v.a("MicroMsg.FTS.FTSIndexDB", e, "occur error \n%s", new Object[]{e});
            }
        }
    }
}
