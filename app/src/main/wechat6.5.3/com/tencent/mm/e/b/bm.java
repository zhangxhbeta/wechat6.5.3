package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class bm extends c {
    private static final int bLr = "appusername".hashCode();
    private static final int bLv = "score".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bxP = "title".hashCode();
    private boolean bLn;
    private boolean bLu;
    private boolean bxL;
    public String field_appusername;
    public int field_score;
    public String field_title;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bLr == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (bxP == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (bLv == hashCode) {
                    this.field_score = cursor.getInt(i);
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
        if (this.bxL) {
            contentValues.put("title", this.field_title);
        }
        if (this.bLu) {
            contentValues.put("score", Integer.valueOf(this.field_score));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
