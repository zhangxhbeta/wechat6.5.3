package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class bj extends c {
    private static final int bKy = "championUrl".hashCode();
    private static final int bKz = "championMotto".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bzG = "username".hashCode();
    private boolean bKw = true;
    private boolean bKx = true;
    private boolean bzs = true;
    public String field_championMotto;
    public String field_championUrl;
    public String field_username;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bzG == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (bKy == hashCode) {
                    this.field_championUrl = cursor.getString(i);
                } else if (bKz == hashCode) {
                    this.field_championMotto = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bzs) {
            contentValues.put("username", this.field_username);
        }
        if (this.bKw) {
            contentValues.put("championUrl", this.field_championUrl);
        }
        if (this.bKx) {
            contentValues.put("championMotto", this.field_championMotto);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
