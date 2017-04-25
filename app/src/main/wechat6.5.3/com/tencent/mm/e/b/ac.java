package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class ac extends c {
    private static final int bCB = "cmdbuf".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bzG = "username".hashCode();
    private boolean bCA = true;
    private boolean bzs = true;
    public byte[] field_cmdbuf;
    public String field_username;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bzG == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.bzs = true;
                } else if (bCB == hashCode) {
                    this.field_cmdbuf = cursor.getBlob(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.field_username == null) {
            this.field_username = SQLiteDatabase.KeyEmpty;
        }
        if (this.bzs) {
            contentValues.put("username", this.field_username);
        }
        if (this.bCA) {
            contentValues.put("cmdbuf", this.field_cmdbuf);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
