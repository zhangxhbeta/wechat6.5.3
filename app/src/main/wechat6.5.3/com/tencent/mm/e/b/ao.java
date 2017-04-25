package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class ao extends c {
    private static final int bDW = "productID".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buv = "content".hashCode();
    private boolean bDw = true;
    private boolean bua = true;
    public byte[] field_content;
    public String field_productID;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bDW == hashCode) {
                    this.field_productID = cursor.getString(i);
                    this.bDw = true;
                } else if (buv == hashCode) {
                    this.field_content = cursor.getBlob(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bDw) {
            contentValues.put("productID", this.field_productID);
        }
        if (this.bua) {
            contentValues.put("content", this.field_content);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
