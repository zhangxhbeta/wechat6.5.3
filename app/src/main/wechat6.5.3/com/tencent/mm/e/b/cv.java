package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class cv extends c {
    private static final int bBK = "conRemark".hashCode();
    private static final int bBU = "encryptUsername".hashCode();
    private static final int bTe = "contactLabels".hashCode();
    private static final int bTf = "conDescription".hashCode();
    private static final int bTg = "conPhone".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bBF = true;
    private boolean bBv = true;
    private boolean bTb = true;
    private boolean bTc = true;
    private boolean bTd = true;
    public String field_conDescription;
    public String field_conPhone;
    public String field_conRemark;
    public String field_contactLabels;
    public String field_encryptUsername;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bBU == hashCode) {
                    this.field_encryptUsername = cursor.getString(i);
                    this.bBF = true;
                } else if (bBK == hashCode) {
                    this.field_conRemark = cursor.getString(i);
                } else if (bTe == hashCode) {
                    this.field_contactLabels = cursor.getString(i);
                } else if (bTf == hashCode) {
                    this.field_conDescription = cursor.getString(i);
                } else if (bTg == hashCode) {
                    this.field_conPhone = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.field_encryptUsername == null) {
            this.field_encryptUsername = SQLiteDatabase.KeyEmpty;
        }
        if (this.bBF) {
            contentValues.put("encryptUsername", this.field_encryptUsername);
        }
        if (this.field_conRemark == null) {
            this.field_conRemark = SQLiteDatabase.KeyEmpty;
        }
        if (this.bBv) {
            contentValues.put("conRemark", this.field_conRemark);
        }
        if (this.field_contactLabels == null) {
            this.field_contactLabels = SQLiteDatabase.KeyEmpty;
        }
        if (this.bTb) {
            contentValues.put("contactLabels", this.field_contactLabels);
        }
        if (this.field_conDescription == null) {
            this.field_conDescription = SQLiteDatabase.KeyEmpty;
        }
        if (this.bTc) {
            contentValues.put("conDescription", this.field_conDescription);
        }
        if (this.field_conPhone == null) {
            this.field_conPhone = SQLiteDatabase.KeyEmpty;
        }
        if (this.bTd) {
            contentValues.put("conPhone", this.field_conPhone);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
