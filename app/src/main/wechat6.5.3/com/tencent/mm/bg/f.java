package com.tencent.mm.bg;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public final class f implements d {
    public static String nxG = SQLiteDatabase.KeyEmpty;
    public int field_MARK_CURSOR_CHECK_IGNORE;
    public boolean lAZ;
    public g nxF;
    public Map<String, h> nxH;
    public Queue<a> nxI;
    public e nxs;

    public interface a {
        int a(f fVar);

        String getTableName();
    }

    public final boolean buA() {
        if (this.nxs != null && this.nxs.isOpen()) {
            return false;
        }
        v.e("MicroMsg.MemoryStorage", "memory db is close [%s]", nxG);
        return true;
    }

    public final int NO(String str) {
        String str2 = null;
        if (!this.lAZ) {
            return -4;
        }
        if (this.nxF == null || this.nxF.inTransaction()) {
            v.d("MicroMsg.MemoryStorage", "copy table but diskDB inTransaction");
            return -3;
        }
        try {
            if (e.a(this.nxs, str)) {
                this.nxs.execSQL("drop table " + str);
                v.i("MicroMsg.MemoryStorage", "table %s is in Memory DB,drop! ", str);
            }
            Cursor rawQuery = this.nxF.rawQuery(" select sql from sqlite_master where tbl_name=\"" + str + "\" and type = \"table\"", null);
            if (rawQuery != null) {
                if (rawQuery.getCount() == 1) {
                    rawQuery.moveToFirst();
                    str2 = rawQuery.getString(0);
                }
                rawQuery.close();
            }
            if (str2 == null) {
                v.w("MicroMsg.MemoryStorage", "diskDB has not this table !");
                return -1;
            }
            this.nxs.execSQL(str2);
            this.nxs.execSQL("insert into " + str + " select * from old." + str);
            v.d("MicroMsg.MemoryStorage", "copy table %s success", str);
            return 0;
        } catch (Throwable e) {
            v.a("MicroMsg.MemoryStorage", e, "copy table failed with exception.\n", new Object[0]);
            return -2;
        }
    }

    public final int delete(String str, String str2, String[] strArr) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.nxH.containsKey(str));
        if (this.nxs == null || !this.nxs.isOpen()) {
            v.w("MicroMsg.MemoryStorage", "memoryDB already close delete [%s] [%s]", str, nxG);
            if (this.nxF == null || !this.nxF.isOpen()) {
                return -1;
            }
            return this.nxF.delete(str, str2, strArr);
        }
        h hVar = (h) this.nxH.get(str);
        com.tencent.mm.bg.h.a aVar = new com.tencent.mm.bg.h.a();
        aVar.nkN = 5;
        aVar.nxZ = str2;
        aVar.F(strArr);
        hVar.a(aVar);
        return this.nxs.delete(str, str2, strArr);
    }

    public final boolean dF(String str, String str2) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.nxH.containsKey(str));
        if (this.nxs == null || !this.nxs.isOpen()) {
            v.w("MicroMsg.MemoryStorage", "memoryDB already close execSQL [%s] [%s]", str, nxG);
            if (this.nxF == null || !this.nxF.isOpen()) {
                return false;
            }
            this.nxF.dF(str2, str);
            return true;
        }
        h hVar = (h) this.nxH.get(str);
        com.tencent.mm.bg.h.a aVar = new com.tencent.mm.bg.h.a();
        aVar.nkN = 1;
        aVar.nme = str2;
        hVar.a(aVar);
        this.nxs.execSQL(str2);
        return true;
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.nxH.containsKey(str));
        if (this.nxs == null || !this.nxs.isOpen()) {
            v.w("MicroMsg.MemoryStorage", "memoryDB already close insert [%s] [%s]", str, nxG);
            if (this.nxF == null || !this.nxF.isOpen()) {
                return -1;
            }
            return this.nxF.insert(str, str2, contentValues);
        }
        h hVar = (h) this.nxH.get(str);
        com.tencent.mm.bg.h.a aVar = new com.tencent.mm.bg.h.a();
        aVar.nkN = 2;
        aVar.nmc = str2;
        aVar.values = new ContentValues(contentValues);
        hVar.a(aVar);
        return this.nxs.insert(str, str2, contentValues);
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.nxH.containsKey(str));
        if (this.nxs == null || !this.nxs.isOpen()) {
            v.w("MicroMsg.MemoryStorage", "memoryDB already close replace [%s] [%s]", str, nxG);
            if (this.nxF == null || !this.nxF.isOpen()) {
                return -1;
            }
            return this.nxF.replace(str, str2, contentValues);
        }
        h hVar = (h) this.nxH.get(str);
        com.tencent.mm.bg.h.a aVar = new com.tencent.mm.bg.h.a();
        aVar.nkN = 4;
        aVar.nmc = str2;
        aVar.values = new ContentValues(contentValues);
        hVar.a(aVar);
        return this.nxs.replace(str, str2, contentValues);
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        Assert.assertTrue("Not Attach Mem Storage:" + str, this.nxH.containsKey(str));
        if (this.nxs == null || !this.nxs.isOpen()) {
            v.w("MicroMsg.MemoryStorage", "memoryDB already close update [%s] [%s]", str, nxG);
            if (this.nxF == null || !this.nxF.isOpen()) {
                return -1;
            }
            return this.nxF.update(str, contentValues, str2, strArr);
        }
        h hVar = (h) this.nxH.get(str);
        com.tencent.mm.bg.h.a aVar = new com.tencent.mm.bg.h.a();
        aVar.nkN = 3;
        aVar.nxZ = str2;
        aVar.values = new ContentValues(contentValues);
        aVar.F(strArr);
        hVar.a(aVar);
        return this.nxs.update(str, contentValues, str2, strArr);
    }

    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (this.nxs != null && this.nxs.isOpen()) {
            return this.nxs.query(str, strArr, str2, strArr2, str3, str4, str5);
        }
        v.w("MicroMsg.MemoryStorage", "memoryDB already close query [%s] [%s]", str, nxG);
        return c.bxW();
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        if (this.nxs != null && this.nxs.isOpen()) {
            return this.nxs.rawQuery(str, strArr);
        }
        v.w("MicroMsg.MemoryStorage", "memoryDB already close rawQuery [%s] [%s]", str, nxG);
        return c.bxW();
    }

    public final Cursor aH(String str, boolean z) {
        return null;
    }
}
