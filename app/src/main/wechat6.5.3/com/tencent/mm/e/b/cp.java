package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class cp extends c {
    private static final int bMC = "position".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bvr = "key".hashCode();
    private boolean bMu = true;
    private boolean bvq = true;
    public String field_key;
    public int field_position;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bvr == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.bvq = true;
                } else if (bMC == hashCode) {
                    this.field_position = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bvq) {
            contentValues.put("key", this.field_key);
        }
        if (this.bMu) {
            contentValues.put("position", Integer.valueOf(this.field_position));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
