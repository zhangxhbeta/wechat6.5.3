package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class bn extends c {
    private static final int bEj = "sort".hashCode();
    private static final int bLq = "rankID".hashCode();
    private static final int bLr = "appusername".hashCode();
    private static final int bLx = "step".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bzG = "username".hashCode();
    private boolean bDJ = true;
    private boolean bLm = true;
    private boolean bLn = true;
    private boolean bLw = true;
    private boolean bzs = true;
    public String field_appusername;
    public String field_rankID;
    public int field_sort;
    public int field_step;
    public String field_username;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bLr == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (bLq == hashCode) {
                    this.field_rankID = cursor.getString(i);
                } else if (bzG == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (bLx == hashCode) {
                    this.field_step = cursor.getInt(i);
                } else if (bEj == hashCode) {
                    this.field_sort = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bLn) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.bLm) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.bzs) {
            contentValues.put("username", this.field_username);
        }
        if (this.bLw) {
            contentValues.put("step", Integer.valueOf(this.field_step));
        }
        if (this.bDJ) {
            contentValues.put("sort", Integer.valueOf(this.field_sort));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
