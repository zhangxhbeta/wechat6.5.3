package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class bg extends c {
    private static final int bJI = "reqType".hashCode();
    private static final int bJJ = "cache".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bJG = true;
    private boolean bJH = true;
    public byte[] field_cache;
    public String field_reqType;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bJI == hashCode) {
                    this.field_reqType = cursor.getString(i);
                    this.bJG = true;
                } else if (bJJ == hashCode) {
                    this.field_cache = cursor.getBlob(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bJG) {
            contentValues.put("reqType", this.field_reqType);
        }
        if (this.bJH) {
            contentValues.put("cache", this.field_cache);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
