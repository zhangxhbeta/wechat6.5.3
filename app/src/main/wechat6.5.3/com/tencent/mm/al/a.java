package com.tencent.mm.al;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class a {
    int bkU = -1;
    public int cTU = 0;
    private int cyA = 0;
    private String cyx = SQLiteDatabase.KeyEmpty;
    private String cyy = SQLiteDatabase.KeyEmpty;
    private int cyz = 0;
    private String path = SQLiteDatabase.KeyEmpty;
    public String username = SQLiteDatabase.KeyEmpty;

    public final void b(Cursor cursor) {
        this.username = cursor.getString(0);
        this.cTU = cursor.getInt(1);
        this.path = cursor.getString(2);
        this.cyx = cursor.getString(3);
        this.cyy = cursor.getString(4);
        this.cyz = cursor.getInt(5);
        this.cyA = cursor.getInt(6);
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if ((this.bkU & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bkU & 2) != 0) {
            contentValues.put("bgflag", Integer.valueOf(this.cTU));
        }
        if ((this.bkU & 4) != 0) {
            contentValues.put("path", this.path == null ? SQLiteDatabase.KeyEmpty : this.path);
        }
        if ((this.bkU & 8) != 0) {
            contentValues.put("reserved1", this.cyx == null ? SQLiteDatabase.KeyEmpty : this.cyx);
        }
        if ((this.bkU & 16) != 0) {
            contentValues.put("reserved2", this.cyy == null ? SQLiteDatabase.KeyEmpty : this.cyy);
        }
        if ((this.bkU & 32) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.cyz));
        }
        if ((this.bkU & 64) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.cyA));
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? SQLiteDatabase.KeyEmpty : this.username;
    }
}
