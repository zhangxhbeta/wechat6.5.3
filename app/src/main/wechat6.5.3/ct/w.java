package ct;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import ct.t.a;
import java.util.Map;

public final class w extends SQLiteOpenHelper implements v {
    private static String a = SQLiteDatabase.KeyEmpty;
    private static w b;

    private w(Context context, String str) {
        super(context, str, null, 5);
        try {
            context.deleteDatabase("access.db");
        } catch (Exception e) {
        }
    }

    public static w a() {
        if (b == null) {
            a = p.b + "-access.db";
            b = new w(p.a, a);
        }
        return b;
    }

    private static void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
        } catch (SQLException e) {
        }
    }

    private synchronized boolean a(String str, a aVar, long j) {
        boolean z = true;
        synchronized (this) {
            try {
                android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
                while (true) {
                    if (!writableDatabase.isDbLockedByOtherThreads() && !writableDatabase.isDbLockedByCurrentThread()) {
                        break;
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("iplist", aVar.a());
                contentValues.put("schedule_lasttime", Long.valueOf(aVar.e));
                contentValues.put("apn_lasttime", Long.valueOf(j));
                contentValues.put("rule", aVar.b);
                int update = writableDatabase.update("access_tbl", contentValues, "apn=? and domain=?", new String[]{str, aVar.a});
                if (update == 0) {
                    contentValues.put("apn", str);
                    contentValues.put("domain", aVar.a);
                    contentValues.put("rule", aVar.b);
                    long insert = writableDatabase.insert("access_tbl", null, contentValues);
                    new StringBuilder("insert record...ret:").append(insert).append(",apnName:").append(str).append(",domain:").append(aVar.a).append(",ip:").append(aVar.a());
                    bd.b();
                    if (-1 == insert) {
                        z = false;
                    }
                } else {
                    new StringBuilder("update record...ret:").append(update).append(",apnName:").append(str).append(",domain:").append(aVar.a).append(",ip:").append(aVar.a());
                    z = false;
                    bd.b();
                }
            } catch (Exception e2) {
                z = false;
            }
        }
        return z;
    }

    private static void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
            bd.b();
        } catch (SQLException e) {
            throw e;
        }
    }

    public final synchronized t a(String str) {
        Throwable th;
        Cursor cursor;
        t tVar;
        try {
            android.database.sqlite.SQLiteDatabase readableDatabase = getReadableDatabase();
            while (true) {
                if (readableDatabase.isDbLockedByOtherThreads() || readableDatabase.isDbLockedByCurrentThread()) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                } else {
                    try {
                        break;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = null;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
            Cursor query = readableDatabase.query("access_tbl", null, "apn=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        t tVar2 = new t(str);
                        do {
                            String string = query.getString(query.getColumnIndex("domain"));
                            String string2 = query.getString(query.getColumnIndex("iplist"));
                            String string3 = query.getString(query.getColumnIndex("last_suc_ip"));
                            String string4 = query.getString(query.getColumnIndex("rule"));
                            long j = query.getLong(query.getColumnIndex("schedule_lasttime"));
                            query.getLong(query.getColumnIndex("apn_lasttime"));
                            tVar2.a(new a(string, j, string2, string4, string3));
                        } while (query.moveToNext());
                        tVar = tVar2;
                        if (query != null) {
                            query.close();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            tVar = null;
            if (query != null) {
                query.close();
            }
        } catch (Exception e2) {
            tVar = null;
        }
        return tVar;
    }

    public final synchronized void a(t tVar) {
        Throwable th;
        Cursor cursor;
        Object obj = null;
        synchronized (this) {
            if (tVar != null) {
                try {
                    Map map = tVar.b;
                    long currentTimeMillis = System.currentTimeMillis();
                    for (a a : map.values()) {
                        obj = a(tVar.a, a, currentTimeMillis) ? 1 : obj;
                    }
                    if (obj != null) {
                        try {
                            String str = SQLiteDatabase.KeyEmpty;
                            bd.c();
                            android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
                            while (true) {
                                if (writableDatabase.isDbLockedByOtherThreads() || writableDatabase.isDbLockedByCurrentThread()) {
                                    try {
                                        Thread.sleep(10);
                                    } catch (InterruptedException e) {
                                    }
                                } else {
                                    try {
                                        break;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        cursor = null;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        throw th;
                                    }
                                }
                            }
                            cursor = writableDatabase.query("access_tbl", new String[]{"apn"}, null, null, "apn", null, "apn_lasttime");
                            if (cursor != null) {
                                try {
                                    if (cursor.getCount() > b.a.b().b.c && cursor.moveToFirst()) {
                                        obj = cursor.getString(cursor.getColumnIndex("apn"));
                                        if (!TextUtils.isEmpty(obj)) {
                                            bd.c();
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (!TextUtils.isEmpty(obj)) {
                                                new StringBuilder("removeRecordIfNeeded...delete apn:").append(obj).append(", ret:").append(writableDatabase.delete("access_tbl", "apn=?", new String[]{obj}));
                                                bd.c();
                                            }
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    throw th;
                                }
                            }
                            String str2 = str;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (TextUtils.isEmpty(obj)) {
                                new StringBuilder("removeRecordIfNeeded...delete apn:").append(obj).append(", ret:").append(writableDatabase.delete("access_tbl", "apn=?", new String[]{obj}));
                                bd.c();
                            }
                        } catch (Exception e2) {
                        }
                    }
                } catch (Exception e3) {
                } catch (Throwable th4) {
                }
            }
        }
    }

    public final synchronized void a(String str, String str2, String str3) {
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
            while (true) {
                if (!writableDatabase.isDbLockedByOtherThreads() && !writableDatabase.isDbLockedByCurrentThread()) {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("last_suc_ip", str3);
            new StringBuilder("updateApnUseTime... for apn:").append(str).append(",updateRet:").append(writableDatabase.update("access_tbl", contentValues, "apn=? and domain=?", new String[]{str, str2}));
            bd.b();
        } catch (Exception e2) {
        }
    }

    public final void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
            bd.b();
        } catch (Exception e) {
            bd.d();
        }
    }

    public final void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
        } catch (SQLException e) {
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
            bd.b();
        } catch (SQLException e2) {
            throw e2;
        } catch (Exception e3) {
        }
    }

    public final void onOpen(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        try {
            int version = sQLiteDatabase.getVersion();
            if (version == 0) {
                return;
            }
            if (version < 5) {
                try {
                    a(sQLiteDatabase);
                    b(sQLiteDatabase);
                } catch (Exception e) {
                }
            } else if (version > 5) {
                try {
                    a(sQLiteDatabase);
                    b(sQLiteDatabase);
                } catch (Exception e2) {
                }
            }
        } catch (Exception e3) {
        }
    }

    public final void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
        } catch (SQLException e) {
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
            bd.b();
        } catch (SQLException e2) {
            throw e2;
        } catch (Exception e3) {
        }
    }
}
