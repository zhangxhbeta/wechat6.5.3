package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class j extends c {
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bvA = "dataType".hashCode();
    private static final int bvB = "size".hashCode();
    private static final int bvr = "key".hashCode();
    private static final int bvz = "data".hashCode();
    private boolean bvq = true;
    private boolean bvw = true;
    private boolean bvx = true;
    private boolean bvy = true;
    public String field_data;
    public String field_dataType;
    public String field_key;
    public int field_size;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bvr == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.bvq = true;
                } else if (bvz == hashCode) {
                    this.field_data = cursor.getString(i);
                } else if (bvA == hashCode) {
                    this.field_dataType = cursor.getString(i);
                } else if (bvB == hashCode) {
                    this.field_size = cursor.getInt(i);
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
        if (this.bvw) {
            contentValues.put("data", this.field_data);
        }
        if (this.bvx) {
            contentValues.put("dataType", this.field_dataType);
        }
        if (this.bvy) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
