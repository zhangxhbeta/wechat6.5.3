package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class ad {
    int bkU = -1;
    int cIs = 0;
    int cIt = 0;
    int cIu = 0;
    int cIv = 0;
    int cIw = 0;
    int cIx = 0;
    String cIy = SQLiteDatabase.KeyEmpty;
    String cIz = SQLiteDatabase.KeyEmpty;

    public final void b(Cursor cursor) {
        this.cIs = cursor.getInt(0);
        this.cIt = cursor.getInt(1);
        this.cIu = cursor.getInt(2);
        this.cIv = cursor.getInt(3);
        this.cIw = cursor.getInt(4);
        this.cIx = cursor.getInt(5);
        this.cIy = cursor.getString(6);
        this.cIz = cursor.getString(7);
    }

    public final ContentValues Fy() {
        ContentValues contentValues = new ContentValues();
        if ((this.bkU & 1) != 0) {
            contentValues.put("grouopid", Integer.valueOf(this.cIs));
        }
        if ((this.bkU & 2) != 0) {
            contentValues.put("membernum", Integer.valueOf(this.cIt));
        }
        if ((this.bkU & 4) != 0) {
            contentValues.put("weixinnum", Integer.valueOf(this.cIu));
        }
        if ((this.bkU & 8) != 0) {
            contentValues.put("insert_time", Integer.valueOf(this.cIv));
        }
        if ((this.bkU & 16) != 0) {
            contentValues.put("lastupdate_time", Integer.valueOf(this.cIw));
        }
        if ((this.bkU & 32) != 0) {
            contentValues.put("needupdate", Integer.valueOf(this.cIx));
        }
        if ((this.bkU & 64) != 0) {
            contentValues.put("updatekey", Fz());
        }
        if ((this.bkU & FileUtils.S_IWUSR) != 0) {
            contentValues.put("groupname", FA());
        }
        return contentValues;
    }

    public final String Fz() {
        return this.cIy == null ? SQLiteDatabase.KeyEmpty : this.cIy;
    }

    public final String FA() {
        return this.cIz == null ? SQLiteDatabase.KeyEmpty : this.cIz;
    }
}
