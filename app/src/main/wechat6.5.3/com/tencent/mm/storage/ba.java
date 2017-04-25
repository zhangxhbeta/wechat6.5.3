package com.tencent.mm.storage;

import com.tencent.mm.e.b.cv;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;

public final class ba extends cv {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[5];
        aVar.bXK = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "encryptUsername";
        aVar.nmd.put("encryptUsername", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" encryptUsername TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "encryptUsername";
        aVar.bXK[1] = "conRemark";
        aVar.nmd.put("conRemark", "TEXT default '' ");
        stringBuilder.append(" conRemark TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "contactLabels";
        aVar.nmd.put("contactLabels", "TEXT default '' ");
        stringBuilder.append(" contactLabels TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "conDescription";
        aVar.nmd.put("conDescription", "TEXT default '' ");
        stringBuilder.append(" conDescription TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[4] = "conPhone";
        aVar.nmd.put("conPhone", "TEXT default '' ");
        stringBuilder.append(" conPhone TEXT default '' ");
        aVar.bXK[5] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public ba(String str) {
        this();
        this.field_conRemark = SQLiteDatabase.KeyEmpty;
        if (str == null) {
            str = SQLiteDatabase.KeyEmpty;
        }
        this.field_encryptUsername = str;
    }

    public ba(String str, String str2) {
        this();
        if (str == null) {
            str = SQLiteDatabase.KeyEmpty;
        }
        this.field_encryptUsername = str;
        if (str2 == null) {
            str2 = SQLiteDatabase.KeyEmpty;
        }
        this.field_conRemark = str2;
    }

    public ba() {
        this.field_encryptUsername = SQLiteDatabase.KeyEmpty;
        this.field_conRemark = SQLiteDatabase.KeyEmpty;
    }

    protected final Object clone() {
        return super.clone();
    }
}
