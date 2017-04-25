package com.tencent.mm.u;

import android.content.ContentValues;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class f {
    int bkU = -1;
    int cyA;
    int cyr;
    int cys;
    String cyt;
    int cyu;
    int cyv;
    int cyw;
    String cyx;
    String cyy;
    int cyz;
    String username;

    public f() {
        reset();
    }

    public final void reset() {
        this.username = SQLiteDatabase.KeyEmpty;
        this.cyr = 0;
        this.cys = 0;
        this.cyt = SQLiteDatabase.KeyEmpty;
        this.cyu = 0;
        this.cyv = 0;
        this.cyw = 0;
        this.cyx = SQLiteDatabase.KeyEmpty;
        this.cyy = SQLiteDatabase.KeyEmpty;
        this.cyz = 0;
        this.cyA = 0;
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if ((this.bkU & 1) != 0) {
            contentValues.put("username", this.username == null ? SQLiteDatabase.KeyEmpty : this.username);
        }
        if ((this.bkU & 2) != 0) {
            contentValues.put("imgwidth", Integer.valueOf(this.cyr));
        }
        if ((this.bkU & 4) != 0) {
            contentValues.put("imgheigth", Integer.valueOf(this.cys));
        }
        if ((this.bkU & 8) != 0) {
            contentValues.put("imgformat", Bc());
        }
        if ((this.bkU & 16) != 0) {
            contentValues.put("totallen", Integer.valueOf(this.cyu));
        }
        if ((this.bkU & 32) != 0) {
            contentValues.put("startpos", Integer.valueOf(this.cyv));
        }
        if ((this.bkU & 64) != 0) {
            contentValues.put("headimgtype", Integer.valueOf(this.cyw));
        }
        if ((this.bkU & FileUtils.S_IWUSR) != 0) {
            contentValues.put("reserved1", this.cyx == null ? SQLiteDatabase.KeyEmpty : this.cyx);
        }
        if ((this.bkU & FileUtils.S_IRUSR) != 0) {
            contentValues.put("reserved2", this.cyy == null ? SQLiteDatabase.KeyEmpty : this.cyy);
        }
        if ((this.bkU & 512) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.cyz));
        }
        if ((this.bkU & 1024) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.cyA));
        }
        return contentValues;
    }

    public final String Bc() {
        return this.cyt == null ? SQLiteDatabase.KeyEmpty : this.cyt;
    }
}
