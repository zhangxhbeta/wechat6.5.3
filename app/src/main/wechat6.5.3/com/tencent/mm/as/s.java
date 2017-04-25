package com.tencent.mm.as;

import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class s {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS VideoPlayHistory ( filename text PRIMARY KEY, starttime int, playduration int, downloadway int );"};
    d cie;

    public s(g gVar) {
        this.cie = gVar;
    }

    public final boolean lu(String str) {
        Throwable e;
        if (be.kS(str)) {
            return false;
        }
        Cursor cursor = null;
        Cursor query;
        try {
            query = this.cie.query("VideoPlayHistory", new String[]{"filename"}, "filename=?", new String[]{be.lZ(str)}, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        if (query != null) {
                            query.close();
                        }
                        return true;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.a("MicroMsg.VideoPlayHistoryStorage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw e;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            v.a("MicroMsg.VideoPlayHistoryStorage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (query != null) {
                query.close();
            }
            return false;
        } catch (Throwable th2) {
            e = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw e;
        }
        return false;
    }

    public final boolean b(String str, PInt pInt, PInt pInt2) {
        boolean z;
        Throwable e;
        Cursor cursor = null;
        Cursor query;
        try {
            query = this.cie.query("VideoPlayHistory", new String[]{"starttime", "playduration"}, "filename=?", new String[]{be.lZ(str)}, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        pInt.value = query.getInt(query.getColumnIndex("starttime"));
                        pInt2.value = query.getInt(query.getColumnIndex("playduration"));
                        z = true;
                        if (query != null) {
                            query.close();
                        }
                        v.i("MicroMsg.VideoPlayHistoryStorage", "getPlayDuration ret : " + z + " starttime : " + pInt.value + " playduration : " + pInt2.value);
                        return z;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.a("MicroMsg.VideoPlayHistoryStorage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        if (query == null) {
                            z = false;
                        } else {
                            query.close();
                            z = false;
                        }
                        v.i("MicroMsg.VideoPlayHistoryStorage", "getPlayDuration ret : " + z + " starttime : " + pInt.value + " playduration : " + pInt2.value);
                        return z;
                    } catch (Throwable th) {
                        e = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw e;
                    }
                }
            }
            z = false;
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            v.a("MicroMsg.VideoPlayHistoryStorage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (query == null) {
                query.close();
                z = false;
            } else {
                z = false;
            }
            v.i("MicroMsg.VideoPlayHistoryStorage", "getPlayDuration ret : " + z + " starttime : " + pInt.value + " playduration : " + pInt2.value);
            return z;
        } catch (Throwable th2) {
            e = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw e;
        }
        v.i("MicroMsg.VideoPlayHistoryStorage", "getPlayDuration ret : " + z + " starttime : " + pInt.value + " playduration : " + pInt2.value);
        return z;
    }
}
