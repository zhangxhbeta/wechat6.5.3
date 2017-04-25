package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class cx extends c {
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buZ = "appId".hashCode();
    private static final int bxd = "openId".hashCode();
    private static final int bzG = "username".hashCode();
    private boolean buI = true;
    private boolean bwH = true;
    private boolean bzs = true;
    public String field_appId;
    public String field_openId;
    public String field_username;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bxd == hashCode) {
                    this.field_openId = cursor.getString(i);
                    this.bwH = true;
                } else if (buZ == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (bzG == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bwH) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.buI) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.bzs) {
            contentValues.put("username", this.field_username);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
