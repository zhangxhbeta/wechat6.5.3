package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class q {
    int bkU = -1;
    public int cCe = 0;
    public int cHW = 0;
    private int cHX = 0;
    private int cuT = 0;
    private String cuV = SQLiteDatabase.KeyEmpty;
    private String cuW = SQLiteDatabase.KeyEmpty;
    public String username = SQLiteDatabase.KeyEmpty;

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if ((this.bkU & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bkU & 2) != 0) {
            contentValues.put("friendtype", Integer.valueOf(this.cHW));
        }
        if ((this.bkU & 4) != 0) {
            contentValues.put("updatetime", Integer.valueOf(this.cCe));
        }
        if ((this.bkU & 8) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.cuT));
        }
        if ((this.bkU & 16) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.cHX));
        }
        if ((this.bkU & 32) != 0) {
            contentValues.put("reserved3", this.cuV == null ? SQLiteDatabase.KeyEmpty : this.cuV);
        }
        if ((this.bkU & 64) != 0) {
            contentValues.put("reserved4", this.cuW == null ? SQLiteDatabase.KeyEmpty : this.cuW);
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? SQLiteDatabase.KeyEmpty : this.username;
    }
}
