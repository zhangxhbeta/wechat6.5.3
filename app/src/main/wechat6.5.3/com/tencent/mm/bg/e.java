package com.tencent.mm.bg;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDatabase.Arithmetic;
import com.tencent.mmdb.database.SQLiteDatabaseConfiguration;
import com.tencent.mmdb.database.SQLiteTrace;

public final class e {
    private static SQLiteTrace nxD;
    private static SQLiteTrace nxE = new SQLiteTrace() {
        public final void onSQLExecuted(SQLiteDatabase sQLiteDatabase, String str, int i, long j) {
            if (e.nxD != null) {
                e.nxD.onSQLExecuted(sQLiteDatabase, str, i, j);
            }
        }

        public final void onDatabaseCorrupted(SQLiteDatabase sQLiteDatabase) {
            if (e.nxD != null) {
                e.nxD.onDatabaseCorrupted(sQLiteDatabase);
            }
        }
    };
    SQLiteDatabase nxA = null;
    SQLiteDatabase nxB = null;
    private boolean nxC = false;

    public static void a(SQLiteTrace sQLiteTrace) {
        nxD = sQLiteTrace;
    }

    public static e aJ(String str, boolean z) {
        e eVar = new e();
        if (str == null || str.length() == 0) {
            eVar.nxB = SQLiteDatabase.create(null);
            eVar.nxC = true;
            if (eVar.nxB == null) {
                return null;
            }
            return eVar;
        }
        if (z) {
            try {
                eVar.nxB = SQLiteDatabase.openOrCreateDatabaseInWalMode(str, null, Arithmetic.UNKNOWN, null);
            } catch (Throwable e) {
                v.e("MicroMsg.netscene.MMDataBase", "exception:%s", be.e(e));
            }
        } else {
            eVar.nxB = SQLiteDatabase.openOrCreateDatabase(str, null, 1);
        }
        eVar.nxB.setTraceCallback(nxE);
        if (eVar.nxB != null) {
            return eVar;
        }
        return null;
    }

    public final String getPath() {
        if (this.nxA != null) {
            return this.nxA.getPath();
        }
        return this.nxB.getPath();
    }

    public static e d(String str, String str2, int i, boolean z) {
        e eVar = new e();
        if (str == null || str.length() == 0) {
            if (be.kS(str2)) {
                eVar.nxA = SQLiteDatabase.openOrCreateDatabase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH, null, 1);
            } else {
                eVar.nxA = SQLiteDatabase.openOrCreateDatabase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH, str2.getBytes(), Arithmetic.AES256CBC, null, null, 1);
            }
            eVar.nxC = true;
            eVar.nxA.setTraceCallback(nxE);
            if (eVar.nxA == null) {
                return null;
            }
            return eVar;
        }
        try {
            if (be.kS(str2)) {
                eVar.nxA = SQLiteDatabase.openOrCreateDatabase(str, null, 1);
            } else {
                eVar.nxA = SQLiteDatabase.openOrCreateDatabase(str, str2.getBytes(), Arithmetic.AES256CBC, null, null, 1);
            }
            eVar.nxA.setTraceCallback(nxE);
        } catch (Throwable e) {
            v.e("MicroMsg.netscene.MMDataBase", "exception:%s", be.e(e));
        }
        if (eVar.nxA == null) {
            return null;
        }
        return eVar;
    }

    public final boolean isOpen() {
        if (this.nxA != null) {
            return this.nxA.isOpen();
        }
        if (this.nxB != null) {
            return this.nxB.isOpen();
        }
        return false;
    }

    public final void close() {
        try {
            if (this.nxA != null && this.nxA.isOpen()) {
                this.nxA.close();
                this.nxA = null;
            }
            if (this.nxB != null && this.nxB.isOpen()) {
                this.nxB.close();
                this.nxB = null;
            }
        } catch (Throwable e) {
            v.e("MicroMsg.netscene.MMDataBase", "exception:%s", be.e(e));
        }
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        if (this.nxA != null) {
            return this.nxA.rawQuery(str, strArr);
        }
        return this.nxB.rawQuery(str, strArr);
    }

    public final void execSQL(String str) {
        if (this.nxA != null) {
            this.nxA.execSQL(str);
        } else {
            this.nxB.execSQL(str);
        }
    }

    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (this.nxA != null) {
            return this.nxA.query(str, strArr, str2, strArr2, str3, str4, str5);
        }
        return this.nxB.query(str, strArr, str2, strArr2, str3, str4, str5);
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        if (this.nxA != null) {
            return this.nxA.insert(str, str2, contentValues);
        }
        return this.nxB.insert(str, str2, contentValues);
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        if (this.nxA != null) {
            return this.nxA.update(str, contentValues, str2, strArr);
        }
        return this.nxB.update(str, contentValues, str2, strArr);
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        if (this.nxA != null) {
            return this.nxA.replace(str, str2, contentValues);
        }
        return this.nxB.replace(str, str2, contentValues);
    }

    public final int delete(String str, String str2, String[] strArr) {
        if (this.nxA != null) {
            return this.nxA.delete(str, str2, strArr);
        }
        return this.nxB.delete(str, str2, strArr);
    }

    public final void beginTransaction() {
        try {
            if (this.nxA != null) {
                this.nxA.beginTransaction();
            } else {
                this.nxB.beginTransaction();
            }
        } catch (Throwable e) {
            v.a("MicroMsg.netscene.MMDataBase", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public final void endTransaction() {
        try {
            if (this.nxA != null) {
                this.nxA.setTransactionSuccessful();
                this.nxA.endTransaction();
                return;
            }
            this.nxB.setTransactionSuccessful();
            this.nxB.endTransaction();
        } catch (Throwable e) {
            v.a("MicroMsg.netscene.MMDataBase", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static boolean a(e eVar, String str) {
        if (eVar == null || str == null) {
            String str2 = "MicroMsg.netscene.MMDataBase";
            String str3 = "[arthurdan.checkTableExist] Notice!!! null == db: %b, table: %s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(eVar == null);
            objArr[1] = str;
            v.e(str2, str3, objArr);
            return false;
        }
        Cursor rawQuery = eVar.rawQuery("select tbl_name from sqlite_master  where type = \"table\" and tbl_name=\"" + str + "\"", null);
        if (rawQuery == null) {
            return false;
        }
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count > 0) {
            return true;
        }
        return false;
    }
}
