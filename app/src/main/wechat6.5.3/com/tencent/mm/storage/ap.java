package com.tencent.mm.storage;

import com.tencent.mmdb.database.SQLiteDatabase;

public class ap {
    public final boolean aZw;
    private final String bld;
    private final String eSD;
    private final String name;
    private boolean nvA;
    private final String type;

    public ap() {
        this.type = SQLiteDatabase.KeyEmpty;
        this.name = SQLiteDatabase.KeyEmpty;
        this.bld = SQLiteDatabase.KeyEmpty;
        this.eSD = SQLiteDatabase.KeyEmpty;
        this.aZw = true;
    }

    public ap(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        this.type = str;
        this.name = str2;
        this.bld = str3;
        this.eSD = str4;
        this.aZw = z;
        this.nvA = z2;
    }

    public final String getType() {
        return this.type == null ? SQLiteDatabase.KeyEmpty : this.type;
    }

    public final String tT() {
        return this.bld == null ? SQLiteDatabase.KeyEmpty : this.bld;
    }

    public final String bvX() {
        return this.eSD == null ? SQLiteDatabase.KeyEmpty : this.eSD;
    }
}
