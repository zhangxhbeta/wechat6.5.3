package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class ah extends c {
    private static final int bDu = "bakLogId".hashCode();
    private static final int bDv = "valueStr".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bDs;
    private boolean bDt;
    public int field_bakLogId;
    public String field_valueStr;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bDu == hashCode) {
                    this.field_bakLogId = cursor.getInt(i);
                } else if (bDv == hashCode) {
                    this.field_valueStr = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bDs) {
            contentValues.put("bakLogId", Integer.valueOf(this.field_bakLogId));
        }
        if (this.bDt) {
            contentValues.put("valueStr", this.field_valueStr);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
