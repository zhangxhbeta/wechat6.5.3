package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class bl extends c {
    private static final int bLq = "rankID".hashCode();
    private static final int bLr = "appusername".hashCode();
    private static final int bLs = "timestamp".hashCode();
    private static final int bLt = "liketips".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bzG = "username".hashCode();
    private boolean bLm = true;
    private boolean bLn = true;
    private boolean bLo = true;
    private boolean bLp = true;
    private boolean bzs = true;
    public String field_appusername;
    public String field_liketips;
    public String field_rankID;
    public int field_timestamp;
    public String field_username;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bLq == hashCode) {
                    this.field_rankID = cursor.getString(i);
                } else if (bLr == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (bzG == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (bLs == hashCode) {
                    this.field_timestamp = cursor.getInt(i);
                } else if (bLt == hashCode) {
                    this.field_liketips = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bLm) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.bLn) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.bzs) {
            contentValues.put("username", this.field_username);
        }
        if (this.bLo) {
            contentValues.put("timestamp", Integer.valueOf(this.field_timestamp));
        }
        if (this.field_liketips == null) {
            this.field_liketips = "";
        }
        if (this.bLp) {
            contentValues.put("liketips", this.field_liketips);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
