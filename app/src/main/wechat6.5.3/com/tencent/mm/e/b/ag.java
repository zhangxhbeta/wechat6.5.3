package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class ag extends c {
    private static final int bDr = "transferId".hashCode();
    public static final String[] btd = new String[0];
    private static final int btl = "msgId".hashCode();
    private static final int btm = "rowid".hashCode();
    private boolean bDq = true;
    private boolean bth = true;
    public long field_msgId;
    public String field_transferId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (btl == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.bth = true;
                } else if (bDr == hashCode) {
                    this.field_transferId = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bth) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.bDq) {
            contentValues.put("transferId", this.field_transferId);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
