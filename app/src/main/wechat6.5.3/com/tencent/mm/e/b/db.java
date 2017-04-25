package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class db extends c {
    private static final int bVg = "bulletin_scene".hashCode();
    private static final int bVh = "bulletin_content".hashCode();
    private static final int bVi = "bulletin_url".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bVd = true;
    private boolean bVe = true;
    private boolean bVf = true;
    public String field_bulletin_content;
    public String field_bulletin_scene;
    public String field_bulletin_url;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bVg == hashCode) {
                    this.field_bulletin_scene = cursor.getString(i);
                    this.bVd = true;
                } else if (bVh == hashCode) {
                    this.field_bulletin_content = cursor.getString(i);
                } else if (bVi == hashCode) {
                    this.field_bulletin_url = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bVd) {
            contentValues.put("bulletin_scene", this.field_bulletin_scene);
        }
        if (this.bVe) {
            contentValues.put("bulletin_content", this.field_bulletin_content);
        }
        if (this.bVf) {
            contentValues.put("bulletin_url", this.field_bulletin_url);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
