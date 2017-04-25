package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.bg.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class as extends j {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS  MediaDuplication  (md5 text , size int , path text , createtime long, remuxing text, duration int, status int);", "DROP INDEX IF EXISTS MediaDuplicationMD5Index ", "CREATE INDEX IF NOT EXISTS MD5Index ON MediaDuplication ( md5 )"};
    public d cie;

    protected final boolean EP() {
        return false;
    }

    public as(g gVar) {
        String string;
        int i;
        Throwable e;
        this.cie = gVar;
        String str = "MediaDuplication";
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Cursor cursor = null;
        try {
            cursor = this.cie.rawQuery("PRAGMA table_info( " + str + " )", null);
            while (cursor.moveToNext()) {
                int columnIndex = cursor.getColumnIndex("name");
                if (columnIndex >= 0) {
                    string = cursor.getString(columnIndex);
                    if ("remuxing".equalsIgnoreCase(string)) {
                        obj = 1;
                    } else if ("duration".equalsIgnoreCase(string)) {
                        obj2 = 1;
                    } else if ("status".equalsIgnoreCase(string)) {
                        obj3 = 1;
                    }
                }
            }
            ak.yW();
            long er = c.wE().er(Thread.currentThread().getId());
            if (obj == null) {
                v.i("MicroMsg.MediaCheckDuplicationStorage", "it had no [remuxing] column, alter table now");
                this.cie.dF(str, "alter table MediaDuplication add remuxing text ");
            }
            if (obj2 == null) {
                v.i("MicroMsg.MediaCheckDuplicationStorage", "it had no [duration] column, alter table now");
                this.cie.dF(str, "alter table MediaDuplication add duration int ");
            }
            if (obj3 == null) {
                v.i("MicroMsg.MediaCheckDuplicationStorage", "it had no [status] column, alter table now");
                this.cie.dF(str, "alter table MediaDuplication add status int ");
            }
            if (er > 0) {
                ak.yW();
                c.wE().es(er);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e2) {
            v.a("MicroMsg.MediaCheckDuplicationStorage", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.MediaCheckDuplicationStorage", "tryAddDBCol error: " + e2.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        string = "MediaDuplication";
        Cursor cursor2 = null;
        long j = 0;
        try {
            cursor2 = this.cie.rawQuery("SELECT count(*) from " + string, null);
            i = (cursor2 == null || !cursor2.moveToFirst()) ? 0 : cursor2.getInt(0);
            if (i >= 5000) {
                try {
                    j = (long) this.cie.delete(string, null, null);
                } catch (Exception e3) {
                    e = e3;
                    try {
                        v.a("MicroMsg.MediaCheckDuplicationStorage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        v.e("MicroMsg.MediaCheckDuplicationStorage", "check to delete MediaDuplication. error : " + e.toString());
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        v.i("MicroMsg.MediaCheckDuplicationStorage", "MediaDuplication record[%d], max record[%d], deleteRecord[%d]", Integer.valueOf(i), Integer.valueOf(5000), Long.valueOf(j));
                    } catch (Throwable th2) {
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                    }
                }
            }
            if (cursor2 != null) {
                cursor2.close();
            }
        } catch (Throwable e4) {
            Throwable th3 = e4;
            i = 0;
            e = th3;
            v.a("MicroMsg.MediaCheckDuplicationStorage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.MediaCheckDuplicationStorage", "check to delete MediaDuplication. error : " + e.toString());
            if (cursor2 != null) {
                cursor2.close();
            }
            v.i("MicroMsg.MediaCheckDuplicationStorage", "MediaDuplication record[%d], max record[%d], deleteRecord[%d]", Integer.valueOf(i), Integer.valueOf(5000), Long.valueOf(j));
        }
        v.i("MicroMsg.MediaCheckDuplicationStorage", "MediaDuplication record[%d], max record[%d], deleteRecord[%d]", Integer.valueOf(i), Integer.valueOf(5000), Long.valueOf(j));
    }

    public final boolean p(String str, int i, String str2) {
        if (be.kS(str2)) {
            v.e("MicroMsg.MediaCheckDuplicationStorage", "insert path is null");
            return false;
        }
        if (i <= 0) {
            int aQ = e.aQ(str2);
            if (aQ <= 0) {
                v.e("MicroMsg.MediaCheckDuplicationStorage", "insert path insize:%d size:%d  path:%s", Integer.valueOf(i), Integer.valueOf(aQ), str2);
                return false;
            }
            i = aQ;
        }
        if (be.kS(str)) {
            str = com.tencent.mm.a.g.aX(str2);
            if (be.kS(str)) {
                v.e("MicroMsg.MediaCheckDuplicationStorage", "insert path read md5 failed  path:%s", str2);
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("md5", str);
        contentValues.put("size", Integer.valueOf(i));
        contentValues.put("path", str2);
        contentValues.put("createtime", Long.valueOf(be.Ni()));
        contentValues.put("status", Integer.valueOf(MMGIFException.D_GIF_ERR_OPEN_FAILED));
        v.i("MicroMsg.MediaCheckDuplicationStorage", "insert Ret:%d size:%d md5:%s path:%s", Long.valueOf(this.cie.insert("MediaDuplication", SQLiteDatabase.KeyEmpty, contentValues)), Integer.valueOf(i), str, str2);
        return this.cie.insert("MediaDuplication", SQLiteDatabase.KeyEmpty, contentValues) > 0;
    }

    public final String bL(String str, int i) {
        if (be.kS(str) || i <= 0) {
            v.e("MicroMsg.MediaCheckDuplicationStorage", "check  md5:%s size:%d", str, Integer.valueOf(i));
            return SQLiteDatabase.KeyEmpty;
        }
        Cursor rawQuery = this.cie.rawQuery("select path from MediaDuplication where md5 = '" + str + "' and  size = " + i + " and status != 100", null);
        if (rawQuery == null) {
            v.e("MicroMsg.MediaCheckDuplicationStorage", "check query return null sql:%s", r1);
            return null;
        }
        String str2 = SQLiteDatabase.KeyEmpty;
        if (rawQuery.moveToNext()) {
            str2 = rawQuery.getString(0);
        }
        rawQuery.close();
        if (be.kS(str2) || e.aQ(str2) > 0) {
            return str2;
        }
        v.w("MicroMsg.MediaCheckDuplicationStorage", "check file size is zero, delete db record now. path[%s], fileSize[%d], size[%d]", str2, Integer.valueOf(e.aQ(str2)), Integer.valueOf(i));
        this.cie.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[]{str, String.valueOf(i), "100"});
        return SQLiteDatabase.KeyEmpty;
    }

    public final boolean a(String str, PString pString, PInt pInt) {
        if (be.kS(str)) {
            v.d("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but import path is null.");
            return false;
        }
        int aQ = e.aQ(str);
        if (aQ <= 0) {
            v.w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but file size is zero. path : " + str);
            return false;
        }
        String aX = com.tencent.mm.a.g.aX(str);
        if (be.kS(aX)) {
            v.w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but md5 is null. path : " + str);
            return false;
        }
        String str2 = "select remuxing, duration from MediaDuplication  where md5 = '" + aX + "' AND  size = " + aQ + " AND status = 100";
        long Nj = be.Nj();
        Cursor cursor = null;
        try {
            cursor = this.cie.rawQuery(str2, null);
            if (cursor != null && cursor.moveToFirst()) {
                pString.value = cursor.getString(0);
                pInt.value = cursor.getInt(1);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            v.a("MicroMsg.MediaCheckDuplicationStorage", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing error: " + e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        if (be.kS(pString.value)) {
            v.d("MicroMsg.MediaCheckDuplicationStorage", "it has no remuxing path.");
            return false;
        } else if (e.aQ(pString.value) <= 0) {
            v.w("MicroMsg.MediaCheckDuplicationStorage", "remuxing file size is zero, delete db record now. remuxing path : " + pString.value);
            this.cie.delete("MediaDuplication", "md5=? AND size=? AND status=?", new String[]{aX, String.valueOf(aQ), "100"});
            pString.value = null;
            return false;
        } else {
            v.i("MicroMsg.MediaCheckDuplicationStorage", "check remuxing file success. remuxing path[%s], duration [%d], cost time[%d]", pString.value, Integer.valueOf(pInt.value), Long.valueOf(be.az(Nj)));
            return true;
        }
    }
}
