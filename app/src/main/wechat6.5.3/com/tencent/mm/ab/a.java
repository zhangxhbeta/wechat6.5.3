package com.tencent.mm.ab;

import com.tencent.mmdb.database.SQLiteDatabase;

public final class a {
    int bkU = -1;
    int cHX = 0;
    long cJZ = 0;
    int cKa = 0;
    int cuT = 0;
    String cuV = SQLiteDatabase.KeyEmpty;
    String cuW = SQLiteDatabase.KeyEmpty;
    int type = 0;
    String username = SQLiteDatabase.KeyEmpty;

    public final String getUsername() {
        return this.username == null ? SQLiteDatabase.KeyEmpty : this.username;
    }

    public final String zM() {
        return this.cuV == null ? SQLiteDatabase.KeyEmpty : this.cuV;
    }
}
