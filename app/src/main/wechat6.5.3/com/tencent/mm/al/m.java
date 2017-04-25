package com.tencent.mm.al;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class m {
    private String bde = (this.id + "_" + this.cUv);
    int bkU = -1;
    String cUu = SQLiteDatabase.KeyEmpty;
    public int cUv = 0;
    private int cyA = 0;
    private String cyx = SQLiteDatabase.KeyEmpty;
    private String cyy = SQLiteDatabase.KeyEmpty;
    private int cyz = 0;
    public int id = 0;
    String name = SQLiteDatabase.KeyEmpty;
    int size = 0;
    public int status = 0;
    public int version = 0;

    public final void b(Cursor cursor) {
        this.version = cursor.getInt(2);
        this.name = cursor.getString(3);
        this.size = cursor.getInt(4);
        this.cUu = cursor.getString(5);
        this.status = cursor.getInt(6);
        this.cyx = cursor.getString(8);
        this.cyy = cursor.getString(9);
        this.cUv = cursor.getInt(7);
        this.cyA = cursor.getInt(11);
        this.id = cursor.getInt(1);
        this.cyz = cursor.getInt(10);
        this.bde = cursor.getString(0);
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if ((this.bkU & 2) != 0) {
            contentValues.put("id", Integer.valueOf(this.id));
        }
        if ((this.bkU & 4) != 0) {
            contentValues.put("version", Integer.valueOf(this.version));
        }
        if ((this.bkU & 8) != 0) {
            contentValues.put("name", this.name == null ? SQLiteDatabase.KeyEmpty : this.name);
        }
        if ((this.bkU & 16) != 0) {
            contentValues.put("size", Integer.valueOf(this.size));
        }
        if ((this.bkU & 32) != 0) {
            contentValues.put("packname", HN());
        }
        if ((this.bkU & 64) != 0) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if ((this.bkU & FileUtils.S_IWUSR) != 0) {
            contentValues.put("type", Integer.valueOf(this.cUv));
        }
        if ((this.bkU & FileUtils.S_IRUSR) != 0) {
            contentValues.put("reserved1", this.cyx == null ? SQLiteDatabase.KeyEmpty : this.cyx);
        }
        if ((this.bkU & 512) != 0) {
            contentValues.put("reserved2", this.cyy == null ? SQLiteDatabase.KeyEmpty : this.cyy);
        }
        if ((this.bkU & 1024) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.cyz));
        }
        if ((this.bkU & 2048) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.cyA));
        }
        if ((this.bkU & 1) != 0) {
            contentValues.put("localId", this.id + "_" + this.cUv);
        }
        return contentValues;
    }

    public final String HN() {
        return this.cUu == null ? SQLiteDatabase.KeyEmpty : this.cUu;
    }
}
