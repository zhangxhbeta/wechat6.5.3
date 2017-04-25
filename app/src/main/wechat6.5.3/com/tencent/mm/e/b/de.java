package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class de extends c {
    private static final int bVJ = "pref_key".hashCode();
    private static final int bVK = "pref_title".hashCode();
    private static final int bVL = "pref_url".hashCode();
    private static final int bVM = "is_show".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bVF = true;
    private boolean bVG = true;
    private boolean bVH = true;
    private boolean bVI = true;
    public int field_is_show;
    public String field_pref_key;
    public String field_pref_title;
    public String field_pref_url;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bVJ == hashCode) {
                    this.field_pref_key = cursor.getString(i);
                    this.bVF = true;
                } else if (bVK == hashCode) {
                    this.field_pref_title = cursor.getString(i);
                } else if (bVL == hashCode) {
                    this.field_pref_url = cursor.getString(i);
                } else if (bVM == hashCode) {
                    this.field_is_show = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bVF) {
            contentValues.put("pref_key", this.field_pref_key);
        }
        if (this.bVG) {
            contentValues.put("pref_title", this.field_pref_title);
        }
        if (this.bVH) {
            contentValues.put("pref_url", this.field_pref_url);
        }
        if (this.bVI) {
            contentValues.put("is_show", Integer.valueOf(this.field_is_show));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
