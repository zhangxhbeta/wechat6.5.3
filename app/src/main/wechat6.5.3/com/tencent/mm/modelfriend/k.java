package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class k {
    public int bBZ = 0;
    int bCi = 0;
    String bCj = SQLiteDatabase.KeyEmpty;
    String bCk = SQLiteDatabase.KeyEmpty;
    String bCl = SQLiteDatabase.KeyEmpty;
    int bkU = -1;
    String username = SQLiteDatabase.KeyEmpty;

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if ((this.bkU & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bkU & 2) != 0) {
            contentValues.put("sex", Integer.valueOf(this.bBZ));
        }
        if ((this.bkU & 4) != 0) {
            contentValues.put("personalcard", Integer.valueOf(this.bCi));
        }
        if ((this.bkU & 8) != 0) {
            contentValues.put("province", this.bCk == null ? SQLiteDatabase.KeyEmpty : this.bCk);
        }
        if ((this.bkU & 16) != 0) {
            contentValues.put("city", this.bCl == null ? SQLiteDatabase.KeyEmpty : this.bCl);
        }
        if ((this.bkU & 32) != 0) {
            String str;
            String str2 = "signature";
            if (this.bCj == null) {
                str = SQLiteDatabase.KeyEmpty;
            } else {
                str = this.bCj;
            }
            contentValues.put(str2, str);
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? SQLiteDatabase.KeyEmpty : this.username;
    }
}
