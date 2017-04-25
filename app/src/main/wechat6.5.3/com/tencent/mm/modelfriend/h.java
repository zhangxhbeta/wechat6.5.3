package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class h {
    String aGX = SQLiteDatabase.KeyEmpty;
    int bBZ = 0;
    public long bCb = 0;
    private String bCc = SQLiteDatabase.KeyEmpty;
    int bCi = 0;
    String bCj = SQLiteDatabase.KeyEmpty;
    String bCk = SQLiteDatabase.KeyEmpty;
    String bCl = SQLiteDatabase.KeyEmpty;
    String bLc = SQLiteDatabase.KeyEmpty;
    int bkU = -1;
    String cGV = SQLiteDatabase.KeyEmpty;
    String cGW = SQLiteDatabase.KeyEmpty;
    String cHv = SQLiteDatabase.KeyEmpty;
    int cHw = 0;
    public int status = 0;
    private int type = 0;
    String username = SQLiteDatabase.KeyEmpty;

    public final void b(Cursor cursor) {
        this.bCb = cursor.getLong(0);
        this.cHv = cursor.getString(1);
        this.cHw = cursor.getInt(2);
        this.status = cursor.getInt(3);
        this.username = cursor.getString(4);
        this.aGX = cursor.getString(5);
        this.cGV = cursor.getString(6);
        this.cGW = cursor.getString(7);
        this.bBZ = cursor.getInt(8);
        this.bCi = cursor.getInt(9);
        this.bCk = cursor.getString(10);
        this.bCl = cursor.getString(11);
        this.bCj = cursor.getString(12);
        this.bLc = cursor.getString(13);
        this.type = cursor.getInt(14);
        this.bCc = cursor.getString(15);
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if ((this.bkU & 1) != 0) {
            contentValues.put("fbid", Long.valueOf(this.bCb));
        }
        if ((this.bkU & 2) != 0) {
            contentValues.put("fbname", EQ());
        }
        if ((this.bkU & 4) != 0) {
            contentValues.put("fbimgkey", Integer.valueOf(this.cHw));
        }
        if ((this.bkU & 8) != 0) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if ((this.bkU & 16) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bkU & 32) != 0) {
            contentValues.put("nickname", EG());
        }
        if ((this.bkU & 64) != 0) {
            contentValues.put("nicknamepyinitial", this.cGV == null ? SQLiteDatabase.KeyEmpty : this.cGV);
        }
        if ((this.bkU & FileUtils.S_IWUSR) != 0) {
            contentValues.put("nicknamequanpin", this.cGW == null ? SQLiteDatabase.KeyEmpty : this.cGW);
        }
        if ((this.bkU & FileUtils.S_IRUSR) != 0) {
            contentValues.put("sex", Integer.valueOf(this.bBZ));
        }
        if ((this.bkU & 512) != 0) {
            contentValues.put("personalcard", Integer.valueOf(this.bCi));
        }
        if ((this.bkU & 1024) != 0) {
            contentValues.put("province", this.bCk == null ? SQLiteDatabase.KeyEmpty : this.bCk);
        }
        if ((this.bkU & 2048) != 0) {
            contentValues.put("city", this.bCl == null ? SQLiteDatabase.KeyEmpty : this.bCl);
        }
        if ((this.bkU & 4096) != 0) {
            contentValues.put("signature", this.bCj == null ? SQLiteDatabase.KeyEmpty : this.bCj);
        }
        if ((this.bkU & 8192) != 0) {
            contentValues.put("alias", this.bLc == null ? SQLiteDatabase.KeyEmpty : this.bLc);
        }
        if ((this.bkU & 16384) != 0) {
            contentValues.put("type", Integer.valueOf(this.type));
        }
        if ((this.bkU & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("email", this.bCc == null ? SQLiteDatabase.KeyEmpty : this.bCc);
        }
        return contentValues;
    }

    public final String EQ() {
        return this.cHv == null ? SQLiteDatabase.KeyEmpty : this.cHv;
    }

    public final String getUsername() {
        return this.username == null ? SQLiteDatabase.KeyEmpty : this.username;
    }

    public final String EG() {
        return this.aGX == null ? SQLiteDatabase.KeyEmpty : this.aGX;
    }
}
